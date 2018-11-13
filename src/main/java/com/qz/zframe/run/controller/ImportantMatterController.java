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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.ImportantMatter;
import com.qz.zframe.run.entity.ImportantMatterExample;
import com.qz.zframe.run.entity.ImportantMatterExample.Criteria;
import com.qz.zframe.run.entity.LogType;
import com.qz.zframe.run.entity.LogTypeExample;
import com.qz.zframe.run.service.ImportantMatterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: ImportantMatterController</p>
 * <p>@Description: 重要事项Controller层 </p>
 * @author 陈汇奇
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
		
		//检查字段
		if(StringUtils.isBlank(importantMatter.getDepartment())
				||StringUtils.isBlank(importantMatter.getLogName())
				||StringUtils.isBlank(importantMatter.getLogType())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//字段正常执行保存操作
		importantMatterService.saveImportantMatter(importantMatter);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	

	@RequestMapping(value = "/listImportantMatter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "重要事项登记首页信息", value = "重要事项登记首页信息")
	public PageResultEntity listImportantMatter(@RequestParam(required=false) List<String> departments,
			@RequestParam(required=false) String seachKey,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		ImportantMatterExample example = new ImportantMatterExample();
		
		Criteria criteria = example.createCriteria();
		//选择了部门/风电场
		if(CollectionUtils.isNotEmpty((departments))){
			for (String department : departments) {
				criteria.andDepartmentEqualTo(department);
			}
		}

		//选择了模糊查询
		if(StringUtils.isNotBlank(seachKey)){
			//可以是日志类型
			example.or().andLogTypeLike(seachKey);
			
			//可以使日志名称
			example.or().andLogNameLike(seachKey);
			
			//可以是重要事项
			example.or().andImportantMatterLike(seachKey);
			
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<ImportantMatter> list = importantMatterService.listImportantMatter(example);
		PageInfo<ImportantMatter> pageInfo = new PageInfo<ImportantMatter>(list);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
	
	
	/**
	 * @Description:勾选id批量删除
	 * @param: @param logTypeIds   需要的字段：勾选的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeImportantMatter", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removeImportantMatter(@RequestParam List<String> matterIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果为空
		if(CollectionUtils.isEmpty(matterIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//正常进行删除
		importantMatterService.removeImportantMatterByIds(matterIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:批量更新
	 * @param: @param ImportantMatter
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editImportantMatter", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新重要事务表", value = "更新重要事务表")
	public ResultEntity editImportantMatter(@RequestBody List<ImportantMatter> importantMatters){
		
		ResultEntity resultEntity = new ResultEntity();
		
		for (ImportantMatter importantMatter : importantMatters) {
			importantMatterService.editImportantMatterById(importantMatter);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getImportantMatter" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getImportantMatter(@RequestParam String matterIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		if(StringUtils.isBlank(matterIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//封装查询条件
		ImportantMatterExample example = new ImportantMatterExample();
		example.createCriteria().andMatterIdEqualTo(matterIds);
		//执行查询
		List<ImportantMatter> list = importantMatterService.listImportantMatter(example);
		
		ImportantMatter importantMatter = null;
		if(list!=null && list.size() > 0 ){
			importantMatter = list.get(0);
		}
		
		if(importantMatter != null){
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(importantMatter);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
