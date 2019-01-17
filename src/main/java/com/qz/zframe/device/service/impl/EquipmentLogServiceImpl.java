package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.service.EquipmentLogService;
@Service
public class EquipmentLogServiceImpl implements EquipmentLogService {
	@Autowired
	private EquipmentLogMapper equipmentLogMapper;
	@Override
	public PageResultEntity findEquipmentLog(Integer pageNum, Integer pageSize) {
		PageResultEntity  resultEntity=new PageResultEntity();
		List<EquipmentLog> list=equipmentLogMapper.selectList(pageNum, pageSize);
		if(list.size()<=0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询无数据");
		}else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("查询成功·");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addEquipmentLog(EquipmentLog equipmentLog) {
		ResultEntity  resultEntity=new ResultEntity();
		if(equipmentLog!=null) {
			equipmentLogMapper.insertAdd(equipmentLog);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateEquipmentLog(EquipmentLog equipmentLog) {
		ResultEntity resultEntity=new ResultEntity();
		EquipmentLog  equip=equipmentLogMapper.select(equipmentLog.getLogId());
		if (equip==null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save=equipmentLogMapper.update(equipmentLog);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return null;
	}

	public ResultEntity deleteEquipmentLog(List<String> logIds) {
		ResultEntity resultEntity=new ResultEntity();
		int delete = equipmentLogMapper.delete(logIds);
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
	public PageResultEntity findById(String logId) {
	PageResultEntity  resultEntity=new PageResultEntity();
	List<EquipmentLog> list=new ArrayList<EquipmentLog>();
	EquipmentLog  equip=equipmentLogMapper.select(logId);
	if (equip == null) {
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询结果有误");
	} else {
		list.add(equip);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
	}
	return resultEntity;
	}

}
