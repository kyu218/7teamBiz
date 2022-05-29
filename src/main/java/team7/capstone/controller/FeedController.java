package team7.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import team7.capstone.domain.Criteria;
import team7.capstone.domain.FeedVO;
import team7.capstone.service.FeedService;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService fservice;

    /* 게시판 목록 페이지 접속(페이징 적용) */
    @GetMapping("/list")
    public void FeedListGET(Model model, Criteria cri) {

        model.addAttribute("list", fservice.GetFeedList(cri));

    }

    /* 피드 등록 */
    @PostMapping("/in")
    public String FeedInPOST(FeedVO feed){

        fservice.FeedIn(feed);

        return ""; // 피드 페이지로 이동
    }

    /* 피드 조회 */
    @GetMapping("/get")
    public void GetFeedGET(int feed_seq, Model model){
        model.addAttribute("FeedInfo", fservice.GetFeed(feed_seq));
    }

    /* 피드 수정 */
    @PostMapping("/modify")
    public String FeedModifyPOST(FeedVO feed, RedirectAttributes rttr) {

        fservice.FeedModify(feed);

        rttr.addFlashAttribute("result", "modify success");

        return ""; // 피드 페이지로 이동

    }

    /* 피드 삭제 */
    @PostMapping("/delete")
    public String FeedDeletePOST(int feed_seq, RedirectAttributes rttr) {

        fservice.Delete(feed_seq);

        rttr.addFlashAttribute("result", "delete success");

        return ""; // 피드 페이지로 이동
    }
}
