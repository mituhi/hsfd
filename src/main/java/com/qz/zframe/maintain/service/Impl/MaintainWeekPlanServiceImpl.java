package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.MaintainWeekPlan;
import com.qz.zframe.maintain.entity.MaintainWeekPlanExample;
import com.qz.zframe.maintain.entity.MaintainWorkContent;
import com.qz.zframe.maintain.entity.MaintainWorkContentExample;
import com.qz.zframe.maintain.mapper.MaintainWeekPlanMapper;
import com.qz.zframe.maintain.mapper.MaintainWorkContentMapper;
import com.qz.zframe.maintain.service.MaintainWeekPlanService;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaintainWeekPlanServiceImpl implements MaintainWeekPlanService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private MaintainWeekPlanMapper maintainWeekPlanMapper;

    @Autowired
    private MaintainWorkContentMapper maintainWorkContentMapper;

    @Override
    public ResultEntity addMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getMaintainTime()==null) {
            resultEntity.setMsg("维护人不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getStartDate()==null) {
            resultEntity.setMsg("周计划开始日期不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getEndDate()==null) {
            resultEntity.setMsg("周计划结束日期不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWeekOfYear())) {
            resultEntity.setMsg("第几周不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getRecordPerson())) {
            resultEntity.setMsg("记录人不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员不能为空");
            return  resultEntity;
        }
        //添加维护周计划主数据
        MaintainWeekPlan maintainWeekPlan = new MaintainWeekPlan();
        BeanUtils.copyProperties(maintainWeekPlanVo,maintainWeekPlan);
        maintainWeekPlan.setWeekId(UUIdUtil.getUUID());
        maintainWeekPlan.setSerialNumber(String.valueOf(maintainWeekPlanMapper.countByExample(new MaintainWeekPlanExample())+1));
        maintainWeekPlanMapper.insert(maintainWeekPlan);
        //添加本周工作
        List<MaintainWorkContent> thisWeekWorkContentList = maintainWeekPlanVo.getThisWeekWorkContentList();
        if (thisWeekWorkContentList!=null && thisWeekWorkContentList.size()!=0) {
            thisWeekWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setWeekId(maintainWeekPlanVo.getWeekId());
                maintainWorkContent.setWorkContentType("01");
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }
        //添加上周工作
        List<MaintainWorkContent> lastWeekWorkContentList = maintainWeekPlanVo.getLastWeekWorkContentList();
        if (lastWeekWorkContentList!=null && lastWeekWorkContentList.size()!=0) {
            lastWeekWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setWeekId(maintainWeekPlanVo.getWeekId());
                maintainWorkContent.setWorkContentType("02");
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }

        resultEntity.setMsg("添加成功");
        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    @Override
    public ResultEntity deleteMaintainWeekPlan(String weekIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(weekIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = weekIds.split(",");
        maintainWeekPlanMapper.batchDelete(ids);

        resultEntity.setMsg("删除成功");
        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    @Override
    public ResultEntity updateMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWeekId())) {
            resultEntity.setMsg("维护周计划id不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getSerialNumber())) {
            resultEntity.setMsg("流水号不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getMaintainTime()==null) {
            resultEntity.setMsg("维护人不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getStartDate()==null) {
            resultEntity.setMsg("周计划开始日期不能为空");
            return  resultEntity;
        }
        if (maintainWeekPlanVo.getEndDate()==null) {
            resultEntity.setMsg("周计划结束日期不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWeekOfYear())) {
            resultEntity.setMsg("第几周不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getRecordPerson())) {
            resultEntity.setMsg("记录人不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员不能为空");
            return  resultEntity;
        }
        //修改维护周计划主数据
        MaintainWeekPlan maintainWeekPlan = new MaintainWeekPlan();
        BeanUtils.copyProperties(maintainWeekPlanVo,maintainWeekPlan);
        maintainWeekPlanMapper.updateByPrimaryKey(maintainWeekPlan);
        //修改本周工作
        MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
        MaintainWorkContentExample.Criteria thisWeekcriteria = maintainWorkContentExample.createCriteria();
        thisWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
        thisWeekcriteria.andWorkContentTypeEqualTo("01");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        List<MaintainWorkContent> thisWeekWorkContentList = maintainWeekPlanVo.getThisWeekWorkContentList();
        if (thisWeekWorkContentList!=null && thisWeekWorkContentList.size()!=0) {
            thisWeekWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }
        //修改上周工作
        MaintainWorkContentExample.Criteria lastWeekcriteria = maintainWorkContentExample.createCriteria();
        lastWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
        lastWeekcriteria.andWorkContentTypeEqualTo("02");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        List<MaintainWorkContent> lastWeekWorkContentList = maintainWeekPlanVo.getLastWeekWorkContentList();
        if (lastWeekWorkContentList!=null && lastWeekWorkContentList.size()!=0) {
            lastWeekWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getMaintainWeekPlanDetail(String weekId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(weekId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //获取周计划主数据
        MaintainWeekPlanVo maintainWeekPlanVo = maintainWeekPlanMapper.getMaintainWeekPlanDetail(weekId);
        if (maintainWeekPlanVo!=null) {
            //获取本周工作
            MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
            maintainWorkContentExample.setOrderByClause("content_number");
            MaintainWorkContentExample.Criteria thisWeekcriteria = maintainWorkContentExample.createCriteria();
            thisWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
            thisWeekcriteria.andWorkContentTypeEqualTo("01");
            List<MaintainWorkContent> thisWeekWorkContentList = maintainWorkContentMapper.selectByExample(maintainWorkContentExample);
            if (thisWeekWorkContentList!=null && thisWeekWorkContentList.size()!=0) {
                thisWeekWorkContentList.forEach(maintainWorkContent -> {
                    maintainWeekPlanVo.getThisWeekWorkContentList().add(maintainWorkContent);
                });
            }
            //获取上周计划
            MaintainWorkContentExample.Criteria lastWeekcriteria = maintainWorkContentExample.createCriteria();
            lastWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
            lastWeekcriteria.andWorkContentTypeEqualTo("02");
            List<MaintainWorkContent> lastWeekWorkContentList = maintainWorkContentMapper.selectByExample(maintainWorkContentExample);
            if (lastWeekWorkContentList!=null && lastWeekWorkContentList.size()!=0) {
                lastWeekWorkContentList.forEach(maintainWorkContent -> {
                    maintainWeekPlanVo.getThisWeekWorkContentList().add(maintainWorkContent);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(maintainWeekPlanVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getMaintainWeekPlanList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<MaintainWeekPlanVo> maintainWeekPlanVoList = maintainWeekPlanMapper.getMaintainWeekPlanList(pageAndCondition);
        int total = maintainWeekPlanMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(maintainWeekPlanVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
