package com.qz.zframe.run.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ObjectIsBlankUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;
import com.qz.zframe.run.service.DutyLogTabService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: DutyLogTabController</p>
 * <p>@Description: 值班日志TAB表controller类 </p>
 * @author 陈汇奇
 * @date 2018年11月6日 下午1:44:46
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/DutyLogTab")
@Api(tags = "api-support-api-support-DutyLogTab", description = "运行-日志管理-配置-值班日志TAB配置")
public class DutyLogTabController {

	@Autowired
	private DutyLogTabService dutyLogTabService;
	
	
	/**
	 * @Description:值班日志TAB表信息添加
	 * @param: @param dutyLogTab: 出了id其他字段都需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveDutyLogTab", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班日志TAB表信息添加", value = "值班日志TAB表信息添加")
	public ResultEntity saveDutyLogTab(@RequestBody DutyLogTab dutyLogTab) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//判断字段是否为空
		if(StringUtils.isBlank(dutyLogTab.getTabCode())
				||StringUtils.isBlank(dutyLogTab.getTabName())
				||StringUtils.isBlank(dutyLogTab.getUrl())){
			//如果字段为空，返回错误信息
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//如果字段都正常：执行插入操作
		resultEntity = dutyLogTabService.saveDutyLogTab(dutyLogTab);
		return resultEntity;
	}
	
	
	/**
	 * @Description:模糊查询
	 * @param: @param dutyLogTab
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDutyLogTab", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班日志TAB表信息列表", value = "模糊查询值班日志TAB表")
	public PageResultEntity listDutyLogTab(@RequestParam(required = false) String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DutyLogTabExample example = new DutyLogTabExample();
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andTabCodeLike(searchKey);
			example.or().andTabNameLike(searchKey);
			example.or().andUrlLike(searchKey);
		}
		
		
		//执行查询
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example,pageNo,pageSize);
		
		//设置返回结果
		PageInfo<DutyLogTab> pageInfo = new PageInfo<DutyLogTab>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	/**
	 * @Description:批量更新值班日志TAB表
	 * @param: @param dutyLogTabs：必填字段：所有字段均需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDutyLogTab", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "批量更新值班日志TAB表", value = "批量更新值班日志TAB表")
	public ResultEntity editDutyLogTab(@RequestBody List<DutyLogTab> dutyLogTabs){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//查看集合是否为空
		if(CollectionUtils.isEmpty(dutyLogTabs)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//查看字段值是否完整
		for (DutyLogTab dutyLogTab : dutyLogTabs) {
			try {
				boolean falg = ObjectIsBlankUtil.isExistFieldBlank(dutyLogTab);
				if (falg) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("缺少字段");
					return resultEntity;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//数据准备就绪
		//循环根据主键进行更新操作
		for (DutyLogTab dutyLogTab : dutyLogTabs) {
			dutyLogTabService.editDutyLogTabById(dutyLogTab);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	
	
	/**
	 * @Description:批量删除值班日志TAB表
	 * @param: @param tabIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeDutyLogTab", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除值班日志TAB表", value = "删除值班日志TAB表")
	public ResultEntity removeDutyLogTab(@RequestParam List<String> tabIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isEmpty(tabIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		for (String tabId : tabIds) {
			dutyLogTabService.removeDutyLogTabById(tabId);
		}
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getDutyLogTab" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getDutyLogTab(@RequestParam String tabId){

		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(tabId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//封装查询条件
		DutyLogTabExample example = new DutyLogTabExample();
		example.createCriteria().andTabIdEqualTo(tabId);
		//执行查询
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example, 0, 0);
		
		DutyLogTab dutyLogTab = null;
		if(list!=null && list.size() > 0 ){
			dutyLogTab = list.get(0);
		}
		
		if(dutyLogTab != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(dutyLogTab);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
