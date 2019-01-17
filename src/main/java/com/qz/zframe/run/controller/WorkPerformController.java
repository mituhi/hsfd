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
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.isc.domain.IscUser;
import com.qz.zframe.isc.service.IscUserService;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;
import com.qz.zframe.run.entity.WorkPerform;
import com.qz.zframe.run.entity.WorkPerformSearch;
import com.qz.zframe.run.entity.WorkTask;
import com.qz.zframe.run.entity.submit.WorkPerformSearchSubmit;
import com.qz.zframe.run.entity.submit.WorkPerformTaskSubmit;
import com.qz.zframe.run.service.WorkClassificationService;
import com.qz.zframe.run.service.WorkPerformSearchService;
import com.qz.zframe.run.service.WorkPerformService;
import com.qz.zframe.run.service.WorkTaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * <p>Title: WorkPerformController</p>
 * <p>@Description: 任务执行Controller层 </p>
 * @author 
 * @date 2018年11月13日 上午10:17:08
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/WorkPerform")
@Api(tags = "api-support-api-support-WorkPerform", description = "运行-定期工作-工作执行查询")
public class WorkPerformController {
	
	@Autowired
	private WorkPerformService workPerformService;

	@Autowired
	private WorkTaskService workTaskService;
	
	@Autowired
	private WorkPerformSearchService workPerformSearchService;
	
	@Autowired
	private IscUserService iscUserService;
	
	@Autowired
	private WorkClassificationService workClassificationService;
	
	
	
