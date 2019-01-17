package com.qz.zframe.tickets.vo;

import com.qz.zframe.tickets.entity.UserAssoInfo;

public class UserAssoVo extends UserAssoInfo {

    private String companyName;

    private String departmentName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
