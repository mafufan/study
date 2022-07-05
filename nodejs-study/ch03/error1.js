const process = require('process');

setInterval(() => {
  console.log(Math.floor(process.uptime(), 1));
  try {
    throw new Error('노랭이1');
  } catch (err) {
    console.error(err);
  }
}, 1000);