	/**
	 * @Description:
	 * @param: @param searchKey:关键字模糊查询
	 * @param: @param classificationName：任务分类
	 * @param: @param unit：机组
	 * @param: @param depart：负责部门
	 * @param: @param windIds:风场
	 * @param: @param status：完成状态
	 * @param: @param startTimeFirst：计划完成时间段：开始
	 * @param: @param startTimeSecond：计划完成时间段：结束
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listWorkPerform", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "加载首页数据", notes = "加载首页数据")
	public PageResultEntity listWorkPerform(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="classificationName",value="分类名称") String classificationName,
			@RequestParam(required = false) @ApiParam(name="unit",value="机组") String unit,
			@RequestParam(required = false) @ApiParam(name="depart",value="负责部门") String depart,
			@RequestParam(required = false) @ApiParam(name="windIds",value="风电场id") List<String> windIds,
			@RequestParam(required = false) @ApiParam(name="status",value="完成状态") String status,
			@RequestParam(required = false) @ApiParam(name="startTimeFirst",value="计划开始时间--始") String startTimeFirst,
			@RequestParam(required = false) @ApiParam(name="startTimeSecond",value="计划开始时间--终") String startTimeSecond,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
		
		
		//声明返回对象
		PageResultEntity pageResultEntity = new PageResultEntity();
		
		//查询字段封装类
		WorkPerformSearchSubmit searchSubmit = new WorkPerformSearchSubmit();
		
		if(StringUtils.isNotBlank(searchKey)){
			searchSubmit.setSearchKey("%"+searchKey+"%");
		}
		//选择了分类名称
		if(StringUtils.isNotBlank(classificationName)){
			searchSubmit.setClassificationName(classificationName);
		}
		
		//选择了班组
		if(StringUtils.isNotBlank(unit)){
			searchSubmit.setUnit(unit);
		}
		
		//选择了部门
		if(StringUtils.isNotBlank(depart)){
			searchSubmit.setDepart(depart);
		}
		
		//选择了风电场
		if(CollectionUtils.isNotEmpty(windIds)){
			searchSubmit.setWindIds(windIds);
		}
		
		//选择了状态
		if(StringUtils.isNotBlank(status)){
			searchSubmit.setStatus(status);
		}
		
		//如果选择了第一个时间区间
		if(StringUtils.isNotBlank(startTimeFirst)){
			//如果选择第二个时间区间
			if(StringUtils.isNotBlank(startTimeSecond)){
				//将时间格式化：   2018-11-13
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateStart = null;
				Date dateEnd = null;
				
				try {
					dateStart = format.parse(startTimeFirst);
					dateEnd = format.parse(startTimeSecond);
				} catch (ParseException e) {
					e.printStackTrace();
					pageResultEntity.setCode(ErrorCode.ERROR);
					pageResultEntity.setMsg("时间解析失败");
					return pageResultEntity;
				}
				
				searchSubmit.setStartTime(dateStart);
				searchSubmit.setEndTime(dateEnd);
				
			}else{
				//没有选择第二个区间
				pageResultEntity.setCode(ErrorCode.ERROR);
				pageResultEntity.setMsg("请选择一个时间区间");
				return pageResultEntity;
			}
			
		}
		
		PageHelper.startPage(pageNum, pageSize);
		//执行查询操作
		List<WorkPerformSearch> listWorkPerformSearch = workPerformSearchService.listWorkPerformSearch(searchSubmit);
		PageInfo<WorkPerformSearch> pageInfo = new PageInfo<WorkPerformSearch>(listWorkPerformSearch);
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(listWorkPerformSearch);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
		
		
	}
	
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
			@RequestParam(required = false) @ApiParam(name="classificationName",value="分类名称") String classificationName,
			@RequestParam(required = false) @ApiParam(name="unit",value="机组") String unit,
			@RequestParam(required = false) @ApiParam(name="depart",value="负责部门") String depart,
			@RequestParam(required = false) @ApiParam(name="windIds",value="风电场id") List<String> windIds,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false) @ApiParam(name="startTimeFirst",value="计划开始时间--始") String startTimeFirst,
			@RequestParam(required = false) @ApiParam(name="startTimeSecond",value="计划开始时间--终") String startTimeSecond,
			HttpServletResponse response) {
		
		//查询字段封装类
		WorkPerformSearchSubmit searchSubmit = new WorkPerformSearchSubmit();
		
		if(StringUtils.isNotBlank(searchKey)){
			searchSubmit.setSearchKey("%"+searchKey+"%");
		}
		
		//选择了分类名称
		if(StringUtils.isNotBlank(classificationName)){
			searchSubmit.setClassificationName(classificationName);
		}
		
		//选择了班组
		if(StringUtils.isNotBlank(unit)){
			searchSubmit.setUnit(unit);
		}
		
		//选择了部门
		if(StringUtils.isNotBlank(depart)){
			searchSubmit.setDepart(depart);
		}
		
		//选择了风电场
		if(CollectionUtils.isNotEmpty(windIds)){
			searchSubmit.setWindIds(windIds);
		}
		
		//选择了状态
		if(StringUtils.isNotBlank(status)){
			searchSubmit.setStatus(status);
		}
		
		//如果选择了第一个时间区间
		if(StringUtils.isNotBlank(startTimeFirst)){
			//如果选择第二个时间区间
			if(StringUtils.isNotBlank(startTimeSecond)){
				//将时间格式化：   2018-11-13
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date dateStart = null;
				Date dateEnd = null;
				
				try {
					dateStart = format.parse(startTimeFirst);
					dateEnd = format.parse(startTimeSecond);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				searchSubmit.setStartTime(dateStart);
				searchSubmit.setEndTime(dateEnd);
				
			}else{
				//没有选择第二个区间
				return ;
			}
			
		}
		
		//执行查询操作
		List<WorkPerformSearch> list = workPerformSearchService.listWorkPerformSearch(searchSubmit);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		for (WorkPerformSearch workPerformSearch : list) {
			//将负责人id变成名称
			//String dealPeople = workPerformSearch.getDealPeople();
			
			/**设置时间相关    时间格式化**/
			
			/**发起时间(导出Excel专用)**/
			Date startTime = workPerformSearch.getStartTime();
			String startTimeStr = format.format(startTime);
			workPerformSearch.setStartTimeStr(startTimeStr);
			
