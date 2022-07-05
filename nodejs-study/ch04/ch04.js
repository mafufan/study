/* const http = require('http');

http
  .createServer((req, res) => {
    // req-Request객체, res-Response객체
    // Request객체: 클라이언트에서 보내온 요청 정보 저장
    // Response: 서버에서 전송할 응답 정보 저장
    console.log('request', req);
    console.log('response', res);

    res.writeHead(200, {
      'content-type': 'text/html; charset=utf-8',
    }); // 응답코드, http의 헤더에 정보를 작성해서 전송
    res.write('<h1>잘보라카이...</h1>');
    res.write('<h2>영진전문대학 화이팅</h2>');
    res.end(
      '<div style="background-color:green">일본반</div>'
    );
  })
  .listen(
    // 요청 대기
    8080, // 포트번호
    () => {
      // 서버시작이 되면 실행되는 코드
      console.log(
        '8080포트에서 서버 실행중. http://localhost:8080/'
      );
    }
  ); */

/* const http = require('http');
const fs = require('fs').promises;

http
  .createServer(async (req, res) => {
    try {
      const data = await fs.readFile('./ch04-1.html');
      res.writeHead(200, {
        'Content-Type': 'text/html; charset=utf-8',
      });
      res.end(data);
    } catch (err) {
      console.error(err);
      res.writeHead(500, {
        'Content-Type': 'text/plain; charset=utf-8',
      });
      res.end(err.message);
    }
  })
  .listen(8081, () => {
    console.log('8081번 포트에서 서버 대기 중입니다!');
  }); */

/* const http = require('http');

http
  .createServer((req, res) => {
    console.log(req.url, req.headers.cookie);
    res.writeHead(200, {
      'Set-Cookie': `mycookie=test;mymy=${encodeURIComponent(
        '김영진'
      )}`,
    });
    res.end('Hello Cookie');
  })
  .listen(8083, () => {
    console.log('8083번 포트에서 서버 대기 중입니다!');
  }); */
/* 
const http = require('http');
const fs = require('fs').promises;
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie = '') =>
  cookie
    .split(';')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});

http
  .createServer(async (req, res) => {
    console.log(req.headers.cookie);
    // parseCookies(어쩌구name=%EC%98%A4%ED%9D%AC%EC%9E%AC)
    const cookies = parseCookies(req.headers.cookie); // { mycookie: 'test' }
    // 주소가 /login으로 시작하는 경우
    if (req.url.startsWith('/login')) {
      // GET /login
      const { query } = url.parse(req.url); //old version url 객체
      const { name } = qs.parse(query); //old version querystring 객체
      const expires = new Date();
      // 쿠키 유효 시간을 현재시간 + 5분으로 설정
      expires.setMinutes(expires.getMinutes() + 1);
      res.writeHead(302, {
        // 임시이동, 리다이렉션
        Location: '/', // GET / 으로 리다이렉션하기 설정
        'Set-Cookie': `name=${encodeURIComponent(
          name
        )}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
      });
      res.end();
      // name이라는 쿠키가 있는 경우
    } else if (cookies.name) {
      // GET /
      res.writeHead(200, {
        'Content-Type': 'text/plain; charset=utf-8',
      });
      res.end(`${cookies.name}님 안녕하세요`);
    } else {
      // GET / 제일 먼저 실행되는 부분
      try {
        const data = await fs.readFile('./ch04-2.html'); // GET /
        res.writeHead(200, {
          'Content-Type': 'text/html; charset=utf-8',
        });
        res.end(data);
      } catch (err) {
        res.writeHead(500, {
          'Content-Type': 'text/plain; charset=utf-8',
        });
        res.end(err.message);
      }
    }
  })
  .listen(8084, () => {
    console.log('8084번 포트에서 서버 대기 중입니다!');
  });
 */
/* const http = require('http');
const fs = require('fs').promises;
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie = '') =>
  cookie
    .split(';')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});

const sessionObj = {}; // Redis, Memcached와 같은 DB를 사용

http
  .createServer(async (req, res) => {
    const cookies = parseCookies(req.headers.cookie); // { mycookie: 'test' }
    // 주소가 /login으로 시작하는 경우
    if (req.url.startsWith('/login')) {
      const { query } = url.parse(req.url);
      const { name } = qs.parse(query);
      const expires = new Date();
      // 쿠키 유효 시간을 현재시간 + 5분으로 설정
      expires.setMinutes(expires.getMinutes() + 1);

      const uniqueInt = Date.now(); // 유니크한 정수값 만들기
      // UUID
      sessionObj[uniqueInt] = {
        name, // name:name
        expires, // expires:expires
      };

      res.writeHead(302, {
        Location: '/',
        'Set-Cookie': `session=${uniqueInt};Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
      });
      res.end();
      // name이라는 쿠키가 있는 경우
    } else if (
      cookies.session &&
      sessionObj[cookies.session].expires > new Date()
    ) {
      res.writeHead(200, {
        'Content-Type': 'text/plain; charset=utf-8',
      });
      res.end(
        `${sessionObj[cookies.session].name}님 안녕하세요`
      );
    } else {
      try {
        const data = await fs.readFile('./ch04-2.html');
        res.writeHead(200, {
          'Content-Type': 'text/html; charset=utf-8',
        });
        res.end(data);
      } catch (err) {
        res.writeHead(500, {
          'Content-Type': 'text/plain; charset=utf-8',
        });
        res.end(err.message);
      }
    }
  })
  .listen(8085, () => {
    console.log('8085번 포트에서 서버 대기 중입니다!');
  }); */
