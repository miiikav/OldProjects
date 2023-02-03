import React from 'react';
import logo from './logo.svg';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import FormControlLabel from '@material-ui/core/FormControlLabel';

function App() {
	const [check, setCheck] = React.useState(true);
	const [first, setFirst] = React.useState("");
	const [middle, setMiddle] = React.useState("");
	const [last, setLast] = React.useState("");
	const [everyone, setEveryone] = React.useState(0);
//  const bool = (event) => {
//    state = { disabled: false }
//  }
  const updateCheck = (event) => {
    setCheck( {disabled: !check.disabled} )
  }
  const updateEveryone = (event) => {
	setFirst("Tuomo");
	setMiddle("Jari Johannes");
	setLast("Ikavalko");
  }
  return (
		<div>
			<Box>
				<TextField id="first" label="First Name" value={first}/>
				<TextField id="middle" label="Middle Name" value={middle} disabled={(check.disabled)? "disabled" : ""}/>
				<TextField id="last" label="Last Name" value={last}/>
			</Box>
			<FormControlLabel control={
					<Checkbox onChange={updateCheck.bind(this)} value="primary"   />
				} 
				label="Middle Name"
			/>
			<Button variant="contained" color="primary" label="autofill" onClick={updateEveryone.bind(this)}>
				Autofill
			</Button>
		</div>
  );
}

export default App;
