package com.qz.zframe.material.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.DataDictType;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.MaterialGroupMapper;
import com.qz.zframe.material.dao.MaterialMapper;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.MaterialGroupExample;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialGroupService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialGroupServiceImpl implements MaterialGroupService {

	
	@Autowired
	private MaterialGroupMapper materialGroupMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@Autowired
	private DataDictService dataDictService;
	
	@Autowired
	private MaterialMapper materialMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getGroupList(MaterialGroupExample materialGroupExample) throws Exception {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = materialGroupMapper.countByExample(materialGroupExample);
		pageResultEntity.setTotal(count);
		List<MaterialGroup> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialGroupMapper.selectByExample(materialGroupExample);
			list=makeCodeType(list);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}
	
	private List<MaterialGroup> makeCodeType(List<MaterialGroup> list) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("MATERIAL_GROUP_STATUS");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
			for(MaterialGroup m : list) {
				for(DataDict d : dataDicts) {
					if ("MATERIAL_GROUP_STATUS".equals(d.getCodeTypeName()) && m.getStatus().equals(d.getName())) {
						m.setGroupStatusText(d.getTitle());
					}
				}
			}
		}
		return list;
	}
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntity getGroupdetailById(String materialGroupId) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
//		MaterialGroup materialGroup = materialGroupMapper.selectByPrimaryKey(materialGroupId);
		MaterialGroupExample example = new MaterialGroupExample();
		example.createCriteria().andMaterialGroupIdEqualTo(materialGroupId);
		List<MaterialGroup> list= materialGroupMapper.selectByExample(example);
		if(list==null&&list.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组信息不存在");
		}else{
		 list=makeCodeType(list);
		 resultEntity.setCode(ErrorCode.SUCCESS);
		 resultEntity.setData(list.get(0));
		}

		return resultEntity;
	}

	@Override
	public ResultEntity addGroup(MaterialGroup materialGroup) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(materialGroup.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请选择启用或停用");
			return resultEntity;
		}
		if (StringUtils.isBlank(materialGroup.getGroupName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请输入物资组名称");
			return resultEntity;
		} else {
			if (checkGroupIsExitByName(materialGroup)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资组名称重复");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(materialGroup.getGroupCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请输入物资组编码");
			return resultEntity;
		} else {
			if (checkGroupIsExitByCode(materialGroup)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资组编码重复");
				return resultEntity;
			}
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		materialGroup.setCreater(userInfo.getUserId());
		materialGroup.setMaterialGroupId(UUIdUtil.getUUID());
		materialGroup.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		materialGroup.setCreateTime(new Date());
		materialGroupMapper.insertSelective(materialGroup);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		return resultEntity;
	}

	/**
	 * 根据物资分组编码判断是否存在
	 */
	private boolean checkGroupIsExitByCode(MaterialGroup materialGroup) {
		MaterialGroupExample example = new MaterialGroupExample();
	
		if (!StringUtils.isBlank(materialGroup.getMaterialGroupId())) {
			example.createCriteria().andMaterialGroupIdNotEqualTo(materialGroup.getMaterialGroupId()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupCodeEqualTo(materialGroup.getGroupCode());
		}else{
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupCodeEqualTo(materialGroup.getGroupCode());
		}
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
	public boolean checkGroupIsExitByName(MaterialGroup materialGroup) {
		MaterialGroupExample example = new MaterialGroupExample();
		if (!StringUtils.isBlank(materialGroup.getMaterialGroupId())) {
			example.createCriteria().andMaterialGroupIdNotEqualTo(materialGroup.getMaterialGroupId()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupNameEqualTo(materialGroup.getGroupName());
		}else{
			example.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andGroupNameEqualTo(materialGroup.getGroupName());
		}
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
		if (StringUtils.isBlank(materialGroup.getMaterialGroupId())) {		
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组Id不存在");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(materialGroup.getGroupName())) {		
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组名称不可为空");
			return resultEntity;
		}
		
		if (StringUtils.isBlank(materialGroup.getGroupCode())) {		
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资组编码不可为空");
			return resultEntity;
		}
		if (materialGroupInfo != null) {
			if (!materialGroupInfo.getGroupName().equals(materialGroup)) {
				if (checkGroupIsExitByName(materialGroup)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资组名称重复");
					return resultEntity;
				}
			}
			if (!materialGroupInfo.getGroupCode().equals(materialGroup.getGroupCode())) {
				if (checkGroupIsExitByCode(materialGroup)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资组编码重复");
					return resultEntity;
				}
			}
		}
		materialGroupMapper.updateByPrimaryKeySelective(materialGroup);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("编辑成功");
		return resultEntity;
	}

	@Override
	public ResultEntity delGroup(List<String> materialGroupIds) {
		ResultEntity resultEntity = new ResultEntity();
		MaterialExample materialExample = new MaterialExample();
		materialExample.createCriteria().andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andMaterialGroupIdIn(materialGroupIds);
		int count=materialMapper.countByExample(materialExample);
		if(count>0){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("所选物资组下包含物资，无法删除");
			return resultEntity;
		}
		
		Map<String, Object> params = new HashMap<>(2);
		params.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
		params.put("materialGroupIds", materialGroupIds);
		materialGroupMapper.updateIsdete(params);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

}
