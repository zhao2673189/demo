package com.example.domain;

import java.util.Date;
import java.util.List;

//用户投票中间表
public class UserVote {
    private Long id;
    private String subjectId;
    private List<Long> optionId;
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public List<Long> getOptionId() {
        return optionId;
    }

    public void setOptionId(List<Long> optionId) {
        this.optionId = optionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
