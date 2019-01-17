package com.qz.zframe.run.entity.result;

import java.util.List;

import com.qz.zframe.run.entity.DutyInfo;
import com.qz.zframe.run.entity.DutyLog;
import com.qz.zframe.run.entity.DutyLogTab;
import com.qz.zframe.run.entity.DutyRemember;

/**
 * <p>Title: DutyLogUpdateResult</p>
 * <p>@Description: 值班日志更新： 结果封装类： 给前台展示 </p>
 * @author 
 * @date 2018年11月16日 下午3:56:23
 * @version:V1.0
 */
public class DutyLogUpdateResult {

	private DutyLog dutyLog;
	private List<DutyRemember> dutyRemembers;
	private DutyInfo dutyInfo;
	private List<DutyLogTab> dutyLogTabs;

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

	public List<DutyLogTab> getDutyLogTabs() {
		return dutyLogTabs;
	}

	public void setDutyLogTabs(List<DutyLogTab> dutyLogTabs) {
		this.dutyLogTabs = dutyLogTabs;
	}
	
}
