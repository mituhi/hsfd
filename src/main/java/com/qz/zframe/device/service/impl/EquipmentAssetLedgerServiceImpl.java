package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.dao.CommonDao;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.RegexUtils;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.AssetEquipmentMapper;
import com.qz.zframe.device.dao.ComponentsMapper;
import com.qz.zframe.device.dao.EquipmentAssetLedgerMapper;
import com.qz.zframe.device.dao.EquipmentClassificationMapper;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.dao.ParametersMapper;
import com.qz.zframe.device.dao.PositionEncodeMapper;
import com.qz.zframe.device.entity.AssetEquipment;
import com.qz.zframe.device.entity.Components;
import com.qz.zframe.device.entity.EquipmentAssetLedger;
import com.qz.zframe.device.entity.EquipmentAssetLedgerExample;
import com.qz.zframe.device.entity.EquipmentClassification;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.service.EquipmentAssetLedgerService;
import com.qz.zframe.file.FileException;
import com.qz.zframe.question.entity.QuestionFeedback;
import com.qz.zframe.question.entity.QuestionFile;

import sun.misc.BASE64Encoder;

@Service
@Transactional(rollbackFor = Exception.class)
public class EquipmentAssetLedgerServiceImpl implements EquipmentAssetLedgerService {
	@Autowired
	private EquipmentAssetLedgerMapper assetLedgerMapper;
	@Autowired
	private AssetEquipmentMapper assetMapper;
	@Autowired
	private EquipmentLogMapper equipmentLogMapper;
	@Autowired
	private CurrentUserService currentUserService;
	@Autowired
	private CommonDao   commonDao;
	@Autowired
	private EquipmentAssetLedgerService   equipmentAssetLedgerService;
	/*
	 * @Autowired private AssetEquipmentMapper assetEquipmentMapper;
	 */
	@Autowired
	private EquipmentClassificationMapper equipmentMapper;
	@Autowired
	private PositionEncodeMapper positionMapper;
	@Autowired
	private ParametersMapper parametersMapper;
	@Autowired
	private ComponentsMapper componentsMapper;
	@Autowired
	private CommonService commonService;

