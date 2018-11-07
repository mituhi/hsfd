package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.dao.StockAddressMapper;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddressExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StockAddressService;

@Service
public class StockAddressServiceImpl implements StockAddressService {
	
	@Autowired
	private StockAddressMapper stockAddressMapper;

	@Override
	public PageResultEntity getStockAddrList(StockAddressExample example) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = stockAddressMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<StockAddress> list;
		if(count==0){
		   list=Collections.emptyList();	
		}else{
		   list=stockAddressMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Override
	public ResultEntity getStockAddrdetailById(String stockAddId) {
		ResultEntity resultEntity = new ResultEntity();
		StockAddress stockAddress = stockAddressMapper.selectByPrimaryKey(stockAddId);
		if(stockAddress==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存地点不存在");
		}else{
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(stockAddress);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addStockAddr(StockAddress stockAddress) {
		ResultEntity resultEntity = new ResultEntity();
		if(checkStockAddrIsExitByCode(stockAddress.getStockAddCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存地点编码已存在");
			return resultEntity;
			
		}
		if(checkStockAddrIsExitByName(stockAddress.getStockAddName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存地点名称已存在");
			return resultEntity;
		}
		stockAddressMapper.insertSelective(stockAddress);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	
	@Override
	public ResultEntity editStockAddr(StockAddress stockAddress) {
		ResultEntity resultEntity = new ResultEntity();
		StockAddress stockAddressInfo = stockAddressMapper.selectByPrimaryKey(stockAddress.getStockAddId());
		if(stockAddressInfo!=null){
			if(!stockAddressInfo.getStockAddName().equals(stockAddress.getStockAddName())){
				if(checkStockAddrIsExitByName(stockAddress.getStockAddName())){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("库存地点名称重复");
					return resultEntity;
				}
			}
			if(!stockAddressInfo.getStockAddCode().equals(stockAddress.getStockAddCode())){
			if(checkStockAddrIsExitByCode(stockAddress.getStockAddCode())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("库存地点编码重复");
				return resultEntity;
			}
			}
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("库存地点不存在");
			return resultEntity;
		}
		stockAddressMapper.updateByPrimaryKeySelective(stockAddress);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public ResultEntity delStockAddr(List<String> stockAddIds) {
		ResultEntity resultEntity = new ResultEntity();
		Map<String, Object> params = new HashMap<>(2);
		params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
		params.put("stockAddIds", stockAddIds);
		stockAddressMapper.updateIsdete(params);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	
	/**
	 * 通过库存地点名称判断是否存在
	 */
	private boolean checkStockAddrIsExitByName(String stockAddName) {
		StockAddressExample example = new StockAddressExample();
		example.createCriteria().andStockAddNameEqualTo(stockAddName).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		int count = stockAddressMapper.countByExample(example);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 通过库存地点编码判断是否存在
	 */
	private boolean checkStockAddrIsExitByCode(String stockAddCode) {
		StockAddressExample example = new StockAddressExample();
		example.createCriteria().andStockAddCodeEqualTo(stockAddCode).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		int count = stockAddressMapper.countByExample(example);
		if(count>0){
			return true;
		}else{
			return false;
		}		
	}

}
