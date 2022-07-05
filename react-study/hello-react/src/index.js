import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // 화면을 작성
  <React.StrictMode>
    <App />
  </React.StrictMode>
); // JSX문법

reportWebVitals();
