package com.qz.zframe.run.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.run.dao.NewSchedulingAssociatedMapper;
import com.qz.zframe.run.dao.SchedulingAssociatedDetailMapper;
import com.qz.zframe.run.entity.AssociatedDetailDate;
import com.qz.zframe.run.entity.NewSchedulingAssociated;
import com.qz.zframe.run.entity.NewSchedulingAssociatedExample;
import com.qz.zframe.run.entity.SchedulingAssociatedDetail;
import com.qz.zframe.run.entity.SchedulingAssociatedDetailExample;
import com.qz.zframe.run.service.NewSchedulingAssociatedService;

@Service
public class NewSchedulingAssociatedServiceImpl implements NewSchedulingAssociatedService {

	@Autowired
	private NewSchedulingAssociatedMapper schedulingAssociatedMapper;

	@Autowired
	private SchedulingAssociatedDetailMapper schedulingAssociateDetailMapper;

	@Autowired
	private CurrentUserService currentUserService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getSchedulingAssociatedList(NewSchedulingAssociatedExample example) {
		NewPageResult newPageResult = new NewPageResult();
		int count = schedulingAssociatedMapper.countByExample(example);
		newPageResult.setTotal(count);
		List<NewSchedulingAssociated> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = schedulingAssociatedMapper.selectByExample(example);
		}
		newPageResult.setCode(ErrorCode.SUCCESS);
		newPageResult.setRows(list);
		return newPageResult;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult<NewSchedulingAssociated> getSchedulingAssociatedDetail(String associatedId) {
		NewPageResult result = new NewPageResult();
		NewSchedulingAssociated newSchedulingAssociated = schedulingAssociatedMapper.selectByPrimaryKey(associatedId);
		if (newSchedulingAssociated == null) {
			result.setCode(ErrorCode.ERROR);
			result.setMsg("传入的排班管理Id不存在");
		} else {
			SchedulingAssociatedDetailExample example = new SchedulingAssociatedDetailExample();
			example.createCriteria().andAssociatedIdEqualTo(newSchedulingAssociated.getAssociatedId());
			List<SchedulingAssociatedDetail> details = schedulingAssociateDetailMapper.selectByExample(example);
			if (details.size() > 0) {
				newSchedulingAssociated.setDetails(details);
			}
			result.setCode(ErrorCode.SUCCESS);
			result.setTotal(1);
			result.setRows(newSchedulingAssociated);
		}
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity saveSchedulingAssociated(NewSchedulingAssociated newSchedulingAssociated) {
		ResultEntity resultEntity = new ResultEntity();
		try {
			if (StringUtils.isBlank(newSchedulingAssociated.getWindCode())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("风电场不可为空");
				return resultEntity;
			}
			if (StringUtils.isBlank(newSchedulingAssociated.getAssociatedName())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("排班表名称不可为空");
				return resultEntity;
			}else{
				if(CheckAssociatedIsExit(newSchedulingAssociated.getAssociatedId(),newSchedulingAssociated.getAssociatedName())){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("排班表名称已存在");
					return resultEntity;
				}
			}
			if (newSchedulingAssociated.getDetails() == null || newSchedulingAssociated.getDetails().isEmpty()) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("排班明细不可为空 ");
				return resultEntity;
			}
			
			String associatedId = UUIdUtil.getUUID();
			int i = 0;
			List<AssociatedDetailDate> list = new ArrayList<>();
			for (SchedulingAssociatedDetail s : newSchedulingAssociated.getDetails()) {
				i++;
				if (StringUtils.isBlank(s.getSchedulingRuleId())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("排班规则Id不可为空");
					return resultEntity;
				}
				if (StringUtils.isBlank(s.getStartDate().toString())
						|| StringUtils.isBlank(s.getEndDate().toString())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 开始日期或结束日期不可为空");
					return resultEntity;
				}
				s.setSort(String.valueOf(i));
				s.setAssociatedId(associatedId);
				s.setAssociatedDetailId(UUIdUtil.getUUID());
				if(s.getStartDate().getTime()>s.getEndDate().getTime()){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 开始日期不可大于结束日期");
					return resultEntity;
				}
				AssociatedDetailDate associatedDetailDate = new AssociatedDetailDate();
				associatedDetailDate.setStartDate(s.getStartDate());
				associatedDetailDate.setEndDate(s.getEndDate());
				list.add(associatedDetailDate);	
				for (int x = 0; x < list.size() - 1; x++) {
					for (int j = x + 1; j < list.size(); j++) {
						if (list.get(x).getStartDate().getTime() <= list.get(j).getEndDate().getTime()
								&& list.get(x).getEndDate().getTime() > list.get(j).getStartDate().getTime()) {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 日期范围出现重叠，请重新选择");
							return resultEntity;
						}
					}

				}
			}
			String associatedCode = aCode(schedulingAssociatedMapper.selectMaxCoder());
			newSchedulingAssociated.setIsDelete("01");
			newSchedulingAssociated.setAssociatedId(associatedId);
			newSchedulingAssociated.setCreater(currentUserService.getId());
			newSchedulingAssociated.setCreateTime(new Date());
			newSchedulingAssociated.setAssociatedCode(associatedCode);
			schedulingAssociatedMapper.insertSelective(newSchedulingAssociated);
			schedulingAssociateDetailMapper.insertList(newSchedulingAssociated.getDetails());
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
		}
		return resultEntity;
	}

