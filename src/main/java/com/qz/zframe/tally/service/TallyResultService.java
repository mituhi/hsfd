package com.qz.zframe.tally.service;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyResult;
import com.qz.zframe.tally.entity.TallyResultChoose;

import java.util.List;

public interface TallyResultService {

    /**
     * 结果选项配置流水号
     * @return
     */
    String findserialNum();

    /**
     * 根据条件查询结果选项
     * @param resultId
     * @param resultName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResultEntity findResultForPage(String resultId, String resultName, int pageNum, int pageSize);

    /**
     * 结果选项配置添加
     * @param tallyResult
     * @return
     */
    ResultEntity addResult(TallyResult tallyResult);

    /**
     * 结果选项配置修改
     * @param tallyResult
     * @return
     */
    ResultEntity updateResult(TallyResult tallyResult);

    /**
     * 删除结果选项
     * @param resultIds
     */
    ResultEntity deleteTallyResult(String[] resultIds);

    /**
     * 根据结果选项分组id获取信息
     * @param resultId
     * @return
     */
    TallyResult findResultMsgById(String resultId) throws Exception;
}