	@Override
	public PageResultEntity findAssetLedger(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.countByExample(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = assetLedgerMapper.selectByExample(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("设备资产台账信息查询成功");
		resultEntity.setRows(list);
		return resultEntity;
	}

	@SuppressWarnings("unused")
	@Override
	public ResultEntity addAssetLedger(EquipmentAssetLedger assetLedger) {
		ResultEntity resultEntity = new ResultEntity();
		String uuid = UUIdUtil.getUUID();
		assetLedger.setEquipmentAssetId(uuid);
		if (assetLedger != null) {
			boolean check = RegexUtils.checkChinese(assetLedger.getEquipmentCode());
			if (check == true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("设备编码不能为汉字");
				return resultEntity;
			}
			boolean checks = RegexUtils.check(assetLedger.getEquipmentCode());
			if (checks == false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}
			List<EquipmentAssetLedger> p = assetLedgerMapper.selectByEquipmentCode(assetLedger.getEquipmentCode());
			if (p != null && !p.isEmpty()&& p.size()>0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("设备编码已经存在,请重新填写");
				return resultEntity;
			}
			/*if(StringUtils.isBlank(assetLedger.getPositionId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选择位置信息");
				return resultEntity;
			}
			*/
			
			/*// 查看设备分类数据
			if (StringUtils.isNotBlank(assetLedger.getEquipmentId())) {
				EquipmentClassification equipmemt = equipmentMapper.selectByPrimaryKey(assetLedger.getEquipmentId());
				// 查看这条数据有没有值
				if (equipmemt != null) {
					if (StringUtils.isNotBlank(equipmemt.getRunId())) {

						if (!equipmemt.getRunId().equals(assetLedger.getRunId())) {
							equipmemt.setRunId(assetLedger.getRunId());
						}
					} else {
						if (StringUtils.isNotBlank(assetLedger.getRunId())) {
							equipmemt.setRunId(assetLedger.getRunId());
						}

					}
					if (StringUtils.isNotBlank(equipmemt.getOutputId())) {

						if (!equipmemt.getOutputId().equals(assetLedger.getOutputId())) {
							equipmemt.setOutputId(assetLedger.getOutputId());
						}

					} else {
						if (StringUtils.isNotBlank(assetLedger.getOutputId())) {
							equipmemt.setOutputId(assetLedger.getOutputId());
						}

					}
					int saveeq = equipmentMapper.updateByPrimaryKey(equipmemt);
					if (saveeq == 0) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("修改设备分类信息失败");
						return resultEntity;
					} else {
						resultEntity.setCode(ErrorCode.SUCCESS);
						resultEntity.setMsg("修改设备分类信息成功");
					}
				} else {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中没有这条设备分类数据");
					return resultEntity;
				}
			} else {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选择设备分类信息");
				return resultEntity;
			}*/
			if (StringUtils.isNotBlank(assetLedger.getPositionId())) {
				PositionEncode position =positionMapper.selectByPrimaryKey(assetLedger.getPositionId());
				if (position != null) {
					// 判断风电场是否相同
					if (StringUtils.isNotBlank(position.getWindId())) {

						if (!position.getWindId().equals(assetLedger.getWindId())) {
							position.setWindId(assetLedger.getWindId());
						}

					} else {
						position.setWindId(assetLedger.getWindId());
					}
					
					/* * // 判断公司是否相同 if(StringUtils.isNotBlank(position.getCompanyCode())) {
					 * 
					 * 
					 * if (!position.getCompanyCode().equals(assetLedger.getCompanyCode())) {
					 * position.setCompanyCode(assetLedger.getCompanyCode()); }
					 * 
					 * }else { position.setCompanyCode(assetLedger.getCompanyCode()); }
					 */
					// 判断部门是否相同
					if (StringUtils.isNotBlank(position.getDepartment())) {

						if (!position.getDepartment().equals(assetLedger.getDepartment())) {
							position.setDepartment(assetLedger.getDepartment());
						}
					} else {
						position.setDepartment(assetLedger.getDepartment());
					}
					
					/* * //// 判断成本中心是否相同 if(StringUtils.isNotBlank(position.getCostCenter())) {
					 * 
					 * 
					 * if (!position.getCostCenter().equals(assetLedger.getCostCenter())) {
					 * position.setCostCenter(assetLedger.getCostCenter()); }
					 * 
					 * }else { position.setCostCenter(assetLedger.getCostCenter()); }*/
					 
					// 判断维护班组是否相同
					if (StringUtils.isNotBlank(position.getMaintenanceTeam())) {

						if (!position.getMaintenanceTeam().equals(assetLedger.getMaintenanceTeam())) {
							position.setMaintenanceTeam(assetLedger.getMaintenanceTeam());
						}

					} else {
						position.setMaintenanceTeam(assetLedger.getMaintenanceTeam());
					}
					// 判断层级是否相同
					if (StringUtils.isNotBlank(position.getHierarchy())) {

						if (!position.getHierarchy().equals(assetLedger.getHierarchy())) {
							position.setHierarchy(assetLedger.getHierarchy());
						}

					} else {
						position.setHierarchy(assetLedger.getHierarchy());
					}
					// 判断机组是否相同
					if (StringUtils.isNotBlank(position.getCrew())) {

						if (!position.getCrew().equals(assetLedger.getCrew())) {
							position.setCrew(assetLedger.getCrew());
						}
					} else {
						position.setCrew(assetLedger.getCrew());
					}
				} else {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中没有这条位置信息数据");
					return resultEntity;
				}
				int savepo = positionMapper.updateByPrimaryKey(position);
				/*if (savepo == 0) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("修改位置信息失败");
					return resultEntity;
				} else {
					resultEntity.setCode(ErrorCode.SUCCESS);
					resultEntity.setMsg("修改位置信息成功");
				}*/
			} else {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选择位置信息");
				return resultEntity;
			}
			List<Components> list = assetLedger.getComponents();
			Components com = new Components();
			if (list != null && !list.isEmpty()) {
				for (Components l : list) {
					com = new Components();
					com.setComponentId(UUIdUtil.getUUID());
					com.setCompany(l.getCompany());
					com.setComponentCode(l.getComponentCode());
					com.setComponentName(l.getComponentName());
					com.setEquipmentAssetId(uuid);
					com.setNumber(l.getNumber());
					com.setSpecificationModel(l.getSpecificationModel());
					com.setRemarks(l.getRemarks());
					componentsMapper.insert(com);
					/*
					 * asset.setAssetId(UUIdUtil.getUUID()); asset.setMaterialId(l);
					 * asset.setWindId(assetLedger.getWindId()); asset.setEquipmentAssetId(uuid);
					 * assetMapper.insertList(asset);
					 */
				}
			}
			
			List<String> files = assetLedger.getFiles();
			if (files != null && !files.isEmpty()) {
				AssetEquipment ae = new AssetEquipment();
				for (String f : files) {
					ae = new AssetEquipment();
					ae.setAssetId(UUIdUtil.getUUID());
					ae.setEquipmentAssetId(uuid);
					ae.setFileId(f);
					assetMapper.insertList(ae);
				}
			}
			int save = assetLedgerMapper.insert(assetLedger);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("新增失败");
				return resultEntity;
			} else {
				
				EquipmentLog log = new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("新增设备资产台账信息");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(uuid);
				equipmentLogMapper.insertAdd(log);
				
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("新增成功");
			}	
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("添加的数据为空,不能添加数据");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateAssetLedger(EquipmentAssetLedger assetLedger) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if (assetLedger != null) {
			EquipmentAssetLedger ledger = selectByPrimaryKey(assetLedger.getEquipmentAssetId());
			if (ledger == null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("数据源中没有这条数据");
				return resultEntity;
			} else {

				boolean check = RegexUtils.checkChinese(assetLedger.getEquipmentCode());
				if (check == true) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("设备编码不能为汉字");
					return resultEntity;
				}
				boolean checks = RegexUtils.check(assetLedger.getEquipmentCode());
				if (checks == false) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
					return resultEntity;
				}
				List<EquipmentAssetLedger> asset = assetLedgerMapper.selectByEquipmentCode(assetLedger.getEquipmentCode());
				if (asset != null && !asset.isEmpty() && asset.size()>0) {
					for(int i=0;i<asset.size();i++) {
					if (!asset.get(i).getEquipmentAssetId().equals(assetLedger.getEquipmentAssetId())) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("设备编码已经存在,请重新填写");
						return resultEntity;
					}
					}
				}

				/*
				 * // 查看设备分类数据 if (StringUtils.isNotBlank(ledger.getEquipmentId())) {
				 * EquipmentClassification equipmemt =
				 * equipmentMapper.selectByPrimaryKey(ledger.getEquipmentId()); // 查看这条数据有没有值 if
				 * (equipmemt != null) { if (StringUtils.isNotBlank(equipmemt.getRunId())) {
				 * 
				 * if (!equipmemt.getRunId().equals(assetLedger.getRunId())) {
				 * equipmemt.setRunId(assetLedger.getRunId()); }
				 * 
				 * } else { if (StringUtils.isNotBlank(assetLedger.getRunId())) {
				 * equipmemt.setRunId(assetLedger.getRunId()); } } if
				 * (StringUtils.isNotBlank(equipmemt.getOutputId())) {
				 * 
				 * if (!equipmemt.getOutputId().equals(assetLedger.getOutputId())) {
				 * equipmemt.setOutputId(assetLedger.getOutputId()); }
				 * 
				 * } else { if (StringUtils.isNotBlank(assetLedger.getOutputId())) {
				 * equipmemt.setOutputId(assetLedger.getOutputId()); } } int saveeq =
				 * equipmentMapper.updateByPrimaryKey(equipmemt); if (saveeq == 0) {
				 * resultEntity.setCode(ErrorCode.ERROR); resultEntity.setMsg("修改设备分类信息失败");
				 * return resultEntity; } else { resultEntity.setCode(ErrorCode.SUCCESS);
				 * resultEntity.setMsg("修改设备分类信息成功"); } } else {
				 * resultEntity.setCode(ErrorCode.ERROR); resultEntity.setMsg("数据源中没有这条设备分类数据");
				 * return resultEntity; } } else { resultEntity.setCode(ErrorCode.ERROR);
				 * resultEntity.setMsg("未选择设备分类信息"); return resultEntity; }
				 */
				if (StringUtils.isNotBlank(ledger.getPositionId())) {
					PositionEncode position =selectByPositionId(ledger.getPositionId());
					if (position != null) {
						// 判断风电场是否相同
						if (StringUtils.isNotBlank(position.getWindId())) {

							if (!position.getWindId().equals(assetLedger.getWindId())) {
								position.setWindId(assetLedger.getWindId());
							}

						} else {
							position.setWindId(assetLedger.getWindId());
						}

						/*
						 * * // 判断公司是否相同 if(StringUtils.isNotBlank(position.getCompanyCode())) {
						 * 
						 * 
						 * if (!position.getCompanyCode().equals(assetLedger.getCompanyCode())) {
						 * position.setCompanyCode(assetLedger.getCompanyCode()); }
						 * 
						 * }else { position.setCompanyCode(assetLedger.getCompanyCode()); }
						 */
						// 判断部门是否相同
						if (StringUtils.isNotBlank(position.getDepartment())) {

							if (!position.getDepartment().equals(assetLedger.getDepartment())) {
								position.setDepartment(assetLedger.getDepartment());
							}
						} else {
							position.setDepartment(assetLedger.getDepartment());
						}
						/*
						 * //// 判断成本中心是否相同 if(StringUtils.isNotBlank(position.getCostCenter())) {
						 * 
						 * 
						 * if (!position.getCostCenter().equals(assetLedger.getCostCenter())) {
						 * position.setCostCenter(assetLedger.getCostCenter()); }
						 * 
						 * }else { position.setCostCenter(assetLedger.getCostCenter()); }
						 */

						// 判断维护班组是否相同
						if (StringUtils.isNotBlank(position.getMaintenanceTeam())) {

							if (!position.getMaintenanceTeam().equals(assetLedger.getMaintenanceTeam())) {
								position.setMaintenanceTeam(assetLedger.getMaintenanceTeam());
							}

						} else {
							position.setMaintenanceTeam(assetLedger.getMaintenanceTeam());
						}
						// 判断层级是否相同
						if (StringUtils.isNotBlank(position.getHierarchy())) {

							if (!position.getHierarchy().equals(assetLedger.getHierarchy())) {
								position.setHierarchy(assetLedger.getHierarchy());
							}

						} else {
							position.setHierarchy(assetLedger.getHierarchy());
						}
						// 判断机组是否相同
						if (StringUtils.isNotBlank(position.getCrew())) {

							if (!position.getCrew().equals(assetLedger.getCrew())) {
								position.setCrew(assetLedger.getCrew());
							}
						} else {
							position.setCrew(assetLedger.getCrew());
						}
					} else {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("数据源中没有这条位置信息数据");
						return resultEntity;
					}
					int savepo = positionMapper.updateByPrimaryKey(position);
					if (savepo == 0) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("修改位置信息失败");
						return resultEntity;
					} else {
						resultEntity.setCode(ErrorCode.SUCCESS);
						resultEntity.setMsg("修改位置信息成功");
					}
				} else {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("未选择位置信息");
					return resultEntity;
				}

				List<Components> listHistory = ledger.getComponents();
				if (listHistory != null && !listHistory.isEmpty()) {
					List<String> cid = new ArrayList<String>();
					for (Components h : listHistory) {
						cid.add(h.getComponentId());
					}
					componentsMapper.deleteByPrimaryKeyList(cid);
					List<Components> list = assetLedger.getComponents();
					if (list != null && !list.isEmpty()) {
						Components com = new Components();
						for (Components l : list) {
							com = new Components();
							com.setComponentId(UUIdUtil.getUUID());
							com.setCompany(l.getCompany());
							com.setComponentCode(l.getComponentCode());
							com.setComponentName(l.getComponentName());
							com.setEquipmentAssetId(assetLedger.getEquipmentAssetId());
							com.setNumber(l.getNumber());
							com.setSpecificationModel(l.getSpecificationModel());
							com.setRemarks(l.getRemarks());
							componentsMapper.insert(com);
						}
					}
				}
				/*
				 * List<AssetEquipment> assetFile =
				 * assetMapper.selectById(assetLedger.getEquipmentAssetId()); if (assetFile !=
				 * null && !assetFile.isEmpty()) { List<String> history = new
				 * ArrayList<String>(); for (AssetEquipment a : assetFile) {
				 * history.add(a.getAssetId()); } assetMapper.deleteByPrimaryKeyList(history); }
				 */
				List<String> file = assetLedger.getFiles();
				if (file != null && !file.isEmpty()) {
					AssetEquipment ae = new AssetEquipment();
					AssetEquipment lae = new AssetEquipment();
					for (String f : file) {
						lae = new AssetEquipment();
						lae = assetMapper.selectByFileId(f);
						if (lae == null) {
							ae = new AssetEquipment();
							ae.setAssetId(UUIdUtil.getUUID());
							ae.setEquipmentAssetId(assetLedger.getEquipmentAssetId());
							ae.setFileId(f);
							assetMapper.insertList(ae);
						}

					}
				}

				// 删除历史与现在上传不同的文件
				List<String> historyFiles = ledger.getFiles();
				List<String> nowFile = assetLedger.getFiles();
				AssetEquipment assetEquipment = new AssetEquipment();
				List<String> fi = new ArrayList<String>();
				if (historyFiles != null && !historyFiles.isEmpty() && nowFile != null && !nowFile.isEmpty()) {
					fi = getDiffrent(nowFile, historyFiles);
				}
				List<String> deleteFile = new ArrayList<String>();
				if (fi != null && !fi.isEmpty()) {
					for (String f : fi) {
						commonService.removeFile(f);
						assetEquipment = new AssetEquipment();
						assetEquipment = assetMapper.selectByFileId(f);
						if (assetEquipment != null) {
							deleteFile.add(assetEquipment.getFileId());
						}
					}
					if (deleteFile != null && !deleteFile.isEmpty()) {
						assetMapper.deleteByFileId(deleteFile);
					}
				}
			}
			int save = assetLedgerMapper.updateByPrimaryKey(assetLedger);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
				return resultEntity;
			} else {

				EquipmentLog log = new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("修改设备资产台账信息");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(assetLedger.getEquipmentAssetId());
				equipmentLogMapper.insertAdd(log);

				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要修改");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByEquipmentAssetId(String equipmentAssetId) throws FileException {
		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isNotBlank(equipmentAssetId)) {
			List<EquipmentAssetLedger> list = new ArrayList<EquipmentAssetLedger>();
			EquipmentAssetLedger equipmentAssetLedger = selectByPrimaryKey(equipmentAssetId);
			if (equipmentAssetLedger == null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("查询结果有误");
				return resultEntity;
			} else {
				Parameters output = parametersMapper.selectByPrimaryKey(equipmentAssetLedger.getOutputId());
				if (output == null) {
					equipmentAssetLedger.setOutputParameters(null);
				} else {
					equipmentAssetLedger.setOutputParameters(output);
				}
				Parameters run = parametersMapper.selectByPrimaryKey(equipmentAssetLedger.getRunId());
				if (run == null) {
					equipmentAssetLedger.setRunParameters(null);
				} else {
					equipmentAssetLedger.setRunParameters(run);
				}
				List<Components> com = componentsMapper.selectById(equipmentAssetId);
				if (com==null && com.isEmpty()) {
					equipmentAssetLedger.setComponents(null);
				} else {
					equipmentAssetLedger.setComponents(com);
				}
				
				List<AssetEquipment> assetEquipment=assetMapper.selectById(equipmentAssetId);
				//List<String> files=new ArrayList<String>();
				List<SpFileUpload> route=new ArrayList<SpFileUpload>();
				SpFileUpload  spu=new SpFileUpload();
				if(assetEquipment!=null && !assetEquipment.isEmpty()) {
					for(AssetEquipment  ae:assetEquipment) {
						//files.add(ae.getFileId());
						spu=commonDao.findByFileId(ae.getFileId());
						spu.setName(spu.getOriginalName());
						if(spu!=null) {
						route.add(spu);
						}
						
					}
					//equipmentAssetLedger.setFiles(files);
					equipmentAssetLedger.setRoute(route);
				}
				list.add(equipmentAssetLedger);
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setRows(list);
			}
		 } else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据ID查询数据,Id为空");
			return resultEntity;
		 }
		return resultEntity;
	}
	@CodeConvert({
		@CodeType(codeType="ASSET_STATUS", nameField="assetStatus", titleField="assetStatusName"),
		@CodeType(codeType="HIERARCHY_TYPE", nameField="hierarchy", titleField="hierarchyName")
	})
	private EquipmentAssetLedger selectByPrimaryKey(String equipmentAssetId) {
		return assetLedgerMapper.selectByPrimaryKey(equipmentAssetId);
	}
	
	@CodeConvert({
		@CodeType(codeType="ASSET_STATUS", nameField="assetStatus", titleField="assetStatusName"),
		@CodeType(codeType="HIERARCHY_TYPE", nameField="hierarchy", titleField="hierarchyName")
	})
	private EquipmentAssetLedger selectByPrimaryKeys(String equipmentAssetId) {
		return assetLedgerMapper.selectByPrimaryKeys(equipmentAssetId);
	}
	@CodeConvert({
		@CodeType(codeType="POSITION_STATUS", nameField="status", titleField="statusName"),
		@CodeType(codeType="IS_TOPLEVEL", nameField="isToplevel", titleField="isToplevelName"),
		@CodeType(codeType="HIERARCHY_TYPE", nameField="hierarchy", titleField="hierarchyName")
	})
	private  PositionEncode selectByPositionId(String positionId) {
		return positionMapper.selectByPrimaryKey(positionId);
	}
	
	@Override
	public ResultEntity deleteAssetLedger(List<String> equipmentAssetIds) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		List<String> files=new ArrayList<String>();
		if (equipmentAssetIds != null && !equipmentAssetIds.isEmpty()) {
			for(String f:equipmentAssetIds) {
				List<AssetEquipment> assetEquipment=assetMapper.selectById(f);
				if(assetEquipment!=null) {
					for(AssetEquipment  ae:assetEquipment) {
						files.add(ae.getFileId());
					}
				}
			}
			List<String> fil=new ArrayList<String>();
			AssetEquipment assetEquipment=new AssetEquipment();
			if (files != null && !files.isEmpty()) {
				for (String fi : files) {
					commonService.removeFile(fi);
					assetEquipment=new AssetEquipment();
					assetEquipment=assetMapper.selectByFileId(fi);
					if(assetEquipment!=null) {
						fil.add(assetEquipment.getFileId());
					}
				}
				if(fil!=null && !fil.isEmpty()) {
					assetMapper.deleteByFileId(fil);
				}
			}
			
			int delete = assetLedgerMapper.deleteByPrimaryKeyList(equipmentAssetIds);
			if (delete < 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("删除失败");
				return resultEntity;
			} else {
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("删除成功");
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据Id删除数据,Id为空");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findChange(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.countByExamples(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
		} else {
			list = assetLedgerMapper.selectByExamples(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public PageResultEntity findById(String equipmentAssetId) {
		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isNotBlank(equipmentAssetId)) {
			List<EquipmentAssetLedger> list = new ArrayList<EquipmentAssetLedger>();
			EquipmentAssetLedger equipmentAssetLedger =selectByPrimaryKey(equipmentAssetId);
			if (equipmentAssetLedger == null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("查询结果有误");
				return resultEntity;
			} else {
				Parameters output = parametersMapper.selectByPrimaryKey(equipmentAssetLedger.getOutputId());
				Parameters run = parametersMapper.selectByPrimaryKey(equipmentAssetLedger.getRunId());
				List<Components> com = componentsMapper.selectById(equipmentAssetId);
				if (output == null) {
					equipmentAssetLedger.setRunParameters(null);
				} else {
					equipmentAssetLedger.setRunParameters(run);
				}
				if (run == null) {
					equipmentAssetLedger.setOutputParameters(null);
				} else {
					equipmentAssetLedger.setOutputParameters(output);
				}
				if (com.size() <= 0) {
					equipmentAssetLedger.setComponents(null);
				} else {
					equipmentAssetLedger.setComponents(com);
				}
				list.add(equipmentAssetLedger);
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setRows(list);
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据ID查询数据,Id为空");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public String ExportExcl(EquipmentAssetLedgerExample assetLedgerExample, HttpServletResponse response,
			String sheetName) throws Exception {
		List<EquipmentAssetLedger> list = assetLedgerMapper.select(assetLedgerExample);
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("equipmentAssetId", "设备资产变动查询信息标识");
		fieldMap.put("equipmentCode", "设备编码");
		fieldMap.put("equipmentName", "设备名称");
		fieldMap.put("positionCode", "位置编码");
		fieldMap.put("positionName", "位置名称");
		fieldMap.put("supplierName", "供应商");
		fieldMap.put("windName", "风电场");
		fieldMap.put("crewName", "机组");
		fieldMap.put("typeName", "设备分类");
		fieldMap.put("dateDeliverys", "投运日期");
		fieldMap.put("assetStatusName", "资产状态");
		fieldMap.put("assetStatusDates", "资产变更日期");
		return ExcelUtil.Excel(list, fieldMap, sheetName, response);
	}

	@Override
	public ResultEntity removeFile(List<String> fileId) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		AssetEquipment assetEquipment = new AssetEquipment();
		List<String> file = new ArrayList<String>();
		if (fileId != null) {
			for (String f : fileId) {
				commonService.removeFile(f);
				assetEquipment = new AssetEquipment();
				assetEquipment = assetMapper.selectByFileId(f);
				if (assetEquipment != null) {
					file.add(assetEquipment.getFileId());
				}
			}
			if (file != null && !file.isEmpty()) {
				assetMapper.deleteByFileId(file);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		}
		return resultEntity;
	}
	
	public ResultEntity closeDown(EquipmentAssetLedger assetLedger) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		if (assetLedger != null) {
			if (StringUtils.isNotBlank(assetLedger.getEquipmentAssetId())) {
				PageResultEntity eal = equipmentAssetLedgerService
						.findByEquipmentAssetId(assetLedger.getEquipmentAssetId());
				if (eal != null && eal.getRows() != null && !eal.getRows().isEmpty()) {
					EquipmentAssetLedger equipAsset = (EquipmentAssetLedger) eal.getRows().get(0);

					List<String> files = new ArrayList<String>();
					if (equipAsset != null) {
						List<SpFileUpload> route = equipAsset.getRoute();
						if(route!=null && !route.isEmpty()) {
							for (SpFileUpload s : route) {
								files.add(s.getFileId());
							}
						}
					}
					List<String> file = assetLedger.getFiles();
					if (file != null && files != null) {
						List<String> diffent = getDiffrent(files, file);
						if (diffent != null && !diffent.isEmpty()) {
							for (String s : diffent) {
								commonService.removeFile(s);
							}
						} else {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("关闭删除失败");
							return resultEntity;
						}
					}
				} else {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中数据查询为空");
					return resultEntity;
				}
			} else {
				List<String> files = assetLedger.getFiles();
				if (files != null && !files.isEmpty()) {
					for (String f : files) {
						commonService.removeFile(f);
					}
				} else {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("关闭删除失败");
					return resultEntity;
				}
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("关闭删除成功");
		}
		return resultEntity;
	}
	/**
	 * 判断两个list里的差异值
	 * @param list1
	 * @param list2
	 * @return
	 */
	private static List<String> getDiffrent(List<String> list1, List<String> list2) {
		List<String> diff = new ArrayList<String>();
		for(String str:list2){
		  if(!list1.contains(str)){
		     diff.add(str);
		}
		}
		return diff;
	}
	
	@Override
	public PageResultEntity selectByWindId(EquipmentAssetLedgerExample assetLedgerExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = assetLedgerMapper.selectByWindIdCount(assetLedgerExample);
		resultEntity.setTotal(count);
		List<EquipmentAssetLedger> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = assetLedgerMapper.selectByExample(assetLedgerExample);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("设备资产台账信息查询成功");
		resultEntity.setRows(list);
		return resultEntity;
	}
}
