import React, { useEffect, useState } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import './App.css';
import Dropdown from "./Dropdown";
import { LocalisationProvider } from "./localisation";
import Translate from "./Translate";

function App() {
	const [inputText, setInputText] = React.useState("");
	const [outputText, setOutputText] = React.useState("");
	const updateOutputText = (event) => {
		setOutputText(reverseString(inputText));
	}
	const updateInput = (event) => {
		setInputText(event.target.value);
	}
	function reverseString(str) {
		var newString="";
		for (var i = str.length - 1; i >= 0; i--) { 
			newString += str[i]; // or newString = newString + str[i];
		}
    return newString; // "olleh"
}
	return (
	<LocalisationProvider>
      <div className="App">
        <Dropdown />
        <h1>
          <Translate token="welcome" />
        </h1>
		<p><Translate token="Reverser" /></p>
		<div>
		<Translate token="Input"/>
		<TextField id={"inputText"} value={inputText} onChange={updateInput}/>
		</div>
		<div>
		<Translate token="Reversed"/>
		<TextField id={"outputText"} value={outputText} />
		</div>
		<Button onClick={updateOutputText}><Translate token="Press"/></Button>
		</div>
		</LocalisationProvider>
	);
}

export default App;