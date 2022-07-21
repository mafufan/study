import React from 'react';
import { Outlet, useNavigate, Link } from 'react-router-dom';

const Layout = () => {
  const navigate = useNavigate();
  const goBack = e => {
    navigate(-1);
  };
  const goArticles = e => {
    navigate('/articles', { replace: true }); // redirection 구현
  };

  return (
    <div>
      <header style={{ background: 'lightgray', padding: 16, fontSize: 24 }}>
        <button onClick={goBack}>뒤로가기</button>
        <button onClick={goArticles}>게시글 목록</button>
        <ul>
          <li>
            <Link to="/">홈으로</Link>
          </li>
          <li>
            <Link to="/about">회사소개</Link>
          </li>
          <li>
            <Link to="/info?detail=true&mode=1">회사소개(쿼리)</Link>
          </li>
          <li>
            <Link to="/profile:username">프로필</Link>
          </li>
          <li>
            <Link to="/article">Article</Link>
          </li>
          <li>
            <Link to="/MyPage">MyPage</Link>
          </li>
          <li>
            <Link to="/Login">Login</Link>
          </li>
        </ul>
      </header>
      <main>
        {/* 다른 컴포넌트로 대체되는 부분 */}
        <Outlet />
      </main>
    </div>
  );
};

export default Layout;
