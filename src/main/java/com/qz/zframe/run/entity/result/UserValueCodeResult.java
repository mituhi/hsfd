package com.qz.zframe.run.entity.result;

import com.qz.zframe.tally.entity.IscUser;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UserValueCodeResult {

	@ApiModelProperty(value="用户id",name="userId")
	private String userId;

	@ApiModelProperty(value="值次Id",name="valueCode")
	private String valueTimeId;

	@ApiModelProperty(value="用户具体信息",name="users")
	private List<IscUser> users;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getValueTimeId() {
		return valueTimeId;
	}

	public void setValueTimeId(String valueTimeId) {
		this.valueTimeId = valueTimeId;
	}

	public List<IscUser> getUsers() {
		return users;
	}

	public void setUsers(List<IscUser> users) {
		this.users = users;
	}
}
