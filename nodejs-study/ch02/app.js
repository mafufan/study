// 옛날 방식
/* var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function () {
  if (this.readyState == 4 && this.status == 200) {
    console.log(ajax.responseText);
  }
};
ajax.open('GET', 'https://codingapple1.github.io/price.json', true);
ajax.send();
 */
// 요즘JS방식
// promise
/* fetch('https://codingapple1.github.io/price.json')
  .then(응답 => {
    if (!응답.ok) {
      throw new Error('400 아니면 500 에러남');
    }
    return 응답.json();
  })
  .then(결과 => {
    console.log(결과);
  })
  .catch(() => {
    console.log('에러남');
  }); */
// async/await
/* async function 데이터가져오는함수() {
  var 응답 = await fetch('https://codingapple1.github.io/price.json');
  if (!응답.ok) {
    throw new Error('400 아니면 500 에러남');
  }
  var 결과 = await 응답.json();
  console.log(결과);
}
데이터가져오는함수().catch(() => {
  console.log('에러남');
}); */

// 외부라이브러리 방식
// async/await
// 제이쿼리 $.ajax()
/* fetch('https://codingapple1.github.io/price.json')
  .then(응답 => {
    if (!응답.ok) {
      throw new Error('400 아니면 500 에러남');
    }
    return 응답.json();
  })
  .then(결과 => {
    console.log(결과);
  })
  .catch(() => {
    console.log('에러남');
  });
 */
// 리액트, 뷰 axios
{
  /* <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.24.0/axios.min.js"></script>;
<script>
axios
  .get('https://codingapple1.github.io/price.json')
  .then(result => {
    console.log(result.data);
  })
  .catch(() => {
    console.log('에러남');
  });

</script> */
}
