import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';

function App() {
	const [number1, setNumber1] = React.useState("");
	
	const onButton = (key) => {
		if (typeof key === "number") {
			setNumber1(number1 + key);
			history = history.slice(0, historyStep + 1);
			const pos = {
				num: key
			};
			history = history.concat([pos]);
			historyStep += 1;
			React.state=({
				num: pos
			})
		} else {
			if (key === "c") {
				setNumber1("");
			}
			else if (key === "handleUndo") {
				if (historyStep === 0) {
				  return;
				}
				historyStep -= 1;
				const previous = history[historyStep];
				React.state=({
					num: previous
				});
			}
			else if (key === "handleRedo") {
				if (historyStep === history.length - 1) {
				  return;
				}
				historyStep += 1;
				const next = history[historyStep];
				React.state=({
					num: next
				});
			}
		}
	}
	let history = [
	  {
		num: 0
	  }
	];
	let historyStep = 0;
		React.state = {
			num: history[0]
	};
	return (
		<Box>
			<Paper style={{width: 400, textAlign: 'center',}}>
				<Box><TextField id={"number1"} disabled={true} variant="outlined" fullWidth value={number1} /></Box>
				<Box>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton(1)}}>1</Button>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton(2)}}>2</Button>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton(3)}}>3</Button>
				</Box>
				<Box>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton("handleUndo")}}>undo</Button>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton("handleRedo")}}>redo</Button>
					<Button variant="contained" id={"4"} onClick={(e) => {onButton("c")}}>reset</Button>
				</Box>
			</Paper>
		</Box>
	);
}

export default App;
