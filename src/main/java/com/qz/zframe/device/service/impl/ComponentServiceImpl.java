package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.ComponentsMapper;
import com.qz.zframe.device.dao.OutputParametersMapper;
import com.qz.zframe.device.entity.Components;
import com.qz.zframe.device.entity.ComponentsExample;
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.service.ComponentService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ComponentServiceImpl implements ComponentService {
	@Autowired
	private ComponentsMapper componentsMapper;
	@Override
	public PageResultEntity findComponent(ComponentsExample componentsExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = componentsMapper.countByExample(componentsExample);
		resultEntity.setTotal(count);
		List<Components> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = componentsMapper.selectByExample(componentsExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity deleteComponent(List<String> componentsIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(componentsIds!=null && !componentsIds.isEmpty()) {
		int delete = componentsMapper.deleteByPrimaryKeyList(componentsIds);
		if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据进行删除");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addComponent(Components components) {
		ResultEntity resultEntity = new ResultEntity();
		components.setComponentId(UUIdUtil.getUUID());
		int save = componentsMapper.insert(components);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateComponent(Components components) {
		ResultEntity resultEntity = new ResultEntity();
		Components com = componentsMapper.selectByPrimaryKey(components.getComponentId());
		if (com == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = componentsMapper.updateByPrimaryKey(components);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
				return resultEntity;
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findById(String componentId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<Components > list = new ArrayList<Components>();
		Components com = componentsMapper.selectByPrimaryKey(componentId);
		if (com == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
			return resultEntity;
		} else {
			list.add(com);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

}
