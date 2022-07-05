import React, { useState } from 'react';

const EventExFun = () => {
  const [input, setInput] = useState('');
  const [isClick, setIsClick] = useState(false);
  return (
    <>
      <h1 style={{ backgroundColor: 'burlywood' }}>이벤트연습</h1>
      <input
        type="text"
        name="message"
        placeholder="입력해보자 머라도"
        onChange={e => {
          // e: event객체, SyntheticBaseEvent객체
          setInput(e.target.value);
        }}
      />
      <button
        onClick={() => {
          setIsClick(true);
        }}
      >
        클릭
      </button>
      {isClick && <h1>{input}</h1>}
    </>
  );
};

export default EventExFun;
