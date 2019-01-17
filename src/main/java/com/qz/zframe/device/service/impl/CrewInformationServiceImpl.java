package com.qz.zframe.device.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtil;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.RegexUtils;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.CrewInformationMapper;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.entity.CrewInformation;
import com.qz.zframe.device.entity.CrewInformationExample;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.service.CrewInformationService;

@Service
@Transactional(rollbackFor = Exception.class)
public class CrewInformationServiceImpl implements CrewInformationService {
	@Autowired
	private CrewInformationMapper crewInformationMapper;
	@Autowired
	private EquipmentLogMapper  equipmentLogMapper;
	@Autowired
    private CurrentUserService currentUserService;
	@Override
	public PageResultEntity findCrew(CrewInformationExample crewExample) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = crewInformationMapper.countByExample(crewExample);
		resultEntity.setTotal(count);
		List<CrewInformation> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list =crewInformationMapper.selectByExample(crewExample);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
			resultEntity.setMsg("机组信息查询成功!");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity addCrew(CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		if(crew!=null) {
			boolean check=RegexUtils.checkChinese(crew.getCrewCode());
			if(check==true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("机组编码不能为汉字");
				return resultEntity;
			}
			boolean  checks=RegexUtils.check(crew.getCrewCode());
			if(checks==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}	
			CrewInformation cr=crewInformationMapper.selectByCrewCode(crew.getCrewCode());
			if(cr!=null ) {
				if(!crew.getCrewId().equals(cr.getCrewId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("机组编码已经存在请重新填入");
				return resultEntity;
				}
			}
		String crewId=UUIdUtil.getUUID();
		crew.setCrewId(crewId);
		crew.setCreater(currentUserService.getId());
		crew.setCreatDate(new Date());
		
		int save = crewInformationMapper.insert(crew);
		if (save == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("新增失败");
			return resultEntity;
		} else {
			
			EquipmentLog  log=new EquipmentLog();
			log.setDate(new Date());
			log.setUserId(currentUserService.getId());
			log.setUserName(currentUserService.getUsername());
			log.setFuncation("新增机组信息");
			log.setLogId(UUIdUtil.getUUID());
			log.setModuleId(crewId);
		    equipmentLogMapper.insertAdd(log);
			
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("新增成功");
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要新增");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updateCrew(CrewInformation crew) {
		ResultEntity resultEntity = new ResultEntity();
		if(crew!=null) {
		boolean check=RegexUtils.checkChinese(crew.getCrewCode());
			if(check==true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("机组编码不能为汉字");
				return resultEntity;
			}
			boolean  checks=RegexUtils.check(crew.getCrewCode());
			if(checks==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}	
		CrewInformation crews = crewInformationMapper.selectByPrimaryKey(crew.getCrewId());
		if (crews == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("数据源中没有这条数据");
		} else {
			CrewInformation cr=crewInformationMapper.selectByCrewCode(crew.getCrewCode());
			if(cr!=null ) {
				if(!crew.getCrewId().equals(cr.getCrewId())) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("位置编码已经存在,请重新填写");
					return resultEntity;
				}
			}
		    crew.setCreatDate(crews.getCreatDate());
		    crew.setCreater(crews.getCreater());
		    crew.setCreaterName(crews.getCreaterName());
			int save = crewInformationMapper.update(crew);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("修改失败");
				return resultEntity;
			} else {
				
				EquipmentLog  log=new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("修改机组信息");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(crew.getCrewId());
			    equipmentLogMapper.insertAdd(log);
			    
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("修改成功");
			}
		}
		}else {
			
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要修改");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByCrewId(String crewId) {
		PageResultEntity resultEntity = new PageResultEntity();
		List<CrewInformation> list = new ArrayList<CrewInformation>();
		CrewInformation crews = crewInformationMapper.selectByPrimaryKey(crewId);
		if (crews == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
			return resultEntity;
		} else {
			list.add(crews);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		return resultEntity;
	}

	@Override
	public ResultEntity deleteCrew(List<String> crewIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(crewIds!=null && !crewIds.isEmpty()) {
		int delete = crewInformationMapper.deleteByPrimaryKeyList(crewIds);
		 if (delete < 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		 } else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		 }
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据进行删除");
			return resultEntity;
		}
		return resultEntity;
	}

	public String ExportExcl(CrewInformationExample crewExample,HttpServletResponse response,String sheetName) throws Exception {
		//ResultEntity resultEntity = new ResultEntity();
		List<CrewInformation> list=crewInformationMapper.select(crewExample);;
		LinkedHashMap<String, String> fieldMap=new  LinkedHashMap<String, String>();
		//CrewInformation c=new CrewInformation();
		fieldMap.put("crewId", "机组信息标识");
		fieldMap.put("crewCode", "机组编码");
		fieldMap.put("crewName", "机组名称");
		fieldMap.put("windName", "所属风电场");
		fieldMap.put("installedCapacity", "装机容量");
		fieldMap.put("enableDates", "启用时间");
		fieldMap.put("createrName","创建人名称");
		fieldMap.put("creatDates","创建时间");
		String file= ExcelUtil.Excel(list, fieldMap, sheetName, response);
		//resultEntity.setData(file);
		return  file;
	}

}
