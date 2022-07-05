async function getUser() {
  // 로딩 시 사용자 가져오는 함수의 정의
  try {
    const res = await axios.get('/users');
    // GET /users 요청
    const users = res.data; // 응답의 body 는 data 속성
    // const list = document.getElementById('list');
    const list = document.querySelector('#list');
    // restFront.html의 <div id="list"></div>

    list.innerHTML = ''; // div태그내용 지우기
    // innerHTML
    // innerText
    // textContent

    // 사용자마다 반복적으로 화면 표시 및 이벤트 연결
    // users : {Date.now():'김영진',Date.now():'이영진',...}
    // {164906213991:'김영진', 164906219333:'이영진', ... }

    Object.keys(users)
      //  [164906213991, 164906219333, ...]
      .map(function (key, index, array) {
        // .forEach()
        const userDiv = document.createElement('div'); //<div></div>
        const span = document.createElement('span'); //<span></span>
        span.textContent = users[key];
        // <span>users[key](->users[164906213991]->김영진)</span>
        const edit = document.createElement('button'); //<button></button>
        edit.textContent = '수정'; //<button>수정</button>
        edit.addEventListener('click', async () => {
          // 수정 버튼 클릭
          //<button onclick='async()=>{}'></button>
          const name = prompt('바꿀 이름을 입력하세요');
          if (!name) {
            return alert('이름을 반드시 입력하셔야 합니다');
          }
          try {
            await axios.put('/user/' + key, { name });
            // PUT /user/164906213991
            // 요청 body: { name }
            getUser();
          } catch (err) {
            console.error(err);
          }
        });
        const remove = document.createElement('button'); //<button></button>
        remove.textContent = '삭제'; //<button>삭제</button>
        remove.addEventListener('click', async () => {
          // 삭제 버튼 클릭
          //<button onclick='async()=>{}'>삭제</button>
          try {
            await axios.delete('/user/' + key);
            // DELETE 요청 /user/164906213991
            getUser();
          } catch (err) {
            console.error(err);
          }
        });
        userDiv.appendChild(span);
        userDiv.appendChild(edit);
        userDiv.appendChild(remove);
        // userDiv.append(span, edit, remove);
        list.appendChild(userDiv);
        /*
        <div id="list">
          <span>김영진</span>
          <button onclick='async()=>{}'>수정</button>
          <button onclick='async()=>{}'>삭제</button>
          <span>이영진</span>
          <button onclick='async()=>{}'>수정</button>
          <button onclick='async()=>{}'>삭제</button>
          <span>최영진</span>
          <button onclick='async()=>{}'>수정</button>
          <button onclick='async()=>{}'>삭제</button>
        </div>
        */
        console.log(res.data);
      });
  } catch (err) {
    console.error(err);
  }
}

window.onload = getUser; // 화면 로딩 시 getUser 호출
// load : 웹브라우저에서 화면정보를 읽어서 로딩되면 발생하는 이벤트
// onload : load이벤트 처리하는 이벤트 핸들러 정보를 등록하는 속성
// window.addEventListener('load',getUser);
// window.addEventListener('load',getUser()); --> X
// java의 main()과 유사한 역할

// 폼 제출(submit) 시 실행
//document.getElementById('form')
document.querySelector('#form').addEventListener(
  'submit', // 이벤트
  async e => {
    // 이벤트 핸들러, e: 이벤트 객체
    e.preventDefault(); // 발생한 이벤트의 본래기능을 중지
    const name = e.target.username.value;
    // e.target:?? 이벤트가 발생한 엘리먼트 객체: form태그의 객체
    // e.target.username: id가 username인 엘리먼트 객체
    if (!name) {
      // name이 "" (빈문자열)이면
      return alert('이름을 입력하세요');
    }
    // name이 ""값이 아닌 경우
    try {
      // const res =
      await axios.post('/user', { name });
      // POST /user 요청
      // request body: { name } ===> {name:name}
      getUser();
    } catch (err) {
      console.error(err);
    }
    e.target.username.value = '';
    //input태그 내용 빈칸으로 지우기
  }
);
