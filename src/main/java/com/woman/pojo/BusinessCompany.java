package com.woman.pojo;

import java.util.List;

//买卖公司
public class BusinessCompany {
  //卖买公司的id
	private int businessCompanyId;
   //内容
	private String businessCompanyContent;
   //	注册公司的名称
	private String businessCompanyName;
	// 注册资本
	private float businessCompanyCapital;
	// 公司注册号
	private String businessCompanyNumber;
	//公司纳税类型 1为一般纳税人 0为小规模
	private int businessCompanyPayTaxes;
	//公司成立时间
	private String businessCompanyCreatDate;
	//公司经营范围
	private String businessCompanyRange;
	//公司注册地区
	private String businessCompanyRegion;
	//公司行业
	private String businessCompanyIndustry;
	//公司银行账户  0代表未开基本户 1代表开基本户
	private int businessCompanyAccount;
	//公司税务信息 1报道 0不报道
	private int businessCompanyTax;
	//公司信息保存 1代表发布， 0代表没有发布编辑箱里
	private int businessCompanyState;
	//公司卖发布时间
	private String businessCompanyCreatTime;
	//浏览量
	private int businessCompanyBrowse;
	//1为买公司 0为卖公司
	private int businessCompany;
	//员工的id 
	private int adminId;
	//1是置顶 0不是指定
	private int businessCompanyTop;

	//公司出售获得中的轮播图

    //	管理员对象
	private Admin Admin;
   //图片对象
	private List<CompanyImg> company;
	
	public List<CompanyImg> getCompany() {
		return company;
	}
	public void setCompany(List<CompanyImg> company) {
		this.company = company;
	}
	public Admin getAdmin() {
		return Admin;
	}
	public void setAdmin(Admin admin) {
		Admin = admin;
	}
	public int getBusinessCompanyId() {
		return businessCompanyId;
	}
	public String getBusinessCompanyContent() {
		return businessCompanyContent;
	}
	public String getBusinessCompanyName() {
		return businessCompanyName;
	}
	public float getBusinessCompanyCapital() {
		return businessCompanyCapital;
	}
	public String getBusinessCompanyNumber() {
		return businessCompanyNumber;
	}
	public int getBusinessCompanyPayTaxes() {
		return businessCompanyPayTaxes;
	}
	public String getBusinessCompanyCreatDate() {
		return businessCompanyCreatDate;
	}
	public String getBusinessCompanyRange() {
		return businessCompanyRange;
	}
	public String getBusinessCompanyRegion() {
		return businessCompanyRegion;
	}
	public String getBusinessCompanyIndustry() {
		return businessCompanyIndustry;
	}
	public int getBusinessCompanyAccount() {
		return businessCompanyAccount;
	}
	public int getBusinessCompanyTax() {
		return businessCompanyTax;
	}
	public int getBusinessCompanyState() {
		return businessCompanyState;
	}
	public String getBusinessCompanyCreatTime() {
		return businessCompanyCreatTime;
	}
	public int getBusinessCompanyBrowse() {
		return businessCompanyBrowse;
	}
	public int getBusinessCompany() {
		return businessCompany;
	}
	public int getAdminId() {
		return adminId;
	}
	public int getBusinessCompanyTop() {
		return businessCompanyTop;
	}
	public void setBusinessCompanyId(int businessCompanyId) {
		this.businessCompanyId = businessCompanyId;
	}
	public void setBusinessCompanyContent(String businessCompanyContent) {
		this.businessCompanyContent = businessCompanyContent;
	}
	public void setBusinessCompanyName(String businessCompanyName) {
		this.businessCompanyName = businessCompanyName;
	}
	public void setBusinessCompanyCapital(float businessCompanyCapital) {
		this.businessCompanyCapital = businessCompanyCapital;
	}
	public void setBusinessCompanyNumber(String businessCompanyNumber) {
		this.businessCompanyNumber = businessCompanyNumber;
	}
	public void setBusinessCompanyPayTaxes(int businessCompanyPayTaxes) {
		this.businessCompanyPayTaxes = businessCompanyPayTaxes;
	}
	public void setBusinessCompanyCreatDate(String businessCompanyCreatDate) {
		this.businessCompanyCreatDate = businessCompanyCreatDate;
	}
	public void setBusinessCompanyRange(String businessCompanyRange) {
		this.businessCompanyRange = businessCompanyRange;
	}
	public void setBusinessCompanyRegion(String businessCompanyRegion) {
		this.businessCompanyRegion = businessCompanyRegion;
	}
	public void setBusinessCompanyIndustry(String businessCompanyIndustry) {
		this.businessCompanyIndustry = businessCompanyIndustry;
	}
	public void setBusinessCompanyAccount(int businessCompanyAccount) {
		this.businessCompanyAccount = businessCompanyAccount;
	}
	public void setBusinessCompanyTax(int businessCompanyTax) {
		this.businessCompanyTax = businessCompanyTax;
	}
	public void setBusinessCompanyState(int businessCompanyState) {
		this.businessCompanyState = businessCompanyState;
	}
	public void setBusinessCompanyCreatTime(String businessCompanyCreatTime) {
		this.businessCompanyCreatTime = businessCompanyCreatTime;
	}
	public void setBusinessCompanyBrowse(int businessCompanyBrowse) {
		this.businessCompanyBrowse = businessCompanyBrowse;
	}
	public void setBusinessCompany(int businessCompany) {
		this.businessCompany = businessCompany;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setBusinessCompanyTop(int businessCompanyTop) {
		this.businessCompanyTop = businessCompanyTop;
	}
	@Override
	public String toString() {
		return "BusinessCompany [businessCompanyId=" + businessCompanyId + ", businessCompanyContent="
				+ businessCompanyContent + ", businessCompanyName=" + businessCompanyName + ", businessCompanyCapital="
				+ businessCompanyCapital + ", businessCompanyNumber=" + businessCompanyNumber
				+ ", businessCompanyPayTaxes=" + businessCompanyPayTaxes + ", businessCompanyCreatDate="
				+ businessCompanyCreatDate + ", businessCompanyRange=" + businessCompanyRange
				+ ", businessCompanyRegion=" + businessCompanyRegion + ", businessCompanyIndustry="
				+ businessCompanyIndustry + ", businessCompanyAccount=" + businessCompanyAccount
				+ ", businessCompanyTax=" + businessCompanyTax + ", businessCompanyState=" + businessCompanyState
				+ ", businessCompanyCreatTime=" + businessCompanyCreatTime + ", businessCompanyBrowse="
				+ businessCompanyBrowse + ", businessCompany=" + businessCompany + ", adminId=" + adminId
				+ ", businessCompanyTop=" + businessCompanyTop + ", Admin=" + Admin + ", company=" + company + "]";
	}


}
