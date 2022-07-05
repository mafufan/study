'use strict';
const Sequelize = require('sequelize');
const User = require('./user'); // User를 반환하는 함수 User(sequelize,'Datatypes)
const Comment = require('./comment'); // Comment를 반환하는 함수

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config.json')[env];
const db = {};

let sequelize;
sequelize = new Sequelize(
  config.database,
  config.username,
  config.password,
  config
);

db.sequelize = sequelize; //객체
db.Sequelize = Sequelize; //생성자
db.User = User(sequelize, Sequelize.DataTypes);
db.Comment = Comment(sequelize, Sequelize.DataTypes);
db.User.associate(db);
db.Comment.associate(db);

module.exports = db;
