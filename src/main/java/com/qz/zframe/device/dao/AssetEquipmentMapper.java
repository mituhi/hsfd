package com.qz.zframe.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.device.entity.AssetEquipment;
import com.qz.zframe.material.entity.Material;

@Mapper
public interface AssetEquipmentMapper {
  
	void insertList (AssetEquipment assetEquipment);
	
	void update(AssetEquipment assetEquipment);
	
	void delete(List<String> equipmentAssetIds);
	
	List<AssetEquipment> selectById(String equipmentAssetId);
	
	AssetEquipment selectByFileId(String fileId);
	
	void deleteByPrimaryKeyList(List<String> assetIds);
	
	void deleteByFileId(List<String> fileIds);
}
