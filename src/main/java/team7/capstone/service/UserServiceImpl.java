package team7.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team7.capstone.domain.UserVO;
import team7.capstone.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapper;

    /* 회원가입 */
    @Override
    public void Register(UserVO user) {
        mapper.Register(user);
    }

    /* 아이디 중복 검사 */
    @Override
    public int IdCk(String user_id) {
        return mapper.IdCk(user_id);
    }

    /* 로그인 */
    @Override
    public UserVO Login(UserVO user) {
        return mapper.Login(user);
    }

    /* 회원 탈퇴 */
    @Override
    public void UserDelete(UserVO user) {
        mapper.UserDelete(user);
    }
}
