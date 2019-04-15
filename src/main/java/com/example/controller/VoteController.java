package com.example.controller;


import com.example.domain.MessageData;
import com.example.domain.UserVote;
import com.example.domain.VoteParam;
import com.example.service.VoteService;
import com.example.until.Constant;
import com.example.until.DateUtils;
import com.example.until.ErrorMap;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vote")
public class VoteController {
   
    @Autowired
    VoteService voteService;

    @RequestMapping(value = "/create", produces = "application/json;charset=utf-8")
    MessageData create(@RequestBody VoteParam voteParam) {
        log.info("create------->", voteParam);
        if (voteParam == null) return new MessageData(Constant.MSG_PARAM_NULL, Constant.CODE_PARAM_NULL);
        else if (StringUtils.isNullOrEmpty(voteParam.getSubject())) {
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_SUBJECT_NULL), Constant.CODE_VOTE_SUBJECT_NULL);
        } else if (voteParam.getOption() == null || voteParam.getOption().size() == 0) {
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_OPTION_NULL), Constant.CODE_VOTE_OPTION_NULL);
        } else if (org.springframework.util.StringUtils.isEmpty(voteParam.getExpiryDate()) || DateUtils.parse(voteParam.getExpiryDate()) == null) {
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_EXPIRY_DATE_NULL), Constant.CODE_VOTE_EXPIRY_DATE_NULL);
        }
        for (String opt : voteParam.getOption()) {
            if (StringUtils.isNullOrEmpty(opt))
                return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_OPTION_CONTAINS_NULL), Constant.CODE_VOTE_OPTION_CONTAINS_NULL);
        }
        return voteService.create(voteParam);
    }


    @RequestMapping(value = "/list")
    MessageData getList(Long id) {
        log.info("getList------->", id);
        return voteService.voteList(id);
    }

    @RequestMapping(value = "/delete")
    MessageData delete(String subjectId) {
        log.info("delete------->", subjectId);
        if (StringUtils.isNullOrEmpty(subjectId))
            return new MessageData(Constant.MSG_PARAM_NULL, Constant.CODE_PARAM_NULL);
        return voteService.delete(subjectId);
    }

    @RequestMapping(value = "/vote", produces = "application/json;charset=utf-8")
    MessageData vote(@RequestBody UserVote userVote) {
        log.info("vote------->", userVote);
        if (userVote == null)
            return new MessageData(Constant.MSG_PARAM_NULL, Constant.CODE_PARAM_NULL);
        Long id = userVote.getId();
        String subjectId = userVote.getSubjectId();
        List<Long> optionId = userVote.getOptionId();
        if (id.equals(0))
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_USER_NOT_EXIST), Constant.CODE_USER_NOT_EXIST);
        else if (StringUtils.isNullOrEmpty(subjectId))
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_INFO_NULL), Constant.CODE_VOTE_INFO_NULL);
        else if (optionId == null || optionId.size() == 0) {
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_NOT_SELECT), Constant.CODE_VOTE_NOT_SELECT);
        }
        return voteService.vote(id, subjectId, optionId);
    }

    @RequestMapping(value = "/detail")
    MessageData detail(String subjectId, Long id) {
        log.info("detail------->", "subjectId=" + subjectId + "  id=" +id);
        if (StringUtils.isNullOrEmpty(subjectId))
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_VOTE_INFO_NULL), Constant.CODE_VOTE_INFO_NULL);
        if (id.equals(0))
            return new MessageData(ErrorMap.getErrorStr(Constant.CODE_USER_NOT_EXIST), Constant.CODE_USER_NOT_EXIST);

        return voteService.detail(subjectId, id);
    }
}
