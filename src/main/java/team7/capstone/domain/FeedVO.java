package team7.capstone.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
public class FeedVO {

    private int feed_seq;
    private String user_id;
    private String name;
    private String content;
    private Date datetime;
    private int release;

}
