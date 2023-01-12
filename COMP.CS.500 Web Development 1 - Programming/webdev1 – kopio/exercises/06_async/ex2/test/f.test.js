const expect = require("chai").expect;

const f = require("../f_skeleton");

describe("thenable", () => { 
  it("resolves with correct value", (done) => {
      Promise.resolve(f.thenable)
        .catch((err) => err)
        .catch((err) => {
          expect(err).to.equal("👍");
          done();
      });
    // TODO: Implement this test. See rejectable below as a model
    // See: https://www.testim.io/blog/testing-promises-using-mocha/
    // This test can be implemented with either Promises or with async / await.
    // Use expect() and to.equal()
    // to make sure that the resolved value is 👍
    //throw "Not yet implemented!";
  });
});

describe("rejectable", () => {
  it("rejects with correct value", (done) => {
    Promise.reject(f.rejectable)
      .catch((err) => err)
      .catch((err) => {
        expect(err).to.equal("👎");
        done();
      });
  });
});
