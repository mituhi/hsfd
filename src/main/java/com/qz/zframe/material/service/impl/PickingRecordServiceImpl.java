package com.qz.zframe.material.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.dao.DeployDao;
import com.qz.zframe.common.dao.DoListDao;
import com.qz.zframe.common.dao.ProcessDetailMapper;
import com.qz.zframe.common.dao.ProcessDetailRoleRelaMapper;
import com.qz.zframe.common.dao.ProcessMapper;
import com.qz.zframe.common.entity.ApproveRecord;
import com.qz.zframe.common.entity.DataDict;
import com.qz.zframe.common.entity.Deploy;
import com.qz.zframe.common.entity.DeployMain;
import com.qz.zframe.common.entity.DoList;
import com.qz.zframe.common.entity.DoRoleRela;
import com.qz.zframe.common.entity.Process;
import com.qz.zframe.common.entity.ProcessDetail;
import com.qz.zframe.common.entity.ProcessDetailRoleRela;
import com.qz.zframe.common.entity.Role;
import com.qz.zframe.common.entity.SpFileUpload;
import com.qz.zframe.common.service.ApproveRecordService;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.service.DataDictService;
import com.qz.zframe.common.service.DeployService;
import com.qz.zframe.common.service.DoListService;
import com.qz.zframe.common.service.ProcessService;
import com.qz.zframe.common.service.RoleService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.material.dao.InventoryMapper;
import com.qz.zframe.material.dao.PickingRecordDetailMapper;
import com.qz.zframe.material.dao.PickingRecordMapper;
import com.qz.zframe.material.dao.WorkOrderMaterialsMapper;
import com.qz.zframe.material.entity.Inventory;
import com.qz.zframe.material.entity.InventoryExample;
import com.qz.zframe.material.entity.MaterialGroup;
import com.qz.zframe.material.entity.PickingRecord;
import com.qz.zframe.material.entity.PickingRecordDetail;
import com.qz.zframe.material.entity.PickingRecordDetailExample;
import com.qz.zframe.material.entity.PickingRecordExample;
import com.qz.zframe.material.entity.WorkOrderMaterials;
import com.qz.zframe.material.enums.StockMaterialStatusEnum;
import com.qz.zframe.material.service.PickingRecordService;
import com.qz.zframe.material.service.StockService;
import com.qz.zframe.tickets.entity.WorkTicket;

@Transactional(rollbackFor = Exception.class)
@Service
public class PickingRecordServiceImpl implements PickingRecordService{
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	//领料基本信息
	@Autowired
	private PickingRecordMapper pickingRecordMapper;
	
	
	//领/退料物资明细
	@Autowired
	private PickingRecordDetailMapper pickingRecordDetailMapper;
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	//通用
	@Autowired
	private CommonService commonService;
	
	//字典
	@Autowired
	private DataDictService dataDictService;
	
	//库存物资
	@Autowired
	private InventoryMapper inventoryMapper;
	
	@Autowired
	private StockService stockService;
	
	//工作流
	@Autowired
	private DeployDao deployDao;
	
	//流程
	@Autowired
	private ProcessMapper processMapper;

	//流程明细
	@Autowired
	private ProcessDetailMapper processDetailMapper;

	//流程角色
	@Autowired
	private ProcessDetailRoleRelaMapper processDetailRoleRelaMapper;
	
	//待办
	@Autowired
	private DoListDao doListDao;
	
	@Autowired
	private DeployService deployService;
	
	@Autowired
    private ProcessService processService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private ApproveRecordService approveRecordService;
	
	
	@Autowired
    private DoListService doListService;
	
