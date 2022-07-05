const mongoose = require('mongoose');

const { Schema } = mongoose;
const userSchema = new Schema({
  name: {
    type: String,
    required: true,
    unique: true,
  },
  age: {
    type: Number,
    required: true,
  },
  married: {
    type: Boolean,
    required: true,
  },
  comment: String,
  createdAt: {
    type: Date,
    default: Date.now,
  },
});

module.exports = mongoose.model('User', userSchema);
// User ==> users 컬렉션 생성, 스키마를 참조해서
// _id 필드가 자동 생성됨
// 도큐먼트 값에 따른 유일한 값을 생성
// 고유의 값 :ObjectId 타입
// 관례상 설정을 반해서 설정
// mongoose.model('User',userSchema,'user_table')
// User==>user_table 컬렉션이 생성됨
