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
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.DeviceType;
import com.qz.zframe.run.entity.WorkClassification;
import com.qz.zframe.run.entity.WorkClassificationExample;
import com.qz.zframe.run.entity.WorkClassificationExample.Criteria;
import com.qz.zframe.run.service.WorkClassificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: WorkClassificationController</p>
 * <p>@Description: 工作分类controller层 </p>
 * @author 陈汇奇
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
		//对属性值进行判断
		if(StringUtils.isBlank(workClassification.getClassificationName())
				||StringUtils.isBlank(workClassification.getStatus())
				||StringUtils.isBlank(workClassification.getFatClassificationId())
				||StringUtils.isBlank(workClassification.getTaskProperties())){
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		/**************************未登录：现在使用默认值******************************/
		//属性值正常：生成创建人
		//workClassification.setUserId(currentUserService.getId());
		
		workClassification.setUserId("chen");
		
		
		
		workClassificationService.saveWorkClassification(workClassification);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		return resultEntity;
	}
	
	
	
	/**
	 * @Description:模糊查询
	 * @param: @param searchKey
	 * @param: @param classificationName
	 * @param: @param status
	 * @param: @param createTime
	 * @param: @param pageNo
	 * @param: @param pageSize
	 * @param: @return   
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/listWorkClassification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "模糊查询工作分类表", value = "模糊查询工作分类表")
	public PageResultEntity listWorkClassification(@RequestParam(required = false) String searchKey,
			@RequestParam(required = false) String classificationName,
			@RequestParam(required = false) String status,
			@RequestParam(required = false) String createTime,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize){
			
		
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
			
			criteria.andCreateTimeEqualTo(date);
		}
		
		
		PageHelper.startPage(pageNo, pageSize);
		//执行查询
		List<WorkClassification> list = workClassificationService.listWorkClassification(example);
		PageInfo<WorkClassification> pageInfo = new PageInfo<WorkClassification>(list);
		
		PageResultEntity pageResultEntity = new PageResultEntity();
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int)pageInfo.getTotal());
		return pageResultEntity;
	}
	
	
	
	
	
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
		@RequestMapping(value="/getWorkClassification" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
		public ResultEntity getWorkClassification(@RequestParam String classificationId){
			
			ResultEntity resultEntity = new ResultEntity();
			
			if(StringUtils.isNotBlank(classificationId)){
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("缺少字段");
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
			
			if(workClassification != null){
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("执行完成");
				resultEntity.setData(workClassification);
				return resultEntity;
			}
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询失败");
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
	public ResultEntity removeWorkClassification(@RequestParam List<String> classificationIds) {
		
		ResultEntity resultEntity = new ResultEntity();
		
		//如果不为空
		if(CollectionUtils.isNotEmpty(classificationIds)){
			for (String classificationId : classificationIds) {
				workClassificationService.deleteWorkClassificationById(classificationId);
			}
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行完成");
			return resultEntity;
		}else{
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
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
		
		//检查字段
		if(StringUtils.isBlank(workClassification.getClassificationCode())
				||StringUtils.isBlank(workClassification.getClassificationName())
				||StringUtils.isBlank(workClassification.getTaskProperties())
				||StringUtils.isBlank(workClassification.getStatus())
				||StringUtils.isBlank(workClassification.getUserId())
				||StringUtils.isBlank(workClassification.getCreateTime()+"")
				){
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
			return resultEntity;
		}
		
		//字段正常
		workClassificationService.editWorkClassification(workClassification);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行完成");
		return resultEntity;
	}
	
	
	
	
	
	
	
	
}
