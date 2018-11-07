package com.qz.zframe.tally.entity;
/*
保存用户账号等相关信息
 */
public class IscUser {
    //用户id，采用uuid
    private String userId;
    //用户账号
    private String userAccount;
    //用户密码，密文
    private String userPassword;
    //用户姓名
    private String userName;
    //用户性别，对应标准代码USER_SEX
    private String userSex;
    //手机号码
    private String mobile;
    //用户状态，对应标准代码USER_STATUS
    private String userStatus;
    //密码错误次数
    private String pwdErrorCount;
    //是否管理员，对应标准代码YES_OR_NO
    private String isAdmin;
    //创建时间
    private String create_time;
    //锁定时间
    private String lockTime;
    //排序号
    private String orderNo;
    //扩展字段1
    private String extend1;
    //扩展字段2
    private String extend2;
    //扩展字段3
    private String extend3;
    //扩展字段4
    private String extend4;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPwdErrorCount() {
        return pwdErrorCount;
    }

    public void setPwdErrorCount(String pwdErrorCount) {
        this.pwdErrorCount = pwdErrorCount;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLockTime() {
        return lockTime;
    }

    public void setLockTime(String lockTime) {
        this.lockTime = lockTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4;
    }
}
