import React from 'react';
import './App.css';
import TextField from '@material-ui/core/TextField';
import Box from '@material-ui/core/Box';
import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';

	
function App() {
	const [items, setItems] = React.useState(["2020-03-01"]);
	const [selected, setSelected] = React.useState(-1);
	
	
	const select = (event, index) => {
		setSelected(index);
	}
	const add = (event) => {
		setItems(items.concat(["2020-03-" + (items.length + 1)]));
	}
	const remove = (event) => {
		setItems(items.slice(0, selected).concat(items.slice(selected+1)));
		setSelected(-1);
	}
	const handleValueChange = (event, index) => {
		let itemsUpdated = items.slice(0, index).concat([event.target.value]).concat(items.slice(index+1));
		setItems(itemsUpdated);
	}
	
	return (
		<div>
			<Box border={1} width={400}>
				<List>
					{items.map((item, index) =>
							<ListItem
								key={"dateListItem"+ index}
								button
								selected={index === selected}
								onClick={(event) => {select(event, index);}}
							>
								<ListItemText
									key={"dateTest"}
									primary={<Typography>{item}</Typography>}
								/>
								<TextField
									type="Date"
									id={"inputField_" + index}
									label="Date"
									onChange={(event) => {handleValueChange(event, index)}}
									value={item}
									InputLabelProps={{shrink: true}}
								/>
							</ListItem>
						)
					}
				</List>
				<Button variant="contained" onClick={add}>Add</Button>
				<Button variant="contained" onClick={remove} disabled={selected<0}>Remove</Button>
			</Box>
		</div>
	);
}
export default App;

