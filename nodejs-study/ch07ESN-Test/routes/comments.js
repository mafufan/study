const express = require('express');
const { Comment } = require('../models');
const router = express.Router();

router.post('/', async (req, res, next) => {
  try {
    const comment = await Comment.create({
      commenter: req.body.commenter,
      comment: req.body.comment,
    });
    console.log('댓글 등록', req.method, req.url, req.body, req.params, comment);
    res.json(comment);
  } catch (err) {
    console.error(err);
    next(err);
  }
});

router
  .route('/:commentid')
  .patch(async (req, res, next) => {
    // PATCH /comments/:commentid
    try {
      const result = await Comment.update(
        {
          comment: req.body.comment,
        },
        {
          where: { id: req.params.commentid },
        }
      );
      res.json(result);
    } catch (err) {
      console.error(err);
      next(err);
    }
  })
  .delete(async (req, res, next) => {
    // DELETE /comments/:commentid
    try {
      const result = await Comment.destroy({
        where: {
          id: req.params.commentid,
        },
      });
      res.json(result);
    } catch (err) {
      console.error(err);
      next(err);
    }
  });

module.exports = router;
