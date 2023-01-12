const responseUtils = require('./utils/responseUtils');
const { acceptsJson, isJson, parseBodyJson } = require('./utils/requestUtils');
const { renderPublic } = require('./utils/render');
const { getCurrentUser } = require('./auth/auth');
const { getAllProducts, viewProduct, updateProduct, deleteProduct, createProduct } = require('./controllers/products');
const { getAllUsers, viewUser, deleteUser, updateUser, registerUser } = require('./controllers/users');
const { createOrder, getAllOrders, viewOrder } = require('./controllers/orders');


/**
 * Known API routes and their allowed methods
 *
 * Used to check allowed methods and also to send correct header value
 * in response to an OPTIONS request by sendOptions() (Access-Control-Allow-Methods)
 */
const allowedMethods = {
  '/api/register': ['POST'],
  '/api/users': ['GET'],
  '/api/products': ['GET', 'POST'],
  '/api/orders': ['GET', 'POST']
};

/**
 * Send response to client options request.
 *
 * @param {string} filePath pathname of the request URL
 * @param {http.ServerResponse} response Server response
 * @returns {void} returns void
 */
const sendOptions = (filePath, response) => {
  if (filePath in allowedMethods) {
    response.writeHead(204, {
      'Access-Control-Allow-Methods': allowedMethods[filePath].join(','),
      'Access-Control-Allow-Headers': 'Content-Type,Accept',
      'Access-Control-Max-Age': '86400',
      'Access-Control-Expose-Headers': 'Content-Type,Accept'
    });
    return response.end();
  }

  return responseUtils.notFound(response);
};

/**
 * Does the url have an ID component as its last part? (e.g. /api/users/dsf7844e)
 *
 * @param {string} url filePath
 * @param {string} prefix API endpoint (eg. 'users', 'products', 'orders')
 * @returns {boolean} true/false if url matches an id route (eg. 'api/users/someidhere')
 */
const matchIdRoute = (url, prefix) => {
  const idPattern = '[0-9a-z]{8,24}';
  const regex = new RegExp(`^(/api)?/${prefix}/${idPattern}$`);
  return regex.test(url);
};

/**
 * Does the URL match /api/users/{id}
 *
 * @param {string} url filePath
 * @returns {boolean} true/false if url matches users id route ('api/users/someidhere')
 */
const matchUserId = url => {
  return matchIdRoute(url, 'users');
};

/**
 * Does the URL match /api/products/{id}
 *
 * @param {string} url filePath
 * @returns {boolean} true/false if url matches products id route ('api/products/someidhere')
 */
const matchProductId = url => {
  return matchIdRoute(url, 'products');
};

/**
 * Does the URL match /api/orders/{id}
 *
 * @param {string} url filePath
 * @returns {boolean} true/false if url matches orders id route ('api/orders/someidhere')
 */
const matchOrderId = url => {
  return matchIdRoute(url, 'orders');
};

