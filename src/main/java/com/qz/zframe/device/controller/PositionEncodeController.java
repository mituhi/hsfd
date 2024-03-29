package com.qz.zframe.device.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	private static Logger logger = LoggerFactory.getLogger(PositionEncodeController.class);
	
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
		public PageResultEntity findPosition(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
				@RequestParam(required = false)
		        @ApiParam(name="windId",value="风电场",required=false)String windId,
		        @RequestParam(required = false)
		        @ApiParam(name="windId2",value="风电场",required=false)String windId2,
		        @RequestParam(required = false) 
		        @ApiParam(name="crew",value="机组",required=false)String crew,
				@RequestParam(required = false)
		        @ApiParam(name="hierarchy",value="层级",required=false) String hierarchy,
		        @RequestParam(required = false) 
		        @ApiParam(name="positionName",value="位置名称",required=false) String positionName){
			
			logger.info("===== 设备-位置编码PositionEncodeController.findPosition ====windId:"+  windId+"crew:"+crew+"positionName:"+positionName+"hierarchy:"+hierarchy);
			
			PageResultEntity resultEntity = new PageResultEntity();
			PositionEncodeExample postitionExample = new PositionEncodeExample();
			postitionExample.setPageSize(pageSize);
			postitionExample.setPageNo(pageNum);
			postitionExample.setOrderByClause("status,position_code ASC ");
			Criteria criteria =postitionExample.createCriteria();
			if (StringUtils.isNotBlank(windId) && StringUtils.isBlank(windId2)){
				criteria.andWindIdEqualTo(windId);
			}
			if (StringUtils.isNotBlank(windId) && StringUtils.isNotBlank(windId2)){
				criteria.andWindIdBetween(windId, windId2);
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
			
			logger.info("===== 设备-位置编码PositionEncodeController.addPosition ====PositionEncode:"+  positionEncode);
			
			ResultEntity resultEntity = new ResultEntity();
			if ( StringUtils.isBlank(positionEncode.getPositionCode())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少位置编码必要字段");
				return resultEntity;
			} 
			if ( StringUtils.isBlank(positionEncode.getPositionName())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少位置名称必要字段");
				return resultEntity;
			} 	 
			if(	StringUtils.isBlank(positionEncode.getWindId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少风电场必要字段");
				return resultEntity;
				
			}
			if(	StringUtils.isBlank(positionEncode.getHierarchy())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少层级必要字段");
				return resultEntity;
				
			}
			/*if(	StringUtils.isBlank(positionEncode.getDepartment())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少部门必要字段");
				return resultEntity;
				
			}
			if(	StringUtils.isBlank(positionEncode.getMaintenanceTeam())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少维护班组必要字段");
				return resultEntity;
				
			}*/
			resultEntity = positionEncodeService.addPosition(positionEncode);
	        return resultEntity;
	    }
		
		@RequestMapping(value = "/updatePosition", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "修改位置信息", notes = "修改位置信息")
	    public ResultEntity updatePosition(@RequestBody PositionEncode positionEncode) {
			
			logger.info("===== 设备-位置编码PositionEncodeController.updatePosition ====PositionEncode:"+  positionEncode);
			
			ResultEntity resultEntity = new ResultEntity();
			if ( StringUtils.isBlank(positionEncode.getPositionCode())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少位置编码必要字段");
				return resultEntity;
			} 	 
			if(StringUtils.isBlank(positionEncode.getWindId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少风电场必要字段");
				return resultEntity;
			}
			if(StringUtils.isBlank(positionEncode.getPositionId())){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("未选中数据进行编辑");
				return resultEntity;
			}
			resultEntity = positionEncodeService.updatePosition(positionEncode);
	        return resultEntity;
	    }
		
		
		@RequestMapping(value = "/findByPositionId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ApiOperation(value = "查询位置信息详情", notes = "查询位置信息详情")
	    public PageResultEntity findByPositionId(@RequestParam 
	    		 @ApiParam(name="positionId",value="位置id",required=true)String positionId) {
			
			logger.info("===== 设备-位置编码PositionEncodeController.findByPositionId ====positionId:"+  positionId);
			
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
	    public ResultEntity deletePositions(@RequestParam(required=true) List<String> positionIds) {
			
			logger.info("===== 设备-位置编码PositionEncodeController.deletePositions ====positionIds:"+ positionIds);
			
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
				@RequestParam(required = true) String positionId){
			PageResultEntity resultEntity = new PageResultEntity();
			EquipmentClassificationExample equipmentExample = new EquipmentClassificationExample();
		
			resultEntity = positionEncodeService.findStructureList(positionId);
			return resultEntity;
		}
		@ApiOperation(value = "导入KKS位置编码", notes = "导入KKS位置编码")
		@RequestMapping(value = "importFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResultEntity importFile(@RequestParam("file") MultipartFile file) throws Exception {
			ResultEntity resultEntity=new ResultEntity();
			if (file.isEmpty()) {
				throw new Exception("传回后台的文件为空");
			}
			resultEntity=positionEncodeService.importBook(file.getOriginalFilename(), file.getInputStream());
            return  resultEntity;
		}
}
