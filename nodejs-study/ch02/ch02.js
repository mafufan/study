/* 
console.log("테스트");
if (true) {
  var x = 3; // 함수 스코프
}
console.log(x); // anonymous 함수내

if (true) {
  const y = 3; // 블록 스코프
  let z = 3;
}
//console.log(y); // 블록 밖
//console.log(z);
*/
/* 
console.log(x); // anonymous 함수내
if (true) {
  var x = 3; // 함수 스코프
}
---> 호이스팅
var x; // 함수 스코프
console.log(x); // anonymous 함수내
if (true) {
  x = 3;
} */
/* console.log(z);
console.log(y);
const y = 3; // 블록 스코프
let z = 3; */

/* const a = 0;
//a = 1; // error: 재할당불가
//const b;  // error: 최초할당필수
let c = 1;
c = 2;
 */

/* const num3 = 1;
const num4 = 2;
const res = 3;

console.log(`${num3} + ${num4} = ${res}`);


var sayNode = function () {
  console.log("Node");
};
var es = "ES추가속성명";
var oldObject = {
  // old 버전 객체 정의
  // 키:값, 키:값, 키:값,
  // 값의 데이터 타입: JS에서 다루는 자료형
  // JS에서 정의된(생성된) 객체에 동적으로 속성을 추가
  // 할 수 있다.
  // 추가시 연관배열 형태로 추가
  // 연관배열: 인덱스가 문자열인 배열
  sayJS: function () {
    //익명(무명)의 함수
    console.log("JS");
  },
  sayNode: sayNode,
};
oldObject[es + 6] = "Fantastic";
oldObject.sayNode(); // Node, 메소드 호출
oldObject.sayJS(); // JS
console.log(oldObject.ES추가속성명6); // Fantastic

// new 버전
var sayNode = function () {
  console.log("Node");
};
const newObject = {
  sayJS() {
    // sayJS: function() {
    console.log("JS");
  },
  sayNode, // 키와 값의 기호가 같은 경우 하나만 표시가능
  [es + 6]: "Fantastic",
  // 키정의시 변수활용 가능
};
newObject.sayNode(); // Node
newObject.sayJS(); // JS
console.log(newObject.ES추가속성명6); // Fantastic
newObject.ES1000 = "이거 되는데 확인좀";
console.log(newObject.ES1000);
*/

/* // 함수정의 1, add1(1,2)
function add1(x, y) {
  return x + y;
}
// 함수정의 2, add2(1,2)
const add2 = function (x, y) {
  return x + y;
};
// 함수정의 3, add3(1,2)
const add3 = (x, y) => {
  return x + y; // 화살표 함수내에 실행문이 return 문만
  // 있는 경우 생략가능
};
// 화살표 함수 정의 2, add4(1,2)
const add4 = (x, y) => x + y;

// 화살표 함수에서 매개변수가 하나인 경우 매개변수리스트
// 작성하는 곳에 소괄호 생략가능
const not1 = (x) => {
  return !x;
};
const not2 = (x) => !x;
 */

/* var relationship1 = {
  name: "zero",
  friends: ["nero", "hero", "xero"],
  logFriends: function () {
    console.log("this1", this);
    // this: relationship1 객체
    var that = this; // relationship1을 가리키는 this를 that에 저장
    this.friends.forEach(
      // 콜백함수
      function (friend, index) {
        console.log("this2", this);
        // this: global 객체
        console.log(that.name, index + "번째 친구:", friend);
      }
    );
  },
};
relationship1.logFriends();

const relationship2 = {
  name: "zero",
  friends: ["nero", "hero", "xero"],
  logFriends() {
    console.log("this3", this);
    // this: relationship2 객체
    this.friends.forEach((friend, index) => {
      console.log("this4", this);
      //
      console.log(this.name, index + "번째 친구:", friend);
    });
  },
};
relationship2.logFriends(); */

//old
/* var candyMachine = {
  status: {
    name: "node",
    count: 5,
  },
  getCandy: function () {
    this.status.count--;
    return this.status.count;
  },
}; */
//var getCandy = candyMachine.getCandy;
//var count = candyMachine.status.count;
//new
// var candyMachine = {
//   status: {
//     name: "node",
//     count: 5,
//   },
//   getCandy() {
//     console.log(this); // global
//     this.status.count--;
//     return this.status.count;
//   },
// };
// const {
//   getCandy,
//   status: { count },
// } = candyMachine;
// const test = getCandy.bind(candyMachine);
// console.log(test());

// var array = ["nodejs", {}, 10, true];
// //old
// var node = array[0];
// var obj = array[1];
// var bool = array[3];

