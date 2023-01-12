

/**
 * TODO: drawArrows uses recursion, but this time
 * with Promise, resolve() and setTimeout()
 * 
 * @param {*} actors the actors to be drawn
 * @param {*} timeout time for setTimeot
 * @param {*} drawArrow the callback for drawing a single array
 * @param {*} i the index of an array
 */
async function drawArrows(actors, timeout, drawArrow, i=0) { 
    return new Promise(function(resolve) {
        if((actors.length-1)+(actors.length-1)==i) { 
            //console.log(actors.length+1);
            resolve(actors.length);
        }
        else{
            setTimeout( function() {
                drawArrow(i,timeout,actors.length-1);
                i++;
                resolve(drawArrows(actors, timeout, drawArrow, i));
            }, timeout)
            //console.log("i"+i);
            //console.log("Test");
        }
    });

};



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
