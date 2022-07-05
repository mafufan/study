// 사용자 등록
document.querySelector('#user-form').addEventListener('submit', async event => {
  event.preventDefault();
  const name = event.target.username.value;
  // event.target.html-input-id명.value;
  const age = event.target.age.value;
  const married = event.target.married.checked;
  // checkbox인 경울 checked로 값 읽어 옴

  if (!name) {
    // 입력값의 validation
    return alert('이름을 입력하세요');
  }
  if (!age) {
    return alert('나이를 입력하세요');
  }

  // 요청 처리
  try {
    const result = await axios.post('/users', { name, age, married });
    getUser();
    console.log(result.data);
  } catch (err) {
    console.error(err);
  }

  // 이전 등록 정보 없애고 입력받을 준비 시키는 코드
  event.target.username.value = '';
  event.target.age.value = '';
  event.target.married.checked = false;
});

const getUser = async () => {
  try {
    const result = await axios.get('/users');
    const users = result.data;
    console.log(users);
    //[{ id:'',name:'',age:'',comment:'',created_at:''},
    // { id:'',name:'',age:'',comment:'',created_at:''},]
    const tbody = document.querySelector('#user-list tbody');
    tbody.innerHTML = '';
    // tbody.textContent = '';
    users.map((user, index) => {
      const tr = document.createElement('tr');
      let td = document.createElement('td');
      tr.addEventListener('click', () => {
        console.log(test);
        getComments(user.id);
      });
      td.textContent = user.id;
      tr.appendChild(td);
      td = document.createElement('td');
      td.textContent = user.name;
      tr.appendChild(td);
      td = document.createElement('td');
      td.textContent = user.age;
      tr.appendChild(td);
      td = document.createElement('td');
      td.textContent = user.married ? '기혼' : '미혼';
      tr.appendChild(td);

      tbody.appendChild(tr);
    });
  } catch (err) {
    console.error(err);
  }
};

// 댓글 등록 시
document.querySelector('#comment-form').addEventListener('submit', async event => {
  event.preventDefault();
  const commenter = event.target.commenter.value;
  const comment = event.target.comment.value;
  if (!commenter) {
    return alert('댓글작성자 ID를 입력하세요');
  }
  if (!comment) {
    return alert('댓글을 입력하세요');
  }
  try {
    await axios.post('/comments', { commenter, comment });
    getComments(commenter);
    console.log(result.data);
  } catch (err) {
    console.error(err);
  }
  event.target.commenter.value = '';
  event.target.comment.value = '';
});

async function getComments(id) {
  try {
    const result = await axios.get(`/users/${id}/comments`);
    const comments = result.data;
    console.log(comments);
    const tbody = document.querySelector('#comment-list tbody');
    tbody.innerHTML = '';
    comments.map((comment, index) => {
      const tr = document.createElement('tr');
      let td = document.createElement('td');
      td.textContent = comment.id;
      tr.appendChild(td);
      td = document.createElement('td');
      td.textContent = comment.User.name;
      tr.appendChild(td);
      td = document.createElement('td');
      td.textContent = comment.comment;
      tr.appendChild(td);
      const editBtn = document.createElement('button');
      editBtn.textContent = '수정';
      editBtn.addEventListener('click', async () => {
        const newComment = prompt('바꿀 내용 입력하세요.');
        if (!newComment) {
          return alert('바꿀내용을 반드시 입력해야 수정가능.');
        }
        try {
          const result = await axios.patch(`/comments/${comment.id}`, { comment: newComment });
          console.log(result.data);
          getComments(id);
        } catch (err) {
          console.error(err);
        }
      });
      td = document.createElement('td');
      tr.appendChild(editBtn);
      const delBtn = document.createElement('button');
      delBtn.textContent = '삭제';
      delBtn.addEventListener('click', async () => {
        try {
          const result = await axios.delete(`/comments/${comment.id}`);
          console.log(result.data);
          getComments(id);
        } catch (err) {
          console.error(err);
        }
      });
      td = document.createElement('td');
      tr.appendChild(delBtn);
      tbody.appendChild(tr);
    });
  } catch (err) {
    console.error(err);
  }
}
