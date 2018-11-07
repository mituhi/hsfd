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
import com.qz.zframe.common.util.ObjectIsBlankUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;
import com.qz.zframe.run.entity.ShiftExample.Criteria;
import com.qz.zframe.run.service.ShiftService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>Title: ShiftController</p>
 * <p>@Description: 班次表控制层</p>
 * @author 陈汇奇
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
	 *             pageNo
	 * @param: @param
	 *             pageSize
	 * @param: @return
	 * @return: PageResultEntity
	 */
	@RequestMapping(value = "/getShiftList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "批量获取班次表信息", notes = "批量获取班次表信息")
	public PageResultEntity getShiftList(@RequestBody Shift shift,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {

		PageResultEntity resultEntity = new PageResultEntity();
		
		//设置分页
		PageHelper.startPage(pageNo, pageSize);

		ShiftExample example = new ShiftExample();
		//设置排序
		example.setOrderByClause("sort desc");

		// 封装查询信息
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(shift.getShiftId())) {
			criteria.andShiftIdEqualTo(shift.getShiftId());
		}

		if (StringUtils.isNotBlank(shift.getShiftCode())) {
			criteria.andShiftCodeEqualTo(shift.getShiftCode());
		}

		if (StringUtils.isNotBlank(shift.getShiftId())) {
			criteria.andShiftIdEqualTo(shift.getShiftId());
		}

		if (StringUtils.isNotBlank(shift.getShiftName())) {
			criteria.andShiftNameLike("%" + shift.getShiftName() + "%");
		}

		if (StringUtils.isNotBlank(shift.getIsMeterRead())) {
			criteria.andIsMeterReadEqualTo(shift.getIsMeterRead());
		}

		// 执行查询
		List<Shift> list = shiftService.listShift(example);
		// 设置返回结果
		PageInfo<Shift> pageInfo = new PageInfo<Shift>(list);
		resultEntity.setRows(list);
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setTotal((int) pageInfo.getTotal());

		return resultEntity;

	}
	
	

	/**
	 * @Description:班次信息添加
	 * @param: @param
	 *             shift
	 * @param: @return
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/saveShift", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "班次信息添加", value = "班次信息添加")
	public ResultEntity saveShift(@RequestBody Shift shift) {

		ResultEntity resultEntity = new ResultEntity();

		// 判断字段是否异常（为空）
		if (StringUtils.isBlank(shift.getShiftCode()) || StringUtils.isBlank(shift.getShiftName())
				|| shift.getSort() == null || StringUtils.isBlank(shift.getStatus())
				|| StringUtils.isBlank(shift.getIsMeterRead())) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("缺少字段");
		} else {
			// 调用接口保存信息
			resultEntity = shiftService.saveShift(shift);
		}
		return resultEntity;

	}
	
	
	
	/**
	 * @Description:
	 * @param: @param shiftIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	@RequestMapping(value = "/deleteShift", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(notes = "批量班次表信息删除", value = "批量班次表信息删除")
	public ResultEntity deleteShift(@RequestBody List<String> shiftIds) {

		ResultEntity resultEntity = shiftService.removeShifts(shiftIds); 
		return resultEntity;
	}
	
	
	
	
	/**
	 * @Description:班次表信息编辑
	 * @param: @param shifts
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
	
	
	

}
