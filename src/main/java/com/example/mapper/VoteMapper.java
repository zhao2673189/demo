package com.example.mapper;


import com.example.domain.User;
import com.example.domain.UserVoteInfo;
import com.example.domain.VoteInfo;
import com.example.domain.VoteOptionsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface VoteMapper {
	//
    int createSub(@Param("voteInfo") VoteInfo voteInfo);
    //创建选项
    int createOptions(@Param("voteInfo") List<VoteOptionsInfo> voteInfos);

    //根据口号id获取口号列表
    List<VoteInfo> getVoteList(@Param("subjectId") String subjectId);

    //投票排行榜
    List<VoteInfo> getUserVoteRank(@Param("subjectId") String subjectId);

    //根据用用户id获取口号列表
    List<VoteInfo> getVoteListByUserId(@Param("id") Long id);

    //根据口号id获取口号详情
    List<VoteInfo> getVoteDetail(@Param("subjectId") String subjectId);

    List<VoteOptionsInfo> getVoteOptionsList(@Param("subjectId") String subjectId);

    List<UserVoteInfo> getUserVoteOptions(@Param("subjectId") String subjectId, @Param("optionId") Long optionId);


    //根据口号id判断用户是否已经投过票
    List<UserVoteInfo> isUserVote(@Param("subjectId") String subjectId, @Param("id") Long id);


    //连表查询，详情
    List<UserVoteInfo> getUserVoteOptionsDetailsByOpt(@Param("subjectId") String subjectId, @Param("optionId") Long optionId);
    //根据口号id删除口号
    int deleteVote(@Param("subjectId") String subjectId);

    int deleteOptions(@Param("subjectId") String subjectId);

    int deleteVoteUser(@Param("subjectId") String subjectId);

    int vote(@Param("id") Long id, @Param("subjectId") String subjectId, @Param("optionIds") List<Long> optionIds, @Param("createDate") Date createDate);

    int updateOptionCountPlus1(@Param("subjectId") String subjectId, @Param("optionId") List<Long> optionId);
    //总票数和总人数
    int updateVoteCount(@Param("subjectId") String subjectId, @Param("addVoteCount") int addVoteCount);




}
