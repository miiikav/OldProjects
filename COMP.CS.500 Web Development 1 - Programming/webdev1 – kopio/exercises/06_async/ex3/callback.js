

/**
 * TODO: write recursive function drawArrows that uses drawArrow in ../misc/draw.js
 * The first sentence should contain a termination condition that is bound to the
 * number of actors
 * 
 * @param {*} actors the array of actors, these label the vertical lines in the sequence diagram 
 * @param {*} timeout time for setTimeout.
 * @param {*} drawArrow a callback function that is passed as a parameter for drawArrows (but not for setTimeout)
 * It draws only one arrow, the f expression must be 'drawArrow'
 * @param {*} i the index, the nth arrow to be drawn, note that the sequence has to return from destination back to the source
 */
const drawArrows = (actors, timeout, drawArrow, i = 0) => {
    
    if((actors.length-1)+(actors.length-1)==i) {
        //console.log(actors.length+1);
        return actors.length;
    }
    
    else{
        //console.log("i"+i);
        //console.log("Test");
        setTimeout( function() {
            drawArrow(i,timeout,actors.length-1);
            i++;
            drawArrows(actors, timeout, drawArrow, i);
        }, timeout)
        //drawArrow(i,timeout,actors.length-1);
        //i++;
        //drawArrows(actors, timeout, drawArrow, i);
    }

}





/**
 * DO NOT TOUCH THIS: drawArrowSync is the utility function for sync.test.js
 * The test just checks the accuracy of drawing, this is done synchronously,
 * the functionality is just partial, do not use as a model above.
 * @param {*} actors the actors for the sequence diagram
 * @param {*} drawArrow a callback to draw an arrow
 */
const drawArrowsSync = (actors, drawArrow) => {
    actors.forEach((actor, index)=>drawArrow(index, -1, actors.length - 1));
}



/**
 * DO NOT TOUCH: Draws all, both actors and arrows, this function is for a browser use.
 * Makes UML seq diagram based on actors
 * @param {*} actors 
 * @param {*} timeout 
 */
const drawAll = (actors = ["mobile client", "router", "controller", "model", "mongoDB"], timeout=200) => {
    draw = getCanvasInBrowser();
    drawActors(actors);
    drawArrows(actors, timeout, drawArrow);
}

exports.drawArrows = drawArrows; //needed for testing, 'exports' causes "Uncaught ReferenceError: exports is not defined" that can be ignored
exports.drawArrowsSync = drawArrowsSync;  //needed for testing, 'exports' causes "Uncaught ReferenceError: exports is not defined" that can be ignored
