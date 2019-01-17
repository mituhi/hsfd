package com.qz.zframe.maintain.controller;

import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.file.FileException;
import com.qz.zframe.maintain.service.DefectWorkorderService;
import com.qz.zframe.maintain.vo.CancelFileVo;
import com.qz.zframe.maintain.vo.DefectWorkorderVo;
import com.qz.zframe.maintain.vo.FileInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/maintain/defectWorkorder")
@Api(tags = { "api-maintain-defectWorkorder" }, description = "维护--缺陷工单")
public class DefectWorkorderController {

    private static Logger logger = LoggerFactory.getLogger(DefectWorkorderController.class);

    @Autowired
    private DefectWorkorderService defectWorkorderService;

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "缺陷工单--添加", notes = "缺陷工单--添加")
    @RequestMapping(value = "addDefectWorkorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        logger.info("===== 缺陷工单--添加 =====");
        return defectWorkorderService.addDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "缺陷工单--修改", notes = "缺陷工单--修改")
    @RequestMapping(value = "updateDefectWorkorder", method = {RequestMethod.POST,RequestMethod.PUT}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        logger.info("===== 缺陷工单--修改 =====");
        return defectWorkorderService.updateDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "缺陷工单--提交", notes = "缺陷工单--提交")
    @RequestMapping(value = "submitDefectWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity submitDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        logger.info("===== 缺陷工单--提交 =====");
        ResultEntity resultEntity = new ResultEntity();
        try {
            resultEntity = defectWorkorderService.submitDefectWorkorder(defectWorkorderVo);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    @ApiOperation(value = "缺陷工单--删除", notes = "缺陷工单--删除")
    @RequestMapping(value = "deleteDefectWorkorder", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteDefectWorkorder(String[] workorderIds) {
        logger.info("===== 缺陷工单--删除 =====");
        return defectWorkorderService.deleteDefectWorkorder(workorderIds);
    }

    @ApiOperation(value = "缺陷工单--详情查询", notes = "缺陷工单--详情查询")
    @RequestMapping(value = "getDefectWorkorderDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getDefectWorkorderDetail(@RequestParam(required = false)
                                                 @ApiParam(name="workorderId",value="缺陷工单id",required=true)String workorderId) {
        logger.info("===== 缺陷工单--详情查询 =====");
        ResultEntity resultEntity = new ResultEntity();

        try {
            resultEntity = defectWorkorderService.getDefectWorkorderDetail(workorderId);
        } catch (Exception e) {
            e.printStackTrace();
            resultEntity.setMsg("系统出错");
        }
        return resultEntity;
    }

    //分页+条件
    @ApiOperation(value = "缺陷工单--列表查询", notes = "缺陷工单--列表查询")
    @RequestMapping(value = "getDefectWorkorderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity getDefectWorkorderList(@RequestParam(defaultValue = "1")@ApiParam(name="pageNum",value="当前页",required=false)String pageNum,
                                                   @RequestParam(defaultValue = "10")@ApiParam(name="pageSize",value="一页记录数",required=false)String pageSize,
                                                   @RequestParam(required = false)@ApiParam(name="startWindId",value="风电场code",required=false)String startWindId,
                                                   @RequestParam(required = false)@ApiParam(name="endWindId",value="风电场code",required=false)String endWindId,
                                                   @RequestParam(required = false)@ApiParam(name="crewId",value="机组id",required=false)String crewId,
                                                   @RequestParam(required = false)@ApiParam(name="dealMode",value="处理方式",required=false)String dealMode,
                                                   @RequestParam(required = false)@ApiParam(name="dutyTeam",value="负责班组",required=false)String dutyTeam,
                                                   @RequestParam(required = false)@ApiParam(name="status",value="状态 01:处理中 02:完成 03未提交 04:审核未通过",required=false)String status,
                                                   @RequestParam(required = false)@ApiParam(name="approveUser",value="审批人",required=false)String approveUser,
                                                   @RequestParam(required = false)@ApiParam(name="workorderDesc",value="工单描述",required=false)String workorderDesc,
                                                   @RequestParam(required = false)@ApiParam(name="startTime",value="填报时间",required=false)String startTime,
                                                   @RequestParam(required = false)@ApiParam(name="endTime",value="填报时间",required=false)String endTime) {
        logger.info("===== 缺陷工单--列表查询 =====");
        PageResultEntity pageResultEntity = new PageResultEntity();

        Map<String,String> pageAndCondition = new HashMap();
        pageAndCondition.put("pageNum",pageNum);
        pageAndCondition.put("pageSize",pageSize);
        pageAndCondition.put("startWindId",startWindId);
        pageAndCondition.put("endWindId",endWindId);
        pageAndCondition.put("crewId",crewId);
        pageAndCondition.put("dealMode",dealMode);
        pageAndCondition.put("dutyTeam",dutyTeam);
        pageAndCondition.put("status",status);
        pageAndCondition.put("approveUser",approveUser);
        pageAndCondition.put("workorderDesc",workorderDesc);
        pageAndCondition.put("startTime",startTime);
        pageAndCondition.put("endTime",endTime);
        try {
            pageResultEntity = defectWorkorderService.getDefectWorkorderList(pageAndCondition);
        } catch (Exception e) {
            e.printStackTrace();
            pageResultEntity.setMsg("系统出错");
        }
        return pageResultEntity;
    }

    @ApiOperation(value = "缺陷工单--同意", notes = "缺陷工单--同意")
    @RequestMapping(value = "agreeDefectWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity agreeDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        logger.info("===== 缺陷工单--同意 =====");
        return defectWorkorderService.agreeDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "缺陷工单--退回", notes = "缺陷工单--退回")
    @RequestMapping(value = "backDefectWorkorder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity backDefectWorkorder(@RequestBody DefectWorkorderVo defectWorkorderVo) {
        logger.info("===== 缺陷工单--退回 =====");
        return defectWorkorderService.backDefectWorkorder(defectWorkorderVo);
    }

    @ApiOperation(value = "流程状态--列表查询", notes = "流程状态--列表查询")
    @RequestMapping(value = "getFlowStatusList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getFlowStatusList(@RequestParam(required = false)@ApiParam(name="workorderId",value="缺陷工单id",required=true) String workorderId) {
        logger.info("===== 流程状态--列表查询 =====");
        return defectWorkorderService.getFlowStatusList(workorderId);
    }

    @ApiOperation(value = "缺陷工单--根据工单号查询物资有关的缺陷工单内容", notes = "缺陷工单--根据工单号查询物资有关的缺陷工单内容")
    @RequestMapping(value = "getDefectWorkorderBySerialNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getDefectWorkorderBySerialNumber(@RequestParam(required = false)
                                                         @ApiParam(name="serialNumber",value="工单号",required=true) String serialNumber) {
        logger.info("===== 缺陷工单--根据工单号查询物资有关的缺陷工单内容 =====");
        return defectWorkorderService.getDefectWorkorderBySerialNumber(serialNumber);
    }

    @ApiOperation(value = "缺陷工单--根据工单号和库存地查询物资列表", notes = "缺陷工单--根据工单号和库存地查询物资列表")
    @RequestMapping(value = "getWorkorderMaterialList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity getWorkorderMaterialList(
                                    @RequestParam(required = false)@ApiParam(name="serialNumber",value="工单号",required=true) String serialNumber,
                                    @RequestParam(required = false)@ApiParam(name="stockAddId",value="库存地id",required=false) String stockAddId) {
        logger.info("===== 缺陷工单--根据工单号和库存地查询物资列表 =====");
        return defectWorkorderService.getWorkorderMaterialList(serialNumber,stockAddId);
    }

    @ApiOperation(value = "缺陷工单--批量上传图片", notes = "缺陷工单--批量上传图片")
    @RequestMapping(value = "/uploadPics", method = RequestMethod.POST)
    public List<String> uploadPics(MultipartFile[] files, HttpServletRequest request) throws Exception {
        logger.info("===== 缺陷工单--批量上传图片 =====");
        List<String> list = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(files)) {
            for (MultipartFile file:files) {
                SpFileUpload map = commonService.fileUpload(file, "01");
                list.add(map.getFileId());
            }
            return list;
        }
        return null;
    }
    @ApiOperation(value = "缺陷工单--上传单个图片", notes = "缺陷工单--上传单个图片")
    @RequestMapping(value = "/uploadDefectPic", method = RequestMethod.POST)
    public ResultEntity uploadDefectPic(MultipartFile file) throws Exception {
        logger.info("===== 缺陷工单--上传单个图片 =====");

        ResultEntity resultEntity = new ResultEntity();
        FileInfo fileInfo = new FileInfo();

        SpFileUpload spFileUpload = commonService.fileUpload(file, "01");
        fileInfo.setFileId(spFileUpload.getFileId());
        fileInfo.setFileName(spFileUpload.getOriginalName());
        fileInfo.setName(spFileUpload.getOriginalName());
        if (spFileUpload!=null) {
            String pic = "data:image/png;base64,";
            BASE64Encoder base64Encoder = new BASE64Encoder();
            byte[] download = commonService.download(spFileUpload.getFileId());
            String encode = base64Encoder.encode(download);
            pic += encode;
            fileInfo.setPicDate(pic);
            fileInfo.setUrl(pic);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("上传成功");
        resultEntity.setData(fileInfo);
        return resultEntity;
    }

    @ApiOperation(value = "缺陷工单--上传单个附件", notes = "缺陷工单--上传单个附件")
    @RequestMapping(value = "/uploadDefectFile", method = RequestMethod.POST)
    public ResultEntity uploadDefectFile(MultipartFile file) throws Exception {
        logger.info("===== 缺陷工单--上传单个附件 =====");

        ResultEntity resultEntity = new ResultEntity();
        FileInfo fileInfo = new FileInfo();

        SpFileUpload spFileUpload = commonService.fileUpload(file, "01");
        fileInfo.setFileId(spFileUpload.getFileId());
        fileInfo.setFileName(spFileUpload.getOriginalName());
        fileInfo.setName(spFileUpload.getOriginalName());

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("上传成功");
        resultEntity.setData(fileInfo);
        return resultEntity;
    }

    @ApiOperation(value = "缺陷工单--下载文件", notes = "缺陷工单--下载文件")
    @RequestMapping(value = "downloadDefectFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> downloadDefectFile(@RequestParam(required = false)
                                                @ApiParam(name="fileId",value="文件id",required=true)String fileId,
                                                HttpServletResponse response) throws Exception {
        logger.info("===== 缺陷工单--下载文件 =====");
        commonService.download(response, fileId);
        return null;
    }

    @ApiOperation(value = "缺陷工单--批量删除文件", notes = "缺陷工单--批量删除文件")
    @RequestMapping(value = "deleteDefectFile", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteDefectFile(@RequestParam(required = true)
                                             @ApiParam(name="fileIds",value="文件s",required=true)List<String> fileIds) throws Exception {
        logger.info("===== 缺陷工单--批量删除文件 =====");
        ResultEntity resultEntity = new ResultEntity();
        if (CollectionUtils.isEmpty(fileIds)) {
            resultEntity.setMsg("文件id不能为空");
            return resultEntity;
        }
        for (String fileId:fileIds) {
            commonService.removeFile(fileId);
        }

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }

    @ApiOperation(value = "缺陷工单--取消修改文件", notes = "缺陷工单--取消修改文件")
    @RequestMapping(value = "cancelChangeDefectFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity cancelChangeDefectFile(@RequestBody CancelFileVo cancelFileVo) {
        logger.info("===== 缺陷工单--取消修改文件 =====");
        return defectWorkorderService.cancelChangeDefectFile(cancelFileVo);
    }
}
