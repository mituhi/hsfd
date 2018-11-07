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
import com.qz.zframe.device.dao.PositionEncodeMapper;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;
import com.qz.zframe.device.service.PositionEncodeService;
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionEncodeServiceImpl implements PositionEncodeService {
	@Autowired
	private PositionEncodeMapper positionMapper;

	@Override
	public PageResultEntity findPosition(PositionEncodeExample position) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = positionMapper.countByExample(position);
		resultEntity.setTotal(count);
		List<PositionEncode> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = positionMapper.selectByExample(position);
		}
		resultEntity.setCode(0);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addPosition(PositionEncode positionEncode) {
		ResultEntity resultEntity = new ResultEntity();
		positionEncode.setPositionId(UUIdUtil.getUUID());
		int save = positionMapper.insert(positionEncode);
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
	public ResultEntity updatePosition(PositionEncode positionEncode) {
		ResultEntity resultEntity = new ResultEntity();
		PositionEncode position = positionMapper.selectByPrimaryKey(positionEncode.getPositionId());
		if (position == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			int save = positionMapper.updateByPrimaryKey(positionEncode);
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
	public PageResultEntity findByPositionId(String positionId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<PositionEncode> list = new ArrayList<PositionEncode>();
		PositionEncode position = positionMapper.selectByPrimaryKey(positionId);
		if (position == null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("查询结果有误");
		} else {
			list.add(position);
			resultEntity.setCode(0);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deletePositions(List<String> positionIds) {
		ResultEntity resultEntity = new ResultEntity();
		int delete = positionMapper.deleteByPrimaryKeyList(positionIds);
		if (delete < 0) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("删除失败");
		} else {
			resultEntity.setCode(0);
			resultEntity.setMsg("删除成功");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructure() {
		PageResultEntity resultEntity = new PageResultEntity();

		List<PositionEncode> top = positionMapper.selectStructure();
		if (top == null) {
			resultEntity.setCode(-1);
			resultEntity.setMsg("还未创建顶层设备分类");
		} else {
			resultEntity.setCode(0);
			resultEntity.setRows(top);
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructureList(String superiorPosition) {
		PageResultEntity resultEntity = new PageResultEntity();

		List<PositionEncode> list = positionMapper.selectStructureList(superiorPosition);
		if (list != null) {
			resultEntity.setCode(0);
			resultEntity.setRows(list);
		} else {
			resultEntity.setCode(-1);
			resultEntity.setMsg("还未创建设备分类");
		}
		return resultEntity;
	}

}
