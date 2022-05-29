package team7.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team7.capstone.domain.Criteria;
import team7.capstone.domain.FeedVO;
import team7.capstone.mapper.FeedMapper;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService{

    @Autowired
    private FeedMapper mapper;

    @Override
    public List<FeedVO> GetList() {
        return mapper.GetList();
    }

    /* 피드 리스트(페이징 적용) */
    @Override
    public List<FeedVO> GetFeedList(Criteria cri) {

        return mapper.GetFeedList(cri);
    }

    @Override
    public void FeedIn(FeedVO feed) {
        mapper.FeedIn(feed);
    }

    @Override
    public FeedVO GetFeed(int feed_seq) {
        return mapper.GetFeed(feed_seq);
    }

    @Override
    public int FeedModify(FeedVO feed) {
        return mapper.FeedModify(feed);
    }

    @Override
    public int Delete(int feed_seq) {
        return mapper.Delete(feed_seq);
    }
}
