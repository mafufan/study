/* const { odd, even } = require("./var");
const checkNumber = require("./func"); // 함수

function checkStringOddOrEven(str) {
  if (str.length % 2) {
    // 홀수면
    return odd;
  }
  return even;
}

console.log(checkNumber(10));
console.log(checkStringOddOrEven("안녕함이")); */
/*
const string = "abc";
const number = 1;
const boolean = true;
const obj = {
  outside: {
    inside: {
      key: "value",
    },
  },
};
console.time("전체시간");
console.log("평범한 로그입니다 쉼표로 구분해 여러 값을 찍을 수 있습니다");
console.log(string, number, boolean);
console.error("에러 메시지는 console.error에 담아주세요");

console.table([
  { name: "제로", birth: 1994 },
  { name: "hero", birth: 1988 },
]);

console.dir(obj, { colors: true, depth: 2 });
console.dir(obj, { colors: true, depth: 1 });

console.time("시간측정");
for (let i = 0; i < 100000; i++) {}
console.timeEnd("시간측정");

function b() {
  console.trace("에러 위치 추적");
}
function a() {
  b();
}
a();

console.timeEnd("전체시간");
*/
/* const timeout = setTimeout(() => {
  console.log("1.5초 후 실행");
}, 1500);

const interval = setInterval(() => {
  console.log("1초마다 실행");
}, 1000);

const timeout2 = setTimeout(() => {
  console.log("실행되지 않습니다");
}, 3000);

setTimeout(() => {
  clearTimeout(timeout2);
  clearInterval(interval);
}, 2500);

const immediate = setImmediate(() => {
  console.log("즉시 실행");
});

const immediate2 = setImmediate(() => {
  console.log("실행되지 않습니다");
});
clearImmediate(immediate2);
*/
/* 
console.log("__filename", __filename);
console.log("__dirname", __dirname);
 */

/* console.log(this); // {}
console.log(this === module.exports); // true
console.log(this === exports); // true

function whatIsThis() {
  console.log("function", this === exports, this === global);
}
whatIsThis();

(() => {
  console.log("arrow func", this === exports, this === global);
})(); */
/* 
console.log("require가 가장 위에 오지 않아도 됩니다.");

module.exports = "저를 찾아보세요.";

require("./var");

console.log("require.cache입니다.");
console.log(require.cache);
console.log("require.main입니다.");
console.log(require.main === module);
console.log(require.main.filename);
console.log(require.main.filename === __filename);
 */

/* setTimeout(() => {
  console.log("timeout");
}, 0);
setImmediate(() => {
  console.log("immediate");
});
process.nextTick(() => {
  console.log("nextTick");
});
Promise.resolve().then(() => console.log("promise")); */

/* const os = require("os");

console.log("운영체제 정보---------------------------------");
console.log("os.arch():", os.arch());
console.log("os.platform():", os.platform());
console.log("os.type():", os.type());
console.log("os.uptime():", os.uptime());
console.log("os.hostname():", os.hostname());
console.log("os.release():", os.release());

console.log("경로------------------------------------------");
console.log("os.homedir():", os.homedir());
console.log("os.tmpdir():", os.tmpdir());

console.log("cpu 정보--------------------------------------");
console.log("os.cpus():", os.cpus());
console.log("os.cpus().length:", os.cpus().length);

console.log("메모리 정보-----------------------------------");
console.log("os.freemem():", os.freemem());
console.log("os.totalmem():", os.totalmem()); */

