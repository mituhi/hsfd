package com.qz.zframe.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.DataDictType;

@Mapper
public interface DataDictDao {

	/**
	 * 获取所有编码信息
	 * @param codeType
	 * @return
	 */
	List<DataDict> findAllCode();

	/**
	 * 根据编码类型获取编码信息
	 * @param codeType 
	 * @return
	 */
	List<DataDict> findCodeByCodeType(String codeType);
	
	/**
	 * 根据分类编码获取编码类型信息
	 * @param name
	 * @return
	 */
	DataDictType findCodeTypeByType(String name);

	/**
	 * 获取编码分类最大id
	 * @return
	 */
	String findMaxCodeTypeId();

	/**
	 * 新增编码分类
	 * @param dataDictType
	 * @return
	 */
	void addCodeType(DataDictType dataDictType);

	/**
	 * 删除编码类型
	 * @param ids
	 * @return
	 */
	int deleteCodeType(List<String> ids);

	/**
	 * 删除编码
	 * @param ids
	 * @return
	 */
	int deleteCode(List<String> ids);

	/**
	 * 查询所有编码分类
	 * @return
	 */
	List<DataDictType> findAllCodeType();

	/**
	 * 根据类型查询编码分类
	 * @param codeType
	 * @return
	 */
	List<DataDictType> findCodeTypeByCodeType(String codeType);

	/**
	 * 根据上级编码id和编码编号查询编码
	 * @param codeTypeId
	 * @param name
	 * @return
	 */
	DataDict findCodeByCodeTypeIdAndName(String codeTypeId, String name);

	/**
	 * 获取编码最大id
	 * @return
	 */
	Map<String, Object> findMaxCodeIdAndSort(String codeTypeId);

	/**
	 * 新增编码
	 * @param dataDict
	 * @return
	 */
	void addCode(DataDict dataDict);

	/**
	 * 根据id查询编码
	 * @param id
	 * @return
	 */
	DataDict queryCodeById(String id);

	/**
	 * 修改编码
	 * @param dataDict
	 */
	void updateCode(DataDict dataDict);

	/**
	 * 修改编码分类
	 * @param dataDictType
	 */
	void updateCodeType(DataDictType dataDictType);

	/**
	 * 根据id查询编码分类
	 * @param id
	 * @return
	 */
	DataDictType queryCodeTypeById(String id);

}