	private boolean CheckAssociatedIsExit(String associatedId, String associatedName) {
		NewSchedulingAssociatedExample example = new NewSchedulingAssociatedExample();
		if(StringUtils.isBlank(associatedId)){
			example.createCriteria().andAssociatedNameEqualTo(associatedName).andIsDeleteEqualTo("01");
		}else{
			example.createCriteria().andAssociatedNameEqualTo(associatedName).andIsDeleteEqualTo("01").andAssociatedIdNotEqualTo(associatedId);
		}
		int count = schedulingAssociatedMapper.countByExample(example);
		if(count>0){
			return true;
		}else{
		return false;
		}
	}

	public String aCode(String maxcode) {
		String billCode = "";
		if (StringUtils.isBlank(maxcode)) {
			billCode = "42" + "000001";
			return billCode;
		} else {
			String oldCode = maxcode.substring(maxcode.length() - 6, maxcode.length());
			String newCode = makeCode(oldCode);
			billCode = "42" + newCode;
			return billCode;
		}
	}

	private String makeCode(String oldCode) {
		String newCode = String.valueOf(Integer.parseInt(oldCode) + 1);
		switch (newCode.length()) {
		case 1:
			newCode = "00000" + newCode;
			break;
		case 2:
			newCode = "0000" + newCode;
			break;

		case 3:
			newCode = "000" + newCode;
			break;
		case 4:
			newCode = "00" + newCode;
			break;
		case 5:
			newCode = "0" + newCode;
			break;
		default:
			break;
		}
		return newCode;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity editSchedulingAssociated(NewSchedulingAssociated newSchedulingAssociated) {
		ResultEntity resultEntity = new ResultEntity();
		try {
			if (StringUtils.isBlank(newSchedulingAssociated.getWindCode())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("风电场不可为空");
				return resultEntity;
			}
			if (StringUtils.isBlank(newSchedulingAssociated.getAssociatedName())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("排班表名称不可为空");
				return resultEntity;
			}else{
				if(CheckAssociatedIsExit(newSchedulingAssociated.getAssociatedId(),newSchedulingAssociated.getAssociatedName())){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("排班表名称已存在");
					return resultEntity;
				}
			}
			if (newSchedulingAssociated.getDetails() == null || newSchedulingAssociated.getDetails().isEmpty()) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("排班明细不可为空 ");
				return resultEntity;
			}
			int i = 0;
			List<AssociatedDetailDate> list = new ArrayList<>();
			for (SchedulingAssociatedDetail s : newSchedulingAssociated.getDetails()) {
				i++;
				if (StringUtils.isBlank(s.getSchedulingRuleId())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("排班规则Id不可为空");
					return resultEntity;
				}
				if (StringUtils.isBlank(s.getStartDate().toString())
						|| StringUtils.isBlank(s.getEndDate().toString())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 开始日期或结束日期不可为空");
					return resultEntity;
				}
				s.setSort(String.valueOf(i));
				s.setAssociatedId(newSchedulingAssociated.getAssociatedId());
				s.setAssociatedDetailId(UUIdUtil.getUUID());
				if(s.getStartDate().getTime()>s.getEndDate().getTime()){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 开始日期不可大于结束日期");
					return resultEntity;
				}
				for (int x = 0; x < list.size() - 1; x++) {
					for (int j = x + 1; j < list.size(); j++) {
						if (list.get(x).getStartDate().getTime() <= list.get(j).getEndDate().getTime()
								&& list.get(x).getEndDate().getTime() > list.get(j).getStartDate().getTime()) {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("规则编码:" + s.getSchedulingRuleCode() + " 日期范围出现重叠，请重新选择");
							return resultEntity;
						}
					}

				}
			}
			schedulingAssociatedMapper.updateByPrimaryKeySelective(newSchedulingAssociated);
			schedulingAssociateDetailMapper.deleteByPrimaryKey(newSchedulingAssociated.getAssociatedId());
			schedulingAssociateDetailMapper.insertList(newSchedulingAssociated.getDetails());
			resultEntity.setCode(ErrorCode.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultEntity.setCode(ErrorCode.ERROR);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity delAssociatedDetail(List<String> associatedDetailIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(associatedDetailIds==null&&associatedDetailIds.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("排班详情id不可为空");
			return resultEntity;
		}
		int count = schedulingAssociateDetailMapper.deleteDetails(associatedDetailIds);
		if (count > 0) {
			NewSchedulingAssociatedExample example = new NewSchedulingAssociatedExample();
			example.createCriteria().andIsDeleteEqualTo("01").andDetailAssociatedIdIsNull();
			List<NewSchedulingAssociated> list = schedulingAssociatedMapper.selectByExample(example);
			List<String> associatedIds = new ArrayList<>();
			if (list.size() > 0) {
				for (NewSchedulingAssociated info : list) {
					associatedIds.add(info.getAssociatedId());
				}
				schedulingAssociatedMapper.updateIsDelete(associatedIds);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");

		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
		}
		return resultEntity;
	}

}