			/**计划完成时间(导出Excel专用)**/
			Date completeTime = workPerformSearch.getCompleteTime();
			String completeTimeStr = format.format(completeTime);
			workPerformSearch.setCompleteTimeStr(completeTimeStr);
			
			
			/**实际完成时间(导出Excel专用)**/
			Date endTime = workPerformSearch.getEndTime();
			String endTimeStr = format.format(endTime);
			workPerformSearch.setEndTimeStr(endTimeStr);
			
		}
		
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("serialNum", "任务编号");
		testMap.put("workName", "工作名称");
		testMap.put("workDescribe", "工作描述");
		testMap.put("depart", "负责班组");
		testMap.put("username", "负责人");
		testMap.put("dealPeople", "处理人");
		testMap.put("startTimeStr", "发起时间");
		testMap.put("completeTimeStr", "计划完成时间");
		testMap.put("endTimeStr", "实际完成时间");
		testMap.put("completeStatus", "完成状态");
		testMap.put("address", "位置");
		testMap.put("unit", "机组");
		testMap.put("createUser", "创建人");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "任务执行", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value = "/getWorkPerformSearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "点击编辑：获取对应信息 ", notes = "点击编辑：获取对应信息")
	public ResultEntity getWorkPerformSearch(@RequestParam @ApiParam(name="performId",value="勾选的performId") String performId) {

		ResultEntity resultEntity = new ResultEntity();

		
		//创建返回对象
		WorkPerformTaskSubmit workPerformTaskSubmit = new WorkPerformTaskSubmit();
		
		// 如果数据不为空
		if (StringUtils.isNotBlank(performId)) {
			
			//通过任务执行表id获取对象
			WorkPerform workPerform = workPerformService.getWorkPerformById(performId);
			
			//设置值
			workPerformTaskSubmit.setWorkPerform(workPerform);
			
			//通过任务执行表对象获取工作任务表id
			String workTaskId = workPerform.getWorkTaskId();
			
			//通过工作任务表id获取对象
			WorkTask workTask = workTaskService.getWorkTaskById(workTaskId);
			
			/***********************************/
			//涉及到文件的回显的问题
			/***********************************/
			
			
			//设置值
			workPerformTaskSubmit.setWorkTask(workTask);
			
			//通过工作任务对象获取工作任务id
			String classificationId = workTask.getClassificationId();
			
			//通过工作任务id获取工作任务对象
			WorkClassification workClassification = workClassificationService.getWorkClassificationById(classificationId);
			
			workPerformTaskSubmit.setWorkClassification(workClassification);
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(workPerformTaskSubmit);
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}

	}

	
	
	/*************************    点击查看：获取对应信息               ***************************/
	@RequestMapping(value = "/viewWorkPerformSearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "点击查看：获取对应信息 ", notes = "点击查看：获取对应信息")
	public ResultEntity viewWorkPerformSearch(@RequestParam @ApiParam(name="performId",value="勾选的performId") String performId) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		
		//创建返回对象
		WorkPerformTaskSubmit workPerformTaskSubmit = new WorkPerformTaskSubmit();
		
		// 如果数据不为空
		if (StringUtils.isNotBlank(performId)) {
			
			//通过任务执行表id获取对象
			WorkPerform workPerform = workPerformService.getWorkPerformById(performId);
			
			//设置值
			workPerformTaskSubmit.setWorkPerform(workPerform);
			
			//通过任务执行表对象获取工作任务表id
			String workTaskId = workPerform.getWorkTaskId();
			
			//通过工作任务表id获取对象
			WorkTask workTask = workTaskService.getWorkTaskById(workTaskId);
			
			/***********************************/
			//涉及到文件的回显的问题
			/***********************************/
			
			
			//设置值
			workPerformTaskSubmit.setWorkTask(workTask);
			
			//通过工作任务对象获取工作任务id
			String classificationId = workTask.getClassificationId();
			
			//通过工作任务id获取工作任务对象
			WorkClassification workClassification = workClassificationService.getWorkClassificationById(classificationId);
			
			workPerformTaskSubmit.setWorkClassification(workClassification);
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(workPerformTaskSubmit);
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
	}
	
	
	/**
	 * @Description:删除
	 * @param: @param performIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeWorkPerformSearch", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "批量信息删除", value = "批量信息删除")
	public ResultEntity removeWorkPerformSearch(@RequestParam @ApiParam(name="performIds",value="勾选的performId") List<String> performIds) {
		
		
		ResultEntity resultEntity = new ResultEntity();
		//如果集合不为空
		if(CollectionUtils.isNotEmpty(performIds)){
			for (String performId : performIds) {
				workPerformService.deleteWorkPerformById(performId);
			}
		}
		resultEntity.setMsg("执行成功");
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}
	
	
	@RequestMapping(value = "/editWorkPerformSearch", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "点击保存操作：更新任务执行界面信息", value = "点击保存操作：更新任务执行界面信息")
	public ResultEntity editWorkPerformSearch(@RequestBody WorkPerformTaskSubmit workPerformTaskSubmit){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//得到工作任务表对象
		WorkTask workTask = workPerformTaskSubmit.getWorkTask();
		
		//得到工作执行表对象
		WorkPerform workPerform = workPerformTaskSubmit.getWorkPerform();
		
		//得到任务分类表对象
		WorkClassification workClassification = workPerformTaskSubmit.getWorkClassification();
		
		//检查字段是否完整
		if(StringUtils.isBlank(workTask.getWindId())
				||StringUtils.isBlank(workTask.getDepart())
				||StringUtils.isBlank(workTask.getUserId())
				||StringUtils.isBlank(workTask.getWorkName())){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		//工作任务对象检查字段完成
		
		//检查任务执行字段是否完整
		if(StringUtils.isBlank(workPerform.getStartTime()+"")
				||StringUtils.isBlank(workPerform.getEndTime()+"")
				||StringUtils.isBlank(workPerform.getDealPeople())
				||StringUtils.isBlank(workPerform.getCompleteTime()+"")){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//任务执行对象检查字段完成
		
		//重新设置负责人：
		String userId = workTask.getUserId();
		//通过userid获取user对象
		IscUser user = iscUserService.getUser(userId, null);
		workTask.setUsername(user.getUserName());
		
		//获取任务分类Code
		String classificationCode = workClassification.getClassificationCode();
		//通过code获取分类对象
		WorkClassificationExample example = new WorkClassificationExample();
		example.createCriteria().andClassificationCodeEqualTo(classificationCode);
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);
		
		if(list.size()>0){
			WorkClassification classification = list.get(0);
			workTask.setClassificationId(classification.getClassificationId());
		}
		
		//更新工作任务表
		workTaskService.updateWorkTask(workTask);
		
		//更新任务执行表
		workPerformService.updateWorkPerform(workPerform);
		
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	
	/**************************点击已执行，更新任务执行表中完成状态字段：置为完成状态*******************************************/
	@RequestMapping(value = "/doneWorkPerformSearch", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "点击已(不)执行操作：更新任务执行界面信息", value = "点击已(不)执行操作：更新任务执行界面信息")
	public ResultEntity doneWorkPerformSearch(@RequestParam @ApiParam(name="performId",value="勾选的performId",required = true) String performId,
			@RequestParam @ApiParam(name="completeStatus",value="根据用户的选择提交：不执行为 -1    未完成是0    已执行为1",required = true) String completeStatus){
		
		ResultEntity resultEntity = new ResultEntity();
		
		//检查字段是否完整
		if(StringUtils.isBlank(performId)
				||StringUtils.isBlank(completeStatus)){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//修改工作执行表完成状态字段
		resultEntity = workPerformService.doneWorkPerform(performId, completeStatus);
		
		return resultEntity;
	}
	
	
	
	
	
}
