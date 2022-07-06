import React, { Component } from 'react';
import './App.css';
import MyCom from './MyCom';
import FuncMyCom from './FuncMyCom';
import StateComCls from './StateComCls';
import StateComFun from './StateComFun';
import EventExFun from './EventExFun';
import EventExCls from './EventExCls';

// rcc 클래스형 자동완성
class App extends Component {
  render() {
    const name = '리액트 테스트';
    const test = 32;
    return (
      <>
        <div className="react">{name}</div>
        {/* <MyCom hakbun={19010223} major="일본IT">
          여기가 내용이오
        </MyCom>
        <StateComCls />
        <FuncMyCom name="최영진" age={test} gender="남" roomnum="603" />
        <FuncMyCom name={name} age={test} gender="남" roomnum="603">
          확인 어쩌구 저쩌구
        </FuncMyCom> */}
        <StateComFun></StateComFun>
        <EventExFun></EventExFun>
        <EventExCls></EventExCls>
      </>
    );
  }
}
export default App;
