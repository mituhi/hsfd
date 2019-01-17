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
	PageResultEntity addAndUpdateCodeType(DataDictType dataDictType) throws Exception;

	/**
	 * 删除标准代码分类及其子类
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity deleteCodeType(List<String> ids) throws Exception;
	
	/**
	 * 删除标准代码
	 * @param ids
	 * @return
	 * @throws Exception 
	 */
	PageResultEntity deleteCode(List<String> ids) throws Exception;

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
	PageResultEntity addAndUpdateCode(DataDict dataDict) throws Exception;

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

	/**
	 * 根据标准代码类型查询标准代码
	 * @param codeTypes
	 * @return
	 * @throws Exception 
	 */
	List<DataDict> findDataDictsByCodeType(List<String> codeTypes) throws Exception;

	/**
	 * 根据类型查询编码列表
	 * @param codeType
	 * @return
	 */
	List<DataDict> queryCodeList(String codeType);
	
	/**
	 * 根据分类编码和资源id查询编码
	 * @param codeType 分类编码
	 * @param name 资源id
	 * @return
	 * @throws Exception 
	 */
	DataDict findDataDictByCodeAndType(String codeType, String name) throws Exception;
}
