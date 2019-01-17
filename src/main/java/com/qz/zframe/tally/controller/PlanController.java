package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.PeriodTime;
import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.service.PeriodTimeService;
import com.qz.zframe.tally.service.TallyPlanService;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.TallyPlanVO;
import com.qz.zframe.tally.vo.TallyStandardVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/support/tallyPlan")
@Api(
        tags = {"api-support-tallyPlan"},
        description = "巡检-巡检计划查询"
)
@Transactional(rollbackFor = Exception.class)
public class PlanController {

    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    TallyStandardService tallyStandardService;

    @Autowired
    TallyRouterService tallyRouterService;

    @Autowired
    PeriodTimeService periodTimeService;

    @Autowired
    TallyPlanService tallyPlanService;

    @ApiOperation(value="巡检计划查询", notes="根据线路，负责人，风机场，开始时间，结束时间" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public PageResultEntity listPlan(String currentUserId,
                                     @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) throws ParseException {
        PageResultEntity resultEntity=new PageResultEntity();
        PageHelper.startPage(pageNum,pageSize);

        List<TallyPlanVO> tallyPlanVOList=tallyPlanService.findAllTallyPlanVO(currentUserId);
        if (tallyPlanVOList==null||tallyPlanVOList.isEmpty()){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有巡检计划!");
            return resultEntity;
        }
        List<TallyPlanVO> tallyPlanVOList2=new ArrayList<TallyPlanVO>();
        for (TallyPlanVO tallyPlanVO:tallyPlanVOList){
            List<String> userNames=tallyPlanService.findUserNamesByRouteId(tallyPlanVO.getRouteId());
            if (userNames==null||userNames.isEmpty()){
                resultEntity.setCode(ErrorCode.ERROR);
                resultEntity.setMsg("巡检计划没有配置人员!");
                return resultEntity;
            }

            if (tallyPlanVO.getCycleUnit().equals("01")){
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(tallyPlanVO.getStartTime());
                calendar.add(Calendar.YEAR,new Integer(tallyPlanVO.getCycle()));
                tallyPlanVO.setEndTime(calendar.getTime());
                //tallyPlanVO.setEndTime(new Date(tallyPlanVO.getStartTime().getTime()+new Integer(tallyPlanVO.getCycle())*365*24*60*60*1000));
            }else if (tallyPlanVO.getCycleUnit().equals("02")){
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(tallyPlanVO.getStartTime());
                calendar.add(Calendar.MONTH,new Integer(tallyPlanVO.getCycle()));
                tallyPlanVO.setEndTime(calendar.getTime());
                //tallyPlanVO.setEndTime(new Date(tallyPlanVO.getStartTime().getTime()+new Integer(tallyPlanVO.getCycle())*30*24*60*60*1000));
            }else if (tallyPlanVO.getCycleUnit().equals("03")){
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(tallyPlanVO.getStartTime());
                calendar.add(Calendar.DATE,7*(new Integer(tallyPlanVO.getCycle())));
                tallyPlanVO.setEndTime(calendar.getTime());
                //tallyPlanVO.setEndTime(new Date(tallyPlanVO.getStartTime().getTime()+new Integer(tallyPlanVO.getCycle())*7*24*60*60*1000));
            } else if (tallyPlanVO.getCycleUnit().equals("04")){
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(tallyPlanVO.getStartTime());
                calendar.add(Calendar.DATE,new Integer(tallyPlanVO.getCycle()));
                tallyPlanVO.setEndTime(calendar.getTime());
                //tallyPlanVO.setEndTime(new Date(tallyPlanVO.getStartTime().getTime()+new Integer(tallyPlanVO.getCycle())*24*60*60*1000));
            }else if (tallyPlanVO.getCycleUnit().equals("05")){
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(tallyPlanVO.getStartTime());
                calendar.add(Calendar.HOUR,new Integer(tallyPlanVO.getCycle()));
                tallyPlanVO.setEndTime(calendar.getTime());
                //tallyPlanVO.setEndTime(new Date(tallyPlanVO.getStartTime().getTime()+new Integer(tallyPlanVO.getCycle())*60*60*1000));
            }

            Date date=new Date();
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateS=format1.format(date);
            Date date2=format1.parse(dateS);
            long diff=tallyPlanVO.getEndTime().getTime()-date2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            String surplusTime=""+days+"天"+hours+"小时"+minutes+"分";
            tallyPlanVO.setSurplusTime(surplusTime);
            tallyPlanVO.setUserNames(userNames);
            tallyPlanVOList2.add(tallyPlanVO);
        }

        PageInfo<TallyPlanVO> pageDate=new PageInfo<>(tallyPlanVOList2);

        resultEntity.setRows(tallyPlanVOList2);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检计划查询成功");
        resultEntity.setTotal((int) pageDate.getTotal());
        return resultEntity;

    }

}
