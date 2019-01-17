//package com.qz.zframe.run.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.github.pagehelper.PageInfo;
//import com.qz.zframe.common.util.ErrorCode;
//import com.qz.zframe.common.util.ExcelUtil;
//import com.qz.zframe.common.util.PageResultEntity;
//import com.qz.zframe.common.util.ResultEntity;
//import com.qz.zframe.run.entity.DutyPersonUpdateExample;
//import com.qz.zframe.run.entity.SchedulingAssociated;
//import com.qz.zframe.run.entity.SchedulingAssociatedExample;
//import com.qz.zframe.run.entity.SchedulingManagement;
//import com.qz.zframe.run.entity.SchedulingManagementExample;
//import com.qz.zframe.run.entity.SchedulingRule;
//import com.qz.zframe.run.entity.SchedulingRuleExample;
//import com.qz.zframe.run.entity.result.SchedulingManagementResult;
//import com.qz.zframe.run.entity.submit.SaveSchedulingManagementSubmit;
//import com.qz.zframe.run.service.DutyPersonUpdateService;
//import com.qz.zframe.run.service.SchedulingAssociatedService;
//import com.qz.zframe.run.service.SchedulingManagementService;
//import com.qz.zframe.run.service.SchedulingRuleService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//
///**
// * <p>Title: SchedulingManagementController</p>
// * <p>@Description: 排班管理控制层 </p>
// * @author 
// * @date 2018年11月1日 上午10:38:07
// * @version:V1.0
// */
//@RestController
//@RequestMapping("/api/support/SchedulingManagement")
//@Api(tags = "api-support-api-support-SchedulingManagement", description = "运行-排班管理-排班管理")
//public class SchedulingManagementController {
//
//	@Autowired
//	private SchedulingManagementService schedulingManagementService;
//	
//	@Autowired
//	private SchedulingAssociatedService schedulingAssociatedService;
//	
//	@Autowired
//	private SchedulingRuleService schedulingRuleService;
//	
//	@Autowired
//	private DutyPersonUpdateService dutyPersonUpdateService;
//	
//	
//	
//	@RequestMapping(value = "/SchedulingManagementIndexPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes = "排班管理信息首页", value = "加载排班管理信息首页数据")
//	public PageResultEntity SchedulingManagementIndexPage(@RequestParam(required = false)@ApiParam(name="departments",value="风电场") List<String> departments,
//			@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
//			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
//			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
//		
//		// 返回对象
//		PageResultEntity pageResultEntity = new PageResultEntity();
//
//		SchedulingAssociatedExample example = new SchedulingAssociatedExample();
//		
//		//如果所选的部门不为空
//		if(CollectionUtils.isNotEmpty(departments)){
//			//排版管理表中的部门
//			//根据部门名称，获取排班管理id
//			List<SchedulingManagement> schedulingManagements = schedulingManagementService.getSchedulingManagementByDepartments(departments);
//			//封装查询条件
//			if(CollectionUtils.isNotEmpty(schedulingManagements)){
//				for (SchedulingManagement schedulingManagement : schedulingManagements) {
//					example.or().andSchedulingManagementIdEqualTo(schedulingManagement.getSchedulingManagementId());
//				}
//			}
//			
//		}
//		
//		//如果输入了关键字 可以是  排班表  规则编码   规则名称
//		if(StringUtils.isNotBlank(searchKey)){
//			//如果是排班表名称：根据排班表名称获取排版管理表id
//			SchedulingManagement schedulingManagement = schedulingManagementService.getSchedulingManagementBySchedulingName(searchKey);
//
//			if(schedulingManagement!=null){
//				//不为空有结果
//				example.or().andSchedulingManagementIdEqualTo(schedulingManagement.getSchedulingManagementId());
//			}
//			
//			//如果是规则编码：根据规则编码获取排班规则表id
//			SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleBySchedulingRuleCode(searchKey);
//			
//			//不为空有结果
//			if(schedulingRule!=null){
//				example.or().andSchedulingRuleIdEqualTo(schedulingRule.getSchedulingRuleId());
//			}
//			
//			//如果是规则名称：根据规则名称查询
//			SchedulingRule schedulingRule2 = schedulingRuleService.getSchedulingRuleBySchedulingRuleName(searchKey);
//			//不为空有结果
//			if(schedulingRule2!=null){
//				example.or().andSchedulingRuleIdEqualTo(schedulingRule2.getSchedulingRuleId());
//			}
//		}
//		
//		//执行查询
//		List<SchedulingAssociated> schedulingAssociateds = schedulingAssociatedService.listSchedulingAssociated(example,
//				pageNum, pageSize);
//		
//		PageInfo<SchedulingAssociated> pageInfo = new PageInfo<SchedulingAssociated>(schedulingAssociateds);
//		pageResultEntity.setTotal((int)pageInfo.getTotal());
//		
//		// 声明返回对象集合
//		List<SchedulingManagementResult> results = new ArrayList<SchedulingManagementResult>();
//
//		// 不为空
//		if (CollectionUtils.isNotEmpty(schedulingAssociateds)) {
//
//
//			// 遍历查询其他相关表
//			for (SchedulingAssociated schedulingAssociatedTemp : schedulingAssociateds) {
//				// 返回对象集合元素
//				SchedulingManagementResult schedulingManagementResult = new SchedulingManagementResult();
//				// 设置排班关联表id
//				schedulingManagementResult.setSchedulingAssociatedId(schedulingAssociatedTemp.getId());
//				// 封装开始时间，结束时间
//				schedulingManagementResult.setStartTime(schedulingAssociatedTemp.getStartTime());
//				schedulingManagementResult.setEndTime(schedulingAssociatedTemp.getEndTime());
//				// 得到排版管理表id
//				String schedulingManagementId = schedulingAssociatedTemp.getSchedulingManagementId();
//				// 根据id查询字段
//				SchedulingManagement schedulingManagement = schedulingManagementService
//						.getSchedulingManagementById(schedulingManagementId);
//				// 封装字段 排班表编号 ，排班表， 风电场
//				schedulingManagementResult.setSchedulingCode(schedulingManagement.getSchedulingCode());
//				schedulingManagementResult.setSchedulingName(schedulingManagement.getSchedulingName());
//				schedulingManagementResult.setDepartment(schedulingManagement.getDepartment());
//				// 得到排班规则表id
//				String schedulingRuleId = schedulingAssociatedTemp.getSchedulingRuleId();
//				SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
//				// 封装字段 规则编码 ， 规则名称
//				schedulingManagementResult.setSchedulingRuleCode(schedulingRule.getSchedulingRuleCode());
//				schedulingManagementResult.setSchedulingRule(schedulingRule.getSchedulingRule());
//				// 添加到集合中
//				results.add(schedulingManagementResult);
//			}
//
//		}
//
//		pageResultEntity.setRows(results);
//		pageResultEntity.setCode(ErrorCode.SUCCESS);
//		pageResultEntity.setMsg("执行成功");
//		return pageResultEntity;
//	}
//	
//	
//	
//	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
//	public void toExcel(@RequestParam(required = false) @ApiParam(name="departments",value="风电场") List<String> departments,
//			@RequestParam(required = false)@ApiParam(name="searchKey",value="关键字查询") String searchKey,
//			HttpServletResponse response) {
//		
//		SchedulingAssociatedExample example = new SchedulingAssociatedExample();
//		
//		//如果所选的部门不为空
//		if(CollectionUtils.isNotEmpty(departments)){
//			//排版管理表中的部门
//			//根据部门名称，获取排班管理id
//			List<SchedulingManagement> schedulingManagements = schedulingManagementService.getSchedulingManagementByDepartments(departments);
//			//封装查询条件
//			if(CollectionUtils.isNotEmpty(schedulingManagements)){
//				for (SchedulingManagement schedulingManagement : schedulingManagements) {
//					example.or().andSchedulingManagementIdEqualTo(schedulingManagement.getSchedulingManagementId());
//				}
//			}
//			
//		}
//		
//		//如果输入了关键字 可以是  排班表  规则编码   规则名称
//		if(StringUtils.isNotBlank(searchKey)){
//			//如果是排班表名称：根据排班表名称获取排版管理表id
//			SchedulingManagement schedulingManagement = schedulingManagementService.getSchedulingManagementBySchedulingName(searchKey);
//
//			if(schedulingManagement!=null){
//				//不为空有结果
//				example.or().andSchedulingManagementIdEqualTo(schedulingManagement.getSchedulingManagementId());
//			}
//			
//			//如果是规则编码：根据规则编码获取排班规则表id
//			SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleBySchedulingRuleCode(searchKey);
//			
//			//不为空有结果
//			if(schedulingRule!=null){
//				example.or().andSchedulingRuleIdEqualTo(schedulingRule.getSchedulingRuleId());
//			}
//			
//			//如果是规则名称：根据规则名称查询
//			SchedulingRule schedulingRule2 = schedulingRuleService.getSchedulingRuleBySchedulingRuleName(searchKey);
//			//不为空有结果
//			if(schedulingRule2!=null){
//				example.or().andSchedulingRuleIdEqualTo(schedulingRule2.getSchedulingRuleId());
//			}
//		}
//		
//		
//		//执行查询
//		List<SchedulingAssociated> schedulingAssociateds = schedulingAssociatedService.listSchedulingAssociated(example,0, 0);
//		
//		// 声明返回对象集合
//		List<SchedulingManagementResult> results = new ArrayList<SchedulingManagementResult>();
//
//		// 不为空
//		if (CollectionUtils.isNotEmpty(schedulingAssociateds)) {
//
//			SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd");
//				
//			// 遍历查询其他相关表
//			for (SchedulingAssociated schedulingAssociatedTemp : schedulingAssociateds) {
//				// 返回对象集合元素
//				SchedulingManagementResult schedulingManagementResult = new SchedulingManagementResult();
//				// 设置排班关联表id
//				schedulingManagementResult.setSchedulingAssociatedId(schedulingAssociatedTemp.getId());
//				// 封装开始时间，结束时间
//				
//				//对时间的格式化
//				String startTimeEx = null;
//				String endTimeEx = null;
//				try {
//					startTimeEx = format.format(schedulingAssociatedTemp.getStartTime());
//					endTimeEx = format.format(schedulingAssociatedTemp.getEndTime());
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//				
//				schedulingManagementResult.setStartTimeExcel(startTimeEx);
//				schedulingManagementResult.setEndTimeExcel(endTimeEx);
//				// 得到排版管理表id
//				String schedulingManagementId = schedulingAssociatedTemp.getSchedulingManagementId();
//				// 根据id查询字段
//				SchedulingManagement schedulingManagement = schedulingManagementService
//						.getSchedulingManagementById(schedulingManagementId);
//				// 封装字段 排班表编号 ，排班表， 风电场
//				schedulingManagementResult.setSchedulingCode(schedulingManagement.getSchedulingCode());
//				schedulingManagementResult.setSchedulingName(schedulingManagement.getSchedulingName());
//				schedulingManagementResult.setDepartment(schedulingManagement.getDepartment());
//				// 得到排班规则表id
//				String schedulingRuleId = schedulingAssociatedTemp.getSchedulingRuleId();
//				SchedulingRule schedulingRule = schedulingRuleService.getSchedulingRuleById(schedulingRuleId);
//				// 封装字段 规则编码 ， 规则名称
//				schedulingManagementResult.setSchedulingRuleCode(schedulingRule.getSchedulingRuleCode());
//				schedulingManagementResult.setSchedulingRule(schedulingRule.getSchedulingRule());
//				// 添加到集合中
//				results.add(schedulingManagementResult);
//			}
//
//		}
//		
//		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
//		testMap.put("schedulingCode", "排班编号");
//		testMap.put("schedulingName", "排班表名称");
//		testMap.put("department", "风电场");
//		testMap.put("schedulingRuleCode", "排班规则编码");
//		testMap.put("schedulingRule", "排班规则名称");
//		testMap.put("startTimeExcel", "开始日期");
//		testMap.put("endTimeExcel", "结束日期");
//		
//		try {
//			String fileName = ExcelUtil.listToExcel2(results, testMap, "排班管理", 65535, response);
//			System.out.println(fileName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	
//	/**
//	 * @Description:排版管理表信息的添加
//	 * @param: @param
//	 *             schedulingManagement：SaveSchedulingManagementSubmit字段都需要
//	 * @param: @return
//	 * @return: ResultEntity
//	 */
//	@RequestMapping(value = "/saveSchedulingManagement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes = "排版管理表信息的添加", value = "排版管理表信息的添加")
//	public ResultEntity saveSchedulingManagement(@RequestBody SaveSchedulingManagementSubmit schedulingManagementSubmit) {
//		
//		
//		/********************************************************/
////		long l1 = System.currentTimeMillis();
//		
//		ResultEntity resultEntity = new ResultEntity();
//		
//		//获取排班管理对象
//		SchedulingManagement schedulingManagement = schedulingManagementSubmit.getSchedulingManagement();
//
//		//获取排班关联表集合对象
//		List<SchedulingAssociated> list = schedulingManagementSubmit.getSchedulingAssociateds();
//		
//		// 判断是否缺少字段
//		if (StringUtils.isBlank(schedulingManagement.getDepartment())
//				|| StringUtils.isBlank(schedulingManagement.getSchedulingCode())
//				|| StringUtils.isBlank(schedulingManagement.getSchedulingName())
//				||CollectionUtils.isEmpty(list)) {
//			resultEntity.setCode(ErrorCode.ERROR);
//			resultEntity.setMsg("缺少字段");
//			return resultEntity;
//		}
//		
//		//保存各个时间用来比较
//		List<Long[]> times = new ArrayList<Long[]>();
//		//对选择的时间进行校验：
//		for (SchedulingAssociated schedulingAssociated : list) {
//
//			//开始时间
//			Date startTime = schedulingAssociated.getStartTime();
//			//结束时间
//			Date endTime = schedulingAssociated.getEndTime();
//			
//			//如果
//			if(startTime.getTime() > endTime.getTime()){
//				resultEntity.setCode(ErrorCode.ERROR);
//				resultEntity.setMsg("开始时间大于结束时间，请检查");
//				return resultEntity;
//			}
//			
//			//比较时间
//			if(CollectionUtils.isNotEmpty(times)){
//				//里面有时间：进行比较
//				for (Long[] longs : times) {
//					//longs[0]:开始时间    longs[1]：结束时间
//					//如果上个日期的开始时间>本次日期的开始时间    或者  如果上个日期的结束时间< 本次日期的结束时间 
//					if(longs[0].longValue() > startTime.getTime()
//							|| longs[1].longValue() >  startTime.getTime()){
//						resultEntity.setCode(ErrorCode.ERROR);
//						resultEntity.setMsg("请按时间顺序添加，时间不能重叠");
//						return resultEntity;
//					}
//				}
//			}
//			
//			//创建对象
//			Long[] longsTime = new Long[]{startTime.getTime(),endTime.getTime()};
//			//存放入集合
//			times.add(longsTime);
//		}
//		
//		//时间正常
//		
//		
//		//生成id
//		String schedulingManagementId = UUID.randomUUID().toString();
//		schedulingManagement.setSchedulingManagementId(schedulingManagementId);
//		//执行插入操作
//		resultEntity = schedulingManagementService.saveSchedulingManagement(schedulingManagement);
//		
//		if(resultEntity.getCode()==ErrorCode.ERROR){
//			return resultEntity;
//		}
//		
//		//创建一个集合用来保存排班关联表的集合
//		List<String> schedulingAssociatedIds = new ArrayList<String>();
//		
//		//插入完成之后需要对关联表进行相关的操作
//		for (SchedulingAssociated schedulingAssociated : list) {
//			//生成schedulingAssociated的主键
//			String schedulingAssociatedId = UUID.randomUUID().toString();
//			schedulingAssociated.setId(schedulingAssociatedId);
//			
//			//保存id
//			schedulingAssociatedIds.add(schedulingAssociatedId);
//			
//			//设置排班关联表id
//			schedulingAssociated.setSchedulingManagementId(schedulingManagementId);
//			//执行插入操作
//			schedulingAssociatedService.saveSchedulingAssociated(schedulingAssociated);
//		}
//		
//		
//		//接下来保存值班人员修改表
//		resultEntity = dutyPersonUpdateService.saveDutyPersonUpdate(schedulingManagement, list);
//		
////		long l2 = System.currentTimeMillis();
////		
////		System.out.println("执行保存操作所需时间："+(l2-l1));
//		
//		return resultEntity;
//	}
	
