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
import com.qz.zframe.device.entity.Components;
import com.qz.zframe.device.entity.ComponentsExample;
import com.qz.zframe.device.entity.ComponentsExample.Criteria;
import com.qz.zframe.device.service.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/support/device/components")
@Api(tags = {"api-support-device-components"}, description = "设备-设备部件")
public class ComponentsController {
	
	private static Logger logger = LoggerFactory.getLogger(ComponentsController.class);
	
	
	@Autowired
	private  ComponentService componentService;
	
	@RequestMapping(value = "/findComponent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = " 获取设备部件信息", notes = " 获取设备部件信息")
	public PageResultEntity findComponent(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(required = false)
    @ApiParam(name="componentName",value="设备部件名称",required=false)String componentName) {
		
		logger.info("===== 设备-设备部件ComponentsController.findComponent ===== ");
		
		PageResultEntity resultEntity = new PageResultEntity();
		ComponentsExample componentsExample = new ComponentsExample();
		componentsExample.setPageSize(pageSize);
		componentsExample.setPageNo(pageNum);
		Criteria criteria =componentsExample.createCriteria();
		if (StringUtils.isNotBlank(componentName) ){
			criteria.andComponentNameLike(componentName);
		}
		resultEntity = componentService.findComponent(componentsExample);
		return resultEntity;
	}
	
	@RequestMapping(value = "/addComponent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "新增设备部件信息", notes = "新增设备部件信息")
	public ResultEntity addComponent(@RequestBody Components components) {
		
		logger.info("===== 设备-设备部件ComponentsController.addComponent =====Components:"+ components );
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(components.getCompany())) {
			
		} 
		if( StringUtils.isBlank(components.getComponentCode())) {
			}
				
		if( StringUtils.isBlank(components.getComponentName())) {
					
				} 
		if( StringUtils.isBlank(components.getSpecificationModel())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;	 
			
		}
		resultEntity = componentService.addComponent(components);
		return resultEntity;
	}

	@RequestMapping(value = "/updateComponent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "修改运行技术参数信息", notes = "修改运行技术参数信息")
	public ResultEntity updateComponent(@RequestBody Components components) {
		
		logger.info("===== 设备-设备部件ComponentsController.updateComponent =====Components:"+ components );
		
		ResultEntity resultEntity = new ResultEntity();
		if (StringUtils.isBlank(components.getCompany()) || StringUtils.isBlank(components.getComponentCode())
		|| StringUtils.isBlank(components.getComponentName()) || StringUtils.isBlank(components.getSpecificationModel())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少必要字段");
			return resultEntity;
		}
		resultEntity = componentService.updateComponent(components);
		return resultEntity;
	}

	@RequestMapping(value = "/deleteComponent", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除运行技术参数信息", notes = "批量删除运行技术参数信息")
	public ResultEntity deleteComponent(@RequestParam(required = true) List<String> componentIds) {
		
		logger.info("===== 设备-设备部件ComponentsController.deleteComponent =====componentIds:"+ componentIds );
		
		ResultEntity resultEntity = new ResultEntity();
		if (componentIds == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中删除的数据");
			return resultEntity;
		}
		resultEntity = componentService.deleteComponent(componentIds);
		return resultEntity;
	}
	
	//查询设备部件的详情
		public PageResultEntity findById(String componentId) {
			PageResultEntity resultEntity = new PageResultEntity();
			resultEntity=componentService.findById(componentId);
		   return resultEntity;
	}
}
