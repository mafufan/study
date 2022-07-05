# 8. Mongo : Mongoose
## 8.1 NoSQL vs SQL
* MySQL: SQL DB, RDBMS의 명칭
  - 관계형 DB를 관리하는 시스템 중 하나
  - PostgreSQL, MariaDB

* NoSQL: Not Only SQL
  - SQL을 주로 사용하지 않는다
  - 객체 기반의 자바스크립트로 관리
  - MongoDB, CenterDB, Firebase
  - 빅데이터

* 348페이지 표 8-1 비교
  - SQL : NoSQL
    테이블: 컬렉션(Collection))
    로우(Row): 문서(Document)
    컬럼(Column): 필드(field, key:value)
  - Mongoose관련
    스키마라는 개념으로 도움
    populate()이용 join기능 처리


## 8.2 몽고디비 설치
## 8.3 컴퍼스 설치 
## 8.4 DB생성 및 컬렉션 생성
## 8.5 CRUD 작업
## 8.6 Mongoose 사용
* MySQL:Mongo = Sequelize:Mongoose
* Sequelize: Mongoose = ORM: ODM(Object Document Mapping)

* Schema정의 가능
* populate가능: Join기능 구현
* 프로미스기반, 쿼리빌드 지원

## 8.7 프로젝트 개발
1) 7장 프로젝트 복사
   ch08ESN-Test-Mongo 폴더로 복사
   node_modules제외
2) sequelize관련 폴더 삭제
  - config, migrations, seeders, models 폴더 삭제
3) 명령창(cmd, powershell 등)
   > npm uninstall sequelize sequelize-cli mysql2 # node_modules도
   복사한 경우
   package.json에서 sequelize sequelize-cli mysql2 항목 삭제
   > npm i
   > npm i mongoose@5.9.10 # 6.3.6 버전

4) schemas 폴더 생성
5) schemas 폴더 이동하여 index.js 생성
6) app.js 목고 디비 설정 실행
   sequelize 부분 삭제
   mongoose 부분 작성  
7) 스키마 생성(user,comment) 381, 382 페이지 참고
8) view에 sequelize.html==>mongoose.html변경
9) public/js/sequelize.js==>mongoose.js변경
10) route/index.js에 내용을 변경
11) mongoose.js 내용 변경
    .id ===> ._id
    td.textContent = comment.User.name;
    => td.textontent = comment.commenter.name;
12) routes/user.s 수정
    findAll() => find()
      create() ==> create()
      join 기능
      const comments = await Comment.find({
        
      })

143) route
const result = await Comment.update{

}