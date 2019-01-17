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
import com.qz.zframe.device.dao.EquipmentClassificationMapper;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.dao.ParametersMapper;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentClassificationExample;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.service.EquipmentClassificationService;
@Service
@Transactional(rollbackFor = Exception.class)
public class EquipmentClassificationServiceImpl implements EquipmentClassificationService {
	@Autowired
	private EquipmentClassificationMapper equipmentMapper;
	@Autowired
	private EquipmentLogMapper equipmentLogMapper;
	@Autowired
	private CurrentUserService currentUserService;
/*	@Autowired
	private OutputParametersMapper outputParametersMapper;
	@Autowired
	private RunParametersMapper runParametersMapper;*/
	@Autowired
	private ParametersMapper parametersMapper;
	@Override
	public PageResultEntity findEquipment(EquipmentClassificationExample equipment) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = equipmentMapper.countByExample(equipment);
		resultEntity.setTotal(count);
		List<EquipmentClassification> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = equipmentMapper.selectByExample(equipment);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addEquipment(EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		if (equipmentClassification != null) {
			String equipmentId = UUIdUtil.getUUID();
			equipmentClassification.setEquipmentId(equipmentId);
			equipmentClassification.setCreateTime(new Date());
			/*if(StringUtils.isBlank(equipmentClassification.getRunId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("运行技术参数为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(equipmentClassification.getOutputId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("出场技术参数为空");
				return resultEntity;
			}*/
			/*boolean check=RegexUtils.checkChinese(equipmentClassification.getTypeName());
			boolean  checks=RegexUtils.check(equipmentClassification.getTypeName());
			if(check==true) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("设备分类编码不能为汉字");
			return resultEntity;
			}
			if(checks==false) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
			return resultEntity;
			}*/
		/*	EquipmentClassification  e=equipmentMapper.selectByTypeName(equipmentClassification.getTypeName());
				if(e!=null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("设备分类编码已经存在,请重新填写");
					return resultEntity;
				}*/
			
			if ("02".equals(equipmentClassification.getIsToplevel())) {
				if(StringUtils.isBlank(equipmentClassification.getSuperiorEquipment())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("上级设备分类不能为空");
					return resultEntity;
				}
				EquipmentClassification equip = equipmentMapper
						.selectByPrimaryKey(equipmentClassification.getSuperiorEquipment());
				equipmentClassification.setSuperiorEquipmentName(equip.getEquipmentType());
			}
			
			int save = equipmentMapper.insertSelective(equipmentClassification);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("新增设备分类数据失败");
				return resultEntity;
			} else {
				
				EquipmentLog log = new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("新增设备分类");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(equipmentId);
				equipmentLogMapper.insertAdd(log);
				
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("新增成功");
			}
			/*
			 * if(saves==0) { resultEntity.setCode(ErrorCode.ERROR);
			 * resultEntity.setMsg("维护日志数据添加失败"); }else {
			 * resultEntity.setCode(ErrorCode.SUCCESS); resultEntity.setMsg("维护日志数据添加成功"); }
			 */
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有新增数据");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateEquipment(EquipmentClassification equipmentClassification) {
		ResultEntity resultEntity = new ResultEntity();
		if (equipmentClassification != null) {
			if (StringUtils.isBlank(equipmentClassification.getEquipmentId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("设备分类id为空");
				return resultEntity;
			} else {
				EquipmentClassification equipment = equipmentMapper
						.selectByPrimaryKey(equipmentClassification.getEquipmentId());
				if (equipment == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中没有这条数据");
					return resultEntity;
				} else {
					/*boolean check=RegexUtils.checkChinese(equipmentClassification.getTypeName());
					if(check==true) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("设备分类编码不能为汉字");
						return resultEntity;
					}
					boolean  checks=RegexUtils.check(equipmentClassification.getTypeName());
					if(checks==false) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
						return resultEntity;
					}
					EquipmentClassification  p=equipmentMapper.selectByTypeName(equipmentClassification.getTypeName());
					if(p!=null) {
						if(!equipmentClassification.getEquipmentId().equals(p.getEquipmentId())) {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("设备分类编码已经存在,请重新填写");
							return resultEntity;
						
						}
					}*/
					/*equipmentClassification.setSuperiorEquipment(equipment.getSuperiorEquipment());
					equipmentClassification.setSuperiorEquipmentName(equipment.getSuperiorEquipmentName());*/
					if ("02".equals(equipmentClassification.getIsToplevel())) {
						if (StringUtils.isNotBlank(equipmentClassification.getSuperiorEquipment())) {
							EquipmentClassification equip = equipmentMapper
									.selectByPrimaryKey(equipmentClassification.getSuperiorEquipment());
							if (equip != null && StringUtils.isNotBlank(equip.getEquipmentType())) {
								equipmentClassification.setSuperiorEquipmentName(equip.getEquipmentType());
							}

						} else {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("上级设备分类未选择");
							return resultEntity;
						}
					} else {
						equipmentClassification.setSuperiorEquipment(null);
						equipmentClassification.setSuperiorEquipmentName(null);
					}
					equipmentClassification.setCreateTime(equipment.getCreateTime());
					int save = equipmentMapper.updateByPrimaryKey(equipmentClassification);
					if (save == 0) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("修改失败");
					} else {
						
						EquipmentLog log = new EquipmentLog();
						log.setDate(new Date());
						log.setUserId(currentUserService.getId());
						log.setUserName(currentUserService.getUsername());
						log.setFuncation("修改设备分类");
						log.setLogId(UUIdUtil.getUUID());
						log.setModuleId(equipmentClassification.getEquipmentId());
						equipmentLogMapper.insertAdd(log);
						
						resultEntity.setCode(ErrorCode.SUCCESS);
						resultEntity.setMsg("修改成功");
					}
					
					/*
					 * if(saves==0) { resultEntity.setCode(ErrorCode.ERROR);
					 * resultEntity.setMsg("维护日志数据添加失败"); }else {
					 * resultEntity.setCode(ErrorCode.SUCCESS); resultEntity.setMsg("维护日志数据添加成功"); }
					 */
				}
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要修改");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteEquipment(String equipmentId) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = equipmentMapper.deleteByPrimaryKey(equipmentId);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByEquipmentId(String equipmentId) {
		PageResultEntity resultEntity = new PageResultEntity();
		// ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isNotBlank(equipmentId)) {
		List<EquipmentClassification> list = new ArrayList<EquipmentClassification>();
		EquipmentClassification equipmentClassification = equipmentMapper.selectByPrimaryKey(equipmentId);
		if (equipmentClassification == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
			return resultEntity;
		} else {
		    Parameters output = parametersMapper.selectByPrimaryKey(equipmentClassification.getOutputId());
			Parameters run = parametersMapper.selectByPrimaryKey(equipmentClassification.getRunId());
			if (output == null) {
				equipmentClassification.setRunParameters(null);
			} else {
				equipmentClassification.setRunParameters(output);
			}
			if (run == null) {
				equipmentClassification.setOutputParameters(null);
			} else {
				equipmentClassification.setOutputParameters(run);
			}
			list.add(equipmentClassification);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据ID查询数据,Id为空");
			return resultEntity;
		}
		return resultEntity;
	}

	public ResultEntity deleteEquipments(List<String> equipmentIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(equipmentIds!=null && !equipmentIds.isEmpty()) {
		int delete = equipmentMapper.deleteByPrimaryKeyList(equipmentIds);
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
			resultEntity.setMsg("未选中数据进行删除");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructure() {
		PageResultEntity resultEntity = new PageResultEntity();

		List<EquipmentClassification> top = equipmentMapper.selectStructures();
		if (top == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("还未创建顶层设备分类");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(top);
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructureList(String equipmentId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<EquipmentClassification> list = equipmentMapper.selectStructureList(equipmentId);
		if (list != null) {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("还未创建设备分类");
		}
		return resultEntity;
	}

}