/* const path = require('path');

const string = __filename; // 현재의 파일경로(파일명포함)

console.log('path.sep:', path.sep); // 경로 구분자
console.log('path.delimiter:', path.delimiter); // 환경 변수의 구분자
// Windows - ;, POSIX - :
// echo %PATH%  echo $PATH
console.log('------------------------------');
console.log('path.dirname():', path.dirname(string));
// 경로의 디렉토리(폴더) /Users/6oz/OneDrive/Code/Js
console.log('path.extname():', path.extname(string));
// 경로의 파일의 확장자(extension), .js
console.log('path.basename():', path.basename(string));
// 경로의 파일명(확장자 포함), ch03.js @빈칸에 있는거슬 적어라!!!
console.log(
  'path.basename - extname:',
  path.basename(string, path.extname(string))
);
// basename(경로,확장자) ---> 파일명(확장자 제외), ch03
console.log('------------------------------');
console.log('path.parse()', path.parse(string));
// 객체명.parse(문자열) : 문자열을 객체로 반환 , JSON.parse()
console.log(
  'path.format():',
  path.format({
    dir: 'C:\\users\\zerocho',
    name: 'path',
    ext: '.js',
  })
);
// 객체명.format(객체) : 객체를 문자열로 반환
console.log(
  'path.normalize():',
  path.normalize('C://users\\\\zerocho\\path.js')
);
// 비정상 path 문자열을 정상적인 path로 변경
console.log('------------------------------');
console.log('path.isAbsolute(C:\\):', path.isAbsolute('C:\\'));
// 절대경로여부 확인: true - 절대경로
// windows : C: 등으로 시작 ---> true
// POSIX : / 시작 ---> true --->
console.log('path.isAbsolute(./home):', path.isAbsolute('./home'));
// 상대경로 : . | .. 으로 시작, false
// .: 현재 경로
// ..: 상위 경로
console.log('------------------------------');
console.log(
  'path.relative():',
  path.relative('C:\\users\\zerocho\\path.js', 'C:\\')
);
// relative(기준경로, 비교경로): 기준경로에서 비교경로로 이동하려고 하는 경우의 상대경로
console.log(
  'path.join():',
  path.join(__dirname, '..', '..', '/users', '.', '/zerocho')
);
// 경로 합쳐서 반환
console.log(
  'path.resolve():',
  path.resolve(__dirname, '..', 'users', '.', '/zerocho')
);
// resolve()의 파라미터에서 / 는 루트디렉토리로 해석 */

/* const url = require('url');

const { URL } = url;
const myURL = new URL(
  'http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor'
);
// WHATWG url 객체 생성
console.log('new URL():', myURL);
console.log('url.format():', url.format(myURL));
// format(객체) : 문자열로 반환
console.log('------------------------------');
const parsedUrl = url.parse(
  'http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor'
);
// parse(문자열) : 객체 반환 - legacy url 객체
console.log('url.parse():', parsedUrl);
console.log('url.format():', url.format(parsedUrl));
 */

/* const { URL } = require('url');

const myURL = new URL(
  'http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript'
);
console.log('searchParams:', myURL.searchParams);
// p.83 FormData
console.log('searchParams.getAll():', myURL.searchParams.getAll('category'));
console.log('searchParams.get():', myURL.searchParams.get('limit'));
console.log('searchParams.has():', myURL.searchParams.has('page'));

console.log('searchParams.keys():', myURL.searchParams.keys());
console.log('searchParams.values():', myURL.searchParams.values());
// keys(): key=value에서 key들을 반환(Iterator)
// values(): key=value에서 value들을 반환(Iterator)

myURL.searchParams.append('filter', 'es3');
myURL.searchParams.append('filter', 'es5');
console.log(myURL.searchParams.getAll('filter'));

myURL.searchParams.set('filter', 'es6');
console.log(myURL.searchParams.getAll('filter'));

myURL.searchParams.delete('filter');
console.log(myURL.searchParams.getAll('filter'));

console.log('searchParams.toString():', myURL.searchParams.toString());
myURL.search = myURL.searchParams.toString(); */

/* const url = require('url');
const querystring = require('querystring');

const parsedUrl = url.parse(
  // parsedUrl: legacy url 객체
  'http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript'
);
// parse(문자열) : 객체반환
const query = querystring.parse(parsedUrl.query);
console.log('querystring.parse():', query);
console.log('querystring.stringify():', querystring.stringify(query));
// 객체를 문자열로 변환: format()
// stringify(객체) *ify(만들다) : 객체를 문자열로 */

/* const crypto = require('crypto');

// 메소드 체이닝
console.log(
  'base64:',
  crypto.createHash('sha512').update('비밀번호').digest('base64')
); */
// createHash(해시알고리즘이름)
// 해시알고리즘
// md1  : 취약점 발견, 128bit
// sha1 : 취약점 발견, 160bit
// sha256 : 256bit
// sha512 : 512bit, 현재 주로 사용
// sha3  : 512bit

