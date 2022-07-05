const http = require('http');
const fs = require('fs').promises;
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie = '') =>
  cookie
    .split('/')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});

http
  .createServer(async (req, res) => {
    console.log(req.headers.cookie);
    const cookies = parseCookies(req.headers.cookie);

    // 주소가 /login으로 시작하는 경우
    if (req.url.startsWith('/login')) {
      const { query } = url.parse(req.url);
      const { name } = qs.parse(query);
      const expires = new Date();
      // 쿠키 유효 시간 : 현재 시간 + 1;
      expires.setMinutes(expires.getMinutes() + 1);
      res.writeHead(302, {
        Location: '/',
        'Set-Cookie': `name=${encodeURIComponent(
          name
        )}; Expires= ${expires.toGMTString()}; HttpOnly; Path=/`,
      });
      res.end();
    } //name 이라는 쿠키가 있을 경우
    else if (cookies.name) {
      res.writeHead(200, {
        'Content-Type': 'text/plain; charset=utf-8;',
      });
      res.end(`${cookies.name} 님 안녕하세요`);
    } else {
      try {
        const data = await fs.readFile('./cookie2.html');
        res.writeHead(200, {
          'Content-Type': 'text/html; charset=utf-8;',
        });
        res.end(data);
      } catch (err) {
        res.writeHead(500, {
          'Content-Type': 'text/plain; charset=utf-8;',
        });
        res.end(err.message);
      }
    }
  })
  .listen(8084, () => {
    console.log('8084포트번ㄴ호 대기주ㅜ줒ㅇㅈ우중ㅈ우');
  });
