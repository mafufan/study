```js
const test = (x,y) => {
  let res = '';
  if(x){
    if(!y){
      res = 'c';
    }
  }else{
    res='a';
  }
  res+='b';
  return res;
};

const test = (x,y) => {
  let res = '';
  if(x){
    if(!y){
      res = 'c';
    }
    res+='b';
    return res;
  }else{
    res='a';
    res+='b';
    return res;           
  }
};
const test = (x, y) => {
      let res = '';
      if (!x) {
        res = 'a';
        res += 'b';
        break;
      }
      if (!y) {
        res = 'c';
      }
      res += 'b';
      return res;
    };
```
1. if문다음에나오는공통된절차를각분기점내부에넣는다.
2. 분기점에서 짧은 절차부터 실행하게 if 문을 작성한다.
3. 짧은 절차가 끝나면 return(함수 내부의 경우)이나 break(for 문 내부의 경우)로 중단한다.
4. else를 제거한다(이때 중첩 하나가 제거된다).
5. 다음 중첩된 분기점이 나오면 1~4의 과정을 반복한다.