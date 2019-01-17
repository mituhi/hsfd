package com.qz.zframe.device.service;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.qz.zframe.common.util.PageResultEntity;
public interface CountifService {
    //按故障位置发生次数统计
	public PageResultEntity findCountis(String pageType,String countType,Date activeTime,Date activeTime2);
	/*//按故障属性发生次数统计
	public ResultEntity numberTrouble(BreakdownInfoExample breakExample);
    // 按完成率统计
	public ResultEntity completeTrouble(BreakdownInfoExample breakExample);*/
	//查询单个风电场的统计信息
	public PageResultEntity findCountisById(Date activeTime,Date activeTime2,String windId);
	
	public String ExportExcl(String pageType,String countType,Date activeTime,Date activeTime2,HttpServletResponse response,String sheetName) throws Exception;
}
