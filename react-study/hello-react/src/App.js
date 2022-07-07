import React, { Component } from 'react';
import './App.css';
import MyCom from './MyCom';
import FuncMyCom from './FuncMyCom';
import StateComCls from './StateComCls';
import StateComFun from './StateComFun';
import EventExFun from './EventExFun';
import EventExCls from './EventExCls';
import ValidateExFef from './ValidateExFef';
import ScrollBoxRef from './ScrollBoxRef';
import MapTestComFun from './MapTestComFun';
import IterateComFn from './IterateComFn';
import LifeCycleCls from './LifeCycleCls';
import ErrorLifeCycleCls from './ErrorLifeCycleCls';

// rcc 클래스형 자동완성
const getRandColor = () => {
  return '#' + Math.floor(Math.random() * 16777215).toString(16);
  // ffffff(16진수):6777215(십진수)
};
class App extends Component {
  state = {
    color: '#000000',
  };
  onClick = e => {
    this.setState({
      color: getRandColor(),
    });
  };

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
        <ValidateExFef></ValidateExFef>
        <ScrollBoxRef
          ref={ref => {
            this.scrollBox = ref;
          }}
        ></ScrollBoxRef>
        <button
          onClick={e => {
            this.scrollBox.scrollBoxBottom();
          }}
        >
          맨밑으로
        </button>
        <ScrollBoxRef></ScrollBoxRef>
        <MapTestComFun></MapTestComFun>
        <IterateComFn></IterateComFn>
        <div>
          <button onClick={this.onClick}>렌덤색상</button>
          <ErrorLifeCycleCls>
            <LifeCycleCls color={this.state.color}></LifeCycleCls>
          </ErrorLifeCycleCls>
        </div>
      </>
    );
  }
}
export default App;
