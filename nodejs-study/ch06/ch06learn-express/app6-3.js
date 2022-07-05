const express = require('express');
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const dotenv = require('dotenv');
const path = require('path');

dotenv.config();
const app = express(); // express 서버객체
app.set('port', process.env.PORT || 3000);

app.use(morgan('dev'));

app.use(
  '/',
  express.static(path.join(__dirname, 'public'))
  // 내부에 res.sendFile() --> next() 처리 안함
);
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(
  session({
    resave: false,
    saveUninitialized: false,
    secret: process.env.COOKIE_SECRET,
    cookie: {
      httpOnly: true,
      secure: false,
    },
    name: 'session-cookie', // 생략시 세션쿠키명: connect.sid
  })
);

const fs = require('fs');
// IO소스코딩시는 try~catch처리 권장
try {
  fs.readdirSync('uploads'); // 동기적으로 작동
} catch (err) {
  console.error(
    'uploads 폴더가 없어 uploads 폴더를 생성합니다.'
  );
  fs.mkdirSync('uploads');
}

const multer = require('multer');
const upload = multer({
  // 멀터객체 생성
  // 옵션
  storage: multer.diskStorage({
    // 저장공간, 저장방식
    destination(req, file, done) {
      // 저장 위치 설정
      // req-요청정보, file-업로드 파일정보, done()-업로드설정완료시 호출
      done(null, 'uploads/'); // 에러가 null, uploads 폴더에 업로드 파일저장
    },
    filename(req, file, done) {
      // 저장시 파일명 설정
      // abd.jpg로 가정
      // file: 업로드된 파일 정보
      const ext = path.extname(file.originalname); //jpg
      done(
        null, // 에러
        path.basename(file.originalname, ext) + // abc
          Date.now() + //1673434254646
          ext // jpg
      );
    },
  }),
  limits: { fileSize: 5 * 1024 * 1024 }, // 용량제한(바이트단위), 5Mb,
});
app.get('/upload', (req, res) => {
  res.sendFile(path.join(__dirname, 'multipart.html'));
});
app.post(
  '/upload', //url
  upload.single('imagefile'), // form>input:file의 name속성값
  (req, res) => {
    console.log(req.file, req.body);
    // req.file 업로드한 파일 객체
    // req.body form>input:
    res.send('<h1>업로드 성공함</h1>');
  }
);

app.get(
  '/',
  (req, res, next) => {
    console.log('GET / 요청에서만 실행됩니다.');
    next();
  },
  (req, res) => {
    throw new Error('에러는 에러 처리 미들웨어로 갑니다.');
  }
);
app.use((err, req, res, next) => {
  console.error(err);
  res.status(500).send(err.message);
});

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '번 포트에서 대기 중');
});

app.set('port', process.env.PORT || 3000);
// app.set(키, 값): 서버객체에 키 정보를 설정

/* app.use((req, res, next) => {
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
}); */

app.listen(
  app.get('port'), // app.get(키): 설정되어 있는
  () => {
    console.log(
      app.get('port'),
      '번 포트에서 접속 대기중~~~'
    );
  }
);
