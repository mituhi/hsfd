package com.qz.zframe.device.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.PositionEncodeExample;
import com.qz.zframe.device.entity.PositionEncodeExample.Criteria;
import com.qz.zframe.device.service.UniversalDropBoxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/dropBox")
@Api(tags = {"api-support-device-dropBox"}, description = "设备-下拉框")
public class UniversalDropBoxController {
	@Autowired
	private UniversalDropBoxService universalDropBoxService;

	 //设备分类上级设备
	@RequestMapping(value = "/findSuperiorEquipment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 上级设备分类", notes = " 上级设备分类")
	 public PageResultEntity  findSuperiorEquipment() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findSuperiorEquipment();
		return resultEntity;
	}
	/*  //位置上级位置
	@RequestMapping(value = "/findSuperiorPostition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 上级位置信息", notes = " 上级位置信息")
	 public PageResultEntity  findSuperiorPostition() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findSuperiorPostition();
		return resultEntity;
	}*/
	
	/* //机组
	@RequestMapping(value = "/findCrews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "机组", notes = " 机组")
	 public PageResultEntity  findCrews() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findCrews();
		return resultEntity;
	}*/
	 /*  //风电厂
	@RequestMapping(value = "/findWind", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 风电厂", notes = " 风电厂")
	 public PageResultEntity  findWind() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findWind();
		return resultEntity;
	}
	    //公司
	@RequestMapping(value = "/findCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 公司", notes = " 公司")
	 public PageResultEntity  findCompany() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findCompany();
		return resultEntity;
	}
	   //部门
	@RequestMapping(value = "/findSection", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 部门", notes = " 部门")
	 public PageResultEntity  findSection() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findSection();
		return resultEntity;
	}
	  //班组
	@RequestMapping(value = "/findTeamGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "维护班组", notes = " 维护班组")
	 public PageResultEntity  findTeamGroup() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findTeamGroup();
		return resultEntity;
	}*/
	 //供应商
	@RequestMapping(value = "/findSupplier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "供应商", notes = " 供应商")
	 public PageResultEntity  findSupplier() {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findSupplier();
		return resultEntity;
	}
	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "当前登陆人的信息和现在时间和流水号", notes = "当前登陆人的信息和现在时间和流水号")
	 public ResultEntity   find() {
		ResultEntity resultEntity=new ResultEntity();
		resultEntity = universalDropBoxService.find();
		return resultEntity;
	}
	 //设备分类上级设备
		@RequestMapping(value = "/findSuperiorEquipmentList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 带入设备分类信息", notes = " 带入设备分类信息")
		 public PageResultEntity  findSuperiorEquipmentList(@RequestParam(required = false)
		    @ApiParam(name="equipmentId",value="设备分类id",required=false)String equipmentId) {
			PageResultEntity resultEntity = new PageResultEntity();
		/*	if(StringUtils.isBlank(equipmentId)) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选中设备分类");
				return resultEntity;
			}*/
			resultEntity = universalDropBoxService.findSuperiorEquipmentList(equipmentId);
			return resultEntity;
		}
		   //位置上级位置
		@RequestMapping(value = "/findSuperiorPostitionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 带入位置信息", notes = " 带入位置信息")
		 public PageResultEntity  findSuperiorPostitionList(
		    @RequestParam(required = false)
		    @ApiParam(name="positionId",value="位置id",required=false)String positionId
		    ) {
			PageResultEntity resultEntity = new PageResultEntity();
			PositionEncodeExample postitionExample = new PositionEncodeExample();
			/*postitionExample.setPageSize(pageSize);
			postitionExample.setPageNo(pageNum);
			postitionExample.setOrderByClause(" create_time desc ");*/
			/*Criteria criteria =postitionExample.createCriteria();
			if(StringUtils.isNotBlank(positionId)) {
				criteria.andPositionIdEqualTo(positionId);
			}
			if(StringUtils.isNotBlank(positionCode)) {
				criteria.andPositionCodeEqualTo(positionCode);
			}
			if(StringUtils.isNotBlank(positionName)) {
				criteria.andPositionNameEqualTo(positionName);
			}*/
			resultEntity = universalDropBoxService.findSuperiorPostitionList(positionId);
			return resultEntity;
		}
		
		 //设备分类上级设备
		@RequestMapping(value = "/findSuperiorEquipmentAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 所有设备分类", notes = " 所有设备分类")
		 public PageResultEntity  findSuperiorEquipmentAll() {
			PageResultEntity resultEntity = new PageResultEntity();
			resultEntity = universalDropBoxService.findSuperiorEquipmentAll();
			return resultEntity;
		}
		   //位置上级位置
		@RequestMapping(value = "/findSuperiorPostitionAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 所有上级位置信息", notes = " 所有上级位置信息")
		 public PageResultEntity  findSuperiorPostitionAll() {
			PageResultEntity resultEntity = new PageResultEntity();
			resultEntity = universalDropBoxService.findSuperiorPostitionAll();
			return resultEntity;
		}

	/*// 根据风电场查询位置信息
	@RequestMapping(value = "/findWindAndPosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 根据风电场查询位置信息", notes = " 根据风电场查询位置信息")
	public PageResultEntity findWindAndPosition(
			@RequestParam(required = true) @ApiParam(name = "windId", value = "风电场编码", required = false) String windId) {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findWindAndPosition(windId);
		return resultEntity;
	}*/

	// 根据风电场位置信息查询设备信息
	@RequestMapping(value = "/findWindAndPositionAndEquipment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "根据风电场位置信息查询设备信息", notes = "根据风电场位置信息查询设备信息")
	public PageResultEntity findWindAndPositionAndEquipment(
/*			@RequestParam(required =false) @ApiParam(name = "windId", value = "风电场编码", required = false) String windId,*/
			@RequestParam(required = false) @ApiParam(name = "positionId", value = "位置id信息", required = false) String positionId) {
		PageResultEntity resultEntity = new PageResultEntity();
		resultEntity = universalDropBoxService.findWindAndPositionAndEquipment(positionId);
		return resultEntity;
	}
	        //所有分层位置信息和根据风电场
  @RequestMapping(value = "/findSuperiorPostitionAlls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = " 所有分层位置信息", notes = " 所有分层位置信息")
   public PageResultEntity  findSuperiorPostitionAlls(
		   @RequestParam(required = false) @ApiParam(name = "windId", value = "风电场编码", required = false) String windId) {
	PageResultEntity resultEntity = new PageResultEntity();
	resultEntity = universalDropBoxService.findSuperiorPostitionAlls(windId);
	return resultEntity;
			}
  
  //根据层级来查询上级位置信息
@RequestMapping(value = "/findSuperiorPostitionAllByHierarchy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiOperation(value = " 根据层级来查询上级位置信息", notes = " 根据层级来查询上级位置信息")
public PageResultEntity  findSuperiorPostitionAllByHierarchy(			
		@RequestParam(required = true) 
		@ApiParam(name = "hierarchy", value = "层级", required = true) String hierarchy,
		@RequestParam(required = true) 
		@ApiParam(name = "windId", value = "风电场编码", required = true) String windId) {
     PageResultEntity resultEntity = new PageResultEntity();
	resultEntity = universalDropBoxService.findSuperiorPostitionAllByHierarchy(hierarchy,windId);
   return resultEntity;
		}


@RequestMapping(value = "/findCrewByWind", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiOperation(value = "根据风电场查询机组", notes = "根据风电场查询机组")
 public PageResultEntity  findCrewByWind(@RequestParam(required =false) @ApiParam(name = "windId", value = "风电场编码", required = false) String windId) {
	PageResultEntity resultEntity = new PageResultEntity();
	resultEntity = universalDropBoxService.findCrewByWind(windId);
	return resultEntity;
}
}
