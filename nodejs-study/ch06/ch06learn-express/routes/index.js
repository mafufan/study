const express = require('express');

const router = express.Router();

// GET / 라우터
router.get('/', (req, res) => {
  res.render(
    'index', // views/index.html
    {
      title: 'Express',
      isLoggedIn: false,
      name: 'HuiJae',
      me: ['asdasd', 'asdasdas'],
    } // title변수 값 전달
  );
});

module.exports = router;
