import React from 'react';
import PropTypes from 'prop-types';

const myStyle = {
  backgroundColor: 'yellow',
  color: 'red',
  fontSize: '34px',
  fontWeight: 'bold',
  padding: 16,
};

const FuncMyCom = props => {
  const funcTest = '일본반';
  const { name, age, gender, roomnum } = props;
  return (
    <>
      <div style={myStyle}>{funcTest + '입니다.'}</div>
      <div>
        <span>{name}</span>
        <p>{age}</p>
        <h6>{gender}</h6>
        <b>{roomnum}</b>
        {props.children}
      </div>
    </>
  );
};

FuncMyCom.defaultProps = {
  name: '일본IT',
};

FuncMyCom.propTypes = {
  name: PropTypes.string.isRequired,
  age: PropTypes.number,
};

export default FuncMyCom;
