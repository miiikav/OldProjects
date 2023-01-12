var http = require('http');
 
http.createServer(function(request,response){
 
 response.writeHead(200);
 
request.on('data',function(message){
 
 response.write(message);
 
 });
 
 request.on('end',function(){
 
 response.end();
 });
 }).listen(3000);
console.log('listen 3000');