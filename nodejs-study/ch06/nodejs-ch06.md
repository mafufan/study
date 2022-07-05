# 6. Express
* 웹 프레임워크
* MVC모델로 구현가능
* M: Model - DB
* V: View  - Front-end, React, Vue, Svelte
* C: Controller
  - Front Controller
  - Router로 나눠서 구현

## 6.1 express프로젝트 생성
1. ch06learn-express폴더 생성
2. 생성폴더로 이동
3. package.json생성: npm init
4. express 설치: npm i express
5. 서버 실행도구 설치: npm i -D nodemon
    package name: (ch06learn-express)
    version: (1.0.0)
    description: 익스프레스 배우기
    entry point: (index.js) app.js
    test command: nodemon app
    git repository:
    keywords: expresslearning express node
    author: yjujit
    license: (ISC) MIT
6. app.js 작성
7. 서버 실행: npm start / npm run start
8. 브라우저 실행: http://localhost:3000/

* app.set(key, value)
* app.get(key)
* app.get(url, callback)
* app.post(url, callback), app.put(), app.patch(), app.delete()


* res.writeHead()
* res.write()
* res.end()
* res.send()
* res.sendFile()
* req.body: body-parser의 영향으로 

## 6.2 middleware
* middle - 중간, ware - 제품
* 요청-미들웨어-응답
* 요청과 응답사이에서 필요한 처리를 하는 제품
* 라우터, 에러핸들러 등도 미들웨어의 한 종류로 취급
* 미들웨어: 콜백함수의 형태
  - (req, res, next)=>{}
  - 에러 핸들러
    - (err, req, res, next)={}
  - 미들웨어에서 다음 미들웨어 실행시키려면 next()호출해야한다
* 미들웨어 사용
  - app.use(미들웨어): 모든 요청에서 대응하는 미들웨어 설정
  - app.use(url, 미들웨어): 특정 url 요청에 대응하는 미들웨어
  - app.post(url, 미들웨어): 라우터

* 기존의 미들웨어 사용
  - express 내장 미들웨어
    - static, body-parser(더 상세 제어를 위해서는 별도의 body-parser미들웨어 설치해야한다)
  - 설치해야 하는 미들웨어
    - npm i morgan cookie-parser express-session

* npm i dotenv
  - 도구 패키지
  - .env파일 내용(키-값) 읽어서 process.env.키 속성으로 등록
  - .env파일 비밀번호 등 프로젝트 실행시 필요한 환경 정보 저장

### 6.2.1 morgan
* 로그 처리 미들
* dev: 개발버전
  - [http요청 메서드] [url] [http status code] [응답속도]-[응답바이트]
* combined: 실제 상용 버전
* common
* short
* tiny

### 6.2.2 static
* 정적 컨텐츠: 이미지, css파일 등
* app.use('요청 경로',express.static('실제경로'));
* 요청 경로(브라우저버전): http://localhost:4000/test/mytest/site.jpg
* 실제 경로: __dirname(app.js의폴더)/public/test/mytest/site.jpg

### 6.2.3 body-parser
* express 버전에 따라 다름(4.16.0)이전에는 설치해야 하는 미들웨어
* 4.17.3버전이어서 설치안해도 사용 가능
* 효과: 요청 바디정보가 req.body에서 설정되어짐
* express.json()
  * 요청바디 정보: {name:'yjujit', book:'nodejs'}
  * req.body.name
  * req.body.book
* express.urlencoded()
  * 요청 쿼리 : name='yjujit'&book='nodejs'
  * req.body.name, req.body.book
  * 파라미터: { extended: true/false }
    - true: qs모듈 (설치해야함)
    - false: querystring모듈 (설치안해도 사용가능)
* npm i body-parser
  - raw데이터, text데이터 사용가능: p 238참고 //지금 할필요 없음

### 6.2.4 cookie-parser
* req.cookies 객체가 생성
* app.use(cookieParser(비밀키));
* res.cookie(): 쿠키 설정 p239참고
* res.clearCookie();
* 옵션
  * signed: true --> req.signedCookies
