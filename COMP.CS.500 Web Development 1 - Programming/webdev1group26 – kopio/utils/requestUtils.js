/**
 * Decode, parse and return user credentials (username and password)
 * from the Authorization header.
 *
 * @param {http.incomingMessage} request Client's request to server
 * @returns {Array|null} [username, password] or null if header is missing
 */
const getCredentials = request => {
  // TODO: 8.4 Parse user credentials from the "Authorization" request header
  // NOTE: The header is base64 encoded as required by the http standard.
  //       You need to first decode the header back to its original form ("email:password").
  //  See: https://attacomsian.com/blog/nodejs-base64-encode-decode
  //       https://stackabuse.com/encoding-and-decoding-base64-strings-in-node-js/
  const headers = request.headers['authorization'];
  // RegExp for checking if given string is Base64 encoded
  const base64Matcher = new RegExp("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{4})$");
  if (headers){
      const splitHeaders = headers.split(" ");
      const authorizationType = splitHeaders[0];
      // Base64 encoded string (hopefully)
      const credentials = splitHeaders[1];
      if (authorizationType !== "Basic"){
        return null;
      }
      // Check if Base64 encoded
      else if (base64Matcher.test(credentials) === false){
        return null;
      }
      else{
        // create a buffer
        const buff = Buffer.from(credentials, 'base64');
        // decode buffer as UTF-8
        const decodedCredentials = buff.toString('utf-8');
        // Parsed credentials in an array
        const splitDecodedCredentials = decodedCredentials.split(":");
        return splitDecodedCredentials;
      }
  }
  // Authorization header does not exist or is an empty string ""
  else{
    return null;
  }
};

/**
 * Does the client accept JSON responses?
 *
 * @param {http.incomingMessage} request Client's request to server
 * @returns {boolean} true/false if client accepts JSON responses or not
 */
const acceptsJson = request => {
  // TODO: 8.3 Check if the client accepts JSON as a response based on "Accept" request header
  // NOTE: "Accept" header format allows several comma separated values simultaneously
  // as in "text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8"
  // Do not rely on the header value containing only single content type!
  const headers = request.headers['accept'];
  if (headers){
    if (headers.includes('application/json') || headers.includes('*/*')){
      return true;
    }
    else{
      return false;
    }
  }
  else{
    return false;
  }
};

/**
 * Is the client request content type JSON?
 *
 * @param {http.incomingMessage} request Client's request to server
 * @returns {boolean} true/false if client's request content type is JSON or not
 */
const isJson = request => {
  // TODO: 8.3 Check whether request "Content-Type" is JSON or not
  const headers = request.headers['content-type'];
  if (headers){
    if (headers === 'application/json'){
      return true;
    }
    else{
      return false;
    }
  }
  // Content-Type header does not exist or is an empty string ""
  else{
    return false;
  }
};

/**
 * Asynchronously parse request body to JSON
 *
 * Remember that an async function always returns a Promise which
 * needs to be awaited or handled with then() as in:
 *
 *   const json = await parseBodyJson(request);
 *
 *   -- OR --
 *
 *   parseBodyJson(request).then(json => {
 *     // Do something with the json
 *   })
 *
 * @param {http.IncomingMessage} request Client's request to server
 * @returns {Promise<*>} Promise resolves to JSON content of the body
 */
const parseBodyJson = request => {
  return new Promise((resolve, reject) => {
    let body = '';

    request.on('error', err => reject(err));

    request.on('data', chunk => {
      body += chunk.toString();
    });

    request.on('end', () => {
      resolve(JSON.parse(body));
    });
  });
};

module.exports = { acceptsJson, getCredentials, isJson, parseBodyJson };
