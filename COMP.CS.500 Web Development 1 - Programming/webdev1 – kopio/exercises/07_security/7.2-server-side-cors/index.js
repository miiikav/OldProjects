const http = require('http');
const port = 3000;

http.createServer((req, res) => {
    // Remove the line 'res.end();' below when you start your own development
    
    const headers = {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods" : "HEAD, GET, POST",
        "Access-Control-Max-Age" : "7200"
        /** TODO: add the required CORS headers */
    };
    //console.log(headers["Access-Control-Allow-Methods"].split(" ")[0]);
    //console.log(headers["Access-Control-Allow-Origin"]);
    //console.log(headers["Access-Control-Max-Age"]);
    //console.log(headers);



    //headers.append('Access-Control-Allow-Methods', 'GET','POST','HEAD');
    //headers.append('Access-Control-Max-Age', '7200');
    //res.addHeader("Access-Control-Allow-Origin", "*");
    //res.addHeader("Access-Control-Allow-Methods", "GET", "POST", "HEAD");
    //res.addHeader("Access-Control-Max-Age", "7200");
    // TODO: handle HEAD HTTP method, 
    // remember to add CORS headers to response
    //console.log(req.method);
    //console.log(req.headers.origin);
    if(req.headers.origin==undefined){
        res.writeHead(400,headers);
        res.write("Origin header not in the request");
        res.end();
    }
    else if (req.method.includes('HEAD')) {
        res.writeHead(200,headers);
        res.write("I was requested using CORS!");
        //res.addHeader(headers["Access-Control-Allow-Origin"]);
        //res.addHeader(headers["Access-Control-Max-Age"]);
        //res.addHeader(headers["Access-Control-Allow-Methods"].split(" ")[2]);
        res.end();


    }



    // TODO: handle GET and POST HTTP methods, 
    // remember to add CORS headers to response
    else if (req.method.includes('GET')) {

        res.writeHead(200,headers);
        res.write("I was requested using CORS!");
        //res.addHeader(headers["Access-Control-Allow-Origin"]);
        //res.addHeader(headers["Access-Control-Max-Age"]);
        //res.addHeader(headers["Access-Control-Allow-Methods"].split(" ")[0]);
        res.end();

    }
    else if (req.method.includes('POST')) {
        res.writeHead(200,headers);
        res.write("I was requested using CORS!");
        //res.addHeader(headers["Access-Control-Allow-Origin"]);
        //res.addHeader(headers["Access-Control-Max-Age"]);
        //res.addHeader(headers["Access-Control-Allow-Methods"].split(" ")[1]);
        res.end();

    }

    // TODO: handle HTTP methods that are not allowed, 
    // remember to add CORS headers to response
    else{
        res.writeHead(405,headers);
        //res.addHeader(headers["Access-Control-Allow-Origin"]);
        //res.addHeader(headers["Access-Control-Max-Age"]);
        //res.addHeader(headers["Access-Control-Allow-Methods"]);
        res.write("Request used a HTTP method which is not allowed.");
        res.end();

    }

//res.end();
}).listen(port);