package team7.capstone.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team7.capstone.domain.UserVO;

@Mapper @Repository
public interface UserMapper {

        /* 회원가입 */
        public void Register(UserVO user);

        /* 아이디 중복 검사 */
        public int IdCk(String user_id);

        /* 로그인 */
        public UserVO Login(UserVO user);

        /* 회원 탈퇴 */
        public void UserDelete(UserVO user);


}
