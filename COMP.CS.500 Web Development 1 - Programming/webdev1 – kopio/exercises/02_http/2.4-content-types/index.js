var http = require('http');
var fs = require('fs');

var server = http.createServer(function(req, res){
        console.log('request was made' + req.url);
        console.log(req.headers['accept']);
        if(req.headers['accept'].includes('*/*')){
            fs.readFile('./data.txt', function (err, txt) {
                if (err) {
                    throw err; 
                }
                res.writeHead(200, {'Content-Type': 'text/plain'});
                res.write(txt);
                res.end(); 
            });
        }
        else if(req.headers['accept'].includes('text/plain')){
            fs.readFile('./data.txt', function (err, txt) {
                if (err) {
                    throw err; 
                }
                res.writeHead(200, {'Content-Type': 'text/plain'});
                res.write(txt);
                res.end(); 
            });
        }
        else if(req.headers['accept'].includes('application/json')){
            fs.readFile('./data.json', function (err, json) {
                if (err) {
                    throw err; 
                }
                res.writeHead(200, {'Content-Type': 'application/json'});
                res.write(json);
                res.end(); 
            
            });
        }
        else if(req.headers['accept'].includes('application/xml')){
            fs.readFile('./data.xml', function (err, xml) {
                if (err) {
                    throw err; 
                }
                res.writeHead(200, {'Content-Type': 'application/xml'});
                res.write(xml);
                res.end(); 
            });
        }
        else{
            res.writeHead(406, {'Content-Type': 'text/html'});
            res.statusMessage = 'Content type not available';
            res.end(); 
        }
    }).listen(3000);
console.log('listen 3000');