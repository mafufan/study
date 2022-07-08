import React, { useRef } from 'react';
const RefTest = () => {
  const id = useRef(1);
  const setId = num => {
    id.current = num;
  };
  const printId = () => {
    console.log(id.current);
  };
  return <>ref test component</>;
};

export default RefTest;
