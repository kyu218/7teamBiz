package team7.capstone.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team7.capstone.domain.ReplyVO;

@Mapper @Repository
public interface ReplyMapper {

    /* ๋๊ธ ์กฐํ */
    public ReplyVO ReadReply(ReplyVO reply);
}
