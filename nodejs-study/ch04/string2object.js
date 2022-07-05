const parseCookies = // 함수 정의
  (cookie = '') => {
    // cookie = testData
    console.log(cookie);
    return cookie // 메소드 체인
      .split(';') // ;를 기준으로 배열 생성
      .map(v => v.split('='));
    //[ 'name=%EA%B9%80%EC%98%81%EC%A7%84', 'test=1234', 'tt=twice' ]
    /*
      [
        [ 'name', '%EA%B9%80%EC%98%81%EC%A7%84' ],
        [ 'test', '1234' ],
        [ 'tt', 'twice' ]
      ]
      */
    // .reduce((acc, [k, v]) => {
    //   acc[k.trim()] = decodeURIComponent(v);
    //   return acc;
    // }, {});
  };

// 함수의 사용
// 호출
const testData = `name=${encodeURIComponent(
  '김영진'
)};test=1234;tt=twice`;
console.log(parseCookies(testData));

/* const parseCookies = (cookie = '') =>
  cookie // 메소드 체인
    .split(';')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});
 */
