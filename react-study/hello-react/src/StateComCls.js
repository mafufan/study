// import React, { Component } from 'react';

// class StateComCls extends Component {
//   // state 방법 1 - constructor에서 객체로 설정
//   constructor(props) {
//     super(props); // 반드시 먼저 호출되도록 구현해야 함

//     this.state = { number: 0, noproblem: '' }; // 상태의 초기값 설정, { 상태값명1:초기치1,상태값명2:초기치2,... }
//   }
//   render() {
//     const { number, noproblem } = this.state; // 상수와 상태 연결
//     return (
//       // JSX
//       <>
//         <h1>{number}</h1> {/* 상태값 조회 */}
//         <h2>{noproblem}</h2> {/* 상태값 조회 */}
//         <button
//           onClick={() => {
//             this.setState({ number: number + 1 });
//             // 상태의 변경: this.setState()
//             this.setState({ noproblem: noproblem + '일본취업' });
//           }}
//         >
//           +1
//         </button>
//       </>
//       // 상태의 변경 : this.setState({상태값 변경"변경값})
//     );
//   }
// }

// export default StateComCls;

import React, { Component } from 'react';

class StateComCls extends Component {
  // state 처리 방법 2
  state = {
    // 상태 초기화
    number: 0,
    noproblem: '',
  };
  render() {
    const { number, noproblem } = this.state; // 상수와 상태 연결
    return (
      // JSX
      <>
        <h1>{number}</h1> {/* 상태값 조회 */}
        <h2>{noproblem}</h2> {/* 상태값 조회 */}
        <button
          onClick={() => {
            this.setState(prevState => {
              // prevSTate: 이전 상태값
              {
                return { number: prevState.number + 1 };
              }
            }); // 비동기적으로 작동 ==> 콜백함수로 작성해야
            this.setState(prevState => ({
              number: prevState.number + 1,
            }));
            this.setState(
              (prevState, props) => ({
                number: prevState.number + 1,
              }),
              () => {
                console.log('상태변경완료');
              }
            );
            // 상태의 변경: this.setState()
            // this.setState({ noproblem: noproblem + '일본취업' });
          }}
        >
          +1
        </button>
      </>
      // 상태의 변경 : this.setState({상태값 변경"변경값})
    );
  }
}

export default StateComCls;
