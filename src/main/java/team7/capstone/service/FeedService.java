package team7.capstone.service;

import team7.capstone.domain.Criteria;
import team7.capstone.domain.FeedVO;

import java.util.List;

public interface FeedService {

    /* 피드 리스트 */
    public List<FeedVO> GetList();

    /* 피드 리스트(페이징 적용) */
    public List<FeedVO> GetFeedList(Criteria cri);

    /* 피드 등록 */
    public void FeedIn(FeedVO feed);

    /* 피드 조회 */
    public FeedVO GetFeed(int feed_seq);

    /* 피드 수정 */
    public int FeedModify(FeedVO feed);

    /* 피드 삭제 */
    public int Delete(int feed_seq);
}
