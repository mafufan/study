import React, { useState } from 'react';
import './App.css';
import Average from './Average';
import Counter from './Counter';
import Info from './Info';
import RefTest from './RefTest';
function App() {
  const [visible, setVisible] = useState(false);
  return (
    <>
      <Counter />
      <br />
      <br />
      <br />
      <br />
      <button
        onClick={e => {
          setVisible(!visible);
        }}
      >
        {visible ? '숨기기' : '보이기'}
      </button>
      <hr />
      {visible && <Info />}
      <Average />
      <RefTest />
    </>
  );
}

export default App;
