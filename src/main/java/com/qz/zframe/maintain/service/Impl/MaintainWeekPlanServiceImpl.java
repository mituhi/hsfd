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
import com.qz.zframe.maintain.entity.MaintainWeekPlan;
import com.qz.zframe.maintain.entity.MaintainWeekPlanExample;
import com.qz.zframe.maintain.entity.MaintainWorkContent;
import com.qz.zframe.maintain.entity.MaintainWorkContentExample;
import com.qz.zframe.maintain.mapper.MaintainWeekPlanMapper;
import com.qz.zframe.maintain.mapper.MaintainWorkContentMapper;
import com.qz.zframe.maintain.service.MaintainWeekPlanService;
import com.qz.zframe.maintain.vo.MaintainWeekPlanVo;
import com.qz.zframe.maintain.vo.MaintainWorkContentVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaintainWeekPlanServiceImpl implements MaintainWeekPlanService {

    @Autowired
    private MaintainWeekPlanMapper maintainWeekPlanMapper;

    @Autowired
    private MaintainWorkContentMapper maintainWorkContentMapper;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private UserService userService;

    @Override
    public ResultEntity addMaintainWeekPlan(MaintainWeekPlanVo maintainWeekPlanVo) {
        ResultEntity resultEntity = new ResultEntity();

        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWeekOfYear())) {
            resultEntity.setMsg("第几周不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getRecordPerson())) {
            resultEntity.setMsg("记录人id不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员ids不能为空");
            return  resultEntity;
        }
        //设置id
        maintainWeekPlanVo.setWeekId(UUIdUtil.getUUID());
        //生成流水号
        maintainWeekPlanVo.setSerialNumber(String.valueOf(maintainWeekPlanMapper.countByExample(new MaintainWeekPlanExample())+1));
        //设置状态为正常
        maintainWeekPlanVo.setStatus("01");
        //设置开始时间 结束时间
        if (maintainWeekPlanVo.getStartDate()==null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int i = calendar.get(Calendar.DAY_OF_WEEK)-1;
            if (i==0) {
                maintainWeekPlanVo.setEndDate(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH,-6);
                maintainWeekPlanVo.setStartDate(calendar.getTime());
            }else {
                calendar.add(Calendar.DAY_OF_WEEK,1-i);
                maintainWeekPlanVo.setStartDate(calendar.getTime());
                calendar.add(Calendar.DAY_OF_WEEK,6);
                maintainWeekPlanVo.setEndDate(calendar.getTime());
            }
            calendar.add(Calendar.DAY_OF_MONTH,2-i);
        }else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(maintainWeekPlanVo.getStartDate());
            int i = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (i!=1) {
                resultEntity.setMsg("开始日期不是周一,请重新选择");
                return  resultEntity;
            }else {
                if (maintainWeekPlanVo.getEndDate()!=null) {
                    calendar.add(Calendar.DAY_OF_WEEK,6);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(maintainWeekPlanVo.getEndDate());
                    if (!calendar.getTime().equals(maintainWeekPlanVo.getEndDate())) {
                        resultEntity.setMsg("结束日期不是对应周日,请重新选择");
                        return  resultEntity;
                    }
                }else {
                    calendar.add(Calendar.DAY_OF_WEEK,6);
                    maintainWeekPlanVo.setEndDate(calendar.getTime());
                }
            }
        }
        //添加第几周
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int i = calendar.get(Calendar.WEEK_OF_YEAR);
        maintainWeekPlanVo.setWeekOfYear(String.valueOf(i));

        //添加维护人
        maintainWeekPlanVo.setMaintainer(currentUserService.getId());
        //插入数据库
        maintainWeekPlanMapper.insertSelective(maintainWeekPlanVo);

        //添加本周任务,上周任务
        this.insertTab(maintainWeekPlanVo);

        resultEntity.setMsg("添加成功");
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
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getWindId())) {
            resultEntity.setMsg("风电场编码不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getRecordPerson())) {
            resultEntity.setMsg("记录人id不能为空");
            return  resultEntity;
        }
        if (!StringUtils.isNoneBlank(maintainWeekPlanVo.getOnDutyPerson())) {
            resultEntity.setMsg("当班人员ids不能为空");
            return  resultEntity;
        }
        //修改维护周计划主数据
        MaintainWeekPlan maintainWeekPlan = maintainWeekPlanMapper.selectByPrimaryKey(maintainWeekPlanVo.getWeekId());
        BeanUtil.copyProperties(maintainWeekPlanVo,maintainWeekPlan,true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        maintainWeekPlanMapper.updateByPrimaryKeySelective(maintainWeekPlan);

        //修改本周工作,上周工作
        this.updateTab(maintainWeekPlanVo);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    @Override
    public ResultEntity deleteMaintainWeekPlan(String[] weekIds) {
        ResultEntity resultEntity = new ResultEntity();

        if (!(weekIds!=null && weekIds.length!=0)) {
            resultEntity.setMsg("ids不能为空");
            return resultEntity;
        }
        maintainWeekPlanMapper.batchDelete(weekIds);

        resultEntity.setMsg("删除成功");
        resultEntity.setCode(ErrorCode.SUCCESS);
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
            //获取当班人员姓名,逗号隔开
            StringBuffer sb = new StringBuffer();
            String[] ids = maintainWeekPlanVo.getOnDutyPerson().split(",");
            if (ids!=null && ids.length!=0) {
                for (String id : ids) {
                    try {
                        UserDto userDto = userService.queryUserInfo(id,null);
                        if (userDto!=null) {
                            sb.append(userDto.getUserName()).append(",");
                        }
                        maintainWeekPlanVo.setOnDutyPerson(sb.deleteCharAt(sb.length() - 1).toString());
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (maintainWeekPlanVo!=null) {
                //获取本周工作
                List<MaintainWorkContentVo> thisWeekWorkContentList = maintainWorkContentMapper.getThisWeekWorkContent(maintainWeekPlanVo.getWeekId());
                if (thisWeekWorkContentList!=null && thisWeekWorkContentList.size()!=0) {
                    for (MaintainWorkContentVo maintainWorkContentVo :thisWeekWorkContentList) {
                        //获取工作人员姓名,逗号隔开
                        sb = new StringBuffer();
                        ids = maintainWorkContentVo.getStaff().split(",");
                        if (ids!=null && ids.length!=0) {
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
                        maintainWeekPlanVo.getThisWeekWorkContentList().add(maintainWorkContentVo);
                    }
                }
                //获取上周计划
                List<MaintainWorkContentVo> lastWeekWorkContentList = maintainWorkContentMapper.getLastWeekWorkContent(maintainWeekPlanVo.getWeekId());
                if (lastWeekWorkContentList!=null && lastWeekWorkContentList.size()!=0) {
                    for (MaintainWorkContentVo maintainWorkContentVo : lastWeekWorkContentList) {
                        //获取工作人员姓名,逗号隔开
                        sb = new StringBuffer();
                        ids = maintainWorkContentVo.getStaff().split(",");
                        if (ids!=null && ids.length!=0) {
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
                        maintainWeekPlanVo.getLastWeekWorkContentList().add(maintainWorkContentVo);
                    }
                }
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
        if (maintainWeekPlanVoList!=null && maintainWeekPlanVoList.size()!=0) {
            maintainWeekPlanVoList.forEach(maintainWeekPlanVo -> {
                //获取当班人员姓名
                StringBuffer sb = new StringBuffer();
                String[] ids = maintainWeekPlanVo.getOnDutyPerson().split(",");
                if (ids!=null && ids.length!=0) {
                    for (String id : ids) {
                        try {
                            UserDto userDto = userService.queryUserInfo(id,null);
                            if (userDto!=null) {
                                sb.append(userDto.getUserName()).append(",");
                            }
                            maintainWeekPlanVo.setOnDutyPerson(sb.deleteCharAt(sb.length() - 1).toString());
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        int total = maintainWeekPlanMapper.getTotal(pageAndCondition);

        pageResultEntity.setCode(ErrorCode.SUCCESS);
        pageResultEntity.setMsg("查询成功");
        pageResultEntity.setRows(maintainWeekPlanVoList);
        pageResultEntity.setTotal(total);
        return pageResultEntity;
    }

    private void insertTab(MaintainWeekPlanVo maintainWeekPlanVo) {
        //添加本周工作
        List<MaintainWorkContentVo> thisWeekWorkContentList = maintainWeekPlanVo.getThisWeekWorkContentList();
        int i = 1;
        if (CollectionUtils.isNotEmpty(thisWeekWorkContentList)) {
            for (MaintainWorkContent maintainWorkContent:thisWeekWorkContentList) {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setContentNumber(String.valueOf(i++));
                maintainWorkContent.setWeekId(maintainWeekPlanVo.getWeekId());
                maintainWorkContent.setWorkContentType("01");
                maintainWorkContentMapper.insert(maintainWorkContent);
            }
        }
        //添加上周工作
        List<MaintainWorkContentVo> lastWeekWorkContentList = maintainWeekPlanVo.getLastWeekWorkContentList();
        if (CollectionUtils.isNotEmpty(lastWeekWorkContentList)) {
            for (MaintainWorkContent maintainWorkContent:lastWeekWorkContentList) {
                maintainWorkContent.setWorkContentId(UUIdUtil.getUUID());
                maintainWorkContent.setContentNumber(String.valueOf(i++));
                maintainWorkContent.setWeekId(maintainWeekPlanVo.getWeekId());
                maintainWorkContent.setWorkContentType("02");
                maintainWorkContentMapper.insert(maintainWorkContent);
            }
        }
    }

    private void updateTab(MaintainWeekPlanVo maintainWeekPlanVo) {
        //删除原来的本周工作
        MaintainWorkContentExample maintainWorkContentExample = new MaintainWorkContentExample();
        MaintainWorkContentExample.Criteria thisWeekcriteria = maintainWorkContentExample.createCriteria();
        thisWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
        thisWeekcriteria.andWorkContentTypeEqualTo("01");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);
        //删除原来的上周工作
        MaintainWorkContentExample.Criteria lastWeekcriteria = maintainWorkContentExample.createCriteria();
        lastWeekcriteria.andDayIdEqualTo(maintainWeekPlanVo.getWeekId());
        lastWeekcriteria.andWorkContentTypeEqualTo("02");
        maintainWorkContentMapper.deleteByExample(maintainWorkContentExample);

        //重新添加
        this.insertTab(maintainWeekPlanVo);
    }
}
