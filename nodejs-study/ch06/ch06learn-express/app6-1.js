const express = require('express');
const path = require('path');

const app = express(); // app객체 - express웹서버객체
// http.createServer()

app.set('port', process.env.PORT || 3000);
// app.set(키, 값): 서버객체에 키 정보를 설정

app.get('/', (req, res) => {
  // GET / 요청 처리 핸들러 등록
  //res.send('안녕 한글 처리 잘될까?');
  //res.sendFile(__dirname + '/index.html');
  res.sendFile(path.join(__dirname, '/index.html'));
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
