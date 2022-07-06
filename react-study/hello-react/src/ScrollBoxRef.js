import React, { Component } from 'react';

class ScrollBoxRef extends Component {
  scrollBoxBottom = () => {
    const { scrollHeight, clientHeight } = this.box;

    this.box.scrollTop = scrollHeight - clientHeight;
  };
  render() {
    const style = {
      border: '1px solid black',
      height: '300px',
      width: '300px',
      overflow: 'auto',
      position: 'relative',
    };
    const innerStyle = {
      width: '100%',
      height: '650px',
      background: 'linear-gradient(white,black)',
    };
    return (
      <>
        <div
          style={style}
          ref={refPram => {
            this.box = refPram;
          }}
        >
          <div style={innerStyle}></div>
        </div>
      </>
    );
  }
}

export default ScrollBoxRef;
