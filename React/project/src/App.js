import React, { useEffect, useState } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import './App.css';
import Dropdown from "./Dropdown";
import { LocalisationProvider } from "./localisation";
import Translate from "./Translate";
import DataTable from 'react-data-table-component';

function App() {
	const [ColumnsNum, setColumnsNum] = React.useState("");
	const [Titles, setTitles] = React.useState("");
	let [Data, setData] = React.useState([]);
	let [Columns, setColumns] = React.useState([]);
	const updateTitles = (event) => {
		setTitles(event.target.value);
	}
	const updateColumnsNum = (event) => {
		setColumnsNum(event.target.value);
	}
	const updateColumns = (titleStrings,i) => {
		setColumns(Columns.concat({name: titleStrings[i] , selector: titleStrings[i], sortable: true, }));
		console.log('updateColumns called')
	}
	const updateData = (dataEntry) => {
		setData(Data.concat(dataEntry));
		console.log('updateData called')
	}
	//let data = [];
	//let columns = [];
	
function createColumns(num,str) {
	console.log('createColumns called')
	let titleStrings = str.split(",");
	for (let i = 0; i < num; i++) {
		//columns.push({name: titleStrings[i] , selector: titleStrings[i], sortable: true, });
		//setColumns(Columns.concat({name: titleStrings[i] , selector: titleStrings[i], sortable: true, }));
		updateColumns(titleStrings,i);
	}
	for (let row = 0; row < 3; row++) {
		let dataEntry = {};
		for (let i = 0; i < num; i++) {
			const hs = titleStrings[i].trim();
			dataEntry[hs] = hs + row;
			dataEntry.id = hs + row;
		}
		//data.push(dataEntry);
		//setData(Data.concat(dataEntry));
		updateData(dataEntry);
	}
	
}
function addRow(num,str) {
	
}
	return (
	<LocalisationProvider>
      <div className="App">
        <Dropdown />
        <h1>
          <Translate token="welcome" />
        </h1>
		<p><Translate token="Table" /></p>
		<div>
		<Translate token="Titles"/>
		<TextField id={"Titles"}  onChange={updateTitles}/>
		</div>
		<div>
		<Translate token="Columns"/>
		<TextField id={"ColumnsNum"}  onChange={updateColumnsNum}/>
		</div>
		<Button onClick={() => {createColumns(ColumnsNum,Titles)}}><Translate token="Create"/></Button>
		<div>
		<DataTable title="Table" Columns={Columns} Data={Data} selectableRows />
		</div>
	</div>
	</LocalisationProvider>

	);
}

export default App;