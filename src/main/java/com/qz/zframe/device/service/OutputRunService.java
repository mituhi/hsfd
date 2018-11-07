package com.qz.zframe.device.service;

import java.util.List;

import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.OutputParametersExample;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.entity.RunParametersExample;

public interface OutputRunService {
	
	
	//查询出场技术参数信息
	public PageResultEntity findOutout(OutputParametersExample output);
	//查询运行技术参数信息
	public PageResultEntity findRun(RunParametersExample run);
	//删除运行技术参数信息
	public ResultEntity deleteRun(List<String> runIds);
	//删除出场技术参数信息
	public ResultEntity deleteOutput(List<String> outputIds);
	//添加出场技术参数信息
	public ResultEntity  addOutput(OutputParameters output);
	//添加运行技术参数信息
	public ResultEntity  addRun(RunParameters run);
	//修改出场技术参数信息
	public ResultEntity  updateOutput(OutputParameters output);
	//修改运行技术参数信息
    public ResultEntity  updateRun(RunParameters run);
}
