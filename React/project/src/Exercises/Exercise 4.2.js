import React from 'react';
import './App.css';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box'; 
import getz from './getz.jpg';

function App() {
	// game maps board index positions to the block identities
	const [image, setImage] = React.useState(getz);
	
	
	const imageDragStart = (event) => {
		event.dataTransfer.setData("image/jpeg", event.target.src);
		event.dataTransfer.dropEffect = "copy";
	}
	
	const imageOnDrop = (event) => {
		event.preventDefault();
		for (let i = 0; i < event.clipboardData.items.length; i++) {
			let paste = event.clipboardData.items[i];
			if (paste.kind === "file" && (paste.type === "image/png" || paste.type === "image/jpeg")) {
				let reader = new FileReader()
				reader.onloadend = function(evt) {
				setImage(reader.result);
				};
				reader.readAsDataURL(paste.getAsFile())
			}
		}
		
	}
	
	const imageDragOver = (event) => {
		event.preventDefault();
		event.dataTransfer.dropEffect = "copy"
	}
	const pagePaste = (event) => {
		event.preventDefault();
		for (let i = 0; i < event.clipboardData.items.length; i++) {
			let paste = event.clipboardData.items[i];
			if (paste.kind === "file" && (paste.type === "image/png" || paste.type === "image/jpeg")) {
				let reader = new FileReader()
				reader.onloadend = function(evt) {
				setImage(reader.result);
				};
				reader.readAsDataURL(paste.getAsFile())
			}
		}
	}
	
	const pageCopy = (event) => {
		event.clipboardData.setData('text/plain');
		event.preventDefault();	
	}
	
	return (
		<div style={{width: 400, height: 400}} onPaste={pagePaste} onCopy={pageCopy} contentEditable={true} >
			<Box><img src={image} alt="Old Huyndai Getz" id="DraggingImage" onDragStart={imageDragStart} draggable={true} onDrop={imageOnDrop} onDragOver={imageDragOver} /></Box>
			<Typography id="picutreCaption" variant='caption'>
				copy image file from anoter place to replace the image. This does not work without exixting image, so refresh the page if you are missing an image
			</Typography>
			
		</div>
	);
}

export default App;
