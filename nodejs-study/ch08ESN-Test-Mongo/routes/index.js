const express = require('express');
const router = express.Router();
const User = require('../schemas/user');

// 라우터 정의 코드

// router.get('/', (req, res) => {});
// router.post('/', (req, res) => {});

router.get('/', async (req, res, next) => {
  try {
    // const users = await User.findAll();
    const users = await User.find({});

    // res.render('sequelize', { users });
    res.locals.users = users;
    res.render('mongoose');
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;
