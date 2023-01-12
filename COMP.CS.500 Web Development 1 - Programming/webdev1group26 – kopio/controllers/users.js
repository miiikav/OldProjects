const responseUtils = require('../utils/responseUtils');
const User = require('../models/user');
/**
 * Send all users as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @returns {void}
 */
const getAllUsers = async response => {
  // TODO: 10.1 Implement this
  const users = await User.find({});
  return responseUtils.sendJson(response, users);
};

/**
 * Delete user and send deleted user as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} userId Id of the user to delete
 * @param {object} currentUser (mongoose document object)
 * @returns {void}
 */
const deleteUser = async (response, userId, currentUser) => {
  // TODO: 10.1 Implement this
  const deletedUser = await User.findById(userId).exec();
  // 400 Bad Request if trying to delete self
  if (userId === currentUser.id){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // Successful user deletion
  else if (deletedUser !== null){
    await User.deleteOne({ _id: userId });
    return responseUtils.sendJson(response, deletedUser);
  }
  // 404 Not Found if user to delete not found
  else{
    return responseUtils.notFound(response);
  }
};

/**
 * Update user and send updated user as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} userId Id of the user to update
 * @param {object} currentUser (mongoose document object)
 * @param {object} userData JSON data from request body
 * @returns {void}
 */
const updateUser = async (response, userId, currentUser, userData) => {
  // TODO: 10.1 Implement this
  // 400 Bad Request if trying to update own role
  if (userId === currentUser.id){
    return responseUtils.badRequest(response, 'Updating own data is not allowed');
  }
  // 400 Bad Request if role is missing
  else if (!userData.role){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // 400 Bad Request if role is not valid
  else if (userData.role !== "admin" && userData.role !== "customer"){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // Update user's role
  else{
    const updatedUser = await User.findById(userId).exec();
    // Successful user update
    if (updatedUser !== null){
      updatedUser.role = userData.role;
      await updatedUser.save();
      return responseUtils.sendJson(response, updatedUser);
    }
    // 404 Not Found if user to update not found
    else{
      return responseUtils.notFound(response);
    }
  }
};

/**
 * Send user data as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {string} userId Id of the user to view
 * @returns {void}
 */
const viewUser = async (response, userId) => {
  // TODO: 10.1 Implement this
  const viewedUser = await User.findById(userId).exec();
  // Successful user viewing
  if (viewedUser !== null){
    return responseUtils.sendJson(response, viewedUser);
  }
  // 404 Not Found if user to view not found
  else{
    return responseUtils.notFound(response);
  }
};

/**
 * Register new user and send created user back as JSON
 *
 * @param {http.ServerResponse} response Server response
 * @param {object} userData JSON data from request body
 */
const registerUser = async (response, userData) => {
  // TODO: 10.1 Implement this
  // 400 Bad Request if email, password or name is missing
  if (!userData.email || !userData.name || !userData.password){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  // 400 Bad Request if email is already in use
  else if (await User.findOne({ email: userData.email }).exec()){
    return responseUtils.badRequest(response, 'Bad Request');
  }
  else{
    userData.role = "customer";
    const newUser = new User(userData);
    await newUser.save()
      // Successful user registration
      .then(() => {
        return responseUtils.createdResource(response, newUser);
      })
      // 400 Bad Request in case of any possible mongoose schema validation errors
      .catch(() => {
        return responseUtils.badRequest(response, 'Bad Request');
      });
  }
};

module.exports = { getAllUsers, registerUser, deleteUser, viewUser, updateUser };
