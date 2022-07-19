import React from 'react';
// import styles from './CSSModuleTest.module.css';
import styles from './CSSModuleTest.module.scss';
import classNames from 'classnames/bind';
// CSS Module사용시
// className={styles.클래스이름}
// :global로 정의한 클래스는
// className = "클래스이름" 형태로 사용
const cx = classNames.bind(styles);
const CSSModuleCom = () => {
  return (
    <>
      <div className={`${styles.wrapper} ${styles.inverted}`}>
        안녕하세요? 저는
        <span className={`${styles.something}`}>Css모듈 테스트</span>
      </div>
      <div className={cx('wrapper', 'inverted')}>
        안녕하세요? 저는
        <span className={`${styles.something}`}>Css모듈 테스트</span>
      </div>
    </>
  );
};

export default CSSModuleCom;
