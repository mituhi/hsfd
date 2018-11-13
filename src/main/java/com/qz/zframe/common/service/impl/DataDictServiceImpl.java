package com.qz.zframe.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qz.zframe.common.dao.DataDictDao;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.DataDictType;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;

@Service
public class DataDictServiceImpl implements DataDictService {
	
	@Autowired
	private DataDictDao codeDao;
	
	@Override
	public PageResultEntity queryCode(String codeType, Integer page, Integer size) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex  = (page - 1) * size;
		//到第几条数据结束
		int lastIndex = page * size;
		List<DataDict> list = codeDao.findCodeByCodeType(codeType, firstIndex, lastIndex);
		if (list == null || list.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			Integer num = codeDao.findCodeByCodeTypeNum(codeType);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	@Override
	public DataDictType addAndUpdateCodeType(DataDictType dataDictType) throws Exception {
		if (dataDictType == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(dataDictType.getName())) {
			throw new Exception("分类编码为空!");
		}
		if (StringUtils.isBlank(dataDictType.getId())) {
			DataDictType ddt = codeDao.findCodeTypeByType(dataDictType.getName());
			if (ddt != null) {
				throw new Exception("分类编码已存在!");
			}
			String id = codeDao.findMaxCodeTypeId();
			if (StringUtils.isBlank(id)) {
				id = "1001";
			}else {
				Integer idInt = Integer.valueOf(id);
				id = (idInt + 1) + "";
			}
			dataDictType.setId(id);
			codeDao.addCodeType(dataDictType);
		}else {
			codeDao.updateCodeType(dataDictType);
		}
		return dataDictType;
	}

	@Override
	@Transactional
	public Integer deleteCodeType(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("请选择删除数据！");
		}
		codeDao.deleteCodeType(ids);
		codeDao.deleteCode(ids);
		return 1;
	}
	
	@Override
	public Integer deleteCode(List<String> ids) throws Exception {
		if (ids == null || ids.isEmpty()) {
			throw new Exception("请选择删除数据！");
		}
		return codeDao.deleteCode(ids);
	}

	@Override
	public PageResultEntity queryCodeType(String codeType, Integer page, Integer size) {
		PageResultEntity pageResultEntity = new PageResultEntity();
		//从第几条数据开始
		int firstIndex  = (page - 1) * size;
		//到第几条数据结束
		int lastIndex = page * size;
		List<DataDictType> list = codeDao.findCodeTypeByCodeType(codeType, firstIndex, lastIndex);
		if (list == null || list.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(null);
			pageResultEntity.setTotal(0);
		}else {
			Integer num = codeDao.findCodeTypeByCodeTypeNum(codeType);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			pageResultEntity.setRows(list);
			pageResultEntity.setTotal(num);
		}
		return pageResultEntity;
	}

	@Override
	public DataDict addAndUpdateCode(DataDict dataDict) throws Exception {
		if (dataDict == null) {
			throw new Exception("对象为空!");
		}
		if (StringUtils.isBlank(dataDict.getName())) {
			throw new Exception("编码编号为空!");
		}
		if (StringUtils.isBlank(dataDict.getCodeTypeId())) {
			throw new Exception("编码类型为空!");
		}
		if (StringUtils.isBlank(dataDict.getId())) {
			DataDict dd = codeDao.findCodeByCodeTypeIdAndName(dataDict.getCodeTypeId(),dataDict.getName());
			if (dd != null) {
				throw new Exception("编码已存在!");
			}
			Map<String, Object> idAndSort = codeDao.findMaxCodeIdAndSort(dataDict.getCodeTypeId());
			String id = "";
			int sort = 0;
			if (idAndSort != null && !idAndSort.isEmpty()) {
				id = idAndSort.get("id").toString();
				Integer idInt = Integer.valueOf(id);
				id = (idInt + 1) + "";
				
				sort = Integer.valueOf(idAndSort.get("disp_order").toString());
				sort = sort+1;
			}else {
				id = dataDict.getCodeTypeId() + "01";
				sort = 1;
			}
			dataDict.setId(id);
			dataDict.setDispOrder(sort);
			codeDao.addCode(dataDict);
		}else {
			codeDao.updateCode(dataDict);
		}
		return dataDict;
	}

	@Override
	public DataDict queryCodeById(String id) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception("请选择编码信息!");
		}
		return codeDao.queryCodeById(id);
	}

	@Override
	public DataDictType queryCodeTypeById(String id) throws Exception {
		if (StringUtils.isBlank(id)) {
			throw new Exception("请选择编码信息!");
		}
		return codeDao.queryCodeTypeById(id);
	}

}
