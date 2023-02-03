import React from 'react';
import Box from '@material-ui/core/Box';
import Drawer from '@material-ui/core/Drawer';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import CircularProgress from '@material-ui/core/CircularProgress';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles({
  buttons: {
    margin: '8pt',
  },
  contents: {
    margin: '8pt',
  },
  progress: {
    paddingTop: '18pt',
  },
});

function App() {
	const [drawerOpen, setDrawerOpen] = React.useState(false);
	const [edited, setEdited] = React.useState(["", "", ""]);
	const [items, setItems] = React.useState([]);
	const [sackSize, setSackSize] = React.useState(15);
	const [result, setResult] = React.useState(null);
	const [progress, setProgress] = React.useState(0);

	const classes = useStyles();

	const closeDrawer = (event) => {
		setDrawerOpen(false);
	}
	const openDrawer = (event) => {
		setEdited(["name " + (items.length+1), items.length, items.length%3+1]);
		setDrawerOpen(true);
	}
	const setValues = (event) => {
		closeDrawer(null);
		let ni = [...items];
		ni.push({name: "item " + edited[0], value: edited[1], weight: edited[2]});
		setItems(ni);
	}
	const optimize = (event) => {
		setResult(null);
		setProgress(0);
		var filler = new Worker('knapSackOptimizer.js');
		// send message to the worker
		filler.postMessage({items: items, sackSize: sackSize});
		// receive results from the worker
		filler.onmessage = function(message) {
			if (message.data.progress) {
				setProgress(message.data.progress);
			}
			if (message.data.result) {
				setResult(message.data.result);
			}
		}
	}
	
	let resultContent = <Typography className={classes.contents}>...</Typography>
	if (result !== null)
		resultContent = result.map((item, index) => <Box m={1} key={"item_" + index}>{item.name}, value: {item.value}, weight: {item.weight}</Box>);
	
	return (
		<Box width={1} height={1}>
			<Drawer open={drawerOpen} onClose={closeDrawer} variant="temporary">
				<TextField
					label="Name"
					className={classes.buttons}
					value={edited[0]}
					onChange={(event) => {setEdited([event.target.value, edited[1], edited[2]])}}
				/>
				<TextField
					label="Value"
					className={classes.buttons}
					value={edited[1]}
					onChange={(event) => {setEdited([edited[0], event.target.value, edited[2]])}}
				/>
				<TextField
					label="Weight"
					className={classes.buttons}
					value={edited[2]}
					onChange={(event) => {setEdited([edited[0], edited[1], event.target.value])}}
				/>
				<Button 
					className={classes.buttons}
					onClick={setValues}>
						Add
				</Button>
			</Drawer>
			
			<Typography className={classes.contents}>Knap sack filler</Typography>
			<Button 
				variant="outlined" 
				color="primary" 
				onClick={openDrawer}
				className={classes.buttons}
			>
					Add new item
			</Button>
			
			<Typography className={classes.contents}>Items to consider into sack</Typography>
			<Box m={1}>
				{
					items.map((item, index) => <Box key={"sackItem_" + index}>{item.name}, value:{item.value}, weight:{item.weight}</Box>)
				}
			</Box>
			<Typography className={classes.contents}>Sack size</Typography>
			<Box m={1}>
				<TextField
					label="Sack size"
					value={sackSize}
					onChange={(event) => {setSackSize(event.target.value)}}
				/>
			</Box>
			<Box m={1}>
				<Button 
					variant="outlined" 
					color="primary" 
					onClick={optimize}
					className={classes.buttons}
				>
					Fill sack
				</Button>
				<CircularProgress 
					variant="determinate" 
					value={Math.round(progress*100)} 
					className={classes.progress}
				/>
			</Box>
			<Typography className={classes.contents}>Items added to the sack</Typography>
			{resultContent}
		</Box>
	);
}

export default App;
