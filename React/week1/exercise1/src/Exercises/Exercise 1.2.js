import React from 'react';
import logo from './logo.svg';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import FormControlLabel from '@material-ui/core/FormControlLabel';

function App() {
	const [binary, setBinary] = React.useState("");
	const [decimal, setDecimal] = React.useState("");
	const [value, setValue] = React.useState("");
	
	const addToBinary = (c) => {
		setBinary(binary + c);
	}

	//const buttons = [];
	//for (let i = 0; i < 7; i++) {
		//let handler = (event) => {addToValue(i);};
	//}
	const updateDecimal = (event) => {
		var digit = parseInt(binary, 2);
		setDecimal(digit);
	}
	
  const updateBinary = (event) => {
	for (var i = 0; i < 7; i++) {
        console.log(event.target.checked, event.target.name, event.target.id );
		if (event.target.checked==true){
			{addToBinary(1);};
		}else{
			{addToBinary(0);};
		}
    }
	
    //setBinary( {disabled: !check.disabled} )
  }
  
  return (
		<div>
			<Box>
				<Checkbox id="1" value="primary" onChange={updateBinary.bind(this)} name="check1" />
				<Checkbox id="2" value="primary" onChange={updateBinary.bind(this)} name="check2" />
				<Checkbox id="3" value="primary" onChange={updateBinary.bind(this)} name="check3" />
				<Checkbox id="4" value="primary" onChange={updateBinary.bind(this)} name="check4" />
				<Checkbox id="5" value="primary" onChange={updateBinary.bind(this)} name="check5" />
				<Checkbox id="6" value="primary" onChange={updateBinary.bind(this)} name="check6" />
				<Checkbox id="7" value="primary" onChange={updateBinary.bind(this)} name="check7" />
				<Checkbox id="8" value="primary" onChange={updateBinary.bind(this)} name="check8" />
			</Box>
			<Box>
				<TextField id="binary" label="binary" disabled={true} value={binary}/>
			</Box>
			<Box>
				<Button variant="contained" color="primary" label="convert" onClick={updateDecimal.bind(this)} >
				Convert
				</Button>
			</Box>
			<Box>
				<TextField id="decimal" label="decimal" disabled={true} value={decimal}/>
			</Box>
		</div>
  );
}

export default App;
