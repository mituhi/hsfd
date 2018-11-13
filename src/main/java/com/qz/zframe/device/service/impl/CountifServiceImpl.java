package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.vo.Breakdown;
import com.qz.zframe.device.entity.vo.BreakdownDetail;
import com.qz.zframe.device.service.CountifService;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.mapper.BreakdownInfoMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class CountifServiceImpl implements CountifService {
	@Autowired
	private BreakdownInfoMapper breakdownInfoMapper;

	@Override
	public PageResultEntity findCountis(String pageType, String countType,Date activeTime,Date activeTime2) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<Breakdown> breakdown = new ArrayList<Breakdown>();
		if ("0".equals(pageType)) {
			if ("1".equals(countType)) {
				int count=breakdownInfoMapper.countNumber(activeTime,activeTime2);
				resultEntity.setTotal(count);
				breakdown = breakdownInfoMapper.numberTroubleSite(activeTime,activeTime2);
			}
			if ("2".equals(countType)) {
				int count=breakdownInfoMapper.countNumbers(activeTime,activeTime2);
				resultEntity.setTotal(count);
				breakdown = breakdownInfoMapper.numberTrouble(activeTime,activeTime2);
			}
			if ("3".equals(countType)) {
				breakdown = breakdownInfoMapper.completeTrouble(activeTime,activeTime2);
			}
		} else {

		}
		if (breakdown == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询失败");
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setRows(breakdown); 
		return resultEntity;

	}

	/*
	 * @Override public ResultEntity numberTrouble(BreakdownInfoExample
	 * breakExample) { ResultEntity resultEntity = new ResultEntity();
	 * List<Breakdown> breakdown=breakdownInfoMapper.numberTrouble(breakExample);
	 * if(breakdown==null) { resultEntity.setCode(ErrorCode.ERROR);
	 * resultEntity.setMsg("查询失败"); } resultEntity.setCode(ErrorCode.SUCCESS);
	 * resultEntity.setMsg("查询成功"); resultEntity.setData(breakdown); return
	 * resultEntity; }
	 * 
	 * @Override public ResultEntity completeTrouble(BreakdownInfoExample
	 * breakExample) { ResultEntity resultEntity = new ResultEntity();
	 * List<Breakdown>
	 * breakdown=breakdownInfoMapper.numberTroubleSite(breakExample);
	 * if(breakdown==null) { resultEntity.setCode(ErrorCode.ERROR);
	 * resultEntity.setMsg("查询失败"); } resultEntity.setCode(ErrorCode.SUCCESS);
	 * resultEntity.setMsg("查询成功"); resultEntity.setData(breakdown); return
	 * resultEntity; }
	 */
	public ResultEntity findCountisById(Date activeTime,Date activeTime2,String windId) {
		ResultEntity resultEntity = new ResultEntity();
		List<BreakdownDetail> breakdownDetail = breakdownInfoMapper.numberTroubleDetail(activeTime,activeTime2,windId);

		if (breakdownDetail == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询失败");
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setData(breakdownDetail);
		return resultEntity;
	}
}

