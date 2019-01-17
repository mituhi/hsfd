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
	public PageResultEntity addAndUpdateCodeType(DataDictType dataDictType) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (dataDictType == null) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("对象为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(dataDictType.getName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("分类编码为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(dataDictType.getId())) {
			DataDictType ddt = codeDao.findCodeTypeByType(dataDictType.getName());
			if (ddt != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("分类编码已存在!");
				return pageResultEntity;
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
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}else {
			codeDao.updateCodeType(dataDictType);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}
	}

	@Override
	@Transactional
	public PageResultEntity deleteCodeType(List<String> ids) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (ids == null || ids.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("请选择删除数据！");
			return pageResultEntity;
		}
		codeDao.deleteCodeType(ids);
		codeDao.deleteCode(ids);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
	}
	
	@Override
	public PageResultEntity deleteCode(List<String> ids) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (ids == null || ids.isEmpty()) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("请选择删除数据！");
			return pageResultEntity;
		}
		codeDao.deleteCode(ids);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		return pageResultEntity;
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
	public PageResultEntity addAndUpdateCode(DataDict dataDict) throws Exception {
		PageResultEntity pageResultEntity = new PageResultEntity();
		if (dataDict == null) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("对象为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(dataDict.getName())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("编码编号为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(dataDict.getCodeTypeId())) {
			pageResultEntity.setCode(ErrorCode.ERROR);
			pageResultEntity.setMsg("编码类型为空!");
			return pageResultEntity;
		}
		if (StringUtils.isBlank(dataDict.getId())) {
			DataDict dd = codeDao.findCodeByCodeTypeIdAndName(dataDict.getCodeTypeId(),dataDict.getName());
			if (dd != null) {
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("编码已存在!");
				return pageResultEntity;
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
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}else {
			codeDao.updateCode(dataDict);
			pageResultEntity.setCode(ErrorCode.SUCCESS);
			return pageResultEntity;
		}
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

	@Override
	public List<DataDict> findDataDictsByCodeType(List<String> codeTypes) throws Exception {
		if (codeTypes == null || codeTypes.isEmpty()) {
			throw new Exception("标准代码类型不能为空");
		}
		return codeDao.findDataDictsByCodeType(codeTypes);
	}

	@Override
	public List<DataDict> queryCodeList(String codeType) {
		return codeDao.queryCodeList(codeType);
	}

	@Override
	public DataDict findDataDictByCodeAndType(String codeType, String name) throws Exception {
		if (StringUtils.isBlank(codeType)) {
			throw new Exception("分类编码不能为空");
		}
		if (StringUtils.isBlank(name)) {
			throw new Exception("资源id不能为空");
		}
		return codeDao.findDataDictByCodeAndType(codeType, name);
	}

}