//	
//	
//	
//	/**
//	 * @Description: 编辑操作：操作排班关联表进行更新
//	 * @param: @param schedulingManagementResults
//	 * @param: @return   
//	 * @return: ResultEntity
//	 */
//	@RequestMapping(value = "/editSchedulingAssociated", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes = "排班关联表表的修改", value = "修改排班关联表") 
//	public ResultEntity editSchedulingAssociated(@RequestBody SaveSchedulingManagementSubmit schedulingManagementSubmit){
//		
//		ResultEntity resultEntity = new ResultEntity();
//		
//		//获取对象
//		SchedulingManagement schedulingManagement = schedulingManagementSubmit.getSchedulingManagement();
//		List<SchedulingAssociated> schedulingAssociateds = schedulingManagementSubmit.getSchedulingAssociateds();
//		
//		//更新排版管理表信息
//		schedulingManagementService.updateSchedulingManagement(schedulingManagement);
//		
//		
//		//更新排班关联表
//		for (SchedulingAssociated schedulingAssociatedTemp : schedulingAssociateds) {
//			String id = schedulingAssociatedTemp.getId();
//			//如果id不为空，就是更新
//			if(StringUtils.isNotBlank(id)){
//				//删除 duty_person_update 值班人员修改表
//				DutyPersonUpdateExample example = new DutyPersonUpdateExample();
//				example.createCriteria().andSchedulingAssociatedIdEqualTo(id);
//				//删除值班人员修改表信息
//				dutyPersonUpdateService.deleteDutyPersonUpdateByExample(example);
//				
//				
//				schedulingAssociatedService.updateSchedulingAssociated(schedulingAssociatedTemp);
//			}else{
//				//id为空，设置
//				String schedulingAssociatedId = UUID.randomUUID().toString();
//				schedulingAssociatedTemp.setSchedulingManagementId(schedulingManagement.getSchedulingManagementId());
//				
//				schedulingAssociatedTemp.setId(schedulingAssociatedId);
//				
//				schedulingAssociatedService.saveSchedulingAssociated(schedulingAssociatedTemp);
//			}
//		}
//		
//		//接下来保存值班人员修改表
//		resultEntity = dutyPersonUpdateService.saveDutyPersonUpdate(schedulingManagement, schedulingAssociateds);
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setMsg("执行成功");
//		return resultEntity;
//	}
//	
//	
//	
//	
//	/***************在排班管理更新界面点击删除规则排班*******************/
//	/**********************删除排班关联表表中信息*****************************/
//	@RequestMapping(value="/removeScheduling",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes="在排班管理更新界面点击删除规则排班", value="在排班管理更新界面点击删除规则排班")
//	public ResultEntity removeScheduling(@RequestParam @ApiParam(name="schedulingAssociateds",value="关联表schedulingAssociated") List<String> schedulingAssociateds){
//		ResultEntity resultEntity = new ResultEntity();
//		
//		for (String schedulingAssociated : schedulingAssociateds) {
//			schedulingAssociatedService.deleteScheduling(schedulingAssociated);
//		}
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setMsg("执行成功");
//		return resultEntity;
//	}
//	
//	
//	
//	/**
//	 * @Description:删除:勾选列，提交排班关联表id，进行删除操作
//	 * @param: @param schedulingAssociateds：勾选被删除的排班关联表id
//	 * @param: @return   
//	 * @return: ResultEntity
//	 */
//	@RequestMapping(value="/removeSchedulingAssociated",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(notes="勾选列，提交排班关联表id，进行删除操作", value="删除排班关联表")
//	public ResultEntity removeSchedulingAssociated(@RequestParam @ApiParam(name="schedulingAssociateds",value="关联表schedulingAssociated") List<String> schedulingAssociateds){
//		return schedulingAssociatedService.removeSchedulingAssociatedById(schedulingAssociateds);
//	}
//	
//	
//	 /*************************    点击编辑：获取对应信息               ***************************/
//	@RequestMapping(value="/getSchedulingAssociated" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
//	public ResultEntity getSchedulingAssociated(@RequestParam @ApiParam(name="schedulingAssociatedId",value="关联表schedulingAssociatedId") String schedulingAssociatedId){
//
//		ResultEntity resultEntity = new ResultEntity();
//
//		
//		//声明返回结果对象
//		SaveSchedulingManagementSubmit schedulingManagementSubmit = new SaveSchedulingManagementSubmit();
//		
//		//通过排班关联表id获取排班管理表id
//		SchedulingAssociated schedulingAssociated = schedulingAssociatedService.getSchedulingAssociatedById(schedulingAssociatedId);
//		
//		//获取排版管理表id
//		String managementId = schedulingAssociated.getSchedulingManagementId();
//		//通过id获取对象
//		SchedulingManagement schedulingManagementResult = schedulingManagementService.getSchedulingManagementById(managementId);
//		
//		//赋值
//		schedulingManagementSubmit.setSchedulingManagement(schedulingManagementResult);
//		
//		//通过排版管理表id获取排版管理表集合对象
//		SchedulingAssociatedExample schedulingAssociatedExample = new SchedulingAssociatedExample();
//		schedulingAssociatedExample.createCriteria().andSchedulingManagementIdEqualTo(managementId);
//		//获取关联集合对象
//		List<SchedulingAssociated> associated = schedulingAssociatedService.listSchedulingAssociated(schedulingAssociatedExample , 0, 0);
//		//封装
//		schedulingManagementSubmit.setSchedulingAssociateds(associated);
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setMsg("执行成功");
//		resultEntity.setData(schedulingManagementSubmit);
//		return resultEntity;
//		
//	}
//	
//	
//	
//	/*************************    点击查看：获取对应信息               ***************************/
//	@RequestMapping(value="/viewSchedulingAssociated" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(value="点击查看：获取对应信息 ", notes="点击查看：获取对应信息")
//	public ResultEntity viewSchedulingAssociated(@RequestParam @ApiParam(name="schedulingAssociatedId",value="关联表schedulingAssociatedId") String schedulingAssociatedId){
//		
//		ResultEntity resultEntity = new ResultEntity();
//		
//		
//		//声明返回结果对象
//		SaveSchedulingManagementSubmit schedulingManagementSubmit = new SaveSchedulingManagementSubmit();
//		
//		//通过排班关联表id获取排班管理表id
//		SchedulingAssociated schedulingAssociated = schedulingAssociatedService.getSchedulingAssociatedById(schedulingAssociatedId);
//		
//		//获取排版管理表id
//		String managementId = schedulingAssociated.getSchedulingManagementId();
//		//通过id获取对象
//		SchedulingManagement schedulingManagementResult = schedulingManagementService.getSchedulingManagementById(managementId);
//		
//		//赋值
//		schedulingManagementSubmit.setSchedulingManagement(schedulingManagementResult);
//		
//		//通过排版管理表id获取排版管理表集合对象
//		SchedulingAssociatedExample schedulingAssociatedExample = new SchedulingAssociatedExample();
//		schedulingAssociatedExample.createCriteria().andSchedulingManagementIdEqualTo(managementId);
//		//获取关联集合对象
//		List<SchedulingAssociated> associated = schedulingAssociatedService.listSchedulingAssociated(schedulingAssociatedExample , 0, 0);
//		//封装
//		schedulingManagementSubmit.setSchedulingAssociateds(associated);
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setMsg("执行成功");
//		resultEntity.setData(schedulingManagementSubmit);
//		return resultEntity;
//	}
//	
//	
//	/************************************获取排班表*****************************************/
//	@RequestMapping(value="/findSchedulingName" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiOperation(value="获取排班表 ", notes="获取排班表")
//	public ResultEntity findSchedulingName(){
//		
//		ResultEntity resultEntity = new ResultEntity();
//		
//		SchedulingManagementExample example = new SchedulingManagementExample();
//		List<SchedulingManagement> list = schedulingManagementService.listSchedulingManagement(example);
//		
//		
//		resultEntity.setCode(ErrorCode.SUCCESS);
//		resultEntity.setData(list);
//		resultEntity.setMsg("执行成功");
//		return resultEntity;
//	}
//		
//	
//	
//	
//}
