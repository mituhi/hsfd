package com.qz.zframe.maintain.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.common.service.UserService;
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
import com.qz.zframe.maintain.vo.MaintainWorkContentVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaintainLogInfoServiceImpl implements MaintainLogInfoService {

    @Autowired
    private MaintainLogInfoMapper maintainLogInfoMapper;

    @Autowired
    private MaintainWorkContentMapper maintainWorkContentMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private UserService userService;

    @Override
    public ResultEntity addMaintainLog(MaintainLogVo maintainLogVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (maintainLogVo.getMaintainTime()==null) {
            resultEntity.setMsg("维护时间不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getRecordPerson())) {
            resultEntity.setMsg("记录人id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员ids不能为空");
            return resultEntity;
        }
        //设置id
        maintainLogVo.setDayId(UUIdUtil.getUUID());
        //生成流水号
        maintainLogVo.setSerialNumber(String.valueOf(maintainLogInfoMapper.countByExample(new MaintainLogInfoExample())+1));
        //设置星期几
        int weekOfDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (weekOfDay==1) {
            weekOfDay = 7;
        }else {
            weekOfDay -=1;
        }
        maintainLogVo.setDayOfWeek(String.valueOf(weekOfDay));
        //设置状态为正常
        maintainLogVo.setStatus("01");
        //添加维护人
        if (!StringUtils.isNoneBlank(maintainLogVo.getMaintainer())) {
            maintainLogVo.setMaintainer(currentUserService.getId());
        }
        //添加维护日期
        if (maintainLogVo.getMaintainDate()==null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                maintainLogVo.setMaintainDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //插入数据库
        maintainLogInfoMapper.insertSelective(maintainLogVo);

        //添加昨日任务,今日任务
        this.insertTab(maintainLogVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加成功");
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
            resultEntity.setMsg("维护人id不能为空");
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
            resultEntity.setMsg("风电场编码不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getRecordPerson())) {
            resultEntity.setMsg("记录人id不能为空");
            return resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainLogVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员ids不能为空");
            return resultEntity;
        }
        //修改维护日志主数据
        MaintainLogInfo maintainLogInfo = maintainLogInfoMapper.selectByPrimaryKey(maintainLogVo.getDayId());
        BeanUtil.copyProperties(maintainLogVo,maintainLogInfo,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        maintainLogInfoMapper.updateByPrimaryKeySelective(maintainLogInfo);

        //修改昨日任务,今日任务
        this.updateTab(maintainLogVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteMaintainLog(String[] dayIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!ArrayUtils.isNotEmpty(dayIds)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        maintainLogInfoMapper.batchDelete(dayIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
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
        if (maintainLogVo!=null) {
            //获取当班人员姓名,逗号隔开
            StringBuffer sb = new StringBuffer();
            String[] ids = maintainLogVo.getOnDutyPerson().split(",");
            if (ids!=null && ids.length!=0) {
                for (String id : ids) {
                    try {
                        UserDto userDto = userService.queryUserInfo(id,null);
                        if (userDto!=null) {
                            sb.append(userDto.getUserName()).append(",");
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                maintainLogVo.setOnDutyPerson(sb.deleteCharAt(sb.length() - 1).toString());
            }
            if (maintainLogVo!=null) {
                //获取当日工作内容
                List<MaintainWorkContentVo> toDayWorkContentList = maintainWorkContentMapper.getToDayWorkContent(maintainLogVo.getDayId());
                if (toDayWorkContentList!=null && toDayWorkContentList.size()!=0) {
                    for (MaintainWorkContentVo maintainWorkContentVo :toDayWorkContentList) {
                        //获取工作人员姓名,逗号隔开
                        ids = maintainWorkContentVo.getStaff().split(",");
                        if (ids!=null && ids.length!=0) {
                            sb = new StringBuffer();
                            for (String id : ids) {
                                try {
                                    UserDto userDto = userService.queryUserInfo(id,null);
                                    if (userDto!=null) {
                                        sb.append(userDto.getUserName()).append(",");
                                    }
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            maintainWorkContentVo.setStaffName(sb.deleteCharAt(sb.length() - 1).toString());
                        }
                        maintainLogVo.getToDayWorkContentList().add(maintainWorkContentVo);
                    }
                }
                //获取昨日工作内容
                List<MaintainWorkContentVo> yesterdayWorkContentList = maintainWorkContentMapper.getYesterDayWorkContent(maintainLogVo.getDayId());
                if (yesterdayWorkContentList!=null && yesterdayWorkContentList.size()!=0) {
                    for (MaintainWorkContentVo maintainWorkContentVo : yesterdayWorkContentList) {
                        //获取工作人员姓名,逗号隔开
                        ids = maintainWorkContentVo.getStaff().split(",");
                        if (ids!=null && ids.length!=0) {
                            sb = new StringBuffer();
                            for (String id : ids) {
                                try {
                                    UserDto userDto = userService.queryUserInfo(id,null);
                                    if (userDto!=null) {
                                        sb.append(userDto.getUserName()).append(",");
                                    }
                                    maintainWorkContentVo.setStaffName(sb.deleteCharAt(sb.length() - 1).toString());
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        maintainLogVo.getToDayWorkContentList().add(maintainWorkContentVo);
                    }
                }
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
        if (maintainLogVoList!=null && maintainLogVoList.size()!=0) {
            maintainLogVoList.forEach(maintainLogVo -> {
                //获取当班人员姓名
                StringBuffer sb = new StringBuffer();
                String[] ids = maintainLogVo.getOnDutyPerson().split(",");
                if (ids!=null && ids.length!=0) {
                    for (String id : ids) {
                        try {
                            UserDto userDto = userService.queryUserInfo(id,null);
                            if (userDto!=null) {
                                sb.append(userDto.getUserName()).append(",");
                            }
                            maintainLogVo.setOnDutyPerson(sb.deleteCharAt(sb.length() - 1).toString());
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        int total = maintainLogInfoMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(maintainLogVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    private void insertTab(MaintainLogVo maintainLogVo) {
        //添加当日工作
        List<MaintainWorkContentVo> toDayWorkContentList = maintainLogVo.getToDayWorkContentList();
        if (CollectionUtils.isNotEmpty(toDayWorkContentList)) {
            int i = 1;
            for (MaintainWorkContent maintainWorkContent:toDayWorkContentList) {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setContentNumber(String.valueOf(i++));
                maintainWorkContent.setDayId(maintainLogVo.getDayId());
                maintainWorkContent.setWorkContentType("01");
                maintainWorkContentMapper.insert(maintainWorkContent);
            }
        }
        //添加昨日工作
        List<MaintainWorkContentVo> yesterdayWorkContentList = maintainLogVo.getYesterdayWorkContentList();
        if (yesterdayWorkContentList!=null && yesterdayWorkContentList.size()!=0) {
            int i = 1;
            for (MaintainWorkContent maintainWorkContent:yesterdayWorkContentList) {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setContentNumber(String.valueOf(i++));
                maintainWorkContent.setDayId(maintainLogVo.getDayId());
                maintainWorkContent.setWorkContentType("02");
                maintainWorkContentMapper.insert(maintainWorkContent);
            }
        }
    }

    private void updateTab(MaintainLogVo maintainLogVo) {
        //删除原来的今日任务
        MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
        MaintainWorkContentExample.Criteria toDaycriteria = maintainWorkContentExample.createCriteria();
        toDaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
        toDaycriteria.andWorkContentTypeEqualTo("01");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        //删除原来的昨日任务
        MaintainWorkContentExample.Criteria yesterdaycriteria = maintainWorkContentExample.createCriteria();
        yesterdaycriteria.andDayIdEqualTo(maintainLogVo.getDayId());
        yesterdaycriteria.andWorkContentTypeEqualTo("02");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);

        //重新添加
        this.insertTab(maintainLogVo);
    }
}
