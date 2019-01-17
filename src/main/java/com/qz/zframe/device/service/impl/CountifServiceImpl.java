package com.qz.zframe.device.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.common.util.DateUtil;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.vo.Breakdown;
import com.qz.zframe.device.entity.vo.BreakdownDetail;
import com.qz.zframe.device.entity.vo.Breakdowns;
import com.qz.zframe.device.entity.vo.Breakdownss;
import com.qz.zframe.device.service.CountifService;
import com.qz.zframe.maintain.entity.BreakdownInfo;
import com.qz.zframe.maintain.entity.BreakdownInfoExample;
import com.qz.zframe.maintain.mapper.BreakdownInfoMapper;

import jxl.write.DateTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class CountifServiceImpl implements CountifService {
	@Autowired
	private BreakdownInfoMapper breakdownInfoMapper;
    
	@Autowired
	private CountifService countifService;
	
	@Override
	public PageResultEntity findCountis(String pageType, String countType,Date activeTime,Date activeTime2) {
		PageResultEntity resultEntity = new PageResultEntity();
		/*
		if(activeTime2.before(activeTime)) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("选择时间有误,请重新选择");
		}
		*/
		//List<Breakdown> breakdown = new ArrayList<Breakdown>();
		if ("01".equals(pageType)) {
			if ("01".equals(countType)) {
				int count=breakdownInfoMapper.countNumber(activeTime,activeTime2);
				if(count==0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("查询无数据");
				}else {
				resultEntity.setTotal(count+1);
				List<Breakdown> breakdown = breakdownInfoMapper.numberTroubleSite(activeTime,activeTime2);
				if (breakdown == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询失败");
					return resultEntity;
				}
					resultEntity.setRows(breakdown); 
				}
				
			}
			if ("02".equals(countType)) {
				int count=breakdownInfoMapper.countNumbers(activeTime,activeTime2);
				if(count==0) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询无数据");
					return resultEntity;
					}else {
				resultEntity.setTotal(count+1);
				List<Breakdowns> breakdowns = breakdownInfoMapper.numberTrouble(activeTime,activeTime2);
				if (breakdowns == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询失败");
					return resultEntity;
				}
				resultEntity.setRows(breakdowns); 
			}
				}
			if ("03".equals(countType)) {
				int count=breakdownInfoMapper.countNumberlist(activeTime, activeTime2);
				if(count==0) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询无数据");
					return resultEntity;
					}else {
				resultEntity.setTotal(count+1 );
				List<Breakdownss> breakdownss = (List<Breakdownss>) breakdownInfoMapper.completeTrouble(activeTime,activeTime2);
				if (breakdownss == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("查询失败");
					return resultEntity;
				}
				resultEntity.setRows(breakdownss); 
			}
				}
		} else {

		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		
		return resultEntity;

	}

	/*
	 * @Override public ResultEntity numberTrouble(BreakdownInfoExample
	 * breakExample) { ResultEntity resultEntity = new ResultEntity();
	 * List<Breakdown> breakdown=breakdownInfoMapper.numberTrouble(breakExample);
	 * if(breakdown==null) { resultEntity.setCode(ErrorCode.ERROR);
	 * resultEntity.setMsg("查询失败"); } resultEntity.setCode(ErrorCode.SUCCESS);
	 * resultEntity.setMsg("查询成功"); resultEntity.setData(breakdown); return
	 * resultEntity; }
	 * 
	 * @Override public ResultEntity completeTrouble(BreakdownInfoExample
	 * breakExample) { ResultEntity resultEntity = new ResultEntity();
	 * List<Breakdown>
	 * breakdown=breakdownInfoMapper.numberTroubleSite(breakExample);
	 * if(breakdown==null) { resultEntity.setCode(ErrorCode.ERROR);
	 * resultEntity.setMsg("查询失败"); } resultEntity.setCode(ErrorCode.SUCCESS);
	 * resultEntity.setMsg("查询成功"); resultEntity.setData(breakdown); return
	 * resultEntity; }
	 */
	public PageResultEntity findCountisById(Date activeTime,Date activeTime2,String windId) {
		PageResultEntity resultEntity = new PageResultEntity();
		/*int count=breakdownInfoMapper.countNumberss(activeTime,activeTime2,windId);
		resultEntity.setTotal(count);*/
		List<BreakdownDetail> breakdownDetail = breakdownInfoMapper.numberTroubleDetail(activeTime,activeTime2,windId);
		if (breakdownDetail == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询失败");
			return resultEntity;
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setMsg("查询成功");
		resultEntity.setRows(breakdownDetail);
		return resultEntity;
	}

	@Override
	public String ExportExcl(String pageType, String countType, Date activeTime, Date activeTime2,
			HttpServletResponse response, String sheetName) throws Exception {
		String fileName=null;
		if ("0".equals(pageType)) {
			if ("1".equals(countType)) {
				List<Breakdown> breakdown = breakdownInfoMapper.numberTroubleSite(activeTime,activeTime2);
				LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
				fieldMap.put("windId", "风电场ID");
				fieldMap.put("windName", "风电场名称");
				fieldMap.put("masterControlSystem", "主控系统");
				fieldMap.put("frequencyConverterSystem", "变频器系统");
				fieldMap.put("cabin", "机舱内");
				fieldMap.put("outsideTheCabin", "机舱外");
				fieldMap.put("yawSystem", "偏航系统");
				fieldMap.put("paddleSystem","变桨系统");
				fieldMap.put("otherEquipment","其他设备");
				fileName=ExcelUtil.Excel(breakdown, fieldMap, sheetName, response);
				}
				
			
			if ("2".equals(countType)) {
				List<Breakdowns> breakdowns = breakdownInfoMapper.numberTrouble(activeTime,activeTime2);
				LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
				fieldMap.put("windId", "风电场ID");
				fieldMap.put("windName", "风电场名称");
				fieldMap.put("mechanicalClass", "机械类");
				fieldMap.put("electricClass", "电气类");
				fieldMap.put("autoControlClass", "自控类");
				fieldMap.put("communicationClass", "通讯类");
				fieldMap.put("supertemperatureClass", "超温类");
				fieldMap.put("hydraulicType","液压类");
				fileName=ExcelUtil.Excel(breakdowns, fieldMap, sheetName, response);
				
			}
			if ("3".equals(countType)) {
				List<Breakdownss> breakdownss = breakdownInfoMapper.completeTrouble(activeTime,activeTime2);
				LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
				fieldMap.put("windId", "风电场ID");
				fieldMap.put("windName", "风电场名称");
				fieldMap.put("numberFailuresActivated", "故障激活数量");
				fieldMap.put("numberFailureRecovery", "故障恢复数量");
				fieldMap.put("failureToRecoverQuantity", "故障未恢复数量");
				fieldMap.put("completionRate", "完成率");
				fileName=ExcelUtil.Excel(breakdownss, fieldMap, sheetName, response);
			}
		} else {

		}
		
		return   fileName;

		
	}
}

