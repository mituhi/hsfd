package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.dao.StockAddressMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.entity.StockAddress;
import com.qz.zframe.material.entity.StockAddressExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.StockAddressService;


@Service
@Transactional(rollbackFor = Exception.class)
public class StockAddressServiceImpl implements StockAddressService {
	
	@Autowired
	private StockAddressMapper stockAddressMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@Autowired
	private DataDictService dataDictService;
	
	@Autowired
	private InventoryMapper inventoryMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult<StockAddress> getStockAddrList(StockAddressExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getStockAddrdetailById(String stockAddId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
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
	public ResultEntity addStockAddr(StockAddress stockAddress) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(stockAddress.getStockAddAttr())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("地点属性不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getArchitectureCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("风电场不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("状态不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getStockAddCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("地点编码不可为空");
			return resultEntity;
		} else {
			if (checkStockAddrIsExitByCode(stockAddress.getStockAddCode())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("库存地点编码已存在");
				return resultEntity;
			}
		}
			if (StringUtils.isBlank(stockAddress.getStockAddName())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("库存地点名称不可为空");
				return resultEntity;
			}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		stockAddress.setCreater(userInfo.getUserId());
		stockAddress.setStockAddId(UUIdUtil.getUUID());
		stockAddress.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		stockAddressMapper.insertSelective(stockAddress);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}
	
	@Override
	public ResultEntity editStockAddr(StockAddress stockAddress) {
		ResultEntity resultEntity = new ResultEntity();
		StockAddress stockAddressInfo = stockAddressMapper.selectByPrimaryKey(stockAddress.getStockAddId());
		if (StringUtils.isBlank(stockAddress.getStockAddAttr())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("地点属性不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getArchitectureCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("风电场不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("状态不可为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(stockAddress.getStockAddCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("地点编码不可为空");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(stockAddress.getStockAddName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("地点名称不可为空");
			return resultEntity;
		}
		if(stockAddressInfo!=null){
			if(!stockAddressInfo.getStockAddName().equals(stockAddress.getStockAddName())){
//				if(checkStockAddrIsExitByName(stockAddress.getStockAddName())){
//					resultEntity.setCode(ErrorCode.ERROR);
//					resultEntity.setMsg("库存地点名称重复");
//					return resultEntity;
//				}
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
		for(String stockAddId:stockAddIds){
			StockAddress stockAddress = stockAddressMapper.selectByPrimaryKey(stockAddId);
			if(stockAddress!=null){
				InventoryExample example = new InventoryExample();
				example.createCriteria().andStockAddIdEqualTo(stockAddress.getStockAddId());
				List<Inventory> list=inventoryMapper.selectByExample(example);
				if(list!=null&&!list.isEmpty()){
//				for(Inventory inventory:list){
//					if(inventory.getInventoryNum()>0||inventory.getFreezeNum()>0){
//						resultEntity.setCode(ErrorCode.ERROR);
//						resultEntity.setMsg("该仓库下存在物资，无法删除!");
//						return resultEntity;
//					}
//				}
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("该仓库曾进行入库操作，无法删除!");
					return resultEntity;
			  }
			}
		}
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
