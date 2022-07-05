const realName = {
  name: '오희재',
  here: function () {
    console.log('here ------------------------------');
    // 일반함수
    console.log('here :', this); // 자기를 담고있는 객체
    // realName 객체를 가리킴
    (function hereFn() {
      // 콜백 함수 = 백그라운드 this = window
      console.log('hereFn :', this); // window
    })();
    (() => {
      // 콜백 화살표 함수 = 내부의 this
      console.log('hereFn(Arrow) :', this); // realName(.here)
    })();
  },

  there: () => {
    console.log('there ------------------------------');
    // 화살표 함수
    console.log('there :', this); // window(.realName)
    (function thereFn() {
      // 일반함수
      console.log('thereFn :', this); // window(.realName(.thereFn))
    })();
    (() => {
      // 일반함수
      console.log('thereFn(Arrow) :', this);
      // realName내부의 this = window
    })();
  },
};
realName.here();
realName.there();
