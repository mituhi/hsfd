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
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.OutputParametersExample;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.entity.RunParametersExample;
import com.qz.zframe.device.entity.RunParametersExample.Criteria;
import com.qz.zframe.device.service.OutputRunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/outputRun")
@Api(tags = {"api-support-device-outputRun"}, description = "设备-出场运行技术参数")
public class OutputRunController {
	
	private static Logger logger = LoggerFactory.getLogger(OutputRunController.class);
	
	@Autowired
	private OutputRunService outputRunService;

	/**
	 * 获取运行技术参数信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param parameterName
	 *            技术参数名称
	 * 
	 */
	@RequestMapping(value = "/findRun", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取运行技术参数信息", notes = " 获取运行技术参数信息")
	public PageResultEntity findRun(@RequestParam(defaultValue = "1") Integer pageNum, 
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="parameterName",value="参数名称",required=false)String parameterName) {
		logger.info("===== 设备-出场运行技术参数OutputRunController.findRun ===== ");
		PageResultEntity resultEntity = new PageResultEntity();
		RunParametersExample runExample = new RunParametersExample();
		runExample.setPageSize(pageSize);
		runExample.setPageNo(pageNum);
		Criteria criteria =runExample.createCriteria();
		if (StringUtils.isNotBlank(parameterName)) {
			criteria.andParameterNameLike(parameterName);
		}
		resultEntity = outputRunService.findRun(runExample);
		return resultEntity;
	}

	/**
	 * 新增位置信息
	 */
	@RequestMapping(value = "/addRun", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增运行技术参数息", notes = "新增运行技术参数信息")
	public ResultEntity addRun(@RequestBody RunParameters run) {
		logger.info("===== 设备-出场运行技术参数OutputRunController.findRun =====RunParameters:"+ run );
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(run.getParameterCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数编码必要字段");
		    return resultEntity;
		} 
        if( StringUtils.isBlank(run.getParameterName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数名称必要字段");
		    return resultEntity;
        }
		if( StringUtils.isBlank(run.getType())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少数据类型必要字段");
		    return resultEntity;
		} 
		if(	StringUtils.isBlank(run.getCompany())){
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少单位必要字段");
		    return resultEntity;
		}
		if( StringUtils.isBlank(run.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少数字值必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.addRun(run);
		return resultEntity;
	}

	@RequestMapping(value = "/updateRun", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改运行技术参数信息", notes = "修改运行技术参数信息")
	public ResultEntity updateRun(@RequestBody RunParameters run) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.updateRun =====RunParameters:"+ run );
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(run.getParameterCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数编码必要字段");
		    return resultEntity;
		} 
        if( StringUtils.isBlank(run.getParameterName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数名称必要字段");
		    return resultEntity;
        }
		if( StringUtils.isBlank(run.getType())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少数据类型必要字段");
		    return resultEntity;
		} 
		if(	StringUtils.isBlank(run.getCompany())){
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少单位必要字段");
		    return resultEntity;
		}
		if( StringUtils.isBlank(run.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少数字值必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.updateRun(run);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteRun", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除运行技术参数信息", notes = "批量删除运行技术参数信息")
	public ResultEntity deleteRun(@RequestParam(required=true) List<String> runIds) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.deleteRun =====runIds:"+ runIds );
		
		ResultEntity resultEntity = new ResultEntity();
		if (runIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = outputRunService.deleteRun(runIds);
		return resultEntity;
	}

	/**
	 * 获取出场技术参数信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * 
	 */
	@RequestMapping(value = "/findOutout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取出场技术参数信息", notes = " 获取出场技术参数信息")
	public PageResultEntity findOutout(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
            @ApiParam(name="parameterName",value="参数名称",required=false)String parameterName) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.findOutout ====="  );
		
		PageResultEntity resultEntity = new PageResultEntity();
		OutputParametersExample outputExample = new OutputParametersExample();
		outputExample.setPageSize(pageSize);
		outputExample.setPageNo(pageNum);
		com.qz.zframe.device.entity.OutputParametersExample.Criteria criteria =outputExample.createCriteria();
		if (StringUtils.isNotBlank(parameterName)) {
			criteria.andParameterNameLike(parameterName);
		}

		resultEntity = outputRunService.findOutout(outputExample);
		return resultEntity;
	}

	@RequestMapping(value = "/addOutout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增出场技术参数信息", notes = "新增出场技术参数信息")
	public ResultEntity addOutout(@RequestBody OutputParameters output) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.addOutout =====OutputParameters:"+  output );
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(output.getParameterCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数编码必要字段");
		    return resultEntity;
		} 
        if( StringUtils.isBlank(output.getParameterName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数名称必要字段");
		    return resultEntity;
        }
		if( StringUtils.isBlank(output.getType())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少数据类型必要字段");
		    return resultEntity;
		} 
		if(	StringUtils.isBlank(output.getCompany())){
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少单位必要字段");
		    return resultEntity;
		}
		if( StringUtils.isBlank(output.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少数字值必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.addOutput(output);
		return resultEntity;
	}

	@RequestMapping(value = "/updateOutout", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改出场技术参数信息", notes = "修改出场技术参数信息")
	public ResultEntity updateOutout(@RequestBody OutputParameters output) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.updateOutout =====OutputParameters:"+  output );
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(output.getParameterCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数编码必要字段");
		    return resultEntity;
		} 
        if( StringUtils.isBlank(output.getParameterName())) {
        	resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少技术参数名称必要字段");
		    return resultEntity;
        }
		if( StringUtils.isBlank(output.getType())) {
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少数据类型必要字段");
		    return resultEntity;
		} 
		if(	StringUtils.isBlank(output.getCompany())){
			resultEntity.setCode(ErrorCode.ERROR);
		    resultEntity.setMsg("缺少单位必要字段");
		    return resultEntity;
		}
		if( StringUtils.isBlank(output.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少数字值必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.updateOutput(output);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteOutout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除出场技术参数信息", notes = "批量删除出场技术参数信息")
	public ResultEntity deleteOutout(@RequestParam(required=true) List<String> outputIds) {
		
		logger.info("===== 设备-出场运行技术参数OutputRunController.deleteOutout =====outputIds:"+  outputIds );
		
		ResultEntity resultEntity = new ResultEntity();
		if (outputIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = outputRunService.deleteOutput(outputIds);
		return resultEntity;
	}
	
	 //查询运行技术参数详情
    public PageResultEntity findRunById(@RequestParam(required=true) String  runId) {
    	PageResultEntity resultEntity = new PageResultEntity();
    	resultEntity = outputRunService.findOutputById(runId);
		return resultEntity;
	}
    
    //查询出场技术参数详情
    public PageResultEntity findOutputById(@RequestParam(required=true)String  outputId) {
    	PageResultEntity resultEntity = new PageResultEntity();
    	resultEntity = outputRunService.findOutputById(outputId);
		return resultEntity;
	}
}
