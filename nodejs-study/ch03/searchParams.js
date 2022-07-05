const { URL } = require('url');

const myURL = new URL(
  'http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript'
);
console.log('searchParams:', myURL.searchParams);
// p.83 FormData
console.log(
  'searchParams.getAll():',
  myURL.searchParams.getAll('category')
);
console.log(
  'searchParams.get():',
  myURL.searchParams.get('limit')
);
console.log(
  'searchParams.has():',
  myURL.searchParams.has('page')
);

console.log(
  'searchParams.keys():',
  myURL.searchParams.keys()
);
console.log(
  'searchParams.values():',
  myURL.searchParams.values()
);
// keys(): key=value에서 key들을 반환(Iterator)
// values(): key=value에서 value들을 반환(Iterator)

myURL.searchParams.append('filter', 'es3');
myURL.searchParams.append('filter', 'es5');
console.log(myURL.searchParams.getAll('filter'));

myURL.searchParams.set('filter', 'es6');
console.log(myURL.searchParams.getAll('filter'));

myURL.searchParams.delete('filter');
console.log(myURL.searchParams.getAll('filter'));

console.log(
  'searchParams.toString():',
  myURL.searchParams.toString()
);
myURL.search = myURL.searchParams.toString();
