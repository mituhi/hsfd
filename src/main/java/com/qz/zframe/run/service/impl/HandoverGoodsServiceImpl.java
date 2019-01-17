package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.run.dao.GoodsMapper;
import com.qz.zframe.run.dao.HandoverGoodsMapper;
import com.qz.zframe.run.entity.Goods;
import com.qz.zframe.run.entity.GoodsExample;
import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsExample;
import com.qz.zframe.run.service.HandoverGoodsService;

import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.statement.select.Select;


@Service
@Transactional(rollbackFor=Exception.class)
public class HandoverGoodsServiceImpl implements HandoverGoodsService {
	
	@Autowired
	private HandoverGoodsMapper handoverGoodsMapper;

	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity saveHandoverGoods(HandoverGoods handoverGoods) {

		ResultEntity resultEntity = new ResultEntity();

		if(StringUtils.isBlank(handoverGoods.getLogTypeId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getWindCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("风电场不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("交接物品配置状态不可为空");
			return resultEntity;
		}
		if(handoverGoods.getGoods()==null||handoverGoods.getGoods().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("交接物品物品明细不可为空");
			return resultEntity;
		}
		String handoverGoodsId=UUIdUtil.getUUID();
		
		try{
		String serialNum = handoverGoodsMapper.selectMaxSeroalNum();
		if(serialNum==null){
			handoverGoods.setSerialNum("1");
		}else{
			handoverGoods.setSerialNum(String.valueOf(Integer.valueOf(serialNum)+1));
		}
		handoverGoods.setHandoverGoodsId(handoverGoodsId);
		handoverGoods.setMaintainUser(currentUserService.getId());
		handoverGoods.setMaintainTime(new Date());
		handoverGoods.setGoodNum(handoverGoods.getGoods().size());
		List<Goods> goodsList = new ArrayList<>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("handoverGoodsId", handoverGoodsId);
		params.put("windCode",handoverGoods.getWindCode());
		String afterMaxgoodsCode=null;
		String maxGoodsCode=goodsMapper.selectMaxGoodsCode(params);
		if(maxGoodsCode==null){
			afterMaxgoodsCode="0000";
		}else{
			afterMaxgoodsCode=maxGoodsCode;
		}
		int i=0;
		for(Goods g:handoverGoods.getGoods()){
			i++;
			String newCode = String.valueOf(Integer.parseInt(afterMaxgoodsCode.substring(afterMaxgoodsCode.length()-4)) + i);
			switch (newCode.length()) {
			case 1:
				newCode = "000" + newCode;
				break;
			case 2:
				newCode = "00" + newCode;
				break;
			case 3:
				newCode = "0" + newCode;
				break;
			default:
				break;
			}
			if(StringUtils.isBlank(g.getGoodsName())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物品名称不可为空");
				return resultEntity;
			}
			
			if(StringUtils.isBlank(g.getIsEnabled())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物品状态不可为空");
				return resultEntity;
			}
			g.setGoodsCode(newCode);
			g.setHandoverGoodsId(handoverGoodsId);
			g.setGoodsId(UUIdUtil.getUUID());
			goodsList.add(g);
		}
		handoverGoodsMapper.insertSelective(handoverGoods);
		goodsMapper.insertList(goodsList);		
		}catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		return resultEntity;
	}

	
	
	
	/**
	 * 编辑
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity updateHandoverGoods(HandoverGoods handoverGoods) {
		ResultEntity resultEntity = new ResultEntity();
          
		if(StringUtils.isBlank(handoverGoods.getHandoverGoodsId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("编辑时物品交接Id不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getLogTypeId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getWindCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("风电场不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("交接物品配置状态不可为空");
			return resultEntity;
		}
		if(handoverGoods.getGoods()==null||handoverGoods.getGoods().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("交接物品物品明细不可为空");
			return resultEntity;
		}
		String handoverGoodsId=handoverGoods.getHandoverGoodsId();
		try{
		handoverGoods.setMaintainUser(currentUserService.getId());
		handoverGoods.setMaintainTime(new Date());
		handoverGoods.setGoodNum(handoverGoods.getGoods().size());
		List<Goods> goodsList = new ArrayList<>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("handoverGoodsId", handoverGoodsId);
		params.put("windCode",handoverGoods.getWindCode());
		String afterMaxgoodsCode=null;
		String maxGoodsCode=goodsMapper.selectMaxGoodsCode(params);
		if(maxGoodsCode==null){
			afterMaxgoodsCode="0000";
		}else{
			afterMaxgoodsCode=maxGoodsCode;
		}
		int i=0;
		for(Goods g:handoverGoods.getGoods()){
			i++;
			String newCode = String.valueOf(Integer.parseInt(afterMaxgoodsCode.substring(afterMaxgoodsCode.length()-4)) + i);
			switch (newCode.length()) {
			case 1:
				newCode = "000" + newCode;
				break;
			case 2:
				newCode = "00" + newCode;
				break;
			case 3:
				newCode = "0" + newCode;
				break;
			default:
				break;
			}
			if(StringUtils.isBlank(g.getGoodsName())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物品名称不可为空");
				return resultEntity;
			}
			
			if(StringUtils.isBlank(g.getIsEnabled())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物品状态不可为空");
				return resultEntity;
			}
//			g.setSort(i);
			g.setHandoverGoodsId(handoverGoodsId);
			g.setGoodsId(UUIdUtil.getUUID());
			goodsList.add(g);
		}
		handoverGoodsMapper.updateByPrimaryKeySelective(handoverGoods);
		goodsMapper.deleteByPrimaryKey(handoverGoodsId);
		goodsMapper.insertList(goodsList);		
		}catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
		
	}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult listHandoverGoods(HandoverGoodsExample example) {
	    NewPageResult result = new NewPageResult();
	    int count = handoverGoodsMapper.countByExample(example);
	    result.setTotal(count);
	    List<HandoverGoods> list;
	    if(count==0){
	    	list = Collections.emptyList();
	    }else{
	    	list = handoverGoodsMapper.selectByExample(example);
	    }
	    result.setCode(ErrorCode.SUCCESS);
	    result.setRows(list);
		return result;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult detailHandoverGoods(String handoverGoodsId) {
		NewPageResult result = new NewPageResult();
		HandoverGoods handoverGoods = handoverGoodsMapper.selectByPrimaryKey(handoverGoodsId);
		if(handoverGoods==null){
			result.setCode(ErrorCode.ERROR);
			result.setMsg("物品交接信息不存在");
			return result;
		}else{
			result.setCode(ErrorCode.SUCCESS);
			result.setTotal(1);
			GoodsExample example = new GoodsExample();
			example.createCriteria().andGoodsHandoverGoodsId(handoverGoods.getHandoverGoodsId());
			List<Goods> list=goodsMapper.selectByExample(example);
			handoverGoods.setGoods(list);
			result.setRows(handoverGoods);
		}
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity delHandoverGoods(List<String> handoverGoodsIds) {
	    ResultEntity resultEntity = new ResultEntity();
	    try {
	    	handoverGoodsMapper.deleteHandoverGoodsList(handoverGoodsIds);
	    	goodsMapper.deleteGoodsList(handoverGoodsIds);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		}
	    resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
