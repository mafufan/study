const express = require('express');
const path = require('path');

const app = express(); // app객체 - express웹서버객체
// http.createServer()

app.set('port', process.env.PORT || 3000);
// app.set(키, 값): 서버객체에 키 정보를 설정

app.use((req, res, next) => {
  console.log('모든 요청에서 처리하는 미들웨어');
  next(); // 다음 미들웨어 실행
}); // 사용자 정의 미들웨어 정의

app.get(
  '/',
  (req, res, next) => {
    console.log('GET / 요청시에만 실행됨');
    next();
  },
  (req, res) => {
    // GET / 요청 처리 핸들러 등록
    res.sendFile(path.join(__dirname, '/index.html'));
  }
);

app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).send(err.message);
});

app.listen(
  app.get('port'), // app.get(키): 설정되어 있는
  () => {
    console.log(
      app.get('port'),
      '번 포트에서 접속 대기중~~~'
    );
  }
);
