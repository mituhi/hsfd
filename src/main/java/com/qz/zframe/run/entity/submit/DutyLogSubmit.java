package com.qz.zframe.run.entity.submit;

import java.util.List;

import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyRemember;

/**
 * <p>Title: DutyLogSubmit</p>
 * <p>@Description: 值班日志配置页面添加提交封装类 </p>
 * @author 
 * @date 2018年11月8日 下午4:01:34
 * @version:V1.0
 */
public class DutyLogSubmit {

	private DutyLog dutyLog;
	
	private List<DutyRemember> dutyRemembers;
	
	private DutyInfo dutyInfo;

	public DutyLog getDutyLog() {
		return dutyLog;
	}

	public void setDutyLog(DutyLog dutyLog) {
		this.dutyLog = dutyLog;
	}

	public List<DutyRemember> getDutyRemembers() {
		return dutyRemembers;
	}

	public void setDutyRemembers(List<DutyRemember> dutyRemembers) {
		this.dutyRemembers = dutyRemembers;
	}

	public DutyInfo getDutyInfo() {
		return dutyInfo;
	}

	public void setDutyInfo(DutyInfo dutyInfo) {
		this.dutyInfo = dutyInfo;
	}

	

}
