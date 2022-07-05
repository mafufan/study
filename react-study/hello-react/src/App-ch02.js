/* eslint-disable*/
import './App.css';
// import React from "react";

function App() {
  // const name = 'react';
  // const number = 0;
  // 함수형 컴포넌트 작성: App컴포넌트

  const name = '리엑트';
  const styleObj = {
    backgroundColor: 'cyan',
    color: 'red',
    fontSize: '34px',
    fontWeight: 'bold',
    padding: 16,
  };
  return (
    // JSX 객체, JSX의 문법을 따라야 한다
    // JSX의 주석
    <>
      <div style={styleObj}>{name}</div>
      <div
        style={{
          backgroundColor: 'yellow',
          color: 'blue',
          fontSize: '34px',
          fontWeight: 'bold',
          padding: 16,
        }}
      >
        {name}
      </div>
      <div className="reactTest">{name}</div>
    </>
    // 리엑트값을 default로 출력시키기
  );

  /*
    <>
      {/* <h1> 안녕!</h1>
      <h2>잘 봐라.리액트 안녕!</h2>
      {name === 'react' ? <h1>리엑트</h1> : null}
      {name === 'react' && <h1>리엑트</h1>}
      {number && <h1>보임??</h1>} 
      
    </>*/
}
export default App;
// module.exports = App;
