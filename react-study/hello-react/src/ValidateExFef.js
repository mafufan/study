/* import React, { Component } from 'react';
import './ValidateExRef.css';

class ValidateExFef extends Component {
  state = {
    password: '',
    clicked: false,
    validated: false,
  };
  inputRef = React.createRef(); // 수정
  onChange = e => {
    this.setState({ password: e.target.value });
  };
  onClick = e => {
    this.setState({
      clicked: true,
      validated: this.state.password === '1234',
    });
    this.inputRef.current.focus(); // 수정
  };
  render() {
    return (
      <>
        <br />
        <input
          type="password"
          ref={this.inputRef} // 수정
          value={this.state.password}
          onChange={this.onChange}
          className={
            this.state.clicked
              ? this.state.validated
                ? 'success'
                : 'failure'
              : ''
          }
        ></input>
        <button onClick={this.onClick}>검증</button>
      </>
    );
  }
}

export default ValidateExFef;
*/
import React, { Component } from 'react';
import './ValidateExRef.css';

class ValidateExFef extends Component {
  state = {
    password: '',
    clicked: false,
    validated: false,
  };
  inputRef = React.createRef(); // 수정
  onChange = e => {
    this.setState({ password: e.target.value });
  };
  onClick = e => {
    this.setState({
      clicked: true,
      validated: this.state.password === '1234',
    });
    this.inputRef.focus();
  };
  render() {
    return (
      <>
        <br />
        <input
          type="password"
          ref={ref => {
            this.inputRef = ref;
          }} // 수정
          value={this.state.password}
          onChange={this.onChange}
          className={
            this.state.clicked
              ? this.state.validated
                ? 'success'
                : 'failure'
              : ''
          }
        ></input>
        <button onClick={this.onClick}>검증</button>
      </>
    );
  }
}

export default ValidateExFef;