* 권장사항: cookie-parser가 express-session보다 먼저 실행되게 하기

### 6.2.5 express-session

### 6.2.6 미들웨어 특성 활용
* 미들웨어: 콜백함수
  - 매개변수: req,res,next
  - 에러 핸들러: err, req, res, next
* app.use(미들웨어), app.use(url, 미들웨어)

* 미들웨어 종합세트 설정
  - app.use(미들웨어1(), 미들웨어2(), ...)

* next()
* next('route')
* next(error)

* 미들웨어간 데이터 전달하기
  - 1) req.session 객체 이용
    - 세션동안 데이터가 유지된다
  - 2) app.set(키,값)/app.get(키) 이용
  - 3) req.mydefinedprops 이용하기(mydefinedprops: 프로그래머의 맘대로)
    - req.cookies, req.session, req.body, req.app, req.ip, req.params, req.query, req.signedCookies제외
    - 응답이전에서 사용가능

```js
app.use(
  (req,res, next) => {
    req.mydata='뒤미들웨어로 데이터 전달';
    next();
  },
  (req,res, next) => {
    console.log("앞 미들웨어여서 받은 데이터",req.mydata)
    next();
  }
;)
```

* 미들웨어 안에 미들웨어 넣어 사용가능
  * 조건에 따라 다르게 동작하는 미들웨어 호출

```js
app.use((req,res,next)=>{
  if(process.env.NODE_ENV === 'production'){
    morgan('combined')(req,res,next);
    //주의 사항: (req,res,next)붙여서 호출해야 함
  } else{
    morgan('dev')(req,res,next);
  }
})
```

### 6.2.7 multer
* 파일 업로드 처리 미들웨어
* 폼태그: enctype="multipart/form-data"
* 설치: npm i multer

index.html
index.jsp
index.php
index.aspx
...

## 6.3 Router객체
  * MVC 패턴
    - Model
      - DB : 7, 8장
    - View : 6.5절
    - Controller : 6.3절
      - Front Controller: app.js
      - 일반 Controller: router들

* placeholder
  - 라우트 매개변수
  - /user/:id : ':'뒤에는 사용자 정의 문자열
    - req.params.id
  - GET /user/1234?key1=test&k2=ttt1
    - req.params.id: 1234
    - req.query.key1
    - req.query.k2
  - 사용시 주의점
    - 라우트 작성 위치
      - /user/:id와 /user/love 둘중에 /user/:id를 나중에 작성해야 함

## 6.4 req, res 객체
* p.255~256

## 6.5 template engine
* pug(구, jade)
* nunjucks
  * 설치
  * npm i nunjucks

## 6.5.2.1 변수
* 변수:{{변수명}}
  - 내부에서 변수 설정
    - {% set 변수명=값%}
    - {% set node='김영진'}
  - 이스케이프 안하기
    - {{변수명 | safe}} , <: *lit; <: &gt>>
    - : &li; >: &gt; 자동으로 변환되지만 safe를 붙이면 자동변환안함
    - &명칭; --> html entity라고 함

## 6.5.2.2 반복문
* {% for 변수 in 반복객체 %} ~~~ {%endfor%}
  - index: loop.index로 참조

## 6.5.2.3 조건문
* {% if 변수(조건) %}~~~{%elif 변수(조건)%}~~~{%else%}~~~{%endif%}
  - elif --> else if 약자

## 6.5.2.4 include
* {%include '파일경로'%}
  - 현재 html에서 파일경로에 해당하는 파일을 포함시켜 렌더링

## 6.5.2.5 extends, block
  * layout
    - 설계도면
  * extends
    - 레이아웃 파일 지정
    - {% extends '파일경로' %}
  * block
    - extend되는 파일
      - {%block 블록명} {%endblock}
    - extend하는 파일 : {% extends '파일경로' %}
      - {%block 블록명}~~~{%endblock}