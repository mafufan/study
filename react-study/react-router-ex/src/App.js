import React from 'react';
import { Routes, Route } from 'react-router-dom';
import About from './Pages/About';
import Home from './Pages/Home';
import Profile from './Pages/Profile';
import Layout from './Pages/Layout';
import Articles from './Pages/Articles';
import Article from './Pages/Article';
import Login from './Pages/Login';
import MyPage from './Pages/MaPage';
import NotFound from './Pages/NotFound';

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/info" element={<About />}></Route>
          <Route path="/profile/:username" element={<Profile />}></Route>
          <Route path="/article" element={<Articles />}></Route>
        </Route>
        <Route path="/articles" element={<Articles />}>
          <Route path=":id" element={<Article />}></Route>
        </Route>
        <Route path="/login" element={<Login />} />
        <Route path="/mypage" element={<MyPage />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;
