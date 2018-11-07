package com.qz.zframe.material.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.functors.FalsePredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.w3c.dom.ls.LSInput;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.dao.MaterialClassifyMapper;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassifyExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialClassifyService;

@Service
public class MaterialClassifyServiceImpl implements MaterialClassifyService {

	private static Logger logger = LoggerFactory.getLogger(MaterialClassifyServiceImpl.class);

	@Autowired
	private MaterialClassifyMapper materialClassifyMapper;

	@Override
	public PageResultEntity getClassifyList(MaterialClassifyExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = materialClassifyMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<MaterialClassify> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialClassifyMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Override
	public ResultEntity addClassify(MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
		if (checkByClassifyNameIsExit(materialClassify)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类已存在");
			return resultEntity;
		}
		materialClassifyMapper.insertSelective(materialClassify);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 判断物资分类是否重复
	 */
	private Boolean checkByClassifyNameIsExit(MaterialClassify materialClassify) {
		MaterialClassifyExample example = new MaterialClassifyExample();
		example.createCriteria().andClassifyNameEqualTo(materialClassify.getClassifyName()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		int count = materialClassifyMapper.countByExample(example);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ResultEntity getClassifyDetail(String materialClassifyId) {
		ResultEntity resultEntity = new ResultEntity();
		MaterialClassify materialClassify = materialClassifyMapper.selectByPrimaryKey(materialClassifyId);
		if (materialClassify == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不存在");
			logger.debug("物资分类Id{}" + materialClassifyId);
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(materialClassify);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity editClassify(MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
		MaterialClassify materialClassifyInfo = materialClassifyMapper.selectByPrimaryKey(materialClassify.getMaterialClassifyId());
		if(materialClassifyInfo!=null){
			if(!materialClassifyInfo.getClassifyName().equals(materialClassify.getClassifyName())){
				if(checkByClassifyNameIsExit(materialClassify)){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资分类已存在");
					return resultEntity;
				}
			}	
		}
		materialClassifyMapper.updateByPrimaryKeySelective(materialClassify);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public ResultEntity delClassify(List<String> materialClassifyIds) {
		ResultEntity resultEntity = new ResultEntity();
	    Map<String, Object> params2 = new HashMap<>(2);
	    params2.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
	    params2.put("materialClassifyIds", materialClassifyIds);
		materialClassifyMapper.updateIsdete(params2);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
