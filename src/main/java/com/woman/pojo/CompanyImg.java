package com.woman.pojo;
//买卖公司的图片的集合
public class CompanyImg {

	//图片的id
	private int companyImgId;
	//图片的地址
	private String companyUrl;
     //	图片的创建时间
	private String companyCreatTime;
	//卖公司的id
	private int businessCompanyId;
	public int getCompanyImgId() {
		return companyImgId;
	}
	public String getCompanyUrl() {
		return companyUrl;
	}
	public String getCompanyCreatTime() {
		return companyCreatTime;
	}
	public int getBusinessCompanyId() {
		return businessCompanyId;
	}
	public void setCompanyImgId(int companyImgId) {
		this.companyImgId = companyImgId;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	public void setCompanyCreatTime(String companyCreatTime) {
		this.companyCreatTime = companyCreatTime;
	}
	public void setBusinessCompanyId(int businessCompanyId) {
		this.businessCompanyId = businessCompanyId;
	}
	@Override
	public String toString() {
		return "CompanyImg [companyImgId=" + companyImgId + ", companyUrl=" + companyUrl + ", companyCreatTime="
				+ companyCreatTime + ", businessCompanyId=" + businessCompanyId + "]";
	}
	
	
}
