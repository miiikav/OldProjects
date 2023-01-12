const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const orderedItemSchema = new Schema({
  product: {
    _id: {
      type: String,
      required: true
    },
    name: {
      type: String,
      required: true
    },
    price: {
      type: Number,
      required: true,
      min: 0
    },
    description: {
      type: String
    },
  },
  quantity: {
    type: Number,
    validate : {
      validator : Number.isInteger,
      message   : '{VALUE} is not an integer value'
    },
    min: 1,
    required: true
  }
});

const orderSchema = new Schema({
  customerId: {
    type: String,
    required: true
  },
  items: [orderedItemSchema]
});

// Omit the version key when serialized to JSON
orderSchema.set('toJSON', { virtuals: false, versionKey: false });

const Order = new mongoose.model('Order', orderSchema);
module.exports = Order;

