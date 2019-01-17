package com.qz.zframe.common.controller;

import com.qz.zframe.common.entity.QualificationCertificate;
import com.qz.zframe.common.service.QualificationCertificateService;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/common/certificate")
@Api(tags = { "api-common-certificate" }, description = "资质证书管理")
public class QualificationCertificateController {
    private static Logger logger = LoggerFactory.getLogger(QualificationCertificateController.class);

    @Autowired
    private QualificationCertificateService qualificationCertificateService;

    @ApiOperation(value = "分页查询资质证书信息", notes = "分页查询资质证书信息")
    @RequestMapping(value = "queryCertificatePage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageResultEntity queryQualificationPage(
            @RequestParam(required = false)
            @ApiParam(name="certificateCode",value="证书编号",required=false) String certificateCode,
            @RequestParam(required = false)
            @ApiParam(name="certificateName",value="证书名称",required=false) String certificateName,
            @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        logger.info("===== 分页查询资质证书信息 QualificationCertificateController.queryQualificationPage ===== " +
                "certificateCode:"+certificateCode +"certificateName:"+certificateName);
        return qualificationCertificateService.queryQualificationPage(certificateCode, certificateName, pageNum, pageSize);
    }

    @ApiOperation(value = "根据id资质证书信息", notes = "根据id资质证书信息")
    @RequestMapping(value = "queryCertificateById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QualificationCertificate> queryCertificateById(
            @RequestParam(required = true)
            @ApiParam(name="certificateId",value="证书id",required=true)String certificateId) throws Exception {
        logger.info("===== 根据id资质证书信息 QualificationCertificateController.queryCertificateById ===== certificateId:"+certificateId);
        return new ResponseEntity<QualificationCertificate>(qualificationCertificateService.queryCertificateById(certificateId), HttpStatus.OK);
    }

    @ApiOperation(value = "新增资质证书", notes = "新增资质证书")
    @RequestMapping(value = "addCertificate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity addCertificate(@RequestBody QualificationCertificate qualificationCertificate) throws Exception {
        logger.info("===== 新增资质证书 QualificationCertificateController.addCertificate ===== qualificationCertificate:"+qualificationCertificate);
        return qualificationCertificateService.addCertificate(qualificationCertificate);
    }

    @ApiOperation(value = "修改资质证书", notes = "修改资质证书")
    @RequestMapping(value = "updateCertificate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity updateCertificate(@RequestBody QualificationCertificate qualificationCertificate) throws Exception {
        logger.info("===== 修改资质证书 QualificationCertificateController.updateCertificate ===== qualificationCertificate:"+qualificationCertificate);
        return qualificationCertificateService.updateCertificate(qualificationCertificate);
    }

    @ApiOperation(value = "删除资质证书", notes = "删除资质证书")
    @RequestMapping(value = "deleteCertificate", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultEntity deleteCertificate(
            @RequestParam(required = true)
            @ApiParam(name="certificateIds",value="证书id",required=true) List<String> certificateIds) {
        logger.info("===== 删除资质证书 QualificationCertificateController.deleteCertificate ===== certificateIds:"+certificateIds);
        return qualificationCertificateService.deleteCertificate(certificateIds);
    }
}
