import React, {useRef, useEffect} from 'react';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

function App() {
	const [canvasSize, setCanvasSize] = React.useState([window.innerWidth, window.innerHeight]);
	const [mousePos, setMousePos] = React.useState(null);
	const [printMode, setPrintMode] = React.useState(false);

	// reference to canvas element, in JSX content
	// there is ref={canvasRef} which causes that
	// element to be stored here
	const canvasRef = useRef(null);
	
	// NOTE: Safari doesn't support following 2 events, 
	// see MDN for more information and how to support Safari
	// https://developer.mozilla.org/en-US/docs/Web/API/WindowEventHandlers/onbeforeprint
	window.onbeforeprint = (event) => {
		setPrintMode(true);
	}
	
	window.onafterprint = (event) => {
		setPrintMode(false);
	}
	
	window.onresize = (event) => {
		// always keep canvas the same size as the window
		setCanvasSize([window.innerWidth, window.innerHeight]);
	}
	
	const setMouseCoordinates = (event) => {
		setMousePos({x: event.clientX, y: event.clientY});
	}
	
	const drawDistance = (ctx, distance) => {
		ctx.textBaseline = "middle";
		let distanceString = " " + distance + " ";
		let textMetrics = ctx.measureText(distanceString);
		let textStart = (distance-textMetrics.width)/2;
		let textEnd = textStart + textMetrics.width;
		ctx.beginPath();
		ctx.moveTo(0, 0);
		ctx.lineTo(textStart, 0);
		ctx.moveTo(textEnd, 0);
		ctx.lineTo(distance, 0);
		ctx.stroke();
		ctx.fillText(distanceString, textStart, 0);
	}

	const drawCross = (ctx, x, y) => {
		ctx.beginPath();
		ctx.moveTo(x-10, y);
		ctx.lineTo(x+10, y);
		ctx.moveTo(x, y-10);
		ctx.lineTo(x, y+10);
		ctx.stroke();
	}
	
	useEffect(() => {
		// this is called every time the UI has updated
		// when this is executed the first time, the canvas has been created
		let ctx = canvasRef.current.getContext('2d');
		if (mousePos === null)
			return;
		// width an height are used in various places, store them in these variables to shorten the following code
		let [w, h] = [canvasRef.current.width, canvasRef.current.height];
		// clear canvas
		if (printMode) {
			ctx.clearRect(0, 0, w, h);
			ctx.strokeStyle = "black";
			ctx.fillStyle = "black";
		} else {
			ctx.fillStyle = "#2E3561";
			ctx.fillRect(0, 0, w, h);
			ctx.strokeStyle = "white";
			ctx.fillStyle = "white";
		}
		
		// save the current canvas transform so that we can go back to it
		ctx.save();
		
		// cursor
		ctx.lineWidth = 2.0;
		if (printMode) {
			ctx.strokeStyle = "black";
			ctx.shadowColor = "gray";
		} else {
			ctx.strokeStyle = "white";
			ctx.shadowColor = "lightGray";
		}
		ctx.shadowBlur = 3;
		ctx.shadowOffsetX = 4;
		ctx.shadowOffsetY = 4;
		drawCross(ctx, mousePos.x, mousePos.y);
		ctx.lineWidth = 1.0;
		ctx.restore();
		
		// calculate the angle from the center to the mouse point, value is in radians as are all values to and from Math trigonometric functions
		let angle = Math.atan2(mousePos.y-h/2, mousePos.x-w/2);
		
		ctx.save();
		ctx.strokeStyle = "gray";
		// distance of the mouse from center displayed
		// doing different transform so that text is always upright (or vertical in worst case)
		if (Math.abs(angle) < Math.PI/2) {
			ctx.translate(w/2, h/2);
			ctx.rotate(angle);
		} else {
			ctx.translate(mousePos.x, mousePos.y);
			ctx.rotate(angle+Math.PI);
		}
		drawDistance(ctx, Math.round(Math.hypot(mousePos.y-h/2, mousePos.x-w/2)));
		ctx.restore();
		
		// distance in x dimension (horizontal)
		
		// distance in y dimension (vertical)
		// angle

		//draw eye
		ctx.save();
		ctx.translate(w/2-15,h/2);
		//ctx.moveTo(700, 500);
		//ctx.translate(mousePos.x, Math.max(h/2, mousePos.y));
		ctx.rotate(angle);
		ctx.beginPath();
		ctx.arc(0, 0, 20 / 2, 0, Math.PI * 2);
		ctx.stroke();
		ctx.beginPath();
		ctx.arc(20 * 0.4, 0, 20 * 0.1, 0, Math.PI * 2);
		ctx.fill();
		ctx.restore();
		//draw eye2
		ctx.save();
		//ctx.translate(Math.min(w/2, mousePos.x), h/2);
		ctx.translate(w/2+15,h/2);
		ctx.rotate(angle);
		ctx.beginPath();
		ctx.arc(0, 0, 20 / 2, 0, Math.PI * 2);
		ctx.stroke();
		ctx.beginPath();
		ctx.arc(20 * 0.4, 0, 20 * 0.1, 0, Math.PI * 2);
		ctx.fill();
		ctx.restore();
		//draw face
		ctx.save();
		ctx.translate(w/2,h/2);
		ctx.beginPath();
		ctx.arc(0, 0, 150 / 2, 0, Math.PI * 2);
		ctx.stroke();
		ctx.beginPath();
		ctx.arc(30 * 0.20, 50, 80 * 0.4, 10, Math.PI * 0.1);
		ctx.fill();
		ctx.restore();
	});
	// the jsx include fixed positions and z-index definitions 
	// to put canvas and Typography on top of each other
	return (
		<Box>
			<Box style={{"zIndex": 2, "position": "fixed"}} display="block" displayPrint="none">
				<Typography className="heading" variant="h6">Mouse position on canvas 
					{mousePos?
						(" ("+mousePos.x +","+mousePos.y+") "):
						" "}  
					 visualized
				</Typography>
			</Box>
			<canvas
				width={canvasSize[0]}
				height={canvasSize[1]}
				ref={canvasRef}
				onMouseMove={setMouseCoordinates}
				style={{"cursor": "none", "zIndex": 1, "position": "fixed"}}
			/>
		</Box>
	);
}

export default App;
