const { workerData, parentPort } = require('worker_threads');

let primes = [];
const min = 2;

function findPrimes(start, range) {
  let isPrime = true;
  const end = start + range;
  for (let i = start; i < end; i++) {
    for (let j = min; j < Math.sqrt(end); j++) {
      if (i !== j && i % j === 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) {
      primes.push(i);
    }
    isPrime = true;
  }
}

findPrimes(workerData.start, workerData.range);
parentPort.postMessage(primes);
