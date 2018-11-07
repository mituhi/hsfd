package com.qz.zframe.material.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.dao.MaterialGroupMapper;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.MaterialGroupExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialGroupService;

@Service
public class MaterialGroupServiceImpl implements MaterialGroupService {

	@Autowired
	private MaterialGroupMapper materialGroupMapper;

	@Override
	public PageResultEntity getGroupList(MaterialGroupExample materialGroupExample) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		int count = materialGroupMapper.countByExample(materialGroupExample);
		pageResultEntity.setTotal(count);
		List<MaterialGroup> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialGroupMapper.selectByExample(materialGroupExample);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Override
	public ResultEntity getGroupdetailById(String materialGroupId) {
		ResultEntity resultEntity = new ResultEntity();
		MaterialGroup materialGroup = materialGroupMapper.selectByPrimaryKey(materialGroupId);
		if (materialGroup == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分组id不存在");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(materialGroup);
		}

		return resultEntity;
	}

	@Override
	public ResultEntity addGroup(MaterialGroup materialGroup) {
		ResultEntity resultEntity = new ResultEntity();
		if (checkGroupIsExitByName(materialGroup.getGroupName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组名称重复");
			return resultEntity;
		}
		if (checkGroupIsExitByCode(materialGroup.getGroupCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组编码重复");
			return resultEntity;
		}
		materialGroupMapper.insertSelective(materialGroup);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	/**
	 * 根据物资分组编码判断是否存在
	 */
	private boolean checkGroupIsExitByCode(String groupCode) {
		MaterialGroupExample example = new MaterialGroupExample();
		example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupCodeEqualTo(groupCode);
		int count = materialGroupMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据物资分组名称判断是否存在重复
	 */
	public boolean checkGroupIsExitByName(String getGroupName) {
		MaterialGroupExample example = new MaterialGroupExample();
		example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupNameEqualTo(getGroupName);
		int count = materialGroupMapper.countByExample(example);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ResultEntity editGroup(MaterialGroup materialGroup) {
		ResultEntity resultEntity = new ResultEntity();
		MaterialGroup materialGroupInfo = materialGroupMapper.selectByPrimaryKey(materialGroup.getMaterialGroupId());
		if (materialGroupInfo != null) {
			if (!materialGroupInfo.getGroupName().equals(materialGroup.getGroupName())) {
				if (checkGroupIsExitByName(materialGroup.getGroupName())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资组名称重复");
					return resultEntity;
				}
			}
			if (!materialGroupInfo.getGroupCode().equals(materialGroup.getGroupCode())) {
				if (checkGroupIsExitByCode(materialGroup.getGroupCode())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资组编码重复");
					return resultEntity;
				}
			}
		}
		materialGroupMapper.updateByPrimaryKeySelective(materialGroup);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public ResultEntity delGroup(List<String> materialGroupIds) {
		ResultEntity resultEntity = new ResultEntity();
		Map<String, Object> params = new HashMap<>(2);
		params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
		params.put("materialGroupIds", materialGroupIds);
		materialGroupMapper.updateIsdete(params);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

}
