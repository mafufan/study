const {
  //Worker, isMainThread,
  parentPort,
} = require('worker_threads');
// 워커일 때
// parentPort객체: 메인쓰레드와 연락가능한 객체
parentPort.on('message', (value) => {
  console.log('from parent', value);
  parentPort.postMessage('pong');
  // 메인 쓰레드에 message 이벤트 처리요청
  parentPort.close();
  // 메인 쓰레드에 exit 이벤트 처리요청
});
