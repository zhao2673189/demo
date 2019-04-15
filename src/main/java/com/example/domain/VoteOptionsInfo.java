package com.example.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class VoteOptionsInfo implements Serializable {
    private Long id;
    private String subjectId;
    private String optionStr;
    private int optionIndex;
    private Date createDate;

    //统计信息
    private int voteCount;
    private String percent;
    private boolean hasVoted;

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    private List<UserVoteInfo> userVotes;

    public List<UserVoteInfo> getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(List<UserVoteInfo> userVotes) {
        this.userVotes = userVotes;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getOptionStr() {
        return optionStr;
    }

    public void setOptionStr(String optionStr) {
        this.optionStr = optionStr;
    }

    public int getOptionIndex() {
        return optionIndex;
    }

    public void setOptionIndex(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
