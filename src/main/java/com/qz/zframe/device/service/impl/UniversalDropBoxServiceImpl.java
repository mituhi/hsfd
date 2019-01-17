package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.dao.OrgArchitectureDao;
import com.qz.zframe.common.entity.OrgArchitecture;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.dao.CrewInformationMapper;
import com.qz.zframe.device.dao.EquipmentAssetLedgerMapper;
import com.qz.zframe.device.dao.EquipmentClassificationMapper;
import com.qz.zframe.device.dao.ParametersMapper;
import com.qz.zframe.device.dao.PositionEncodeMapper;
import com.qz.zframe.device.dao.RunParametersMapper;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.GeneralDto;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;
import com.qz.zframe.device.service.UniversalDropBoxService;
import com.qz.zframe.material.dao.SupplierMapper;
import com.qz.zframe.material.entity.Supplier;
@Service
public class UniversalDropBoxServiceImpl implements UniversalDropBoxService {
	@Autowired
	private EquipmentClassificationMapper  equipmentMapper;
	@Autowired
	private PositionEncodeMapper positionMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private OrgArchitectureDao orgArchitectureDao;
	@Autowired
	 private CrewInformationMapper crewInformationMapper;
	@Autowired
    private CurrentUserService currentUserService;
	@Autowired
	private ParametersMapper parametersMapper;
	@Autowired
	private RunParametersMapper runParametersMapper;
	@Autowired
	private EquipmentAssetLedgerMapper assetLedgerMapper;
	@Override
	/**
	 * 上级设备分类
	 */
	public PageResultEntity findSuperiorEquipment() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<EquipmentClassification> list=equipmentMapper.selectStructures();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}
/**
 * 上级位置
 */
	@Override
	public PageResultEntity findSuperiorPostition() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<PositionEncode> list=positionMapper.selectStructures();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findWind() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<OrgArchitecture> list=orgArchitectureDao.findWind();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findCompany() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<OrgArchitecture> list=orgArchitectureDao.findCompany();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findSection() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<OrgArchitecture> list=orgArchitectureDao.findSection();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findTeamGroup() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<OrgArchitecture> list=orgArchitectureDao.findTeamGroup();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findSupplier() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<Supplier> list=supplierMapper.selectSupplier();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity find() {
		ResultEntity resultEntity=new ResultEntity();
		GeneralDto  gl=new GeneralDto();
		String  id=String.valueOf(System.currentTimeMillis());
		gl.setId(id);
		gl.setUserId(currentUserService.getId());
		gl.setUserName(currentUserService.getUsername());
		gl.setTime(new Date());
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setData(gl);
		return resultEntity;
	}

	@Override
	/**
	 * 机组下拉框
	 */
	public PageResultEntity findCrews() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<CrewInformation> list=crewInformationMapper.selectAll();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	/**
	 * 根据设备分类id带出数据
	 */
	public PageResultEntity findSuperiorEquipmentList(String equipmentId) {
		PageResultEntity resultEntity=new PageResultEntity();
		List<EquipmentClassification> list = new ArrayList<EquipmentClassification>();
		if(StringUtils.isBlank(equipmentId)) {
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据设备Id查询带出数据,设备Id为空");
			return resultEntity;
			
		}else {
		
		EquipmentClassification equipmentClassification = equipmentMapper.selectByPrimaryKey(equipmentId);
		if(equipmentClassification==null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未查询到数据源中有这条数据");
			return resultEntity;
		}else {
		Parameters output = parametersMapper.selectByPrimaryKey(equipmentClassification.getOutputId());
		if (output == null) {
			equipmentClassification.setOutputParameters(null);
		} else {
			equipmentClassification.setOutputParameters(output);
		}
		Parameters run = parametersMapper.selectByPrimaryKey(equipmentClassification.getRunId());
		if (run == null) {
			equipmentClassification.setRunParameters(null);
		} else {
			equipmentClassification.setRunParameters(run);
		}
		list.add(equipmentClassification);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		}
		}
		return resultEntity;
	}
	@Override
	/**
	 * 根据位置id带入的数据
	 */
	public PageResultEntity findSuperiorPostitionList(String positionId) {
		PageResultEntity resultEntity=new PageResultEntity();
		List<PositionEncode> list = new ArrayList<PositionEncode>();
		/*if(StringUtils.isBlank(positionId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据位置Id查询带出数据,位置Id为空");
			return resultEntity;
		}else {*/
		PositionEncode position =positionMapper.selectByPrimaryKey(positionId);
		if(position!=null) {
		list.add(position);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		/*}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未查到相关的位置信息");
			return resultEntity;
		}*/
		}
		return resultEntity;
	}
/*	@CodeConvert({
		@CodeType(codeType="POSITION_STATUS", nameField="status", titleField="statusName"),
		@CodeType(codeType="IS_TOPLEVEL", nameField="isToplevel", titleField="isToplevelName"),
		@CodeType(codeType="HIERARCHY_TYPE", nameField="hierarchy", titleField="hierarchyName")
	})
	private  PositionEncode selectByPositionId(String positionId) {
		return positionMapper.selectByPrimaryKey(positionId);
	}*/
	@Override
	/**
	 * 查询所以上级设备分类
	 */
	public PageResultEntity findSuperiorEquipmentAll() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<EquipmentClassification> list=equipmentMapper.selectStructure();
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	/**
	 * 所有上级位置信息（树形结构）
	 */
	public PageResultEntity findSuperiorPostitionAll() {
		PageResultEntity resultEntity=new PageResultEntity();
		List<PositionEncode> list=positionMapper.selectIsTop(null);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}
	
	@Override
