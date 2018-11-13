package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.run.entity.ImportantMatter;
import com.qz.zframe.run.entity.ImportantMatterExample;

/**
 * <p>Title: ImportantMatterService</p>
 * <p>@Description:重要事项登记表接口声明  </p>
 * @author 陈汇奇
 * @date 2018年11月7日 下午4:57:25
 * @version:V1.0
 */
public interface ImportantMatterService {

	/**
	 * @Description:添加
	 * @param: @param importantMatter   
	 * @return: void
	 */
	void saveImportantMatter(ImportantMatter importantMatter);
	
	
	/**
	 * @Description:删除
	 * @param: @param ImportantMatterId   
	 * @return: void
	 */
	void removeImportantMatterByIds(List<String> ImportantMatterId);
	
	
	
	/**
	 * @Description:批量获取信息
	 * @param: @return   
	 * @return: List<ImportantMatter>
	 */
	List<ImportantMatter> listImportantMatter(ImportantMatterExample example);
	
	
	/**
	 * @Description:根据主键进行修改操作
	 * @param: @param ImportantMatter   
	 * @return: void
	 */
	void editImportantMatterById(ImportantMatter importantMatter);
	
	
	
	
	
}


