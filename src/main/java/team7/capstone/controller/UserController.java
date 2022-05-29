package team7.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team7.capstone.domain.UserVO;
import team7.capstone.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uservice;

    @Autowired
    private BCryptPasswordEncoder pwEncoder;

    /* 회원가입 등록 */
    @PostMapping("/register")
    public String RegisterPOST(UserVO user) throws Exception {
        String rawPw = "";
        String encodePw = "";

        rawPw = user.getPassword(); //비밀번호 데이터
        encodePw = pwEncoder.encode(rawPw); //비밀번호 encode로 인코딩
        user.setPassword(encodePw); //인코딩된 비밀번호 재저장

        /* 회원가입 쿼리 */
        uservice.Register(user);

        /* 페이지 이동 처리 (사용x)*/
        return "";
    }

    /* 아이디 중복 검사 */
    @PostMapping("")
    @ResponseBody
    public String User_IdCkPOST(String user_id) throws Exception {
        int result = uservice.IdCk(user_id);
        if(result != 0) {
            return "Fail"; //아이디 중복
        } else {
            return "Success"; //고유 아이디
        }
    }

    /* 로그인 */
    @PostMapping("")
    public String LoginPOST(HttpServletRequest request, UserVO user, RedirectAttributes rttr) throws Exception {

        HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";

        UserVO uvo = uservice.Login(user);

        if(uvo != null) { //일치하는 아이디 존재

            rawPw = user.getPassword(); //사용자가 제출한 비밀번호
            encodePw = uvo.getPassword(); //DB 저장된 인코딩 비밀번호

            if(true == pwEncoder.matches(rawPw, encodePw)) { //비밀번호 일치여부 판단
                uvo.setPassword(""); //인코딩된 비밀번호 정보 지움
                session.setAttribute("user", uvo); //세션에 사용자 정보 저장
                return ""; // 피드라인 페이지로 이동
            } else {
                rttr.addFlashAttribute("result", 0);
                return ""; //로그인 페이지로 이동
            }

        } else { //아이디 존재하지 않음
            rttr.addFlashAttribute("result", 0);
            return ""; //로그인 페이지로 이동
        }
    }

    /* 로그아웃 */
    @PostMapping("/logout")
    public String LogoutGET(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();

        session.invalidate(); //세션 전체 무효화 메서드

        return ""; //로그인 페이지로 이동
    }

    /* 탈퇴 */
    @PostMapping("/delete")
    public void DeletePOST(UserVO user) throws Exception {
        uservice.UserDelete(user);
    }

}