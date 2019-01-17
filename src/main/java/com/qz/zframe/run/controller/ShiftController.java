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
import com.qz.zframe.common.util.ObjectIsBlankUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;
import com.qz.zframe.run.entity.ShiftExample.Criteria;
import com.qz.zframe.run.service.ShiftService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>Title: ShiftController</p>
 * <p>@Description: 班次表控制层</p>
 * @author 
 * @date 2018年10月31日 下午2:39:17
 * @version:V1.0
 */
@RestController
@RequestMapping("/api/support/Shift")
@Api(tags = "api-support-api-support-Shift", description = "运行-排班管理-班次管理")
public class ShiftController {

	@Autowired
	private ShiftService shiftService;

	/**
	 * @Description:批量查询班次表信息
	 * @param: @param
	 *             shift
	 * @param: @param
	 *             pageNum
	 * @param: @param
	 *             pageSize
	 * @param: @return
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/getShiftList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量获取班次表信息", notes = "批量获取班次表信息")
	public PageResultEntity getShiftList(@RequestParam(required = false) @ApiParam(name="searchKey",value="关键字查询")String searchKey,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		PageResultEntity pageResultEntity = new PageResultEntity();
		
		ShiftExample example = new ShiftExample();
		
		Criteria criteria = example.createCriteria();
		
		//如果状态值一栏选中
		if(StringUtils.isNotBlank(status)){
			//设置模糊查询
			criteria.andStatusEqualTo(status);
		}
		
		
		// 一个 criteria 对应一个 or
		
		//模糊查询
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			criteria.andShiftCodeLike(searchKey);
			
			Criteria criteria2 = example.createCriteria();
			criteria2.andStatusEqualTo(status);
			criteria2.andShiftNameLike(searchKey);
			
		    example.or(criteria2);
		}
		
		example.setOrderByClause("sort asc");
		//执行查询
		List<Shift> list = shiftService.listShift(example, pageNum, pageSize);
		//设置返回结果
		PageInfo<Shift> pageInfo = new PageInfo<Shift>(list);

		pageResultEntity.setRows(list);
		pageResultEntity.setTotal((int) pageInfo.getTotal());
		pageResultEntity.setCode(ErrorCode.SUCCESS);
		pageResultEntity.setMsg("执行成功");
		return pageResultEntity;
		

	}
	
	@RequestMapping(value="/toExcel",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "导出EXCEL", notes = "导出EXCEL")
	public void toExcel(@RequestParam(required = false) @ApiParam(name="searchKey",value="关键字查询")String searchKey,
			@RequestParam(required = false) @ApiParam(name="status",value="状态") String status,
			HttpServletResponse response) {
		
		ShiftExample example = new ShiftExample();
		
		//如果状态值一栏选中
		if(StringUtils.isNotBlank(status)){
			//设置模糊查询
			example.createCriteria().andStatusEqualTo(status);
		}

		//模糊查询
		if(StringUtils.isNotBlank(searchKey)){
			//设置模糊查询
			example.or().andShiftCodeLike(searchKey);
			example.or().andShiftNameLike(searchKey);
		}
		
		example.setOrderByClause("sort");
		
		
		List<Shift> list = shiftService.listShift(example, 0, 0);
		
		LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>();
		testMap.put("shiftCode", "班次编码");
		testMap.put("shiftName", "班次名称");
		testMap.put("startTime", "开始时间");
		testMap.put("endTime", "结束时间");
		testMap.put("status", "状态");
		testMap.put("sort", "排序");
		testMap.put("isMeterRead", "是否抄表");
		
		try {
			String fileName = ExcelUtil.listToExcel2(list, testMap, "班次管理", 65535, response);
			System.out.println(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	/**
	 * @Description:班次信息添加
	 * @param: @param
	 *             shift：  需要的字段：除了id都需要
	 * @param: @return
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveShift", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "班次信息添加", value = "班次信息添加")
	public ResultEntity saveShift(@RequestBody Shift shift) {

		ResultEntity resultEntity = new ResultEntity();

		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(shift.getShiftCode())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少班次编码字段");
			return resultEntity;
		} 
		if (StringUtils.isBlank(shift.getShiftName())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少班次名称字段");
			return resultEntity;
		}
		if( shift.getSort() == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少排序序号字段");
			return resultEntity;
		} 
		if( StringUtils.isBlank(shift.getStatus())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少状态字段");
			return resultEntity;	
		}
		if( StringUtils.isBlank(shift.getIsMeterRead())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少是否抄表字段");
			return resultEntity;
		} 
		resultEntity = shiftService.saveShift(shift);
		return resultEntity;

	}
	
	
	
	/**
	 * @Description:
	 * @param: @param shiftIds 需要的字段：勾选的被删除的id
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/removeShift", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "批量班次表信息删除", value = "批量班次表信息删除")
	public ResultEntity removeShift(@RequestParam @ApiParam(name="shiftIds",value="勾选的shiftIds") List<String> shiftIds) {

		ResultEntity resultEntity = shiftService.removeShifts(shiftIds); 
		return resultEntity;
	}
	
	
	
	
	/**
	 * @Description:班次表信息编辑
	 * @param: @param shifts：需要的字段：班次表中所有字段都需要
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value="/editShift",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes="批量班次表编辑",value="批量班次表编辑")
	public ResultEntity editShift(@RequestBody List<Shift> shifts){
		
		ResultEntity resultEntity = new ResultEntity();
		//检查修改之后提交的字段是否为空
		if (CollectionUtils.isNotEmpty(shifts)) {
			for (Shift shift : shifts) {
				try {
					boolean fieldBlank = ObjectIsBlankUtil.isExistFieldBlank(shift);
					if(fieldBlank){
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("请填写完整");
						return resultEntity;
					}
				} catch (Exception e) {
					e.printStackTrace();
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("未知错误");
					return resultEntity;
				}
			}
			
		}
		
		resultEntity = shiftService.editShifts(shifts);
		return resultEntity;
	}
	
	
	
	 /** ********************** 	点击添加：获取排序数字            ***********************/
	 
