package com.qz.zframe.tally.dao;

import com.qz.zframe.tally.entity.QrCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TallyQrCodeDao {

    /**
     * 查询二维码配置
     * @return
     */
    List<QrCode> findAllQrCode();

    /**
     * 查询二维码配置
     * @param addressName
     * @return
     */
    List<QrCode> findAllQrCode2(@Param("addressName")String addressName);

    /**
     * 根据编号插入二维码配置
     * @param qrCode
     */
    void insertByCodes(QrCode qrCode);

    /**
     * 根据编号统计插入字段是否有空缺
     * @param code1
     * @param code2
     * @return
     */
    int countByCodes(@Param("code1") String code1,@Param("code2") String code2);

    /**
     *根据编号查显示信息
     * @param code
     * @return
     */
    QrCode findQrCodeByCode(String code);

    /**
     *根据编号修改信息
     * @param qrCode
     * @return
     */
    void updateQrCodeByCode(QrCode qrCode);

    /**
     * 根据编号删除二维码配置 \
     * @param code
     */
    void deleteQrCodeByCode(String code);

    /**
     * 计算记录总数二维码配置
     * @return
     */
    int countQrCode();

}
