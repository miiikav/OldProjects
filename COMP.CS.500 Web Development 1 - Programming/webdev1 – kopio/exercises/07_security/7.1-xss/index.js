const http = require('http');
const url = require('url');

function sanitize(string) {
    const map = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#x27;',
        "/": '&#x2F;',
    };
    const reg = /[&<>"'/]/ig;
    return string.replace(reg, (match)=>(map[match]));
}

http.createServer((request, response) => {
    request.on('error', (err) => {
        console.error(err);
        response.statusCode = 400;
        response.end();
    });
    response.on('error', (err) => {
        console.error(err);
    });

    const queryObject = url.parse(request.url, true).query;
    queryObject.addThisText=sanitize(request.url);
    // TODO: sanitize the the 'addThisText' query parameter user input so that injected scripts won't run

    response.write(
        `   <!doctype html>
            <html lang="en">
            <head>
                <meta charset="utf-8">
                <title>XSS alert!</title>
            </head>
            <body>
                <p id="xss">Here be XSS!</p>
                ${queryObject['addThisText']}
            </body >
            </html >
    `);
    response.end();
}).listen(3000);
