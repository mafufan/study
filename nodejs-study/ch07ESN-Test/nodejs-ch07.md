# 7. MySql : Sequelize
## 7.1 DB
## 7.2 설치
## 7.3 워크벤치 
## 7.4 DB생성 및 테이블 생성
## 7.5 CRUD 작업
* CRUD
* C: Create
  - insert into
* R: Read
  - select
* U: Update
  - update from
* D: Delete
  - delete

## 7.6 sequelize 사용
* ORM: Object Relational Mapping : 객체-관계 매핑 
  - Model:Table = Sequelize:RDB
  - sequelize, typeORM, Prisma, GraphQL
  - python: DjangoORM, Flask-SQLAlchemy
  - php: Laravel -Eloquent ORM
  - Java(JSP,Servlet): Hibernate, iBatis, MyBatis, JPA
* 특징: promise대응
* sequelize의 CRUD 테스트하기: sequelize-sql 모듈 사용하기
1)  테스트 프로젝트 폴더 생성
    mkdir ch07sequelize-sql-test
2)  테스트 프로젝트폴더로 이동
3)  sequelize 모델 생성
    model:table = sequelize:DB
    <models/index.js>
    <models/user.js>
    <models/comment.js>
    model: 단수형 --> table: 복수형
    user        --> users
4)  DB연결 설정
    <config/config.json>
5)  필요 모듈 설치
    npm i sequelize sequelize-cli mysql2
    npm i -D sequelize-sql
6)  config의 DB 생성
    npx sequelize db:create
7)  테이블 만들기
    <model2tabletest.js>
    node model2tabletest
8)  .sequelizerc파일 작성
9)  npx sequelize-sql
10) p.329~334 crud테스트

* express, sequelize, nunjucks 사용 예제
1) 프로젝트 폴더 만들기
   - mkdir ch07ESN-Test
2) 프로젝트 폴더로 이동
   - cd ch07ESN-Test
3) package.json 작성
   - npm init
4) 사용할 패키지(모듈)을 설치
   - npm i express morgan nunjucks sequelize sequelize-cli mysql2
   - npm i -D nodemon
5) sequelize-cli 실행
   - npx sequelize init
6) config/config.json 수정
7) db 생성하기
   - npx sequelize db:create
8) 생성 db와 연결
   a) models/index.js를 수정
   b) app.js 수정
9) npm start로 테스트
10) 모델 생성(models/user.js, models/comment.js)
   - 한줄로 작성
   - npx sequelize model:generate --name User --attributes
   name:string,age:integer,married:boolean,comment:text,
   created_at:date
   - npx sequelize model:generate --name Comment --attributes
   comment:string,created_at:date
11) 모델 연결(models/index.js 수정)
12) npm start로 DB서버 접속 후 테이블 생성 테스트
13) 관계정의 각 모델의 associate() 메소드 구현
14) 관계정의 적용(models/index.js 수정)

* 관계정의
   - RDB에서 table의 관계
   - 1:1 
      - 사용자:사용자정보
      - hasOne()
      - belongsTo()
   - 1:N 
      - 사용자:게시글
      - users:comments
      - 1에 해당하는 모델의 associate()메서드 구현
         - hasMany()
      - N에 해당하는 모델의 associate()메서드 구현
         - belongsTo()
   - N:M
      - 게시글:해시태그
      - belongsToMany(모델명, {through: '중간테이블명'})
      - db.sequelize.models.중간테이블명으로 JS 사용가능
   - get+모델명+s(), set+모델명+s(), add+모델명+s(), remove+모델명+s(), add+모델명()
   - user.getComments()

* RESTful하게 구현 : SPA (Single Page Application): aJax - axios
- method url  request data         response data/view
- GET  /      {}       html                   html
- POST /users {이름:'', 나이:'', 결혼여부:''}     등록된 사용자 정보 {}
- GET  /users {}                   등록된 사용자 정보들 [{},{},..]
- GET  /users/:userid/comments {}  지정된 사용자의 댓글 정보들 [{},{},..]
- POST /comments {사용자 아이디:'', 댓글:''}      등록된 댓글 정보 {}
- PATCH /comments/:commentid {수정하려는 댓글:""} 수정된 댓글 정보 - 수정된 댓글 갯수
- DELETE /comments/:commentid {}              삭제된 댓글 갯수
15) 