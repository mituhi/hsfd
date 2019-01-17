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
 * @author 
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
		}else{
			shifts =shiftMapper.selectByExample(example);
		}
		/*for(Shift st:shifts) {
			st.setStatusName(statusName(st.getStatus()));
			st.setIsMeterReadName(isMeterRead(st.getIsMeterRead()));
		}*/
		
		return shifts;
	}

	
	/**
	 * 保存信息
	 */
	@Override
	public ResultEntity saveShift(Shift shift) {

		ResultEntity resultEntity = new ResultEntity();
		// 判断 sort 字段是否重复
		Shift list = shiftMapper.selectSort(shift.getSort());
		if (list != null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排序序号已经存在，请重新选填");
			return resultEntity;
		}
		// 生成id
		String id = UUID.randomUUID().toString();
		shift.setShiftId(id);
		// 执行插入操作
		int save = shiftMapper.insert(shift);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("添加失败");
			return resultEntity;
		} else {

			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("添加成功");
		}
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
	@Transactional
	public ResultEntity editShifts(List<Shift> shifts) {
		ResultEntity resultEntity = new ResultEntity();
		int save = 0;
		if (CollectionUtils.isNotEmpty(shifts)) {
			Shift shif = new Shift();

			for (Shift shift : shifts) {
				shif = new Shift();
				shif = shiftMapper.selectByPrimaryKey(shift.getShiftId());
				if (shif == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中有数据有问题,不支持编辑");
					return resultEntity;
				} else {
					Shift shi=shiftMapper.selectSort(shif.getSort());
					if(shi!=null) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("排序序号已经存在，请重新填写");
						return resultEntity;
					}
					save = shiftMapper.updateByPrimaryKeySelective(shift);
				}
			}
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("执行失败");
				return resultEntity;
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("执行成功");
			}
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
			int shift = shiftMapper.selectCount();
			if(shift==0) {
				sort=1;
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("排序序号生成成功");
				resultEntity.setData(sort);
			}else {
				sort=shift+1;
			/*	Shift shif=shiftMapper.selectSort(sort);
				if(shif!=null) {
					sort=sort+1;
				}*/
				Shift shif1=new Shift();
				for(int i=1;i<5;i++) {
					shif1=new Shift();
					shif1=shiftMapper.selectSort(sort);
					if(shif1!=null) {
						sort=sort+1;
					}else {
						break;
					}
				}
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("排序序号生成成功");
				resultEntity.setData(sort);
			}
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
		Shift shift= shiftMapper.selectByPrimaryKey(shiftId);
		/*if(shift!=null) {
			shift.setStatusName(statusName(shift.getStatus()));
			shift.setIsMeterReadName(isMeterRead(shift.getIsMeterRead()));
		}*/
		return shift;
	}
	
	
	public String statusName(String status) {
		if("01".equals(status)) {
		   return "启用";
		}else {
			return "停用";
		}
	}
	public String isMeterRead(String isMeterRead) {
		if("01".equals(isMeterRead)) {
		   return "是";
		}else {
			return "否";
		}
	}
}
