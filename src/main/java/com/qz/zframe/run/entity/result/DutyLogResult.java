package com.qz.zframe.run.entity.result;

import java.util.List;

/**
 * <p>Title: DutyLogResult</p>
 * <p>@Description: 值班日志表中    值班信息表初始化返回结果封装类 </p>
 * @author 
 * @date 2018年11月8日 下午3:24:22
 * @version:V1.0
 */
public class DutyLogResult {
	
	private String valueName;
	
	private List<String> userIds;
	
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	
	

}
