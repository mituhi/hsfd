package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.MaterialMapper;
import com.qz.zframe.material.dao.MaterialUnitMapper;
import com.qz.zframe.material.entity.Material;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.entity.MaterialUnit;
import com.qz.zframe.material.entity.MaterialUnitExample;
import com.qz.zframe.material.service.MaterialUnitService;


@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialUnitServiceImpl implements MaterialUnitService{
	
	@Autowired
	private MaterialUnitMapper materialUnitMapper;
	
	@Autowired
	private MaterialMapper materialMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getMaterialUnitList(MaterialUnitExample example) {
		NewPageResult newPageResult = new NewPageResult<>();
		int count = materialUnitMapper.countByExample(example);
		newPageResult.setTotal(count);
		List<MaterialUnit> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialUnitMapper.selectByExample(example);
		}
		newPageResult.setCode(ErrorCode.SUCCESS);
		newPageResult.setRows(list);
		return newPageResult;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getMaterialUnitDetail(String measuringUnitId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail<>();
		MaterialUnit materialUnit = materialUnitMapper.selectByPrimaryKey(measuringUnitId);
		if(materialUnit==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位信息不存在");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setData(materialUnit);
		return resultEntity;
	}

	@Override
	public ResultEntity addMaterialUnit(MaterialUnit materialUnit) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(materialUnit.getMeasuringUnitCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位编码不可为空");
			return resultEntity;
		} else {
			if (checkUnitCodeIsExit(materialUnit)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资单位编码已存在");
				return resultEntity;
			}
		}

		if (StringUtils.isBlank(materialUnit.getMeasuringUnitName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位名称不可为空");
			return resultEntity;
		} else {
			if (checkUnitNameIsExit(materialUnit)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资单位名称已存在");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(materialUnit.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位状态不可为空");
			return resultEntity;
		}
		materialUnit.setMeasuringUnitId(UUIdUtil.getUUID());
		materialUnit.setCreateTime(new Date());
		materialUnit.setCreater(currentUSerservice.getId());
		materialUnit.setIsDelete("01");
		materialUnitMapper.insert(materialUnit);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		return resultEntity;
	}
    //判断编码是否存在
	private boolean checkUnitCodeIsExit(MaterialUnit materialUnit) {
		MaterialUnitExample example = new MaterialUnitExample();
		if (!StringUtils.isBlank(materialUnit.getMeasuringUnitId())){
			example.createCriteria().andMeasuringUnitCodeEqualTo(materialUnit.getMeasuringUnitCode()).andIsDeleteEqualTo("01").andMeasuringUnitIdNotEqualTo(materialUnit.getMeasuringUnitId());
		}else{
			example.createCriteria().andMeasuringUnitCodeEqualTo(materialUnit.getMeasuringUnitCode()).andIsDeleteEqualTo("01");
		}
		int count = materialUnitMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	//判断名称是否存在
	private boolean checkUnitNameIsExit(MaterialUnit materialUnit) {
		MaterialUnitExample example = new MaterialUnitExample();
		if (!StringUtils.isBlank(materialUnit.getMeasuringUnitId())){
			example.createCriteria().andMeasuringUnitNameEqualTo(materialUnit.getMeasuringUnitName()).andIsDeleteEqualTo("01").andMeasuringUnitIdNotEqualTo(materialUnit.getMeasuringUnitId());
		}else{
			example.createCriteria().andMeasuringUnitNameEqualTo(materialUnit.getMeasuringUnitName()).andIsDeleteEqualTo("01");
		}
		int count = materialUnitMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultEntity editMaterialUnit(MaterialUnit materialUnit) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(materialUnit.getMeasuringUnitCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位编码不可为空");
			return resultEntity;
		} else {
			if (checkUnitCodeIsExit(materialUnit)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资单位编码已存在");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(materialUnit.getMeasuringUnitName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位名称不可为空");
			return resultEntity;
		} else {
			if (checkUnitNameIsExit(materialUnit)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资单位名称已存在");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(materialUnit.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资单位状态不可为空");
			return resultEntity;
		}
		materialUnitMapper.updateByPrimaryKeySelective(materialUnit);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("编辑成功");
		return resultEntity;
	}

	@Override
	public ResultEntity delUnit(List<String> measuringUnitIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(measuringUnitIds==null||measuringUnitIds.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请传入物资单位Id");
			return resultEntity;
		}
		for(String measuringUnitId:measuringUnitIds ){
			MaterialUnit materialUnit = materialUnitMapper.selectByPrimaryKey(measuringUnitId);
			MaterialExample example = new MaterialExample();
			example.createCriteria().andIsDeleteEqualTo("01").andMeasuringUnitEqualTo(measuringUnitId);
			int count = materialMapper.countByExample(example);
			if(count>0){
				if(materialUnit!=null){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资单位:"+materialUnit.getMeasuringUnitName()+"，包含物资，无法删除");
					return resultEntity;
				}
			}
		}
		materialUnitMapper.deleteByIds(measuringUnitIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

}
