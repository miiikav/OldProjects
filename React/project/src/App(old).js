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
	const updateTitles = (event) => {
		setTitles(event.target.value);
	}
	const updateColumnsNum = (event) => {
		setColumnsNum(event.target.value);
	}
	
	const ColumnName = [];
	const data = [{ id: 1, title: 'Conan the Barbarian', year: '1982' }];
	const columns = [{name: ColumnName , selector: ColumnName, sortable: true, },];
 
function createColumns(num,str) {
	var newArray = str.split(",")
	for (var i = 0; i == num; i++) { 
		ColumnName[i] = newArray[i];
	}
	
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
		<Translate token="Columns"/>
		<TextField id={"ColumnsNum"} value={ColumnsNum} onChange={updateColumnsNum}/>
		</div>
		<div>
		<Translate token="Titles"/>
		<TextField id={"Titles"} value={Titles} onChange={updateTitles}/>
		</div>
		<Button onClick={createColumns(ColumnsNum,Titles)}><Translate token="Create"/></Button>
		<div>
		<DataTable title="Table" columns={columns} data={data} selectableRows />
		</div>
	</div>
	</LocalisationProvider>

	);
}

export default App;