import React, {useRef, useEffect} from 'react';
import './App.css';
import { createMuiTheme, makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Slider from '@material-ui/core/Slider';
import brushSVG from './brush.svg';
import brushImg from './brush.png';
import FormControlLabel from '@material-ui/core/FormControlLabel';

function App() {
	const [zoom, setZoom] = React.useState(1.0);
	const [pan, setPan] = React.useState(1);
	const [tilt, setTilt] = React.useState(1);
	const [rotation, setRotation] = React.useState(0);
	
	const canvasRef = useRef(null);
	const imageEl = useRef(null);
	const svgEl = useRef(null);
	
	useEffect(() => {
		let ctx = canvasRef.current.getContext('2d');
		// width an height are used in various places, store them in these variables to shorten the following code
		let [w, h] = [canvasRef.current.width, canvasRef.current.height];
		// clear canvas
		ctx.clearRect(0, 0, w, h);
		
		// save the current canvas state so that we can go back to it
		ctx.save();
		// transform to take care of pant, tilt, zoom and rotation
		ctx.translate(pan, tilt);
		ctx.translate(w/2, h/2);
		ctx.scale(zoom, zoom);
		ctx.rotate(rotation/180*Math.PI);
		ctx.translate(-w/2, -h/2);
		// draw the png and svg images to canvas
		ctx.drawImage(imageEl.current, 0, w/3);
		ctx.drawImage(svgEl.current, 0, w/3);
		// in the end restore the transform
		ctx.restore();
	});
		
	return (
		<Box>
			<Box>
				<Typography variant="h6">Images on Canvas</Typography>
			</Box>
			<Box display="flex" style={{"position": "relative", "top": 0, "width": 40, "height": 600}}>
				<FormControlLabel
					labelPlacement='bottom'
					label="v-pos"
					control={
						<Slider
							value={-tilt}
							orientation="vertical"
							valueLabelDisplay="auto"
							step={1}
							min={-600}
							max={600}
							onChange={(event, value) => setTilt(-value)}
						/>
					}>
				</FormControlLabel>
				<Box>
					<canvas
						width={600}
						height={600}
						ref={canvasRef}
					/>
					<Box style={{"width": 600}}>
					<FormControlLabel
						style={{"width": 600}}
						labelPlacement='bottom'
						label="h-pos"
						control={
							<Slider
								value={pan}
								orientation="horizontal"
								valueLabelDisplay="auto"
								step={1}
								min={-600}
								max={600}
								onChange={(event, value) => setPan(value)}
							/>
						}>
					</FormControlLabel>
					</Box>
					<Box style={{"width": 600}}>
						<FormControlLabel
							style={{"width": 600}}
							labelPlacement='bottom'
							label="zoom"
							control={
							<Slider
								value={(zoom-1)*64}
								orientation="horizontal"
								valueLabelDisplay="auto"
								step={1}
								min={0}
								max={255}
								onChange={(event, value) => setZoom(value/64+1)}
							/>
						}>
					</FormControlLabel>
					</Box>
					<Box style={{"width": 600}}>
						<FormControlLabel
							style={{"width": 600}}
							labelPlacement='bottom'
							label="rot"
							control={
							<Slider
								value={rotation}
								orientation="horizontal"
								valueLabelDisplay="auto"
								step={5}
								min={0}
								max={180}
								onChange={(event, value) => setRotation(value)}
						/>
						}>
					</FormControlLabel>
					</Box>
				</Box>
			</Box>
			<img onLoad={() => {setPan(0);}} src={brushImg} ref={imageEl} style={{"display": "none"}}/>
			<img onLoad={() => {setTilt(0);}} src={brushSVG} ref={svgEl} style={{"display": "none"}}/>
		</Box>
	);
}

export default App;
