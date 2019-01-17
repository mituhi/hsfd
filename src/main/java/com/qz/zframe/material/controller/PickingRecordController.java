package com.qz.zframe.material.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.type.TrueFalseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.service.CommonService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.material.entity.ApprovalOpinion;
import com.qz.zframe.material.entity.PickingRecord;
import com.qz.zframe.material.entity.PickingRecordDetail;
import com.qz.zframe.material.entity.PickingRecordDetailExample;
import com.qz.zframe.material.entity.PickingRecordExample;
import com.qz.zframe.material.entity.StoreHouseType;
import com.qz.zframe.material.entity.StoreHouseTypeExample;
import com.qz.zframe.material.entity.PickingRecordExample.Criteria;
import com.qz.zframe.material.entity.StoreHouseType.ListView;
import com.qz.zframe.material.enums.IsDeleteEnum;
import com.qz.zframe.material.service.PickingRecordService;
import com.qz.zframe.material.service.StoreHouseTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/pickRecord")
@Api(tags = "api-material-pickRecord", description = "物资管理-领退料管理")
public class PickingRecordController {
	
	private static Logger logger = LoggerFactory.getLogger(PickingRecordController.class);
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
	@Autowired
	private PickingRecordService pickingRecordService;
	
	
	@Autowired
	private CurrentUserService currentUSerservice;
	
