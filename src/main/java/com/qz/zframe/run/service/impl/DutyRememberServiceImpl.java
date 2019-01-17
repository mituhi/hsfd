package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
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


	/**
	 * 根据主键删除
	 */
	@Override
	public ResultEntity deleteDutyRemember(String dutyRememberId) {
		ResultEntity resultEntity = new ResultEntity();
		dutyRememberMapper.deleteByPrimaryKey(dutyRememberId);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}


	/**
	 * 更新
	 */
	@Override
	public ResultEntity updateDutyRemember(DutyRemember dutyRemember) {
		ResultEntity resultEntity = new ResultEntity();
		dutyRememberMapper.updateByPrimaryKeySelective(dutyRemember);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}

	
	@Override
	public List<DutyRemember> getDutyRememberList() {
		DutyRememberExample example = new DutyRememberExample();
		return dutyRememberMapper.selectByExample(example);
	}

	
	/**
	 * @Description:返回所有的主题
	 * @param: @param dutyRemembers
	 * @param: @return   
	 * @return: List<String>
	 */
	@Override
	public Set<String> getRememberTheme(){
		
		List<DutyRemember> dutyRemembers = getDutyRememberList();
		//如果不为空
		if(CollectionUtils.isNotEmpty(dutyRemembers)){
			
			//创建set集合
			Set<String> result = new HashSet<String>();
			
			//循环遍历
			for (DutyRemember dutyRemember : dutyRemembers) {
				result.add(dutyRemember.getRememberTheme());
			}
			return result;
		}else{
			return null;
		}
	}
	
	
}
