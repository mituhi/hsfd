package com.qz.zframe.common.controller;

import com.qz.zframe.common.service.ApproveRecordService;
import com.qz.zframe.common.util.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/common/approveRecord")
@Api(tags = { "api-common-approveRecord" }, description = "流程审批记录")
public class ApproveRecordController {

    private static Logger logger = LoggerFactory.getLogger(DeployController.class);

    @Autowired
    private ApproveRecordService approveRecordService;

    @ApiOperation(value = "根据关联id查询流程审批记录", notes = "根据关联id查询流程审批记录")
    @RequestMapping(value = "getApproveRecordListByOrderId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getApproveRecordListByOrderId(String orderId) {
        logger.info("===== 根据关联id查询流程审批记录 ===== ");
        return approveRecordService.getApproveRecordListByOrderId(orderId);
    }

}
