package com.qz.zframe.run.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyInfoMapper;
import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.service.DutyInfoService;

/**
 * <p>Title: DutyInfoServiceImpl</p>
 * <p>@Description: 值班信息接口实现 </p>
 * @author 陈汇奇
 * @date 2018年11月8日 下午3:45:34
 * @version:V1.0
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DutyInfoServiceImpl implements DutyInfoService {

	@Autowired
	private DutyInfoMapper dutyInfoMapper;
	
	
	/**
	 * 保存操作
	 */
	@Override
	public ResultEntity saveDutyInfo(DutyInfo dutyInfo) {

		ResultEntity resultEntity = new ResultEntity();
		// 生成id
		dutyInfo.setDutyInfoId(UUID.randomUUID().toString());

		// 执行保存
		dutyInfoMapper.insert(dutyInfo);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