// update(평문): 암호화시도
// digest(인코딩코드): 인코딩코드- base64, hex, latin1 등

/* console.log(
  'hex:',
  crypto.createHash('sha512').update('비밀번호').digest('hex')
);
console.log(
  'base64:',
  crypto.createHash('sha512').update('다른 비밀번호').digest('base64')
); */

/* const crypto = require('crypto');

crypto.randomBytes(64, (err, buf) => {
  const salt = buf.toString('base64');
  console.log('salt:', salt);
  crypto.pbkdf2('비밀번호', salt, 100000, 64, 'sha512', (err, key) => {
    console.log('password:', key.toString('base64'));
  });
}); */

/* const crypto = require('crypto');

const algorithm = 'aes-256-cbc';
const key = 'abcdefghijklmnopqrstuvwxyz123456';
const iv = '1234567890123456';

const cipher = crypto.createCipheriv(algorithm, key, iv);
let result = cipher.update('암호화할 문장', 'utf8', 'base64');
result += cipher.final('base64');
console.log('암호화:', result);

const decipher = crypto.createDecipheriv(algorithm, key, iv);
let result2 = decipher.update(result, 'base64', 'utf8');
result2 += decipher.final('utf8');
console.log('복호화:', result2);
 */

/* const util = require('util');
const crypto = require('crypto');

const dontUseMe = util.deprecate((x, y) => {
  console.log(x + y);
}, 'dontUseMe 함수는 deprecated되었으니 더 이상 사용하지 마세요!');
 */
/* const dontUseMe = (x, y) => {
  console.log(x + y);
}; */
/* dontUseMe(1, 2);

const randomBytesPromise = util.promisify(crypto.randomBytes);
randomBytesPromise(64)
  .then((buf) => {
    console.log(buf.toString('base64'));
  })
  .catch((error) => {
    console.error(error);
  });
 */
/* const { Worker, isMainThread, parentPort } = require('worker_threads');

if (isMainThread) {
  // 부모일 때
  // const worker = new Worker(__filename);
  const worker = new Worker('./workerThread.js');
  // workerThread.js파일을 읽어서 워커쓰레드 객체를 생성해라
  worker.on(
    // addEventListener()
    'message', // 이벤트명
    (message) => console.log('from worker', message) // 이벤트 핸들러
    // (message) => {return console.log('from worker', message)};
  );
  worker.on('exit', () => console.log('worker exit'));
  worker.postMessage('ping');
  // 워커쓰레드로 메시지('ping')를 POST
} */ /* else {
  // 워커일 때
  parentPort.on('message', (value) => {
    console.log('from parent', value);
    parentPort.postMessage('pong');
    parentPort.close();
  });
} */
/* const {
  Worker,
  isMainThread,
  //parentPort,
  //workerData,
} = require('worker_threads');

if (isMainThread) {
  // 부모일 때
  const threads = new Set(); // 중복불가
  threads.add(
    new Worker('./workerData.js', {
      workerData: { start: 1, msg: '안녕' },
    })
  );
  threads.add(
    new Worker('./workerData.js', {
      workerData: { start: 2, msg: '눈깔아!' },
    })
  );
  for (let worker of threads) {
    worker.on('message', (message) => console.log('from worker', message));
    worker.on('exit', () => {
      threads.delete(worker);
      if (threads.size === 0) {
        console.log('job done');
      }
    });
  }
}  */ /* else {
  // 워커일 때
  const data = workerData;
  parentPort.postMessage(data.start + 100);
} */
/* const min = 2;
const max = 10000000;
const primes = [];

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

console.time('prime');
findPrimes(min, max);
console.timeEnd('prime');
console.log(primes.length); */

/* const {
  Worker,
  isMainThread,
  parentPort,
  workerData,
} = require('worker_threads'); */ /* else {

/* const min = 2; */
/* let primes = []; */

/* function findPrimes(start, range) {
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
} */

