var http = require('http');
var fs = require('fs');


fs.readFile('./index.html', function (err, html) {
    if (err) {
        throw err; 
    }      
var server = http.createServer(function(req, res){
        console.log('request was made' + req.url);
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(html);
        res.end();  
    }).listen(3000);
});
console.log('listen 3000');