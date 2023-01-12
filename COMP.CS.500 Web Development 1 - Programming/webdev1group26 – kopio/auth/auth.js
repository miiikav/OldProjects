const { getCredentials } = require('../utils/requestUtils');
const User = require('../models/user');
/**
 * Get current user based on the request headers
 * 
 *
 * @param {http.IncomingMessage} request Client's request to server
 * @returns {object|null} current authenticated user or null if not yet authenticated
 */
const getCurrentUser = async request => {
  // TODO: 8.4 Implement getting current user based on the "Authorization" request header

  // NOTE: You can use getCredentials(request) function from utils/requestUtils.js
  // and getUser(email, password) function from utils/users.js to get the currently
  // logged in user
  
  const credentials = getCredentials(request);
  if (credentials !== null){
    const email = credentials[0];
    const password = credentials[1];
    const loggedUser = await User.findOne({email: email}).exec();
    if (loggedUser !== null) {
      if (await loggedUser.checkPassword(password)){
        return loggedUser;
      }
      else {
        return null;
      }
    }
    else{
      return null;
    }
  }
  else{
    return null;
  }
    
};

module.exports = { getCurrentUser };
