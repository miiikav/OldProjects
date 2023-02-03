import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import FormControl from '@material-ui/core/FormControl';
import Box from '@material-ui/core/Box';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import Typography from '@material-ui/core/Typography';
import red from '@material-ui/core/colors/red';
import green from '@material-ui/core/colors/green';
import blue from '@material-ui/core/colors/blue';

function App() {
	const initial = green[500]; // #F44336
	const primary = red[200]; // #F44336
	const secondary = blue[300]; // #F44336
	const [color, setColor] = React.useState("");
	const updateColor = (event) => {
		console.log(event.target.value)
		let val = event.target.value
		setColor(val);
	}
  return (
	<div>
		<Box>
			<Box>
				<Typography variant="h1" component="h2" style={{'fontStyle': "italic", color: color}}>COLOR</Typography>
				<Box>
					<FormControl component="fieldset">
						<RadioGroup defaultValue="black" name="customized-radios">
							<FormControlLabel value={initial} control={<Radio />} label="green" onClick={updateColor}/>
							<FormControlLabel value={secondary} control={<Radio />} label="blue" onClick={updateColor}/>
							<FormControlLabel value={primary} control={<Radio />} label="red" onClick={updateColor}/>
						</RadioGroup>
					</FormControl>
				</Box>
			</Box>

		</Box>
	</div>
  );
}

export default App;
