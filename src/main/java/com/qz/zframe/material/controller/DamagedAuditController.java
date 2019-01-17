package com.qz.zframe.material.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.authentication.domain.UserInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.NewPageResult;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.ResultEntityDetail;
import com.qz.zframe.material.entity.DamagedAudit;
import com.qz.zframe.material.entity.DamagedAuditExample;
import com.qz.zframe.material.entity.DamagedAuditExample.Criteria;
import com.qz.zframe.material.service.DamagedAuditService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/damagedAudit")
@Api(tags = "api-support-damagedAudit", description = "物资管理-损坏件核定")
public class DamagedAuditController {

	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private DamagedAuditService damagedAuditService;
	
	
	@RequestMapping(value = "/listDamagedAudit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "损坏件审核列表", notes = "损坏件审核列表")
	public NewPageResult<DamagedAudit>  getDamageAuditList(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) @ApiParam(name = "damagedAauditDescribe", value = "核定详情", required = false) String damagedAauditDescribe,
			@RequestParam(required = false) @ApiParam(name = "startDate", value = "开始时间", required = false) String startDate,
			@RequestParam(required = false) @ApiParam(name = "endDate", value = "结束时间", required = false) String endDate,
			@RequestParam(required = false) @ApiParam(name = "windIds", value = "风电场", required = false) List<String> windIds
			) throws ParseException{
		DamagedAuditExample example = new DamagedAuditExample();
		example.setPageNo(pageNum);
		example.setPageSize(pageNum);
		example.setOrderByClause("a.create_time desc");
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isBlank(damagedAauditDescribe)) {
			criteria.andDamagedAuditDescribeLike(damagedAauditDescribe);
		}
		if (!StringUtils.isBlank(startDate)&&!StringUtils.isBlank(endDate)) {
			criteria.andCreateTimeBetween(format.parse(startDate), format.parse(endDate));
		}
		if(windIds!=null&&!windIds.isEmpty()){
			criteria.andWindIdIn(windIds);
		}
		return damagedAuditService.getDamageAuditList(example);
	}
	
	
	@RequestMapping(value = "/datailDamagedAudit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "损坏件审核详情", notes = "damageAuditId:苏幻剑")
	public ResultEntityDetail<DamagedAudit> getDamageAuditListDatail(@RequestParam(required = true) @ApiParam(name = "damageAuditId", value = "损坏件核定id", required = false) String damageAuditId){
		return damagedAuditService.getDamageAuditListDatail(damageAuditId);
		
	}
	
	@RequestMapping(value = "/saveDamagedAudit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增损坏件核定信息", notes = "损坏件审核列表")
	public ResultEntity saveDamageAudit(@RequestBody DamagedAudit damagedAudit){
		ResultEntity resultEntity = new ResultEntity();
		if(damagedAudit.getDamagedAuditDetails() ==null||damagedAudit.getDamagedAuditDetails().isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少物资明细");
			return resultEntity;
		}
		return damagedAuditService.addDamageAudit(damagedAudit); 
	}
	
	@RequestMapping(value = "/editDamagedAudit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "编辑损坏件核定信息", notes = "损坏件审核列表")
	public ResultEntity editDamagedAudit(@RequestBody DamagedAudit damagedAudit){
		return damagedAuditService.editDamagedAudit(damagedAudit); 
	}
	
	@RequestMapping(value = "/delDamagedAudit", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "删除损坏件核定信息", notes = "损坏件审核列表")
	public ResultEntity delDamagedAudit(@RequestBody List<String> damagedAuditIds){
		ResultEntity resultEntity = new ResultEntity();
		if(damagedAuditIds == null||damagedAuditIds.isEmpty()){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("损坏件审核id不能为空");
			return resultEntity;
		}
		return damagedAuditService.delDamagedAudit(damagedAuditIds); 
	}
	
	
}
