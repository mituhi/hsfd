package com.qz.zframe.common.dao;

import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.entity.QualificationCertificate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QualificationCertificateDao {

    /**
     * 分页查询资质证书信息
     * @param certificateCode
     * @param certificateName
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    List<OrgArchitecture> queryQualificationPage(@Param("certificateCode") String certificateCode, @Param("certificateName") String certificateName,
                                                 @Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);

    /**
     * 分页查询资质证书信息条数
     * @param certificateCode
     * @param certificateName
     * @return
     */
    Integer queryQualificationNum(@Param("certificateCode") String certificateCode, @Param("certificateName") String certificateName);

    /**
     * 根据id资质证书信息
     * @param certificateId
     * @return
     */
    QualificationCertificate queryCertificateById(@Param("certificateId") String certificateId);

    /**
     * 根据条件查询资质证书信息
     * @param certificateCode
     * @return
     */
    List<QualificationCertificate> findQualificationByMsg(@Param("certificateCode") String certificateCode);

    /**
     * 新增资质证书信息
     * @param qualificationCertificate
     * @return
     */
    int addQualification(QualificationCertificate qualificationCertificate);

    /**
     * 修改资质证书信息
     * @param qualificationCertificate
     * @return
     */
    int updateQualification(QualificationCertificate qualificationCertificate);

    /**
     * 删除资质证书信息
     * @param certificateIds
     * @return
     */
    int deleteQualification(List<String> certificateIds);
}
