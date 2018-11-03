package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
import java.util.UUID;


@Controller
@RequestMapping("api/support/tallyRouter")
@Api(
        tags = {"api-support-tally"},
        description = "巡检"
)
@Transactional(rollbackFor = Exception.class)
public class InspectionController {

    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    TallyRouterService tallyRouterService;
    @Autowired
    TallyStandardService tallyStandardService;

    /**
     * 点击巡检和页面相关查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value="巡检线路查询（包括条件查询）", notes="可以根据无参，路线编码，路线名称，当前页，每页显示条数查询" ,httpMethod="GET")
    @RequestMapping("listRoute")
    @ResponseBody
    public ResultEntity listRoute(String windId,
                                   String routeCode,
                                   String routeName,
                                   @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "1")  int pageSize) {



        ResultEntity resultEntity=new ResultEntity();
        PageHelper.startPage(currentPage,pageSize);

        //1.先查询所有点检路线表需要的字段
        List<TallyRoute> tallyRouteList=tallyRouterService.findAllTallyRouter(windId,routeCode,routeName);
        List<TallyRouterVO> tallyRouterVOList=new ArrayList<TallyRouterVO>();

        //2.先添加点检路线表的数据，然后路线→周期 或者→关联人id→姓名
        for (TallyRoute tallyRoute:tallyRouteList){
            TallyRouterVO tallyRouterVO=new TallyRouterVO();
            tallyRouterVO.setRouteName(tallyRoute.getRouteName());
            tallyRouterVO.setRouteCode(tallyRoute.getRouteCode());
            tallyRouterVO.setWindId(tallyRoute.getWindId());
            tallyRouterVO.setRouteId(tallyRoute.getRouteId());

            //2.1根据路线id查周期名称
            tallyRouterVO.setCycleName(tallyRouterService.findCycleNameByRouteId(tallyRoute.getRouteId()));

            List<String> userNames=new ArrayList<String>();
            //2.2关联人id查出人员
            /*2.2.1先根据路线id查出关联人id*/
            List<String> userIds=tallyRouterService.findUserIdsByRouteId(tallyRoute.getRouteId());
            for (String userId:userIds){
                /*2.2.2根据id查名字*/
                userNames.add(tallyRouterService.findUserNameByUserId(userId));
            }
            tallyRouterVO.setUserNames(userNames);

