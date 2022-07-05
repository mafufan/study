const http = require('http');

http
  .createServer((req, res) => {
    res.writeHead(200, {
      'Content-Type': 'text/html; charset=utf-8',
    });
    res.write('<h1>dlksajflkasjddf</h1>');
    res.end('<p>asdasdasdasd</p>');
  })
  .listen(8080, () => {
    console.log('asdasdsad');
  });