    @Autowired
	private WorkOrderMaterialsMapper workOrderMaterialsMapper;
	
 	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getPickRecordList(PickingRecordExample example) throws Exception {
		NewPageResult resultEntity = new NewPageResult();
		int count = pickingRecordMapper.countByExample(example);
		resultEntity.setTotal(count);
		List<PickingRecord> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=pickingRecordMapper.selectByExample(example);
			makeCodeType(list);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult<PickingRecord> getPickRecordByOrderNo(PickingRecordExample example, String pickType) {
		NewPageResult resultEntity = new NewPageResult();
		int count = pickingRecordMapper.countByExample(example);
		resultEntity.setTotal(count);
		List<PickingRecord> list;
		if(count==0){
			list=Collections.emptyList();
			resultEntity.setCode(ErrorCode.SUCCESS);
			return resultEntity;
		}else{
			list=pickingRecordMapper.selectByExample(example);
			String pickingType=list.get(0).getPickingType();
			String approStatus=list.get(0).getApprovalStatus();
			if(pickingType.equals("212")||pickingType.equals("202")){
			    resultEntity.setCode(ErrorCode.ERROR);
			    resultEntity.setMsg("所选领料单属于退料单，无法进行退料操作");
			    return resultEntity;
			}
			if(!approStatus.equals("03")){
				resultEntity.setCode(ErrorCode.ERROR);
			    resultEntity.setMsg("所选领料单未通过审核，无法进行退料操作");
			    return resultEntity;
			}
			if(!StringUtils.isBlank(pickType)){
				if(pickType.equals("212")){
					if(!pickingType.equals("211")){
						resultEntity.setCode(ErrorCode.ERROR);
					    resultEntity.setMsg("部门退料时所选领料单类型必须为部门领料");
					    return resultEntity;
					}
				}
				if(pickType.equals("202")){
					if(!pickingType.equals("201")){
						resultEntity.setCode(ErrorCode.ERROR);
					    resultEntity.setMsg("工单退料时所选领料单类型必须为工单领料");
					    return resultEntity;
					}
				}
			}
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}
	
	
	private List<PickingRecord> makeCodeType(List<PickingRecord> list) throws Exception {
		List<String> codeTypes = new ArrayList<String>();
		codeTypes.add("MATERIAL_AUDIT_STATUS");
		List<DataDict> dataDicts = dataDictService.findDataDictsByCodeType(codeTypes);
		if (dataDicts != null && !dataDicts.isEmpty()) {
			for(PickingRecord m : list) {
				for(DataDict d : dataDicts) {
					if ("MATERIAL_AUDIT_STATUS".equals(d.getCodeTypeName()) && m.getApprovalStatus().equals(d.getName())) {
						m.setApprovalStatusText(d.getTitle());
						m.setValue(m.getPickingOrder());
					}
				}
			}
		}
		return list;
	}
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getPickRecordDetail(String pickingId) {
		NewPageResult resultEntity = new NewPageResult();
		PickingRecordExample example = new PickingRecordExample();
		example.createCriteria().andPickingIdEqualTo(pickingId);
		List<PickingRecord> list=pickingRecordMapper.selectByExample(example);
		if(list==null||list.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("请传入正确的领料单Id");		
		}else{
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list.get(0));
			resultEntity.setTotal(1);
		}
		return resultEntity;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity addPickRecord(PickingRecord pickingRecord) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		String approvalStatus=pickingRecord.getApprovalStatus();
		if(StringUtils.isBlank(approvalStatus)){
			resultEntity.setCode(ErrorCode.ERROR); 
			resultEntity.setMsg("提交状态不能为空");
			return resultEntity;
		}
		//领用类型
		String pickType=pickingRecord.getPickingType();
		//风电场编码
		String windId=pickingRecord.getWindId();
		//仓库
		String pickingOrder=pickingRecord.getPickingOrder().equals("")?null:pickingRecord.getPickingOrder();
		String stockAddId=pickingRecord.getStockAddId();
		String pickingId=UUIdUtil.getUUID();
		pickingRecord.setPickingOrder(pickingOrder);
		pickingRecord.setPickingId(pickingId);
		pickingRecord.setCreateTime(new Date());
		UserInfo userInfo = currentUSerservice.getUserInfo();
		pickingRecord.setCreater(userInfo.getUserId());
		
	try {
		//保存状态
		if(approvalStatus.equals("01")){	
		pickingRecordMapper.insertSelective(pickingRecord);
		List<PickingRecordDetail> list = new ArrayList<>();
		if(pickingRecord.getRecordDetails()!=null&&!pickingRecord.getRecordDetails().isEmpty()){
		for(PickingRecordDetail pickingRecordDetail:pickingRecord.getRecordDetails()){
			pickingRecordDetail.setPickingDetailId(UUIdUtil.getUUID());
			pickingRecordDetail.setPickingId(pickingId);
			list.add(pickingRecordDetail);
		}	
		  pickingRecordDetailMapper.insertList(list);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("新增成功");
		}
		//提交状态
		if(approvalStatus.equals("02")){
			if(StringUtils.isBlank(pickingRecord.getPickingType())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("领料类型不能为空");
				return resultEntity;
			}else{
				if(pickType.equals("201")){
					if(StringUtils.isBlank(pickingRecord.getWorkOrder())){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("工单号不能为空");
						return resultEntity;
					}
				}
				if(pickType.equals("212")||pickType.equals("202")){
					if(StringUtils.isBlank(pickingRecord.getReturnPickingOrder())||StringUtils.isBlank(pickingRecord.getReturnPickingId())){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("退料时所退领料单信息不能为空");
						return resultEntity;
					}else{
						PickingRecord returnPickingRecord=pickingRecordMapper.selectByPrimaryKey(pickingRecord.getReturnPickingId());
						if(returnPickingRecord==null){
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("领料单号不存在");
							return resultEntity;
						}else{
							if(!returnPickingRecord.getApprovalStatus().equals("03")){
								resultEntity.setCode(ErrorCode.ERROR);
								resultEntity.setMsg("该领料单无法进行退料");
								return resultEntity;
							}
						}
					}
				}
				
			}
			if(StringUtils.isBlank(windId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("风电场不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(stockAddId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("库存地不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(pickingRecord.getProposer())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("申请人不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(pickingRecord.getPicker())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("领/退料人不能为空");
				return resultEntity;
			}
			
			List<PickingRecordDetail> list = new ArrayList<>();
			if(pickingRecord.getRecordDetails()==null||pickingRecord.getRecordDetails().isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资明细不能为空");
				return resultEntity;
			}else{
				for(PickingRecordDetail pickingRecordDetail:pickingRecord.getRecordDetails()){
					if(pickType.equals("201")||pickType.equals("211")){
		               	InventoryExample inventoryExample = new InventoryExample();
		               	inventoryExample.createCriteria().andMaterialIdEqualTo(pickingRecordDetail.getMaterialId()).andStockAddIdEqualTo(stockAddId).andStatusEqualTo("01");
		               	NewPageResult<Inventory> newPageResult = stockService.getNormalStock(inventoryExample);
		               	List<Inventory> stockList=(List<Inventory>) newPageResult.getRows();
		               	if(stockList!=null&&!stockList.isEmpty()){
		               		//判断库存是否满足领取数量
		               		if(pickingRecordDetail.getRecipientsNum()>stockList.get(0).getInventoryNum()){
		               			resultEntity.setCode(ErrorCode.ERROR);
		               			resultEntity.setMsg("物资编码:"+pickingRecordDetail.getMaterialCode()+" 库存不足");
		               			return resultEntity;
		               		}
		               		Inventory inventory=new Inventory();
		               		inventory.setInventoryId(stockList.get(0).getInventoryId());
		               		inventory.setInventoryNum(stockList.get(0).getInventoryNum()-pickingRecordDetail.getRecipientsNum());
		               		inventory.setInventoryAmount(stockList.get(0).getInventoryAmount().subtract(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum()))));
		               		inventory.setFreezeNum(stockList.get(0).getFreezeNum()+pickingRecordDetail.getRecipientsNum());
		               		inventory.setFreezeAmount(stockList.get(0).getFreezeAmount().add(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum()))));
		               		inventoryMapper.updateByPrimaryKeySelective(inventory);
		               		pickingRecordDetail.setPrice(stockList.get(0).getAveragePrice());
		               		pickingRecordDetail.setAmount(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum())));
		               	}
						
	  				}
					if(pickType.equals("212")||pickType.equals("202")){
						if(pickingRecordDetail.getReturnNum()>pickingRecordDetail.getRefundableNum()){
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("物资编码:"+pickingRecordDetail.getMaterialCode()+"退回数量不可大于可退数量");
							return resultEntity;
						}
//					approvalSta
					if(StringUtils.isBlank(pickingRecordDetail.getReturnPickingDetailId())){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("退料时必须传入所退物资明细详情信息");
						return resultEntity;
					}
                    					
					PickingRecordDetail pickingRecordDetailInfo=pickingRecordDetailMapper.selectByPrimaryKey(pickingRecordDetail.getReturnPickingDetailId());
					pickingRecordDetailInfo.setReturnNum(pickingRecordDetailInfo.getReturnNum()+pickingRecordDetail.getReturnNum());
					pickingRecordDetailMapper.updateByPrimaryKeySelective(pickingRecordDetailInfo);
					}	
					pickingRecordDetail.setPickingDetailId(UUIdUtil.getUUID());
					pickingRecordDetail.setPickingId(pickingId);
					list.add(pickingRecordDetail);
				}	
			}	
			String maxOrder= commonService.customOrder("04", pickingRecordMapper.getMaxPickingOrder());	
			pickingRecord.setPickingOrder(maxOrder);
			pickingRecordMapper.insertSelective(pickingRecord);
			pickingRecordDetailMapper.insertList(list);
			
			//获取工作流程，流程步骤，操作角色等信息
			DeployMain deployMain=deployService.queryDeployMainById("2");
			if(deployMain!=null){
				   //主流程
                   Process process = new Process();
                   String processId=UUIdUtil.getUUID();
                   process.setProcessId(processId);
                   process.setOrderId(pickingId);
                   process.setProcessSort(1);
                   process.setProcessStatus("01");
                   process.setProcessType("02");
                   process.setCreateTime(new Date());
                   processMapper.insertSelective(process);
                   
                   DoList doList = new DoList();
                   String doId=UUIdUtil.getUUID();
                   doList.setDoId(doId);
                   doList.setTaskId(pickingId);
                   doList.setTaskType("02");
                   doList.setTaskCode(maxOrder);
                   doList.setTaskDescribe("领/退料单");
                   doList.setCreateTime(new Date());
                   doListDao.addDoList(doList);  
                   List<ProcessDetail> processDetails = new ArrayList<ProcessDetail>();
                   List<ProcessDetailRoleRela> processDetailRoleRelas = new ArrayList<ProcessDetailRoleRela>();
                   List<DoRoleRela> doRoleRelas = new ArrayList<DoRoleRela>();
                   
                   if(deployMain.getDeploys()!=null&&!deployMain.getDeploys().isEmpty()){
                   for(Deploy d:deployMain.getDeploys()){
                	   ProcessDetail processDetail = new ProcessDetail();
                	   String processDetailId=UUIdUtil.getUUID();
                	   processDetail.setProcessDetailId(processDetailId);
                	   processDetail.setProcessId(processId);
                	   processDetail.setSort(Integer.valueOf(d.getDeploySort()));
                	   processDetail.setName(d.getDeployName());
                	   if(Integer.valueOf(d.getDeploySort())==1){
                		   processDetail.setStatus("02");
                	   }
                	   if(Integer.valueOf(d.getDeploySort())!=1){
                		   processDetail.setStatus("01");
                	   }
                	   processDetails.add(processDetail);
                	   if(d.getRoles()!=null&&!d.getRoles().isEmpty()){
                		   for(Role r:d.getRoles()){
                			   //流程详情角色
                			   ProcessDetailRoleRela processDetailRoleRela = new ProcessDetailRoleRela();
                			   processDetailRoleRela.setRelaId(UUIdUtil.getUUID());
                			   processDetailRoleRela.setProcessDetailId(processDetailId);
                			   processDetailRoleRela.setRoleId(r.getRoleId());
                			   processDetailRoleRelas.add(processDetailRoleRela);
                			   if(Integer.valueOf(d.getDeploySort())==2){
                			   DoRoleRela doRoleRela = new DoRoleRela();
                			   doRoleRela.setRelaId(UUIdUtil.getUUID());
                			   doRoleRela.setRoleId(r.getRoleId());
                			   doRoleRela.setDoId(doId);
                			   doRoleRelas.add(doRoleRela);
                			   }
                		   }
                	   }
                	   
                   }
                  processDetailMapper.insertList(processDetails);                  
				  processDetailRoleRelaMapper.insertList(processDetailRoleRelas); 	
				  doListDao.addDoRoleRelas(doRoleRelas);
                   }
			}
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("提交成功");
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("系统繁忙!");
	}
		return resultEntity;
	}

