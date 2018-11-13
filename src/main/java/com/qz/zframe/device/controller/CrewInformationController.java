package com.qz.zframe.device.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
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
	@Autowired
	private CrewInformationService crewInformationService;
	
	/**
	 * 获取机组信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param crewCode  机组编码
	 * @param crewName  机组名称
	 * @param windId  所属风电场
	 */
	@RequestMapping(value = "/findCrew", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取机组信息", notes = " 获取机组信息")
	public PageResultEntity findCrew(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false)
	        @ApiParam(name="crewCode",value="机组编码",required=false)String crewCode,
	        @RequestParam(required = false)
	        @ApiParam(name="crewName",value="机组名称",required=false)String crewName,
	        @RequestParam(required = false)
	        @ApiParam(name="windId",value="风电场",required=false)String windId){
		PageResultEntity resultEntity = new PageResultEntity();
		CrewInformationExample crewExample = new CrewInformationExample();
		crewExample.setPageSize(pageSize);
		crewExample.setPageNo(pageNum);
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
		resultEntity = crewInformationService.findCrew(crewExample);
		return resultEntity;
	}
	
	/**
	 * 新增位置信息
	 */
	@RequestMapping(value = "/addCrew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增机组信息", notes = "新增机组信息")
    public ResultEntity addCrew(@RequestBody CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(crew.getCreater()) || 
			StringUtils.isBlank(crew.getCrewCode()) ||
		    StringUtils.isBlank(crew.getCrewName()) ||
			StringUtils.isBlank(crew.getInstalledCapacity())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = crewInformationService.addCrew(crew);
        return resultEntity;
    }
	
	@RequestMapping(value = "/updateCrew", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改机组信息", notes = "修改机组信息")
    public ResultEntity updateCrew(@RequestBody CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(crew.getCreater()) || 
				StringUtils.isBlank(crew.getCrewCode()) ||
			    StringUtils.isBlank(crew.getCrewName()) ||
				StringUtils.isBlank(crew.getInstalledCapacity()) || 
				StringUtils.isBlank(crew.getWindId())||
				StringUtils.isBlank(crew.getCrewId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = crewInformationService.updateCrew(crew);
        return resultEntity;
    }
	
	
	@RequestMapping(value = "/findByCrewId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询机组信息详情", notes = "查询机组信息详情")
    public PageResultEntity findByParameterId(
    		@RequestParam(required = true)
    		@ApiParam(name="crewId",value="机组信息id",required=true) String crewId) {
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
    public ResultEntity deleteCrew(@RequestBody List<String> crewIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (crewIds==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = crewInformationService.deleteCrew(crewIds);
        return resultEntity;
    }

}
