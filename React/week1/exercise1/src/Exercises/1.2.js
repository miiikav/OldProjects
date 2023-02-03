import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import FormControlLabel from '@material-ui/core/FormControlLabel';

function App() {
	const [binary, setBinary] = React.useState("00000000");
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
		//setBinary(0);
		var index = parseInt(event.target.id)-1;
		var b="";
		console.log(index, event.target.checked, binary);
		for (var i = 0; i < 8; i++) {
		//console.log(event.target.checked, event.target.name, event.target.id );
			if(i==index){
				//console.log("if "+index);
				if (event.target.checked==true){
					{b+="1";};
					
					//console.log("true "+b);
				}
				else{
					{b+="0";};
					//console.log("false "+b);
				}
			}
			else{
			//console.log("else "+index);
				b+=binary.substring(i,i+1);
				//console.log("else "+b);
			}
			

		}
		setBinary(b);
	}
  
  return (
		<div>
			<Box>
				<Checkbox id="1" value="primary" onChange={updateBinary} name="check1" />
				<Checkbox id="2" value="primary" onChange={updateBinary} name="check2" />
				<Checkbox id="3" value="primary" onChange={updateBinary} name="check3" />
				<Checkbox id="4" value="primary" onChange={updateBinary} name="check4" />
				<Checkbox id="5" value="primary" onChange={updateBinary} name="check5" />
				<Checkbox id="6" value="primary" onChange={updateBinary} name="check6" />
				<Checkbox id="7" value="primary" onChange={updateBinary} name="check7" />
				<Checkbox id="8" value="primary" onChange={updateBinary} name="check8" />
			</Box>
			<Box>
				<TextField id="binary" label="binary" disabled={true} value={binary}/>
			</Box>
			<Box>
				<Button variant="contained" color="primary" label="convert" onClick={updateDecimal} >
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
