const bcrypt = require('bcryptjs');
const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const userSchema = new Schema({
  name: { 
    type: String, 
    required: true,
    trim: true,
    minlength: 1,
    maxlength: 50
  },
  email: {
    type: String,
    required: true,
    unique: true,
    match: /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/
  },
  password: {
    type: String,
    required: true,
    minlength: 10,
    set: setHash
  },
  role: {
    type: String,
    trim: true,
    lowercase: true,
    default: "customer",
    enum: ["admin", "customer"]
  }
});

/**
 * Hash a password using bcrypt
 *
 * @param {string} password Password to hash
 * @returns {boolean|string} Returns false if password to hash is less than 10 characters long. Returns hashed password otherwise.
 */
function setHash(password) {
  if (password.length < 10){
    return false;
  }
  else{
    const salt = bcrypt.genSaltSync(10);
    const hash = bcrypt.hashSync(password, salt);
    return hash;
  }
}

/**
 * Compare supplied password with user's own (hashed) password
 *
 * @param {string} password Password to compare to a hashed version
 * @returns {Promise<boolean>} promise that resolves to the comparison result
 */
userSchema.methods.checkPassword = async function (password) {
  // TODO: 9.4 Implement this
  if (bcrypt.compareSync(password, this.password)){
    return await Promise.resolve(true);
  }
  else{
    return await Promise.resolve(false);
  }
};

// Omit the version key when serialized to JSON
userSchema.set('toJSON', { virtuals: false, versionKey: false });

const User = new mongoose.model('User', userSchema);
module.exports = User;

