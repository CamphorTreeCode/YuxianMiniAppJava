package com.woman.pojo;

public class Admin {

	private Integer adminId;
	private String adminName;
	private String adminPassword;
	private String adminCrateTime;

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
				+ ", adminCrateTime=" + adminCrateTime + "]";
	}
	
	
}
