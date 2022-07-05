## 9.1 프로젝트 세팅
1) npm i express-generator
2) npx express -v pug jitSNS
3) cd jitSNS
4) package.json 확인 후 수정
   pug부분 삭제, start항목 수정
5) npm i
6) npm i express-session multer nunjucks
7) npm i dotenv
8) npm i -D nodemon
9) npm i sequelize mysql2 sequelize-cli
10) npx sequelize init
11) config/config.json 수정
  "development":{
    "username":"root", // 수정해야할 곳
    "password":비밀번호입력, // 수정해야할 곳
    "database":"jitsnsdb", // 수정해야할 곳
    "host":"127.0.0.1",
    "dialect":"mysql"
  }
12) npx sequelize db:create
13) view엔진 설정:app.js 수정
```js
const nunjucks = require('nunjucks');
app.set('view engine','html');
nunjucks.configure('views',{
  express: app,
  watch: true,
});
```
});
14) DB 연결 설정: app.js 수정
```js
const {sequelize} = require('./models');
sequelize.sync({force:false})
  .then(()=>{
    console.log('데이터베이스 연결 성공');
  })
  .catch((err)=>{
    console.error(err);
  });
```
15) .env처리
16) 쿠키처리, 세션처리 설정: app.js
17) 에러 처리부분 수정:app.js
18) REST API에 대한 분석