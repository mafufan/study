// const value = require('./var.js');
const value = require('./var');
// const { odd, even } = require('./var');
const odd = value.odd;
const even = value.even;

// const { odd, even } = require("./var"); //구조분해할당
// const odd = require('./var').odd;
// const even = require('./var').even;
function checkOddOrEven(num) {
  if (num % 2) {
    return odd;
  } else {
    return even;
  }
}
module.exports = checkOddOrEven;

/* function checkOddOrEven(num) {
  if (num % 2) {
    // 홀수면
    return odd;
  }
  return even;
}

module.exports = checkOddOrEven;
 */
