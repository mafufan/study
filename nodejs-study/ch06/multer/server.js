const express = require('express');
const multer = require('multer');
const path = require('path');
const cors = require('cors');
const app = express();

app.use(cors());

const fileStorageEngine = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, './images');
  },
  filename: (req, file, cb) => {
    cb(null, Date.now() + '--' + file.originalname);
  },
});

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

const upload = multer({ storage: fileStorageEngine });

app.post('/single', upload.single('image'), (req, res) => {
  console.log(req.file);
  res.send('Single File upload success').json(req.file);
});

app.post('/multiple', upload.array('images', 3), (req, res) => {
  console.log(req.files);
  res.send('Multiple File Upload Success');
});

app.listen(5000, () => {
  console.log('5000번 서버 대기중!');
});
