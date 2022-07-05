const exec = require('child_process').exec;
// 구조분해할당
const { exec, spawn } = require('child_process');

var process = exec('ls'); // shell 명령어 실행
// dir 도스 명령어
// ls  linux의 shell명령어 ()

process.stdout.on('data', function (data) {
  // 표준출력: stdout - 모니터
  // 표준입력: stdin  - 키보드
  console.log(data.toString());
}); // 실행 결과

process.stderr.on('data', function (data) {
  // 표준에러: stderr - 모니터
  console.error(data.toString());
}); // 실행 에러
