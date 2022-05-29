package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class ReplyVO {

    private int feed_seq;
    private int reply_seq;
    private String name;
    private String content;
    private Date datetime;
}
