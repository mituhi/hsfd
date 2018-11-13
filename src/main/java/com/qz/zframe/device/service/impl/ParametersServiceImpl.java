package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.ParametersMapper;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;
import com.qz.zframe.device.service.ParametersService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ParametersServiceImpl implements ParametersService {
	@Autowired
	 private ParametersMapper parametersMapper;
	@Override
	public PageResultEntity findParameters(ParametersExample parametersExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = parametersMapper.countByExample(parametersExample);
		resultEntity.setTotal(count);
		List<Parameters> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else { 
			list = parametersMapper.selectByExample(parametersExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addParameters(Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		parameters.setParameterId(UUIdUtil.getUUID());
		int save = parametersMapper.insert(parameters);
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
	public ResultEntity updateParameters(Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		Parameters position = parametersMapper.selectByPrimaryKey(parameters.getParameterId());
		if (position == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = parametersMapper.updateByPrimaryKey(parameters);
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
	public PageResultEntity findByParameterId(String parameterId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<Parameters> list = new ArrayList<Parameters>();
		Parameters paramerers = parametersMapper.selectByPrimaryKey(parameterId);
		if (paramerers == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(paramerers);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteParameters(List<String> parameterIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = parametersMapper.deleteByPrimaryKeyList(parameterIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

}