	@Autowired
	private StoreHouseTypeService storeHouseTypeService;
	
	
	@RequestMapping(value = "/listPickRecord", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取领料列表", notes = "")
	public NewPageResult<PickingRecord> getPickRecordList (
			@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "pickingOrder", value = "领料单号", required = false) String pickingOrder,
			@RequestParam(required = false) @ApiParam(name = "pickingType", value = "领用类型，传入领用类型编码", required = false) String pickingType,
			@RequestParam(required = false) @ApiParam(name = "startDate", value = "开始日期", required = false) String startDate,
			@RequestParam(required = false) @ApiParam(name = "endDate", value = "结束日期", required = false) String endDate,
			@RequestParam(required = false) @ApiParam(name = "startArchiteCode", value = "开始的电场编码", required = false) String startArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "endArchiteCode", value = "结束的电场编码", required = false) String endArchiteCode,
			@RequestParam(required = false) @ApiParam(name = "proposer", value = "申请人", required = false) String proposer,
			@RequestParam(required = false) @ApiParam(name = "workOrder", value = "工单", required = false) String workOrder,
			@RequestParam(required = false) @ApiParam(name = "approvalStatus", value = "审批状态", required = false) String approvalStatus,
			@RequestParam(required = false) @ApiParam(name = "pickingId", value = "领料单Id", required = false) String pickingId,
			@RequestParam(required = false) @ApiParam(name = "pickingOrderSearch", value = "领料单模糊查询", required = false) String pickingOrderSearch) throws  Exception{
		PickingRecordExample example = new PickingRecordExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setOrderByClause("picking_order is null desc,a.create_time desc ");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(pickingOrder)) {
			criteria.andPickingOrderEqualTo(pickingOrder);		
		}
		if (!StringUtils.isBlank(pickingType)) {
			criteria.andPickingTypeEqualTo(pickingType);
		}
		if (!StringUtils.isBlank(startDate)) {
			if(!StringUtils.isBlank(endDate)){
				criteria.andApplicationTimeBetween(format.parse(startDate), format.parse(endDate));
			}else{
				criteria.andApplicationTimeEqualTo(format.parse(startDate));
			}
		}
		if (!StringUtils.isBlank(startArchiteCode)) {
			if (!StringUtils.isBlank(endArchiteCode)){
				criteria.andArchitectureCodeBetween(startArchiteCode, endArchiteCode);
			}else{
				criteria.andArchitectureCodeEqualTo(startArchiteCode);
			}
		}
		if (!StringUtils.isBlank(proposer)) {
			criteria.andProposerLikeTo(proposer);
		}
		if (!StringUtils.isBlank(workOrder)) {
			criteria.andWorkOrderLike(workOrder);
		}
		if(!StringUtils.isBlank(approvalStatus)){
			criteria.andApprovalStatusEqualTo(approvalStatus);
		}
		if(!StringUtils.isBlank(pickingId)){
			criteria.andPickingIdEqualTo(pickingId);
		}
		if(!StringUtils.isBlank(pickingOrderSearch)){
			criteria.andPickingOrderLike(pickingOrderSearch);
		}
		UserInfo userInfo = currentUSerservice.getUserInfo();
		criteria.andCreaterEqualTo(userInfo.getUserId());
		return pickingRecordService.getPickRecordList(example);
	}
	
	
	@RequestMapping(value = "/getByPickOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "根据单号获取领料单详情", notes = "")
	public NewPageResult<PickingRecord> getPickRecordByOrderNo (	
			@RequestParam(required = true) @ApiParam(name = "pickingOrder", value = "领料单号", required = false) String pickingOrder,
			@RequestParam(required = false) @ApiParam(name = "pickType", value = "领料单号", required = false) String pickType
		) throws  Exception{
		PickingRecordExample example = new PickingRecordExample();
		example.createCriteria().andPickingOrderEqualTo(pickingOrder);
		return pickingRecordService.getPickRecordByOrderNo(example,pickType);
	}
	
	
	@RequestMapping(value = "/detailPickRecord", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取领料单详情", notes = "")
	public NewPageResult<PickingRecord> getPickRecordDetail(@RequestParam(required = true) @ApiParam(name = "pickingId", value = "领料id", required = false) String pickingId){ 
		return pickingRecordService.getPickRecordDetail(pickingId);
	}
	
	@RequestMapping(value = "/savePickRecord", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增领料单", notes = "")
	public ResultEntity addPickRecord(@RequestBody PickingRecord pickingRecord) throws Exception{	
		logger.info("=====addPickRecord==pickingRecord:"+pickingRecord);
		return pickingRecordService.addPickRecord(pickingRecord);
	}
	
	@RequestMapping(value = "/editPickRecord", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑领料单", notes = "")
	public ResultEntity updatePickRecord(@RequestBody PickingRecord pickingRecord) throws Exception{
		return pickingRecordService.updatePickRecord(pickingRecord);
	}
	
	@RequestMapping(value = "/listPickRecordDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "领料单物资明细列表", notes = "领料单物资明细列表")
	public NewPageResult<PickingRecordDetail> getPickRecordDetailList(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,@RequestParam(required = false,defaultValue="1") Integer isPage,
			@RequestParam(required = false) @ApiParam(name = "pickingId", value = "领料单Id", required = false) String pickingId,
			@RequestParam(required = false) @ApiParam(name = "pickingOrder", value = "领料单号", required = false) String pickingOrder){
		PickingRecordDetailExample example = new PickingRecordDetailExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageSize);
		example.setIsPage(isPage);
		com.qz.zframe.material.entity.PickingRecordDetailExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(pickingId)) {
			criteria.andPickingIdEqualTo(pickingId);	
		}
		if (!StringUtils.isBlank(pickingOrder)) {
			criteria.andPickingIdOrderTo(pickingOrder);
		}
		return pickingRecordService.getPickRecordDetailList(example);
	}
		
	@RequestMapping(value = "/agreeStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "审批同意", notes = "")
	public ResultEntity agreeOrderStatus(@RequestBody ApprovalOpinion approvalOpinion){	
		return pickingRecordService.agreeOrderStatus(approvalOpinion.getPickingId(),approvalOpinion.getApprovalOpinion());
	}
	
	@RequestMapping(value = "/refuseStatus", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "审批拒绝", notes = "")
	public ResultEntity refuseOrderStatus(@RequestBody ApprovalOpinion approvalOpinion){	
		return pickingRecordService.refuseOrderStatus(approvalOpinion.getPickingId(),approvalOpinion.getApprovalOpinion());
	}
	
	@RequestMapping(value = "/delPickRecord", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除", notes = "")
	public ResultEntity deletePickRecord(@RequestBody List<String>  pickingIds){	
		return pickingRecordService.deletePickRecord(pickingIds);
	}
		

	@RequestMapping(value = "/listPickingType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "获取领用类型", notes = "")
	@JsonView({ ListView.class })
	public NewPageResult<StoreHouseType> getStoreHouseTypeList() {
		StoreHouseTypeExample example = new StoreHouseTypeExample();
		example.setIsPage(0);
		example.setOrderByClause("a.type_code asc");
		com.qz.zframe.material.entity.StoreHouseTypeExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(IsDeleteEnum.DELETE_NO.getCode());
		criteria.andPickTypeCodeLike("2");
		return storeHouseTypeService.getStoreHouseTypeList(example);
	}
}
