import React, {useRef, useEffect} from 'react';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Slider from '@material-ui/core/Slider';
import FormControlLabel from '@material-ui/core/FormControlLabel';

function App() {
	const [controlPoints, setControlPoints] = React.useState([100, 100, 200, 300, 300, 100, 400, 550]);
	const [dragged, setDragged] = React.useState(-1);
	const [position, setPosition] = React.useState(0);
	const [zoom, setZoom] = React.useState(1.0);

	const canvasRef = useRef(null);
	
	const CPW = 8;
	
	const mouseCoordinatesOnCanvas = (event) => {
		// transform mouse coordinates to internal, logical coordinates
		// using DOMMatrix: https://developer.mozilla.org/en-US/docs/Web/API/DOMMatrix
		let h = canvasRef.current.height;
		let w = canvasRef.current.width;
		let transform = new DOMMatrix();
		transform = transform.translateSelf(w / 2, h / 2, 0);
		transform = transform.scaleSelf(zoom, zoom, 1);
		transform = transform.translate(-w / 2, -h / 2, 0);
		
		transform = transform.invertSelf();
		
		// check if mouse is close to one of th control points
		var rect = event.target.getBoundingClientRect();
		let domP = new DOMPoint(event.clientX - rect.left, event.clientY - rect.top);
		let domPTransformed = transform.transformPoint(domP);
		return domPTransformed;
	}
	
	const pick = (event) => {
		let mc = mouseCoordinatesOnCanvas(event);
		for (let i = 0; i < controlPoints.length; i+=2) {
			console.log(i, mc.x, mc.y, Math.abs(controlPoints[i]-mc.x),  Math.abs(controlPoints[i+1]-mc.y));
			if (Math.abs(controlPoints[i]-mc.x) < CPW && Math.abs(controlPoints[i+1]-mc.y) < CPW) {
				console.log("Dragging", i);
				setDragged(i/2);
				break;
			}
		}
	}
	
	const move = (event) => {
		let mc = mouseCoordinatesOnCanvas(event);
		if (dragged >= 0) {
			setControlPoints(
				controlPoints.slice(0, dragged*2).concat([mc.x, mc.y]).concat(controlPoints.slice(dragged*2+2))
			);
		}
	}
	
	const release = (event) => {
		setDragged(-1);
	}
	
	const drawBezier = (ctx) => {
		let h = ctx.canvas.height;
		let w = ctx.canvas.width;
		
		ctx.clearRect(0, 0, w, h);
		
		ctx.save();
		
		// move origin to the centre
		ctx.translate(w / 2, h / 2);
		// scale there
		ctx.scale(zoom, zoom);
		// move origin back
		ctx.translate(-w / 2, -h / 2);
		
		ctx.strokeStyle = "black";
		ctx.beginPath();
		ctx.moveTo(controlPoints[0], controlPoints[1]);
		ctx.bezierCurveTo(controlPoints[2], controlPoints[3], controlPoints[4], controlPoints[5], controlPoints[6], controlPoints[7]);
		ctx.stroke();
		
		ctx.strokeStyle = "lightGray";
		drawMidControlPoints(ctx, controlPoints);
		ctx.restore();
	}
	
	const drawMidControlPoints = (ctx, points) => {
		let p = position;
		let r = 1.0 - position;
		let mcps = []; // mid control points
		for (let i = 0; i < points.length; i+=2) {
			// draw a control points and line between it and the next one
			ctx.fillRect(points[i] - CPW / 2, points[i+1] - CPW / 2, CPW, CPW);
			// if this is not the last control point, 
			// draw a line between this and the next one
			// and interpolate a point on the line
			if (i < points.length-2) { 
				// draw the line
				ctx.beginPath();
				ctx.moveTo(points[i], points[i+1]);
				ctx.lineTo(points[i + 2], points[i + 3]);
				ctx.stroke();
				// interpolate the mid control point on the line
				mcps.push(p * points[i] + r * points[i + 2]);
				mcps.push(p * points[i+1] + r * points[i + 3]);
				// draw to interpolated control point
				ctx.fillRect(mcps[mcps.length-2] - CPW / 2, mcps[mcps.length-1] - CPW / 2, CPW, CPW);
			}
		}
		ctx.fillStyle = "gray";
		// if there are control points left to interpolate, do so recursively
		// else draw the final point
		if (mcps.length > 1) {
			drawMidControlPoints(ctx, mcps);
		} else {
			ctx.beginPath();
			ctx.ellipse(mcps[0] - 4, mcps[1] - 4, 8, 8, 0, 0, Math.PI*2);
			ctx.stroke();
		}
	}

	useEffect(() => {
		let ctx = canvasRef.current.getContext('2d');
		// save the current canvas transform so that we can go back to it
		ctx.save();
		drawBezier(ctx);
		ctx.restore();
	});
	
	return (
		<Box>
			<Box>
				<Typography className="heading" variant="h6">Bézier curve</Typography>
			</Box>
			<canvas
				width={600}
				height={600}
				ref={canvasRef}
				onMouseDown={pick}
				onMouseMove={move}
				onMouseUp={release}
			/>
			<Box style={{"width": 600}}>
				<FormControlLabel
					style={{"width": 600}}
					labelPlacement='bottom'
					label="Position"
					control={
					<Slider
						value={position*100}
						orientation="horizontal"
						valueLabelDisplay="auto"
						step={1}
						min={0}
						max={100}
						onChange={(event, value) => setPosition(value/100)}
				/>
				}>
				</FormControlLabel>
			</Box>
			<Box style={{"width": 600}}>
				<FormControlLabel
					style={{"width": 600}}
					labelPlacement='bottom'
					label="Zoom"
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
		</Box>
	);
}

export default App;
