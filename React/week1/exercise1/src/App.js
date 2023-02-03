import React from 'react';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogTitle from '@material-ui/core/DialogTitle';
import Button from '@material-ui/core/Button';
import DialogActions from '@material-ui/core/DialogActions';
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";


const styles = {
  root: {
    background: "black"
  },
  input: {
    color: "white",
	fontFamily: "calibri"
  }
};
const initialState = {
  mouseX: null,
  mouseY: null,
};
function CustomizedInputs(props) {
	const { classes } = props;
	const [state, setState] = React.useState(initialState);
	const [font, setFont] = React.useState();
	const [colour, setColour] = React.useState();
	const [stages, setStage] = React.useState("1");
  const handleClick = (event) => {
    event.preventDefault();
    setState({
      mouseX: event.clientX - 2,
      mouseY: event.clientY - 4,
    });
  };
  const handleClose = () => {
    setState(initialState);
  };
  	const changeFont = (event) => {
		if(stages === "1"){
			setFont("Courier New");
			setStage("2");
		}
		else if(stages === "2"){
			setFont("Consolas");
			setStage("3");
		}
		else{
			setFont("Monaco");
			setStage("1");
		}
	}
	const changeColour = (event) => {
		if(stages === "1"){
			setColour('red');
			setStage("2");
		}
		else if(stages === "2"){
			setColour('green');
			setStage("3");
		}
		else{
			setColour('blue');
			setStage("1");
		}
	}
	
  return (
    <div onContextMenu={handleClick} style={{ cursor: 'context-menu' }}>
    <TextField
      defaultValue="test"
      className={classes.root}
      InputProps={{
        className: classes.input
      }}
    />
      <Menu
        keepMounted
        open={state.mouseY !== null}
        onClose={handleClose}
        anchorReference="anchorPosition"
        anchorPosition={
          state.mouseY !== null && state.mouseX !== null
            ? { top: state.mouseY, left: state.mouseX }
            : undefined
        }
      >
        <MenuItem onClick={changeFont}>Change Font</MenuItem>
        <MenuItem onClick={changeColour}>Change Colour</MenuItem>
      </Menu>
    </div>
  );
}
CustomizedInputs.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(CustomizedInputs);