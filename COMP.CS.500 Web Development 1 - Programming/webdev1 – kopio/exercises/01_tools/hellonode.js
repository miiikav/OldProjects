const _ = require("lodash");
const ver = _.VERSION;
console.log(ver);


function hellonode(array) {
	let fel = _.first(array);
	let lel = _.last(array);
	return fel + ' ' + lel;
}

module.exports = hellonode