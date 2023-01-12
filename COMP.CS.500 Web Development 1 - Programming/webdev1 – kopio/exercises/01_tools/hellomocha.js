function hellomocha() {
    console.log("Hello Mocha!")
}


hellomocha();


/**
 * Here we have grade() function that will be mocha tested.
 * The test reside in file test/mocha.test.js.
 * Some of the tests pass gracefully, a few of them fail. 
 * 
 * Examine the tests, and fix grade() function accordingly,
 * so that all the tests will pass.
 *
 * The grading is done piece-by-piece, points are incremented if test is OK
 * The first test checks that maxPoint is an even number
 * The second test check that the answer is string
 * The rest checks the right format of the string
 * 
 * TODO: there is currently something wrong with the function
 * 
 * @param answer the string to be tested
 * @param maxPoints the maximum points that can be reached.
 * 
 * @return received points that can range 0..maxPoints
 */
module.exports = {
    grade(answer, maxPoints) {
        let points = 0;

        if (!Number.isInteger(maxPoints) || maxPoints < 2 || maxPoints % 2 !== 0) {
            // maxPoints must be an even positive integer
            // since it's divided by 2 below
            return points;
        }

        if (typeof answer !== 'string') {
            return points;
        }

        answer = answer.toLowerCase();
		
        if (answer.includes('mocha')) {
			if (answer.includes('hello')) {
				points += maxPoints;
			}
			else{
				points += maxPoints / 2;
			}
        }
        else if (answer.includes('hello')) {
			points += maxPoints / 2;
        }
        if (answer.includes('plussa')) {
            points += maxPoints / 2;
        }

        return points;
    }
};
