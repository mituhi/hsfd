package com.qz.zframe.tally.controller;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.TallyResult;
import com.qz.zframe.tally.service.TallyResultService;
import com.qz.zframe.tally.vo.TallyResultUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("api/support/tallyResult")
@Api(tags = {"api-support-tallyResult"},description = "巡检-结果选项配置")
public class ResultController {

    @Autowired
    TallyResultService tallyResultService;

    @Autowired
    CurrentUserService currentUserService;

    @ApiOperation(value="结果选项配置查询", notes="初始界面有简单的查询功能,初始界面分页显示数据，控制单页数据量确保速度" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public PageResultEntity listResult(String resultCode,
                                       String resultName,
                                       @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        return tallyResultService.findResultForPage(resultCode, resultName, pageNum, pageSize);

    }

    @ApiOperation(value="结果选项配置添加", notes="新增一个选项，跳转至结果选项创建界面" ,httpMethod="POST")
    @RequestMapping("add")
    @ResponseBody
    public ResultEntity addResult(@RequestBody TallyResult tallyResult) {
        return tallyResultService.addResult(tallyResult);

    }

    @ApiOperation(value="获取流水号，当前日期，申请人", notes="获取巡检路线添加基础信息接口" ,httpMethod="GET")
    @RequestMapping("user")
    @ResponseBody
    public ResultEntity tallyUser() {
        ResultEntity resultEntity=new ResultEntity();
        //查流水号,tallyResult查最大id
        String serialNum=tallyResultService.findserialNum();
        //查申请日期
        Date currentDate=new Date();
        //查当前用户
        String userName=currentUserService.getUsername();

        TallyResultUserVO tallyRouterUserVO=new TallyResultUserVO();
        tallyRouterUserVO.setSerialNum(serialNum);
        tallyRouterUserVO.setCurrentDate(currentDate);
        tallyRouterUserVO.setUserName(userName);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("获取成功!");
        resultEntity.setData(tallyRouterUserVO);
        return resultEntity;
    }


    @ApiOperation(value="结果选项配置修改", notes="修改选中的结果选项分组，界面同创建界面（含数据）" ,httpMethod="PUT")
    @RequestMapping("update")
    @ResponseBody
    public ResultEntity updateResult(@RequestBody TallyResult tallyResult) {
        return tallyResultService.updateResult(tallyResult);

    }

    @ApiOperation(value="结果选项配置删除", notes="删除：删除选中的行记录" ,httpMethod="DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resultIds", value = "结果ID", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity deleteResult(String[] resultIds) {
        return tallyResultService.deleteTallyResult(resultIds);
    }

    @ApiOperation(value="浏览", notes="浏览：显示结果选项配置选中的数据，界面同创建界面（灰色，仅显示不能更改）" ,httpMethod="GET")
    @RequestMapping("browse")
    @ResponseBody
    public TallyResult browse(String resultId) throws Exception {
        return tallyResultService.findResultMsgById(resultId);
    }


}
