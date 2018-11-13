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

import com.github.pagehelper.Page;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.InInventoryDetailMapper;
import com.qz.zframe.material.dao.InInventoryMapper;
import com.qz.zframe.material.entity.InInventory;
import com.qz.zframe.material.entity.InInventoryDetail;
import com.qz.zframe.material.entity.InInventoryDetailExample;
import com.qz.zframe.material.entity.InInventoryExample;
import com.qz.zframe.material.enums.InInventoryTypeEnum;
import com.qz.zframe.material.service.InInventoryService;

@Service
public class InInventoryServiceImpl implements InInventoryService {
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	
	@Autowired
	private InInventoryMapper inInventoryMapper;
	
	@Autowired
	private InInventoryDetailMapper inInventoryDetailMapper;

	@Override
	public PageResultEntity getListInInventory(InInventoryExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = inInventoryMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<InInventory> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=inInventoryMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity saveInInventory(InInventory inInventory) {
		ResultEntity resultEntity = new ResultEntity();
		String inInventoryId=UUIdUtil.getUUID();
		inInventory.setInInventoryId(inInventoryId);
		try{
		inInventoryMapper.insertSelective(inInventory);
		for(InInventoryDetail inInventoryDetail:inInventory.getInInventoryDetails()){
			inInventoryDetail.setInInventoryDetailId(UUIdUtil.getUUID());
			inInventoryDetail.setInInventoryId(inInventoryId);
			if(!StringUtils.isBlank(inInventoryDetail.getManufactureDate())){
				inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
			}
			inInventoryDetailMapper.insertSelective(inInventoryDetail);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("系统繁忙");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity getDetailInInventory(String inInventoryId) {
	    ResultEntity resultEntity = new ResultEntity();
	    InInventory inInventory =inInventoryMapper.selectByPrimaryKey(inInventoryId);
	    if(inInventory==null){
	    	resultEntity.setCode(ErrorCode.ERROR);
	    	resultEntity.setMsg("入库单不存在");
	    }else{
	    	InInventoryDetailExample example = new InInventoryDetailExample();
	    	example.createCriteria().andInInventoryIdEqualTo(inInventory.getInInventoryId());
	    	inInventory.setInInventoryDetails(inInventoryDetailMapper.selectByExample(example));
	    	resultEntity.setCode(ErrorCode.SUCCESS);
	    	resultEntity.setData(inInventory);
	    }
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity editInInventory(InInventory inInventory) throws ParseException{
		ResultEntity resultEntity = new ResultEntity();
		if(!StringUtils.isBlank(inInventory.getInInventoryDate())){
			inInventory.setInInventoryTime(format.parse(inInventory.getInInventoryDate()));
		}
		try {
		inInventoryMapper.updateByPrimaryKeySelective(inInventory);
		//删除旧详情数据
		inInventoryDetailMapper.delByInInventoryId(inInventory.getInInventoryId());
		if(inInventory.getInInventoryDetails().size() !=0&& !inInventory.getInInventoryDetails().isEmpty()){
			for(InInventoryDetail inInventoryDetail:inInventory.getInInventoryDetails()){	
				if(!StringUtils.isBlank(inInventoryDetail.getManufactureDate())){
					inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));  
				}
				inInventoryDetailMapper.insertSelective(inInventoryDetail);
			}
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("系统繁忙!");
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity delInInventory(List<String> inInventoryIds) {
		ResultEntity resultEntity = new ResultEntity();
		try {
			inInventoryMapper.deleteByIds(inInventoryIds);
			inInventoryDetailMapper.deleteByIds(inInventoryIds);
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("网络繁忙!");
		}
		return resultEntity;
	}

}
