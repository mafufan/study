const { parentPort, workerData } = require('worker_threads');

const data = workerData;
parentPort.postMessage(data.start + 100 + data.msg);
// on() 메소드 처리 하지 않아서 postMessage()후 종료됨
