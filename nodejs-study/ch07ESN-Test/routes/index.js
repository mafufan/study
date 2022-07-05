const express = require('express');
const { User } = require('../models');
const router = express.Router();
// 라우터 정의 코드

// router.get('/', (req, res) => {});
// router.post('/', (req, res) => {});

router.get('/', async (req, res, next) => {
  try {
    const users = await User.findAll();
    // res.render('sequelize', { users });
    res.locals.users = users;
    res.render('sequelize');
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;
