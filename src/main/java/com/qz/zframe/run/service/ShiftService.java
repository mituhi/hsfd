package com.qz.zframe.run.service;

import java.util.List;

import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.run.entity.Shift;
import com.qz.zframe.run.entity.ShiftExample;

/**
 * <p>Title: ShiftService</p>
 * <p>@Description: 接口声明 </p>
 * @author 陈汇奇
 * @date 2018年11月1日 下午12:28:02
 * @version:V1.0
 */
public interface ShiftService {
	
	/**
	 * @Description:批量获取班次信息
	 * @param: @param example
	 * @param: @return   
	 * @return: List<Shift>
	 */
	List<Shift> listShift(ShiftExample example ,int pageNo , int pageSize);

	/**
	 * @Description:添加班次信息
	 * @param: @param shift
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity saveShift(Shift shift);

	/**
	 * @Description:批量删除班次信息
	 * @param: @param shiftIds
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity removeShifts(List<String> shiftIds);

	/**
	 * @Description:批量编辑班次信息
	 * @param: @param shifts
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity editShifts(List<Shift> shifts);

	
	/**
	 * @Description:获取最大的sort值
	 * @param: @return   
	 * @return: ResultEntity
	 */
	ResultEntity getMaxSort();
	
	
	/**
	 * @Description: 根据班次code获取班次id
	 * @param: @param ShiftCode
	 * @param: @return   
	 * @return: String
	 */
	String getShiftIdByCode(String shiftCode);
	
	
	
	/**
	 * @Description:根据班次名称获取对象
	 * @param: @param shiftName
	 * @param: @return   
	 * @return: Shift
	 */
	Shift getShiftByShiftName(String shiftName);

	
	/**
	 * @Description:通过id查找
	 * @param: @param shiftId
	 * @param: @return   
	 * @return: Shift
	 */
	Shift getShiftByShiftId(String shiftId);
	
}
