package com.qz.zframe.device.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qz.zframe.authentication.CurrentUserService;
import com.qz.zframe.code.annotation.CodeConvert;
import com.qz.zframe.code.annotation.CodeType;
import com.qz.zframe.common.util.ErrorCode;
import com.qz.zframe.common.util.ExcelUtils;
import com.qz.zframe.common.util.PageResultEntity;
import com.qz.zframe.common.util.RegexUtils;
import com.qz.zframe.common.util.ResultEntity;
import com.qz.zframe.common.util.UUIdUtil;
import com.qz.zframe.device.dao.EquipmentLogMapper;
import com.qz.zframe.device.dao.PositionEncodeMapper;
import com.qz.zframe.device.entity.EquipmentLog;
import com.qz.zframe.device.entity.PositionEncode;
import com.qz.zframe.device.entity.PositionEncodeExample;
import com.qz.zframe.device.service.PositionEncodeService;
import com.qz.zframe.tally.entity.QrCode;
@Service
@Transactional(rollbackFor = Exception.class)
public class PositionEncodeServiceImpl implements PositionEncodeService {
	@Autowired
	private PositionEncodeMapper positionMapper;
	@Autowired
	private EquipmentLogMapper equipmentLogMapper;
	@Autowired
	private CurrentUserService currentUserService;

