# 2. 알아야하는 JS 문법
- https://ko.javascript.info/
- https://developer.mozilla.org/ko/docs/Web/javaScript
- https://www.w3schools.com/js/default.asp

## 2.1 ES2015+/ES6+
- 2015년 JS에 대변혁 버전 발표
- ECMAScript 2015버전
- 노드를 위해서 최신 문법을 이해할 필요가 있다.
- ie(인터넷익스플로어)와 같이 최신문법 이해 못하는 브라우저를 위해 babel 도구 이용 처리해야 할 필요 있음

### 노드의 실행법
1. 노드 REPL사용
  REPL (Read-Eval-Print Loop) - Python IDLE
  '>'으로 프롬프트가 변경됨
  cmd창에서 node + 엔터키 입력
  VSCode에서 cmd 실행: Ctrl+`(백틱)
  종료: Ctrl+C 2회, .exit + 엔터키
2. 파일로 실행
  cmd창에서 다음을 입력
  node '실행하려고하는파일명'+ 엔터키 입력
  node .\ch02.js

### 2.1.1 const, let
- old: var로 변수선언
  - 사용범위(스코프): 함수
  - Hoisting 문제 발생
  - 호이스팅: 함수내의 선언들을 모두 최상단으로 옮겨 실행
    - 변수의 스코프가 함수 내로 변경
    - 잠재적인 버그를 유발
    - 모든 것은 사용하기전에 선언과 초기화, 정의한 후 사용하기로 대응
- new: const, let이용
  - 스코프: 블록 - {~}
  - 호이스팅 발생하면 에러되도록
  - 모든 것은 사용하기전에 선언과초기화해야 함
  - 선언 초기화 후 사용가능
  - const vs let
    - const : 최초할당 필수, 재할당불가
    - let : 재할당 가능

### 2.1.2 템플릿 문자열(Template String)
- 백틱(`)
- 템플릿문자열내에 변수또는 JS코드입력가능
- `${변수명또는JS코드}`

### 2.1.3 객체 리터럴(Object Literal)
- 리터널: 구체적인 값
  - 숫자 리터럴: 1234, 12.34
  - 문자열 리터럴: '테스트'
  - 객체 리터럴: {}
  - 배열: [~,~]

### 2.1.4 화살표 함수
* arrow function : => 기호 사용하여 함수 정의
* (매개변수리스트)=>{실행문장들;}
* 기존함수에서 this와 화살표 함수에서의 this가 다름
  - binding(묶는다)차이
  - 기존함수에서 this: global 객체
  - 화살표함수에서 this: 화살표함수를 포함하는 외부 스코프(상위스코프)의 객체

### 2.1.5 구조분해 할당 (destructuring assignment)
* 객체의 구조분해 할당
  - const {변수명리스트} = 객체명;
  - const 변수명 = 객체명.속성명; // 속성명===변수명
* 배열의 구조분해 할당
  - 인덱스 위치 값
  - const [해당위치의 변수명,] = 배열명;

### 2.1.6 클래스
* 기존: prototype으로 객체지향적으로 코드 구현
* 신버전: class문법 도입, 내부적인 동작은 prototype형태로 작동

### 2.1.7 프로미스(Promise)
* 실행완료를 보장(약속)하는 객체
  * 콜백실행을 성공, 실패로 분리해서 정의하여 사용
* Callback Hell(지옥)을 극복하기 위해 사용
  - ES6부터 프로미스 사용 해결
* 콜백 - 비동기 동작하지만, 여러개의 콜백이 순서대로 실행되어야 할
  필요가 있으면 콜백함수내에서 콜백함수를 정의해서 해결
* 사용규칙
  - 1. 프로미스 객체 생성
    - 생성자에 파라미터: 콜백
    - 콜백(resolve, reject)
  - 2. 생성된 객체에 then(), catch(), finally()의 매개변수로 콜백 정의
    - 프로미스 객체의 실행이 성공하면  then()의 콜백실행
    - 실패하면 catch() 콜백 실행
    - 모든경우에 실행 finally() 콜백 실행
