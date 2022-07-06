/* import React, { useState } from 'react';

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
          console.log(e.target.value);
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
 */

/* import React, { useState } from 'react';

const EventExFun = () => {
  const [msg, setMsg] = useState('');
  const [username, setUsername] = useState('');

  const handleKeyPress = e => {
    if (e.key === 'Enter') {
      handleClick(e);
    }
  };
  const handleClick = e => {
    e.target.name === 'msg' && setMsg('');
    e.target.name === 'username' && setUsername('');
  };
  const handleChangeMsg = e => {
    setMsg(e.target.value);
  };

  const handleChangeUN = e => {
    setUsername(e.target.value);
  };
  return (
    <>
      <h1 style={{ backgroundColor: 'palevioletred' }}>
        이벤트연습(Function형)
      </h1>
      <input
        type="text"
        name="msg"
        placeholder="입력해보자 머라도"
        value={msg}
        onKeyPress={handleKeyPress}
        onChange={handleChangeMsg}
      ></input>
      <input
        type="text"
        name="username"
        placeholder="이름입력"
        value={username}
        onKeyPress={handleKeyPress}
        onChange={handleChangeUN}
      ></input>
      <div>{msg + ' ' + username}</div>
      <button onClick={handleClick}>확인</button>
    </>
  );
};

export default EventExFun; */
import React, { useState } from 'react';

const EventExFun = () => {
  const [jit, setJit] = useState({
    msg: '',
    username: '',
  });

  const { username, msg } = jit;

  const handleKeyPress = e => {
    if (e.key === 'Enter') {
      handleClick(e);
    }
  };
  const handleClick = e => {
    const newJit = {
      msg: '',
      username: '',
    };
    setJit(newJit);
  };
  const handleChange = e => {
    const newJit = {
      ...jit,
      [e.target.name]: e.target.value,
    };
    setJit(newJit);
  };
  return (
    <>
      <h1 style={{ backgroundColor: 'palevioletred' }}>
        이벤트연습(Function형)
      </h1>
      <input
        type="text"
        name="msg"
        placeholder="입력해보자 머라도"
        value={msg}
        onKeyPress={handleKeyPress}
        onChange={handleChange}
      ></input>
      <input
        type="text"
        name="username"
        placeholder="이름입력"
        value={username}
        onKeyPress={handleKeyPress}
        onChange={handleChange}
      ></input>
      <div>{msg + ' ' + username}</div>
      <button onClick={handleClick}>확인</button>
    </>
  );
};

export default EventExFun;
