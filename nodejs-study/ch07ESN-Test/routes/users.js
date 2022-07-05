const express = require('express');
const { User, Comment } = require('../models');
const router = express.Router();
// 라우터 정의 코드

router
  .route('/')
  .get(async (req, res, next) => {
    try {
      const users = await User.findAll();
      res.json(users);
      console.log('사용자정보조회', req.method, req.body, req.url, req.params, users);
    } catch (err) {
      console.error(err);
      next(err);
    }
  })
  .post(async (req, res, next) => {
    try {
      console.log('req.body', req.body);
      const user = await User.create({
        name: req.body.name,
        age: req.body.age,
        married: req.body.married,
      });
      console.log('user', user);
      res.status(201).json(user);
    } catch (err) {
      console.error(err);
      next(err);
    }
  });

router.get('/:commenter/comments', async (req, res, next) => {
  try {
    const comments = await Comment.findAll({
      include: {
        model: User,
        where: { id: req.params.commenter },
      },
    });
    console.log('댓글조회', req.method, req.url, req.body, req.params, comments);
    res.json(comments);
  } catch (err) {
    console.error(err);
    next(err);
  }
});

/* router.post('/', async (req, res, next) => {
  try {
    console.log('req.body', req.body);
    const user = await User.create({
      name: req.body.name,
      age: req.body.age,
      married: req.body.married,
    });
    console.log('user', user);
    res.status(201).json(user);
  } catch (err) {
    console.error(err);
    next(err);
  }
});

router.get('/', async (req, res, next) => {
  try {
  } catch (err) {
    console.error(err);
    next(err);
  }
}); */

module.exports = router;
