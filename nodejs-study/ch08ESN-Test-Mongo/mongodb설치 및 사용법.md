# 몽고디비서버 실행
* 몽고쉘 실행
  - .\mongo
  - use admin
  - db.createUser({user:'이름',pwd:'비밀번호',  roles:['root']});
  - db.createUser({user:'node',pwd:'mong',roles:['root']});
  - db.dropUser('node');
  - show users
  - exit

# 몽고디비서버 실행상태
* 몽고쉘 실행
  - .\mongo admin -u node -p mongo
  - use nodejs
  - show dbs
  - db
  - db.createCollection('users');
  - db.createCollection('comments');
  - show collections

# 몽고디비서버 실행상태
* 몽고쉘 실행
  - .\mongo admin -u node -p mongo
  - db.users.save({name:'zero',age:24,married:false,comment:'안녕하세요. 간단히 몽고디비 사용 방법에 대해 알아봅시다.',createdAt:new Date()});
  - db.users.save({name:'nero',age:32,married:true,comment:'안녕하세요. zero친구nero입니다.',createdAt:new Date()});
  - db.users.find({name:'zero'},{_id:1})
  - db.comments.save({commenter:ObjectId('62a6d76977be2b22b569f793'),comment:'안녕하세요. zero의 댓글입니다.',createdAt:new Date()});
  - db.users.find({});
  - db.comments.find({});
  - db.users.find({},{_id:0,name:1,married:1});
  - db.users.find({age:{$gt:30},married:true},{_id:0,name:1,age:1});
  - db.users.find({$or:[{age:{$gr:30}},{married:false}]},{_id:0,name:1,age:1});
  - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1});
  - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1}).limit(1);
  - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1}).limit(1).skip(1);
  - db.users.update({name:'nero'},{$set:{comment:'안녕하세요. 이 필드를 바꿔보겠습니다!'}});
  - db.users.remove({name:'nero'});

  # mongosh 명령
  ## 몽고디비서버 실행상태
  * 컴패스 실행
    - use admin
    - db.createUser({user:'node1',pwd:'mongo1',roles:['root']});
    - show users
    - use nodejs1
    - show dbs
    - db
    - db.createCollection('users');
    - db.createCollection('comments');
    - show collections

  ## 몽고디비서버 실행상태
  * 컴패스 실행 : node / mongo
    - use nodejs
    - db.users.insertOne({name:'zero1',age:24,married:false,comment:'안녕하세요. 간단히 몽고디비 사용 방법에 대해 알아봅시다.',createdAt:new Date()});
    - db.users.insertOne({name:'nero',age:32,married:true,comment:'안녕하세요. zero 친구nero입니다.',createdAt:new Date()});
    - db.comments.insertOne({commenter:ObjectId(''),comment:'안녕하세요. zero의 댓글입니다.',createdAd:new Date()});
    - db.users.find({});
    - db.comments.find({});
    - db.users.find({},{_id:0,name:1,married:1});
    - db.users.find({age:{$gt:30},married:true},{_id:0,name:1,age:1});
    - db.users.find({$or:[{age:{$gt:30}},{married:false}]},{_id:0,name:1,age:1});
    - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1});
    - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1}).limit(1);
    - db.users.find({},{_id:0,name:1,age:1}).sort({age:-1}).limit(1).skip(1);
    - db.users.updateOne({name:'nero'},{$set:{comment:'안녕하세요???. 이 필드를 바꿔보겠습니다!'}});
    - db.users.deleteOne({name:'nero'});