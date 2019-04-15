package com.example.domain;

import java.io.Serializable;
import java.util.Date;


public class VoteInfo implements Serializable {
    private String subject;
    private String subjectId;
    public static final int TYPE_SINGLE = 0;
    public static final int TYPE_MULTI = 1;
    private int type;
    private Date expiryDate;
    private Date createDate;
    private Date updateDate;
    private int sumUser;
    private int sumVote;
    private String percent;

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    private Boolean hasVoted = false;

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public int getSumUser() {
        return sumUser;
    }

    public void setSumUser(int sumUser) {
        this.sumUser = sumUser;
    }

    public int getSumVote() {
        return sumVote;
    }

    public void setSumVote(int sumVote) {
        this.sumVote = sumVote;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
