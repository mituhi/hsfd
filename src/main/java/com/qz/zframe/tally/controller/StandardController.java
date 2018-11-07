package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyRouteStandard;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.TallyRouterUserVO;
import com.qz.zframe.tally.vo.TallyStandardPostVO;
import com.qz.zframe.tally.vo.TallyStandardVO;
import com.qz.zframe.tally.vo.WindIdCycleNameVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@RequestMapping("api/support/tallyStandard")
@Api(
        tags = {"api-support-tallyStandard"},
        description = "巡检-巡检标准配置"
)
@Transactional(rollbackFor = Exception.class)
public class StandardController {

    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    TallyStandardService tallyStandardService;

    @Autowired
    TallyRouterService tallyRouterService;

    @ApiOperation(value="点检标准查询(包括条件查询)", notes="根据所属设备，状态，所属路线，报警类型，标准编码，点检内容进行查询" ,httpMethod="GET")

    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listStandard(String equipmentBelonging,
                                     String routeId,
                                     String equipmentState,
                                     String alarmType,
                                     String standardCoding,
                                     String checkContent,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "2")  int pageSize) {
        ResultEntity resultEntity=new ResultEntity();

        //获取记录总数
        int n=tallyStandardService.countStandard(equipmentBelonging, routeId, equipmentState, alarmType, standardCoding, checkContent);

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




        }
        PageBean<TallyStandardVO> pageDate=new PageBean<TallyStandardVO>(currentPage,pageSize,n);
        pageDate.setItems(tallyStandardVOList);


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("点检标准查询成功");
        resultEntity.setData(pageDate);
        return resultEntity;
    }


    @ApiOperation(value="点检标准删除(包括批量)", notes="根据传入的所属路线数组进行删除" ,httpMethod="DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "routeNames", value = "所属路线数组", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity deleteStandard(String[] routeNames) {
        ResultEntity resultEntity=new ResultEntity();

        if (routeNames==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的标准!");

            return resultEntity;
        }
        //1.删除关联
        //tallyRouterService.deleteByRouteId(routeIds);
        //tallyStandardService.deletetallyRouteStandardByPeriodTimeIds(periodTimeIds);
         tallyStandardService.deletetallyRouteStandardByRouteNames(routeNames);
        //2.删除标准表
        //tallyRouterService.deleteRouteUserByRouteId(routeIds);
        //tallyStandardService.deleteTallyStandardByPeriodTimeIds(periodTimeIds);
        tallyStandardService.deleteTallyStandardByRouteNames(routeNames);



        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");

        return resultEntity;
    }

    @ApiOperation(value="点检标准添加", notes="根据点检标准所需信息添加" ,httpMethod="POST")
    @RequestMapping("post")
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

    //todo
    @ApiOperation(value="所属路线匹配所属风电场和执行周期(添加点检标准时使用 还没写好)", notes="选择所属路线后自动加载风电场和执行周期" ,httpMethod="GET")
    @RequestMapping("checkStandardRouterUser")
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
    @RequestMapping("update")
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

    @ApiOperation(value="点击标准更新(获取更新页面显示用信息)", notes="根据路线名称查更新页面信息" ,httpMethod="GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "routeName", value = "所属路线", required = false),
    })
    @RequestMapping("updateDetail")
    @ResponseBody
    public ResultEntity updateDetail(String routeName) {
        ResultEntity resultEntity=new ResultEntity();

        TallyStandardPostVO tallyStandardPostVO=new TallyStandardPostVO();

        TallyStandard tallyStandard=tallyStandardService.findTallyStandardByRouteName(routeName);
        tallyStandardPostVO.setAlarmCeiling(tallyStandard.getAlarmCeiling());
        tallyStandardPostVO.setAlarmLowerlimit(tallyStandard.getAlarmLowerlimit());
        tallyStandardPostVO.setAlarmType(tallyStandard.getAlarmType());
        tallyStandardPostVO.setCheckContent(tallyStandard.getCheckContent());
        tallyStandardPostVO.setCheckMethod(tallyStandard.getCheckMethod());
        tallyStandardPostVO.setDataType(tallyStandard.getDataType());
        tallyStandardPostVO.setEmissivity(tallyStandard.getEmissivity());
        tallyStandardPostVO.setEquipmentBelonging(tallyStandard.getEquipmentBelonging());
        tallyStandardPostVO.setEquipmentState(tallyStandard.getEquipmentState());
        tallyStandardPostVO.setLocation(tallyStandard.getLocation());
        tallyStandardPostVO.setLowerlimitMileage(tallyStandard.getLowerlimitMileage());
        tallyStandardPostVO.setMaincontrolPoint(tallyStandard.getMaincontrolPoint());
        tallyStandardPostVO.setMeasurementUnit(tallyStandard.getMeasurementUnit());
        tallyStandardPostVO.setResultOptions(tallyStandard.getResultOptions());
        tallyStandardPostVO.setRouteName(routeName);
        tallyStandardPostVO.setSignalType(tallyStandard.getSignalType());
        tallyStandardPostVO.setStandardCoding(tallyStandard.getStandardCoding());
        tallyStandardPostVO.setStandardJudgment(tallyStandard.getStandardJudgment());
        tallyStandardPostVO.setStandardType(tallyStandard.getStandardType());
        tallyStandardPostVO.setStartandstopPoint(tallyStandard.getStartandstopPoint());
        tallyStandardPostVO.setTwodimensionalcodeLocation(tallyStandard.getTwodimensionalcodeLocation());
        tallyStandardPostVO.setTypicalValue(tallyStandard.getTypicalValue());
        tallyStandardPostVO.setUpperlimitMileage(tallyStandard.getUpperlimitMileage());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("更新信息查询成功");
        resultEntity.setData(tallyStandardPostVO);
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




    //todo 一堆下拉
}
