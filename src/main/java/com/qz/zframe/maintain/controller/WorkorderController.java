package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.maintain.service.WorkorderService;
import com.qz.zframe.maintain.vo.CancelFileVo;
import com.qz.zframe.maintain.vo.FileInfo;
import com.qz.zframe.maintain.vo.WorkorderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/workorder")
@Api(tags = { "api-maintain-workorder" }, description = "维护--工单管理")
public class WorkorderController {

    private static Logger logger = LoggerFactory.getLogger(WorkorderController.class);

    @Autowired
    private WorkorderService workorderService;

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "工单--添加(工单策划)", notes = "工单--添加(工单策划)")
    @RequestMapping(value = "addWorkorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addWorkorder(@RequestBody WorkorderVo workorderVo) {
        logger.info("===== 工单--添加(工单策划) =====");
        return workorderService.addWorkorder(workorderVo);
    }

    @ApiOperation(value = "工单--修改", notes = "工单--修改")
    @RequestMapping(value = "updateWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateWorkorder(@RequestBody WorkorderVo workorderVo) {
        logger.info("===== 工单--修改 =====");
        return workorderService.updateWorkorder(workorderVo);
    }

    @ApiOperation(value = "工单--提交", notes = "工单--提交")
    @RequestMapping(value = "submitWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitWorkorder(@RequestBody WorkorderVo workorderVo) {
        logger.info("===== 工单--提交 =====");
        ResultEntity resultEntity = new ResultEntity();
        try {
            resultEntity = workorderService.submitWorkorder(workorderVo);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "工单--删除", notes = "工单--删除")
    @RequestMapping(value = "deleteWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorder(String[] orderIds) {
        logger.info("===== 工单--删除 =====");
        return workorderService.deleteWorkorder(orderIds);
    }

    @ApiOperation(value = "工单--详情查询", notes = "工单--详情查询")
    @RequestMapping(value = "getWorkorderDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderDetail(@RequestParam(required = false)
                                           @ApiParam(name="orderId",value="工单id",required=true) String orderId) {
        logger.info("===== 工单--详情查询 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = workorderService.getWorkorderDetail(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    //分页+条件
    @ApiOperation(value = "工单--列表查询", notes = "工单--列表查询")
    @RequestMapping(value = "getWorkorderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getWorkorderList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                 @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                 @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                 @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                 @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                 @RequestParam(required = false)@ApiParam(name="workorderTypeId",value="工单类型id",required=false)String workorderTypeId,
                                 @RequestParam(required = false)@ApiParam(name="status",value="状态 01:处理中 02:完成 03:未提交",required=false)String status,
                                 @RequestParam(required = false)@ApiParam(name="approveUser",value="审批人",required=false)String approveUser,
                                 @RequestParam(required = false)@ApiParam(name="workorderDesc",value="工单描述",required=false)String workorderDesc) {
        logger.info("===== 工单--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("workorderTypeId",workorderTypeId);
        pageAndCondition.put("status",status);
        pageAndCondition.put("approveUser",approveUser);
        pageAndCondition.put("workorderDesc",workorderDesc);

        try {
            pageResultEntity = workorderService.getWorkorderList(pageAndCondition);
        } catch (Exception e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    @ApiOperation(value = "工单--同意", notes = "工单--同意")
    @RequestMapping(value = "agreeWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity agreeWorkorder(@RequestBody WorkorderVo workorderVo) {
        logger.info("===== 工单--同意 =====");
        return workorderService.agreeWorkorder(workorderVo);
    }

    @ApiOperation(value = "工单--退回", notes = "工单--退回")
    @RequestMapping(value = "backWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity backWorkorder(@RequestBody WorkorderVo workorderVo) {
        logger.info("===== 工单--退回 =====");
        return workorderService.backWorkorder(workorderVo);
    }

    @ApiOperation(value = "流程状态--列表查询", notes = "流程状态--列表查询")
    @RequestMapping(value = "getFlowStatusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getFlowStatusList(@RequestParam(required = false)
                                          @ApiParam(name="orderId",value="工单id",required=true) String orderId) {
        logger.info("===== 流程状态--列表查询 =====");
        return workorderService.getFlowStatusList(orderId);
    }

    @ApiOperation(value = "工单--上传单个图片或文件", notes = "工单--上传单个图片或文件")
    @RequestMapping(value = "/uploadWorkorderFile", method = RequestMethod.POST)
    public ResultEntity uploadWorkorderFile(MultipartFile file) throws Exception {
        logger.info("===== 工单--上传单个图片或文件 =====");

        ResultEntity resultEntity = new ResultEntity();
        FileInfo fileInfo = new FileInfo();

        SpFileUpload spFileUpload = commonService.fileUpload(file, "01");
        fileInfo.setFileId(spFileUpload.getFileId());
        fileInfo.setFileName(spFileUpload.getOriginalName());
        fileInfo.setName(spFileUpload.getOriginalName());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("上传成功");
        resultEntity.setData(spFileUpload);
        return resultEntity;
    }

    @ApiOperation(value = "工单--下载文件", notes = "工单--下载文件")
    @RequestMapping(value = "downloadWorkorderFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> downloadWorkorderFile(@RequestParam(required = false)
                                                   @ApiParam(name="fileId",value="文件id",required=true)String fileId,
                                                   HttpServletResponse response) throws Exception {
        logger.info("===== 工单--下载文件 =====");
        commonService.download(response, fileId);
        return null;
    }

    @ApiOperation(value = "工单--取消修改文件", notes = "工单--取消修改文件")
    @RequestMapping(value = "cancelChangeFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity cancelChangeFile(@RequestBody CancelFileVo cancelFileVo) {
        logger.info("===== 工单--取消修改文件 =====");
        String orderId = cancelFileVo.getOrderId();
        List<FileInfo> attachmentList = cancelFileVo.getAttachmentList();
        return workorderService.cancelChangeFile(orderId,attachmentList);
    }


    @ApiOperation(value = "工单--批量删除文件", notes = "工单--批量删除文件")
    @RequestMapping(value = "deleteWorkorderFile", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteWorkorderFile(@RequestParam(required = false)
                                                @ApiParam(name="fileIds",value="文件对象list",required=true)List<FileInfo> fileIds) throws Exception {
        logger.info("===== 工单--批量删除文件 =====");
        ResultEntity resultEntity = new ResultEntity();
        if (CollectionUtils.isEmpty(fileIds)) {
            resultEntity.setMsg("文件id不能为空");
            return resultEntity;
        }
        for (FileInfo fileInfo:fileIds) {
            String fileId = fileInfo.getFileId();
            if (StringUtils.isNoneBlank(fileId)) {
                commonService.removeFile(fileId);
            }
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

}
