import React, { useState, useEffect } from 'react';
import axios from 'axios';
function App() {
  const [fileData, setFileData] = useState();
  const [viewImage, setViewImage] = useState();

  const fileChangeHandler = e => {
    setFileData(e.target.files[0]);
  };

  const onSubmitHandler = async e => {
    e.preventDefault();

    // Handle File Data from the state Before Sending
    const data = new FormData();

    data.append('image', fileData);
    await axios
      .post('http://localhost:5000/single', data)
      .then(result => {
        console.log('File Sent Successful');
        setViewImage(result.data);
      })
      .catch(err => {
        console.log(err.message);
      });
  };

  return (
    <div className="App">
      <h1>리액트 파일 업로드 Multer</h1>
      <form action="/single" encType="multipart-formdata" onSubmit={onSubmitHandler}>
        <h1>Single File</h1>
        <input name="file" type="file" onChange={fileChangeHandler} />
        <button type="submit">Submit File to backend</button>
        <br />
      </form>
      <form action="/multiple" encType="multipart-formdata" onSubmit={onSubmitHandler}>
        <h1>Multiple Files</h1>
        <input name="files" type="file" onChange={fileChangeHandler} multiple />
        <button type="submit">Submit File to backend</button>
      </form>
      <img src={viewImage} />
    </div>
  );
}

export default App;
