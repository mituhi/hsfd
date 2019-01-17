package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.RegexUtils;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.dao.ParametersMapper;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;
import com.qz.zframe.device.service.ParametersService;
@Service
@Transactional(rollbackFor = Exception.class)
public class ParametersServiceImpl implements ParametersService {
	@Autowired
	private ParametersMapper parametersMapper;
	@Autowired
	private EquipmentLogMapper equipmentLogMapper;
	@Autowired
	private CurrentUserService currentUserService;

	@Override
	public PageResultEntity findParameters(ParametersExample parametersExample,String type) {
		PageResultEntity resultEntity = new PageResultEntity();
		if(StringUtils.isBlank(type)) {
		int count = parametersMapper.countByExample(parametersExample);
		resultEntity.setTotal(count);
		List<Parameters> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = parametersMapper.selectByExample(parametersExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		}else {
			//01 运行
			if("01".equals(type)) {
				int count = parametersMapper.countByExample3(parametersExample);
				resultEntity.setTotal(count);
				List<Parameters> list;
				if (count == 0) {
					list = Collections.emptyList();
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询结果为空");
					resultEntity.setRows(list);
					return resultEntity;
				} else {
					list = parametersMapper.selectByExample3(parametersExample);
				}
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setRows(list);
			}
			//出场
			if("02".equals(type)) {
				int count = parametersMapper.countByExample2(parametersExample);
				resultEntity.setTotal(count);
				List<Parameters> list;
				if (count == 0) {
					list = Collections.emptyList();
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询结果为空");
					resultEntity.setRows(list);
					return resultEntity;
				} else {
					list = parametersMapper.selectByExample2(parametersExample);
				}
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setRows(list);
			}
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addParameters(Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		if (parameters != null) {
			boolean check=RegexUtils.checkChinese(parameters.getParameterCode());
			if(check==true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("技术参数编码不能为汉字");
				return resultEntity;
			}
			boolean  checks=RegexUtils.check(parameters.getParameterCode());
			if(checks==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}
			Parameters  p=parametersMapper.selectByParameterCode(parameters.getParameterCode());
			if(p!=null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("技术参数编码已经存在,请重新填写");
				return resultEntity;
			}
			String parameterId = UUIdUtil.getUUID();
			parameters.setParameterId(parameterId);
			parameters.setCreateTime(new Date());
			/*
			 * if(parameters.getOutput()!=null) { parameters.setOutputIs("是"); }
			 * if(parameters.getRun()!=null) { parameters.setRunIs("是"); }
			 */
			int save = parametersMapper.insert(parameters);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("新增失败");
				return resultEntity;
			} else {
				
				EquipmentLog log = new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("新增技术参数信息");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(parameterId);
				equipmentLogMapper.insertAdd(log);
				
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("新增成功");
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要新增");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateParameters(Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		if (parameters != null) {
			boolean check=RegexUtils.checkChinese(parameters.getParameterCode());
			if(check==true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("技术参数编码不能为汉字");
				return resultEntity;
			}
			boolean  checks=RegexUtils.check(parameters.getParameterCode());
			if(checks==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}
			Parameters position = parametersMapper.selectByPrimaryKey(parameters.getParameterId());
			if (position == null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据源中没有这条数据");
				return resultEntity;
			} else {
				/*
				 * if(parameters.getOutput()!=null) { parameters.setOutputIs("√"); }
				 * if(parameters.getRun()!=null) { parameters.setRunIs("√"); }
				 */
				Parameters  p=parametersMapper.selectByParameterCode(parameters.getParameterCode());
				if(p!=null) {
					if(!parameters.getParameterId().equals(p.getParameterId())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("技术参数编码已经存在,请重新填写");
					return resultEntity;
				}
				}
				parameters.setCreateTime(position.getCreateTime());
				int save = parametersMapper.updateByPrimaryKey(parameters);
				if (save == 0) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("修改失败");
					return resultEntity;
				} else {
					
					EquipmentLog log = new EquipmentLog();
					log.setDate(new Date());
					log.setUserId(currentUserService.getId());
					log.setUserName(currentUserService.getUsername());
					log.setFuncation("修改技术参数信息");
					log.setLogId(UUIdUtil.getUUID());
					log.setModuleId(parameters.getParameterId());
					equipmentLogMapper.insertAdd(log);
					
					resultEntity.setCode(ErrorCode.SUCCESS);
					resultEntity.setMsg("修改成功");
				}
			}
			} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要修改");
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
			return resultEntity;
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
		if(parameterIds!=null && !parameterIds.isEmpty()) {
		int delete = parametersMapper.deleteByPrimaryKeyList(parameterIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据删除");
			return resultEntity;
		}
		return resultEntity;
	}

}
