# 3. 노드 기능 알아보기

## 3.1 REPL 사용하기

- Read Eval Print Loop
- 실행: cmd창에서 node 엔터키
  - 프롬프트가 '>' 변경
  - > 명령어 입력
- 종료: .exit 엔터키 또는 ctrl+C (2회)

- VScode에서 cmd 실행(터미널)
ctrl+`(백틱), 터미널>새터미널

## 3.2 JS 파일 실행하기

- REPL이 긴 소스코드의 실행에는 적합하지 않음
- 파일로 소스코드 작성후 실행
- 실행: node 실행시킬파일의경로(js 확장자는 생략가능)

## 3.3 모듈(module)

- 하나의 서비스는 여러개의 파일로 구성
- 여러파일에서 사용되는 공통된 코드는 모듈로서 관리
- 모듈: 특정기능을 하는 함수나 객체(변수)들의 집합
  - 재사용성
  - 모듈의 정의: module.exports 객체를 정의
  - 모듈의 사용: require(사용하려는모듈의경로)
- ES6에서 모듈에 관한 추가 문법
  - 모듈과 일반 JS파일 구분: 모듈-mjs 확장자
  - import {odd,even} from './var';
  - export default 함수명 또는 객체명;

## 3.4노드의 내장 객체 알아보기

- https://nodejs.org/dist/latest-v16.x/docs/api/ 참고
- 따로 설치하지 않고 사용할 수 있는 객체

## 3.4.1 global

- 노드의 전역 객체(비교-브라우저의 window객체)
- 생략가능
- require() <-- global.require()
- console.log() <-- global.console.log()
- 전역객체라서 모든 파일에서 공공으로 사용하는 데이터를 속성으로
  정의할 수 있다. 바람직하지는 않다
  - 파일간의 공유 데이터로 사용: 남용 말기

### 3.4.2 console

- 디버깅용: 변수에 값이 제대로 들어 있는 지 확인용
- 에러 발생시 표시하기
- 코드 실행 경과 시간 알아내기

### 3.4.3 타이머 함수
- setTimeout(콜백,밀리초)
  - 1회, 반환-타이머아이디
- setInterval(콜백,밀리초)
- - 여러번, 반환-타이머아이디
- setImmediate(콜백)
  - 즉시 실행(곧바로), 반환-타이머아이디
  - setTimeout(콜백,0)보다 setImmediate(콜백) 먼저 실행, 항상 그렇지는 않음
- clearTimeout(타이머아이디)
- clearInterval(타이머아이디)
- clearImmediate(타이머아이디)

### 3.4.4 **filename, **dirname
- __filename: 현재 실행되는 파일의 경로(파일명)
- __dirname: 현재 실행되는 파일의 디렉토리 경로(폴더)
- OS별 경로 구분자
  - windows: \
  - mac, linux: /

### 3.4.5 module, exports, require
- 모듈 작성하기
  - module.exports 사용
    - 객체를 모듈로서 정의 가능
  - exports 사용
    - 객체 모듈로 사용하면 오류 유발 가능
    - exports의 속성으로 정의해야 함
  - exports === module.exports ===> true
@노드에서의 this의미 vs 브라우저에서의 this의 의미

- 최상위 스코프(anonymous스코프)의 this:
  {}, this === exports === module.exports
- 함수 스코프에서의 this: global객체
- 화살표 함수 스코프의 this: this === exports === module.exports

- 참고: 브라우저에서 this
  - 최상위 : window객체
  - 함수내 : window객체
  - 화살표 함수내 : window객체
- 주의: 화살표 함수내의 this
  - 화살표 함수를 감싸고 있는 환경(context)의 this

* require(사용하려는모듈의경로): 함수호출-반환값?

  - 반환값: 객체 또는 함수
  - require(): 함수-->함수객체-->속성을 가질 수 있다.
  - require.cache
    - 모듈을 로딩 정보
    - 한번 로딩된 모듈은 require 다시 되더라도 로드된 모듈 사용
  - require.main
    - require.main.filename: 현재 메인 모듈의 파일명
    - require.main.filename === __filename

* 주의 사항
  - 모듈과 require 상호 참조 안되게 하자!
  - 순환참조

### 3.4.6 process

- process vs. thread
- process: 실행되고 있는 노드 프로세스 정보 객체

#### 3.4.6.1 process.env

- node의 실행환경(environment)정보
- 환경변수
  - 키=값 형태로 지정
  - 용도: 비밀키, 액세스키 저장하기

#### 3.4.6.2 process.env
- task

* setTimeout(콜백,0)
* setImmediate(콜백)

- microtask- 태스크의 타이머보다 먼저 실행, 우선순위 높음
  - process.nextTick(콜백)
  - promise.resolve().then(콜백)
  - 사용시 주의 사항: 재귀호출 등 시간이 많이 걸리는 작업 회피하기ㅇㅇㅇ

#### 3.4.6.3 process.exit(종료코드)
- 노드의 프로세스를 종료시킴
- process.exit(0) 또는 process.exit(): 정상 종료
- process.exit(1) : 비정상 종료

## 3.5 노드 내장 모듈
- require(사용할모듈명)으로 임포트한 후 사용 가능

### 3.5.1 os
* os: operating system: 운영체제
* EADDRINUSE : os.contants

### 3.5.2 path
* 폴더나 파일의 경로 정보를 다루는 모듈
* OS별로 경로 구분자가 다름
  - Windows : \
  - POSIX(mac, linux) : /
* 폴더나 파일에 대한 처리, 관리 기능

* 노드에서 상대 경로의 기준점:
  - require.main.filename == __filename

### 3.5.3 url
* url정보 처리 및 관리를 위한 모듈
* 2가지 방식
  - old style(기존방식, 노드 6까지) : legacy방식
    - path와 query 중요
      - querystring 모듈
  - new style(WHATWG방식,노드 7이후)
    - searchParams객체

### 3.5.5 crypto(암호화)
* 용어
  - 평문 : 암호화 하고 싶은 데이터
  - 암호문 : 암호화된 데이터
  - 암호화(encoding) : 평문 ---> 암호문
  - 복호화(decoding) : 암호문 ---> 평문
* 종류
  - 단방향 암호화
    - 암호화만 가능한 방식
    - 해시 함수 (hash function) : 문자열을 특정길이의 다른 문자열로 바꾸는 함수
    - 로그인 처리시 패스워드 정보
  - 양방향 암호화
    - 암호화와 복호화가 가능한 방식
    - 인증서, https

#### 3.5.5.1 단방향 암호화
* 암호화를 복잡하게 하기 위해 pbkdf2, script, bscript 사용
  - 평문+salt한 문자열을 해시함수로 반복횟수만큼 반복적용하여 암호처리
  - bscript으로 교과서는 암호화 처리

#### 3.5.5.2 양방향 암호화
* 암호화, 복호화가 가능
  - 키(열쇠) : 비밀키, 공개키

### 3.5.6 util - 도구
* 각종 편의 기능을 모아둔 모듈
* deprecated 많음

### 3.5.7 worker_threads
* 멀티 쓰레드 코딩을 위한 모듈
* 쓰레드: 프로세스내의 실행흐름(작업 work단위)
* 싱글쓰레드: 부모쓰레드, 메인쓰레드 (main thread)
* 워커쓰레드 (worker_threads)
* 메인 쓰레드에서 워커쓰레드를 생성하여 실행시킴
* 메인 쓰레드와 워커쓰레드 간의 데이터 공유: workerData이용
* isMainThread, parentPort, on(), new Worker(), postMessage()
* 실질적예제: 소수찾기
  * 소수 (prime number)
    - 약수로 1과 자기자신의 수로만 되어 있는 숫자
    - 암호에 사용
    - 1, 2, 3, 5, 7, 11, 13, 17...
* 단, 멀티쓰레드 프로그래밍은 잘못하는 경우 속도 느려 질 수 있음 주의
  - 쓰레드 생성하고 쓰레드 사이의 통신(데이터 주고 받고)의 비용이 많이 발생
  - 비용: cpu 시간

### 3.5.8 child_process
* 노드에서 다른 프로그램을 실행하거나 명령어(shell명령어)를 실행하려고 할 때 사용
* exec
  - shell명령어 처리
* spawn
  - shell명령어 처리, 다른 프로그램 실행

## 3.6 FS (file system)
* FS 모듈: 파일 또는 폴더의 생성, 삭제, 읽기(read), 쓰기(write)
* Buffer 개념
  - 메모리에 들어가 있는 데이터
  - 8bits 16진수로 표현
* 동기/비동기
  * 노드의 내장 모듈들은 비동기 동작
  * 비동기 동작 메소드
    - 메소드명() : readFile()
  * 동기 동작 메소드
    - 메소드명Sync() : readFileSync()

### 3.6.1 동기/비동기
* 콜백지옥 --> 프로미스 --> async/await

### 3.6.2 Buffer/Stream
* 파일을 읽고 쓰는 방식
  - Buffer 방식
    - 일정크기로 읽기/쓰기를 하는 것
    - const 버퍼객체명 = Buffer.from(문자열)
    - 버퍼객체명.toString()
    - 버퍼객체명.length
    - 버퍼객체명.concat(배열)
    - const 버퍼객체명 = Buffer.concat(문자열)
    - const 버퍼객체명 = Buffer.alloc(바이트단위크기)
  - stream 방식
    - 내부적으로 버퍼 사용
    - 데이터를 흘려 보내는 듯하게 함

### 3.6.3 기타 fs 메서드

### 3.6.4 쓰레드풀(pool)

### 3.7 이벤트
* 사용자 정의 이벤트 처리
* EventEmitter객체
* 1. 이벤트객체 생성: new EventEmitter();
* 2. 이벤트 발생 시키기: 이벤트객체명.emit(이벤트명);
* 3. 이벤트 핸들러 등록: 이벤트객체명.on(이벤트명,콜백)
                     이벤트객체명.once(이벤트명,콜백) : 한번만 실행
*                    이벤트객체명.addListener(이벤트명,콜백)
* 4. 이벤트 핸들러 취소/삭제: 이벤트객체명.off(이벤트명,콜백)
*                    이벤트객체명.removeListener(이벤트명,콜백)
                     조건: 등록시의 콜백과 같은 콜백사용
                     이벤트객체명.removeAllListeners(이벤트명)
* 5. 등록된 이벤트핸들러 갯수: 이벤트객체명.listenerCount(이벤트명)                 

## 3.8 예외
* try~catch(err) 처리
* 임의로 예외 발생: throw new Error(에러메시지)