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
import org.springframework.web.multipart.MultipartFile;

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
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.WorkTaskExample;
import com.qz.zframe.run.entity.WorkTaskExample.Criteria;
import com.qz.zframe.run.entity.submit.WorkTaskSubmit;
import com.qz.zframe.run.service.WorkClassificationService;
import com.qz.zframe.run.service.WorkTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * <p>Title: WorkTaskController</p>
 * <p>@Description: 工作任务Controller层 </p>
 * @author 
 * @date 2018年11月12日 下午4:10:26
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/WorkTask")
@Api(tags = "api-support-api-support-WorkTask", description = "运行-运行管理-定期工作-工作任务")
public class WorkTaskController {
	
	@Autowired
	private WorkTaskService workTaskService;
	
	@Autowired
	private WorkClassificationService workClassificationService;
	
	@Autowired
	private CurrentUserService currentUserService;
	
	@Autowired
	private IscUserService iscUserService;
	
//	@Autowired
//	private CommonService commonService;
	
	/*********************有文件上传操作---统一调用*************************
	 * @Description:保存信息
	 * @param: @param workTask
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveWorkTask",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="保存工作任务信息",value="保存工作任务信息")
	public ResultEntity saveWorkTask( WorkTaskSubmit workTaskSubmit){

		ResultEntity resultEntity = new ResultEntity();
		
		//得到工作任务对象
		WorkTask workTask = workTaskSubmit.getWorkTask();
		
		//得到文件对象
		//MultipartFile multipartFile = workTaskSubmit.getMultipartFile();
		
		
		//检查字段
		if(StringUtils.isBlank(workTask.getClassificationId())
				||StringUtils.isBlank(workTask.getWindId())
				||StringUtils.isBlank(workTask.getDepart())
				||StringUtils.isBlank(workTask.getUserId())
				||StringUtils.isBlank(workTask.getWorkName())
				||StringUtils.isBlank(workTask.getStartTime().toLocaleString())
				||StringUtils.isBlank(workTask.getRateTime())
				||StringUtils.isBlank(workTask.getLeadTime()+"")
				||StringUtils.isBlank(workTask.getExecutionTime()+"")
				||StringUtils.isBlank(workTask.getStatus())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		//字段正常：
		
		//对文件进行提交
		/*
		try {
			//上传文件
			SpFileUpload spFileUpload = commonService.fileUpload(multipartFile, null);
			//获取文件id
			String fileId = spFileUpload.getFileId();
			workTask.setFileId(fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//负责人相关：我有两个字段：分别为：负责人id，负责人名称：根据你提交给我的内容进行修改
		//这里使用默认值
		//		workTask.setUserId("ccc");
		//		workTask.setUsername("");
		IscUser user = iscUserService.getUser(workTask.getUserId(), null);
		workTask.setUsername(user.getUserName());
		
		
		/**************************************/
							//设置创建人：创建人为通过分类id，获取创建人填入：使用默认的创建人//应该是错误的理解
		//创建人应该是当前操作的人员：currentUserService
		workTask.setCreateUser(currentUserService.getUsername());
		/**************************************/
		
		
		//执行插入
		resultEntity = workTaskService.saveWorkTask(workTask);
		
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:模糊查询
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value="/listWorkTask",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="加载首页数据",value="加载首页数据")
	public PageResultEntity listWorkTask(@RequestParam(required = false) @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="depart",value="负责部门") String depart,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false) @ApiParam(name="startTime",value="创建时间--始") String startTime,
			@RequestParam(required = false) @ApiParam(name="endTime",value="创建时间--终") String endTime,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
			
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		WorkTaskExample example = new WorkTaskExample();
		//限定的需要用同一个criteria
		Criteria criteria = example.createCriteria();
		//如果负责部门选择了
		if(StringUtils.isNotBlank(depart)){
			criteria.andDepartEqualTo(depart);
		}

		//如果选中了状态
		if(StringUtils.isNotBlank(status)){
			criteria.andStatusEqualTo(status);
		}

		//如果选取了创建时间范围
		if(StringUtils.isNotBlank(startTime)){
			if(StringUtils.isBlank(endTime)){
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("请选取一个时间段");
				return pageResultEntity;
			}
			//如果选择了正确的时间段
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startTimeDate = null;
			Date endTimeDate = null;
			try {
				startTimeDate = format.parse(startTime);
				endTimeDate = format.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			criteria.andCreateTimeGreaterThanOrEqualTo(startTimeDate);
			criteria.andCreateTimeLessThanOrEqualTo(endTimeDate);
		}
		
		//如果关键字不为空
		if(StringUtils.isNotBlank(searchKey)){
			//可以是任务名称模糊查询
			example.or().andWorkNameLike(searchKey);
			//可以是任务内容/工作描述
			example.or().andWorkDescribeLike(searchKey);
			//可以是负责人
			example.or().andUsernameLike(searchKey);
			//可以是创建人
			example.or().andCreateUserLike(searchKey);
		}
		
		//设置分页
		PageHelper.startPage(pageNum, pageSize);
		//执行查询
		List<WorkTask> list = workTaskService.listWorkTask(example);
		
		PageInfo<WorkTask> pageInfo = new PageInfo<WorkTask>(list);
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
		
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false) @ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="depart",value="负责部门") String depart,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false) @ApiParam(name="startTime",value="创建时间--始") String startTime,
			@RequestParam(required = false) @ApiParam(name="endTime",value="创建时间--终") String endTime,
			HttpServletResponse response) {
		
		
		WorkTaskExample example = new WorkTaskExample();
		//限定的需要用同一个criteria
		Criteria criteria = example.createCriteria();
		//如果负责部门选择了
		if(StringUtils.isNotBlank(depart)){
			criteria.andDepartEqualTo(depart);
		}

		//如果选中了状态
		if(StringUtils.isNotBlank(status)){
			criteria.andStatusEqualTo(status);
		}

		//如果选取了创建时间范围
		if(StringUtils.isNotBlank(startTime)){
			if(StringUtils.isBlank(endTime)){
				
				
			}
			//如果选择了正确的时间段
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date startTimeDate = null;
			Date endTimeDate = null;
			try {
				startTimeDate = format.parse(startTime);
				endTimeDate = format.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			criteria.andCreateTimeGreaterThanOrEqualTo(startTimeDate);
			criteria.andCreateTimeLessThanOrEqualTo(endTimeDate);
		}
		
		//如果关键字不为空
		if(StringUtils.isNotBlank(searchKey)){
			//可以是任务名称模糊查询
			example.or().andWorkNameLike(searchKey);
			//可以是任务内容/工作描述
			example.or().andWorkDescribeLike(searchKey);
			//可以是负责人
			example.or().andUsernameLike(searchKey);
			//可以是创建人
			example.or().andCreateUserLike(searchKey);
		}
		
		//执行查询
		List<WorkTask> list = workTaskService.listWorkTask(example);
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("serialNum", "计划编号");
		testMap.put("workName", "工作名称");
		testMap.put("workDescribe", "工作描述");
		testMap.put("depart", "负责班组");
		testMap.put("username", "负责人");
		testMap.put("address", "位置");
		testMap.put("unit", "机组");
		testMap.put("rateTime", "工作周期");
		testMap.put("createUser", "创建人");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "工作任务", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************************* 点击编辑：获取对应信息 ***************************/
	@RequestMapping(value = "/getWorkTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "点击编辑：获取对应信息 ", notes = "点击编辑：获取对应信息")
	public ResultEntity getWorkTask(@RequestParam @ApiParam(name="workTaskId",value="勾选的workTaskId") String workTaskId) {

		ResultEntity resultEntity = new ResultEntity();

		if (StringUtils.isEmpty(workTaskId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}

		// 封装查询条件
		WorkTaskExample example = new WorkTaskExample();
		example.createCriteria().andWorkTaskIdEqualTo(workTaskId);
		// 执行查询
		List<WorkTask> list = workTaskService.listWorkTask(example);

		WorkTask workTask = null;
		if (list != null && list.size() > 0) {
			workTask = list.get(0);
		}

		if (workTask != null) {
			/***********/
			//获取文件id:文件回显
			String fileId = workTask.getFileId();
			//如果存在文件
			if(StringUtils.isNotBlank(fileId)){
			}
			/***********/
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(workTask);
			return resultEntity;
		}

		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
	}

	
	
	
	/************************* 点击查看：获取对应信息 ***************************/
	@RequestMapping(value = "/viewWorkTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "点击查看：获取对应信息 ", notes = "点击查看：获取对应信息")
	public ResultEntity viewWorkTask(@RequestParam @ApiParam(name="workTaskId",value="勾选的workTaskId") String workTaskId) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		if (StringUtils.isEmpty(workTaskId)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		// 封装查询条件
		WorkTaskExample example = new WorkTaskExample();
		example.createCriteria().andWorkTaskIdEqualTo(workTaskId);
		// 执行查询
		List<WorkTask> list = workTaskService.listWorkTask(example);
		
		WorkTask workTask = null;
		if (list != null && list.size() > 0) {
			workTask = list.get(0);
		}
		
		if (workTask != null) {
			/***********/
			//获取文件id:文件回显
			String fileId = workTask.getFileId();
			//如果存在文件
			if(StringUtils.isNotBlank(fileId)){
			}
			/***********/
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			resultEntity.setData(workTask);
			return resultEntity;
		}
		
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:更新
	 * @param: @param workTask
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/editWorkTask", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "更新任务表", value = "更新任务表")
	public ResultEntity editWorkTask(@RequestBody WorkTask workTask){

		ResultEntity resultEntity = new ResultEntity();
		
		//检查各字段是否完整
		if(StringUtils.isBlank(workTask.getSerialNum())
				||StringUtils.isBlank(workTask.getWorkName())
				||StringUtils.isBlank(workTask.getDepart())
				||StringUtils.isBlank(workTask.getUsername())
				||StringUtils.isBlank(workTask.getCreateUser())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//字段完整
		workTaskService.updateWorkTask(workTask);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:批量删除
	 * @param: @param workTaskIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/removeWorkTask", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="批量删除 ", notes="批量删除 ")
	public ResultEntity removeWorkTask(@RequestParam @ApiParam(name="workTaskIds",value="勾选的workTaskIds") List<String> workTaskIds){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果集合不为空
		if(CollectionUtils.isNotEmpty(workTaskIds)){
			//循环进行删除
			for (String workTaskId : workTaskIds) {
				workTaskService.deleteWorkTask(workTaskId);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			return resultEntity;
		}else{
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			return resultEntity;
		}
	}
	
	
	
	
	
	
	
	
	/**********************************选择任务分类：自动带出任务属性******************************************/
	@RequestMapping(value="/getClassificationName",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="选择任务分类：自动带出任务属性",value="选择任务分类：自动带出任务属性")
	public ResultEntity getClassificationName(@RequestParam @ApiParam(name="classificationId",value="工作分类id") String classificationId){
		
		ResultEntity resultEntity = new ResultEntity();

		WorkClassificationExample example = new WorkClassificationExample();
		example.createCriteria().andClassificationIdEqualTo(classificationId);
		
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);
		
		if(list != null && list.size()>0){
			WorkClassification workClassification = list.get(0);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(workClassification);
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("未找到");
		return resultEntity;
	}
	
	
	
	
	
	
	
	
	
}
