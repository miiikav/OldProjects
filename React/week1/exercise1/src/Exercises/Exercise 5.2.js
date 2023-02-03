import React, {useRef, useEffect} from 'react';
import './App.css';
import { createMuiTheme, makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Slider from '@material-ui/core/Slider';
import brushSVG from './brush.svg';
import brushImg from './brush.png';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import TextField from '@material-ui/core/TextField';
import FormGroup from '@material-ui/core/FormGroup';
import Button from '@material-ui/core/Button';

function App() {
	const [items, setItems] = React.useState([]);
	const [url, setUrl] = React.useState("");
	const [top, setTop] = React.useState("");
	const [bottom, setBottom] = React.useState("");
	
	const updateUrl = (event) => {
		setUrl(event.target.value);
	}
	const updateTop = (event) => {
		setTop(event.target.value);
	}
	const updateBottom = (event) => {
		setBottom(event.target.value);
	}
	const [zoom, setZoom] = React.useState(1.0);
	const [pan, setPan] = React.useState(1);
	const [tilt, setTilt] = React.useState(1);
	const [rotation, setRotation] = React.useState(0);
	
	const canvasRef = useRef(null);
	const imageEl = useRef(null);
	const Top = useRef(null);
	const Bottom = useRef(null);
	
	useEffect(() => {
		let ctx = canvasRef.current.getContext('2d');
		// width an height are used in various places, store them in these variables to shorten the following code
		let [w, h] = [canvasRef.current.width, canvasRef.current.height];
		// clear canvas
		ctx.clearRect(0, 0, w, h);
		
		// save the current canvas state so that we can go back to it
		ctx.save();
		// transform to take care of pant, tilt, zoom and rotation
		ctx.translate(w/2, h/2);
		ctx.rotate(rotation/180*Math.PI);
		ctx.translate(-w/2, -h/2);
		// draw the png and svg images to canvas
		ctx.drawImage(imageEl.current, 0, w/3);
		ctx.fillText(top,200, 200);
		ctx.fillText(bottom,200, 600);
		// in the end restore the transform
		ctx.restore();
	});
		
	return (
		<Box>
			<Box>
				<Typography variant="h6">Images on Canvas -refresh the page when changing images</Typography>
				<FormGroup>
				<TextField id={"url"} value={url} onChange={updateUrl} label="ImageURL" />
			</FormGroup>
			<FormGroup>
				<TextField id={"top"} value={top} onChange={updateTop} label="top text" />
			</FormGroup>
			<FormGroup>
				<TextField id={"bottom"} value={bottom} onChange={updateBottom} label="bottom text" />
			</FormGroup>
			</Box>
			<Box display="flex" style={{"position": "relative", "top": 0, "width": 40, "height": 600}}>
				<Box>
					<canvas
						width={600}
						height={600}
						ref={canvasRef}
					/>
				</Box>
			</Box>
			<img onLoad={() => {setPan(0);}} src={url} ref={imageEl} style={{"display": "none"}}/>
		</Box>
	);
}

export default App;
