package com.qz.zframe.run.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.BaseResultEntity;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.DeviceTypeExample;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.WorkTaskExample;
import com.qz.zframe.run.entity.WorkTaskExample.Criteria;
import com.qz.zframe.run.service.WorkClassificationService;
import com.qz.zframe.run.service.WorkTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * <p>Title: WorkTaskController</p>
 * <p>@Description: 工作任务Controller层 </p>
 * @author 陈汇奇
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
	
	/*********************有文件上传操作---统一调用*************************
	 * @Description:保存信息
	 * @param: @param workTask
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/saveWorkTask",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="保存工作任务信息",value="保存工作任务信息")
	public ResultEntity saveWorkTask(@RequestBody WorkTask workTask ){

		ResultEntity resultEntity = new ResultEntity();
		
		//检查字段
		if(StringUtils.isBlank(workTask.getClassificationId())
				||StringUtils.isBlank(workTask.getWindId())
				||StringUtils.isBlank(workTask.getDepart())
				||StringUtils.isBlank(workTask.getUserId())
				||StringUtils.isBlank(workTask.getWorkName())
				||StringUtils.isBlank(workTask.getStartTime().toLocaleString())
				||StringUtils.isBlank(workTask.getRateTime().toLocaleString())
				||StringUtils.isBlank(workTask.getLeadTime()+"")
				||StringUtils.isBlank(workTask.getExecutionTime()+"")
				||StringUtils.isBlank(workTask.getStatus())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		//字段正常：
		
		//设置用户名：接口未实现保留
		/**************************************/
		
		//设置创建人：因为未登录所以用默认数据
		//workTask.setCreateUser(currentUserService.getUsername());
		workTask.setCreateUser("chq");
		
		
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
	public PageResultEntity listWorkTask(@RequestParam(required = false) String searchKey,
			@RequestParam(required = false) String depart,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String startTime,
			@RequestParam(required = false) String endTime,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
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
				// TODO Auto-generated catch block
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
		PageHelper.startPage(pageNo, pageSize);
		//执行查询
		List<WorkTask> list = workTaskService.listWorkTask(example);
		
		PageInfo<WorkTask> pageInfo = new PageInfo<WorkTask>(list);
		
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
		
	
	/************************* 点击编辑：获取对应信息 ***************************/
	@RequestMapping(value = "/getWorkTask", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "点击编辑：获取对应信息 ", notes = "点击编辑：获取对应信息")
	public ResultEntity getWorkTask(@RequestParam String workTaskId) {

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
	public ResultEntity removeWorkTask(@RequestParam List<String> workTaskIds){
		
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
	@ApiOperation(notes="查询任务分类",value="查询任务分类")
	public PageResultEntity getClassificationName(){
		
		List<WorkClassification> list = workClassificationService.listWorkClassification(null);
		PageResultEntity pageResultEntity = new PageResultEntity();
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setRows(list);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
	}
	
	
	
	
	
	
	
	
	
}
