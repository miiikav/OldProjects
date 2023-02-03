import React from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles({
  buttons: {
    margin: '8pt',
  },
  contents: {
    margin: '8pt',
  },
});

function App() {
	const [fromNumber, setFromNumber] = React.useState(3);
	const [toNumber, setToNumber] = React.useState(100);
	const [results, setResults] = React.useState([]);
	const [finderStarted, setFinderStarted] = React.useState(false);
	
	const classes = useStyles();
	
	const findPrimes = (event) => {
		setResults(["starting"]);
		let fndr = new Worker('primesFinder.js');
		setFinderStarted(true);
		// receive results from the worker
		fndr.onmessage = (message) => {
			if (message.data.prime) {
				if (message.data.prime <= toNumber) {
					setResults([message.data.prime]);
				} else {
					if (fndr)
						fndr.postMessage({stop: true});
				}
			}
			if (message.data.primes) {
				setFinderStarted(false);
				setResults(message.data.primes);
			}
		};
		// send message to the worker
		fndr.postMessage({startFrom: fromNumber});
	}
	
	let resultContent = "..."
	if (results.length > 0) {
		resultContent = "";
		for (let p = 0; p < results.length; p++)
			resultContent += results[p] + ", ";
	}
	
	return (
		<Box>
			<Box className={classes.contents}>
				<TextField 
					className={classes.contents}
					label="From" 
					value={fromNumber} 
					onChange={(evt) => {setFromNumber(parseInt(evt.target.value))}}
				></TextField> 
				<TextField 
					className={classes.contents}
					label="To" 
					value={toNumber} 
					onChange={(evt) => {setToNumber(parseInt(evt.target.value))}}
				></TextField> 
				<Button 
					className={classes.buttons}
					variant="outlined" 
					disabled={finderStarted} 
					color="primary" 
					onClick={findPrimes}>
						Find primes
				</Button>
			</Box>
			
			<Box className={classes.contents}>
				<Typography>Found primes</Typography>
				<Typography>{resultContent}</Typography>
			</Box>
		</Box>
	);
}

export default App;
