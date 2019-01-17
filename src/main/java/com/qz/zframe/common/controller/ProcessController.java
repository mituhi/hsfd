package com.qz.zframe.common.controller;

import com.qz.zframe.common.service.ProcessService;
import com.qz.zframe.common.util.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/common/process")
@Api(tags = { "api-common-process" }, description = "流程主表,详情及关联角色")
public class ProcessController {

    private static Logger logger = LoggerFactory.getLogger(DeployController.class);

    @Autowired
    private ProcessService processService;

    @ApiOperation(value = "根据id查询是否有审批权限", notes = "根据id查询是否有审批权限")
    @RequestMapping(value = "isPermissions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity isPermissions(@RequestParam(required = false)@ApiParam(name="id",value="各自页面主id",required=false) String id) {
        return processService.isPermissions(id);
    }

}
