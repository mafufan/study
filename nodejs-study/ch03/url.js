const url = require('url');

const { URL } = url;
const myURL = new URL(
  'http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor'
);
// WHATWG url 객체 생성
console.log('new URL():', myURL);
console.log('url.format():', url.format(myURL));
// format(객체) : 문자열로 반환
console.log('------------------------------');
const parsedUrl = url.parse(
  'http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor'
);
// parse(문자열) : 객체 반환 - legacy url 객체
console.log('url.parse():', parsedUrl);
console.log('url.format():', url.format(parsedUrl));
