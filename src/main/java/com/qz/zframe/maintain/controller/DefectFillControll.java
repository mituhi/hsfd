package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.service.DefectFillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/maintain/defectFill")
@Api(tags = { "api-maintain-defectFill" }, description = "维护--缺陷填报")
public class DefectFillControll {

    @Autowired
    private DefectFillService defectFillService;

    @ApiOperation(value = "添加缺陷信息", notes = "添加缺陷信息")
    @RequestMapping(value = "saveBreakdown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity saveBreakdown(@RequestBody BreakdownInfo breakdownInfo) {
        return defectFillService.saveBreakdown(breakdownInfo);
    }

    @ApiOperation(value = "提交缺陷信息", notes = "提交缺陷信息")
    @RequestMapping(value = "submitBreakdown", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitBreakdown(@RequestBody BreakdownInfo breakdownInfo) {
        return defectFillService.submitBreakdown(breakdownInfo);
    }
}