const handleRequest = async (request, response) => {
  const { url, method, headers } = request;
  const filePath = new URL(url, `http://${headers.host}`).pathname;

  // serve static files from public/ and return immediately
  if (method.toUpperCase() === 'GET' && !filePath.startsWith('/api')) {
    const fileName = filePath === '/' || filePath === '' ? 'index.html' : filePath;
    return renderPublic(fileName, response);
  }

  if (matchUserId(filePath)) {
    // TODO: 8.5 Implement view, update and delete a single user by ID (GET, PUT, DELETE)
    // You can use parseBodyJson(request) from utils/requestUtils.js to parse request body
    if (method.toUpperCase() === 'GET' || method.toUpperCase() === 'PUT' || method.toUpperCase() === 'DELETE'){
      const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      // 403 Forbidden if valid user doesn't have admin role
      else if (currentUser.role !== "admin"){
        return responseUtils.forbidden(response);
      }
      // Require a correct accept header (require 'application/json' or '*/*')
      else if (!acceptsJson(request)) {
        return responseUtils.contentTypeNotAcceptable(response);
      }
      else{
        // User's ID in filepath
        const filePathSplit = filePath.split("/");
        const filePathUserId = filePathSplit[filePathSplit.length - 1];
        // View a single user by ID
        if (method.toUpperCase() === 'GET'){
          await viewUser(response, filePathUserId);
        }
        // Update a single user by ID
        else if (method.toUpperCase() === 'PUT'){
          const requestBody = await parseBodyJson(request);
          await updateUser(response, filePathUserId, currentUser, requestBody);
        }
        // Delete a single user by ID
        else{
          await deleteUser(response, filePathUserId, currentUser);
        }
      }
    }
  }

  // Viewing, updating and deleting a product
  if (matchProductId(filePath)) {
    if (method.toUpperCase() === 'GET' || method.toUpperCase() === 'PUT' || method.toUpperCase() === 'DELETE'){
      const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      // Require a correct accept header (require 'application/json' or '*/*')
      else if (!acceptsJson(request)) {
        return responseUtils.contentTypeNotAcceptable(response);
      }
      else{
        // Product's ID in filepath
        const filePathSplit = filePath.split("/");
        const filePathProductId = filePathSplit[filePathSplit.length - 1];
        // View a single product by ID
        if (method.toUpperCase() === 'GET'){
          await viewProduct(response, filePathProductId);
        }
        // Update a single product by ID
        else if (method.toUpperCase() === 'PUT'){
          const requestBody = await parseBodyJson(request);
          await updateProduct(response, filePathProductId, currentUser, requestBody);
        }
        // Delete a single product by ID
        else{
          await deleteProduct(response, filePathProductId, currentUser);
        }
      }
    }
  }

  // Viewing a single order
  if (matchOrderId(filePath)) {
    if (method.toUpperCase() === 'GET'){
      const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      // Require a correct accept header (require 'application/json' or '*/*')
      else if (!acceptsJson(request)) {
        return responseUtils.contentTypeNotAcceptable(response);
      }
      else{
        // Orders's ID in filepath
        const filePathSplit = filePath.split("/");
        const filePathOrderId = filePathSplit[filePathSplit.length - 1];
        // View a single product by ID
        await viewOrder(response, filePathOrderId, currentUser);
      }
    }
  }

  // Default to 404 Not Found if unknown url
  if (!(filePath in allowedMethods)) return responseUtils.notFound(response);

  // See: http://restcookbook.com/HTTP%20Methods/options/
  if (method.toUpperCase() === 'OPTIONS') return sendOptions(filePath, response);

  // Check for allowable methods
  if (!allowedMethods[filePath].includes(method.toUpperCase())) {
    return responseUtils.methodNotAllowed(response);
  }

  // Require a correct accept header (require 'application/json' or '*/*')
  if (!acceptsJson(request)) {
    return responseUtils.contentTypeNotAcceptable(response);
  }

  // GET all users
  if (filePath === '/api/users' && method.toUpperCase() === 'GET') {
    // TODO: 8.4 Add authentication (only allowed to users with role "admin")
    const currentUser = await getCurrentUser(request);
    if (currentUser === null){
      return responseUtils.basicAuthChallenge(response);
    }
    // 403 Forbidden if valid user doesn't have admin role
    else if (currentUser.role !== "admin"){
      return responseUtils.forbidden(response);
    }
    // TODO: 8.3 Return all users as JSON
    else{
      await getAllUsers(response);
    }
  }

  // register new user
  if (filePath === '/api/register' && method.toUpperCase() === 'POST') {
    // Fail if not a JSON request
    if (!isJson(request)) {
      return responseUtils.badRequest(response, 'Invalid Content-Type. Expected application/json');
    }
    // TODO: 8.3 Implement registration
    // You can use parseBodyJson(request) from utils/requestUtils.js to parse request body
    else{
      const requestBody = await parseBodyJson(request);
      await registerUser(response, requestBody);
    }
  }

  // GET all products
  if (filePath === '/api/products' && method.toUpperCase() === 'GET'){
    const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      else{
        await getAllProducts(response);
      }
  }

  // Create a new product
  if (filePath === '/api/products' && method.toUpperCase() === 'POST'){
    // Fail if not a JSON request
    if (!isJson(request)) {
      return responseUtils.badRequest(response, 'Invalid Content-Type. Expected application/json');
    }
    // Require a correct accept header (require 'application/json' or '*/*')
    else if (!acceptsJson(request)) {
      return responseUtils.contentTypeNotAcceptable(response);
    }
    else{
      const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      else{
        const requestBody = await parseBodyJson(request);
        await createProduct(response, requestBody, currentUser);
      }
    }
  }

  // GET all orders
  if (filePath === '/api/orders' && method.toUpperCase() === 'GET'){
    const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      else{
        await getAllOrders(response, currentUser);
      }
  }

  // Create a new order
  if (filePath === '/api/orders' && method.toUpperCase() === 'POST'){
    // Fail if not a JSON request
    if (!isJson(request)) {
      return responseUtils.badRequest(response, 'Invalid Content-Type. Expected application/json');
    }
    // Require a correct accept header (require 'application/json' or '*/*')
    else if (!acceptsJson(request)) {
      return responseUtils.contentTypeNotAcceptable(response);
    }
    else{
      const currentUser = await getCurrentUser(request);
      if (currentUser === null){
        return responseUtils.basicAuthChallenge(response);
      }
      else{
        const requestBody = await parseBodyJson(request);
        await createOrder(response, requestBody, currentUser);
      }
    }
  }

};

module.exports = { handleRequest };
