/* import React, { Component } from 'react';

class EventExCls extends Component {
  state = {
    msg: '',
  };
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleClick = this.handleClick.bind(this);
    this.handleKeyPress = this.handleKeyPress.bind(this);
  }
  handleKeyPress(e) {
    if (e.key === 'Enter') {
      alert(this.state.msg);
      this.setState({ msg: '' });
    }
  }
  handleChange(e) {
    this.setState({ msg: e.target.value });
  }
  handleClick() {
    alert(this.state.msg);
    this.setState({ msg: '' });
  }
  render() {
    return (
      <>
        <h1 style={{ backgroundColor: 'coral' }}>이벤트연습(Class형)</h1>
        <input
          type="text"
          name="message"
          placeholder="입력해보자 머라도"
          value={this.state.msg}
          onKeyPress={e => {
            this.handleKeyPress(e);
          }}
          onChange={e => {
            // e: event객체, SyntheticBaseEvent객체
            this.handleChange(e);
          }}
        />
        <button
          onClick={e => {
            this.handleClick();
          }}
        >
          확인
        </button>
        <div>{this.state.msg}</div>
      </>
    );
  }
}
export default EventExCls;
*/
import React, { Component } from 'react';

class EventExCls extends Component {
  state = {
    msg: '',
    username: '',
  };
  handleKeyPress = e => {
    if (e.key === 'Enter') {
      this.handleClick(e);
    }
  };
  handleClick = e => {
    // this.setState({ msg: '',username:'' });
    this.setState({ msg: '', username: '' });
  };
  handleChange = e => {
    this.setState({ [e.target.name]: e.target.value });
  };

  render() {
    return (
      <>
        <h1 style={{ backgroundColor: 'coral' }}>이벤트연습(Class형)</h1>
        <input
          type="text"
          name="msg"
          placeholder="입력해보자 머라도"
          value={this.state.msg}
          onKeyPress={this.handleKeyPress}
          onChange={this.handleChange}
        />
        <input
          type="text"
          name="username"
          placeholder="이름입력"
          value={this.state.username}
          onKeyPress={this.handleKeyPress}
          onChange={this.handleChange}
        />
        <div>{this.state.msg + ' ' + this.state.username}</div>
        <button onClick={this.handleClick}>확인</button>
      </>
    );
  }
}

export default EventExCls;
