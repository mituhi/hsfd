package com.qz.zframe.tally.dao;

import com.qz.zframe.common.util.BaseMapper;
import com.qz.zframe.tally.entity.QrCode;
import com.qz.zframe.tally.entity.QrCodeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TallyQrCodeDao extends BaseMapper<QrCode, QrCodeExample, Long>{
    
	//获取最大二维码Id
	String getMaxQrcode();

	void deleteQrCodeByQrId(List<String> qrIds);

    List<String> findAllPositionCodes();

    String findPositonIdByPositionCode(String positionCode);

	List<QrCode> findPositionIdAndPositionCode();
}