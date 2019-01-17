package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyRoute;
import com.qz.zframe.tally.entity.TallyRouteStandard;
import com.qz.zframe.tally.entity.TallyStandard;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.service.TallyStandardService;
import com.qz.zframe.tally.vo.*;
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



    @ApiOperation(value="查询点检标准", notes="根据所属设备，所属路线，标准类型，点检内容进行查询" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public PageResultEntity listStandard(String equipmentBelonging,
                                     String routeName,
                                     String standardType,
                                     String checkContent,
                                     @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {

        PageResultEntity resultEntity=new PageResultEntity();

        PageHelper.startPage(pageNum,pageSize);

        List<TallyStandardVO2> tallyStandardVO2s=tallyStandardService.findAllTallyStandardVO2(equipmentBelonging, routeName, standardType, checkContent);

        PageInfo<TallyStandardVO2> pageData=new PageInfo<TallyStandardVO2>(tallyStandardVO2s);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("点检标准查询成功");
        resultEntity.setRows(tallyStandardVO2s);
        resultEntity.setTotal((int) pageData.getTotal());
        return resultEntity;
    }


    @ApiOperation(value="删除点检标准", notes="根据传入的所属巡检id数组进行删除" ,httpMethod="DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "standardIds", value = "巡检标准Id", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity deleteStandard(String[] standardIds) {
        ResultEntity resultEntity=new ResultEntity();
        if (standardIds==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请选择要删除的标准!");
            return resultEntity;
        }
        tallyStandardService.deleteTallyStandardByRouteNames(standardIds);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功!");
        return resultEntity;
    }

    @ApiOperation(value="新增点检标准", notes="根据点检标准所需信息添加" ,httpMethod="POST")
    @RequestMapping("post")
    @ResponseBody
    public ResultEntity postStandard(@RequestBody TallyStandardPostVO tallyStandardPostVO) {
        ResultEntity resultEntity=new ResultEntity();
        if (tallyStandardPostVO==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("新增数据为空!");
            return resultEntity;
        }
        //1.是否缺少必填的字段
        if (StringUtils.isBlank(tallyStandardPostVO.getEquipmentId())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少所属设备!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getStandardType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少标准类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getDataType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少数据类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getSignalType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少信号类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getCheckContent())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少点检内容!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getStandardJudgment())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少判断标准!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getResultOptions())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少结果选项!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getEquipmentState())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少设备状态!");
            return resultEntity;
        }

        resultEntity=tallyStandardService.addTallyStandardNew(tallyStandardPostVO,resultEntity);
        return resultEntity;
    }

    @ApiOperation(value="修改点检标准", notes="根据点检标准所需信息修改" ,httpMethod="PUT")
    @RequestMapping("update")
    @ResponseBody
    public ResultEntity updateStandard(@RequestBody TallyStandardPostVO tallyStandardPostVO) {
        ResultEntity resultEntity=new ResultEntity();
        if (tallyStandardPostVO==null){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("修改标准对象为空!");
            return resultEntity;
        }
        //1.是否缺少必填的字段
        if (StringUtils.isBlank(tallyStandardPostVO.getStandardId())){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("巡检标准id为空!");
            return resultEntity;
        }
        //1.是否缺少必填的字段
        if (StringUtils.isBlank(tallyStandardPostVO.getEquipmentId())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少所属设备!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getStandardType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少标准类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getDataType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少数据类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getSignalType())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少信号类型!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getCheckContent())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少点检内容!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getStandardJudgment())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少判断标准!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getResultOptions())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少结果选项!");
            return resultEntity;
        }
        if (StringUtils.isBlank(tallyStandardPostVO.getEquipmentState())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("缺少设备状态!");
            return resultEntity;
        }
        resultEntity=tallyStandardService.updateTallyStandardByStandardId(tallyStandardPostVO,resultEntity);
        return resultEntity;
    }

    @ApiOperation(value="浏览标准页面信息", notes="根据标准id查更新页面信息" ,httpMethod="GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "standardId", value = "标准id", required = false),
    })
    @RequestMapping("updateDetail")
    @ResponseBody
    public ResultEntity updateDetail(String standardId) {
        ResultEntity resultEntity=new ResultEntity();
        //1.是否缺少必填的字段
        if (StringUtils.isBlank(standardId)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("巡检标准id为空!");
            return resultEntity;
        }

       resultEntity=tallyStandardService.updateDetail(resultEntity,standardId);

        return resultEntity;
    }

    @ApiOperation(value="获取流水号，当前日期，申请人", notes="获取巡检路线添加基础信息接口" ,httpMethod="GET")
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

    @ApiOperation(value="获取路线名称下拉框", notes="获取巡检路线名称" ,httpMethod="GET")
    @RequestMapping("getTallyRouteNames")
    @ResponseBody
    public ResultEntity getTallyRouteNames() {
        ResultEntity resultEntity=new ResultEntity();

        resultEntity=tallyRouterService.findAllTallyRouteName(resultEntity);

        return resultEntity;
    }

    @ApiOperation(value="获取所属设备或者二维码位置带上风电场下拉框", notes="获取所属设备或者二维码位置下拉框" ,httpMethod="GET")
    @RequestMapping("GetEquipmentOrQrCode")
    @ResponseBody
    public ResultEntity GetEquipmentOrQrCode(String windCode,String qrId,String equipmentId) {
        ResultEntity resultEntity=new ResultEntity();
        if (StringUtils.isBlank(windCode)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("没有获取风电场编码");
            return resultEntity;
        }

        resultEntity=tallyStandardService.findEquipmentOrQrCode(resultEntity,windCode,qrId,equipmentId);

        return resultEntity;
    }

    @ApiOperation(value="获取结果选项下拉框", notes="结果选项下拉框" ,httpMethod="GET")
    @RequestMapping("GetResult")
    @ResponseBody
    public ResultEntity GetResult() {
        ResultEntity resultEntity=new ResultEntity();

        resultEntity=tallyStandardService.findAllResult(resultEntity);

        return resultEntity;
    }

    @ApiOperation(value="获取计量单位下拉框", notes="计量单位下拉框" ,httpMethod="GET")
    @RequestMapping("GetUnit")
    @ResponseBody
    public ResultEntity GetUnit(String name) {
        ResultEntity resultEntity=new ResultEntity();
        if (StringUtils.isBlank(name)){
                resultEntity.setCode(ErrorCode.ERROR);
                resultEntity.setMsg("请先选择信号类型!");
                return resultEntity;
        }

        resultEntity=tallyStandardService.findAllUnit(resultEntity,name);

        return resultEntity;
    }

    @ApiOperation(value="查询点检标准详情", notes="查询点检标准详情" ,httpMethod="GET")
    @RequestMapping("listStandardDetail")
    @ResponseBody
    public ResultEntity listStandardDetail(String qrId) {
        ResultEntity resultEntity=new ResultEntity();
        if (StringUtils.isBlank(qrId)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("二维码id为空!");
            return resultEntity;
        }
        String currentUser=currentUserService.getUsername();
        if (StringUtils.isBlank(currentUser)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("请先登录!");
            return resultEntity;
        }

        List<TallyStandardPostVO> tallyStandardPostVOList=new ArrayList<TallyStandardPostVO>();

        List<TallyStandard> tallyStandardList=tallyStandardService.findAllTallyStandardForDetail(qrId);
        if (tallyStandardList==null||tallyStandardList.isEmpty()){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("二维码下没有设备!");
            return resultEntity;
        }
        for (TallyStandard tallyStandard:tallyStandardList){
            TallyStandardPostVO tallyStandardPostVO=new TallyStandardPostVO();
            tallyStandardPostVO.setStandardId(tallyStandard.getStandardId());
            tallyStandardPostVO.setEquipmentBelonging(tallyStandardService.findEquipmentNameByEquipmentId(tallyStandard.getEquipmentId()));//所属设备
            tallyStandardPostVO.setEquipmentId(tallyStandard.getEquipmentId());//设备id
            tallyStandardPostVO.setLocation(tallyStandard.getLocation());//所在部位
            tallyStandardPostVO.setStandardCoding(tallyStandard.getStandardCoding());//标准编码
            tallyStandardPostVO.setCheckContent(tallyStandard.getCheckContent());//点检内容
            tallyStandardPostVO.setStandardType(tallyStandard.getStandardType());//标准类型
            tallyStandardPostVO.setStandardTypeTitle(tallyStandardService.findTitleByName("STANDARD_TYPE",tallyStandard.getStandardType()));
            tallyStandardPostVO.setDataType(tallyStandard.getDataType());//数据类型
            tallyStandardPostVO.setDataTypeTitle(tallyStandardService.findTitleByName("DATA_TYPE",tallyStandard.getDataType()));
            tallyStandardPostVO.setSignalType(tallyStandard.getSignalType());//信号类型
            tallyStandardPostVO.setSignalTypeTitle(tallyStandardService.findTitleByName("SIGNAL_TYPE",tallyStandard.getSignalType()));
            tallyStandardPostVO.setCheckMethod(tallyStandard.getCheckMethod());//点检方法
            tallyStandardPostVO.setStandardJudgment(tallyStandard.getStandardJudgment());//判断标准
            tallyStandardPostVO.setResultOptions(tallyStandard.getResultOptions());//结果选项
            tallyStandardPostVO.setResultOptionNames(tallyStandardService.findResultChooseByResultId(tallyStandard.getResultOptions()));
            tallyStandardPostVO.setMeasurementUnit(tallyStandard.getMeasurementUnit());//计量单位
            tallyStandardPostVO.setMeasurementUnitTitle(tallyStandardService.findTitleByName("MEASUREMENT_UNIT"+tallyStandard.getSignalType(),tallyStandard.getMeasurementUnit()));
            tallyStandardPostVO.setTypicalValue(tallyStandard.getTypicalValue());//典型值
            tallyStandardPostVO.setEquipmentState(tallyStandard.getEquipmentState());//设备状态
            tallyStandardPostVO.setEquipmentStateTile(tallyStandardService.findTitleByName("EQUIPMENT_STATUS2",tallyStandard.getEquipmentState()));
            tallyStandardPostVO.setTwodimensionalcodeLocation(tallyStandardService.findPositonNameByQrId(tallyStandard.getTwodimensionalcodeLocation()));

            //路线配置
            tallyStandardPostVO.setRouteId(tallyStandard.getRouteId());
            tallyStandardPostVO.setRouteName(tallyStandardService.findRouteNameByRouteId(tallyStandard.getRouteId()));//所属路线
            tallyStandardPostVO.setWindName(tallyStandardService.findWindNameByRouteId(tallyStandard.getRouteId()));//所属风场
            tallyStandardPostVO.setCycleName(tallyStandardService.findCycleNameByRouteId(tallyStandard.getRouteId()));//执行周期
            tallyStandardPostVO.setMaincontrolPoint(tallyStandard.getMaincontrolPoint());//主控点
            tallyStandardPostVO.setStartandstopPoint(tallyStandard.getStartandstopPoint());//启停点
            //报警类型
            tallyStandardPostVO.setAlarmType(tallyStandard.getAlarmType());
            tallyStandardPostVO.setAlarmTypeTitle(tallyStandardService.findTitleByName("ALARM_TYPE",tallyStandard.getAlarmType()));
            tallyStandardPostVO.setAlarmCeiling(tallyStandard.getAlarmCeiling());//报警上限
            tallyStandardPostVO.setAlarmLowerlimit(tallyStandard.getAlarmLowerlimit());//报警下限

            tallyStandardPostVOList.add(tallyStandardPostVO);
        }


        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("点检标准查询成功");
        resultEntity.setData(tallyStandardPostVOList);
        return resultEntity;
    }


    @ApiOperation(value="获取二维码相关信息", notes="查询路线下的二维码们" ,httpMethod="GET")
    @RequestMapping("GetQrCode")
    @ResponseBody
    public ResultEntity GetQrCode(String routeId) {
        ResultEntity resultEntity=new ResultEntity();
        if (StringUtils.isBlank(routeId)){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("路线id传递失败!");
            return resultEntity;
        }
        resultEntity=tallyStandardService.findQrCodeByRouteId(resultEntity,routeId);
        return resultEntity;
    }

}
