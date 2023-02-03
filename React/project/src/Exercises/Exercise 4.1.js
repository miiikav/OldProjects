import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box'; 

function App() {
	// game maps board index positions to the block identities
	const [text1, setText1] = React.useState("Text1");
	const [text2, setText2] = React.useState("Text2");
	const [text3, setText3] = React.useState("Text3");
	const [image, setImage] = React.useState("");
	
	const textDragStart1 = (event) => {
		event.dataTransfer.setData("text/plain", text1);
		event.dataTransfer.dropEffect = "copy";
	}
	const textDragStart2 = (event) => {
		event.dataTransfer.setData("text/plain", text2);
		event.dataTransfer.dropEffect = "copy";
	}
	const textDragStart3 = (event) => {
		event.dataTransfer.setData("text/plain", text3);
		event.dataTransfer.dropEffect = "copy";
	}
	
	const textOnDrop1 = (event) => {
		var items = event.dataTransfer.items;
		for (var i = 0; i < items.length; ++i) {
			var item = items[i];
			if (item.kind === 'string') {
				event.preventDefault();
				const data = event.dataTransfer.getData("text/plain");
				setText1(data);
				return;
			}
		}
		event.preventDefault();
	}
	const textOnDrop2 = (event) => {
		var items = event.dataTransfer.items;
		for (var i = 0; i < items.length; ++i) {
			var item = items[i];
			if (item.kind === 'string') {
				event.preventDefault();
				const data = event.dataTransfer.getData("text/plain");
				setText2(data);
				return;
			}
		}
		event.preventDefault();
	}
	const textOnDrop3 = (event) => {
		var items = event.dataTransfer.items;
		for (var i = 0; i < items.length; ++i) {
			var item = items[i];
			if (item.kind === 'string') {
				event.preventDefault();
				const data = event.dataTransfer.getData("text/plain");
				setText3(data);
				return;
			}
		}
		event.preventDefault();
	}
	const textDragEnter = (event) => {
		var items = event.dataTransfer.items;
		for (var i = 0; i < items.length; ++i) {
			var item = items[i];
			if (item.kind === 'string') {
				event.preventDefault();
				return;
			}
		}
	}
	
	const textDragOver = (event) => {
		event.preventDefault();
		event.dataTransfer.dropEffect = "copy"
		
	}
	
	const imageDragStart = (event) => {
		event.dataTransfer.setData("image/jpeg", event.target.src);
		event.dataTransfer.dropEffect = "copy";
	}
	
	const imageOnDrop = (event) => {
		event.preventDefault();
		let file = event.dataTransfer.files[0];
		if (file) {
			let reader = new FileReader()
			reader.onloadend = function(evt) {
				setImage(reader.result);
			};
			reader.readAsDataURL(file)
		}
		
	}
	
	const imageDragOver = (event) => {
		event.preventDefault();
		event.dataTransfer.dropEffect = "copy"
	}
	
	const pagePaste = (event) => {
		let paste = event.clipboardData.getData('text1');
		setText1(paste);
		event.preventDefault();
	}
	
	const pageCopy = (event) => {
		event.clipboardData.setData('text/plain', text1);
		event.preventDefault();	
	}
	
	return (
		<div style={{width: 400, height: 400}} onPaste={pagePaste} onCopy={pageCopy} contentEditable={true} >
			<Typography id="DraggingText1" variant='h2' 
				onDragStart={textDragStart1} 
				draggable={true} 
				onDrop={textOnDrop1} 
				onDragEnter={textDragEnter} 
				onDragOver={textDragOver}>
				{text1}
			</Typography>
			<Typography id="DraggingText2" variant='h2' 
				onDragStart={textDragStart2} 
				draggable={true} 
				onDrop={textOnDrop2} 
				onDragEnter={textDragEnter} 
				onDragOver={textDragOver}>
				{text2}
			</Typography>
			<Typography id="DraggingText3" variant='h2' 
				onDragStart={textDragStart3} 
				draggable={true} 
				onDrop={textOnDrop3} 
				onDragEnter={textDragEnter} 
				onDragOver={textDragOver}>
				{text3}
			</Typography>
			
		</div>
	);
}

export default App;
