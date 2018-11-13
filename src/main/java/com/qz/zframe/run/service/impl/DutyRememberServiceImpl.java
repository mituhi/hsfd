package com.qz.zframe.run.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.dao.DutyRememberMapper;
import com.qz.zframe.run.entity.DutyRemember;
import com.qz.zframe.run.entity.DutyRememberExample;
import com.qz.zframe.run.service.DutyRememberService;

@Service
@Transactional(rollbackFor=Exception.class)
public class DutyRememberServiceImpl implements DutyRememberService {
	
	@Autowired
	private DutyRememberMapper dutyRememberMapper;
	

	@Override
	public ResultEntity saveDutyRemember(DutyRemember dutyRemember) {
		ResultEntity resultEntity = new ResultEntity();

		//设置id
		if(StringUtils.isEmpty(dutyRemember.getDutyId())){
			dutyRemember.setDutyId(UUID.randomUUID().toString());
		}
		
		dutyRememberMapper.insert(dutyRemember);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

}
