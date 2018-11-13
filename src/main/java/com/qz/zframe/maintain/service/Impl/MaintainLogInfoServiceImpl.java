package com.qz.zframe.maintain.service.Impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.maintain.entity.MaintainLogInfo;
import com.qz.zframe.maintain.entity.MaintainLogInfoExample;
import com.qz.zframe.maintain.entity.MaintainWorkContent;
import com.qz.zframe.maintain.entity.MaintainWorkContentExample;
import com.qz.zframe.maintain.mapper.MaintainLogInfoMapper;
import com.qz.zframe.maintain.mapper.MaintainWorkContentMapper;
import com.qz.zframe.maintain.service.MaintainLogInfoService;
import com.qz.zframe.maintain.vo.MaintainLogVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaintainLogInfoServiceImpl implements MaintainLogInfoService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private MaintainLogInfoMapper maintainLogInfoMapper;

    @Autowired
    private MaintainWorkContentMapper maintainWorkContentMapper;

    @Override
    public ResultEntity addMaintainLog(MaintainLogVo maintainLogVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(maintainLogVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (maintainLogVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (maintainLogVo.getMaintainTime()==null) {
            resultEntity.setMsg("维护时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getRecordPerson())) {
            resultEntity.setMsg("记录人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员不能为空");
            return resultEntity;
        }
        //添加维护日志主数据
        MaintainLogInfo maintainLogInfo = new MaintainLogInfo();
        BeanUtils.copyProperties(maintainLogVo,maintainLogInfo);
        maintainLogInfo.setDayId(UUIdUtil.getUUID());
        maintainLogInfo.setSerialNumber(String.valueOf(maintainLogInfoMapper.countByExample(new MaintainLogInfoExample())+1));
        //maintainLogInfo.setDayOfWeek(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1));
        maintainLogInfoMapper.insert(maintainLogInfo);
        //添加当日工作
        List<MaintainWorkContent> toDayWorkContentList = maintainLogVo.getToDayWorkContentList();
        if (toDayWorkContentList!=null && toDayWorkContentList.size()!=0) {
            toDayWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setDayId(maintainLogVo.getDayId());
                maintainWorkContent.setWorkContentType("01");
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }
        //添加昨日工作
        List<MaintainWorkContent> yesterdayWorkContentList = maintainLogVo.getYesterdayWorkContentList();
        if (yesterdayWorkContentList!=null && yesterdayWorkContentList.size()!=0) {
            yesterdayWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setDayId(maintainLogVo.getDayId());
                maintainWorkContent.setWorkContentType("02");
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteMaintainLog(String dayIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(dayIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }

        String[] ids = dayIds.split(",");
        maintainLogInfoMapper.batchDelete(ids);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @Override
    public ResultEntity updateMaintainLog(MaintainLogVo maintainLogVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(maintainLogVo.getDayId())) {
            resultEntity.setMsg("日志id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getSerialNumber())) {
            resultEntity.setMsg("流水号不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getMaintainer())) {
            resultEntity.setMsg("维护人不能为空");
            return resultEntity;
        }
        if (maintainLogVo.getMaintainDate()==null) {
            resultEntity.setMsg("维护日期不能为空");
            return resultEntity;
        }
        if (maintainLogVo.getMaintainTime()==null) {
            resultEntity.setMsg("维护时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getWindId())) {
            resultEntity.setMsg("风电场id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getRecordPerson())) {
            resultEntity.setMsg("记录人不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员不能为空");
            return resultEntity;
        }
        //修改维护日志主数据
        MaintainLogInfo maintainLogInfo = new MaintainLogInfo();
        BeanUtils.copyProperties(maintainLogVo,maintainLogInfo);
        maintainLogInfoMapper.updateByPrimaryKey(maintainLogInfo);
        //修改当日工作
        MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
        MaintainWorkContentExample.Criteria toDaycriteria = maintainWorkContentExample.createCriteria();
        toDaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
        toDaycriteria.andWorkContentTypeEqualTo("01");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        List<MaintainWorkContent> toDayWorkContentList = maintainLogVo.getToDayWorkContentList();
        if (toDayWorkContentList!=null && toDayWorkContentList.size()!=0) {
            toDayWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }
        //修改昨日工作
        MaintainWorkContentExample.Criteria yesterdaycriteria = maintainWorkContentExample.createCriteria();
        yesterdaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
        yesterdaycriteria.andWorkContentTypeEqualTo("02");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        List<MaintainWorkContent> yesterdayWorkContentList = maintainLogVo.getYesterdayWorkContentList();
        if (yesterdayWorkContentList!=null && yesterdayWorkContentList.size()!=0) {
            yesterdayWorkContentList.forEach(maintainWorkContent -> {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContentMapper.insert(maintainWorkContent);
            });
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity getMaintainLogDetail(String dayId) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(dayId)) {
            resultEntity.setMsg("id不能为空");
            return resultEntity;
        }
        //获取日志主数据
        MaintainLogVo maintainLogVo = maintainLogInfoMapper.getMaintainLogDetail(dayId);
        System.out.println(maintainLogVo);
        if (maintainLogVo!=null) {
            //获取当日工作内容
            MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
            maintainWorkContentExample.setOrderByClause("content_number");
            MaintainWorkContentExample.Criteria toDaycriteria = maintainWorkContentExample.createCriteria();
            toDaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
            toDaycriteria.andWorkContentTypeEqualTo("01");
            List<MaintainWorkContent> toDayWorkContentList = maintainWorkContentMapper.selectByExample(maintainWorkContentExample);
            if (toDayWorkContentList!=null && toDayWorkContentList.size()!=0) {
                toDayWorkContentList.forEach(maintainWorkContent -> {
                    maintainLogVo.getToDayWorkContentList().add(maintainWorkContent);
                });
            }
            //获取昨日工作内容
            MaintainWorkContentExample.Criteria yesterdaycriteria = maintainWorkContentExample.createCriteria();
            yesterdaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            yesterdaycriteria.andWorkContentTypeEqualTo("02");
            List<MaintainWorkContent> yesterdayWorkContentList = maintainWorkContentMapper.selectByExample(maintainWorkContentExample);
            if (yesterdayWorkContentList!=null && yesterdayWorkContentList.size()!=0) {
                yesterdayWorkContentList.forEach(maintainWorkContent -> {
                    maintainLogVo.getToDayWorkContentList().add(maintainWorkContent);
                });
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("查询成功");
        resultEntity.setData(maintainLogVo);
        return resultEntity;
    }

    @Override
    public PageResultEntity getMaintainLogList(Map<String, String> pageAndCondition) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setRows(new ArrayList());

        String start = String.valueOf((Integer.parseInt(pageAndCondition.get("pageNum"))-1)*(Integer.parseInt(pageAndCondition.get("pageSize"))));
        pageAndCondition.put("start",start);
        List<MaintainLogVo> maintainLogVoList = maintainLogInfoMapper.getMaintainLogList(pageAndCondition);
        int total = maintainLogInfoMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(maintainLogVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }
}
