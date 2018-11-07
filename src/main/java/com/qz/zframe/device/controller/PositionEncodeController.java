package com.qz.zframe.device.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.qz.zframe.device.entity.EquipmentClassificationExample;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;
import com.qz.zframe.device.entity.PositionEncodeExample.Criteria;
import com.qz.zframe.device.service.PositionEncodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@RequestMapping("/api/support/device/position")
@Api(tags = {"api-support-device-position"}, description = "设备-位置编码")
public class PositionEncodeController {
		@Autowired
		private PositionEncodeService positionEncodeService;
		/**
		 * 获取位置信息
		 * 
		 * @param pageNum
		 * @param pageSize
		 * @param windId  风电场
		 * @param crew   机组
		 * @param hierarchy  层级
		 * @param positionName   位置名称
		 * 
		 */
		@RequestMapping(value = "/findPosition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 获取位置编码信息", notes = " 获取位置编码信息")
		public PageResultEntity findPosition(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
				@RequestParam(required = false)
		        @ApiParam(name="windId",value="风电场",required=false)String windId,
		        @RequestParam(required = false) 
		        @ApiParam(name="crew",value="机组",required=false)String crew,
				@RequestParam(required = false)
		        @ApiParam(name="hierarchy",value="层级",required=false) String hierarchy,
		        @RequestParam(required = false) 
		        @ApiParam(name="positionName",value="位置名称",required=false) String positionName){
			PageResultEntity resultEntity = new PageResultEntity();
			PositionEncodeExample postitionExample = new PositionEncodeExample();
			postitionExample.setPageSize(pageSize);
			postitionExample.setPageNo(pageNum);
			Criteria criteria =postitionExample.createCriteria();
			if (StringUtils.isNotBlank(windId) ){
				criteria.andWindIdEqualTo(windId);
			}
			if (StringUtils.isNotBlank(crew) ){
				criteria.andCrewEqualTo(crew);
			}
			if (StringUtils.isNotBlank(hierarchy) ){
				criteria.andHierarchyEqualTo(hierarchy);
			}
			if (StringUtils.isNotBlank(positionName) ){
				criteria.andPositionNameLike(positionName);
			}
			resultEntity = positionEncodeService.findPosition(postitionExample);
			return resultEntity;
		}
		
		/**
		 * 新增位置信息
		 */
		@RequestMapping(value = "/addPosition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "新增位置信息", notes = "新增位置信息")
	    public ResultEntity addPosition(@RequestBody PositionEncode positionEncode) {
			ResultEntity resultEntity = new ResultEntity();
			if (StringUtils.isBlank(positionEncode.getCompanyCode()) || StringUtils.isBlank(positionEncode.getCostCenter()) ||
			    StringUtils.isBlank(positionEncode.getCrew()) || StringUtils.isBlank(positionEncode.getDepartment()) ||
				StringUtils.isBlank(positionEncode.getHierarchy()) || StringUtils.isBlank(positionEncode.getIsToplevel()) ||
				StringUtils.isBlank(positionEncode.getMaintenanceTeam()) || StringUtils.isBlank(positionEncode.getPositionCode()) ||	
			    StringUtils.isBlank(positionEncode.getPositionName())|| 
				StringUtils.isBlank(positionEncode.getStatus())|| StringUtils.isBlank(positionEncode.getSuperiorPosition())|| 
				StringUtils.isBlank(positionEncode.getWindId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少必要字段");
				return resultEntity;
			}
			resultEntity = positionEncodeService.addPosition(positionEncode);
	        return resultEntity;
	    }
		
		@RequestMapping(value = "/updatePosition", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "修改位置信息", notes = "修改位置信息")
	    public ResultEntity updatePosition(@RequestBody PositionEncode positionEncode) {
			ResultEntity resultEntity = new ResultEntity();
			if (StringUtils.isBlank(positionEncode.getCompanyCode()) || StringUtils.isBlank(positionEncode.getCostCenter()) ||
				    StringUtils.isBlank(positionEncode.getCrew()) || StringUtils.isBlank(positionEncode.getDepartment()) ||
					StringUtils.isBlank(positionEncode.getHierarchy()) || StringUtils.isBlank(positionEncode.getIsToplevel()) ||
					StringUtils.isBlank(positionEncode.getMaintenanceTeam()) || StringUtils.isBlank(positionEncode.getPositionCode()) ||	
					StringUtils.isBlank(positionEncode.getPositionId()) || StringUtils.isBlank(positionEncode.getPositionName())|| 
					StringUtils.isBlank(positionEncode.getStatus())|| StringUtils.isBlank(positionEncode.getSuperiorPosition())|| 
					StringUtils.isBlank(positionEncode.getWindId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少必要字段");
				return resultEntity;
			}
			resultEntity = positionEncodeService.updatePosition(positionEncode);
	        return resultEntity;
	    }
		
		
		@RequestMapping(value = "/findByPositionId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "查询位置信息详情", notes = "查询位置信息详情")
	    public PageResultEntity findByPositionId(@RequestParam 
	    		 @ApiParam(name="positionId",value="位置id",required=true)String positionId) {
			PageResultEntity resultEntity = new PageResultEntity();
			if (StringUtils.isBlank(positionId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选中查看的数据");
				return resultEntity;
			}
			resultEntity = positionEncodeService.findByPositionId(positionId);
	        return resultEntity;
	    }
		
		@RequestMapping(value = "/deletePositions", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "批量删除位置信息", notes = "批量删除位置信息")
	    public ResultEntity deletePositions(@RequestBody List<String> positionIds) {
			ResultEntity resultEntity = new ResultEntity();
			if (positionIds==null ){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选中删除的数据");
				return resultEntity;
			}
			resultEntity = positionEncodeService.deletePositions(positionIds);
	        return resultEntity;
	    }
		
		@RequestMapping(value = "/findStructure", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 获取位置信息顶层结构", notes = " 获取位置信息顶层结构")
		public PageResultEntity findStructure(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize
				){
			PageResultEntity resultEntity = new PageResultEntity();
			EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
			equipmentExample.setPageSize(pageSize);
			equipmentExample.setPageNo(pageNum);
			resultEntity = positionEncodeService.findStructure();
			return resultEntity;
		}
		@RequestMapping(value = "/findStructureList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value = " 获取位置信息结构", notes = " 获取位置信息结构")
		public PageResultEntity findStructureList(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
				@RequestParam(required = true) String superiorPosition){
			PageResultEntity resultEntity = new PageResultEntity();
			EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
			equipmentExample.setPageSize(pageSize);
			equipmentExample.setPageNo(pageNum);
			resultEntity = positionEncodeService.findStructureList(superiorPosition);
			return resultEntity;
		}
}
