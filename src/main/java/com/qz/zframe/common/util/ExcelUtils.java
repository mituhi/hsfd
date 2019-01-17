package com.qz.zframe.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtils {

	public static boolean isBlankRow(Row row, String[] headers) {
		int blankCellCount = 0;
		Cell cell = null;
		String strValue = null;
		for (int i=0; i<headers.length; ++i) {
			cell = row.getCell(i);
			if (cell == null) {
				++blankCellCount;
			} else {
				if (cell.getCellTypeEnum() == CellType.STRING) {
					strValue = cell.getStringCellValue();
					if (StringUtils.isBlank(strValue)) {
						++blankCellCount;
					}
				} else if (cell.getCellTypeEnum() == CellType.BLANK) {
					++blankCellCount;
				}
			}
		}
		return blankCellCount >= headers.length ? true : false;
	}
	
	public static void checkHeader(int r, Row row, String[] headers) throws Exception {
		Cell cell = null;
		String value = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.getCell(i);
			if (cell == null) {
				throw new Exception("第" + (r + 1) + "行第1列为空");
			}
			if (cell.getCellTypeEnum() == CellType.STRING) {
				value = cell.getStringCellValue();
				if (!headers[i].equals(value)) {
					throw new Exception("第" + (r + 1) + "行第" + (i + 1) + "列的内容不是'" + headers[i] + "'");
				}
			} else {
				throw new Exception("第" + (r + 1) + "行第" + (i + 1) + "列类型不是字符串");
			}
		}
	}

	public static String getCellStringValue(Row row, int idx) {
		Cell cell = row.getCell(idx);
		if (cell != null) {
			if (1 == cell.getCellType()) {
				String value = cell.getStringCellValue();
				if (StringUtils.isNotBlank(value)) {
					return value;
				}
			} else {
				if (cell.getCellType() == 0) {
					return String.valueOf(cell.getNumericCellValue());
				}
				if (3 == cell.getCellType()) {
					return null;
				}
				String value = cell.getStringCellValue();
				if (StringUtils.isNotBlank(value)) {
					return value;
				}
			}
		}
		return null;
	}

	public static Integer getCellIntValue(Row row, int idx) {
		Cell cell = row.getCell(idx);
		if (cell != null) {
			if (cell.getCellType() == 0) {
				return Integer.valueOf((int) cell.getNumericCellValue());
			}
			String value = cell.getStringCellValue();
			if (StringUtils.isNotBlank(value)) {
				try {
					return Integer.valueOf(Integer.parseInt(value));
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return null;
	}

	public static Double getCellDoubleValue(Row row, int idx) {
		Cell cell = row.getCell(idx);
		if (cell != null) {
			if (cell.getCellType() == 0) {
				return Double.valueOf(cell.getNumericCellValue());
			}
			String value = cell.getStringCellValue();
			if (StringUtils.isNotBlank(value)) {
				try {
					return Double.valueOf(Double.parseDouble(value));
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return null;
	}

	public static Date getCellDateValue(Row row, int idx, SimpleDateFormat Fmt) {
		Date d = null;
		Cell cell = row.getCell(idx);
		if (cell != null) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				d = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
			} else {
				try {
					d = Fmt.parse(cell.getStringCellValue());
				} catch (ParseException e) {
					d = null;
				}
			}
		}
		if (d != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			if (c.get(1) < 2000) {
				d = null;
			}
		}
		return d;
	}
	
	public static ResultEntity checkHeader1(int r, Row row, String[] headers) throws Exception {
		ResultEntity  resultEntity=new ResultEntity();
		Cell cell = null;
		String value = null;
		for (int i = 0; i < headers.length; i++) {
			cell = row.getCell(i);
			if (cell == null) {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("第" + (r + 1) + "行第1列为空");
				return resultEntity;
				/*throw new Exception("第" + (r + 1) + "行第1列为空"a);*/
			}
			if (cell.getCellTypeEnum() == CellType.STRING) {
				value = cell.getStringCellValue();
				if (!headers[i].equals(value)) {
					resultEntity.setCode(ErrorCode.ERROR);
					resultEntity.setMsg("第" + (r + 1) + "行第" + (i + 1) + "列的内容不是'" + headers[i] + "'");
					return resultEntity;
					//throw new Exception("第" + (r + 1) + "行第" + (i + 1) + "列的内容不是'" + headers[i] + "'");
				}
			} else {
				resultEntity.setCode(ErrorCode.ERROR);
				resultEntity.setMsg("第" + (r + 1) + "行第" + (i + 1) + "列类型不是字符串");
				return resultEntity;
				//throw new Exception("第" + (r + 1) + "行第" + (i + 1) + "列类型不是字符串");
			}
		}
		resultEntity.setCode(ErrorCode.SUCCESS);
		return resultEntity;
	}
}
