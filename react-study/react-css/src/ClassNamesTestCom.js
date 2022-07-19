import React from 'react';
import classNames from 'classnames';

const ClassNamesTestCom = ({ clsTest, theme }) => {
  return (
    <>
      <div className={classNames('MyCls', { clsTest }, theme)}>안녕하세요?</div>
      <div className={`MyCls ${theme} ${clsTest ? 'clsTest' : ''}`}>
        안녕하세요?
      </div>
    </>
  );
};

export default ClassNamesTestCom;
