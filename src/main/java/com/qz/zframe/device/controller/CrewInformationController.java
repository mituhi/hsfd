package com.qz.zframe.device.controller;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.service.EquipmentLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.device.entity.CrewInformationExample.Criteria;
import com.qz.zframe.device.service.CrewInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/crew")
@Api(tags = {"api-support-device-crew"}, description = "设备-机组信息")
public class CrewInformationController {
	
	private static Logger logger = LoggerFactory.getLogger(CrewInformationController.class);
	
	@Autowired
	private CrewInformationService crewInformationService;
	@Autowired
	private EquipmentLogService equipmentLogService;

	@Autowired
	private CurrentUserService currentUserService;
	
	/**
	 * 获取机组信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param crewCode  机组编码
	 * @param crewId  机组名称
	 * @param windId  所属风电场
	 */
	@RequestMapping(value = "/findCrew", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取机组信息", notes = " 获取机组信息")
	public PageResultEntity findCrew(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
	        @ApiParam(name="crewCode",value="机组编码",required=false)String crewCode,
	        @RequestParam(required = false)
	        @ApiParam(name="crewId",value="机组Id",required=false)String crewId,
			@RequestParam(required = false)
		    @ApiParam(name="windId",value="风电场",required=false)String windId,
		    @RequestParam(required = false)
		    @ApiParam(name="windId2",value="风电场",required=false)String windId2){
		
		logger.info("===== 设备-机组信息CrewInformationController.findCrew =====crewCode:"+crewCode+"crewId:"+crewId+"windId:"+windId);
		
		PageResultEntity resultEntity = new PageResultEntity();
		CrewInformationExample crewExample = new CrewInformationExample();
		crewExample.setPageSize(pageSize);
		crewExample.setPageNo(pageNum);
		crewExample.setOrderByClause(" crew_code  asc ");
		Criteria criteria =crewExample.createCriteria();
		if (StringUtils.isNotBlank(crewCode) ){
			criteria.andCrewCodeLike(crewCode);
		}
		if (StringUtils.isNotBlank(crewId) ){
			criteria.andCrewIdEqualTo(crewId);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isBlank(windId2)){
			criteria.andWindIdEqualTo(windId);
		}
		if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId2) ){
			criteria.andWindIdBetween(windId,windId2);
		}
		resultEntity = crewInformationService.findCrew(crewExample);
		return resultEntity;
	}
	
	@RequestMapping(value = "/addCrew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增机组信息", notes = "新增机组信息")
    public ResultEntity addCrew(@RequestBody CrewInformation crew) {
		
		logger.info("===== 设备-机组信息CrewInformationController.addCrew =====CrewInformation:"+crew);
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(crew.getCrewCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少机组编码必要字段");
			return resultEntity;
		} 
		if(    StringUtils.isBlank(crew.getCrewName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少机组名称必要字段");
			return resultEntity;
		}
		if(   StringUtils.isBlank(crew.getWindId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少风电场必要字段");
			return resultEntity;
		
		}
		resultEntity = crewInformationService.addCrew(crew);
        return resultEntity;
    }
	
	@RequestMapping(value = "/updateCrew", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改机组信息", notes = "修改机组信息")
    public ResultEntity updateCrew(@RequestBody CrewInformation crew) {
		
		logger.info("===== 设备-机组信息CrewInformationController.updateCrew =====CrewInformation:"+crew);
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(crew.getCrewCode())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少机组编码必要字段");
			return resultEntity;
		} 
		if(    StringUtils.isBlank(crew.getCrewName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少机组名称必要字段");
			return resultEntity;
		}
		if(  StringUtils.isBlank(crew.getWindId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少风电场必要字段");
			return resultEntity;
		}
		if( StringUtils.isBlank(crew.getCrewId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据进行编辑");
			return resultEntity;
		}
		resultEntity = crewInformationService.updateCrew(crew);
        return resultEntity;
    }
	
	
	@RequestMapping(value = "/findByCrewId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询机组信息详情", notes = "查询机组信息详情")
    public PageResultEntity findByCrewId(
    		@RequestParam(required = true)
    		@ApiParam(name="crewId",value="机组信息id",required=true) String crewId) {
		
		logger.info("===== 设备-机组信息CrewInformationController.findByCrewId =====crewId:"+crewId);
		
		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(crewId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中查看的数据");
			return resultEntity;
		}
		resultEntity = crewInformationService.findByCrewId(crewId);
        return resultEntity;
    }
	
	@RequestMapping(value = "/deleteCrew", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除机组信息", notes = "批量删除机组信息")
    public ResultEntity deleteCrew(@RequestParam(required = true) List<String> crewIds) {
		
		logger.info("===== 设备-机组信息CrewInformationController.deleteCrew =====crewIds:"+crewIds);
		
		ResultEntity resultEntity = new ResultEntity();
		if (crewIds==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = crewInformationService.deleteCrew(crewIds);
        return resultEntity;
    }
	
	
	@RequestMapping(value = "/ExportExcl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出机组信息", notes = "导出机组信息")
	public String ExportExcl(
			HttpServletResponse response,
			@RequestParam(required = false ,defaultValue = "机组信息")String sheetName,
			@RequestParam(required = false)
			@ApiParam(name="crewCode",value="机组编码",required=false)String crewCode,
			@RequestParam(required = false)
			@ApiParam(name="crewName",value="机组名称",required=false)String crewName,
			@RequestParam(required = false)
			@ApiParam(name="windId",value="风电场",required=false)String windId) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		CrewInformationExample crewExample = new CrewInformationExample();
		Criteria criteria =crewExample.createCriteria();
		if (StringUtils.isNotBlank(crewCode) ){
			criteria.andCrewCodeLike(crewCode);
		}
		if (StringUtils.isNotBlank(crewName) ){
			criteria.andCrewNameEqualTo(crewName);
		}
		if (StringUtils.isNotBlank(windId) ){
			criteria.andWindIdEqualTo(windId);
		}
		String fileName= crewInformationService.ExportExcl(crewExample,response,sheetName);
		return  fileName;
	}

	@RequestMapping(value = "/SerialNum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "流水号信息", notes = "流水号信息")
	public ResultEntity SerialNum(
			) throws Exception {

		ResultEntity resultEntity=new ResultEntity();

		EquipmentLog equipmentLog=new EquipmentLog();
		equipmentLog.setLogId((UUID.randomUUID()+"").replaceAll("-",""));
		equipmentLog.setUserName(currentUserService.getUsername());

		equipmentLog.setDate(new Date());

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("获取成功!");
		resultEntity.setData(equipmentLog);
		return  resultEntity;
	}
}
