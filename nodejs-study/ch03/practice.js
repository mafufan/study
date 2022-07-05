process.on('uncaughtException', err => {
  console.error('예기치 못한 에러', err);
});

setInterval(() => {
  throw new Error('노랭이 바부');
}, 1000);

setTimeout(() => {
  console.log('에옹');
}, 2000);
