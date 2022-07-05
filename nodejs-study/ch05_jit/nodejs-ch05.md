# 5. 패키지 매니저
## 5.1 npm
* npm
  - node package manager
  - 노드 패키지 매니저
* 패키지: npm 공홈에 업로드된 모듈
  - module.exports
* npm: 공홈 https://www.npmjs.com/
* yarn
  * 공홈:https://yarnpkg.com/
  * 기능: npm과 유사
  * 페북에서 만듬

## 5.2 package.json 패키지 관리
* 노드로 프로젝트를 하려고 할 때 맨먼저 해야 하는일
  - package.json을 작성
  - 의존성 관리
  
* 실습
  1) 터미널에서 프로젝트 폴더 작성
    - mkdir ch05_jit
  2) 프로젝트 폴더로 이동
    - cd ch05_jit
  3) package.json을 작성
    - package.json을 복사해 와서 수정
    - npm init 명령어

* npm 명령어
  - cheatsheet 활용
  - npm init
  - npm run test/npm test
  - npm run start/npm start
  - npm run (package.json의 scripts속성에 정의한 명령어)
  - npm install [패키지명1, 패키지명2,...]
  - npm i [패키지명1, 패키지명2,...]
    - 옵션
    - --save
      - 생략가능
      - package.json에 dependencies 속성이 생성
    - --save-dev
      - package.json에 devDependencies 속성이 생성
      - -D로 축약
    - -global
      - -g로 축약
      - 설치가 npm설치된 폴더의 node_modules 폴더에 설치
      - 명령어 도구 패키지 설치
  - 결과
    - package.json 속성추가
    - node_modules생성
    - package-lock.json 생성

* 과제 제출, github에 업로드할때 node_modules 폴더는 제외

* --global 옵션 설치가 싫으면
  - npm i -D rimraf
  - npx rimraf node_modules

* 프로젝트 폴더에 package.json 만 있으면 다시 환경 구성이
  가능하다.
  - 프로젝트 폴더에서 npm i 명령입력

## 5.3 패키지 버전
* SemVer 방식
  - Semantic Versioning(유의적인 버전)
  - x.y.z
    - x: major
      - 정식, 화위 호환성 고려하지 않고 변경
    - y: minor
      - 하위호환성 고려하여 변경
    - z: patch
      - 기능의 업데이트, 간단 버그 수정
  - 기호
    - ^: minor 업데이트부분 수용
      - npm i express@^1.1.1 (1.1.1~1.9.9)
      - npm i express@1.x.x
    - ~: patch 업데이트 수용
      - npm i express@~1.1.1 (1.1.1~1.1.9)
      - npm i express@1.1.x
    - >, >=, <, <=
      - npm i express@>1.1.1

  - 가장 최신 버전: npm i 패키지명@latest
  - 알파,베타,버전: npm i 패키지명@next