/* if (isMainThread) {
  const max = 10000000;
  const threadCount = 8;
  const threads = new Set();
  const range = Math.ceil((max - min) / threadCount);
  let start = min;
  console.time('prime');
  for (let i = 0; i < threadCount - 1; i++) {
    const wStart = start;
    threads.add(
      new Worker('./workerPrime.js', { workerData: { start: wStart, range } })
    );
    start += range;
  }
  threads.add(
    new Worker('./workerPrime.js', {
      workerData: { start, range: range + ((max - min + 1) % threadCount) },
    })
  );
  for (let worker of threads) {
    worker.on('error', (err) => {
      throw err;
    });
    worker.on('exit', () => {
      threads.delete(worker);
      if (threads.size === 0) {
        console.timeEnd('prime');
        console.log(primes.length);
      }
    });
    worker.on('message', (msg) => {
      primes = primes.concat(msg);
    });
  }
}  
  findPrimes(workerData.start, workerData.range);
  parentPort.postMessage(primes);
} 
*/

// const exec = require('child_process').exec;
// 구조분해할당
/* const { exec, spawn } = require('child_process');

var process = exec('ls'); // shell 명령어 실행
// dir 도스 명령어
// ls  linux의 shell명령어 ()

process.stdout.on('data', function (data) {
  // 표준출력: stdout - 모니터
  // 표준입력: stdin  - 키보드
  console.log(data.toString());
}); // 실행 결과

process.stderr.on('data', function (data) {
  // 표준에러: stderr - 모니터
  console.error(data.toString());
}); // 실행 에러

var process = spawn('python3', ['test.py', '222'], { shell: false });
process.stdout.on('data', function (data) {
  // 표준출력: stdout - 모니터
  // 표준입력: stdin  - 키보드
  console.log(data.toString());
}); // 실행 결과

process.stderr.on('data', function (data) {
  // 표준에러: stderr - 모니터
  console.error(data.toString());
}); // 실행 에러 */

/* const fs = require('fs');

fs.readFile(
  './readme.txt', // 읽기위한 파일경로 지정
  (err, data) => {
    // 콜백
    if (err) {
      throw err;
    }
    console.log(data); // buffer
    console.log(data.toString());
  }
); */

/* const fs = require('fs').promises;

fs.readFile('./readme.txt')
  .then(data => {
    console.log(data);
    console.log(data.toString());
  })
  .catch(err => {
    console.error(err);
  }); */
/* const fs = require('fs').promises;

(async () => {
  try {
    const data = await fs.readFile('./readme.txt');
    console.log(data);
    console.log(data.toString());
  } catch (err) {
    console.error(err);
  }
})(); */

/* const fs = require('fs');

fs.watch('./target.txt', (eventType, filename) => {
  console.log(eventType, filename);
}); */

/* const crypto = require('crypto');

const pass = 'pass';
const salt = 'salt';
const start = Date.now();

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('1:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('2:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('3:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('4:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('5:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('6:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('7:', Date.now() - start);
});

crypto.pbkdf2(pass, salt, 1000000, 128, 'sha512', () => {
  console.log('8:', Date.now() - start);
}); */

const EventEmitter = require('events');

const myEvent = new EventEmitter();
myEvent.addListener('event1', () => {
  console.log('이벤트 1');
});
myEvent.on('event2', () => {
  console.log('이벤트 2');
});
myEvent.on('event2', () => {
  console.log('이벤트 2 추가');
});
myEvent.once('event3', () => {
  console.log('이벤트 3');
}); // 한 번만 실행됨

myEvent.emit('event1'); // 이벤트 호출
myEvent.emit('event2'); // 이벤트 호출

myEvent.emit('event3');
myEvent.emit('event3'); // 실행 안 됨

myEvent.on('event4', () => {
  console.log('이벤트 4');
});
myEvent.removeAllListeners('event4');
myEvent.emit('event4'); // 실행 안 됨

const listener = () => {
  console.log('이벤트 5');
};
myEvent.on('event5', listener);
myEvent.removeListener('event5', listener);
myEvent.emit('event5'); // 실행 안 됨

console.log(myEvent.listenerCount('event2'));
