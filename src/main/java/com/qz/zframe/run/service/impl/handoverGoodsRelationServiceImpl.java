package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.run.dao.GoodsMapper;
import com.qz.zframe.run.dao.HandoverGoodsMapper;
import com.qz.zframe.run.dao.HandoverGoodsRelationMapper;
import com.qz.zframe.run.entity.Goods;
import com.qz.zframe.run.entity.HandoverGoods;
import com.qz.zframe.run.entity.HandoverGoodsRelation;
import com.qz.zframe.run.entity.HandoverGoodsRelationExample;
import com.qz.zframe.run.entity.result.HandoverResult;
import com.qz.zframe.run.entity.submit.HandoverGoodsSubmit;
import com.qz.zframe.run.entity.submit.HandoverSearchSubmit;
import com.qz.zframe.run.service.HandoverGoodsRelationService;
/**
 * <p>Title: handoverGoodsRelationServiceImpl</p>
 * <p>@Description: 交接物品关联表接口实现 </p>
 * @author 
 * @date 2018年11月14日 下午4:59:43
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class handoverGoodsRelationServiceImpl implements HandoverGoodsRelationService {
	
	@Autowired
	private HandoverGoodsRelationMapper handoverGoodsRelationMapper;
	
	@Autowired
	private GoodsMapper goodsMapper ;
	
	@Autowired
	private HandoverGoodsMapper handoverGoodsMapper;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	/**
	 * @Description:交接物品关联表保存操作
	 * @param: @param handoverGoodsRelation
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@Override
	public ResultEntity saveHandoverGoods(HandoverGoods handoverGoods) {
		ResultEntity resultEntity = new ResultEntity();

		if(StringUtils.isBlank(handoverGoods.getLogTypeId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("日志类型不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(handoverGoods.getLogTypeId())){
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
		handoverGoods.setHandoverGoodsId(handoverGoodsId);
		handoverGoods.setMaintainUser(currentUserService.getId());
		handoverGoods.setMaintainTime(new Date());
		handoverGoods.setGoodNum(handoverGoods.getGoods().size());
		List<Goods> goodsList = new ArrayList<>();
		for(Goods g:handoverGoods.getGoods()){
			if(StringUtils.isBlank(g.getGoodsCode())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("");
				return resultEntity;
			}
			if(StringUtils.isBlank(g.getGoodsName())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("");
				return resultEntity;
			}
			
			if(StringUtils.isBlank(g.getIsEnabled())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("");
				return resultEntity;
			}
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
	 * 根据查询条件查询交接物品配置首页信息
	 */
	@Override
	public PageResultEntity listHandoverGoodsRelation(HandoverSearchSubmit searchSubmit, int pageNo, int pageSize) {
		
		//创建返回对象
		PageResultEntity pageResultEntity = new PageResultEntity();
		//返回对象数据
		List<HandoverResult> results = new ArrayList<HandoverResult>();
		
		if (pageNo != 0 && pageSize != 0) {
			PageHelper.startPage(pageNo, pageSize);
		}
		// 查询
		List<HandoverResult> searchHandoverList = handoverGoodsRelationMapper.searchHandoverList(searchSubmit);
		// 进行封装：封装的依据是如果交接物品表id一致，则设备数量累计
		for (HandoverResult handoverResult : searchHandoverList) {

			// 返回对象数据中不为空就进行比较交接物品表id
			if (CollectionUtils.isNotEmpty(results)) {

				// 设置一个flag=true，表示默认results集合中没有该元素
				boolean flag = true;
				// 循环比较主设备id
				for (HandoverResult handoverResultTemp : results) {
					// 如果交接物品表id相同
					if (handoverResult.getHandoverGoodsId().equals(handoverResultTemp.getHandoverGoodsId())) {
						flag = false;
						// 数量+1
						handoverResultTemp.setCount(handoverResultTemp.getCount() + 1);
						break;
					}
					// 执行到这里:
					if (flag) {
						// 如果为false假，说明找到了一样的，如果为真，说明没有找到：没有找到就添加到集合中
						// 初始化数量
						handoverResult.setCount(1);
						results.add(handoverResult);
						break;
					}
				}
			} else {
				// 为空，添加到集合中
				// 初始化数量
				handoverResult.setCount(1);
				results.add(handoverResult);
			}
		}
			
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(results);
		pageResultEntity.setTotal(results.size());
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}


	/**
	 * 获取编辑数据
	 */
	@Override
	public ResultEntity getEditData(String handoverGoodsId) {
		
		//通过 handoverGoodsId 获取 关联表  物品表id
		HandoverGoodsRelationExample example = new HandoverGoodsRelationExample();
		
		example.createCriteria().andHandoverGoodsIdEqualTo(handoverGoodsId);
		
		//获取关联对象
		List<HandoverGoodsRelation> list = handoverGoodsRelationMapper.selectByExample(example);
		
		//返回对象
		HandoverGoodsSubmit handoverGoodsSubmit = new HandoverGoodsSubmit();
		//物品集合
		List<Goods> goodsList = new ArrayList<Goods>();
		
		//遍历关联对象获取物品表id
		for (HandoverGoodsRelation handoverGoodsRelation : list) {
			String goodsId = handoverGoodsRelation.getGoodsId();
			//通过goodId查询数据
			Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
			goodsList.add(goods);
		}
		
		handoverGoodsSubmit.setGoodsList(goodsList);
		
		
		//通过handoverGoodsId获取交接物品表信息
		HandoverGoods handoverGoods = handoverGoodsMapper.selectByPrimaryKey(handoverGoodsId);
		handoverGoodsSubmit.setHandoverGoods(handoverGoods);
		
		ResultEntity resultEntity = new ResultEntity();
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(handoverGoodsSubmit);
		return resultEntity;
	}

	
	
	/**
	 * 删除
	 */
	@Override
	public ResultEntity deleteHandoverGoodsRelation(String handoverGoodsId) {
		
		
		HandoverGoodsRelationExample example = new HandoverGoodsRelationExample();
		example.createCriteria().andHandoverGoodsIdEqualTo(handoverGoodsId);
		//获取
		List<HandoverGoodsRelation> list = handoverGoodsRelationMapper.selectByExample(example);
		
		if(list.size() > 0){
			for (HandoverGoodsRelation handoverGoodsRelation : list) {
				String goodsId = handoverGoodsRelation.getGoodsId();
				//删除物品表
				goodsMapper.deleteByPrimaryKey(goodsId);
			}
		}
		
		//删除交接物品表
		handoverGoodsMapper.deleteByPrimaryKey(handoverGoodsId);
		
		
		//删除关联表
		HandoverGoodsRelationExample handoverGoodsRelationExample = new HandoverGoodsRelationExample();
		handoverGoodsRelationExample.createCriteria().andHandoverGoodsIdEqualTo(handoverGoodsId);
		handoverGoodsRelationMapper.deleteByExample(handoverGoodsRelationExample);
		
		ResultEntity resultEntity = new ResultEntity();
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}




}
