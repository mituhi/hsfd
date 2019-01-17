package com.qz.zframe.run.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyLogTabExample;
import com.qz.zframe.run.service.DutyLogTabService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: DutyLogTabController</p>
 * <p>@Description: 值班日志TAB表controller类 </p>
 * @author 
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

		if (StringUtils.isBlank(dutyLogTab.getTabName())) {
			resultEntity.setMsg("名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(dutyLogTab.getUrl())) {
			resultEntity.setMsg("url不能为空");
			return resultEntity;
		}
		
		//如果字段都正常：执行插入操作
		resultEntity = dutyLogTabService.saveDutyLogTab(dutyLogTab);
		return resultEntity;
	}
	
	
	/**
	 * @Description:模糊查询
	 * @param: @param dutyLogTab
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listDutyLogTab", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "值班日志TAB表信息列表查询", value = "模糊查询值班日志TAB表")
	public PageResultEntity listDutyLogTab(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		DutyLogTabExample example = new DutyLogTabExample();
		example.setOrderByClause("tab_code");
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andTabCodeLike(searchKey);
			example.or().andTabNameLike(searchKey);
			example.or().andUrlLike(searchKey);
		}
		
		
		//执行查询
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example,pageNum,pageSize);
		
		//设置返回结果
		PageInfo<DutyLogTab> pageInfo = new PageInfo<DutyLogTab>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());

		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("查询成功");
		return pageResultEntity;
	}
	
	
	/*@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")*/
	public void toExcel(@RequestParam(required = false)  @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			HttpServletResponse response) {
		
		DutyLogTabExample example = new DutyLogTabExample();
		
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andTabCodeLike(searchKey);
			example.or().andTabNameLike(searchKey);
			example.or().andUrlLike(searchKey);
		}
		
		
		//执行查询
		List<DutyLogTab> list = dutyLogTabService.listDutyLogTab(example,0,0);
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("tabCode", "编码");
		testMap.put("tabName", "名称");
		testMap.put("url", "URL链接");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "值班日志TAB表", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/**
	 * @Description:批量更新值班日志TAB表
	 * @param: @param dutyLogTabs：必填字段：所有字段均需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editDutyLogTab", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "修改日志TAB表", value = "修改值班日志TAB表")
	public ResultEntity editDutyLogTab(@RequestBody @ApiParam(name="dutyLogTab",value="值班日志TAB表") DutyLogTab dutyLogTab){
		
		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(dutyLogTab.getTabId())) {
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(dutyLogTab.getTabCode())) {
			resultEntity.setMsg("编码不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(dutyLogTab.getTabName())) {
			resultEntity.setMsg("名称不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(dutyLogTab.getUrl())) {
			resultEntity.setMsg("url不能为空");
			return resultEntity;
		}

		return dutyLogTabService.editDutyLogTabById(dutyLogTab);
	}
	
	
	
	
	/**
	 * @Description:批量删除值班日志TAB表
	 * @param: @param tabIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeDutyLogTab", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "删除值班日志TAB表", value = "删除值班日志TAB表")
	public ResultEntity removeDutyLogTab(@RequestParam @ApiParam(name="tabIds",value="值班日志TAB表ids") List<String> tabIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(CollectionUtils.isEmpty(tabIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("ids不能为空");
			return resultEntity;
		}

		dutyLogTabService.removeDutyLogTabById(tabIds);

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}
	

	@RequestMapping(value="/getDutyLogTab" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="详情查询 ", notes="详情查询")
	public ResultEntity getDutyLogTab(@RequestParam @ApiParam(name="tabId",value="值班日志TAB表id") String tabId){

		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(tabId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
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
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setData(dutyLogTab);
		return resultEntity;
	}

}
