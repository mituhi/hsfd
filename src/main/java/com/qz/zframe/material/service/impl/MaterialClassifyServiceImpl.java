package com.qz.zframe.material.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.material.dao.MaterialClassifyMapper;
import com.qz.zframe.material.dao.MaterialMapper;
import com.qz.zframe.material.entity.MaterialClassify;
import com.qz.zframe.material.entity.MaterialClassifyExample;
import com.qz.zframe.material.entity.MaterialExample;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.enums.EnableStatusEnum;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.MaterialClassifyService;

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialClassifyServiceImpl implements MaterialClassifyService {

	private static Logger logger = LoggerFactory.getLogger(MaterialClassifyServiceImpl.class);
	
	@Autowired
	private CurrentUserService currentUSerservice;

	@Autowired
	private MaterialClassifyMapper materialClassifyMapper;
	
	@Autowired
	private DataDictService dataDictService;
	
	@Autowired
	private MaterialMapper materialMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult<MaterialClassify> getClassifyList(MaterialClassifyExample example) throws Exception {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = materialClassifyMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<MaterialClassify> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = materialClassifyMapper.selectByExample(example);
			list=makeCodeType(list);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}
	
	
	private List<MaterialClassify> makeCodeType(List<MaterialClassify> list) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("MATERIAL_CLASSIFICATION_STATUS");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
			for(MaterialClassify m : list) {
				for(DataDict d : dataDicts) {
					if ("MATERIAL_CLASSIFICATION_STATUS".equals(d.getCodeTypeName()) && m.getStatus().equals(d.getName())) {
						m.setStatusText(d.getTitle());
					}
				}
			}
		}
		return list;
	}
	

	@Override
	public ResultEntity addClassify(MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(materialClassify.getClassifyName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(materialClassify.getClassifyDescribe())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("分类描述不可为空");
			return resultEntity;
		}
		
		if (checkByClassifyNameIsExit(materialClassify)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类已存在");
			return resultEntity;
		}
		if(StringUtils.isBlank(materialClassify.getIsTop())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请传入是否顶级");
			return resultEntity;
		}
		if(StringUtils.isBlank(materialClassify.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请选择启用或停用");
			return resultEntity;
		}
		if (materialClassify.getIsTop().equals(EnableStatusEnum.ENABLE_STOP.getCode())) {
			if (StringUtils.isBlank(materialClassify.getSuperiorClassifyId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("当物资分类为非顶级时，必须传入上级类型");
				return resultEntity;
			}
		}
//		if(materialClassify.getIsTop().equals("01")){
//			materialClassify.setSort(1);
//		}
//		if(materialClassify.getIsTop().equals("02")){
//			MaterialClassify  superClassify=materialClassifyMapper.selectByPrimaryKey(materialClassify.getSuperiorClassifyId());
//			if(superClassify.getSort()>=5){
//				resultEntity.setCode(ErrorCode.ERROR);
//				resultEntity.setMsg("超出层级上限");
//				return resultEntity;
//			}else{
//				materialClassify.setSort(superClassify.getSort()+1);
//			}
//		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		materialClassify.setCreater(userInfo.getUserId());
		materialClassify.setMaterialClassifyId(UUIdUtil.getUUID());
		materialClassify.setIsDelete(IsDeleteEnum.DELETE_NO.getCode());
		materialClassifyMapper.insertSelective(materialClassify);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		return resultEntity;
	}

	/**
	 * 判断物资分类是否重复
	 */
	private Boolean checkByClassifyNameIsExit(MaterialClassify materialClassify) {
		MaterialClassifyExample example = new MaterialClassifyExample();
		if(StringUtils.isBlank(materialClassify.getMaterialClassifyId())){
			example.createCriteria().andClassifyNameEqualTo(materialClassify.getClassifyName()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());	
		}else{
			example.createCriteria().andClassifyNameEqualTo(materialClassify.getClassifyName()).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode()).andMaterialClassifyIdEqualTo(materialClassify.getMaterialClassifyId());	
		}
		int count = materialClassifyMapper.countByExample(example);	
		if (count > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getClassifyDetail(String materialClassifyId) throws Exception {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
		MaterialClassify materialClassify = materialClassifyMapper.selectByPrimaryKey(materialClassifyId);
		if (materialClassify == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不存在");
			logger.debug("物资分类Id{}" + materialClassifyId);
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setData(makeCodeTypeDetail(materialClassify));
		}
		return resultEntity;
	}
	
	
	private MaterialClassify makeCodeTypeDetail(MaterialClassify m) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("MATERIAL_CLASSIFICATION_STATUS");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
				for(DataDict d : dataDicts) {
					if ("MATERIAL_CLASSIFICATION_STATUS".equals(d.getCodeTypeName()) && m.getStatus().equals(d.getName())) {
						m.setStatusText(d.getTitle());
					}
				}
		}
		return m;
	}
	
	

	@Override
	public ResultEntity editClassify(MaterialClassify materialClassify) {
		ResultEntity resultEntity = new ResultEntity();
		if(StringUtils.isBlank(materialClassify.getClassifyName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("物资分类不可为空");
			return resultEntity;
		}
		
		if(StringUtils.isBlank(materialClassify.getClassifyDescribe())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("分类描述不可为空");
			return resultEntity;
		}
		
		MaterialClassify materialClassifyInfo = materialClassifyMapper.selectByPrimaryKey(materialClassify.getMaterialClassifyId());
		if(materialClassifyInfo==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("传入正确的物资分类Id");
			return resultEntity;
		}
		if(materialClassifyInfo!=null){
			if(!materialClassifyInfo.getClassifyName().equals(materialClassify.getClassifyName())){
				if(checkByClassifyNameIsExit(materialClassify)){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("物资分类已存在");
					return resultEntity;
				}
			}	
		}
		if(materialClassifyInfo.getIsTop().equals("01")&&materialClassify.getIsTop().equals("02")){
			MaterialClassifyExample example = new MaterialClassifyExample();
			example.createCriteria().andSuperiorClassifyIdEqualTo(materialClassify.getMaterialClassifyId()).andIsDeleteEqualTo("01");
	        int count = materialClassifyMapper.countByExample(example);
	        if(count>0){
	        	resultEntity.setCode(ErrorCode.ERROR);
	        	resultEntity.setMsg("该物资分类下含有子级分类，请删除所含子级分类后再选择上级分类");
	        	return resultEntity;
	        }
		}
				
		if(materialClassify.getMaterialClassifyId().equals(materialClassify.getSuperiorClassifyId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("与上级物资分类产生冲突，请选择其他分类");
			return resultEntity;
		}
		if(materialClassify.getIsTop().equals("01")){
			materialClassify.setSort(1);
			materialClassify.setSuperiorClassifyId("");
			MaterialClassify materialClassify2 = new MaterialClassify();
			materialClassify2.setStatus(materialClassify.getStatus());
			materialClassify2.setSuperiorClassifyId(materialClassify.getMaterialClassifyId());
			materialClassifyMapper.updateByIsTopSelective(materialClassify2);	
		}	
//		if(materialClassify.getIsTop().equals("02")){
//			MaterialClassify  superClassify=materialClassifyMapper.selectByPrimaryKey(materialClassify.getSuperiorClassifyId());
//			if(superClassify.getSort()>=5){
//				resultEntity.setCode(ErrorCode.ERROR);
//				resultEntity.setMsg("超出层级上限");
//				return resultEntity;
//			}else{
//				materialClassify.setSort(superClassify.getSort()+1);
//			}
//		}
		if(materialClassify.getIsTop().equals("01")){
			materialClassify.setIsTop("");
		}
		materialClassifyMapper.updateByPrimaryKeySelective(materialClassify);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("编辑成功");
		return resultEntity;
	}

	@Override
	public ResultEntity delClassify(List<String> materialClassifyIds) {
		ResultEntity resultEntity = new ResultEntity();
		for(String materialClassifyId:materialClassifyIds){
			MaterialClassifyExample example = new MaterialClassifyExample();
			example.createCriteria().andSuperiorClassifyIdEqualTo(materialClassifyId).andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
			int count=materialClassifyMapper.countByExample(example);
			if(count>0){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("删除顶级分类之前请删除所属子级分类");
				return resultEntity;
			}
			MaterialExample materialExample = new MaterialExample();
			materialExample.createCriteria().andMaterialClassifyIdEqualTo(materialClassifyId);
			int mateialCount = materialMapper.countByExample(materialExample);
			if(mateialCount>0){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("所选物资分类下包含物资，无法删除");
				return resultEntity;
			}
			
		}	
	    Map<String, Object> params2 = new HashMap<>(2);
	    params2.put("isDelete", IsDeleteEnum.DELETE_YES.getCode());
	    params2.put("materialClassifyIds", materialClassifyIds);
		materialClassifyMapper.updateIsdete(params2);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getClassifyListAll(MaterialClassifyExample example) {
		NewPageResult newPageResult = new NewPageResult<>();
		int count = materialClassifyMapper.countByExample(example);
		newPageResult.setTotal(count);
		List<MaterialClassify> list;
		if (count == 0) {
			list = Collections.emptyList();
			newPageResult.setRows(list);
		} else {
			list = materialClassifyMapper.selectByExample(example);
			List<MaterialClassify> list1 = new ArrayList<MaterialClassify>();
			List<MaterialClassify> list2 = new ArrayList<MaterialClassify>();
			for (MaterialClassify m : list) {
				if (m.getIsTop().equals("01")) {
					list1.add(m);
				}
				if (m.getIsTop().equals("02")) {
					list2.add(m);
				}
//				if (m.getSort() == 3) {
//					list3.add(m);
//				}
//				if (m.getSort() == 4) {
//					list4.add(m);
//				}
//				if (m.getSort() == 5) {
//					list5.add(m);
//				}

			}
			list1 = makeTree(list2, list1);
			newPageResult.setRows(list1);
		}
		newPageResult.setCode(ErrorCode.SUCCESS);
		return newPageResult;
	}

	private List<MaterialClassify> makeTree(List<MaterialClassify> list5, List<MaterialClassify> list4) {
			for(MaterialClassify p : list4) {
				if(p==null) {
					break;
				}else {
				List<MaterialClassify> list6 = new ArrayList<MaterialClassify>();
				for(MaterialClassify pe : list5) {
					if(pe==null) {
						break;
					}else {
					if(pe.getSuperiorClassifyId().equals(p.getMaterialClassifyId())) {
						list6.add(pe);
					}
					}
				}
				p.setMaterialClassifys(list6);
				}
			}
		//}
		return list4;
	}
}
