package com.qz.zframe.material.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.w3c.dom.ls.LSInput;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.DamagedPartsDetailMapper;
import com.qz.zframe.material.dao.DamagedPartsMapper;
import com.qz.zframe.material.entity.DamagedParts;
import com.qz.zframe.material.entity.DamagedPartsDetail;
import com.qz.zframe.material.entity.DamagedPartsDetailExample;
import com.qz.zframe.material.entity.DamagedPartsExample;
import com.qz.zframe.material.service.DamagedPartsService;

@Service
public class DamagedPartsServiceImpl implements DamagedPartsService{
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	
	@Autowired
	private DamagedPartsMapper damagedPartsMapper;
	
	@Autowired
	private DamagedPartsDetailMapper damagedPartsDetailMapper;

	@Override
	public PageResultEntity getDamagedPartsList(DamagedPartsExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = damagedPartsMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<DamagedParts> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = damagedPartsMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Override
	public ResultEntity getDamagedPartsDetails(String damagedPartsId) {
		ResultEntity resultEntity = new ResultEntity();
		DamagedParts damagedPartsInfo = damagedPartsMapper.selectByPrimaryKey(damagedPartsId);
		if(damagedPartsId==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("损坏件不存在");
		}else{
			DamagedPartsDetailExample example = new DamagedPartsDetailExample();
			example.createCriteria().andDamagedPartsIdEqualTo(damagedPartsId);
			List<DamagedPartsDetail> list=damagedPartsDetailMapper.selectByExample(example);
			damagedPartsInfo.setDamagedPartsDetails(list);
			resultEntity.setData(damagedPartsInfo);
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity addDamagedParts(DamagedParts damagedParts) throws ParseException {
		ResultEntity resultEntity = new ResultEntity();
		if (!StringUtils.isBlank(damagedParts.getStorageDate())) {
			damagedParts.setStorageTime(format.parse(damagedParts.getStorageDate()));
		}
		try {
			String damagedPartsId=UUIdUtil.getUUID();
			damagedParts.setDamagedPartsId(damagedPartsId);
			damagedPartsMapper.insertSelective(damagedParts);
			for (DamagedPartsDetail damagedPartsDetail : damagedParts.getDamagedPartsDetails()) {
				damagedPartsDetail.setDamagedPartsDetailId(UUIdUtil.getUUID());
				damagedPartsDetail.setDamagedPartsId(damagedPartsId);
				damagedPartsDetailMapper.insertSelective(damagedPartsDetail);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("网络繁忙");
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity editDamagedParts(DamagedParts damagedParts) throws ParseException {
		ResultEntity resultEntity = new ResultEntity();
		if (!StringUtils.isBlank(damagedParts.getStorageDate())) {
			damagedParts.setStorageTime(format.parse(damagedParts.getStorageDate()));
		}
		try {
			damagedPartsMapper.updateByPrimaryKeySelective(damagedParts);
			damagedPartsDetailMapper.delDamagedPartsDetail(damagedParts.getDamagedPartsId());
			for (DamagedPartsDetail damagedPartsDetail : damagedParts.getDamagedPartsDetails()) {
				damagedPartsDetailMapper.insertSelective(damagedPartsDetail);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("网络繁忙");
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity delDamagedParts(List<String> damagedPartsIds) {
		ResultEntity resultEntity = new ResultEntity();
		try {
			damagedPartsMapper.delByPartsIds(damagedPartsIds);
			damagedPartsDetailMapper.delByPartsIds(damagedPartsIds);
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("网络繁忙");
		}
		return resultEntity;
	}
}
