package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;

public interface ParametersService {
	//查询技术参数信息
	 public	PageResultEntity findParameters(ParametersExample parametersExample);
   //新增技术参数信息
	 public ResultEntity  addParameters(Parameters parameters);
	//修改技术参数信息
	 public ResultEntity  updateParameters(Parameters parameters);
	 //查询技术参数信息详情
	 public  PageResultEntity  findByParameterId(String parameterId);
	 //批量删除技术参数信息
	 public   ResultEntity  deleteParameters(List<String> parameterIds);
}
