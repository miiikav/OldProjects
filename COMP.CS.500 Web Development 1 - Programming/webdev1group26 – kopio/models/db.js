const mongoose = require('mongoose');

/**
 * Get database connect URL.
 *
 * Reads URL from DBURL environment variable or
 * returns default URL if variable is not defined
 *
 * @returns {string} connection URL
 */
const getDbUrl = () => {
  // TODO: 9.3 Implement this
  let url = process.env.DBURL;
  // Set default database URL if URL is not defined in .env
  if (url === undefined){
    url = "mongodb://localhost:27017/WebShopDb";
  }
  return url;
};

/**
 * Connect to database
 *
 */
function connectDB () {
  // Do nothing if already connected
  if (!mongoose.connection || mongoose.connection.readyState === 0) {
    mongoose
      .connect(getDbUrl(), {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        useFindAndModify: false,
        useCreateIndex: true,
        autoIndex: true
      })
      .then(() => {
        mongoose.connection.on('error', err => {
          console.error(err);
        });

        mongoose.connection.on('reconnectFailed', handleCriticalError);
      })
      .catch(handleCriticalError);
  }
}

/**
 * Handle critical error
 *
 * @param {object} err Error
 */
function handleCriticalError (err) {
  console.error(err);
  throw err;
}

/**
 * Disconnect from database
 *
 */
function disconnectDB () {
  mongoose.disconnect();
}

module.exports = { connectDB, disconnectDB, getDbUrl };
