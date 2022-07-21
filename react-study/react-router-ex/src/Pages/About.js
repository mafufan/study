import React from 'react';
import { useSearchParams } from 'react-router-dom';

function About() {
  const [searchParams, setSearchParams] = useSearchParams();
  const detail = searchParams.get('detail');
  const mode = searchParams.get('mode');
  // const { detail, mode } = searchParams;

  const onDetail = e => {
    setSearchParams({
      mode,
      detail: detail === 'true' ? false : true,
    });
  };
  const onMode = e => {
    setSearchParams({
      mode,
      detail: detail === null ? 1 : parseInt(mode),
    });
  };

  return (
    <div>
      <h1>소개</h1>
      <p>우리는 일본IT과 프로그래밍반</p>
      <p>detail:{detail}</p>
      <p>mode:{mode}</p>
      <button onClick={onDetail}>Detail</button>
      <button onClick={onMode}>Mode</button>
    </div>
  );
}

export default About;
