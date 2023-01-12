var http = require('http');

var server = http.createServer(function(req, res) {
    const { headers, method, url } = req;
    let body = [];
    req.on('data', (chunk) => {
        body.push(chunk);
    }).on('end', () => {
        body = Buffer.concat(body).toString();
        // at this point, `body` has the entire request body stored in it as a string
        res.on('error', (err) => {
            console.error(err);
    });
        console.log('request was made' + req.url);
        res.writeHead(200, {'Content-Type': 'text/plain'});
        const responseBody = { headers, method, url, body };
        res.write(JSON.stringify(responseBody));
        res.end('\'All together now!\''); 
    });

}).listen(3000);
console.log('listen 3000');