	private boolean checkMaxOrderIsExit(String pickingRecordOrder) {
		PickingRecordExample example = new PickingRecordExample();
		example.createCriteria().andPickingOrderEqualTo(pickingRecordOrder);
		int count = pickingRecordMapper.countByExample(example);
		if(count>0){
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public String getMaxPickingOrder() {
		String pickingOrder = pickingRecordMapper.selectMaxOrder();
		return pickingOrder;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ResultEntity updatePickRecord(PickingRecord pickingRecord) throws ParseException {
		ResultEntity resultEntity = new ResultEntity();
		String approvalStatus=pickingRecord.getApprovalStatus();
		if(StringUtils.isBlank(approvalStatus)){
			resultEntity.setCode(ErrorCode.ERROR); 
			resultEntity.setMsg("提交状态不能为空");
			return resultEntity;
		}
		PickingRecord pickingRecord2 = pickingRecordMapper.selectByPrimaryKey(pickingRecord.getPickingId());
		if(pickingRecord2!=null){
			if(!pickingRecord2.getApprovalStatus().equals("01")){
				resultEntity.setCode(ErrorCode.ERROR); 
				resultEntity.setMsg("该领料单状态非保存状态无法编辑");
				return resultEntity;
			}
		}
		
		
		//领用类型
		String pickType=pickingRecord.getPickingType();
		//风电场编码
		String windId=pickingRecord.getWindId();
		//仓库
		String stockAddId=pickingRecord.getStockAddId();
		String pickingId=pickingRecord.getPickingId();
		pickingRecord.setPickingId(pickingId);
		pickingRecord.setCreateTime(new Date());
		UserInfo userInfo = currentUSerservice.getUserInfo();
		pickingRecord.setCreater(userInfo.getUserId());
		
	try {
		//保存状态
		if(approvalStatus.equals("01")){	
		pickingRecordMapper.updateByPrimaryKeySelective(pickingRecord);
		List<PickingRecordDetail> list = new ArrayList<>();
		if(pickingRecord.getRecordDetails()!=null&&!pickingRecord.getRecordDetails().isEmpty()){
		for(PickingRecordDetail pickingRecordDetail:pickingRecord.getRecordDetails()){
			pickingRecordDetail.setPickingDetailId(UUIdUtil.getUUID());
			pickingRecordDetail.setPickingId(pickingId);
			list.add(pickingRecordDetail);
		}	
		pickingRecordDetailMapper.deleteByPrimaryKey(pickingRecord.getPickingId());
		pickingRecordDetailMapper.insertList(list);
		}	
		resultEntity.setCode(ErrorCode.SUCCESS);
		}
		//提交状态
		if(approvalStatus.equals("02")){
			if(StringUtils.isBlank(pickingRecord.getPickingType())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("领料类型不能为空");
				return resultEntity;
			}else{
				if(pickType.equals("201")){
					if(StringUtils.isBlank(pickingRecord.getWorkOrder())){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("工单号不能为空");
						return resultEntity;
					}
				}
				if(pickType.equals("212")){
					if(StringUtils.isBlank(pickingRecord.getReturnPickingId())){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("退料时所退领料单号不能为空");
						return resultEntity;
					}else{
						PickingRecord returnPickingRecord=pickingRecordMapper.selectByPrimaryKey(pickingRecord.getReturnPickingId());
						if(returnPickingRecord==null){
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("领料单号不存在");
							return resultEntity;
						}else{
							if(!returnPickingRecord.getApprovalStatus().equals("03")){
								resultEntity.setCode(ErrorCode.ERROR);
								resultEntity.setMsg("该领料单无法进行退料");
								return resultEntity;
							}
						}
					}
				}
				
			}
			if(StringUtils.isBlank(windId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("风电场不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(stockAddId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("库存地不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(pickingRecord.getProposer())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("申请人不能为空");
				return resultEntity;
			}
			if(StringUtils.isBlank(pickingRecord.getPicker())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("领/退料人不能为空");
				return resultEntity;
			}
			
			List<PickingRecordDetail> list = new ArrayList<>();
			if(pickingRecord.getRecordDetails()==null||pickingRecord.getRecordDetails().isEmpty()){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("物资明细不能为空");
				return resultEntity;
			}else{
				for(PickingRecordDetail pickingRecordDetail:pickingRecord.getRecordDetails()){
					if(pickType.equals("201")||pickType.equals("211")){
		               	InventoryExample inventoryExample = new InventoryExample();
		               	inventoryExample.createCriteria().andMaterialIdEqualTo(pickingRecordDetail.getMaterialId()).andStockAddIdEqualTo(stockAddId).andStatusEqualTo("01");
		               	NewPageResult<Inventory> newPageResult = stockService.getNormalStock(inventoryExample);
		               	List<Inventory> stockList=(List<Inventory>) newPageResult.getRows();
		               	if(stockList!=null&&!stockList.isEmpty()){
		               		//判断库存是否满足领取数量
		               		if(pickingRecordDetail.getRecipientsNum()>stockList.get(0).getInventoryNum()){
		               			resultEntity.setCode(ErrorCode.ERROR);
		               			resultEntity.setMsg("物资编码:"+pickingRecordDetail.getMaterialCode()+" 库存不足");
		               			return resultEntity;
		               		}
		               		Inventory inventory=new Inventory();
		               		inventory.setInventoryId(stockList.get(0).getInventoryId());
		               		inventory.setInventoryNum(stockList.get(0).getInventoryNum()-pickingRecordDetail.getRecipientsNum());
		               		inventory.setInventoryAmount(stockList.get(0).getInventoryAmount().subtract(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum()))));
		               		inventory.setFreezeNum(stockList.get(0).getFreezeNum()+pickingRecordDetail.getRecipientsNum());
		               		inventory.setFreezeAmount(stockList.get(0).getFreezeAmount().add(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum()))));
		               		inventoryMapper.updateByPrimaryKeySelective(inventory);
		               		pickingRecordDetail.setPrice(stockList.get(0).getAveragePrice());
		               		pickingRecordDetail.setAmount(stockList.get(0).getAveragePrice().multiply(new BigDecimal(pickingRecordDetail.getRecipientsNum())));
		               	}
						
	  				}
					if(pickType.equals("212")||pickType.equals("202")){
						if(pickingRecordDetail.getReturnNum()>pickingRecordDetail.getRefundableNum()){
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("物资编码:"+pickingRecordDetail.getMaterialCode()+"退回数量不可大于可退数量");
							return resultEntity;
						}
						if(StringUtils.isBlank(pickingRecordDetail.getReturnPickingDetailId())){
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("退料时必须传入所退物资明细详情信息");
							return resultEntity;
						}
						PickingRecordDetail pickingRecordDetailInfo=pickingRecordDetailMapper.selectByPrimaryKey(pickingRecordDetail.getReturnPickingDetailId());	
						pickingRecordDetailInfo.setReturnNum(pickingRecordDetailInfo.getReturnNum()+pickingRecordDetail.getReturnNum());
						pickingRecordDetailMapper.updateByPrimaryKeySelective(pickingRecordDetailInfo);
					}	
					pickingRecordDetail.setPickingDetailId(UUIdUtil.getUUID());
					pickingRecordDetail.setPickingId(pickingId);
					list.add(pickingRecordDetail);
				}	
			}	
			String maxOrder= commonService.customOrder("04", pickingRecordMapper.getMaxPickingOrder());	
			pickingRecord.setPickingOrder(maxOrder);
			pickingRecordMapper.updateByPrimaryKeySelective(pickingRecord);
			pickingRecordDetailMapper.deleteByPrimaryKey(pickingRecord.getPickingId());
			pickingRecordDetailMapper.insertList(list);
			
			DeployMain deployMain=deployService.queryDeployMainById("2");
			if(deployMain!=null){
				   //主流程
                   Process process = new Process();
                   String processId=UUIdUtil.getUUID();
                   process.setProcessId(processId);
                   process.setOrderId(pickingId);
                   process.setProcessSort(1);
                   process.setProcessStatus("01");
                   process.setProcessType("02");
                   process.setCreateTime(new Date());
                   processMapper.insertSelective(process);
                   
                   DoList doList = new DoList();
                   String doId=UUIdUtil.getUUID();
                   doList.setDoId(doId);
                   doList.setTaskId(pickingId);
                   doList.setTaskType("02");
                   doList.setTaskCode(maxOrder);
                   doList.setTaskDescribe("领/退料单");
                   doList.setCreateTime(new Date());
                   doListDao.addDoList(doList);  
                   List<ProcessDetail> processDetails = new ArrayList<>();
                   List<ProcessDetailRoleRela> processDetailRoleRelas = new ArrayList<>();
                   List<DoRoleRela> doRoleRelas = new ArrayList<>();
                   
                   if(deployMain.getDeploys()!=null&&!deployMain.getDeploys().isEmpty()){
                	   for(Deploy d:deployMain.getDeploys()){
                	   //流程详情
                	   ProcessDetail processDetail = new ProcessDetail();
                	   String processDetailId=UUIdUtil.getUUID();
                	   processDetail.setProcessDetailId(processDetailId);
                	   processDetail.setProcessId(processId);
                	   processDetail.setSort(Integer.valueOf(d.getDeploySort()));
                	   processDetail.setName(d.getDeployName());
                	   if(Integer.valueOf(d.getDeploySort())==1){
                		   processDetail.setStatus("02");
                	   }
                	   if(Integer.valueOf(d.getDeploySort())!=1){
                		   processDetail.setStatus("01");
                	   }
                	   processDetails.add(processDetail);
                	   if(d.getRoles()!=null&&!d.getRoles().isEmpty()){
                		   for(Role r:d.getRoles()){
                			   //流程详情角色
                			   ProcessDetailRoleRela processDetailRoleRela = new ProcessDetailRoleRela();
                			   processDetailRoleRela.setRelaId(UUIdUtil.getUUID());
                			   processDetailRoleRela.setProcessDetailId(processDetailId);
                			   processDetailRoleRela.setRoleId(r.getRoleId());
                			   processDetailRoleRelas.add(processDetailRoleRela);
                			   if(Integer.valueOf(d.getDeploySort())==2){
                			   DoRoleRela doRoleRela = new DoRoleRela();
                			   doRoleRela.setRelaId(UUIdUtil.getUUID());
                			   doRoleRela.setRoleId(r.getRoleId());
                			   doRoleRela.setDoId(doId);
                			   doRoleRelas.add(doRoleRela);
                			   }
                		   }
                	   }
                	   
                   }
                  processDetailMapper.insertList(processDetails);                  
				  processDetailRoleRelaMapper.insertList(processDetailRoleRelas); 	
				  doListDao.addDoRoleRelas(doRoleRelas);
                   }
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("提交成功");
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("系统繁忙!");
	}
		return resultEntity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public NewPageResult getPickRecordDetailList(PickingRecordDetailExample example) {
		NewPageResult newPageResult = new NewPageResult();
		int count = pickingRecordDetailMapper.countByExample(example);
		newPageResult.setTotal(count);
		List<PickingRecordDetail> list;
		if(count==0){
			list=Collections.emptyList();
		}else{
			list=pickingRecordDetailMapper.selectByExample(example);
		for(PickingRecordDetail pickingRecordDetail:list){
				PickingRecordDetail info=pickingRecordDetailMapper.selectByPrimaryKey(pickingRecordDetail.getReturnPickingDetailId());
				if(info!=null){
				pickingRecordDetail.setRefundableNum(info.getRecipientsNum()-info.getReturnNum());
				}else{
			    pickingRecordDetail.setRefundableNum(pickingRecordDetail.getRecipientsNum()-pickingRecordDetail.getReturnNum());
				}
				}
		}
		newPageResult.setCode(ErrorCode.SUCCESS);
		newPageResult.setRows(list);
		return newPageResult;
	}

	@Override
	public ResultEntity agreeOrderStatus(String pickingId, String approvalOpinion) {
		ResultEntity resultEntity = new ResultEntity();
		PickingRecord pickingRecordInfo=pickingRecordMapper.selectByPrimaryKey(pickingId);
		if(pickingRecordInfo==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("领料单不存在");
			return resultEntity;
		}
		if(!pickingRecordInfo.getApprovalStatus().equals("02")){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("该领料单非待审核状态，无法执行审核操作");
			return resultEntity;
		}
		
		ResultEntity resultEntity2  =  processService.getProcessByOrderIdAndType(pickingId, "02");
		if(resultEntity2.getData()!=null){
		Process process = (Process) resultEntity2.getData();
		  ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
	        int totalSort = (Integer) totalSortResultEntity.getData();

	        if (process!=null && totalSort!=0) {
	          
	            if (process.getProcessSort()==totalSort) {
	                resultEntity.setMsg("流程已结束,无法进行操作");
	                return resultEntity;
	            }
	            if (!"01".equals(process.getProcessStatus())) {
	                resultEntity.setMsg("审核过的领料单无法再操作");
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
	                            List<Role> userRoleList = roleService.findUserRoleList(currentUSerservice.getId());
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
	                        resultEntity.setMsg("权限不足");
	                        return resultEntity;
	                    }
	                }
	                ApproveRecord approveRecord = new ApproveRecord();
	                approveRecord.setApproveId(UUIdUtil.getUUID());
	                approveRecord.setOrderId(pickingId);
	                approveRecord.setProcessDetailId(processDetail.getProcessDetailId());
	                approveRecord.setApproveResult("通过");
	                approveRecord.setApproveUser(currentUSerservice.getId());
	                approveRecord.setApproveTime(new Date());
	                approveRecord.setApproveOpinion(approvalOpinion);
	                //将流程审批记录插入数据库
	                approveRecordService.addApproveRecord(approveRecord);
	            }
	            processDetail.setStatus("02");
	            processService.updateProcessDetail(processDetail);
	            if (totalSort-process.getProcessSort()>1) {
	                processDetailResultEntity = processService.getProcessDetailByProcessIdAndsort(process.getProcessId(), String.valueOf(process.getProcessSort() + 2));
	                processDetail = (ProcessDetail) processDetailResultEntity.getData();
	                if (processDetail != null) {
	                    List<ProcessDetailRoleRela> processDetailRoleRelas = processDetail.getProcessDetailRoleRelas();
	                    if (CollectionUtils.isNotEmpty(processDetailRoleRelas)) {
	                        //获取代办信息
	                        ResultEntity doListResultEntity = doListService.findDoListByTaskId(pickingId);
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
	                            doListService.updateDoList(pickingId, doRoleRelas);
	                        }
	                    }
	                }
	                
	            }

	            //如果当前是最后一步修改流程主表,流程结束
	            if (totalSort-process.getProcessSort()==1) {
	                //获取代办信息
	                ResultEntity doListResultEntity = doListService.findDoListByTaskId(pickingId);
	                DoList doList = (DoList) doListResultEntity.getData();
	                if (doList != null) {
	                    //修改代办角色关联列表
	                    List<DoRoleRela> doRoleRelas = new ArrayList<>();
	                    doListService.updateDoList(pickingId, doRoleRelas);
	                }
	                PickingRecordDetailExample example = new PickingRecordDetailExample();
	                example.createCriteria().andPickingIdEqualTo(pickingId);
	                List<PickingRecordDetail> detailList=pickingRecordDetailMapper.selectByExample(example);
	                String pickingType = pickingRecordInfo.getPickingType();
	                for(PickingRecordDetail p:detailList){
	                	if(pickingType.equals("211")||pickingType.equals("201")){	                              		
	                		InventoryExample inventoryExample = new InventoryExample();
	            	    	inventoryExample.createCriteria().andMaterialIdEqualTo(p.getMaterialId()).andWindIdEqualTo(pickingRecordInfo.getWindId()).andStockAddIdEqualTo(pickingRecordInfo.getStockAddId()).andStatusEqualTo("01");
	            	    	List<Inventory> list1=inventoryMapper.selectByExample(inventoryExample);		            
	            	    	if(list1!=null&&!list1.isEmpty()){
	            	        	Inventory inventory = new Inventory();
	            	        	inventory.setFreezeNum(list1.get(0).getFreezeNum()-p.getRecipientsNum());
	            	        	inventory.setFreezeAmount(list1.get(0).getFreezeAmount().subtract(p.getAmount()));
	            	        	inventory.setInventoryId(list1.get(0).getInventoryId());
	            	        	inventoryMapper.updateByPrimaryKeySelective(inventory);
	            	        }
	            	        if(pickingType.equals("201")){
	            	        	WorkOrderMaterials materials = workOrderMaterialsMapper.selectByPrimaryKey(p.getWorkorderMaterialId());
	            	        	BigDecimal amount = new BigDecimal(materials.getMaterialActualMoney());
	            	            Integer num = Integer.valueOf(materials.getMaterialActualAmount())+p.getRecipientsNum();
	            	            materials.setMaterialActualMoney((amount.add(p.getAmount()).toString()));
	            	            materials.setMaterialActualAmount(num.toString());
	            	            workOrderMaterialsMapper.updateByPrimaryKeySelective(materials);
	            	       
	            	        }
	                	}             	
                        if(pickingType.equals("212")||pickingType.equals("202")){
	                		PickingRecordDetail pickingRecordDetail = pickingRecordDetailMapper.selectByPrimaryKey(p.getReturnPickingDetailId());
	                		String materialId=p.getMaterialId();
	                		String windCode=pickingRecordInfo.getWindId();
	                		InventoryExample inventoryExample = new InventoryExample();
	                		inventoryExample.createCriteria().andWindIdEqualTo(windCode).andMaterialIdEqualTo(materialId).andStatusEqualTo("01");
	                		List<Inventory> inventoryLists = inventoryMapper.selectByExample(inventoryExample);
	                		if(inventoryLists!=null&&!inventoryLists.isEmpty()){
	                	    Inventory inventory = inventoryLists.get(0);
	                		Inventory inventoryAvg = inventoryMapper.selectAveragePriceExample(inventoryExample);
	                		inventory.setInventoryNum(inventory.getInventoryNum()+p.getReturnNum());
	                		inventory.setInventoryAmount(inventory.getInventoryAmount().add(new BigDecimal(p.getReturnNum()).multiply(inventoryAvg.getAveragePrice())));
	                		inventoryMapper.updateByPrimaryKeySelective(inventory); 
	                		}
	                	}                    
	                }
	                
	              
	                //设置流程主表状态未已完成
	                process.setProcessStatus("02");
	                pickingRecordInfo.setPickingId(pickingId);
	                pickingRecordInfo.setApprovalStatus("03");
	                pickingRecordInfo.setApprovalOpinion(approvalOpinion);
	        		pickingRecordMapper.updateByPrimaryKeySelective(pickingRecordInfo);
	        		doListDao.deleteByDoId(pickingId);
	            }
	            process.setProcessSort(process.getProcessSort()+1);
	            processService.updateProcess(process);
	            
	        }
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	
	}

	@Override
	public ResultEntity refuseOrderStatus(String pickingId, String approvalOpinion) {
		ResultEntity resultEntity = new ResultEntity();
		//领/退料单详情
		PickingRecord PickingRecordInfo=pickingRecordMapper.selectByPrimaryKey(pickingId);
		if(PickingRecordInfo==null){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("领料单不存在");
			return resultEntity;
		}
		if(!PickingRecordInfo.getApprovalStatus().equals("02")){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("该领料单非待审核状态，无法执行审核操作");
			return resultEntity;
		}
		
		ResultEntity resultEntity2  =  processService.getProcessByOrderIdAndType(pickingId, "02");
		if(resultEntity2.getData()!=null){
		Process process = (Process) resultEntity2.getData();
		  ResultEntity totalSortResultEntity = processService.getTotalSort(process.getProcessId());
	        int totalSort = (Integer) totalSortResultEntity.getData();

	        if (process!=null && totalSort!=0) {
	          
	            if (process.getProcessSort()==totalSort) {
	                resultEntity.setMsg("流程已结束,无法进行操作");
	                return resultEntity;
	            }
	            if (!"01".equals(process.getProcessStatus())) {
	                resultEntity.setMsg("审核过的领料单无法再操作");
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
	                            List<Role> userRoleList = roleService.findUserRoleList(currentUSerservice.getId());
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
	                        resultEntity.setMsg("权限不足");
	                        return resultEntity;
	                    }
	                }
	
	            }
	        }
		}   
		if(PickingRecordInfo.getPickingType().equals("211")||PickingRecordInfo.getPickingType().equals("201")){
		PickingRecordDetailExample detailExample = new PickingRecordDetailExample();
		detailExample.setIsPage(0);//不分页
		detailExample.createCriteria().andPickingIdEqualTo(pickingId);
		List<PickingRecordDetail> detailList = pickingRecordDetailMapper.selectByExample(detailExample);
		List<Inventory> inventorieList=new ArrayList<Inventory>();
		for(PickingRecordDetail pickingRecordDetail:detailList){
			
	    	InventoryExample inventoryExample = new InventoryExample();
	    	inventoryExample.createCriteria().andMaterialIdEqualTo(pickingRecordDetail.getMaterialId()).andWindIdEqualTo(PickingRecordInfo.getWindId()).andStockAddIdEqualTo(PickingRecordInfo.getStockAddId()).andStatusEqualTo(StockMaterialStatusEnum.STATUS_NORMAL.getCode());
	    	List<Inventory> list1=inventoryMapper.selectByExample(inventoryExample);	
	        if(list1!=null&&!list1.isEmpty()){
	        	Inventory inventory = new Inventory();
		        inventory.setInventoryId(list1.get(0).getInventoryId());
		        inventory.setInventoryNum(list1.get(0).getInventoryNum()+pickingRecordDetail.getRecipientsNum());
		        inventory.setFreezeNum(list1.get(0).getFreezeNum()-pickingRecordDetail.getRecipientsNum());
		        inventory.setInventoryAmount(list1.get(0).getInventoryAmount().add(pickingRecordDetail.getAmount()));
		        inventory.setFreezeAmount(list1.get(0).getFreezeAmount().subtract(pickingRecordDetail.getAmount()));
		     //   inventorieList.add(inventory);
		        inventoryMapper.updateByPrimaryKeySelective(inventory);
	        } 	
	        
		}  
		//恢复冻结的物资
		//inventoryMapper.updateBatch(inventorieList);
	    }
		if(PickingRecordInfo.getPickingType().equals("212")||PickingRecordInfo.getPickingType().equals("202")){
			PickingRecordDetailExample detailExample = new PickingRecordDetailExample();
			detailExample.setIsPage(0);//不分页
			detailExample.createCriteria().andPickingIdEqualTo(pickingId);
			List<PickingRecordDetail> detailList = pickingRecordDetailMapper.selectByExample(detailExample);
			List<PickingRecordDetail> returnDetailList=new ArrayList<>();
			for(PickingRecordDetail pickingRecordDetail:detailList){
				//退料时虽退领料详情id
				PickingRecordDetail pickingRecordDetail2 = pickingRecordDetailMapper.selectByPrimaryKey(pickingRecordDetail.getReturnPickingDetailId());
				PickingRecordDetail pickingRecordDetail3 = new PickingRecordDetail();
				pickingRecordDetail3.setPickingDetailId(pickingRecordDetail2.getPickingDetailId());
				pickingRecordDetail3.setReturnNum(pickingRecordDetail2.getReturnNum()-pickingRecordDetail.getReturnNum());
				returnDetailList.add(pickingRecordDetail3);
				pickingRecordDetailMapper.updateByPrimaryKeySelective(pickingRecordDetail3);
		        
			}  
		//	pickingRecordDetailMapper.updateBatchReturnNum(returnDetailList);//批量更新
		    }
		
		PickingRecordInfo.setPickingId(pickingId);
		PickingRecordInfo.setApprovalStatus("04");
		PickingRecordInfo.setApprovalOpinion(approvalOpinion);
		pickingRecordMapper.updateByPrimaryKeySelective(PickingRecordInfo);
		  //审核记录
		ApproveRecord approveRecord = new ApproveRecord();
		approveRecord.setApproveId(UUIdUtil.getUUID());
		approveRecord.setOrderId(pickingId);
		approveRecord.setProcessDetailId(pickingId);
		approveRecord.setApproveResult("通过");
		approveRecord.setApproveUser(currentUSerservice.getId());
		approveRecord.setApproveTime(new Date());
		approveRecord.setApproveOpinion(approvalOpinion);
		doListDao.deleteByDoId(pickingId);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("操作成功");
		return resultEntity;
	}
	
	
	

	@Override
	public ResultEntity deletePickRecord(List<String> pickingIds) {
		ResultEntity resultEntity = new ResultEntity();
		for(String pickingId:pickingIds){
			PickingRecord pickingRecordInfo = pickingRecordMapper.selectByPrimaryKey(pickingId);
			if(pickingRecordInfo!=null){
				if(!pickingRecordInfo.getApprovalStatus().equals("01")){
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("处于保存状态下的领料单才可删除");
					return resultEntity;
				}
			}
		}
		pickingRecordMapper.deleteByPickingId(pickingIds);
		pickingRecordDetailMapper.deleteByPickingId(pickingIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}


}
