# 4. http 모듈: 서버 작성
* 쿠키, 세션, 요청 주소별 라우팅 처리, RESTful API

## 4.1 요청, 응답 이해
* Request
* Response
* 이벤트 처리와 유사하다

* http메시지 구조
  - 요청메시지
    - 헤더 + 바디
  - 응답메시지
    - 헤더 + 바디

* 서버의 실행: node 서버js파일
* 서버의 종료: Ctrl+C
* 

* 매번 요청에 대해 소스코드로 html응답 메시지를 작성하는 것 어려움
  * 해결법: html파일을 미리 작성하여 두고 요청이 들어오면 해당 파일을 읽어서 전송

* http 상태코드 (status code) : 응답 코드
  - 요청이 성공/실패 여부 확인
  - 2XX: 성공
    - 200: 성공
    - 201: 작성됨
  - 3XX: redirection : 페이지 전환
    - 301: 영구이동
    - 302: 임시이동
    - 304: 수정되지 않음: 캐시됨
  - 4XX: 요청 오류
    - 400: 잘못된 요청
    - 401: 권한없음 (unauthorized)
    - 403: 금지됨 (forbidden)
    - 404: 파일못찾음 (file not found)
  - 5XX: 서버측 오류, 프로그래머가 직접 writeHead하는 경우가 드물다
    - 500: 내부 서버 오류
    - 502: 불량 게이트웨이
    - 503: 서비스를 사용할 수 없음

* 요청은 반드시 응답받아 처리해야 함
  - 요청이 일정시간 이후로도 응답 못 받으면 Timeout 처리

## 4.2 REST & Routing
* 웹에서의 요청
  * /index.html : 파일 전송해줘 요청
  * 주소로 파일지정
* REST : REpresentational State Transfer - 대표적인(상징적) 상태 전달
  - 서버의 자원을 요청하는 대표적인 방법을 정의하는 약속
  - 서버의 자원(resource)
    - 파일: html, css, js, jpg등 이미지, mp3등의 음원, mp4등의 영상 등등
    - 서버가 실행할 수 있는 기능들: 사용자 로그인해줘, 로그아웃해줘
  - 정의 방법
    - url과 요청메서드를 함께 표시
  - REST하게 정의된 정보: REST API
  - REST API 구성
    - url: 명사형으로 설정
    - http request method(요청메서드)
      - GET: read, 서버 자원 읽기, 쿼리스트링이용
      - POST: 서버에 자원을 등록(create), form태그, FormData이용
        - http요청메시지의 body 정보로 등록 정보 전송
      - PUT: 덮어쓰기
      - PATCH: 일부수정
        - body정보에 수정내용을 저장하여 전송
      - DELETE
        - 자원의 삭제, 쿼리스트링
      - OPTIONS
        - 요청전 통신 옵션을 설정
  - REST API 예시
    - GET /users : 사용자 정보를 읽어와라
    - POST /users: body정보를 참고해서 사용자정보를 등록해라
  - 장점
    - 직관적으로 REST API주소만 참고하면 어떤 요청인지 파악가능
    - 서비스를 하는 새로운 장비가 도입되면 REST API처리만 가능하게 하면 서버의 수정이 필요 없다.
      서버의 업그레이드하더라도 REST API처리되어 있으면 클라이언트 소스코드의 수정 필요 없다
  - RESTful: REST API로 개발한 것
    - RESTful 웹서버

* req, res,
  - req: 요청정보객체(readStream으로 내부구현)
    - req.method
      - 요청메소드 정보
    - req.url
      - 요청 url정보
      - req.headers.cookie
        - 요청시 쿠키 정보
        -
  - res: 응답정보객체(writeStream으로 내부구현)
    - res.writeHead()
      - res.writeHead(응답코드,{'Set-Cookie':'키1 = 값1; 키2 = 값2; 키3 = 값3;....'});
      - 브라우저로 쿠키값 전달하기
    - res.write()
    - res.end()

* JSON객체 -> 문자열: const 문자열명 = JSON.stringify(JSON객체명);
* 문자열 -> JSON객체: const JSON객체명 = JSON.parse(문자열명);


## 4.3 cookie, session
* cookie:
  - 요청 보낸 사람을 구별하고자 만든 것
  - 정보를 클라이언트에서 저장
  - 브라우저가 최초 요청: 서버에서 쿠키를 만들어서 전송해줌
  - 브라우저가 최초 요청 이후 요청마다: 요청정보에 쿠키값을 함께 전송
  - 쿠키값의 구성
    - 키1 = 값1; 키2 = 값2; 키3 = 값3;....
  - 쿠키값에 유효기간을 줄수 있다.
  - 쿠키값에는 개행문자,한글 쓸 수 없다.  ASCII코드만 사용가능
  - 쿠키명=쿠키값
  - Expires=날짜
    - 만료기간, 만료기간 이후 쿠키값은 삭제됨
    - 기본값: 브라우저 종료까지
  - Max-age=초
    - 만료기간, 초단위, Expires 보다 우선순위 높다
  - Domain=도메인명
    - 쿠키가 전송될 도메인을 특정, 기본값: 현재도메인
  - Path=URL
    - 쿠키가 전송된 URL을 특정, 기본값: / --> 모든 URL로 쿠키가 전송될 수 있다.
  - Secure: HTTPS처리
  - HttpOnly: 자바스크립트에서 쿠키값 접근 불가능
* session
  - 쿠키와 함께 로그인 구현을 위해 사용
  - 주요 정보를 서버에서 관리
  - 세션을 위해 사용되는 쿠키: 세션쿠키
## 4.4 https, http2
* https
  - s: secure
  - http+SSL
  - 요청과 응답 사이의 송수신정보를 암호화
  - 인증서 필요
  - 공인인증서 발급 받아서 처리해야 함
    - Let's Encrypt 사이트 등
  - require('https');
  - https.createServer(인증서관련 옵션 객체, 콜백(req, res))

* http2
  - https+버전2
  - 성능 개선한 http 버전2를 사용
  - require('http2')
  - http2.createSecureServer(인증서 관련 옵션 객체, 콜백(req, res))
  - http/1.1 대세, http/2 언제 사용 정착될지/

## 4.5 cluster
* 멀티프로세싱 vs 멀티쓰레딩
* 멀티프로세싱관련, p.135 chid_process
* 성능 개선 장점, 단점: 코딩 장벽 높고 프로세스간 메모리 공유 -> 안됨
  - 레디스 등 사용으로 단점 보완
* 실무에선 pm2 모듈 사용