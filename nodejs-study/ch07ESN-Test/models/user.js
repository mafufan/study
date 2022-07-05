'use strict';
const { Model, Sequelize } = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class User extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
      this.hasMany(models.Comment, {
        foreignKey: 'commenter',
        sourceKey: 'id',
      });
    }
  }
  User.init(
    {
      // id:{} 자동을 생김, PK, AI
      name: {
        type: DataTypes.STRING(20),
        allowNull: false, // Not Null
        unique: true, // UNIQUE
      },
      age: {
        type: DataTypes.INTEGER.UNSIGNED,
        allowNull: false,
      },
      married: {
        type: DataTypes.BOOLEAN,
        allowNull: false,
      },
      comment: {
        type: DataTypes.TEXT,
        allowNull: true, // Null입력가능
      },
      created_at: {
        type: DataTypes.DATE,
        allowNull: false,
        defaultValue: Sequelize.literal('now()'),
      },
    },
    {
      sequelize,
      timestamps: false, // true--> createdAt, updatedAt 필드가 생성
      underscored: false, // 기본 CamelCase, true - snake_case
      modelName: 'User',
      tableName: 'users', // 관례상 복수형
      paranoid: false, // true: deletedAt필드 생성
      charset: 'utf8',
      collate: 'utf8_general_ci',
    }
  );
  return User;
};
