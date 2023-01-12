/**
 * TODO: Make a thenable (i.e. has a then method). 
 * Thenable behaves like a promise that resolves with
 * the value `👍` after 10ms.
 * See rejectable for reference
 */
const thenable = {
  then: function (onFulfilled) {
    setTimeout( function() {
      onFulfilled("👍");
  },10)
  }
};

/**
 * Instead of onFulfilled only, rejectable needs
 * one more parameter onRejected that returns "👎"
 */
const rejectable = {
  then: function (onFulfilled, onRejected) {
    onRejected("👎");
  },
};

//TODO: Verify that all functions are exported for tests
exports.thenable = thenable;
exports.rejectable = rejectable;