* 콜백지옥 해결 위해서 프로미스 실행 상황에서 then()콜백에서 다시
  프로미스객체 생성하여 리턴
  리턴된 프로미스객체에 대한 then()처리
  연속적으로 then()처리: 프로미스 체이닝
* 콜백지옥: 콜백depth가 깊은 경우

* 여러개의 콜백이 모두 완료한 뒤 처리하려고 하는경우
* Promise.all(모두완료시키려고하는 프로미스 객체들)
* Promise.resolve(), Promise.reject() : 바로 성공/실패
  처리하도록 시키는 프로미스객체 생성
* Promise.race(프로미스객체들)
  
### 2.1.8 async/await
* 프로미스로 콜백지옥은 어느정도 해결되었지만
  아직도 코드 해석하는데 어려움이 있음
* 프로미스는 아직도 가독성이 좋지 않음
* 가독성을 높이기 위해 노드 7.6버전(ES2017)이후
  - async/await
  - 비동기 동작하는 것을 동기적으로 동작하는 코드로 작성가능
  - async/await으로 만들기
    - 1. 비동기 동작을 하는 코드묶음을 async 키워드로 정의
    - 2. 각각의 비동기 동작 코드(함수호출) 앞에 await 키워드  
* async 함수는 항상 Promise 객체를 반환(return)
  then(), catch()처리가능하다, async/await처리 가능

## 2.2 프론트엔드 JS
* HTML관련된 JS, 브라우저에서 실행
* html파일내의 script태그내의 Js
  - BOM
    - Browser Object Model : window객체
      - document, location, href, navigation, geolocation 객체 등
  - DOM
    - document객체
      - createElement, createTextNode()
      - querySelect(), querySelectAll(),
      - getElementById(), getElementsByTagName()
      - getElementsByClassName()
      - textContent, innerHTML, innerText
      - append(), appendChild()

## 2.2.1 AJAX(Asynchronous JavaScript And XML)
  - XML ---> JSON 으로 바뀌고 있다
  - Web 2.0 시작
  - Mashup가능, OpenAPI
  - 웹페이지 이동없이 (웹페이지 전환없이) 서버에 요청을 보내고 응답을 받는 기술
  - XMLHttpRequests객체를 사용
    - JQuery.ajax(), fetch, axios
      - fetch : JS 표준 라이브러리
      - axios 설치해야하는 라이브러리
  - axios 사용하기
    - 설치
      - npm install axios
    - CDN활용
      - <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
      - <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    - 브라우저에서 서버로 요청 방법
      - get/post/delete/put/patch/options
      - axios.get()
      - axios.post() ...

  
### 2.2.2 FormData
* html의 form태그 정보를 동적으로 제어할 수 있도록 해주는 객체
* 주로 AJAX와 함께 사용

### 2.2.3 encodeURIComponent, decodeURIComponent
* 주소에 한글이 있는 경우 한글처리하기 위해 사용
* https://www.zerocho.com/api/search/노드
* https://www.zerocho.com/api/search/%EB%85%B8%EB%93%9C
* 서버로 보낼 때 : encodeURIComponent(처리할한글문자열);
* 서버로부터 받을 때 : decodeURIComponent(받은문자열);
* encodeURIComponent('영진'); // '%EC%98%81%EC%A7%84'
* decodeURIComponent('%EC%98%81%EC%A7%84') // '영진'

### 2.2.4 데이터 속성, dataset
* 데이터 속성: html 태그의 속성 사용자정의 속성 사용하기
  data - 사용자정의속성명
  data - 사용자정의속성명1- 사용자정의속성명2 ---> snake-case
* dataset: 사용자정의 속성을 JS에서 다룰 때 사용
  dataset.사용자정의속성명
  dataset.사용자정의속성명1사용자정의속성명2(사용자정의속성명2의 첫글자는 대문자) ---> camelCase