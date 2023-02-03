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
	const [dialogOpen, setDialogOpen] = React.useState(false);
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
	const openDialog = (event) => {
		handleMenuClose(event);
		setDialogOpen(true);
	}
		const closeDialog = (event) => {
		handleMenuClose(event);
		setDialogOpen(false);
	}
  return (
	<div className={classes.root}>
		<AppBar position="sticky"  className={classes.bar}>
			<Toolbar variant="dense">
				<Button color="inherit" className={classes.title}>File</Button>
				<Button color="inherit" id="1" className={classes.title} onClick={changeGreeting}>Edit</Button>
				<Button color="inherit" className={classes.title} onClick={handleMenu}>Help</Button>
					<Menu id="help-appbar" anchorEl={anchorEl} 
					anchorOrgin={{vertical: "top", horizontal: "right"}}
					keepMounted
					transformOrgin={{vertical: "top", horizontal: "right"}}
					open={menuOpen}
					onClose={handleMenuClose}>
					<MenuItem onClick={openDialog}>About</MenuItem>
					</Menu>
			</Toolbar>
		</AppBar>
		<Typography variant="h2" className="geeting">
			{greeting}
		</Typography>
		<Dialog onClose={closeDialog} open={dialogOpen}>
			<DialogTitle>About</DialogTitle>
			<Typography>
				Test Dialog
			</Typography>
			<DialogActions>
				<Button variant="contained" id={"dialogOK"} onClick={closeDialog}>Test</Button>
			</DialogActions>
		</Dialog>
    </div>
  );
}
export default App;

