import React, { useEffect, useState, useReducer } from 'react';
import useInputs from './useInputs';

const Info = () => {
  const [name, setName] = useState('');
  const [nickname, setNickname] = useState('');

  const uInfoUp = (state, action) => {
    return {
      ...state,
      [action.name]: action.value, //action === e.target.name
    };
  };
  const [rObj, setRObjAction] = useReducer(uInfoUp, {
    name1: '',
    nickname1: '',
  });
  const [myHookStates, onChangeMyHook] = useInputs({
    name2: '',
    nickname2: '',
  });

  const onChangeName = e => {
    setName(e.target.value);
  };
  const onChangeNickName = e => {
    setNickname(e.target.value);
  };
  const onChange = e => {
    setRObjAction(e.target);
  };
  const { name1, nickname1 } = rObj;
  const { name2, nickname2 } = myHookStates;
  /* useEffect(() => {
    console.log('이름변경');
    console.log({ name, nickname });
  }, [name, nickname]); */
  /* useEffect(() => {
    console.log('렌더링 완료');
    console.log({ name, nickname });
    return () => {
      console.log('언마운트');
      console.log({ name, nickname });
    };
  }, []); */

  return (
    <>
      <div>
        <input type="text" name="name" value={name} onChange={onChangeName} />
        <input
          type="text"
          name="nickname"
          value={nickname}
          onChange={onChangeNickName}
        />
      </div>
      <div>
        <div>
          <b>이름:</b>
          {name}
        </div>
        <div>
          <b>별명:</b>
          {nickname}
        </div>
        <button
          onClick={() => {
            setName('');
            setNickname('');
          }}
        >
          지우기
        </button>
      </div>
      <div>
        <input type="text" name="name1" value={name1} onChange={onChange} />
        <input
          type="text"
          name="nickname1"
          value={nickname1}
          onChange={onChange}
        />
      </div>
      <div>
        <div>
          <b>이름:</b>
          {name1}
        </div>
        <div>
          <b>별명:</b>
          {nickname1}
        </div>
        <button
          onClick={() => {
            console.log(rObj);
            setRObjAction('');
          }}
        >
          지우기
        </button>
      </div>
      <div>
        <input
          type="text"
          name="name2"
          value={name2}
          onChange={onChangeMyHook}
        />
        <input
          type="text"
          name="nickname2"
          value={nickname2}
          onChange={onChangeMyHook}
        />
      </div>
      <div>
        <div>
          <b>이름:</b>
          {name2}
        </div>
        <div>
          <b>별명:</b>
          {nickname2}
        </div>
        <button
          onClick={() => {
            console.log(rObj);
            setRObjAction('');
          }}
        >
          지우기
        </button>
      </div>
    </>
  );
};

export default Info;
