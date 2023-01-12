var http = require('http');

var server = http.createServer(function(req, res){
        console.log('request was made' + req.url);
        res.writeHead(200, {'Content-Type': 'text/plain'});
        var stringHeaders = JSON.stringify(req.headers);
        res.write(stringHeaders);
        res.end();  
    }).listen(3000);
console.log('listen 3000');