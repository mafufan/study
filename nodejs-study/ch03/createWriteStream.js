const fs = require('fs');

const writeStream = fs.createWriteStream('./readme2.txt');
writeStream.on('finish', () => {
  console.log('파일쓰기완료');
});

writeStream.write('이 글을 씁니다.\n');
writeStream.write(
  '노랭이 흰둥이 아가야 말짱이 쩔뚝이 뭉치\n'
);
writeStream.end();
