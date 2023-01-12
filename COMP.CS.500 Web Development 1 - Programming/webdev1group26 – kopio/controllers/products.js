const responseUtils = require('../utils/responseUtils');
const Product = require('../models/product');
/**
 * Send all products as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @returns {void}
 */
const getAllProducts = async response => {
  // Get products
  const products = await Product.find({});
  return responseUtils.sendJson(response, products);
};

/**
 * Send product data as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} productId Id of the product to view
 * @returns {void}
 */
const viewProduct = async (response, productId) => {
  const viewedProduct = await Product.findById(productId).exec();
  // Successful product viewing
  if (viewedProduct !== null){
    return responseUtils.sendJson(response, viewedProduct);
  }
  // 404 Not Found if product to view not found
  else{
    return responseUtils.notFound(response);
  }
};

/**
 * Update product and send updated product as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} productId Id of the product to update
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @param {object} productData JSON data from request body
 * @returns {void}
 */
const updateProduct = async (response, productId, currentUser, productData) => {
  // 403 Forbidden if user is a customer.
  if (currentUser.role !== "admin"){
    return responseUtils.forbidden(response);
  }
  // 400 Bad Request if name is empty.
  else if (productData.name === ""){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // 400 Bad Request if price is invalid.
  else if (productData.price && isNaN(productData.price)){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // 400 Bad Request if price is 0 or negative
  else if (productData.price <= 0){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // Update product
  else{
    const updatedProduct = await Product.findById(productId).exec();
    // Successful product update
    if (updatedProduct !== null){
      // Update name if it exists in request
      if (productData.name){
        updatedProduct.name = productData.name;
      }
      // Update price if it exists in request
      if (productData.price){
        updatedProduct.price = productData.price;
      }
      // Update image if it exists in request
      if (productData.image){
        updatedProduct.image = productData.image;
      }
      // Update description if it exists in request
      if (productData.description){
        updatedProduct.description = productData.description;
      }
      await updatedProduct.save();
      return responseUtils.sendJson(response, updatedProduct);
    }
    // 404 Not Found if product to update not found
    else{
      return responseUtils.notFound(response);
    }
  }
};

/**
 * Delete product and send deleted product as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} productId Id of the product to delete
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @returns {void}
 */
const deleteProduct = async (response, productId, currentUser) => {
  const deletedProduct = await Product.findById(productId).exec();
  // 403 Forbidden if user is a customer.
  if (currentUser.role !== "admin"){
    return responseUtils.forbidden(response);
  }
  // Successful product deletion
  else if (deletedProduct !== null){
    await Product.deleteOne({ _id: productId });
    return responseUtils.sendJson(response, deletedProduct);
  }
  // 404 Not Found if product to delete not found
  else{
    return responseUtils.notFound(response);
  }
};

/**
 * Create a new product and send created product back as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {object} productData JSON data from request body
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @returns {void}
 */
const createProduct = async (response, productData, currentUser) => {
  // 403 Forbidden if user is a customer.
  if (currentUser.role !== "admin"){
    return responseUtils.forbidden(response);
  }
  // 400 Bad Request if product's name or price is missing
  else if (!productData.name || !productData.price){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  else{
    const newProduct = new Product(productData);
    await newProduct.save()
      // Successful product creation
      .then(() => {
        return responseUtils.createdResource(response, newProduct);
      })
      // 400 Bad Request in case of any possible mongoose schema validation errors
      .catch(() => {
        return responseUtils.badRequest(response, 'Bad Request');
      });
  }
};

module.exports = { getAllProducts, viewProduct, updateProduct, deleteProduct, createProduct };
