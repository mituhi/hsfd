package com.qz.zframe.tally.service.impl;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.dao.TallyResultDao;
import com.qz.zframe.tally.entity.TallyResult;
import com.qz.zframe.tally.entity.TallyResultChoose;
import com.qz.zframe.tally.service.TallyResultService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("tallyResultService")
@Transactional(rollbackFor = Exception.class)
public class TallyResultServiceImpl implements TallyResultService{
    @Autowired
    TallyResultDao tallyResultDao;

    @Override
    public String findserialNum() {

        return String.valueOf(tallyResultDao.findserialNum()+10000);
    }

    /**
     * 根据条件查询结果选项
     * @param resultCode
     * @param resultName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResultEntity findResultForPage(String resultCode, String resultName, int pageNum, int pageSize) {
        PageResultEntity resultEntity = new PageResultEntity();
        //从第几条数据开始
        int firstIndex  = (pageNum - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = pageNum * pageSize;
        List<TallyResult> tallyResults = tallyResultDao.findAllTallyResult(resultCode,resultName,firstIndex,lastIndex);
        if (tallyResults == null || tallyResults.isEmpty()) {
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setRows(null);
            resultEntity.setTotal(0);
        }else {
            Integer num = tallyResultDao.countTallyResult(resultCode,resultName);
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setRows(tallyResults);
            resultEntity.setTotal(num);
        }
        return resultEntity;
    }
    /**
     * 结果选项配置添加
     * @param tallyResult
     * @return
     */
    @Override
    public ResultEntity addResult(TallyResult tallyResult) {
        ResultEntity resultEntity=new ResultEntity();
        if (tallyResult == null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("传入对象为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getResultName())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项分组名称不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getResultCode())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项编号不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getManyChoose())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("是否多选不能为空!");
            return resultEntity;
        }
        TallyResult tr = tallyResultDao.findTallyResultByResultCode(tallyResult.getResultCode());
        if (tr != null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项编号已存在!");
            return resultEntity;
        }
        tallyResult.setResultId(UUID.randomUUID().toString().replaceAll("-",""));
        tallyResult.setIsDelete("01");
        tallyResultDao.addTallyResult(tallyResult);
        List<TallyResultChoose> tallyResultChooseList = tallyResult.getTallyResultChooseList();
        if (tallyResultChooseList != null && !tallyResultChooseList.isEmpty()){
            for (TallyResultChoose trc : tallyResultChooseList){
                trc.setChooseId(UUID.randomUUID().toString().replaceAll("-",""));
                trc.setResultId(tallyResult.getResultId());
            }
        }
        tallyResultDao.addTallyResultChoose(tallyResultChooseList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("结果选项配置添加成功");
        return resultEntity;
    }

    /**
     * 结果选项配置修改
     * @param tallyResult
     * @return
     */
    @Override
    public ResultEntity updateResult(TallyResult tallyResult) {
        ResultEntity resultEntity=new ResultEntity();
        if (tallyResult == null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("传入对象为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getResultId())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项分组id不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getResultName())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项分组名称不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getResultCode())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项编号不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyResult.getManyChoose())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("是否多选不能为空!");
            return resultEntity;
        }
        TallyResult tr = tallyResultDao.findTallyResultByResultCodeNotId(tallyResult.getResultCode(), tallyResult.getResultId());
        if (tr != null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("结果选项编号已存在!");
            return resultEntity;
        }
        tallyResult.setIsDelete("01");
        tallyResultDao.updateTallyResult(tallyResult);
        List<TallyResultChoose> tallyResultChooseList = tallyResult.getTallyResultChooseList();
        if (tallyResultChooseList != null && !tallyResultChooseList.isEmpty()){
            deletetallyResultChooseList(tallyResult.getResultId());
            for (TallyResultChoose trc : tallyResultChooseList){
                trc.setChooseId(UUID.randomUUID().toString().replaceAll("-",""));
                trc.setResultId(tallyResult.getResultId());
            }
        }
        tallyResultDao.addTallyResultChoose(tallyResultChooseList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("结果选项配置修改成功");
        return resultEntity;
    }

    /**
     * 删除结果选项
     * @param resultIds
     */
    @Override
    public ResultEntity deleteTallyResult(String[] resultIds) {
        ResultEntity resultEntity=new ResultEntity();

        if (resultIds==null && resultIds.length == 0){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的结果选项!");
            return resultEntity;
        }
        tallyResultDao.updateTallyResultIsDelete(resultIds);
//        tallyResultDao.deleteTallyResult(resultIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("结果选项删除成功!");
        return resultEntity;
    }

    /**
     * 根据结果选项分组id删除结果选项
     * @param resultId
     */
    private void deletetallyResultChooseList(String resultId){
        if (StringUtils.isNotBlank(resultId)){
            tallyResultDao.deletetallyResultChooseList(resultId);
        }
    }
    /**
     * 根据结果选项分组id获取信息
     * @param resultId
     * @return
     */
    @Override
    public TallyResult findResultMsgById(String resultId) throws Exception {
        if (StringUtils.isBlank(resultId)){
            throw new Exception("结果选项分组id不能为空");
        }
        TallyResult tallyResult = tallyResultDao.findTallyResultByResultId(resultId);
        if (tallyResult != null){
            List<TallyResultChoose> tallyResultChooses =  tallyResultDao.findTallyResultChooseByResultId(resultId);
            if (tallyResultChooses != null && !tallyResultChooses.isEmpty()){
                tallyResult.setTallyResultChooseList(tallyResultChooses);
            }
        }
        return tallyResult;
    }
}