// const [n, o, , b] = array;
// console.log(b);

/*
var Human = function (type) {
  // JS에서 함수는 하나의 객체로 취급
  this.type = type || "human";
}; // 생성자 함수

Human.isHuman = function (human) {
  return human instanceof Human;
};

Human.prototype.breathe = function () {
  alert("h-a-a-a-m");
};

var Zero = function (type, firstName, lastName) {
  Human.apply(this, arguments); // 상속코드1
  this.firstName = firstName;
  this.lastName = lastName;
};

Zero.prototype = Object.create(Human.prototype); // 상속코드2
Zero.prototype.constructor = Zero; // 상속코드2
Zero.prototype.sayName = function () {
  alert(this.firstName + " " + this.lastName);
};
var oldZero = new Zero("human", "Zero", "Cho");
Human.isHuman(oldZero); // true
*/

// class Human {
//   constructor(type = "human") {
//     this.type = type;
//   }

//   static isHuman(human) {
//     return human instanceof Human;
//   }

//   breathe() {
//     alert("h-a-a-a-m");
//   }
// }

// class Zero extends Human {
//   constructor(type, firstName, lastName) {
//     super(type);
//     this.firstName = firstName;
//     this.lastName = lastName;
//   }

//   sayName() {
//     super.breathe();
//     alert(`${this.firstName} ${this.lastName}`);
//   }
// }

// const newZero = new Zero("human", "Zero", "Cho");
// Human.isHuman(newZero); // true
/* 
const condition = Math.random() < 0.5 ? true : false;
// true면 resolve, false면 reject
// 사용규칙1: 프로미스 객체 생성
const promise = new Promise((resolve, reject) => {
  // 콜백함수의 파라미터-2개
  // resolve: 성공 콜백의 의미, reject: 실패 콜백의 의미
  // 여러가지 코딩 처리
  if (condition) {
    // 여러가지 코딩 처리
    resolve("성공하면 표시 데이터"); // 성공시 나타내려는 데이터와 함께 resolve
    // 호출
  } else {
    // 여러가지 코딩 처리
    reject("실패");
  }
});
// 다른 코드가 들어갈 수 있음

// 사용 규칙 2: 생성된 객체에 then(),catch(),finally()
promise
  .then((message) => {
    // message는 사용규칙1에서의 resolve(파라미터)의 파라미터
    //resolve(파라미터)의 파라미터
    console.log(message); // 성공(resolve)한 경우 실행
  })
  .catch((error) => {
    // error는 사용규칙1에서의 reject(파라미터)의 파라미터
    //reject(파라미터)의 파라미터
    console.error(error); // 실패(reject)한 경우 실행
  })
  .finally(() => {
    // 끝나고 무조건 실행
    console.log("무조건");
  });

promise // 프로미스 체이닝
  .then((message) => {
    return new Promise((resolve, reject) => {
      resolve(message + 1);
    });
  })
  .then((message2) => {
    console.log(message2 + 2);
    return new Promise((resolve, reject) => {
      resolve(message2);
    });
  })
  .then((message3) => {
    console.log(message3 + 3);
  })

  .catch((error) => {
    console.error(error);
  }); */
/* 
const promise1 = Promise.resolve("성공1");
//const promise3 = Promise.reject("실패3");
const promise2 = Promise.resolve("성공2");
const promise3 = Promise.resolve("성공3");

Promise.race([promise1, promise3, promise2])
  .then((res) => {
    console.log(res); //['성공1', '성공2']
  })
  .catch((err) => {
    console.error(err);
  });
 */
// function findAndSaveUser(Users) {
//   Users.findOne({})
//     .then((user) => {
//       user.name = "zero";
//       return user.save();
//     })
//     .then((user) => {
//       return Users.findOne({ gender: "m" });
//     })
//     .then((user) => {
//       // 생략
//     })
//     .catch((err) => {
//       console.error(err);
//     });
// }
// // async/await바꾸기
// // 1. async 함수로 바꾸기
// async function findAndSaveUser(Users) {}
// // 2. 비동기 코드들 앞에 await 붙이기
// async function findAndSaveUser(Users) {
//   let result = await Users.findOne({});
//   result.name = "zero";
//   result = await result.save();
//   result = await Users.findOne({ gender: "m" });
// }

// // 3. error는 try~catch처리
// async function findAndSaveUser(Users) {
//   // const findAndSaveUser = async function(Users) {
//   // const findAndSaveUser = async (Users) => {
//   try {
//     let result = await Users.findOne({});
//     result.name = "zero";
//     result = await result.save();
//     result = await Users.findOne({ gender: "m" });
//   } catch (err) {
//     console.error(err);
//   }
// }
