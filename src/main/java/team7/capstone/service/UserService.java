package team7.capstone.service;

import team7.capstone.domain.UserVO;

public interface UserService {

    /* 회원가입 */
    public void Register(UserVO user);

    /* 아이디 중복 검사 */
    public int IdCk(String user_id);

    /* 로그인 */
    public UserVO Login(UserVO user);

    /* 회원 탈퇴 */
    public void UserDelete(UserVO user);
}
