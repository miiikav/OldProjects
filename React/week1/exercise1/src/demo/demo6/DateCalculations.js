import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import Input from '@material-ui/core/Input';

const useStyles = makeStyles(theme => ({
	heading: {
		fontSize: "2em",
		padding: "16pt"
	},
	calculatorBox: {
		padding: "16pt",
		border: "12pt",
	},
	inputField: {
		paddingLeft: "16pt",
	},
	formText: {
		marginLeft: "8pt",
		marginRight: "8pt",
	}
}));

function App() {
	const [dateInput, setDateInput] = React.useState("");
	const [parsedDate, setParsedDate] = React.useState(null);
	const [numberInput, setNumberInput] = React.useState("");
	const [parsedNumber, setParsedNumber] = React.useState(null);
	const [result, setResult] = React.useState(null);
	
	const styledClasses = useStyles({});
	
	const updateCalculation = (d, n) => {
		if (d !== null && n !== null) {
			let updatedDate = new Date(d);
			updatedDate.setDate(d.getDate() + n);
			setResult(updatedDate);
		}
	}
	
	const updateDate = (event) => {
		let it = event.target.value;
		let d = null;
		let datePattern = new RegExp("(?<day>\\d\\d?)\\.(?<month>\\d\\d?)\\.(?<year>\\d\\d(\\d\\d)?)$");
		let match = it.match(datePattern);
		if (match !== null) {
			d = new Date(match.groups.year, match.groups.month-1, match.groups.day);
			if (d.getDate() === parseInt(match.groups.day) && d.getMonth() + 1 === parseInt(match.groups.month)) {
				setParsedDate(d);
				updateCalculation(d, parsedNumber);
			} else {
				d = null;
			}
		}
		setParsedDate(d);
		setDateInput(it);
	}
	
	const updateNumber = (event) => {
		let typed = event.target.value;
		let pn = parseInt(typed);
		if (!isNaN(pn)) {
			setParsedNumber(pn);
			updateCalculation(parsedDate, pn);
		} else {
			setParsedNumber(null);
		}
		setNumberInput(typed);
	}
	
	// Notice that Intl.DateTimeFormat() creates US date format by default, so language code must be given.
	const df = new Intl.DateTimeFormat(navigator.language);
	
	return (
		<Box>
			<Typography variant="h1" className={styledClasses.heading}>
				Date Calculator
			</Typography>
			<Box display="flex" flexWrap="wrap" className={styledClasses.calculatorBox}>
				<FormControl
					error={parsedDate===null?true:false}
				>
					<InputLabel htmlFor="date-input">Date input</InputLabel>
					<Input 
						id="date-input"
						aria-describedby="date-helper-text"
						className={styledClasses.inputField}
						value={dateInput} 
						onChange={updateDate}
					/>
					<FormHelperText id="date-helper-text">Give date in format D.M.YYYY.</FormHelperText>
				</FormControl>
				<Typography variant="body1" className={styledClasses.formText}>plus</Typography> 
				<FormControl
						error={parsedNumber===null?true:false}
				>
					<InputLabel htmlFor="days-input">Number of days</InputLabel>
					<Input 
						id="days-input"
						aria-describedby="days-helper-text"
						className={styledClasses.inputField}
						value={numberInput} 
						onChange={updateNumber}
					/>
					<FormHelperText id="days-helper-text">Input number of days as integer.</FormHelperText>
				</FormControl>
				<Typography variant="body1" className={styledClasses.formText}>is date</Typography> 
				<Box component="span" className={styledClasses.formText}>
					<Typography variant="body1" className={styledClasses.formText}>{result!=null?df.format(result):""}</Typography> 
				</Box>
			</Box>
		</Box>
	);
}

export default App;
