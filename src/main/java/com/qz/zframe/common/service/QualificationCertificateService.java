package com.qz.zframe.common.service;

import com.qz.zframe.common.entity.QualificationCertificate;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;

import java.util.List;

public interface QualificationCertificateService {

    /**
     * 分页查询资质证书信息
     * @param certificateCode
     * @param certificateName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResultEntity queryQualificationPage(String certificateCode, String certificateName, Integer pageNum, Integer pageSize);

    /**
     * 根据id资质证书信息
     * @param certificateId
     * @return
     */
    QualificationCertificate queryCertificateById(String certificateId) throws Exception;

    /**
     * 新增资质证书信息
     * @param qualificationCertificate
     * @return
     */
    ResultEntity addCertificate(QualificationCertificate qualificationCertificate) throws Exception;

    /**
     * 修改资质证书
     * @param qualificationCertificate
     * @return
     */
    ResultEntity updateCertificate(QualificationCertificate qualificationCertificate) throws Exception;

    /**
     * 删除资质证书
     * @param certificateIds
     * @return
     */
    ResultEntity deleteCertificate(List<String> certificateIds);
}
