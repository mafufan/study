const test = async () => {
  // 함수 선언/정의
  try {
    // 3. try~catch처리
    //2. await 붙이기
    const res = await axios.get('https://www.zerocho.com/api/get');
    console.log(res);
    console.log(res.dat);
  } catch (err) {
    console.error('마이에러', error);
  }
};
test(); // 함수 호출
