package team7.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team7.capstone.domain.ReplyVO;
import team7.capstone.domain.UserVO;
import team7.capstone.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyMapper mapper;

    /* 댓글 조회 */
    @Override
    public ReplyVO ReadReply(ReplyVO reply) {
        return mapper.ReadReply(reply);
    }
}
