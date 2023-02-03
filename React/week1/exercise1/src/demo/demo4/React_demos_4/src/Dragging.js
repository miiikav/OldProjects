import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box'; 
import getz from './getz.jpg';

function App() {
	// game maps board index positions to the block identities
	const [text, setText] = React.useState("Heading text here");
	const [image, setImage] = React.useState(getz);
	
	const textDragStart = (event) => {
		event.dataTransfer.setData("text/plain", text);
		event.dataTransfer.setData("text/html", "<h2>" + text + "</h2>");
		event.dataTransfer.dropEffect = "copy";
	}
	
	const textOnDrop = (event) => {
		var items = event.dataTransfer.items;
		for (var i = 0; i < items.length; ++i) {
			var item = items[i];
			if (item.kind === 'string') {
				event.preventDefault();
				const data = event.dataTransfer.getData("text/plain");
				setText(data);
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
		let paste = event.clipboardData.getData('text');
		setText(paste);
		event.preventDefault();
	}
	
	const pageCopy = (event) => {
		event.clipboardData.setData('text/plain', text);
		event.preventDefault();	
	}
	
	return (
		<div style={{width: 400, height: 400}} onPaste={pagePaste} onCopy={pageCopy} contentEditable={true} >
			<Typography id="DraggingText" variant='h2' 
				onDragStart={textDragStart} 
				draggable={true} 
				onDrop={textOnDrop} 
				onDragEnter={textDragEnter} 
				onDragOver={textDragOver}>
				{text}
			</Typography>
			<Box><img src={image} alt="Old Huyndai Getz" id="DraggingImage" onDragStart={imageDragStart} draggable={true} onDrop={imageOnDrop} onDragOver={imageDragOver}/></Box>
			<Typography id="picutreCaption" variant='caption'>
				Drag and drop and image file above to replace the image.
				Drag and drop text to change the text on top.
			</Typography>
			
		</div>
	);
}

export default App;
