import { useParams } from 'react-router-dom';

const data = {
  velopert: {
    name: '김민준',
    description: '리액트를 좋아하는 개발자',
  },
  gildong: {
    name: '홍길동',
    description: '고전 소설 홍길동전의 주인공',
  },
};
const Profile = () => {
  /* const params = useParams();
  const profile = data[params.username]; */

  const { username } = useParams();
  const profile = data[username];
  /* if (!profile) {
    return <div>존재하지 않는 사용자</div>;
  } */
  return (
    <div>
      <h1>사용자 프로필</h1>
      {profile ? (
        <div>
          <h2>{profile.name}</h2>
          <p>{profile.description}</p>
        </div>
      ) : (
        <div>존재하지 않는 사용자</div>
      )}
    </div>
  );
};

export default Profile;
