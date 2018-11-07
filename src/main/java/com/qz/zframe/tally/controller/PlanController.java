package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.PeriodTime;
import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.service.PeriodTimeService;
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

import java.util.ArrayList;
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

    @ApiOperation(value="巡检计划查询(包括条件查询 分页有问题在改)", notes="根据线路，负责人，风机场，开始时间，结束时间" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listStandard(String routeName,
                                     String maintenancer,
                                     String windId,
                                     Date startTime,
                                     Date endTime,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "5")  int pageSize) {
        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

        //1.先查询所有点检标准表需要的字段
       //List<TallyRoute> tallyRouteList=tallyRouterService.findTallyRouteByPlan(routeName, maintenancer, windId, startTime, endTime);
        List<TallyPlanVO> tallyPlanVOList=tallyRouterService.findTallyPlanVOByPlan(routeName, maintenancer, windId, startTime, endTime);

        //List<TallyPlanVO> tallyPlanVOList=new ArrayList<TallyPlanVO>();

        /*for (TallyRoute tallyRoute:tallyRouteList){
            TallyPlanVO tallyPlanVO=new TallyPlanVO();

            tallyPlanVO.setRouteName(tallyRoute.getRouteName());
            tallyPlanVO.setMaintenancer(tallyRoute.getMaintenancer());

            //获取RouteName 根据routeid
            List<PeriodTime> periodTimeList=tallyRouterService.findPeriodTimeByPlan(tallyRoute.getRouteId());
            for (PeriodTime periodTime:periodTimeList){
                tallyPlanVO.setStartTime(periodTime.getStartTime());
                tallyPlanVO.setEndTime(periodTime.getEndTime());

                tallyPlanVOList.add(tallyPlanVO);
            }



        }*/

        PageBean<TallyPlanVO> pageDate=new PageBean<TallyPlanVO>(currentPage,pageSize,tallyPlanVOList.size());
        pageDate.setItems(tallyPlanVOList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("巡检计划查询成功");
        resultEntity.setData(pageDate);
        return resultEntity;

    }

    @ApiOperation(value="巡检计划删除(包括批量)", notes="根据传入的list进行删除" ,httpMethod="DELETE")
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity tallyDelete(@RequestBody List<TallyPlanVO> tallyPlanVOList) {
        ResultEntity resultEntity=new ResultEntity();

        if (tallyPlanVOList==null||tallyPlanVOList.size()==0){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的计划!");

            return resultEntity;
        }
        for (TallyPlanVO tallyPlanVO:tallyPlanVOList){
            //1.删除时间段表和关联表
            periodTimeService.deletePeriodTimeByRouteNames(tallyPlanVO.getRouteName(),tallyPlanVO.getStartTime(),tallyPlanVO.getEndTime());



            

        }

        //tallyRouterService.deleteByRouteId(routeNames);
        //2.删除路线人员关联表
        //tallyRouterService.deleteRouteUserByRouteId(routeIds);
        //3.删除路线标准关联
        //tallyRouterService.deleteTallyRouteStandardByRouteId(routeIds);
        //4.删除点检路线表
        //tallyRouterService.deleteTallyRouteByRouteId(routeIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");

        return resultEntity;
    }
}
