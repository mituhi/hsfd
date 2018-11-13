package com.qz.zframe.common.service;

import java.util.List;

import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.DataDictType;
import com.qz.zframe.common.util.PageResultEntity;

public interface DataDictService {

	/**
	 * 根据标准代码类型查询标准代码
	 * @param codeType
	 * @param size 
	 * @param page 
	 * @return
	 */
	PageResultEntity queryCode(String codeType, Integer page, Integer size);

	/**
	 * 新增及修改标准代码分类
	 * @param dataDictType
	 * @return
	 * @throws Exception 
	 */
	DataDictType addAndUpdateCodeType(DataDictType dataDictType) throws Exception;

	/**
	 * 删除标准代码分类及其子类
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteCodeType(List<String> ids) throws Exception;
	
	/**
	 * 删除标准代码
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	Integer deleteCode(List<String> ids) throws Exception;

	/**
	 * 根据类型查询标准代码分类
	 * @param codeType
	 * @param size 
	 * @param page 
	 * @return
	 */
	PageResultEntity queryCodeType(String codeType, Integer page, Integer size);

	/**
	 * 新增及修改标准代码
	 * @param dataDict
	 * @return
	 * @throws Exception 
	 */
	DataDict addAndUpdateCode(DataDict dataDict) throws Exception;

	/**
	 * 根据id查询编码
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	DataDict queryCodeById(String id) throws Exception;

	/**
	 * 根据id查询编码分类
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	DataDictType queryCodeTypeById(String id) throws Exception;

}
