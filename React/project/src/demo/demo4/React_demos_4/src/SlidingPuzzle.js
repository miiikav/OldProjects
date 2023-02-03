import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import SlidingBlock from './SlidingBlock';
import UndoIcon from '@material-ui/icons/Undo';
import RedoIcon from '@material-ui/icons/Redo';
import IconButton from '@material-ui/core/IconButton';
import info from './info.json';

const EMPTY_PIECE = 6;

const findEmpty = (game) => {
	for (let i = 0; i < game.length; i++) {
		if (game[i] === EMPTY_PIECE)
			return i;
	}
}

function App() {
	// game variable maps board index to the block identities
	const [game, setGame] = React.useState([2, 1, 0, 8, 5, 4, EMPTY_PIECE, 7, 3]);
	// these two stacks contain arrays of game values to enable undo and redo
	const [undoStack, setUndoStack] = React.useState([]);
	const [redoStack, setRedoStack] = React.useState([]);
	// index of empty block. Note this initial value must match the index of EMPTY_PIECE in initial game value.
	const [empty, setEmpty] = React.useState(findEmpty(game)); 
	
	const makeAMove = (event, pieceIndex) => {
		// check if one of the neighbours of the clicked block is the emtpy block
		let nextToEmpty = (Math.abs((empty%3)-(pieceIndex%3))+Math.abs((Math.floor(empty/3))-(Math.floor(pieceIndex/3)))) === 1;
		// if so, swap 
		if (nextToEmpty) {
			// add current game state to undo stack
			setUndoStack(undoStack.concat([game]));
			// clear redo stack
			setRedoStack([]);
			
			let ng = [...game]; // create a copy so that React understands we are setting a new value to game
			ng[pieceIndex] = game[empty];
			ng[empty] = game[pieceIndex];
			setGame(ng);
			setEmpty(pieceIndex);
		}
	}
	
	const undo = (event) => {
		setEmpty(findEmpty(undoStack[undoStack.length-1]));
		setRedoStack(redoStack.concat([game]));
		setGame(undoStack[undoStack.length-1]);
		setUndoStack(undoStack.slice(0, undoStack.length-1));
	}
	const redo = (event) => {
		setEmpty(findEmpty(redoStack[redoStack.length-1]));
		setUndoStack(undoStack.concat([game]));
		setGame(redoStack[redoStack.length-1]);
		setRedoStack(redoStack.slice(0, redoStack.length-1));
	}
	
	// build a list of image file names for each of the 9 blocks, the image files are in public folder
	const imageRefs = [0, 1, 2, 3, 4, 5, 6, 7, 8].map((item, index) => {
			let x = item%3+1;
			let y = Math.floor(item/3+1);
			return process.env.PUBLIC_URL + '/GuineaFowl' + x + y+ '.jpg'
		}
	)
	
	// build block components to a list which is placed into UI in return statement
	const blocks = [];
	for (let x = 0; x < 3; x++) {
		for (let y = 0; y < 3; y++) {
			blocks.push(<SlidingBlock key={"sb_" + (x+3*y)} imageSrc={imageRefs[game[x+3*y]]} x={x} y={y} onClick={makeAMove} emptyBlock={game[x+3*y]===EMPTY_PIECE}/> );
		}
	}
	
	return (
		<Box>
			<Box style={{width: 400, height: 400}}>
				{blocks}
			</Box>
			
			<Box>
				<IconButton disabled={undoStack.length === 0} onClick={undo}>
					<UndoIcon/>
				</IconButton>
				<IconButton disabled={redoStack.length === 0} onClick={redo}>
					<RedoIcon/>
				</IconButton>
			</Box>
			
			<Typography variant="caption">
				{info.attribution}
			</Typography>
		</Box>
	);
}

export default App;
