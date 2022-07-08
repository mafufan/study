/* import React, { useState } from 'react';
// useState() 훅예제
// 사용선언
// const [상태명, set상태명] = useState(초기값); // set상태명 -- Setter함수
// 상태는 Setter함수로만 변경 가능

const Counter = () => {
  const [cnt, setCnt] = useState(0);
  return (
    <>
      <p>
        현 카운터의 값 : <b>{cnt}</b>
      </p>
      <button
        onClick={e => {
          setCnt(cnt + 1);
        }}
      >
        +1
      </button>
      <button
        onClick={e => {
          setCnt(cnt - 1);
        }}
      >
        -1
      </button>
    </>
  );
};

export default Counter; */
import React, { useReducer } from 'react';
// useState() 훅예제
// 사용선언
// const [상태명, set상태명] = useState(초기값); // set상태명 -- Setter함수
// 상태는 Setter함수로만 변경 가능

const Counter = () => {
  const calculate = (state, action) => {
    switch (action.type) {
      case '더하기':
        return { value: state.value + 1 };
      case '빼기':
        return { value: state.value - 1 };
      default:
        return state;
    }
  };

  const [cnt, setCntAction] = useReducer(calculate, { value: 0 });
  return (
    <>
      <p>
        현 카운터의 값 : <b>{cnt.value}</b>
      </p>
      <button
        onClick={e => {
          setCntAction({ type: '더하기' });
        }}
      >
        +1
      </button>
      <button
        onClick={e => {
          setCntAction({ type: '빼기' });
        }}
      >
        -1
      </button>
    </>
  );
};

export default Counter;
