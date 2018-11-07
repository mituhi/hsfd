package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;

public interface CrewInformationService {
	    //查询机组信息
		 public	PageResultEntity findCrew(CrewInformationExample crewExample);
	   //新增机组信息
		 public ResultEntity  addCrew(CrewInformation crew);
		//修改机组信息
		 public ResultEntity  updateCrew(CrewInformation crew);
		 //查询机组信息详情
		 public  PageResultEntity  findByCrewId(String crewId);
		 //批量删除机组信息
		 public   ResultEntity  deleteCrew(List<String> crewIds);
}
