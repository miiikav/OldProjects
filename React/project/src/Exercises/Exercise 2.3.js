import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogTitle from '@material-ui/core/DialogTitle';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';

const useStyles = makeStyles(theme => ({
		root: {
			flexGrow: 1,
		},
		bar: {
			maxWidth: "360px",
		},
		menuButton: {
			marginRight: theme.spacing(0),
		},
		title: {
			marginRight: theme.spacing(4),
		},
		heading: {
			marginLeft: theme.spacing(6),
		},
}));
	
function App() {
	const classes = useStyles();
	const [anchorEl, setAnchorEl] = React.useState("");
	const [dialogOpenAbout, setDialogOpenAbout] = React.useState(false);
	const [dialogOpenSize, setDialogOpenSize] = React.useState(false);
	const [dialogOpenText, setDialogOpenText] = React.useState(false);
	const [inputSize, setInputSize] = React.useState();
	const [fontSize, setFontSize] = React.useState();
	const [fontSizeInput, setFontSizeInput] = React.useState();
	const [Text, setText] = React.useState();
	const [textInput, setTextInput] = React.useState();
	const [greeting, setGreeting] = React.useState("Greeting");
	const [stages, setStage] = React.useState("1");
	const menuOpen = Boolean(anchorEl);
	
	const changeGreeting = (event) => {
		if(stages === "1"){
			setGreeting("Hi!");
			setStage("2");
		}
		else if(stages === "2"){
			setGreeting("Hello!");
			setStage("3");
		}
		else{
			setGreeting("Howdy!");
			setStage("1");
		}
	}
	
	const handleMenu = (event) => {
		setAnchorEl(event.currentTarget);
	};
	const handleMenuClose = () => {
		setAnchorEl(null);
	};
	const inputText = (event) => {
		setTextInput(event.target.value);
	}
	const inputFontSize = (event) => {
		setFontSizeInput(event.target.value);
	}
	const openDialogSize = (event) => {
		handleMenuClose(event);
		setFontSizeInput(""+fontSize);
		setDialogOpenSize(true);
	}
	const openDialogText = (event) => {
		handleMenuClose(event);
		setTextInput(textInput);
		setDialogOpenText(true);
	}
	const openDialogAbout = (event) => {
		handleMenuClose(event);
		setDialogOpenAbout(true);
	}
	const closeDialog = (event) => {
		setDialogOpenText(false);
		setDialogOpenSize(false);
		setDialogOpenAbout(false);
	}
	const acceptDialogSize = (event) => {
		let fs = parseInt(fontSizeInput)
		setFontSize(fs);
		closeDialog();
	}
	const acceptDialogText = (event) => {
		setText(textInput);
		closeDialog();
	}
	
  return (
	<div className="App">
		<AppBar position="sticky">
			<Toolbar variant="dense">
				<Button color="inherit" className={classes.title} onClick={handleMenu}>File</Button>
					<Menu id="menu-appbar" anchorEl={anchorEl} 
					anchorOrgin={{vertical: "top", horizontal: "right"}}
					keepMounted
					transformOrgin={{vertical: "top", horizontal: "right"}}
					open={menuOpen}
					onClose={handleMenuClose}>
						
						
						
					</Menu>
				<Button color="inherit" id="1" className={classes.title} onClick={changeGreeting}>Edit</Button>
				<Button color="inherit" className={classes.title} onClick={handleMenu}>Help</Button>
					<Menu id="help-appbar" anchorEl={anchorEl} 
					anchorOrgin={{vertical: "top", horizontal: "right"}}
					keepMounted
					transformOrgin={{vertical: "top", horizontal: "right"}}
					open={menuOpen}
					onClose={handleMenuClose}>
						<MenuItem onClick={openDialogSize}>Text size</MenuItem>
						<MenuItem onClick={openDialogText}>Change text</MenuItem>
						<MenuItem onClick={openDialogAbout}>About</MenuItem>
					</Menu>
			</Toolbar>
		</AppBar>
		<Typography variant="h2" className="geeting">
			{greeting}
		</Typography>
		<Dialog onClose={closeDialog} open={dialogOpenText}>
			<DialogTitle>Update text</DialogTitle>
			<TextField 
				label="Type here"
				helperText="Write new text"
				variant="filled"
				value={textInput} 
				onChange={inputText}
			/>
			<DialogActions>
				<Button variant="contained" id={"textCancel"} onClick={closeDialog}>Cancel</Button>
				<Button variant="contained" id={"textOK"} onClick={acceptDialogText}>Ok</Button>
			</DialogActions>
		</Dialog>
		
		
		<Dialog onClose={closeDialog} open={dialogOpenSize}>
			<DialogTitle>Set text size</DialogTitle>
			<TextField 
				value={fontSizeInput} 
				onChange={inputSize}
			/>
			<DialogActions>
				<Button variant="contained" id={"dialogCancel"} onClick={closeDialog}>Cancel</Button>
				<Button variant="contained" id={"sizeOK"} onClick={acceptDialogSize}>Ok</Button>
			</DialogActions>
		</Dialog>
		<Dialog onClose={closeDialog} open={dialogOpenAbout}>
			<DialogTitle>About</DialogTitle>
			<Typography>
				Test Dialog
			</Typography>
			<DialogActions>
				<Button variant="contained" id={"aboutOK"} onClick={closeDialog}>Ok</Button>
			</DialogActions>
		</Dialog>
    </div>
  );
}
export default App;

