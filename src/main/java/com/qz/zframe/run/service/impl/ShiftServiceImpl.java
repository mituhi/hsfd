package com.qz.zframe.run.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.RuleShiftValueMapper;
import com.qz.zframe.run.dao.ShiftMapper;
import com.qz.zframe.run.entity.RuleShiftValueExample;
import com.qz.zframe.run.entity.RuleShiftValueExample.Criteria;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;
import com.qz.zframe.run.service.ShiftService;

/**
 * <p>Title: ShiftServiceImpl</p>
 * <p>@Description: 班次实现 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:46:28
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ShiftServiceImpl implements ShiftService {

	@Autowired
	private ShiftMapper shiftMapper;

	@Autowired
	private RuleShiftValueMapper ruleShiftValueMapper;
	
	/**
	 * 批量获取
	 */
	@Override
	public List<Shift> listShift(ShiftExample example , int pageNo , int pageSize) {
		List<Shift> shifts = Collections.emptyList();
		
		if(pageNo != 0 && pageSize != 0){
			PageHelper.startPage(pageNo, pageSize);
			//查出记录
			shifts =shiftMapper.selectByExample(example);
		}
		return shifts;
	}

	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveShift(Shift shift) {
		
		ResultEntity resultEntity = new ResultEntity();
		//判断 sort 字段是否重复
		ShiftExample example = new ShiftExample();
		example.createCriteria().andSortEqualTo(shift.getSort());
		
		//执行查询
		List<Shift> list = shiftMapper.selectByExample(example);
		
		//如果集合有数据，则sort已存在，插入失败
		if(CollectionUtils.isNotEmpty(list)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排序值重复");
			return resultEntity;
		}
		
		// 生成id
		String id = UUID.randomUUID().toString();
		shift.setShiftId(id);
		//执行插入操作
		shiftMapper.insert(shift);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("添加成功");
		return resultEntity;
	}

	
	/**
	 * 批量删除
	 */
	@Override
	public ResultEntity removeShifts(List<String> shiftIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isNotEmpty(shiftIds)) {

			// 遍历删除
			for (String id : shiftIds) {
				shiftMapper.deleteByPrimaryKey(id);
				
				//删除排班班次值次关联表相关字段
				RuleShiftValueExample example = new RuleShiftValueExample();
				Criteria criteria = example.createCriteria();
				
				//设置删除条件
				criteria.andShiftIdEqualTo(id);
				//执行删除
				ruleShiftValueMapper.deleteByExample(example);
			}

			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行失败");
		}

		return resultEntity;
	}

	
	/**
	 * 批量编辑
	 */
	@Override
	public ResultEntity editShifts(List<Shift> shifts) {
		ResultEntity resultEntity = new ResultEntity();
		if (CollectionUtils.isNotEmpty(shifts)) {
			for (Shift shift : shifts) {
				shiftMapper.updateByPrimaryKeySelective(shift);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("执行失败");
		}
		return resultEntity;
	}

	
	/**
	 * 获取表中sort最大值
	 */
	@Override
	public ResultEntity getMaxSort() {
		ResultEntity resultEntity = new ResultEntity();
		//设置初始值为0
		int sort = 0 ;
		try {
			Shift shift = shiftMapper.selectMaxSort();
			 sort = shift.getSort();
		} catch (Exception e) {
			//捕获异常：则为系统第一次录入返回1
		}
		resultEntity.setMsg((sort+1)+"");
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}


	/**
	 * 通过code获取id
	 */
	@Override
	public String getShiftIdByCode(String shiftCode) {
		ShiftExample example = new ShiftExample();
		example.createCriteria().andShiftCodeEqualTo(shiftCode);
		List<Shift> list = shiftMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(list)){
			Shift shift = list.get(0);
			return shift.getShiftId();
		}
		return null;
	}


	/**
	 * 通过班次名称获取对象
	 */
	@Override
	public Shift getShiftByShiftName(String shiftName) {
		ShiftExample example = new ShiftExample();
		example.createCriteria().andShiftNameEqualTo(shiftName);

		// 执行查询操作
		List<Shift> list = shiftMapper.selectByExample(example);
		// 如果不为空
		if (CollectionUtils.isNotEmpty(list)) {
			Shift shift = list.get(0);
			return shift;
		}

		return null;
	}


	/**
	 * 通过id查找
	 */
	@Override
	public Shift getShiftByShiftId(String shiftId) {
		return shiftMapper.selectByPrimaryKey(shiftId);
	}
}
