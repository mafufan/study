import React, { useState } from 'react';
// 사전지식
/* 배열의 구조분해 할당
const arr = [1, 2];
const one = arr[0];
const two = arr[1];
==>
  const arr1 = [1, 2];
  const [one, two] = arr1; */

const StateComFun = () => {
  const [number, setNumber] = useState(0);
  const [noproblem, setNoproblem] = useState('');
  // 상태 선언 및 초기화
  return (
    <>
      <h1>{number}</h1>
      <h2>{noproblem}</h2>
      <button
        onClick={() => {
          setNumber(number + 1);
          setNoproblem(noproblem + '일본취업만이 살길이다.');
        }}
      >
        +1
      </button>
    </>
  );
};

export default StateComFun;