	@Override
	public PageResultEntity findPosition(PositionEncodeExample position) {
		PageResultEntity resultEntity = new PageResultEntity();
		int count = positionMapper.countByExample(position);
		resultEntity.setTotal(count);
		List<PositionEncode> list;
		if (count == 0) {
			list = Collections.emptyList();
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果为空");
			resultEntity.setRows(list);
			return resultEntity;
		} else {
			list = positionMapper.selectByExample(position);
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		resultEntity.setRows(list);
		return resultEntity;
	}

	@Override
	public ResultEntity addPosition(PositionEncode positionEncode) {
		ResultEntity resultEntity = new ResultEntity();
		if (positionEncode != null) {
			boolean check=RegexUtils.checkChinese(positionEncode.getPositionCode());
			boolean  checks=RegexUtils.check(positionEncode.getPositionCode());
			if(check==true) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("位置编码不能为汉字");
				return resultEntity;
			}
			if(checks==false) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
				return resultEntity;
			}
			PositionEncode  p=positionMapper.selectByPositionCode(positionEncode.getPositionCode());
			if(p!=null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("位置编码已经存在,请重新填写");
				return resultEntity;
			}
			String positionId = UUIdUtil.getUUID();
			positionEncode.setPositionId(positionId);
			positionEncode.setCreateTime(new Date());
			if ("02".equals(positionEncode.getIsToplevel())) {
				PositionEncode position =positionMapper.selectByPrimaryKey(positionEncode.getSuperiorPosition());
				positionEncode.setSuperiorPositionName(position.getPositionName());
			}
			
			int save = positionMapper.insert(positionEncode);
			if (save == 0) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("新增失败");
				return resultEntity;
			} else {
				
				EquipmentLog log = new EquipmentLog();
				log.setDate(new Date());
				log.setUserId(currentUserService.getId());
				log.setUserName(currentUserService.getUsername());
				log.setFuncation("新增位置信息");
				log.setLogId(UUIdUtil.getUUID());
				log.setModuleId(positionId);
				equipmentLogMapper.insertAdd(log);
				
				resultEntity.setCode(ErrorCode.SUCCESS);
				resultEntity.setMsg("新增成功");
			}
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要新增");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity updatePosition(PositionEncode positionEncode) {
		ResultEntity resultEntity = new ResultEntity();
		if (positionEncode != null) {
			if (StringUtils.isBlank(positionEncode.getPositionId())) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("位置id为空");
				return resultEntity;
			} else {
				PositionEncode position =selectByPositionId(positionEncode.getPositionId());
				
				if (position == null) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("数据源中没有这条数据");
					return resultEntity;
				} else {
					boolean check=RegexUtils.checkChinese(positionEncode.getPositionCode());
					if(check==true) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("位置编码不能为汉字");
						return resultEntity;
					}
					boolean  checks=RegexUtils.check(positionEncode.getPositionCode());
					if(checks==false) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("填入的编码不符合要求，只能输入字母加数字");
						return resultEntity;
					}
					PositionEncode  p=positionMapper.selectByPositionCode(positionEncode.getPositionCode());
					if(p!=null) {
						if(!positionEncode.getPositionId().equals(p.getPositionId())) {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("位置编码已经存在,请重新填写");
							return resultEntity;
						
						}
					}
					
			      if ("02".equals(positionEncode.getIsToplevel())) {
						if (StringUtils.isNotBlank(positionEncode.getSuperiorPosition())) {
							PositionEncode equip =
									positionMapper.selectByPrimaryKey(positionEncode.getSuperiorPosition());
							if (equip != null) {
								positionEncode.setSuperiorPositionName(equip.getPositionName());
							}

						} else {
							resultEntity.setCode(ErrorCode.ERROR);
							resultEntity.setMsg("上级位置未选择");
							return resultEntity;
						}
					} else {
						/*positionEncode.setSuperiorPositionName(position.getSuperiorPositionName());
						positionEncode.setSuperiorPosition(position.getSuperiorPosition());*/
						positionEncode.setSuperiorPosition(null);
						positionEncode.setSuperiorPositionName(null);
					}
			        
					positionEncode.setCreateTime(position.getCreateTime());
					int save = positionMapper.updateByPrimaryKey(positionEncode);
					if (save == 0) {
						resultEntity.setCode(ErrorCode.ERROR);
						resultEntity.setMsg("修改失败");
						return resultEntity;
					} else {
						
						EquipmentLog log = new EquipmentLog();
						log.setDate(new Date());
						log.setUserId(currentUserService.getId());
						log.setUserName(currentUserService.getUsername());
						log.setFuncation("修改位置信息");
						log.setLogId(UUIdUtil.getUUID());
						log.setModuleId(positionEncode.getPositionId());
						equipmentLogMapper.insertAdd(log);
						
						resultEntity.setCode(ErrorCode.SUCCESS);
						resultEntity.setMsg("修改成功");
					}
				}
			}
			}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("没有数据需要修改");
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findByPositionId(String positionId) {
		PageResultEntity resultEntity = new PageResultEntity();
		if(StringUtils.isNotBlank(positionId)) {
		List<PositionEncode> list = new ArrayList<PositionEncode>();
		PositionEncode position =selectByPositionId(positionId);
		if (position == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("查询结果有误");
			return resultEntity;
		} else {
			list.add(position);
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("根据ID查询数据,Id为空");
			return resultEntity;
		}
		return resultEntity;
	}
	
	
	
	
	@CodeConvert({
		@CodeType(codeType="POSITION_STATUS", nameField="status", titleField="statusName"),
		@CodeType(codeType="IS_TOPLEVEL", nameField="isToplevel", titleField="isToplevelName"),
		@CodeType(codeType="HIERARCHY_TYPE", nameField="hierarchy", titleField="hierarchyName")
	})
	public  PositionEncode selectByPositionId(String positionId) {
		return positionMapper.selectByPrimaryKey(positionId);
	}
	
	
	
	@Transactional
	public ResultEntity deletePositions(List<String> positionIds) {
		ResultEntity resultEntity = new ResultEntity();
		if(positionIds!=null && !positionIds.isEmpty()) {
			for(String p:positionIds) {
			PositionEncode position=positionMapper.selectByPrimaryKey(p);
			if(position.getIsToplevel().equals("01")) {
				List<PositionEncode>  list=positionMapper.selectStructureList(position.getPositionId());
				if(list!=null && !list.isEmpty() && !list.equals("")) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("部分数据有下级关系，不能删除");
					return resultEntity;
				}
			}	
			}
		int delete=0;
		for(String po:positionIds) {
		   PositionEncode positions=positionMapper.selectByPrimaryKey(po);
		   positions.setStatus("02");
		   delete=positionMapper.updateByPrimaryKey(positions);
		}
		/*int delete = positionMapper.deleteByPrimaryKeyList(positionIds);*/
		if (delete == 0) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("删除失败");
			return resultEntity;
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setMsg("删除成功");
		}
		}else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("未选中数据删除");
			return resultEntity;
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructure() {
		PageResultEntity resultEntity = new PageResultEntity();

		List<PositionEncode> top = positionMapper.selectStructures();
		if (top == null) {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("还未创建顶层设备分类");
		} else {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(top);
		}
		return resultEntity;
	}

	@Override
	public PageResultEntity findStructureList(String positionId) {
		PageResultEntity resultEntity = new PageResultEntity();

		List<PositionEncode> list = positionMapper.selectStructureList(positionId);
		if (list != null) {
			resultEntity.setCode(ErrorCode.SUCCESS);
			resultEntity.setRows(list);
		} else {
			resultEntity.setCode(ErrorCode.ERROR);
			resultEntity.setMsg("还未创建设备分类");
		}
		return resultEntity;
	}

	@Override
	public ResultEntity importBook(String fileName, InputStream in) throws Exception {
		ResultEntity resultEntity=new ResultEntity();
		Workbook wb=null;
			String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
			if ("xls".equals(extension)) {
				wb = new HSSFWorkbook(in);
			} else if ("xlsx".equals(extension)) {
				wb = new XSSFWorkbook(in);
			} else {
				try {
					if (in != null)
						in.close();
				} catch (IOException localIOException) {
				}
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("不支持的文件类型! 目前只支持xls或xlsx后缀名的Excel文件!");
				return resultEntity;
			}
			List<PositionEncode>  positionEncode=new ArrayList<PositionEncode>();
			//查询数据库里现在有的位置信息
			List<PositionEncode>  posit=positionMapper.selectAll();
			//存放位置编码的list集合
			List<String> code=new ArrayList<String>();
			if(posit!=null && !posit.isEmpty()) {
				for(PositionEncode p: posit) {
					code.add(p.getPositionCode());
				}
				
			}
			int i = 0;
			int r = 0;
			String value = null;
			Cell cell = null;
			String[] headers = {"位置编码","位置名称","风电场编码","部门","维护班组","层级","是否顶级","上级位置","状态","机组"};
			Sheet sheet1 = wb.getSheetAt(0);
			for (Row row : sheet1) {
				i = 0;
				if (r == 0) {
					ExcelUtils.checkHeader(r, row, headers);
				} else {
					if (ExcelUtils.isBlankRow(row, headers))
						continue;

					PositionEncode  positionBook=new PositionEncode();
					// 位置编码
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							for(String  c:code) {
								if(c.equals(value)) {
									resultEntity.setCode(ErrorCode.ERROR);
									resultEntity.setMsg("编码已存在,请检查文件");
									return resultEntity;	
								}
								
							}
						}
						    positionBook.setPositionId(value);
							positionBook.setPositionCode(value);
						}
					// 位置名称
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setPositionName(value);
						}
					}
					// 风电场编码
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setWindId(value);
						}
					}
					// 部门
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setDepartment(value);
						}else {
							positionBook.setDepartment(null);
						}
					}else {
						positionBook.setDepartment(null);
					}
					// 维护班组
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setMaintenanceTeam(value);
						}else {
							positionBook.setMaintenanceTeam(null);
						}
					}else {
						positionBook.setMaintenanceTeam(null);
					}
					// 层级
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setHierarchy(value);
						}
					}
					// 是否顶级
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setIsToplevel(value);
						}
					}
					//上级位置
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setSuperiorPosition(value);
						}else {
							positionBook.setSuperiorPosition(null);
							positionBook.setSuperiorPositionName(null);
						}
					}else {
						positionBook.setSuperiorPosition(null);
						positionBook.setSuperiorPositionName(null);
					}
					//状态
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setStatus(value);
						}
					}
					//机组
					cell = row.getCell(i++);
					if (cell != null) {
						value = cell.getStringCellValue();
						if (StringUtils.isNotBlank(value)) {
							positionBook.setCrew(value);
						}else {
							positionBook.setCrew(null);
						}
					}else {
						 positionBook.setCrew(null);
					}
					positionEncode.add(positionBook);
	         }	
				r++;
	}
			List<PositionEncode> position=positionEncode;
			for(PositionEncode  p:positionEncode) {
				if(StringUtils.isNotBlank(p.getSuperiorPosition())) {
					for(PositionEncode pe:position) {
						if(p.getSuperiorPosition().equals(pe.getPositionId())) {
							p.setSuperiorPositionName(pe.getPositionName());
						}
					}
				}
				 p.setCreateTime(new Date());
			}
			int save=0;
			for(PositionEncode  pe:positionEncode) {
				save=positionMapper.insert(pe);
				save++;
			}
			if(save==0) {
				resultEntity.setCode(ErrorCode.ERROR);
				 resultEntity.setMsg("导入出错，请检查文件");
				 return resultEntity;
				}else {
				 resultEntity.setCode(ErrorCode.SUCCESS);
				 resultEntity.setMsg("导入成功");
				}
	
	    return resultEntity;
	}

}
