/* import React, { useState } from 'react';

const calculateAvg = arr => {
  if (arr.length === 0) {
    return 0;
  }
  const sum = arr.reduce((acc, cur) => {
    return acc + cur;
  });
  return sum / arr.length;
};

const Average = () => {
  const [numArr, setNumArr] = useState([]);
  const [num, setNum] = useState('');
  const onChange = e => {
    setNum(e.target.value);
  };
  const onInsert = e => {
    const newNumArr = numArr.concat(parseInt(num));
    setNumArr(newNumArr); // 불변성을 유지하면서 바꿔야함
    setNum('');
  };
  return (
    <>
      <input type="text" value={num} onChange={onChange} />
      <button onClick={onInsert}>등록</button>
      <ul>
        {numArr.map((val, idx) => {
          return <li key={idx}>{val}</li>;
        })}
      </ul>
      <div>
        <b>평균값: </b>
        {calculateAvg(numArr)}
      </div>
    </>
  );
};

export default Average; */
import React, { useState, useMemo, useCallback, useRef } from 'react';

const calculateAvg = arr => {
  if (arr.length === 0) {
    return 0;
  }
  const sum = arr.reduce((acc, cur) => {
    return acc + cur;
  });
  return sum / arr.length;
};

const Average = () => {
  const [numArr, setNumArr] = useState([]);
  const [num, setNum] = useState('');
  const inputTag = useRef(null);

  const onChange = useCallback(e => {
    setNum(e.target.value);
  }, []); // 컴포넌트가 처음 랜더링될 때 이벤트핸들러가 생성

  const onInsert = useCallback(
    e => {
      const newNumArr = numArr.concat(parseInt(num));
      setNumArr(newNumArr); // 불변성을 유지하면서 바꿔야함
      setNum('');
      inputTag.current.focus();
    },
    [num, numArr]
  );

  const avg = useMemo(() => {
    return calculateAvg(numArr);
  }, [numArr]);
  return (
    <>
      <input type="text" value={num} onChange={onChange} ref={inputTag} />
      <button onClick={onInsert}>등록</button>
      <ul>
        {numArr.map((val, idx) => {
          return <li key={idx}>{val}</li>;
        })}
      </ul>
      <div>
        <b>평균값: </b>
        {avg}
      </div>
    </>
  );
};

export default Average;