	@RequestMapping(value="/getSort" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取排序数字 ", notes="获取排序数字  ")
	public ResultEntity getSort(){
		ResultEntity resultEntity = new ResultEntity();
		resultEntity = shiftService.getMaxSort();
		return resultEntity;
	}
	
	
	 /*************************    点击编辑：获取对应信息               ***************************/
	@RequestMapping(value="/getShift" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击编辑：获取对应信息 ", notes="点击编辑：获取对应信息")
	public ResultEntity getShift(@RequestParam @ApiParam(name="shiftId",value="勾选的shiftId") String shiftId){
		
		ResultEntity resultEntity = new ResultEntity();

		// 如果数据不为空
		if (StringUtils.isNotBlank(shiftId)) {
			Shift shift = shiftService.getShiftByShiftId(shiftId);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(shift);
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("缺少字段");
		return resultEntity;

	}

	/*************************    点击查看：获取对应信息               ***************************/
	@RequestMapping(value="/viewShift" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取对应信息详情 ", notes="点击查看：获取对应信息详情")
	public ResultEntity viewShift(@RequestParam @ApiParam(name="shiftId",value="勾选的shiftId") String shiftId){
		
		ResultEntity resultEntity = new ResultEntity();
		
		// 如果数据不为空
		if (StringUtils.isNotBlank(shiftId)) {
			Shift shift = shiftService.getShiftByShiftId(shiftId);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("执行成功");
			resultEntity.setData(shift);
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("缺少字段");
		return resultEntity;
		
	}
	
	/************************   获取班次下拉框值           ************************************/
	@RequestMapping(value="/getValueSelect" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="获取班次下拉框值 ", notes="获取班次下拉框值")
	public ResultEntity getValueSelect(){
		ResultEntity resultEntity = new ResultEntity();
		
		ShiftExample example = new ShiftExample();
		List<Shift> list = shiftService.listShift(example, 0, 0);
		if(list!=null && !list.isEmpty()) {
		 resultEntity.setCode(ErrorCode.SUCCESS);
		 resultEntity.setMsg("查询成功");
		 resultEntity.setData(list);
	  }else {
		resultEntity.setCode(ErrorCode.ERROR);
		resultEntity.setMsg("查询失败");
		resultEntity.setData(list);
		}
		return resultEntity;
	}

	
	
	
	
	/**********************************获取班次*************************************/
	@RequestMapping(value="/getShiftName" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value="点击查看：获取班次对应信息 ", notes="点击查看：获取班次对应信息")
	public ResultEntity getShiftName(){
		ResultEntity resultEntity = new ResultEntity(); 
		
		ShiftExample example = new ShiftExample();
		List<Shift> list = shiftService.listShift(example , 0, 0);
		
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("执行成功");
		resultEntity.setData(list);
		return resultEntity;
	}
	

}
