import React from 'react';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';
import PieChart from './PieChart';

const useStyles = makeStyles({
  buttons: {
    margin: '8pt',
  },
  contents: {
    margin: '8pt',
  },
});

function App() {
	const [result, setResult] = React.useState(null);
	const [results, setResults] = React.useState(null);
	const [finderStarted, setFinderStarted] = React.useState(false);
	const [numberStatistics, setNumberStatistics] = React.useState({});
	const [finder, setFinder] = React.useState(null);
	const [pieValue, setPieValue] = React.useState(null);
	const [pieName, setPieName] = React.useState(null);
	const [pieList, setPieList] = React.useState({});
	
	const classes = useStyles();
	
	const findPrimes = (event) => {
		setResult(null);
		setResults(null);
		let fndr = new Worker('primesFinder.js');
		setFinder(fndr);
		setFinderStarted(true);
		// send message to the worker
		fndr.postMessage({startFrom: 3});
		// receive results from the worker
		fndr.onmessage = function(message) {
			if (message.data.prime) {
				message.data.prime="30";
				setResult(message.data.prime);
			}
			if (message.data.primes) {
				message.data.primes="30";
				setResults(message.data.primes);
				setFinderStarted(false);
				let ar = {};
				console.log(message.data.primes);
				for (let r in message.data.primes) {
					//console.log(message.data.primes);
					let textValue = ""+message.data.primes[r];
					//console.log(message.data.primes[r]);
					for (let c in textValue) {
						console.log("textValue: "+textValue);
						let letter = textValue.charAt(c);
						//console.log("letter on pie: "+letter);
						if (!ar.hasOwnProperty(letter)) {
							ar[letter] = {value: 1, name:  textValue.charAt(c)};
						} else {
							ar[letter].value += 1;
						}
					}
				}
					console.log(ar);
					setNumberStatistics(ar);
			}
		}
	}
	const updatePieName = (event) => {
		setPieName(event.target.value);
	}
	const updatePieValue = (event) => {
		setPieValue(event.target.value);
	}
	const addPie = (event) => {
		let ar = {};
/* 		if(pieList.length !== 0){
			console.log("test");
			for (let c in pieList.length) {
				pieList[c] = {value: pieValue, name:  pieName};
			}
		} */
		//else{
			ar[0] = {value: pieValue, name:  pieName};
		//}
		console.log(pieList);
		console.log(ar);
/* 		if(pieList.length !== 0){
			setPieList(ar);
			console.log("ar pielist: "+pieList);
		} */
		setNumberStatistics(ar);
		//updatePieList();
		
	}
/* 	const updatePieList = (event) => {
		for (let c in pieList.length) {
			pieList[c] = {value: pieValue, name:  pieName};
		}
	} */
	const analyse = (event) => {
		console.log("Posting worker a stop message");
		finder.postMessage({stop: true});
		setFinderStarted(false);
	}
	
	let resultContent = <Typography>...</Typography>
	if (results !== null)
		resultContent = results.length;
	
	return (
		<Box>
			<Typography className={classes.contents}>Prime: {result}</Typography>
			<Button 
				className={classes.buttons}
				variant="outlined" 
				disabled={finderStarted} 
				color="primary" 
				onClick={findPrimes}>
					Find primes
			</Button>
			
			<Button 
				className={classes.buttons}
				variant="outlined" 
				//disabled={result === null} 
				color="primary" 
				onClick={addPie}>
					Add to Pie Chart
			</Button>
			<Box>
			<Typography>PieValue</Typography>
			<TextField id={"PieValue"}  onChange={updatePieValue}/>
			</Box>
			<Box>
			<Typography>PieName</Typography>
			<TextField id={"PieName"} onChange={updatePieName}/>
			</Box>
			<Box className={classes.contents}>
				<Typography>Found primes</Typography>
				{resultContent}
			</Box>
			<Box className={classes.contents}>
				<Typography>Pie Chart</Typography>
				<PieChart data={numberStatistics}/>
			</Box>
		</Box>
	);
}

export default App;
