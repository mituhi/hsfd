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
import com.qz.zframe.device.entity.OutputParameters;
import com.qz.zframe.device.entity.OutputParametersExample;
import com.qz.zframe.device.entity.RunParameters;
import com.qz.zframe.device.entity.RunParametersExample;
import com.qz.zframe.device.service.OutputRunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/support/device/outputRun")
@Api(tags = {"api-support-device-outputRun"}, description = "设备-出场运行技术参数")
public class OutputRunController {
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
	public PageResultEntity findRun(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		PageResultEntity resultEntity = new PageResultEntity();
		RunParametersExample runExample = new RunParametersExample();
		runExample.setPageSize(pageSize);
		runExample.setPageNo(pageNum);
		// Criteria criteria =runExample.createCriteria();
		resultEntity = outputRunService.findRun(runExample);
		return resultEntity;
	}

	/**
	 * 新增位置信息
	 */
	@RequestMapping(value = "/addRun", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增运行技术参数息", notes = "新增运行技术参数信息")
	public ResultEntity addRun(@RequestBody RunParameters run) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(run.getParameterCode()) || StringUtils.isBlank(run.getParameterName())
				|| StringUtils.isBlank(run.getType()) || StringUtils.isBlank(run.getCompany())
				|| StringUtils.isBlank(run.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.addRun(run);
		return resultEntity;
	}

	@RequestMapping(value = "/updateRun", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改运行技术参数信息", notes = "修改运行技术参数信息")
	public ResultEntity updateRun(@RequestBody RunParameters run) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(run.getParameterCode()) || StringUtils.isBlank(run.getParameterName())
				|| StringUtils.isBlank(run.getType()) || StringUtils.isBlank(run.getCompany())
				|| StringUtils.isBlank(run.getNumberValue()) || StringUtils.isBlank(run.getRunId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.updateRun(run);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteRun", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除运行技术参数信息", notes = "批量删除运行技术参数信息")
	public ResultEntity deleteRun(@RequestBody List<String> runIds) {
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
	public PageResultEntity findOutout(@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		PageResultEntity resultEntity = new PageResultEntity();
		OutputParametersExample outputExample = new OutputParametersExample();
		outputExample.setPageSize(pageSize);
		outputExample.setPageNo(pageNum);
		// com.qz.zframe.device.entity.OutputParametersExample.Criteria criteria
		// =outputExample.createCriteria();

		resultEntity = outputRunService.findOutout(outputExample);
		return resultEntity;
	}

	/**
	 * 新增位置信息
	 */
	@RequestMapping(value = "/addOutout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增出场技术参数信息", notes = "新增出场技术参数信息")
	public ResultEntity addOutout(@RequestBody OutputParameters output) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(output.getParameterCode()) || StringUtils.isBlank(output.getParameterName())
				|| StringUtils.isBlank(output.getType()) || StringUtils.isBlank(output.getCompany())
				|| StringUtils.isBlank(output.getNumberValue())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.addOutput(output);
		return resultEntity;
	}

	@RequestMapping(value = "/updateOutout", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改出场技术参数信息", notes = "修改出场技术参数信息")
	public ResultEntity updateOutout(@RequestBody OutputParameters output) {
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(output.getParameterCode()) || StringUtils.isBlank(output.getParameterName())
				|| StringUtils.isBlank(output.getType()) || StringUtils.isBlank(output.getCompany())
				|| StringUtils.isBlank(output.getNumberValue()) || StringUtils.isBlank(output.getOutputId())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = outputRunService.updateOutput(output);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteOutout", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除出场技术参数信息", notes = "批量删除出场技术参数信息")
	public ResultEntity deleteOutout(@RequestBody List<String> outputIds) {
		ResultEntity resultEntity = new ResultEntity();
		if (outputIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = outputRunService.deleteOutput(outputIds);
		return resultEntity;
	}
}