            tallyRouterVOList.add(tallyRouterVO);
        }


        PageBean<TallyRouterVO> pageData=new PageBean<TallyRouterVO>(currentPage,pageSize,tallyRouterVOList.size());
        pageData.setItems(tallyRouterVOList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取分页信息成功");
        resultEntity.setData(pageData);
        return resultEntity;
    }

    @ApiOperation(value="巡检线路删除(包括批量)", notes="根据传入的路线id数组进行删除" ,httpMethod="DELETE")
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity tallyDelete(String[] routeIds) {
        ResultEntity resultEntity=new ResultEntity();

        if (routeIds==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的路线!");

            return resultEntity;
        }
        //1.删除周期表记录
        tallyRouterService.deleteByRouteId(routeIds);
        //2.删除路线人员关联表
        tallyRouterService.deleteRouteUserByRouteId(routeIds);
        //3.删除路线标准关联
        tallyRouterService.deleteTallyRouteStandardByRouteId(routeIds);
        //4.删除点检路线表
        tallyRouterService.deleteTallyRouteByRouteId(routeIds);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");

        return resultEntity;
    }

    @ApiOperation(value="获取流水号，当前日期，申请人（当前登录用户）", notes="获取巡检路线添加基础信息接口" ,httpMethod="GET")
    @RequestMapping("user")
    @ResponseBody
    public ResultEntity tallyUser() {
        ResultEntity resultEntity=new ResultEntity();
        //查流水号,tallyRoute查最大id
        int serialNum=tallyRouterService.findserialNum()+1;
        //查申请日期
        Date currentDate=new Date();
        //查当前用户
        String userName=currentUserService.getUsername();

        TallyRouterUserVO tallyRouterUserVO=new TallyRouterUserVO();
        tallyRouterUserVO.setSerialNum(serialNum);
        tallyRouterUserVO.setCurrentDate(currentDate);
        tallyRouterUserVO.setUserName(userName);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取成功!");
        resultEntity.setData(tallyRouterUserVO);
        return resultEntity;
    }


    //todo 具体校验和前端对接
    @ApiOperation(value="巡检路线添加", notes="根据风电场，周期名称，基准日期，路线id,周期单位，周期，人员等信息添加" ,httpMethod="POST")
    @RequestMapping("post")
    @ResponseBody
    public ResultEntity tallyPost(@RequestBody TallyPostVO tallyPostVO) {
        ResultEntity resultEntity=new ResultEntity();

        if (StringUtils.isBlank(tallyPostVO.getWindId()) || StringUtils.isBlank(tallyPostVO.getCycleName())
                || StringUtils.isBlank(tallyPostVO.getBenchmarkDate().toString())
                || StringUtils.isBlank(tallyPostVO.getRouteId())
                ||StringUtils.isBlank(tallyPostVO.getCycleUnit())
                ||StringUtils.isBlank(tallyPostVO.getCycle())
                ||StringUtils.isBlank(tallyPostVO.getUserNames().get(0))) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少必填字段!");
            return resultEntity;
        }

        TallyRoute tallyRoute=new TallyRoute();
        tallyRoute.setRouteCode(tallyPostVO.getRouteCode());//路线编码
        tallyRoute.setWindId(tallyPostVO.getWindId());//所属风场
        tallyRoute.setRouteName(tallyPostVO.getRouteName());//路线的名称
        tallyRoute.setMandatoryOrder(tallyPostVO.getMandatoryOrder());//强制次序
        tallyRoute.setRemark(tallyPostVO.getTallyRouteRemark());//备注
        tallyRoute.setSerialNum(tallyPostVO.getSerialNum());//流水号
        tallyRoute.setMaintenancer(tallyPostVO.getMaintenancer());//维护人
        tallyRoute.setMaintenanceTime(tallyPostVO.getMaintenanceTime());//维护日期
        tallyRoute.setRouteId(tallyPostVO.getRouteId());//路线id  要自己生成 有检验接口，所以一定不同

        tallyRouterService.addTallyRoute(tallyRoute);//完成巡检路线表

        Cycle cycle=new Cycle();
        cycle.setCycleId(UUID.randomUUID()+""); //还是看具体要求*************
        cycle.setRouteId(tallyPostVO.getRouteId());
        cycle.setCycleName(tallyPostVO.getCycleName());
        cycle.setCycleUnit(tallyPostVO.getCycleUnit());
        cycle.setBenchmarkDate(tallyPostVO.getBenchmarkDate());
        cycle.setCycle(tallyPostVO.getCycle());

        tallyRouterService.addCycle(cycle);

        int len=tallyPostVO.getStartTimes().size();

        for (int i=0;i<len;i++){
            PeriodTime periodTime=new PeriodTime();
            periodTime.setPeriodTimeId(""+ UUID.randomUUID());
            periodTime.setStartTime(tallyPostVO.getStartTimes().get(i));
            periodTime.setEndTime(tallyPostVO.getEndTimes().get(i));

            tallyRouterService.addPeriodTime(periodTime);

            CyclePeriodTime cyclePeriodTime=new CyclePeriodTime();

            cyclePeriodTime.setId(UUID.randomUUID()+"");
            cyclePeriodTime.setCycleId(cycle.getCycleId());
            cyclePeriodTime.setPeriodTimeId(periodTime.getPeriodTimeId());

            tallyRouterService.addCyclePeriodTime(cyclePeriodTime);

        }


       int len2=tallyPostVO.getUserNames().size();
       for (int i=0;i<len2;i++){
           RouteUser routeUser=new RouteUser();
           routeUser.setId(UUID.randomUUID()+"");
           routeUser.setRouteId(tallyPostVO.getRouteId());

           //根据username获取userid
            routeUser.setUserId(tallyRouterService.findUserIdByUserName(tallyPostVO.getUserNames().get(i)));
           //routeUser.setUserId();
           routeUser.setIsPractitioners("0");//看情况
           routeUser.setIsHead("0");//看情况
           routeUser.setIsManagers("0");//看情况

           routeUser.setRemark(tallyPostVO.getIscUserRemark());

            tallyRouterService.addRouteUser(routeUser);
       }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加巡检路线相关信息成功!");

        return resultEntity;
    }

    @ApiOperation(value="校验路线id是否已经存在(添加路线时使用)", notes="前端传递路线id进行校验" ,httpMethod="GET")
    @RequestMapping("checkRouteId")
    @ResponseBody
    public ResultEntity checkRouteId(String routeId) {
        ResultEntity resultEntity=new ResultEntity();
        int num=tallyRouterService.checkRouteId(routeId);

        if (num<=0){
            resultEntity.setCode(ErrorCode.SUCCESS);
            resultEntity.setMsg("路线id可用!");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.ERROR);
        resultEntity.setMsg("路线id不可用!");
        return resultEntity;
    }

    @ApiOperation(value="获取选择人员(只有全部的)", notes="点击选择后提供人员信息" ,httpMethod="GET")
    @RequestMapping("choice")
    @ResponseBody
    public ResultEntity choice() {
        ResultEntity resultEntity=new ResultEntity();
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取人员信息成功!");
        resultEntity.setData(tallyRouterService.choicePeople());
        return resultEntity;
    }

    //todo
    @ApiOperation(value="获取风电场下拉项(没实现)", notes="点击下拉后获取风电场下拉信息" ,httpMethod="GET")
    @RequestMapping("winds")
    @ResponseBody
    public ResultEntity winds() {
        ResultEntity resultEntity=new ResultEntity();
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取风电场下拉列表信息成功!");
        resultEntity.setData(tallyRouterService.choicePeople());
        return resultEntity;
    }


    //todo 获取路线编码






    @ApiOperation(value="点检标准查询(包括条件查询)", notes="根据所属设备，状态，所属路线，报警类型，标准编码，点检内容进行查询" ,httpMethod="GET")
    @RequestMapping("listStandard")
    @ResponseBody
    public ResultEntity listStandard(String equipmentBelonging,
                                     String routeId,
                                     String equipmentState,
                                     String alarmType,
                                     String standardCoding,
                                     String checkContent,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "1")  int pageSize) {
        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

        //1.先查询所有点检标准表需要的字段
        List<TallyStandard> tallyStandardList=tallyStandardService.findAllTallyStandard(equipmentBelonging,routeId,equipmentState,alarmType,standardCoding,checkContent);

        List<TallyStandardVO> tallyStandardVOList=new ArrayList<TallyStandardVO>();

        for (TallyStandard tallyStandard:tallyStandardList){
            TallyStandardVO tallyStandardVO=new TallyStandardVO();
            tallyStandardVO.setAlarmType(tallyStandard.getAlarmType());
            tallyStandardVO.setCheckContent(tallyStandard.getCheckContent());
            tallyStandardVO.setEquipmentBelonging(tallyStandard.getEquipmentBelonging());

            //获取RouteName 根据routeid
            tallyStandardVO.setRouteName(tallyStandardService.findRouteNameByRouteId(tallyStandard.getRouteId()));
            tallyStandardVO.setWindId(tallyStandardService.findWindIdByRouteId(tallyStandard.getRouteId()));
            tallyStandardVO.setStandardCoding(tallyStandard.getStandardCoding());
            tallyStandardVOList.add(tallyStandardVO);

            PageBean<TallyStandardVO> pageDate=new PageBean<TallyStandardVO>(currentPage,pageSize,tallyStandardVOList.size());
            pageDate.setItems(tallyStandardVOList);


        }



        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("点检标准查询成功");
        resultEntity.setData(tallyStandardVOList);
        return resultEntity;
    }


    @ApiOperation(value="点检标准删除(包括批量)", notes="根据传入的标准id数组进行删除" ,httpMethod="DELETE")
    @RequestMapping("deleteStandard")
    @ResponseBody
    public ResultEntity deleteStandard(String[] periodTimeIds) {
        ResultEntity resultEntity=new ResultEntity();

        if (periodTimeIds==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的标准!");

            return resultEntity;
        }
        //1.删除关联
        //tallyRouterService.deleteByRouteId(routeIds);
        tallyStandardService.deletetallyRouteStandardByPeriodTimeIds(periodTimeIds);
        //2.删除标准表
        //tallyRouterService.deleteRouteUserByRouteId(routeIds);
        tallyStandardService.deleteTallyStandardByPeriodTimeIds(periodTimeIds);



        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");

        return resultEntity;
    }

    @ApiOperation(value="点检标准添加", notes="根据点检标准所需信息添加" ,httpMethod="POST")
    @RequestMapping("postStandard")
    @ResponseBody
    public ResultEntity postStandard(@RequestBody TallyStandardPostVO tallyStandardPostVO) {
        ResultEntity resultEntity=new ResultEntity();
        //1.是否缺少必填的字段
        if (StringUtils.isBlank(tallyStandardPostVO.getEquipmentBelonging()) || StringUtils.isBlank(tallyStandardPostVO.getLocation())
                || StringUtils.isBlank(tallyStandardPostVO.getStandardCoding())
                || StringUtils.isBlank(tallyStandardPostVO.getStandardType())
                ||StringUtils.isBlank(tallyStandardPostVO.getDataType())
                ||StringUtils.isBlank(tallyStandardPostVO.getSignalType())
                ||StringUtils.isBlank(tallyStandardPostVO.getCheckContent())
                ||StringUtils.isBlank(tallyStandardPostVO.getCheckMethod())
                ||StringUtils.isBlank(tallyStandardPostVO.getStandardJudgment())
                ||StringUtils.isBlank(tallyStandardPostVO.getResultOptions())
                ||StringUtils.isBlank(tallyStandardPostVO.getMeasurementUnit())
                ||StringUtils.isBlank(tallyStandardPostVO.getTypicalValue())
                ||StringUtils.isBlank(tallyStandardPostVO.getTwodimensionalcodeLocation())
                ||StringUtils.isBlank(tallyStandardPostVO.getEquipmentState())
                ||StringUtils.isBlank(tallyStandardPostVO.getStartandstopPoint())
                ||StringUtils.isBlank(tallyStandardPostVO.getMaincontrolPoint())
                ||StringUtils.isBlank(tallyStandardPostVO.getAlarmType())
                ||StringUtils.isBlank(tallyStandardPostVO.getAlarmCeiling())
                ||StringUtils.isBlank(tallyStandardPostVO.getAlarmLowerlimit())
                ||StringUtils.isBlank(tallyStandardPostVO.getEmissivity())
                ||StringUtils.isBlank(tallyStandardPostVO.getUpperlimitMileage())
                ||StringUtils.isBlank(tallyStandardPostVO.getLowerlimitMileage())
                ) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少必填字段!");
            return resultEntity;
        }

        TallyStandard tallyStandard=new TallyStandard();
        tallyStandard.setStandardId(UUID.randomUUID()+"");//还是看具体要求吧。。。。
        //根据路线名称获取路线id
        // 线路名称要不一致判断
        //todo 前端校验
        String s=tallyStandardService.findRouteIdByRouteName(tallyStandardPostVO.getRouteName());
        tallyStandard.setRouteId(s);
        tallyStandard.setEquipmentId(UUID.randomUUID()+"");
        tallyStandard.setStandardCoding(tallyStandardPostVO.getStandardCoding());
        tallyStandard.setEquipmentBelonging(tallyStandardPostVO.getEquipmentBelonging());
        tallyStandard.setLocation(tallyStandardPostVO.getLocation());
        tallyStandard.setCheckContent(tallyStandardPostVO.getCheckContent());
        tallyStandard.setStandardType(tallyStandardPostVO.getStandardType());
        tallyStandard.setDataType(tallyStandardPostVO.getDataType());
        tallyStandard.setSignalType(tallyStandardPostVO.getSignalType());
        tallyStandard.setCheckMethod(tallyStandardPostVO.getCheckMethod());
        tallyStandard.setStandardJudgment(tallyStandardPostVO.getStandardJudgment());
        tallyStandard.setResultOptions(tallyStandardPostVO.getResultOptions());
        tallyStandard.setMeasurementUnit(tallyStandardPostVO.getMeasurementUnit());
        tallyStandard.setTypicalValue(tallyStandardPostVO.getTypicalValue());
        tallyStandard.setEquipmentState(tallyStandardPostVO.getEquipmentState());
        tallyStandard.setTwodimensionalcodeLocation(tallyStandardPostVO.getTwodimensionalcodeLocation());
        tallyStandard.setStartandstopPoint(tallyStandardPostVO.getStartandstopPoint());
        tallyStandard.setMaincontrolPoint(tallyStandardPostVO.getMaincontrolPoint());
        tallyStandard.setAlarmType(tallyStandardPostVO.getAlarmType());
        tallyStandard.setAlarmCeiling(tallyStandardPostVO.getAlarmCeiling());
        tallyStandard.setAlarmLowerlimit(tallyStandardPostVO.getAlarmLowerlimit());
        tallyStandard.setEmissivity(tallyStandardPostVO.getEmissivity());
        tallyStandard.setUpperlimitMileage(tallyStandardPostVO.getUpperlimitMileage());
        tallyStandard.setLowerlimitMileage(tallyStandardPostVO.getLowerlimitMileage());

        tallyStandardService.addTallyStandard(tallyStandard);

        //完成关系表更新路线标准
        TallyRouteStandard tallyRouteStandard=new TallyRouteStandard();
        tallyRouteStandard.setId(""+UUID.randomUUID()); //以后看具体标准
        tallyRouteStandard.setStandardId(tallyStandard.getStandardId());
        tallyRouteStandard.setRouteId(tallyStandard.getRouteId());

        tallyStandardService.addTallyRouteStandard(tallyRouteStandard);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("添加点检标准相关信息成功!");

        return resultEntity;
    }

    @ApiOperation(value="所属路线匹配所属风电场和执行周期(添加点检标准时使用)", notes="选择所属路线后自动加载风电场和执行周期" ,httpMethod="GET")
    @RequestMapping("standardRouterUser")
    @ResponseBody
    public ResultEntity standardRouterUser(String routeName) {
        ResultEntity resultEntity=new ResultEntity();

        WindIdCycleNameVO windIdCycleNameVO=new WindIdCycleNameVO();
        windIdCycleNameVO.setWindId(tallyStandardService.findWindIdByRouteName(routeName));
        windIdCycleNameVO.setCycleName(tallyStandardService.findCycleNameByRouteName(routeName));


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("匹配风电场和执行周期信息成功!");
        resultEntity.setData(windIdCycleNameVO);
        return resultEntity;
    }


    @ApiOperation(value="点检标准更新", notes="根据点检标准所需信息修改" ,httpMethod="PUT")
    @RequestMapping("updateStandard")
    @ResponseBody
    public ResultEntity updateStandard(@RequestBody TallyStandardPostVO tallyStandardPostVO) {
        ResultEntity resultEntity=new ResultEntity();

        TallyStandard tallyStandard=new TallyStandard();
        tallyStandard.setStandardId(tallyStandardService.findStandardIdByRouteName(tallyStandardPostVO.getRouteName()));//还是看具体要求吧。。。。

        tallyStandard.setRouteId(tallyStandardService.findRouteIdByRouteName(tallyStandardPostVO.getRouteName()));
        tallyStandard.setEquipmentId(tallyStandardService.findEquipmentIdByRouteName(tallyStandardPostVO.getRouteName()));
        tallyStandard.setStandardCoding(tallyStandardPostVO.getStandardCoding());
        tallyStandard.setEquipmentBelonging(tallyStandardPostVO.getEquipmentBelonging());
        tallyStandard.setLocation(tallyStandardPostVO.getLocation());
        tallyStandard.setCheckContent(tallyStandardPostVO.getCheckContent());
        tallyStandard.setStandardType(tallyStandardPostVO.getStandardType());
        tallyStandard.setDataType(tallyStandardPostVO.getDataType());
        tallyStandard.setSignalType(tallyStandardPostVO.getSignalType());
        tallyStandard.setCheckMethod(tallyStandardPostVO.getCheckMethod());
        tallyStandard.setStandardJudgment(tallyStandardPostVO.getStandardJudgment());
        tallyStandard.setResultOptions(tallyStandardPostVO.getResultOptions());
        tallyStandard.setMeasurementUnit(tallyStandardPostVO.getMeasurementUnit());
        tallyStandard.setTypicalValue(tallyStandardPostVO.getTypicalValue());
        tallyStandard.setEquipmentState(tallyStandardPostVO.getEquipmentState());
        tallyStandard.setTwodimensionalcodeLocation(tallyStandardPostVO.getTwodimensionalcodeLocation());
        tallyStandard.setStartandstopPoint(tallyStandardPostVO.getStartandstopPoint());
        tallyStandard.setMaincontrolPoint(tallyStandardPostVO.getMaincontrolPoint());
        tallyStandard.setAlarmType(tallyStandardPostVO.getAlarmType());
        tallyStandard.setAlarmCeiling(tallyStandardPostVO.getAlarmCeiling());
        tallyStandard.setAlarmLowerlimit(tallyStandardPostVO.getAlarmLowerlimit());
        tallyStandard.setEmissivity(tallyStandardPostVO.getEmissivity());
        tallyStandard.setUpperlimitMileage(tallyStandardPostVO.getUpperlimitMileage());
        tallyStandard.setLowerlimitMileage(tallyStandardPostVO.getLowerlimitMileage());

        tallyStandardService.updateTallyStandard(tallyStandard);//更新

        //完成关系表更新路线标准
        TallyRouteStandard tallyRouteStandard=new TallyRouteStandard();
        tallyRouteStandard.setId(tallyStandardService.findIdByRouteName(tallyStandardPostVO.getRouteName())); //以后看具体标准
        tallyRouteStandard.setStandardId(tallyStandard.getStandardId());
        tallyRouteStandard.setRouteId(tallyStandard.getRouteId());

       // tallyStandardService.addTallyRouteStandard(tallyRouteStandard);
        tallyStandardService.updateTallyRouteStandard(tallyRouteStandard);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("更新点检标准相关信息成功!");

        return resultEntity;
    }


    //todo 一堆下拉





}
