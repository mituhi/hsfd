package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.isc.domain.IscUser;
import com.qz.zframe.isc.service.IscUserService;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;
import com.qz.zframe.run.entity.WorkClassificationExample.Criteria;
import com.qz.zframe.run.service.WorkClassificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: WorkClassificationController</p>
 * <p>@Description: 工作分类controller层 </p>
 * @author 
 * @date 2018年11月12日 上午11:38:24
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/WorkClassification")
@Api(tags = "api-support-api-support-WorkClassification", description = "运行-运行管理-定期工作-工作分类")
public class WorkClassificationController {

	@Autowired
	private WorkClassificationService workClassificationService;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private IscUserService iscUserService;
	
	/**
	 * @Description:
	 * @param: @param workClassification：保存工作分类信息
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveWorkClassification",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="保存工作分类信息",value="保存工作分类信息")
	public ResultEntity saveWorkClassification(@RequestBody WorkClassification workClassification ){
		
		ResultEntity resultEntity = new ResultEntity();

		if ("02".equals(workClassification.getIsTop())) {
			if (StringUtils.isBlank(workClassification.getSuperiorClassificationId())) {
				resultEntity.setMsg("上级分类编码不能为空");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(workClassification.getClassificationName())) {
			resultEntity.setMsg("定期工作分类不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(workClassification.getStatus())) {
			resultEntity.setMsg("状态不能为空");
			return resultEntity;
		}

		return workClassificationService.saveWorkClassification(workClassification);
	}
	
	
	
	/**
	 * @Description:模糊查询
	 * @param: @param searchKey
	 * @param: @param classificationName
	 * @param: @param status
	 * @param: @param createTime
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listWorkClassification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "列表查询", value = "列表查询")
	public PageResultEntity listWorkClassification(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="classificationName",value="分类名称") String classificationName,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false) @ApiParam(name="taskProperties",value="任务属性") String taskProperties,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
			
		
		WorkClassificationExample example = new WorkClassificationExample();
		
		Criteria criteria = example.createCriteria();
		//如果选择了关键字查询
		if(StringUtils.isNotBlank(searchKey)){
			criteria.andTaskPropertiesLike(searchKey);
		}

		//如果选择了分类名称
		if(StringUtils.isNotBlank(classificationName)){
			criteria.andClassificationNameLike("%"+classificationName+"%");
		}

		//如果选择了任务属性
		if(StringUtils.isNotBlank(taskProperties)){
			criteria.andTaskPropertiesEqualTo(taskProperties);
		}

		//如果选择了状态
		if(StringUtils.isNotBlank(status)){
			criteria.andStatusEqualTo(status);
		}
		
		PageHelper.startPage(pageNum, pageSize);
		//执行查询
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);
		PageInfo<WorkClassification> pageInfo = new PageInfo<WorkClassification>(list);
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("查询成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}

	/**
	 *查询启用的定期工作分类列表
	 */
	@RequestMapping(value = "/enableListWorkClassification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "列表查询启用的定期工作分类", value = "列表查询启用的定期工作分类")
	public ResultEntity enableListWorkClassification(){
		ResultEntity resultEntity = new ResultEntity();

		WorkClassificationExample example = new WorkClassificationExample();
		example.createCriteria().andStatusEqualTo("01");
		//执行查询
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);

		resultEntity.setData(list);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		return resultEntity;
	}
	
	@RequestMapping(value="/getWorkClassification" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="详情查询 ", notes="详情查询")
	public ResultEntity getWorkClassification(@RequestParam @ApiParam(name="classificationId",value="勾选的classificationId") String classificationId){

		ResultEntity resultEntity = new ResultEntity();

		if(StringUtils.isNotBlank(classificationId)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}

		//封装查询条件
		WorkClassificationExample example = new WorkClassificationExample();
		example.createCriteria().andClassificationIdEqualTo(classificationId);
		//执行查询
		 List<WorkClassification> list = workClassificationService.listWorkClassification(example);

		 WorkClassification workClassification = null;
		if(list!=null && list.size() > 0 ){
			workClassification = list.get(0);
		}

		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setData(workClassification);
		return resultEntity;
	}
	
	/**
	 * @Description:批量删除
	 * @param: @param classificationIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeWorkClassification", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量删除 ", notes = "批量删除 ")
	public ResultEntity removeWorkClassification(@RequestParam @ApiParam(name="classificationIds",value="勾选的classificationIds") List<String> classificationIds) {
		
		ResultEntity resultEntity = new ResultEntity();

		if(CollectionUtils.isEmpty(classificationIds)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("ids不能为空");
			return resultEntity;
		}
		
		workClassificationService.deleteWorkClassificationById(classificationIds);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("删除成功");
		return resultEntity;

	}
	
	
	/**
	 * @Description:更新工作分类表
	 * @param: @param workClassification
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editWorkClassification", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新工作分类表", value = "更新工作分类表")
	public ResultEntity editWorkClassification(@RequestBody WorkClassification workClassification){
		
		ResultEntity resultEntity = new ResultEntity();

		if(StringUtils.isBlank(workClassification.getClassificationId())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("id不能为空");
			return resultEntity;
		}
		if ("02".equals(workClassification.getIsTop())) {
			if (StringUtils.isBlank(workClassification.getSuperiorClassificationId())) {
				resultEntity.setMsg("上级分类编码不能为空");
				return resultEntity;
			}
		}
		if (StringUtils.isBlank(workClassification.getClassificationName())) {
			resultEntity.setMsg("定期工作分类不能为空");
			return resultEntity;
		}
		if (StringUtils.isBlank(workClassification.getStatus())) {
			resultEntity.setMsg("状态不能为空");
			return resultEntity;
		}
		
		//字段正常
		workClassificationService.editWorkClassification(workClassification);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("修改成功");
		return resultEntity;
	}

	/*@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")*/
	public void toExcel(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
						@RequestParam(required = false) @ApiParam(name="classificationName",value="分类名称") String classificationName,
						@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
						@RequestParam(required = false) @ApiParam(name="createTime",value="创建时间") String createTime,
						HttpServletResponse response) {

		WorkClassificationExample example = new WorkClassificationExample();

		Criteria criteria = example.createCriteria();
		//如果选择了关键字查询
		if(StringUtils.isNotBlank(searchKey)){
			criteria.andTaskPropertiesLike(searchKey);
		}

		//如果选择了分类名称
		if(StringUtils.isNotBlank(classificationName)){
			criteria.andClassificationNameEqualTo(classificationName);
		}

		//如果选择了状态
		if(StringUtils.isNotBlank(status)){
			criteria.andStatusEqualTo(status);
		}

		//如果选择了创建时间
		if(StringUtils.isNotBlank(createTime)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			Date date = null;
			try {
				date = format.parse(createTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			criteria.andMaintainTimeEqualTo(date);
		}

		//执行查询
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		//使用工作分类表id作为创建时间（不新增字段作为Excel导出，对其他业务无影响）
		for (WorkClassification workClassification : list) {
			workClassification.setClassificationId(format.format(workClassification.getMaintainTime()));
			//将创建人的id设置为username
			String userId = workClassification.getMaintainer();
			IscUser user = iscUserService.getUser(userId, null);
			workClassification.setMaintainer(user.getUserName());
		}


		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("classificationCode", "分类编号");
		testMap.put("classificationName", "分类名称");
		testMap.put("taskProperties", "任务属性");
		testMap.put("status", "状态");
		testMap.put("userId", "创建人");
		testMap.put("classificationId", "创建时间");
		testMap.put("remark", "备注");


		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "工作分类", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
