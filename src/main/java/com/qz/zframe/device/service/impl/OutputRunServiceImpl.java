package com.qz.zframe.device.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.OutputParametersMapper;
import com.qz.zframe.device.dao.RunParametersMapper;
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.OutputParametersExample;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.entity.RunParametersExample;
import com.qz.zframe.device.service.OutputRunService;
@Service
@Transactional(rollbackFor = Exception.class)
public class OutputRunServiceImpl implements OutputRunService {
	@Autowired
	private OutputParametersMapper outputParametersMapper;
	@Autowired
	private RunParametersMapper runParametersMapper;

	@Override
	public PageResultEntity findOutout(OutputParametersExample output) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = outputParametersMapper.countByExample(output);
		resultEntity.setTotal(count);
		List<OutputParameters> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = outputParametersMapper.selectByExample(output);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findRun(RunParametersExample run) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = runParametersMapper.countByExample(run);
		resultEntity.setTotal(count);
		List<RunParameters> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = runParametersMapper.selectByExample(run);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity deleteRun(List<String> runIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = runParametersMapper.deleteByPrimaryKeyList(runIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteOutput(List<String> outputIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = outputParametersMapper.deleteByPrimaryKeyList(outputIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addOutput(OutputParameters output) {
		ResultEntity resultEntity = new ResultEntity();
		output.setOutputId(UUIdUtil.getUUID());
		int save = outputParametersMapper.insert(output);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addRun(RunParameters run) {
		ResultEntity resultEntity = new ResultEntity();
		run.setRunId(UUIdUtil.getUUID());
		int save = runParametersMapper.insert(run);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateOutput(OutputParameters output) {
		ResultEntity resultEntity = new ResultEntity();
		OutputParameters out = outputParametersMapper.selectByPrimaryKey(output.getOutputId());
		if (out == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = outputParametersMapper.updateByPrimaryKey(output);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateRun(RunParameters run) {
		ResultEntity resultEntity = new ResultEntity();
		RunParameters runing = runParametersMapper.selectByPrimaryKey(run.getRunId());
		if (runing == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = runParametersMapper.updateByPrimaryKey(run);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

}
