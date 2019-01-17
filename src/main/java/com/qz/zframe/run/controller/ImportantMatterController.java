package com.qz.zframe.run.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.ImportantMatter;
import com.qz.zframe.run.entity.ImportantMatterExample;
import com.qz.zframe.run.entity.ImportantMatterExample.Criteria;
import com.qz.zframe.run.service.ImportantMatterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: ImportantMatterController</p>
 * <p>@Description: 重要事项Controller层 </p>
 * @author 
 * @date 2018年11月7日 下午5:09:15
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/ImportantMatter")
@Api(tags = "api-support-api-support-ImportantMatter", description = "运行-日志管理-配置-重要事项登记配置")
public class ImportantMatterController {

	@Autowired
	private ImportantMatterService importantMatterService;
	
	
	/**
	 * @Description：保存
	 * @param: @param importantMatter
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveImportantMatter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "保存重要事务记录表", value = "保存重要事务记录表")
	public ResultEntity saveImportantMatter(@RequestBody ImportantMatter importantMatter){
		
		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(importantMatter.getWindCode())) {
			resultEntity.setMsg("风电场不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(importantMatter.getLogTypeId())) {
			resultEntity.setMsg("日志类型不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(importantMatter.getImportantMatter())) {
			resultEntity.setMsg("重要事项不能为空");
			return resultEntity;
		}
		
		//字段正常执行保存操作
		importantMatterService.saveImportantMatter(importantMatter);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("信息已保存");
		return resultEntity;
	}

	@RequestMapping(value = "/updateImportantMatter", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "修改重要事务记录表", value = "修改重要事务记录表")
	public ResultEntity updateImportantMatter(@RequestBody ImportantMatter importantMatter){

		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isBlank(importantMatter.getMatterId())) {
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(importantMatter.getWindCode())) {
			resultEntity.setMsg("风电场不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(importantMatter.getLogTypeId())) {
			resultEntity.setMsg("日志类型不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(importantMatter.getImportantMatter())) {
			resultEntity.setMsg("重要事项不能为空");
			return resultEntity;
		}

		//字段正常执行保存操作
		importantMatterService.editImportantMatterById(importantMatter);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
	}
	
	

	@RequestMapping(value = "/listImportantMatter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "列表查询", value = "列表查询")
	public PageResultEntity listImportantMatter(@RequestParam(required=false)@ApiParam(name="departments",value="风电场") List<String> departments,
			@RequestParam(required=false)@ApiParam(name="seachKey",value="关键字查询") String seachKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		ImportantMatterExample example = new ImportantMatterExample();
		
		PageHelper.startPage(pageNum, pageSize);
		List<ImportantMatter> list = importantMatterService.listImportantMatter(example);
		PageInfo<ImportantMatter> pageInfo = new PageInfo<ImportantMatter>(list);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("查询成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
	
	
	
	/*@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")*/
	public void toExcel(@RequestParam(required=false)@ApiParam(name="departments",value="风电场") List<String> departments,
			@RequestParam(required=false)@ApiParam(name="seachKey",value="关键字查询") String seachKey,
			HttpServletResponse response) {
		
		ImportantMatterExample example = new ImportantMatterExample();
		
		Criteria criteria = example.createCriteria();
		//选择了部门/风电场
		if(CollectionUtils.isNotEmpty((departments))){
			for (String department : departments) {
				criteria.andWindCodeEqualTo(department);
			}
		}
		
		List<ImportantMatter> list = importantMatterService.listImportantMatter(example);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//使用日志类型id作为修改时间的字段：（不需要增加字段导出Excel）
		for (ImportantMatter importantMatter : list) {
			importantMatter.setLogTypeId(format.format(importantMatter.getUpdateTime()));
		}
		
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("department", "风电场名称");
		testMap.put("logType", "日志类型");
		testMap.put("logName", "日志名称");
		testMap.put("importantMatter", "重要事项");
		testMap.put("logTypeId", "修改时间");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "重要事项登记", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:勾选id批量删除
	 * @param: @param logTypeIds   需要的字段：勾选的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeImportantMatter", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removeImportantMatter(@RequestParam @ApiParam(name="matterIds",value="勾选的ids") List<String> matterIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果为空
		if(CollectionUtils.isEmpty(matterIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("ids不能为空");
			return resultEntity;
		}
		
		//正常进行删除
		importantMatterService.removeImportantMatterByIds(matterIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;
	}
	
	@RequestMapping(value="/getImportantMatter" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="详情查询 ", notes="详情查询")
	public ResultEntity getImportantMatter(@RequestParam @ApiParam(name="matterId",value="matterId") String matterId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(matterId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}
		
		//封装查询条件
		ImportantMatterExample example = new ImportantMatterExample();
		example.createCriteria().andMatterIdEqualTo(matterId);
		//执行查询
		List<ImportantMatter> list = importantMatterService.listImportantMatter(example);
		
		ImportantMatter importantMatter = null;
		if(list!=null && list.size() > 0 ){
			importantMatter = list.get(0);
		}
		
		if(importantMatter != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("查询成功");
			resultEntity.setData(importantMatter);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
	}

}
