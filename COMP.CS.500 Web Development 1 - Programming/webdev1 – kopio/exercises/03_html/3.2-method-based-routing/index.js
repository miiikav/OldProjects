var http = require('http');
var fs = require('fs');

http.createServer((request, response) => {
  request.on('error', (err) => {
    console.error(err);
    response.statusCode = 400;
    response.end();
  });
  response.on('error', (err) => {
    console.error(err);
  });
  console.log(request.method);
  if (request.method.includes('GET')) {

    fs.readFile('./get.html', function (err, txt) {
        if (err) {
            throw err; 
        }
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(txt);
        response.end(); 
    });
}
  else if (request.method.includes('POST')) {
    fs.readFile('./post.html', function (err, txt) {
        if (err) {
            throw err; 
        }
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(txt);
        response.end(); 
    });
}
   else {
    response.writeHead(405, { Allow: "GET, POST"});
    response.end();
  }
}).listen(3000);
console.log('listen 3000');
