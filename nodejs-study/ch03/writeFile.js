// const fs = require('fs');
const fs = require('fs').promises;

/* fs.writeFile(
  './writeMe.txt',
  '글이 작성됩니다.',
  (err, data) => {
    if (err) {
      throw err;
    }
  }
); */

fs.writeFile('./writeMe.txt', '글이 작성됩니다.')
  .then(() => {
    return fs.readFile('./writeMe.txt');
  })
  .then(data => {
    console.log(data.toString());
  })
  .catch(() => {});
