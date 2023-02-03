import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import { makeStyles } from '@material-ui/core/styles';


const useStyles = makeStyles(theme => ({
		app: {
			padding: "10px",
		},
		input: {
			outline: "none",
			borderRadius: "50px",
		},
		red: {
			background: 'linearGradient(90deg, rgb(0,0,0), rgb(255,0,0))',
		},
		green: {
			background: 'linearGradient(90deg, rgb(0,0,0), rgb(0,255,0))',
		},
		blue: {
			background: 'linearGradient(90deg, rgb(0,0,0), rgb(0,0,255))',
		},
		label: {
			marginLeft: "5px",
			position: "relative",
		},
		box: {
			marginTop: "10px",
			height: "200px",
			width: "200px",
		}
}));
	
function App() {
	const classes = useStyles();
	const [red, setRed] = React.useState("0");
	const [blue, setBlue] = React.useState("0");
	const [green, setGreen] = React.useState("0");
	
	
	const updateRed = (event) => {
		setRed(event.target.value);
	}
	const updateBlue = (event) => {
		setBlue(event.target.value);
	}
	const updateGreen = (event) => {
		setGreen(event.target.value);
	}
	
	/*render: function () {
		var styles = {
			marginTop: 10,
			height: 200,
			width: 200,
			background: 'rgb(' + this.state.red + ',' + this.state.green + ',' + this.state.blue + ')'
	};*/

  return (
  <div className="container">
        <div className="sliders">
          <div className={classes.red}>
            <input id="red" type="range" 
                min="0" 
                max="255" 
                steps="1" 
                value={red} 
                onChange={updateRed} />
            <label className={classes.label}>Red: {red}</label>
          </div>
          <div className={classes.green}>
            <input id="green" type="range" 
                min="0" 
                max="255" 
                steps="1" 
                value={green} 
                onChange={updateGreen} />
            <label className={classes.label}>Green: {green}</label>
          </div>
          <div className={classes.blue}>
            <input id="blue" type="range"  
                min="0" 
                max="255" 
                steps="1" 
                value={blue} 
                onChange={updateBlue} />
            <label className={classes.label}>Blue: {blue}</label>
          </div>
        </div>
        <div className={classes.box}>
			<Box className={classes.box} style={{"backgroundColor": 'rgb(' + red + ',' + green + ',' + blue + ')',"height": "100","width": "200"}}>
			</Box>
		</div>
      </div>
	  
  );
}
export default App;

