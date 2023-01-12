const responseUtils = require('../utils/responseUtils');
const Order = require('../models/order');

/**
 * Send all orders as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @returns {void}
 */
const getAllOrders = async (response, currentUser) => {
    let orders;
    // Get all orders as admin
    if (currentUser.role === "admin"){
        orders = await Order.find({});
    }
    // Get customer's own orders as customer
    else{
        const id = currentUser._id;
        orders = await Order.find({ customerId: id});
    }
    return responseUtils.sendJson(response, orders);
  };

/**
 * Send order data as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} orderId Id of the order to be viewed
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @returns {void}
 */
const viewOrder = async (response, orderId, currentUser) => {
    const viewedOrder = await Order.findById(orderId).exec();
    // Successful order viewing
    if (viewedOrder !== null){
        // Return any order as admin
        if (currentUser.role === "admin"){
            return responseUtils.sendJson(response, viewedOrder);
        }
        // Return only customer's own order as customer
        else{
            // Successfully return customer's own order info
            if (String(viewedOrder.customerId) === String(currentUser._id)){
                return responseUtils.sendJson(response, viewedOrder);
            }
            // 404 Not Found if customer is trying to view someone else's order
            else{
                return responseUtils.notFound(response);
            }
        }
    }
    // 404 Not Found if order to view not found
    else{
      return responseUtils.notFound(response);
    }
  };

/**
 * Create a new order and send created order back as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {object} orderData JSON data from request body
 * @param {object} currentUser Currently authenticated user (mongoose document object)
 * @returns {void}
 */
const createOrder = async (response, orderData, currentUser) => {
    // 403 Forbidden if user is a admin.
    if (currentUser.role !== "customer"){
        return responseUtils.forbidden(response);
    }
    // 400 Bad Request if order items is empty
    else if (orderData.items.length === 0){
        return responseUtils.badRequest(response, 'Bad Request');
    }
    else{
        // Set mandatory customerId attribute for orderData, current user's id used here
        orderData.customerId = currentUser._id;
        const newOrder = new Order(orderData);
        await newOrder.save()
            // Successful order creation
            .then(() => {
                return responseUtils.createdResource(response, newOrder);
            })
            // 400 Bad Request in case of any possible mongoose schema validation errors
            .catch(() => {
                return responseUtils.badRequest(response, 'Bad Request');
            });
    }
  };

  module.exports = { createOrder, getAllOrders, viewOrder };