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






}
