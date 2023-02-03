import React from 'react';
import Box from '@material-ui/core/Box';
import './SlidingBlock.css';

function SlidingBlock(props) {
	const index = props.x+3*props.y;
	return (
			<Box key={"blockBox_" + index}>
				<img 
					key={"block_" + (props.x+3*props.y)} 
					onClick={(event) => {props.onClick(event, index)}} 
					src={props.imageSrc} 
					alt={"sliding puzzle block " + props.x + ", " + props.y}
					className="animatedBlock"
					style={{"opacity": (props.emptyBlock?0.1:1.0), "position": "absolute", "width": 125, "height": 125, "top": props.y*130, "left": props.x*130}} 
				/>
			</Box>	);
}

export default SlidingBlock;
