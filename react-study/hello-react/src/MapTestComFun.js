import React from 'react';

const MapTestComFun = () => {
  const fruits = [
    '🥝',
    '🥥',
    '🥭',
    '🍍',
    '🍌',
    '🍋',
    '🍊',
    '🍉',
    '🍈',
    '🍏',
    '🍐',
    '🍑',
    '🍒',
    '🍅',
  ];
  const fruitsLi = fruits.map((fruit, index) => {
    return <li key={index}>{fruit}</li>;
  });

  return (
    <>
      <ul>{fruitsLi}</ul>
    </>
  );
};

export default MapTestComFun;
