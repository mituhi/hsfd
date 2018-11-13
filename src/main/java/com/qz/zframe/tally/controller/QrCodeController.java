package com.qz.zframe.tally.controller;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageBean;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.entity.TallyAlarm;
import com.qz.zframe.tally.service.TallyQrCodeService;
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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/support/tallyQrCode")
@Api(
        tags = {"api-support-tallyQrCode"},
        description = "巡检-二维码配置"
)
@Transactional(rollbackFor = Exception.class)
public class QrCodeController {

    @Autowired
    TallyQrCodeService tallyQrCodeService;

 /*   @ApiOperation(value="二维码配置查询", notes="可以根据线路，位置名称查询" ,httpMethod="GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressName", value = "位置名称", required = false),
            @ApiImplicitParam(name = "routeName", value = "路线", required = false),
    })
    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listQrCode(String addressName,
                                     String routeName,
                                     @RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                     @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        int n=tallyQrCodeService.countQrCode();

        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

        List<QrCode> qrCodeList=tallyQrCodeService.findAllQrCode(addressName, routeName);

        PageBean<QrCode> pageDate=new PageBean<QrCode>(currentPage,pageSize,n);
        pageDate.setItems(qrCodeList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置查询成功");
        resultEntity.setData(pageDate);
        return resultEntity;

    }*/

    @ApiOperation(value="二维码配置查询", notes="可以根据线路，位置名称查询" ,httpMethod="GET")
    @RequestMapping("list")
    @ResponseBody
    public ResultEntity listQrCode(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage,
                                   @RequestParam(value = "pageSize",defaultValue = "10")  int pageSize) {
        int n=tallyQrCodeService.countQrCode();

        ResultEntity resultEntity=new ResultEntity();

        PageHelper.startPage(currentPage,pageSize);

        List<QrCode> qrCodeList=tallyQrCodeService.findAllQrCode();

        PageBean<QrCode> pageDate=new PageBean<QrCode>(currentPage,pageSize,n);
        pageDate.setItems(qrCodeList);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置查询成功");
        resultEntity.setData(pageDate);
        return resultEntity;

    }


    @ApiOperation(value="二维码配置插入", notes="根据编号可在行与行之前插入插入" ,httpMethod="POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code1", value = "编号1", required = false),
            @ApiImplicitParam(name = "code2", value = "编号2", required = false),
    })
    @RequestMapping("insert")
    @ResponseBody
    public ResultEntity insertQrCode(String code1,
                                     String code2,
                                     @RequestBody QrCode qrCode) {
        ResultEntity resultEntity=new ResultEntity();

        int n=tallyQrCodeService.insertByCodes(code1, code2, qrCode);

        if (n==ErrorCode.ERROR){
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("二维码配置插入失败");

            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置插入成功");
        //resultEntity.setData(tallyQrCodeService.countByCodes(code1, code2));
        return resultEntity;

    }

    @ApiOperation(value="二维码配置显示", notes="根据code查询显示修改时数据" ,httpMethod="GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号", required = false),
    })
    @RequestMapping("display")
    @ResponseBody
    public ResultEntity display(String code) {
        ResultEntity resultEntity=new ResultEntity();

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置显示成功");
        resultEntity.setData(tallyQrCodeService.findQrCodeByCode(code));
        return resultEntity;

    }

    @ApiOperation(value="二维码配置修改", notes="根据code修改二维码配置数据" ,httpMethod="PUT")
    @RequestMapping("update")
    @ResponseBody
    public ResultEntity update(@RequestBody QrCode qrCode) {
        ResultEntity resultEntity=new ResultEntity();

        tallyQrCodeService.updateQrCodeByCode(qrCode);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置修改成功");

        return resultEntity;

    }

    @ApiOperation(value="二维码配置删除", notes="根据code修改二维码配置数据" ,httpMethod="DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "编号", required = false),
    })
    @RequestMapping("delete")
    @ResponseBody
    public ResultEntity delete(String code) {
        ResultEntity resultEntity=new ResultEntity();

        tallyQrCodeService.deleteQrCodeByCode(code);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("二维码配置显示修改成功");

        return resultEntity;

    }



}
