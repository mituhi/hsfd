package com.qz.zframe.device.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;

public interface CrewInformationService {
	    
	/**
	 * //查询机组信息
	 * 
	 * @param crewExample
	 * @return
	 */
	public PageResultEntity findCrew(CrewInformationExample crewExample);

	/**
	 * //新增机组信息
	 * 
	 * @param crew
	 * @return
	 */
	public ResultEntity addCrew(CrewInformation crew);

	/**
	 * //修改机组信息
	 * 
	 * @param crew
	 * @return
	 */
	public ResultEntity updateCrew(CrewInformation crew);

	/**
	 * //查询机组信息详情
	 * 
	 * @param crewId
	 * @return
	 */

	public PageResultEntity findByCrewId(String crewId);

	/**
	 * //批量删除机组信息
	 * 
	 * @param crewIds
	 * @return
	 */

	public ResultEntity deleteCrew(List<String> crewIds);

	// 导出数据
	public String ExportExcl(CrewInformationExample crewExample, HttpServletResponse response, String sheetName)
			throws Exception;
}
