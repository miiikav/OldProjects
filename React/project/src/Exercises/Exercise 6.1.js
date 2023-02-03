import React, {useRef, useEffect} from 'react';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

function App() {
	const [canvasSize, setCanvasSize] = React.useState([window.innerWidth, window.innerHeight]);
	const [mousePos, setMousePos] = React.useState(null);
	const [printMode, setPrintMode] = React.useState(false);
	const currentDate = new Date().toISOString();
	const weekdayNum = new Date().getDay();
	const dayNum = new Date().getDate();
	const monthNum = new Date().getMonth();
	const year = new Date().getFullYear();
	const [weekday, setWeekday] = React.useState("");
	const [month, setMonth] = React.useState("");
	const updateWeekday = (event) => {
		switch (weekdayNum) {
			case 0:
				setWeekday("Sunday");
				break;
			case 1:
				setWeekday("Monday");
				break;
			case 2:
				setWeekday("Tuesday");
				break;
			case 3:
				setWeekday("Wednesday");
				break;
			case 4:
				setWeekday("Thursday");
				break;
			case 5:
				setWeekday("Friday");
				break;
			case 6:
				setWeekday("Saturday");
				break;
			default:
				setWeekday("Error");
			}
	}
	const updateMonth = (event) => {
		switch (monthNum) {
			case 0:
				setMonth("January");
				break;
			case 1:
				setMonth("Febuary");
				break;
			case 2:
				setMonth("March");
				break;
			case 3:
				setMonth("April");
				break;
			case 4:
				setMonth("May");
				break;
			case 5:
				setMonth("June");
				break;
			case 6:
				setMonth("July");
				break;
			case 7:
				setMonth("August");
				break;
			case 8:
				setMonth("September");
				break;
			case 9:
				setMonth("October");
				break;
			case 10:
				setMonth("November");
				break;
			case 11:
				setMonth("December");
				break;
			default:
				setMonth("Error");
			}
	}
	//console.log(currentDate);
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
		//ctx.save();
		
		
		// distance in x dimension (horizontal)
		
		// distance in y dimension (vertical)
		// angle

		//draw eye
		// Wall
		ctx.strokeRect(75, 140, 150, 110);

		// Door
		ctx.fillRect(130, 190, 40, 60);

		// Roof
		ctx.beginPath();
		ctx.moveTo(50, 140);
		ctx.lineTo(150, 60);
		ctx.lineTo(250, 140);
		ctx.closePath();
		ctx.stroke();
		// Wall
		ctx.strokeRect(75*2, 140*2, 150*2, 110*2);

		// Door
		ctx.fillRect(130*2, 190*2, 40*2, 60*2);

		// Roof
		ctx.beginPath();
		ctx.moveTo(50*2, 140*2);
		ctx.lineTo(150*2, 60*2);
		ctx.lineTo(250*2, 140*2);
		ctx.closePath();
		ctx.stroke();
		// Wall
		ctx.strokeRect(395, 140, 150, 110);

		// Door
		ctx.fillRect(450, 190, 40, 60);

		// Roof
		ctx.beginPath();
		ctx.moveTo(370, 140);
		ctx.lineTo(465, 60);
		ctx.lineTo(570, 140);
		ctx.closePath();
		ctx.stroke();
		
		//weekday
		updateWeekday(weekdayNum);
		updateMonth(monthNum);
		ctx.font = 'bold 25px serif';
		ctx.strokeText(weekday,w-240, h-90);
		//daynum
		ctx.font = 'bold 40px serif';
		ctx.strokeText(dayNum,w-215, h-55);
		//month
		ctx.font = 'bold 25px serif';
		ctx.strokeText(month,w-225, h-32);
		//year
		ctx.font = 'bold 25px serif';
		ctx.strokeText(year,w-218, h-5);
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
				//onMouseMove={updateWeekday}
				//onMouseMove={updateMonth}
				style={{"cursor": "none", "zIndex": 1, "position": "fixed"}}
			/>
		</Box>
	);
}

export default App;
