import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';

function App() {
	const [click, setClick] = React.useState("");
	const [move, setMove] = React.useState("");
	const [wheel, setWheel] = React.useState("");
	const updateClick = (event) => {
		setClick("button 1");
	}
	const updateMove = (e) => {
		setMove({ x: e.screenX, y: e.screenY });
		//setMove("moved");
	}
		const updateWheel = (event) => {
		setWheel("wheel");
	}
    //setBinary( {disabled: !check.disabled} )
  return (
		<div>
			<Box>
				<Box>
					<TextField id="click" label="Mouse was clicked:" disabled={true} value={click} onMouseDown={updateClick}/>
				</Box>
				<Box>
					<TextField id="move" label="Mouse was moved:" disabled={true} value={move} onMouseMove={updateMove.bind(this)}/>
				</Box>
				<Box>
					<TextField id="wheel" label="Mouse wheel event:" disabled={true} value={wheel} onWheel={updateWheel.bind(this)}/>
				</Box>
			</Box>
		</div>
  );
}

export default App;