/**
 * 根据风电场查询位置信息
 */
	public PageResultEntity findSuperiorPostitionAlls(String windId) {
		PageResultEntity resultEntity=new PageResultEntity();
		List<PositionEncode> list1=new ArrayList<PositionEncode>();
		List<PositionEncode> list2 = new ArrayList<PositionEncode>();
		if(StringUtils.isBlank(windId)) {
			list1=positionMapper.selectIsTop(null);
			 //list=positionMapper.selectStructureAndHierarchy1(null);
			 list2=positionMapper.selectNotIsTop(null);
		}else {
		   //list1=positionMapper.selectStructureAndHierarchy1(windId);
		   list1=positionMapper.selectIsTop(windId);
		   list2=positionMapper.selectNotIsTop(windId);
		}
		/*if(list != null && !list.isEmpty()) {
			List<PositionEncode> list1 = new ArrayList<PositionEncode>();
			List<PositionEncode> list2 = new ArrayList<PositionEncode>();
			List<PositionEncode> list3 = new ArrayList<PositionEncode>();
			List<PositionEncode> list4 = new ArrayList<PositionEncode>();
			List<PositionEncode> list5 = new ArrayList<PositionEncode>();
			for(PositionEncode p : list) {
				if("01".equals(p.getHierarchy())) {
					list1.add(p);
				}
				if("02".equals(p.getHierarchy())) {
					list2.add(p);
				}
				if("03".equals(p.getHierarchy())) {
					list3.add(p);
				}
				if("04".equals(p.getHierarchy())) {
					list4.add(p);
				}
				if("05".equals(p.getHierarchy())) {
					list5.add(p);
				}
			}*/
			/*list4 = makeTree(list5, list4);
			list3 = makeTree(list4, list3);
			list2 = makeTree(list3, list2);*/
		
			list1 = makeTree(list2, list1);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("查询成功");
			resultEntity.setRows(list1);
			return resultEntity;
		}/*else {
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("未查到相关数据");
		resultEntity.setRows(null);
		return resultEntity;*/
	
	private List<PositionEncode> makeTree(List<PositionEncode> list5, List<PositionEncode> list4) {
		//if(list5 != null && !list5.isEmpty() && list4 != null && !list4.isEmpty()) {
			for(PositionEncode p : list4) {
				if(p==null) {
					break;
				}else {
				List<PositionEncode> list6 = new ArrayList<PositionEncode>();
				for(PositionEncode pe : list5) {
					if(pe==null) {
						break;
					}else {
						if (pe.getSuperiorPosition()!=null) {
							if(pe.getSuperiorPosition().equals(p.getPositionId())) {
								list6.add(pe);
							}
						}

					}
				}
				p.setPositionEncodes(list6);
				}
			}
		//}
		return list4;
	}

	@Override
	public PageResultEntity findWindAndPosition(String windId) {
		PageResultEntity  resultEntity=new PageResultEntity();
		List<PositionEncode> list = new ArrayList<PositionEncode>();
		list=positionMapper.selectByWindId(windId);
		if(list!=null && !list.isEmpty()) {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未查询到数据");
			return resultEntity;
		}
		return resultEntity;
		
	}

	@Override
	/**
	 * 根据位置id 查询设备信息
	 */
	public PageResultEntity findWindAndPositionAndEquipment(String positionId) {
		PageResultEntity  resultEntity=new PageResultEntity();
		List<EquipmentAssetLedger> list=new ArrayList<EquipmentAssetLedger>();
		if(StringUtils.isBlank(positionId)) {
		list=assetLedgerMapper.selectByWindAndPosition(null);
		}else {
		list=assetLedgerMapper.selectByWindAndPosition(positionId);
		}
		if(list==null && list.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未查询到数据");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return  resultEntity;
	}

	@Override
	public PageResultEntity findSuperiorPostitionAllByHierarchy(String Hierarchy,String windId) {
		PageResultEntity  resultEntity=new PageResultEntity();
		List<PositionEncode> list = new ArrayList<PositionEncode>();
		if(StringUtils.isBlank(Hierarchy)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("层级为空");
			return resultEntity;
		}else {
		if("02".equals(Hierarchy)) {
		list=positionMapper.selectStructureAndHierarchy2("01",windId);
		}
		if("03".equals(Hierarchy)) {
			list=positionMapper.selectStructureAndHierarchy2("02",windId);
		}
        if("04".equals(Hierarchy)) {
        	list=positionMapper.selectStructureAndHierarchy2("03",windId);
		}
        if("05".equals(Hierarchy)) {
        	list=positionMapper.selectStructureAndHierarchy2("04",windId);
       }
        
        if(list==null && list.isEmpty()) {
        	resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未找到与层级相关的上级位置信息");
			return resultEntity;
        }
       
	}
	 resultEntity.setCode(ErrorCode.SUCCESS);
	 resultEntity.setRows(list);
	 return  resultEntity;

    }

	@Override
	/**
	 * 根据风电场查询机组信息下拉框
	 */
	public PageResultEntity findCrewByWind(String windId) {
		PageResultEntity  resultEntity=new PageResultEntity();
		List<CrewInformation>  list=new ArrayList<CrewInformation>();
		if(StringUtils.isBlank(windId)) {
		  list=crewInformationMapper.selectCrewByWind(null);
		}else {
		  list=crewInformationMapper.selectCrewByWind(windId);
		}
		if(list==null && list.isEmpty()) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未找到与风电场相关的机组信息");
			return resultEntity;
		}
		 resultEntity.setCode(ErrorCode.SUCCESS);
		 resultEntity.setRows(list);
		 return  resultEntity;
	}
	}
