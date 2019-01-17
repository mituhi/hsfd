package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.DamagedAuditDetailMapper;
import com.qz.zframe.material.dao.DamagedAuditMapper;
import com.qz.zframe.material.dao.DamagedPartsDetailMapper;
import com.qz.zframe.material.entity.DamagedAudit;
import com.qz.zframe.material.entity.DamagedAuditDetail;
import com.qz.zframe.material.entity.DamagedAuditDetailExample;
import com.qz.zframe.material.entity.DamagedAuditExample;
import com.qz.zframe.material.entity.DamagedPartsDetail;
import com.qz.zframe.material.service.DamagedAuditService;

@Service
public class DamagedAuditServiceImpl implements DamagedAuditService{

	@Autowired
	private DamagedAuditMapper damagedAuditMapper;
	
	@Autowired
	private DamagedAuditDetailMapper damagedAuditDetailMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getDamageAuditList(DamagedAuditExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = damagedAuditMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<DamagedAudit> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=damagedAuditMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity addDamageAudit(DamagedAudit damagedAudit) {
		ResultEntity resultEntity = new ResultEntity();
		String damageAuditId=UUIdUtil.getUUID();
		try {
			UserInfo userInfo = currentUSerservice.getUserInfo();
			damagedAudit.setCreater(userInfo.getUserId());
			damagedAudit.setDamagedAuditId(damageAuditId);
			damagedAudit.setCreateTime(new Date());
			damagedAuditMapper.insertSelective(damagedAudit);
			for(DamagedAuditDetail damagedPartsDetail:damagedAudit.getDamagedAuditDetails()){
				damagedPartsDetail.setDamagedAuditId(damageAuditId);
				damagedPartsDetail.setDamagedPartsDetailId(UUIdUtil.getUUID());
				damagedAuditDetailMapper.insertSelective(damagedPartsDetail);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("系统繁忙");
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity editDamagedAudit(DamagedAudit damagedAudit) {
		ResultEntity resultEntity = new ResultEntity();
		damagedAuditMapper.updateByPrimaryKeySelective(damagedAudit);
		try {
			if (damagedAudit.getDamagedAuditDetails() != null && !damagedAudit.getDamagedAuditDetails().isEmpty()) {
				damagedAuditDetailMapper.delByDamagedId(damagedAudit.getDamagedAuditId());
				for (DamagedAuditDetail damagedAuditDetail : damagedAudit.getDamagedAuditDetails()) {
					damagedAuditDetailMapper.insertSelective(damagedAuditDetail);
			}
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("系统繁忙");
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity delDamagedAudit(List<String> damagedAuditIds) {
		ResultEntity resultEntity = new ResultEntity();
		try {
			damagedAuditMapper.delBydamagedAuditIds(damagedAuditIds);
			damagedAuditDetailMapper.delByDamagedIds(damagedAuditIds);
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("系统繁忙");
		}
		return resultEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getDamageAuditListDatail(String damageAuditId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
		DamagedAudit damagedAudit = damagedAuditMapper.selectByPrimaryKey(damageAuditId);
		if(damageAuditId==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("损坏件审核信息不存在");
			return resultEntity;
		}else{
			DamagedAuditDetailExample example = new DamagedAuditDetailExample();
			example.createCriteria().andDamagedAuditIdEqualTo(damageAuditId);
			List<DamagedAuditDetail> list = damagedAuditDetailMapper.selectByExample(example);
			damagedAudit.setDamagedAuditDetails(list);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(damagedAudit);
		}
		return resultEntity;
	}
	

}
