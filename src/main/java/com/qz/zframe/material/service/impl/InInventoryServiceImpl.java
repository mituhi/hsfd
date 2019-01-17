package com.qz.zframe.material.service.impl;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.entity.*;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.service.*;
import com.qz.zframe.common.util.*;
import com.qz.zframe.material.dao.InInventoryDetailMapper;
import com.qz.zframe.material.dao.InInventoryMapper;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.dao.IventoryDetailMapper;
import com.qz.zframe.material.dao.MaterialMapper;
import com.qz.zframe.material.entity.*;
import com.qz.zframe.material.service.InInventoryService;
import com.qz.zframe.tally.entity.QrCode;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@Transactional
public class InInventoryServiceImpl implements InInventoryService {
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	
	@Autowired
	private InInventoryMapper inInventoryMapper;
	
	@Autowired
	private InInventoryDetailMapper inInventoryDetailMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
		
	@Autowired
	private CommonService commonService;

	@Autowired
	private InventoryMapper inventoryMapper;

	@Autowired
	private IventoryDetailMapper iventoryDetailMapper;

	@Autowired
	private DoListService doListService;

	@Autowired
	private ProcessService processService;

	@Autowired
	private ApproveRecordService approveRecordService;

	@Autowired
	private DeployService deployService;

	@Autowired
	private CurrentUserService currentUserService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MaterialMapper materialMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getListInInventory(InInventoryExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = inInventoryMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<InInventory> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=inInventoryMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				list.forEach(inInventory -> {
					inInventory.setStatusName(this.getStatusName(inInventory.getStatus()));
				});
			}
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public  ResultEntity saveInInventory(InInventory inInventory) throws Exception {
		ResultEntity resultEntity = new ResultEntity();

		//如果是期初入库
		if ("02".equals(inInventory.getInInventoryType())) {
			if (!StringUtils.isNoneBlank(inInventory.getArchitectureId())) {
				resultEntity.setMsg("风电场id不能为空");
				return resultEntity;
			}
			if (!StringUtils.isNoneBlank(inInventory.getStockAddId())) {
				resultEntity.setMsg("库存地id不能为空");
				return resultEntity;
			}
			if (inInventory.getInInventoryTime()==null) {
				resultEntity.setMsg("入库日期不能为空");
				return resultEntity;
			}
			if (!StringUtils.isNoneBlank(inInventory.getTypeCode())) {
				resultEntity.setMsg("入库类型不能为空");
				return resultEntity;
			}
			if("01".equals(inInventory.getInInventoryType())){
				String maxOrder= commonService.customOrder("02", inInventoryMapper.getMaxInInventoryOrder("01"));
				inInventory.setInInventoryOrder(maxOrder);
			}
			if("02".equals(inInventory.getInInventoryType())){
				String maxOrder= commonService.customOrder("03", inInventoryMapper.getMaxInInventoryOrder("02"));
				inInventory.setInInventoryOrder(maxOrder);
			}
			//设置id
			String inInventoryId = UUIdUtil.getUUID();
			inInventory.setInInventoryId(inInventoryId);
			//设置创建人
			inInventory.setCreater(currentUSerservice.getUserInfo().getUserId());
			//设置创建时间
			inInventory.setCreateTime(new Date());
			//插入数据库
			inInventoryMapper.insertSelective(inInventory);

			//获取物资插入数据库
			List<InInventoryDetail> inInventoryDetails = inInventory.getInInventoryDetails();
			if (CollectionUtils.isNotEmpty(inInventoryDetails)) {
				for (InInventoryDetail inInventoryDetail : inInventoryDetails) {
					String  inInventoryDetailId = UUIdUtil.getUUID();
					inInventoryDetail.setInInventoryDetailId(inInventoryDetailId);
					inInventoryDetail.setInInventoryId(inInventoryId);
					//生产日期
					if (!StringUtils.isBlank(inInventoryDetail.getManufactureDate())) {
						inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
					}
				}
				inInventoryDetailMapper.insertList(inInventoryDetails);
			}
			//创建库存信息
			this.createInventroyAndInventoryDetail(inInventory,resultEntity);
			inInventory.setStatus("05");
			inInventoryMapper.updateByPrimaryKeySelective(inInventory);
		}

		//如果是普通入库
		if ("01".equals(inInventory.getInInventoryType())) {
			//添加保存
			if ("01".equals(inInventory.getStatus())) {
				//设置id
				String inInventoryId = UUIdUtil.getUUID();
				inInventory.setInInventoryId(inInventoryId);
				//设置创建人
				inInventory.setCreater(currentUSerservice.getUserInfo().getUserId());
				//设置创建时间
				inInventory.setCreateTime(new Date());
				//插入数据库
				inInventoryMapper.insertSelective(inInventory);

				//获取物资插入数据库
				List<InInventoryDetail> inInventoryDetails = inInventory.getInInventoryDetails();
				if (CollectionUtils.isNotEmpty(inInventoryDetails)) {
					for (InInventoryDetail inInventoryDetail : inInventoryDetails) {
						if (!StringUtils.isNoneBlank(inInventoryDetail.getMaterialId())) {
							resultEntity.setMsg("物资编码不能为空");
							return resultEntity;
						}
						if (inInventoryDetail.getGoodsNum()==null) {
							resultEntity.setMsg("到货数量不能为空");
							return resultEntity;
						}
						if (inInventoryDetail.getTaxPrice()==null) {
							resultEntity.setMsg("含税单价不能为空");
							return resultEntity;
						}
						if (StringUtils.isNoneBlank(inInventoryDetail.getTaxBill())) {
							if (Integer.parseInt(inInventoryDetail.getTaxBill())==0) {
								resultEntity.setMsg("税率不能为零");
								return resultEntity;
							}
							/*if (!Pattern.matches("^([1-9]+(\\.\\d+)?|0\\.\\d+)$",inInventoryDetail.getTaxBill())) {
								resultEntity.setMsg("税率格式错误");
								return resultEntity;
							}*/
						}
						//设置id
						inInventoryDetail.setInInventoryDetailId(UUIdUtil.getUUID());
						//设置入库id
						inInventoryDetail.setInInventoryId(inInventoryId);
						//生产日期
						if (!StringUtils.isBlank(inInventoryDetail.getManufactureDate())) {
							inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
						}
					}
					inInventoryDetailMapper.insertList(inInventoryDetails);
				}
			}
			//提交
			if ("02".equals(inInventory.getStatus())) {
				if (!StringUtils.isNoneBlank(inInventory.getArchitectureId())) {
					resultEntity.setMsg("风电场id不能为空");
					return resultEntity;
				}
				if (!StringUtils.isNoneBlank(inInventory.getStockAddId())) {
					resultEntity.setMsg("库存地id不能为空");
					return resultEntity;
				}
				if (inInventory.getInInventoryTime()==null) {
					resultEntity.setMsg("入库日期不能为空");
					return resultEntity;
				}
				if (!StringUtils.isNoneBlank(inInventory.getTypeCode())) {
					resultEntity.setMsg("入库类型不能为空");
					return resultEntity;
				}
				if("01".equals(inInventory.getInInventoryType())){
					String maxOrder= commonService.customOrder("02", inInventoryMapper.getMaxInInventoryOrder("01"));
					inInventory.setInInventoryOrder(maxOrder);
				}
				if("02".equals(inInventory.getInInventoryType())){
					String maxOrder= commonService.customOrder("03", inInventoryMapper.getMaxInInventoryOrder("02"));
					inInventory.setInInventoryOrder(maxOrder);
				}
				//设置id
				String inInventoryId = UUIdUtil.getUUID();
				inInventory.setInInventoryId(inInventoryId);
				//设置创建人
				inInventory.setCreater(currentUSerservice.getUserInfo().getUserId());
				//设置创建时间
				inInventory.setCreateTime(new Date());
				//插入数据库
				inInventoryMapper.insertSelective(inInventory);

				//获取物资插入数据库
				List<InInventoryDetail> inInventoryDetails = inInventory.getInInventoryDetails();
				if (CollectionUtils.isNotEmpty(inInventoryDetails)) {
					for (InInventoryDetail inInventoryDetail : inInventoryDetails) {
						if (!StringUtils.isNoneBlank(inInventoryDetail.getMaterialId())) {
							resultEntity.setMsg("物资编码不能为空");
							return resultEntity;
						}
						if (inInventoryDetail.getGoodsNum()==null) {
							resultEntity.setMsg("到货数量不能为空");
							return resultEntity;
						}
						if (inInventoryDetail.getTaxPrice()==null) {
							resultEntity.setMsg("含税单价不能为空");
							return resultEntity;
						}
						//设置id
						inInventoryDetail.setInInventoryDetailId(UUIdUtil.getUUID());
						//设置入库单id
						inInventoryDetail.setInInventoryId(inInventoryId);
						//生产日期
						if (!StringUtils.isBlank(inInventoryDetail.getManufactureDate())) {
							inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
						}
					}
					inInventoryDetailMapper.insertList(inInventoryDetails);
				}
				//创建流程信息
				this.createProcessAndDoListAndApproveRecord(inInventory, resultEntity);
			}
		}

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("保存成功");
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public synchronized ResultEntity editInInventory(InInventory inInventory) throws Exception {
		ResultEntity resultEntity = new ResultEntity();

		if (!StringUtils.isNoneBlank(inInventory.getInInventoryId())) {
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}

		InInventory inInventoryInfo = inInventoryMapper.selectByPrimaryKey(inInventory.getInInventoryId());
		if (inInventoryInfo == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("入库单信息不存在");
			return resultEntity;
		}
		if (!"01".equals(inInventoryInfo.getStatus())) {
			resultEntity.setMsg("只有处于未提交状态下的入库单可以进行编辑");
			return resultEntity;
		}

		//编辑保存
		if ("01".equals(inInventory.getStatus())) {
			inInventoryMapper.updateByPrimaryKeySelective(inInventory);
			// 删除旧详情数据
			inInventoryDetailMapper.delByInInventoryId(inInventory.getInInventoryId());
			// 添加新详情数据
			List<InInventoryDetail> lists = new ArrayList<>();
			List<InInventoryDetail> inInventoryDetails = inInventory.getInInventoryDetails();
			if (CollectionUtils.isNotEmpty(inInventoryDetails)) {
				for (InInventoryDetail inInventoryDetail : inInventoryDetails) {
					if (!StringUtils.isNoneBlank(inInventoryDetail.getMaterialId())) {
						resultEntity.setMsg("物资编码不能为空");
						return resultEntity;
					}
					if (inInventoryDetail.getGoodsNum()==null) {
						resultEntity.setMsg("到货数量不能为空");
						return resultEntity;
					}
					if (inInventoryDetail.getTaxPrice()==null) {
						resultEntity.setMsg("含税单价不能为空");
						return resultEntity;
					}
					if (!StringUtils.isBlank(inInventoryDetail.getManufactureDate())) {
						inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
					}
					lists.add(inInventoryDetail);
				}
				inInventoryDetailMapper.insertList(lists);
			}
		}
		//提交
		if ("02".equals(inInventory.getStatus())) {
			if (!StringUtils.isNoneBlank(inInventory.getArchitectureId())) {
				resultEntity.setMsg("风电场id不能为空");
				return resultEntity;
			}
			if (!StringUtils.isNoneBlank(inInventory.getStockAddId())) {
				resultEntity.setMsg("库存地id不能为空");
				return resultEntity;
			}
			if (inInventory.getInInventoryTime()==null) {
				resultEntity.setMsg("入库日期不能为空");
				return resultEntity;
			}
			if (!StringUtils.isNoneBlank(inInventory.getTypeCode())) {
				resultEntity.setMsg("入库类型不能为空");
				return resultEntity;
			}
			if("01".equals(inInventory.getInInventoryType())){
				String maxOrder= commonService.customOrder("02", inInventoryMapper.getMaxInInventoryOrder("01"));
				inInventory.setInInventoryOrder(maxOrder);
			}
			if("02".equals(inInventory.getInInventoryType())){
				String maxOrder= commonService.customOrder("03", inInventoryMapper.getMaxInInventoryOrder("02"));
				inInventory.setInInventoryOrder(maxOrder);
			}
			inInventoryMapper.updateByPrimaryKeySelective(inInventory);
			// 删除旧详情数据
			inInventoryDetailMapper.delByInInventoryId(inInventory.getInInventoryId());
			// 添加新详情数据
			List<InInventoryDetail> lists = new ArrayList<>();
			List<InInventoryDetail> inInventoryDetails = inInventory.getInInventoryDetails();
			if (CollectionUtils.isNotEmpty(inInventoryDetails)) {
				for (InInventoryDetail inInventoryDetail : inInventoryDetails) {
					if (!StringUtils.isNoneBlank(inInventoryDetail.getMaterialId())) {
						resultEntity.setMsg("物资编码不能为空");
						return resultEntity;
					}
					if (inInventoryDetail.getGoodsNum()==null) {
						resultEntity.setMsg("到货数量不能为空");
						return resultEntity;
					}
					if (inInventoryDetail.getTaxPrice()==null) {
						resultEntity.setMsg("含税单价不能为空");
						return resultEntity;
					}
					if (!StringUtils.isBlank(inInventoryDetail.getManufactureDate())) {
						inInventoryDetail.setManufactureDay(format.parse(inInventoryDetail.getManufactureDate()));
					}
					lists.add(inInventoryDetail);
				}
				inInventoryDetailMapper.insertList(lists);
			}
			this.createProcessAndDoListAndApproveRecord(inInventory, resultEntity);
		}

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("操作成功");
		return resultEntity;
	}

	@Override
	public ResultEntity updateOrderStatus(InInventory inInventory) throws Exception {
		ResultEntity resultEntity = new ResultEntity();

		String inInventoryId = inInventory.getInInventoryId();
		String approvalStatus = inInventory.getApprovalStatus();
		String approvalOpinion = inInventory.getApprovalOpinion();

		if (!StringUtils.isNoneBlank(inInventoryId)) {
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}

		InInventory inInventoryInfo= inInventoryMapper.selectByPrimaryKey(inInventoryId);
		if(inInventoryInfo==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("入库单信息异常，确认传入Id");
			return resultEntity;
		}
		if(!"02".equals(inInventoryInfo.getStatus())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请选择处于待审核状态的入库单");
			return resultEntity;
		}
		//入库审批同意后,修改库存表及库存明细
		if ("03".equals(approvalStatus)) {
			//获取流程主表
			ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(inInventoryId, "01");
			Process process = (Process)processResultEntity.getData();

			//获取流程步数
			ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
			int totalSort = (Integer) totalSortResultEntity.getData();

			if (process!=null && totalSort!=0) {
				//判断流程是否已经结束
				if (process.getProcessSort()==totalSort) {
					resultEntity.setMsg("流程已结束,无法进行操作");
					return resultEntity;
				}
				if ("03".equals(process.getProcessStatus())) {
					resultEntity.setMsg("审核未通过的无法再操作");
					return resultEntity;
				}
				//获取流程详情
				ResultEntity processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()+1));
				ProcessDetail processDetail = (ProcessDetail) processDetailResultEntity.getData();
				if (processDetail!=null) {
					//判断权限
					boolean flag = true;
					List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
					if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
						for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
							try {
								List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
								for (Role role:userRoleList) {
									if (processDetailRoleRela.getRoleId().equals(role.getRoleId())) {
										flag = false;
									}
								}
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
						if (flag) {
							resultEntity.setMsg("您无此权限");
							return resultEntity;
						}
					}

					//生成流程审批记录
					ApproveRecord approveRecord = new ApproveRecord();
					approveRecord.setApproveId(UUIdUtil.getUUID());
					approveRecord.setOrderId(inInventoryId);
					approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
					approveRecord.setApproveResult("通过");
					approveRecord.setApproveUser(currentUserService.getId());
					approveRecord.setApproveTime(new Date());
					approveRecord.setApproveOpinion(approvalOpinion);
					//将流程审批记录插入数据库
					approveRecordService.addApproveRecord(approveRecord);
				}

				//修改流程详情
				processDetail.setStatus("02");
				processService.updateProcessDetail(processDetail);

				if (totalSort-process.getProcessSort()>1) {
					processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 2));
					processDetail = (ProcessDetail) processDetailResultEntity.getData();
					if (processDetail != null) {
						List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
						if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
							//获取代办信息
							ResultEntity doListResultEntity = doListService.findDoListByTaskId(inInventoryId);
							DoList doList = (DoList) doListResultEntity.getData();
							if (doList != null) {
								//修改代办角色关联列表
								List<DoRoleRela> doRoleRelas = new ArrayList<>();
								for (ProcessDetailRoleRela processDetailRoleRela : processDetailRoleRelas) {
									DoRoleRela doRoleRela = new DoRoleRela();
									doRoleRela.setRelaId(UUIdUtil.getUUID());
									doRoleRela.setDoId(doList.getDoId());
									doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
									doRoleRelas.add(doRoleRela);
								}
								doListService.updateDoList(inInventoryId, doRoleRelas);
							}
						}
					}
				}

				//如果当前是最后一步修改流程主表,流程结束
				if (totalSort-process.getProcessSort()==1) {
					//获取代办信息
					ResultEntity doListResultEntity = doListService.findDoListByTaskId(inInventoryId);
					DoList doList = (DoList) doListResultEntity.getData();
					if (doList != null) {
						//修改代办角色关联列表
						List<DoRoleRela> doRoleRelas = new ArrayList<>();
						doListService.updateDoList(inInventoryId, doRoleRelas);
					}
					//修改流程主表中的状态为完成
					process.setProcessStatus("02");

					//物资入库
					this.createInventroyAndInventoryDetail(inInventoryInfo,resultEntity);

					//修改入库单状态为审核完成
					inInventoryInfo.setStatus("03");
					inInventoryMapper.updateByPrimaryKeySelective(inInventoryInfo);
				}
				process.setProcessSort(process.getProcessSort()+1);
				processService.updateProcess(process);
			}
		}
		if ("04".equals(approvalStatus)) {
			//获取流程主表
			ResultEntity processResultEntity = processService.getProcessByOrderIdAndType(inInventoryId, "01");
			Process process = (Process)processResultEntity.getData();

			//获取流程步数
			ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
			int totalSort = (Integer) totalSortResultEntity.getData();

			if (process!=null && totalSort!=0) {
				//处理中的流程才能退回
				if ("03".equals(process.getProcessStatus())) {
					resultEntity.setMsg("审核未通过的无法再操作");
					return resultEntity;
				}
				//若流程步骤为0,则无法退回
				if (process.getProcessSort()==0) {
					resultEntity.setMsg("当前步骤无法退回");
					return resultEntity;
				}
				//判断流程是否已经结束
				if (process.getProcessSort()==totalSort) {
					resultEntity.setMsg("流程已结束,无法进行操作");
					return resultEntity;
				}
				//获取流程详情
				ResultEntity processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 1));
				ProcessDetail processDetail = (ProcessDetail) processDetailResultEntity.getData();
				if (processDetail!=null) {
					//判断权限
					boolean flag = true;
					List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
					if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
						for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
							try {
								List<Role> userRoleList = roleService.findUserRoleList(currentUserService.getId());
								for (Role role:userRoleList) {
									if (processDetailRoleRela.getRoleId().equals(role.getRoleId())) {
										flag = false;
									}
								}
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
						if (flag) {
							resultEntity.setMsg("您无此权限");
							return resultEntity;
						}
					}
					//生成流程审批记录
					ApproveRecord approveRecord = new ApproveRecord();
					approveRecord.setApproveId(UUIdUtil.getUUID());
					approveRecord.setOrderId(inInventoryId);
					approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
					approveRecord.setApproveResult("拒绝");
					approveRecord.setApproveUser(currentUserService.getId());
					approveRecord.setApproveTime(new Date());
					approveRecord.setApproveOpinion(approvalOpinion);
					//将流程审批记录插入数据库
					approveRecordService.addApproveRecord(approveRecord);
				}

				//获取上一步流程详情
				processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
				processDetail = (ProcessDetail) processDetailResultEntity.getData();
				if (processDetail!=null) {
					//流程主表状态往后退一步
					//process.setProcessSort(process.getProcessSort()-1);
                /*if (process.getProcessSort()==0) {
                    process.setProcessStatus("");
                    //设置入库单状态为未提交
                    inInventoryInfo.setStatus("01");

                }*/
					//修改流程主表中的状态未审核未通过
					process.setProcessStatus("03");
					processService.updateProcess(process);

					//设置入库单状态为审核未通过
					inInventoryInfo.setStatus("04");
					inInventoryMapper.updateByPrimaryKeySelective(inInventoryInfo);

					//修改上一步流程详情为待办
                /*processDetail.setStatus("01");
                processService.updateProcessDetail(processDetail);*/

					//List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
					//if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
					//获取代办信息
					ResultEntity doListResultEntity = doListService.findDoListByTaskId(inInventoryId);
					DoList doList = (DoList)doListResultEntity.getData();
					if (doList!=null) {
						//修改代办角色关联列表
						List<DoRoleRela> doRoleRelas = new ArrayList<>();
                        /*for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
                            DoRoleRela doRoleRela = new DoRoleRela();
                            doRoleRela.setRelaId(UUIdUtil.getUUID());
                            doRoleRela.setDoId(doList.getDoId());
                            doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
                            doRoleRelas.add(doRoleRela);
                        }*/
						doListService.updateDoList(inInventoryId,doRoleRelas);
					}
					//}
				}
			}
		}

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("审核成功");
		return resultEntity;
	}

	private boolean checkOrderIsExit(InInventory inInventory) {
		InInventoryExample example = new InInventoryExample();
		example.createCriteria().andInInventoryOrderEqualTo(inInventory.getInInventoryOrder()).andInInventoryTypeEqualTo(inInventory.getInInventoryType());
		int count  = inInventoryMapper.countByExample(example);
		if(count>0){
			return true;
		}else{
		return false;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultEntityDetail getDetailInInventory(String inInventoryId) {
		ResultEntityDetail resultEntity = new ResultEntityDetail();
	    InInventory inInventory =inInventoryMapper.selectByPrimaryKey(inInventoryId);
	    if(inInventory==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("入库单不存在");
		}else{
			inInventory.setStatusName(this.getStatusName(inInventory.getStatus()));
			resultEntity.setCode(ErrorCode.SUCCESS);

	    	resultEntity.setData(inInventory);
	    }
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity delInInventory(List<String> inInventoryIds) {
		ResultEntity resultEntity = new ResultEntity();
		 InInventoryExample example = new InInventoryExample();
		 example.setIsPage(0);
		 example.createCriteria().andInInventoryIdIn(inInventoryIds).andStatusEqualTo("01");
		 int count = inInventoryMapper.countByExample(example);
		 if(count<inInventoryIds.size()){
			 resultEntity.setCode(ErrorCode.ERROR);
			 resultEntity.setMsg("待审核或已审核的入库单无法删除，请重新确认");
			 return resultEntity;
		 }

		inInventoryMapper.deleteByIds(inInventoryIds);
		inInventoryDetailMapper.deleteByIds(inInventoryIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}

	@Override
	public String getMaxInInventoryOrder(String inInventoryType) {
		
		return inInventoryMapper.getMaxInInventoryOrder(inInventoryType);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getStageInventoryDetailList(InInventoryDetailExample example) {
		NewPageResult pageResultEntity = new NewPageResult();
		int count = inInventoryDetailMapper.countByExample(example);
		pageResultEntity.setTotal(count);
		List<InInventoryDetail> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=inInventoryDetailMapper.selectByExample(example);
		}
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		return pageResultEntity;
	}

	private String getStatusName(String status) {
		if ("01".equals(status)) {
			return "未提交";
		}
		if ("02".equals(status)) {
			return "待审核";
		}
		if ("03".equals(status)) {
			return "已通过";
		}
		if ("04".equals(status)) {
			return "未通过";
		}
		if ("05".equals(status)) {
			return "已入库";
		}
		return null;
	}

	private ResultEntity createInventroyAndInventoryDetail(InInventory inInventory,ResultEntity resultEntity) throws Exception {
		System.err.println(inInventory.getStatus()+"----------");
		String isNegative = inInventoryMapper.getNegativeByTypeCode(inInventory.getTypeCode());

		if (!("02".equals(isNegative) || "01".equals(isNegative))) {
			resultEntity.setMsg("该出入库类型不存在");
			return resultEntity;
		}

		//如果是入库
		if ("02".equals(isNegative)) {
			//获取物资列表
			InInventoryDetailExample example = new InInventoryDetailExample();
			example.setIsPage(0);
			example.createCriteria().andInInventoryIdEqualTo(inInventory.getInInventoryId());
			List<InInventoryDetail> inInventoryDetailList = inInventoryDetailMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(inInventoryDetailList)) {
				List<String> list = new ArrayList<>();
				for (InInventoryDetail inInventoryDetail:inInventoryDetailList) {
					//如果验证结果是01正常,设置入库状态为01正常
					if ("01".equals(inInventoryDetail.getCheckResults())) {
						//根据物资id,库存id,状态判断该物资是否有库存
						InventoryExample inventoryExample = new InventoryExample();
						InventoryExample.Criteria criteria = inventoryExample.createCriteria();
						criteria.andMaterialIdEqualTo(inInventoryDetail.getMaterialId());
						criteria.andStockAddIdEqualTo(inInventory.getStockAddId());
						criteria.andStatusEqualTo("01");
						List<Inventory> inventoryList = inventoryMapper.selectByExample(inventoryExample);
						Inventory inventory = null;
						if (CollectionUtils.isNotEmpty(inventoryList)) {
							//获取当前库存记录
							inventory = inventoryList.get(0);
							inventory.setInventoryNum(inventory.getInventoryNum()+inInventoryDetail.getGoodsNum());
							inventory.setInventoryAmount(inventory.getInventoryAmount().add(inInventoryDetail.getTaxAmount()));
							inventoryMapper.updateByPrimaryKeySelective(inventory);
						}else {
							//创建新的库存记录
							inventory = new Inventory();
							inventory.setInventoryId(UUIdUtil.getUUID());
							inventory.setMaterialId(inInventoryDetail.getMaterialId());
							inventory.setWindId(inInventory.getArchitectureId());
							inventory.setStockAddId(inInventory.getStockAddId());
							inventory.setInventoryNum(inInventoryDetail.getGoodsNum());
							inventory.setInventoryAmount(inInventoryDetail.getTaxAmount());
							inventory.setStatus("01");
							inventoryMapper.insertSelective(inventory);
						}
						//修改库存后,记录库存操作记录
						IventoryDetail iventoryDetail = new IventoryDetail();
						iventoryDetail.setInventoryId(UUIdUtil.getUUID());
						iventoryDetail.setAssoId(inInventory.getInInventoryId());
						iventoryDetail.setMaterialId(inInventoryDetail.getMaterialId());
						iventoryDetail.setWindId(inInventory.getArchitectureId());
						iventoryDetail.setStockAddId(inInventory.getStockAddId());
						iventoryDetail.setInventoryNum(inInventoryDetail.getGoodsNum());
						iventoryDetail.setInventoryAmount(inInventoryDetail.getTaxAmount());
						iventoryDetail.setTypeCode(inInventory.getTypeCode());
						iventoryDetail.setAccessType("01");
						try {
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
							iventoryDetail.setCreateDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						iventoryDetailMapper.insertSelective(iventoryDetail);
					}
					if ("02".equals(inInventoryDetail.getCheckResults())) {
						throw new Exception("部分物资不合格,无法入库");
					}
				}
			}
		}

		//如果是冲销出库
		if ("01".equals(isNegative)) {
			//获取物资列表
			InInventoryDetailExample example = new InInventoryDetailExample();
			example.setIsPage(0);
			example.createCriteria().andInInventoryIdEqualTo(inInventory.getInInventoryId());
			List<InInventoryDetail> inInventoryDetailList = inInventoryDetailMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(inInventoryDetailList)) {
				List<String> list = new ArrayList<>();
				for (InInventoryDetail inInventoryDetail:inInventoryDetailList) {
					//如果验证结果是01正常,设置入库状态为01正常
					if ("01".equals(inInventoryDetail.getCheckResults())) {
						//根据物资id,库存id,状态判断该物资是否有库存
						InventoryExample inventoryExample = new InventoryExample();
						InventoryExample.Criteria criteria = inventoryExample.createCriteria();
						criteria.andMaterialIdEqualTo(inInventoryDetail.getMaterialId());
						criteria.andStockAddIdEqualTo(inInventory.getStockAddId());
						criteria.andStatusEqualTo("01");
						List<Inventory> inventoryList = inventoryMapper.selectByExample(inventoryExample);
						Inventory inventory = null;
						if (CollectionUtils.isNotEmpty(inventoryList)) {
							//获取当前库存记录
							inventory = inventoryList.get(0);
							if (inventory.getInventoryNum()-inInventoryDetail.getGoodsNum()<0) {
								throw new Exception("冲销数量不能大于库存数量");
							}
							if (inventory.getInventoryAmount().subtract(inInventoryDetail.getTaxAmount()).intValue()<0) {
								throw new Exception("冲销金额不能大于库存金额");
							}
							inventory.setInventoryNum(inventory.getInventoryNum()-inInventoryDetail.getGoodsNum());
							inventory.setInventoryAmount(inventory.getInventoryAmount().subtract(inInventoryDetail.getTaxAmount()));
							inventoryMapper.updateByPrimaryKeySelective(inventory);
						}else {
							//物资不存在
							throw new Exception("库存不足,无法冲销");
						}
						//修改库存后,记录库存操作记录
						IventoryDetail iventoryDetail = new IventoryDetail();
						iventoryDetail.setInventoryId(UUIdUtil.getUUID());
						iventoryDetail.setAssoId(inInventory.getInInventoryId());
						iventoryDetail.setMaterialId(inInventoryDetail.getMaterialId());
						iventoryDetail.setWindId(inInventory.getArchitectureId());
						iventoryDetail.setStockAddId(inInventory.getStockAddId());
						iventoryDetail.setInventoryNum(inInventoryDetail.getGoodsNum());
						iventoryDetail.setInventoryAmount(inInventoryDetail.getTaxAmount());
						iventoryDetail.setTypeCode(inInventory.getTypeCode());
						iventoryDetail.setAccessType("01");
						try {
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
							iventoryDetail.setCreateDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						iventoryDetailMapper.insertSelective(iventoryDetail);
					}
					if ("02".equals(inInventoryDetail.getCheckResults())) {
						throw new Exception("部分物资不合格,无法入库");
					}
				}
			}
		}
		return null;
	}

	private ResultEntity createProcessAndDoListAndApproveRecord(InInventory inInventory,ResultEntity resultEntity) throws Exception {
		if ("02".equals(inInventory.getStatus()) && "01".equals(inInventory.getInInventoryType())) {
			//获取流程配置
			DeployMain deployMain = deployService.queryDeployMainById("5");
			if (deployMain!=null) {
				//生成流程主表,流程详情,流程角色配置
				Process process = new Process();
				process.setProcessId(UUIdUtil.getUUID());
				process.setOrderId(inInventory.getInInventoryId());
				process.setProcessSort(1);
				process.setProcessType("01");
				process.setProcessStatus("01");
				process.setCreateTime(new Date());
				List<Deploy> deploys = deployMain.getDeploys();
				if (CollectionUtils.isNotEmpty(deploys)) {
					for (Deploy deploy:deploys) {
						ProcessDetail processDetail = new ProcessDetail();
						processDetail.setProcessDetailId(UUIdUtil.getUUID());
						processDetail.setProcessId(process.getProcessId());
						processDetail.setSort(deploy.getDeploySort());
						processDetail.setName(deploy.getDeployName());
						processDetail.setStatus("01");
						process.getProcessDetails().add(processDetail);
						List<Role> roles = deploy.getRoles();
						if (CollectionUtils.isNotEmpty(roles)) {
							for (Role role:roles) {
								ProcessDetailRoleRela processDetailRoleRela = new ProcessDetailRoleRela();
								processDetailRoleRela.setRelaId(UUIdUtil.getUUID());
								processDetailRoleRela.setProcessDetailId(processDetail.getProcessDetailId());
								processDetailRoleRela.setRoleId(role.getRoleId());
								processDetail.getProcessDetailRoleRelas().add(processDetailRoleRela);
							}
						}
					}
				}
				//将流程主表,流程详情,流程角色配置插入数据库
				processService.addProcess(process);

				//修改流程详情第一步为已完成
				ResultEntity processDetailResultEntity= processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()));
				ProcessDetail processDetail = (ProcessDetail)processDetailResultEntity.getData();
				if (processDetail!=null) {
					//更新数据库中的流程详情第一步为完成
					processDetail.setStatus("02");
					processService.updateProcessDetail(processDetail);

					//生成流程审批记录
					ApproveRecord approveRecord = new ApproveRecord();
					approveRecord.setApproveId(UUIdUtil.getUUID());
					approveRecord.setOrderId(inInventory.getInInventoryId());
					approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
					approveRecord.setApproveResult("提交成功");
					approveRecord.setApproveUser(currentUserService.getId());
					approveRecord.setApproveTime(new Date());
					//将流程审批记录插入数据库
					approveRecordService.addApproveRecord(approveRecord);
				}

				//获取流程第二步
				processDetailResultEntity= processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort()+1));
				processDetail = (ProcessDetail)processDetailResultEntity.getData();
				if (processDetail!=null) {
					//生成代办信息,代办关联的角色列表
					DoList doList = new DoList();
					doList.setDoId(UUIdUtil.getUUID());
					doList.setTaskId(inInventory.getInInventoryId());
					doList.setTaskDescribe(inInventory.getInInventoryOrder());
					doList.setTaskType("01");
					doList.setCreateTime(new Date());
					List<DoRoleRela> doRoleRelas = new ArrayList<>();
					List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
					for (ProcessDetailRoleRela processDetailRoleRela:processDetailRoleRelas) {
						DoRoleRela doRoleRela = new DoRoleRela();
						doRoleRela.setRelaId(UUIdUtil.getUUID());
						doRoleRela.setDoId(doList.getDoId());
						doRoleRela.setRoleId(processDetailRoleRela.getRoleId());
						doRoleRelas.add(doRoleRela);
					}
					doList.setDoRoleRelas(doRoleRelas);
					//将代办信息,代办关联的角色列表插入数据库
					doListService.addDoList(doList);
				}
			}
		}
		return resultEntity;
	}

	@Override
	public NewPageResult importMaterial(MultipartFile file) {
		NewPageResult result = new NewPageResult();
		if(file.isEmpty()){
			result.setCode(ErrorCode.ERROR);
			result.setMsg("文件不能为空");
			return result;
		}
		Workbook wb=null;
		try {
		String fileName=file.getOriginalFilename();
		String extension = fileName.substring(fileName.lastIndexOf('.')+1);
		if("xls".equals(extension)){
			new HSSFWorkbook(file.getInputStream());
		}else if ("xlsx".equals(extension)) {
			wb = new XSSFWorkbook(file.getInputStream());
		} else {
			try {
				if (file.getInputStream() != null)
					file.getInputStream().close();
			} catch (IOException localIOException) {
			}
			result.setCode(ErrorCode.ERROR);
			result.setMsg("不支持的文件类型! 目前只支持xls或xlsx后缀名的Excel文件!");
			return result;
		}
		List<InInventoryDetail> details = new ArrayList<>();
		Map<String,String> m=new HashMap();
		List<String> materialCodes=new ArrayList<String>();
		int i = 0;
		int r = 0;
		String value = null;
		Cell cell = null;
		Integer value1 = null;
		BigDecimal value2=BigDecimal.ZERO;
		String[] headers = {"物资编码","物资名称","到货数量","含税单价","税率%","备注"};
		
		Sheet sheet1 = wb.getSheetAt(0);
		for (Row row : sheet1) {
			InInventoryDetail inInventoryDetail = new InInventoryDetail();
			i = 0;
			if (r == 0) {
				NewPageResult rs = checkHeader(r, row, headers);
				if(rs.getCode()==ErrorCode.ERROR){
					result.setCode(ErrorCode.ERROR);
					result.setMsg(rs.getMsg());
					return result;			
				}
			} else {
				if (ExcelUtils.isBlankRow(row, headers))
					continue;
			    //物资编码
				cell = row.getCell(i++);
			//
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							MaterialExample materialExample = new MaterialExample();
							materialExample.createCriteria().andMaterialCodeEqualTo(value).andIsDeleteEqualTo("01");
							List<Material> list2 = materialMapper.selectByExample(materialExample);
							if (list2.size()==0) {
								result.setCode(ErrorCode.ERROR);
								result.setMsg("第" + (r + 1) + "行物资编码不存在");
								return result;
							} else {
								Material material = list2.get(0);
								inInventoryDetail.setMaterialId(material.getMaterialId());
								inInventoryDetail.setMaterialCode(value);
								inInventoryDetail.setMaterialName(material.getMaterialName());
								inInventoryDetail.setSpecifications(material.getSpecifications());
								inInventoryDetail.setMeasuringUnitName(material.getMeasuringUnitName());
								if(materialCodes.contains(value)){
									result.setCode(ErrorCode.ERROR);
									result.setMsg("第" + (r + 1) + "行物资编码出现重复");
									return result;
								}
								
								materialCodes.add(value);
							}

						}
					} else {
						result.setCode(ErrorCode.ERROR);
						result.setMsg("第" + (r + 1) + "行物资编码不能为空");
						return result;
					}
				    //物资名称
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						Long num = null;
						if (cell.getCellTypeEnum() == CellType.STRING) {
							value = cell.getStringCellValue();
						} else {
							num = (long) cell.getNumericCellValue();
							value = num.toString();
						}
						if (StringUtils.isNotBlank(value)) {
						
						}
					}
					
					//到货数量
					cell = row.getCell(i++);
					if (cell != null) {
						value1 = (int) cell.getNumericCellValue();
						Long num = null;
						if (cell.getCellTypeEnum() == CellType.STRING) {
							value1 = (int) cell.getNumericCellValue();
						} else {
							num = (long) cell.getNumericCellValue();
							value = num.toString();
						}
						if (value1<1) {
							result.setCode(ErrorCode.ERROR);
							result.setMsg("第"+(r+1)+"到货数量必须大于0");
							return result;
						}else{
							inInventoryDetail.setGoodsNum(value1);
						}
					}else{
						result.setCode(ErrorCode.ERROR);
						result.setMsg("第"+(r+1)+"到货数量不能为空");
						return result;
					}
					
					//含税单价
					cell = row.getCell(i++);
					if (cell != null) {
						value2 = new BigDecimal(Double.toString(cell.getNumericCellValue()));
						Long num = null;
						if (cell.getCellTypeEnum() == CellType.STRING) {
							value2 = new BigDecimal(cell.getNumericCellValue());
						} else {
							num = (long) cell.getNumericCellValue();
							value = num.toString();
						}
						if (StringUtils.isNotBlank(value)) {
							inInventoryDetail.setTaxPrice(value2);
						}
					}else{
						result.setCode(ErrorCode.ERROR);
						result.setMsg("第"+(r+1)+"行含税单价不能为空");
						return result;
					}
                    //税率
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						Long num = null;
						if (cell.getCellTypeEnum() == CellType.STRING) {
							value = cell.getStringCellValue();
						} else {
							num = (long) cell.getNumericCellValue();
							value = num.toString();
						}
						if (StringUtils.isNotBlank(value)) {
							inInventoryDetail.setTaxBill(value);
						}
					}
					//备注
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						Long num = null;
						if (cell.getCellTypeEnum() == CellType.STRING) {
							value = cell.getStringCellValue();
						} else {
							num = (long) cell.getNumericCellValue();
							value = num.toString();
						}
						if (StringUtils.isNotBlank(value)) {
							inInventoryDetail.setRemark(value);
						}
					}
					details.add(inInventoryDetail);

			}
			r++;
		}
		
		result.setTotal(details.size());
		result.setRows(details);
		result.setCode(ErrorCode.SUCCESS);
		result.setMsg("导入成功!");
	    return result;
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static NewPageResult checkHeader(int r, Row row, String[] headers) throws Exception {
		NewPageResult result = new NewPageResult();
		Cell cell = null;
		String value = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.getCell(i);
			if (cell == null&&i==0) {
				//throw new Exception("第" + (r + 1) + "行第1列为空");
				result.setCode(ErrorCode.ERROR);
				result.setMsg("第" + (r + 1) + "行第"+i+"列为空");
				return result;
			}
			if (cell.getCellTypeEnum() == CellType.STRING) {
				value = cell.getStringCellValue();
				if (!headers[i].equals(value)) {
//					throw new Exception();
					result.setCode(ErrorCode.ERROR);
					result.setMsg("第" + (r + 1) + "行第" + (i + 1) + "列的内容不是'" + headers[i] + "'");
					return result;
				}
			} else {
	//			throw new Exception("第" + (r + 1) + "行第" + (i + 1) + "列类型不是字符串");
				result.setCode(ErrorCode.ERROR);
				result.setMsg("第" + (r + 1) + "行第" + (i + 1) + "列类型不是字符串");
				return result;
			}
		}
		result.setCode(ErrorCode.SUCCESS);
		return result;
	}
}
