package com.qz.zframe.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	 * @param lastIndex 
	 * @param firstIndex 
	 * @return
	 */
	List<DataDict> findCodeByCodeType(@Param("codeType") String codeType, 
			@Param("firstIndex") int firstIndex, @Param("lastIndex") int lastIndex);
	
	/**
	 * 根据分类编码获取编码类型信息
	 * @param name
	 * @return
	 */
	DataDictType findCodeTypeByType(@Param("name") String name);

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
	List<DataDictType> findCodeTypeByCodeType(@Param("codeType") String codeType, int firstIndex, int lastIndex);

	/**
	 * 根据上级编码id和编码编号查询编码
	 * @param codeTypeId
	 * @param name
	 * @return
	 */
	DataDict findCodeByCodeTypeIdAndName(@Param("codeTypeId") String codeTypeId, @Param("name") String name);

	/**
	 * 获取编码最大id
	 * @return
	 */
	Map<String, Object> findMaxCodeIdAndSort(@Param("codeTypeId") String codeTypeId);

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
	DataDict queryCodeById(@Param("id") String id);

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
	DataDictType queryCodeTypeById(@Param("id") String id);

	/**
	 * 根据分类编码查询编码分类数量
	 * @param codeType
	 * @return
	 */
	Integer findCodeTypeByCodeTypeNum(@Param("codeType") String codeType);

	/**
	 * 根据分类编码查询编码数量
	 * @param codeType
	 * @return
	 */
	Integer findCodeByCodeTypeNum(@Param("codeType") String codeType);

	/**
	 * 根据标准代码类型查询标准代码
	 * @param codeTypes
	 * @return
	 */
	List<DataDict> findDataDictsByCodeType(List<String> codeTypes);

	/**
	 * 根据类型查询编码列表
	 * @param codeType
	 * @return
	 */
	List<DataDict> queryCodeList(@Param("codeType") String codeType);

	/**
	 * 根据分类编码和资源id查询编码
	 * @param codeType 分类编码
	 * @param name 资源id
	 * @return
	 */
	DataDict findDataDictByCodeAndType(@Param("codeType") String codeType, @Param("name") String name);

}
