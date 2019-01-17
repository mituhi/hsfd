package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.UserDto;
import com.qz.zframe.common.service.OrgArchitectureService;
import com.qz.zframe.common.service.UserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.tally.dto.QDto;
import com.qz.zframe.tally.dto.TallyRouterDto;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.PeriodTimeService;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.*;
import io.swagger.annotations.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("api/support/tallyRouter")
@Api(
        tags = {"api-support-tallyRouter"},
        description = "巡检-巡检路线配置"
)
@Transactional(rollbackFor = Exception.class)
public class InspectionController {

    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    TallyRouterService tallyRouterService;
    @Autowired
    TallyStandardService tallyStandardService;
    @Autowired
    PeriodTimeService periodTimeService;
    @Autowired
    private OrgArchitectureService orgArchitectureService;
    @Autowired
    private UserService userService;

    /**
     * 点击巡检和页面相关查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value="查询巡检线路", notes="初始界面有简单的查询功能" ,httpMethod="GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "windId1", value = "风电场1", required = false),
            @ApiImplicitParam(name = "windId2", value = "风电场2", required = false),
            @ApiImplicitParam(name = "routeName", value = "路线名称", required = false),
    })
    @RequestMapping("list")
    @ResponseBody
    public PageResultEntity list(String windId1,
                                 String windId2,
                                 String routeName,
                                 @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        PageResultEntity resultEntity=new PageResultEntity();
        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isBlank(windId2)){
            List<TallyRoute> tallyRouteList=tallyRouterService.findTallyRouteByWindIdAndRouteName(routeName, windId1);
            PageInfo<TallyRoute> pageData=new PageInfo<TallyRoute>(tallyRouteList);
            resultEntity.setRows(tallyRouteList);
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("获取分页信息成功");
            resultEntity.setTotal((int) pageData.getTotal());
            return resultEntity;
        }
        List<TallyRoute> tallyRouteList=tallyRouterService.findTallyRouteByWindIdAndRouteName(routeName, windId1,windId2);
        PageInfo<TallyRoute> pageData=new PageInfo<TallyRoute>(tallyRouteList);
        resultEntity.setRows(tallyRouteList);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取分页信息成功");
        resultEntity.setTotal((int) pageData.getTotal());
        return resultEntity;
    }

    @ApiOperation(value="删除巡检线路", notes="删除：删除选中的行记录" ,httpMethod="DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "routeIds", value = "路线ID", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity tallyDelete(@RequestBody List<String> routeIds) {
        ResultEntity resultEntity=new ResultEntity();
        if (routeIds==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的路线!");
            return resultEntity;
        }
        //tallyRouterService.deleteByRouteId(routeIds);//删除周期
        //tallyRouterService.deleteRouteUserByRouteId(routeIds);//删除路线人员关联

        tallyRouterService.deleteTallyRouteByRouteId(routeIds);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");
        return resultEntity;
    }

    @ApiOperation(value="获取流水号，当前日期，申请人", notes="获取巡检路线添加基础信息接口" ,httpMethod="GET")
    @RequestMapping("user")
    @ResponseBody
    public ResultEntity tallyUser() {
        ResultEntity resultEntity=new ResultEntity();
        //查流水号,tallyRoute查最大id
        int serialNum=tallyRouterService.findserialNum();
        //查申请日期
        Date currentDate=new Date();
        //查当前用户
        String userName=currentUserService.getUsername();
        String cycleId=UUIdUtil.getUUID();
        //String routeUserId=tallyRouterService.findRouteUserId();
        TallyRouterUserVO tallyRouterUserVO=new TallyRouterUserVO();
        tallyRouterUserVO.setSerialNum(serialNum);
        tallyRouterUserVO.setCurrentDate(currentDate);
        tallyRouterUserVO.setUserName(userName);
        tallyRouterUserVO.setCycleId(cycleId);
        //tallyRouterUserVO.setRouteUserId(routeUserId);
        //tallyRouterUserVO.setRouteId(UUID.randomUUID()+"");
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取成功!");
        resultEntity.setData(tallyRouterUserVO);
        return resultEntity;
    }

    @ApiOperation(value="新增巡检路线", notes="添加：新增一个路线，跳转至路线创建界面" ,httpMethod="POST")
    @RequestMapping("post")
    @ResponseBody
    public ResultEntity tallyPost(@RequestBody TallyPostVOP tallyPostVO) {
        ResultEntity resultEntity=new ResultEntity();
        if(StringUtils.isBlank(tallyPostVO.getWindId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("风电场不可为空");
        	return resultEntity;
        }
        if(StringUtils.isBlank(tallyPostVO.getRouteName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("路线名称不可为空");
        	return resultEntity;
        }
        
        if(StringUtils.isBlank(tallyPostVO.getCycleUnit())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("周期单位不可为空");
        	return resultEntity;
        }
        if(StringUtils.isBlank(tallyPostVO.getBenchmarkDate().toString())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("维护日期不可为空");
        	return resultEntity;
        }
      
        if(tallyPostVO.getRouteUsers()==null||tallyPostVO.getRouteUsers().isEmpty()){
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("人员不可为空");
        	return resultEntity;
        }
        TallyRoute tallyRoute=new TallyRoute();
        tallyRoute.setWindId(tallyPostVO.getWindId());//所属风场ID
        tallyRoute.setRouteName(tallyPostVO.getRouteName());//路线的名称
        tallyRoute.setStatus(tallyPostVO.getStatus());//状态
        tallyRoute.setSerialNum(tallyPostVO.getSerialNum());//流水号  。。。
        tallyRoute.setMaintenancer(tallyPostVO.getMaintenancer());//维护人 。。。
        tallyRoute.setMaintenanceTime(tallyPostVO.getMaintenanceTime());//维护日期 。。。
        tallyRoute.setRemark(tallyPostVO.getTallyRouteRemark());
        tallyRoute.setRouteId(String.valueOf(tallyRouterService.findserialNum()));//路线id  根流水号差不多来吧
        tallyRoute.setTrueId("0");
        tallyRouterService.addTallyRoute(tallyRoute);//完成巡检路线表
        Cycle cycle=new Cycle();
        cycle.setCycleId(UUIdUtil.getUUID());
        cycle.setRouteId(tallyRoute.getRouteId());
        cycle.setCycleName(tallyPostVO.getCycleName());
        cycle.setCycleUnit(tallyPostVO.getCycleUnit());
        cycle.setBenchmarkDate(tallyPostVO.getBenchmarkDate());
        cycle.setCycle(tallyPostVO.getCycle());
        cycle.setTrueId("0");
        tallyRouterService.addCycle(cycle);
        int len2=tallyPostVO.getRouteUsers().size();
        for (int t=0;t<len2;t++){
            RouteUser routeUser=new RouteUser();
            routeUser.setId(UUIdUtil.getUUID());
            routeUser.setRouteId(tallyRoute.getRouteId());
            //根据username获取userid
            //routeUser.setUserId(tallyRouterService.findUserIdByUserName(tallyPostVO.getRouteUsers().get(t).getUserName()));
            routeUser.setUserId(tallyPostVO.getRouteUsers().get(t).getUserId());
            routeUser.setTrueId("0");
                routeUser.setIsPractitioners(tallyPostVO.getRouteUsers().get(t).getIsPractitioners());
                routeUser.setIsManagers(tallyPostVO.getRouteUsers().get(t).getIsManagers());
                routeUser.setIsHead(tallyPostVO.getRouteUsers().get(t).getIsHead());

            tallyRouterService.addRouteUser(routeUser);
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加巡检路线相关信息成功!");
        return resultEntity;
    }

    @ApiOperation(value="修改巡检路线", notes="修改：修改选中的路线，界面同创建界面（含数据）" ,httpMethod="PUT")
    @RequestMapping("update")
    @ResponseBody
    public ResultEntity updateRouter(@RequestBody TallyPostVOW tallyPostVO) {
        ResultEntity resultEntity=new ResultEntity();
        if(StringUtils.isBlank(tallyPostVO.getWindId())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("风电场不可为空");
        	return resultEntity;
        }
        if(StringUtils.isBlank(tallyPostVO.getRouteName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("路线名称不可为空");
        	return resultEntity;
        }
        
        if(StringUtils.isBlank(tallyPostVO.getCycleUnit())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("周期单位不可为空");
        	return resultEntity;
        }
        if(StringUtils.isBlank(tallyPostVO.getBenchmarkDate().toString())) {
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("维护日期不可为空");
        	return resultEntity;
        }
      
        if(tallyPostVO.getRouteUsers()==null||tallyPostVO.getRouteUsers().isEmpty()){
        	resultEntity.setCode(ErrorCode.ERROR);
        	resultEntity.setMsg("人员不可为空");
        	return resultEntity;
        }
        TallyRoute tallyRoute=new TallyRoute();
        tallyRoute.setWindId(tallyPostVO.getWindId());//所属风场
        tallyRoute.setRouteName(tallyPostVO.getRouteName());//路线的名称
        tallyRoute.setStatus(tallyPostVO.getStatus());//状态
        tallyRoute.setRemark(tallyPostVO.getTallyRouteRemark());//备注
        tallyRoute.setSerialNum(tallyPostVO.getSerialNum());//流水号 查出来
        tallyRoute.setMaintenancer(tallyPostVO.getMaintenancer());//维护人 查出来，最近修改的人
        tallyRoute.setMaintenanceTime(tallyPostVO.getMaintenanceTime());//维护日期 查出来
        tallyRoute.setRouteId(tallyPostVO.getRouteId());//路线id  自己写一个UUID接口 要自己生成 有检验接口，所以一定不同
        tallyRouterService.updateTallyRoute(tallyRoute);//完成点检路线表更新

        Cycle cycle=new Cycle();

        cycle.setCycleId(tallyPostVO.getCycleId());
        cycle.setRouteId(tallyPostVO.getRouteId());
        cycle.setCycleName(tallyPostVO.getCycleName());
        cycle.setCycleUnit(tallyPostVO.getCycleUnit());
        cycle.setBenchmarkDate(tallyPostVO.getBenchmarkDate());
        cycle.setCycle(tallyPostVO.getCycle());

        tallyRouterService.updateCycle(cycle);

        int len2=tallyPostVO.getRouteUsers().size();
        tallyRouterService.deleteUserByRouteId(tallyRoute.getRouteId());
        for (int t=0;t<len2;t++){
            RouteUser routeUser=new RouteUser();
            routeUser.setId(UUIdUtil.getUUID());
            routeUser.setRouteId(tallyRoute.getRouteId());
            routeUser.setUserId(tallyPostVO.getRouteUsers().get(t).getUserId());
            routeUser.setIsPractitioners(tallyPostVO.getRouteUsers().get(t).getIsPractitioners());
            routeUser.setIsManagers(tallyPostVO.getRouteUsers().get(t).getIsManagers());
            routeUser.setIsHead(tallyPostVO.getRouteUsers().get(t).getIsHead());
            tallyRouterService.updateRouteUser(routeUser);
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("更新点检路线相关信息成功!");
        return resultEntity;
    }

    @ApiOperation(value="浏览巡检路线", notes="浏览：显示选中的路线数据，界面同创建界面（灰色，仅显示不能更改）" ,httpMethod="GET")
    @RequestMapping("browse")
    @ResponseBody
    public ResultEntity browse(String routeId) {
        ResultEntity resultEntity=new ResultEntity();

        TallyPostVOQ tallyPostVO=new TallyPostVOQ();

        TallyRoute tallyRoute=tallyRouterService.findTallyRouteByRouteId(routeId);

        tallyPostVO.setRouteId(tallyRoute.getRouteId());
        tallyPostVO.setRouteName(tallyRoute.getRouteName());
        tallyPostVO.setRouteCode(tallyRoute.getRouteCode());
        tallyPostVO.setWindId(tallyRoute.getWindId());
        tallyPostVO.setWindName(tallyRoute.getWindName());
        tallyPostVO.setStatus(tallyRoute.getStatus());
        tallyPostVO.setTallyRouteRemark(tallyRoute.getRemark());
        tallyPostVO.setMaintenancer(tallyRoute.getMaintenancer());
        tallyPostVO.setMaintenanceTime(tallyRoute.getMaintenanceTime());
        tallyPostVO.setSerialNum(tallyRoute.getSerialNum());
        Cycle cycle=tallyRouterService.findCycleByRouteId(routeId);
        tallyPostVO.setCycleId(cycle.getCycleId());
        tallyPostVO.setCycleName(cycle.getCycleName());
        tallyPostVO.setCycleUnit(cycle.getCycleUnit());
        tallyPostVO.setBenchmarkDate(cycle.getBenchmarkDate());
        tallyPostVO.setCycle(cycle.getCycle());
        tallyPostVO.setCycleUnitText(cycle.getCycleUnitText());
        tallyPostVO.setRouteUsers(tallyRouterService.findRouteUserByrouteId(routeId));


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("浏览巡检路线成功!");
        resultEntity.setData(tallyPostVO);
        return resultEntity;
    }

    @ApiOperation(value="查询风电场下部门和部门下人员信息", notes="下拉框根据风电场匹配信息" ,httpMethod="GET")
    @RequestMapping("getArchitectureAndMenberByWindId")
    @ResponseBody
    public PageResultEntity getArchitectureAndMenberByWindId(String windId,
                                                             @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        PageResultEntity resultEntity=new PageResultEntity();
        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isBlank(windId)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请先选择风电场!");
            return resultEntity;
        }
        resultEntity=tallyRouterService.getArchitectureAndMemberByWindId(windId,resultEntity);
        return resultEntity;
    }








}
