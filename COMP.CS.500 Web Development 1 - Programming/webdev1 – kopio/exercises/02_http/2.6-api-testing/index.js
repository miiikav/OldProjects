var http = require('http');
var fs = require('fs');

module.exports = http.createServer((request, response) => {
  request.on('error', (err) => {
    console.error(err);
    response.statusCode = 400;
    response.end();
  });
  response.on('error', (err) => {
    console.error(err);
  });
  if (request.url === '/classical') {

    fs.readFile('./homer.html', function (err, txt) {
        if (err) {
            throw err; 
        }
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(txt);
        response.end(); 
    });
}
  else if (request.url === '/modern') {
    fs.readFile('./bradbury.html', function (err, txt) {
        if (err) {
            throw err; 
        }
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(txt);
        response.end(); 
    });
}
  else if (request.url === '/') {
    fs.readFile('./index.html ', function (err, txt) {
        if (err) {
            throw err; 
        }
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(txt);
        response.end(); 
    });
}
   else {
    response.statusCode = 404;
    response.statusMessage = 'Requested content not found';
    response.end();
  }
}).listen(3000);
console.log('listen 3000');
