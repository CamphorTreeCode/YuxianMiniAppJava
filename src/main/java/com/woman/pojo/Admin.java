package com.woman.pojo;

public class Admin {
     //自增id
	private Integer adminId;
	//用户名帐号
	private String adminName;
    //密码
	private String adminPassword;
	//管理员创建的时间
	private String adminCrateTime;
	//头像
	private String adminImgUrl;
	//昵称
	private String  adminNickName;
     //电话
	private String adminPhone;
	//请求接口的集合 可以用数组接受
	private String adminAction;
	//0代表超级管理员 1代表普通员工
	private int adminState;
	
	public String getAdminImgUrl() {
		return adminImgUrl;
	}
	public String getAdminNickName() {
		return adminNickName;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public String getAdminAction() {
		return adminAction;
	}
	public int getAdminState() {
		return adminState;
	}
	public void setAdminImgUrl(String adminImgUrl) {
		this.adminImgUrl = adminImgUrl;
	}
	public void setAdminNickName(String adminNickName) {
		this.adminNickName = adminNickName;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public void setAdminAction(String adminAction) {
		this.adminAction = adminAction;
	}
	public void setAdminState(int adminState) {
		this.adminState = adminState;
	}
	public Admin() {
		super();
	}
	public Admin(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminCrateTime() {
		return adminCrateTime;
	}
	public void setAdminCrateTime(String adminCrateTime) {
		this.adminCrateTime = adminCrateTime;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminCrateTime=" + adminCrateTime + ", adminImgUrl=" + adminImgUrl + ", adminNickName="
				+ adminNickName + ", adminPhone=" + adminPhone + ", adminAction=" + adminAction + ", adminState="
				+ adminState + "]";
	}

	
	
}
