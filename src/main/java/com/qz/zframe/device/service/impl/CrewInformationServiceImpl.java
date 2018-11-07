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
import com.qz.zframe.device.dao.CrewInformationMapper;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.device.service.CrewInformationService;
@Service
@Transactional(rollbackFor = Exception.class)
public class CrewInformationServiceImpl implements CrewInformationService {
	@Autowired
	 private CrewInformationMapper crewInformationMapper;
	@Override
	public PageResultEntity findCrew(CrewInformationExample crewExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = crewInformationMapper.countByExample(crewExample);
		resultEntity.setTotal(count);
		List<CrewInformation> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list =crewInformationMapper.selectByExample(crewExample);
		}
		resultEntity.setCode(0);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addCrew(CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		crew.setCrewId(UUIdUtil.getUUID());
		int save = crewInformationMapper.insert(crew);
		if (save == 0) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("新增失败");
		} else {
			resultEntity.setCode(0);
			resultEntity.setMsg("新增成功");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateCrew(CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		CrewInformation crews = crewInformationMapper.selectByPrimaryKey(crew.getCrewId());
		if (crews == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = crewInformationMapper.update(crew);
			if (save == 0) {
				resultEntity.setCode(-1);
				resultEntity.setMsg("修改失败");
			} else {
				resultEntity.setCode(0);
				resultEntity.setMsg("修改成功");
			}
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByCrewId(String crewId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<CrewInformation> list = new ArrayList<CrewInformation>();
		CrewInformation crews = crewInformationMapper.selectByPrimaryKey(crewId);
		if (crews == null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(crews);
			resultEntity.setCode(0);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteCrew(List<String> crewIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = crewInformationMapper.deleteByPrimaryKeyList(crewIds);
		if (delete < 0) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(0);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

}
