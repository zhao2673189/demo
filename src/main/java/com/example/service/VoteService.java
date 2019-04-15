package com.example.service;

import com.example.domain.MessageData;
import com.example.domain.SectionSourceParam;
import com.example.domain.VoteParam;


import java.util.List;


public interface VoteService {

    //列表
    MessageData voteList(Long id);

    //投票
    MessageData vote(Long id, String subjectId, List<Long> optionIndexs);

    //创建
    MessageData create(VoteParam voteParam);

    //删除
    MessageData delete(String subjectId);

    //详情
    MessageData detail(String subjectId, Long id);

    //修改
    MessageData update(VoteParam voteParam);

    //排行榜
    MessageData getRank(Long id);

//    //查看某个投票的某个选项的来源
//    MessageData checkSource(SectionSourceParam sectionSourceParam);
}
