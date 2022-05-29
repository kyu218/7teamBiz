package team7.capstone.domain;

import lombok.ToString;

@ToString
public class Criteria {

    /* 현재 페이지 */
    private int pageNum;
    /* 한 페이지 당 보여질 피드 갯수 */
    private int amount;
    /* 스킵 할 피드 수 ( (pageNum - 1) * amount ) */
    private int skip;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.skip = (pageNum - 1) * this.amount;
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.skip = (this.pageNum - 1) * amount;
        this.amount = amount;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    /* 기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 10 */
    public Criteria() {
        this(1,10);
        this.skip = 0;
    }

    /* 생성자 => 원하는 pageNum, 원하는 amount */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum - 1) * amount;
    }
}
