import React, { useState, useCallback } from 'react';
import './TodoInsert.scss';
import { MdAdd } from 'react-icons/md';
//  import { 아이콘 이름 } from 'react-icons/md';

const TodoInsert = ({ onInsert }) => {
  const [inputVal, setInputVal] = useState('');
  const onChange = useCallback((e) => {
    setInputVal(e.target.value);
  }, []);
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      onInsert(inputVal);
      setInputVal('');
    },
    [onInsert, inputVal],
  );
  return (
    <>
      <form className="TodoInsert" onSubmit={onSubmit}>
        <input
          placeholder="할 일 입력하기"
          value={inputVal}
          onChange={onChange}
        />
        <button type="submit">
          <MdAdd />
        </button>
      </form>
    </>
  );
};

export default TodoInsert;
