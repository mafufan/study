const str = 'fruits1=apple; fruits2=banana; fruits3=kiwi';
/*
console.log(decodeURIComponent(`${str}`));
const parseCookies = (cookie = '') =>
  cookie
    .split(';')
    .map(v => v.split('='))
    .reduce((acc, [k, v]) => {
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});

const cookies = parseCookies(str);

console.log(cookies);
 */

const Fn1 = (cookie = '') => {
  return cookie;
};

const result = Fn1(str);
console.log(result);
