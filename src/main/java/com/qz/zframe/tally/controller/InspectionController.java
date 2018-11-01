package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.*;
import com.qz.zframe.tally.service.TallyRouterService;
import com.qz.zframe.tally.vo.TallyPostVO;
import com.qz.zframe.tally.vo.TallyRouterUserVO;
import com.qz.zframe.tally.vo.TallyRouterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        tags = {"api-support-iscTally"},
        description = "巡检"
)
public class InspectionController {

    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    TallyRouterService tallyRouterService;

    /**
     * 点击巡检和页面相关查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value="查询巡检线路（包括条件查询）", notes="可以根据无参，路线编码，路线名称，当前页，每页显示条数查询" ,httpMethod="GET")
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

    @ApiOperation(value="删除巡检线路(包括批量)", notes="根据传入的路线id数组进行删除" ,httpMethod="DELETE")
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


    @ApiOperation(value="添加巡检路线", notes="根据风电场，周期名称，基准日期，路线id,周期单位，周期，人员等信息添加" ,httpMethod="POST")
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

    @ApiOperation(value="校验路线id是否已经存在", notes="前端传递路线id进行校验" ,httpMethod="GET")
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

    @ApiOperation(value="选择人员", notes="点击选择后提供人员信息" ,httpMethod="GET")
    @RequestMapping("choice")
    @ResponseBody
    public ResultEntity choice() {
        ResultEntity resultEntity=new ResultEntity();
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取人员信息成功!");
        resultEntity.setData(tallyRouterService.choicePeople());
        return resultEntity;
    }


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
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取人员信息成功!");
        resultEntity.setData(tallyRouterService.choicePeople());
        return resultEntity;
    }





}
