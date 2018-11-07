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
import com.qz.zframe.device.entity.Parameters;
import com.qz.zframe.device.entity.ParametersExample;
import com.qz.zframe.device.entity.ParametersExample.Criteria;
import com.qz.zframe.device.service.ParametersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/parameters")
@Api(tags = {"api-support-device-parameters"}, description = "设备-技术参数")
public class ParametersController {
	@Autowired
	private ParametersService parametersService;
	
	/**
	 * 获取技术参数信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param parameterName  技术参数名称
	 * 
	 */
	@RequestMapping(value = "/findParameters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取技术参数信息", notes = " 获取技术参数信息")
	public PageResultEntity findPosition(@RequestParam(required = false) Integer pageNum,@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false)
	        @ApiParam(name="parameterName",value="技术参数名称",required=false)String parameterName){
		PageResultEntity resultEntity = new PageResultEntity();
		ParametersExample parameterExample = new ParametersExample();
		parameterExample.setPageSize(pageSize);
		parameterExample.setPageNo(pageNum);
		Criteria criteria =parameterExample.createCriteria();
		if (StringUtils.isNotBlank(parameterName) ){
			criteria.andParameterNameLike(parameterName);
		}
		resultEntity = parametersService.findParameters(parameterExample);
		return resultEntity;
	}
	
	/**
	 * 新增位置信息
	 */
	@RequestMapping(value = "/addParameters", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "新增技术参数信息", notes = "新增技术参数信息")
    public ResultEntity addParameters(@RequestBody Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(parameters.getCompany()) || 
			StringUtils.isBlank(parameters.getParameterCode()) ||
		    StringUtils.isBlank(parameters.getParameterName()) ||
			StringUtils.isBlank(parameters.getStatus()) || 
			StringUtils.isBlank(parameters.getType())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = parametersService.addParameters(parameters);
        return resultEntity;
    }
	
	@RequestMapping(value = "/updateParameters", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改技术参数信息", notes = "修改技术参数信息")
    public ResultEntity updateParameters(@RequestBody Parameters parameters) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(parameters.getCompany()) || 
				StringUtils.isBlank(parameters.getParameterCode()) ||
			    StringUtils.isBlank(parameters.getParameterId()) || 
			    StringUtils.isBlank(parameters.getParameterName()) ||
				StringUtils.isBlank(parameters.getStatus()) || 
				StringUtils.isBlank(parameters.getType())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = parametersService.updateParameters(parameters);
        return resultEntity;
    }
	
	
	@RequestMapping(value = "/findByParameterId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "查询技术参数详情", notes = "查询技术参数详情")
    public PageResultEntity findByParameterId(@RequestParam 
    		 @ApiParam(name="parameterId",value="技术参数id",required=false)String parameterId) {
		PageResultEntity resultEntity = new PageResultEntity();
		if (StringUtils.isBlank(parameterId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中查看的数据");
			return resultEntity;
		}
		resultEntity = parametersService.findByParameterId(parameterId);
        return resultEntity;
    }
	
	@RequestMapping(value = "/deleteParameters", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "批量删除技术参数信息", notes = "批量删除技术参数信息")
    public ResultEntity deleteParameters(@RequestBody List<String> parameterIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (parameterIds==null ){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = parametersService.deleteParameters(parameterIds);
        return resultEntity;
    }
}
