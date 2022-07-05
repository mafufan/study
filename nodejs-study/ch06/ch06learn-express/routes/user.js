const express = require('express');

const router = express.Router();

// GET /user 라우터
router.get('/', (req, res) => {
  res.send('잘봤제? user라우터여!');
});

router.get('/test/:id', (req, res) => {
  const testStr = req.params.id + ': ' + req.query.key1;
  // res.write(testStr);
  res.send('잘봤제? user라우터여!');
});

module.exports = router;
