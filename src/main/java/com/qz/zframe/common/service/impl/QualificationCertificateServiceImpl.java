package com.qz.zframe.common.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.dao.QualificationCertificateDao;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.QualificationCertificate;
import com.qz.zframe.common.service.QualificationCertificateService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class QualificationCertificateServiceImpl implements QualificationCertificateService {

    @Autowired
    private QualificationCertificateDao qualificationCertificateDao;

    @Autowired
    private CurrentUserService currentUserService;

    /**
     * 分页查询资质证书信息
     * @param certificateCode
     * @param certificateName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResultEntity queryQualificationPage(String certificateCode, String certificateName, Integer pageNum, Integer pageSize) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        //从第几条数据开始
        int firstIndex = (pageNum - 1) * pageSize;
        //到第几条数据结束
        int lastIndex = pageNum * pageSize;

        List<OrgArchitecture> list = qualificationCertificateDao.queryQualificationPage(certificateCode, certificateName, firstIndex, lastIndex);
        if (list == null || list.isEmpty()) {
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setRows(null);
            pageResultEntity.setTotal(0);
        }else {
            Integer num = qualificationCertificateDao.queryQualificationNum(certificateCode, certificateName);
            pageResultEntity.setCode(ErrorCode.SUCCESS);
            pageResultEntity.setRows(list);
            pageResultEntity.setTotal(num);
        }
        return pageResultEntity;
    }

    /**
     * 根据id资质证书信息
     * @param certificateId
     * @return
     */
    @Override
    public QualificationCertificate queryCertificateById(String certificateId) throws Exception {
        if (StringUtils.isBlank(certificateId)) {
            throw new Exception("证书id不能为空!");
        }
        return qualificationCertificateDao.queryCertificateById(certificateId);
    }

    /**
     * 新增资质证书信息
     * @param qualificationCertificate
     * @return
     */
    @Override
    public ResultEntity addCertificate(QualificationCertificate qualificationCertificate) throws Exception {
        ResultEntity resultEntity = new ResultEntity();
        if (qualificationCertificate == null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("传入对象不能为空!");
            return resultEntity;
        }
        //判断必填字段
        resultEntity = checkQualificationCertificate(qualificationCertificate);
        if (ErrorCode.ERROR == resultEntity.getCode()) {
            return resultEntity;
        }
        //判断是否已经有配置信息
        boolean result = checkCodeByMsg(qualificationCertificate.getCertificateCode());
        if (result) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("该编号已存在!");
            return resultEntity;
        }

        qualificationCertificate.setCertificateId(UUID.randomUUID().toString().replaceAll("-",""));
        qualificationCertificate.setCreater(currentUserService.getId());
        qualificationCertificate.setCreateTime(new Date());
        qualificationCertificateDao.addQualification(qualificationCertificate);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("保存成功");
        return resultEntity;
    }

    /**
     * 判断必填字段
     * @param qualificationCertificate
     * @return
     */
    private ResultEntity checkQualificationCertificate(QualificationCertificate qualificationCertificate) {
        ResultEntity resultEntity = new ResultEntity();
        if (StringUtils.isBlank(qualificationCertificate.getCertificateCode())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("证书编号不能为空");
            return resultEntity;
        }
        if (StringUtils.isBlank(qualificationCertificate.getCertificateName())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("证书名称不能为空");
            return resultEntity;
        }
        resultEntity.setCode(ErrorCode.SUCCESS);
        return resultEntity;
    }

    /**
     * 修改资质证书信息
     * @param qualificationCertificate
     * @return
     */
    @Override
    public ResultEntity updateCertificate(QualificationCertificate qualificationCertificate) throws Exception {
        ResultEntity resultEntity = new ResultEntity();
        if (qualificationCertificate == null) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("传入对象不能为空!");
            return resultEntity;
        }
        if (StringUtils.isBlank(qualificationCertificate.getCertificateId())) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("证书id不能为空!");
            return resultEntity;
        }

        //判断必填字段
        resultEntity = checkQualificationCertificate(qualificationCertificate);
        if (ErrorCode.ERROR == resultEntity.getCode()) {
            return resultEntity;
        }

        //判断是否已经有配置信息
        boolean result = checkCodeByMsg(qualificationCertificate.getCertificateCode());
        if (result) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("该对象已经配置过!");
            return resultEntity;
        }

        qualificationCertificateDao.updateQualification(qualificationCertificate);

        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("修改成功");
        return resultEntity;
    }

    /**
     * 根据条件判断资质证书信息是否已经配置过
     * 是 true 否 false
     * @param certificateCode
     * @return
     */
    private boolean checkCodeByMsg(String certificateCode) throws Exception {
        if (StringUtils.isBlank(certificateCode)) {
            throw new Exception("证书编号不能为空");
        }
        List<QualificationCertificate> qualificationCertificates = qualificationCertificateDao.findQualificationByMsg(certificateCode);
        if (CollectionUtils.isEmpty(qualificationCertificates)) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * 删除资质证书信息
     * @param certificateIds
     * @return
     */
    @Override
    public ResultEntity deleteCertificate(List<String> certificateIds) {
        ResultEntity resultEntity = new ResultEntity();
        if (CollectionUtils.isEmpty(certificateIds)) {
            resultEntity.setCode(ErrorCode.ERROR);
            resultEntity.setMsg("id不能为空!");
            return resultEntity;
        }
        //TODO 判断是否有业务使用到

        qualificationCertificateDao.deleteQualification(certificateIds);
        resultEntity.setCode(ErrorCode.SUCCESS);
        resultEntity.setMsg("删除成功");
        return resultEntity;
    }
}
