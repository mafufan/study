const path = require('path');

const string = __filename;

console.log(require.filename);
console.log('__filename : ', string); // 현재 파일 경로
console.log('path.set : ', path.sep); // /
console.log('path.delimiter : ', path.delimiter);
console.log('path.dirname() : ', path.dirname(string));
console.log('path.extname() : ', path.extname(string));
console.log('path.basename() : ', path.basename(string));
console.log(
  'path.basename - extname : ',
  path.basename(string, path.extname(string))
);
console.log('path.parse() : ', path.parse(string));
console.log(
  'path.format() : ',
  path.format(path.parse(string))
);
console.log(
  'path.normalize() : ',
  path.normalize('/Users/6oz/bin//user\\zerocho\\path.js')
);
console.log(
  'path.isAbsolute() : ',
  path.isAbsolute(string)
);
console.log(
  'path.isAbsolute() : ',
  path.isAbsolute('6oz/bin/user')
);
console.log(
  'path.relative() : ',
  path.relative(
    string,
    '/Users/6oz/OneDrive/수업자료/DB 이중권'
  )
);
console.log('Here is :');
console.log('path.join():', path.join(string, '/.'));
console.log('path.resolve():', path.resolve(string, '/'));
console.log('path.posix.sep : ', path.posix.sep);
console.log('path.win32.sep : ', path.win32.sep);
console.log(
  'path.posix.join() : ',
  path.posix.join(string)
);
console.log(
  'path.win32.join() : ',
  path.win32.join(string)
);
