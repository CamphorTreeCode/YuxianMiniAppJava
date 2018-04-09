package com.woman.pojo;

import java.util.List;

//买卖公司
public class BusinessCompany {
  //卖买公司的id
	private Integer businessCompanyId;
   //内容
	private String businessCompanyContent;
   //	注册公司的名称
	private String businessCompanyName;
	// 注册资本
	private float businessCompanyCapital;
	// 公司注册号
	private String businessCompanyNumber;
	//公司纳税类型 1为一般纳税人 0为小规模
	private Integer businessCompanyPayTaxes;
	//公司成立时间
	private String businessCompanyCreatDate;
	//公司经营范围
	private String businessCompanyRange;
	//公司注册地区
	private String businessCompanyRegion;
	//公司行业
	private String businessCompanyIndustry;
	//公司银行账户  0代表未开基本户 1代表开基本户
	private Integer businessCompanyAccount;
	//公司税务信息 1报道 0不报道
	private Integer businessCompanyTax;
	//公司信息保存 1代表发布， 0代表没有发布编辑箱里
	private Integer businessCompanyState;
	//公司卖发布时间
	private String businessCompanyCreatTime;
	//浏览量
	private Integer businessCompanyBrowse;
	//1为买公司 0为卖公司
	private Integer businessCompany;
	//员工的id 
	private Integer adminId;
	//1是置顶 0不是指定
	private Integer businessCompanyTop;
    //	管理员对象
	private Admin Admin;
   //图片对象
	private List<CompanyImg> companyImg;
	/**
	 * @return businessCompanyId
	 */
	public Integer getBusinessCompanyId() {
		return businessCompanyId;
	}
	/**
	 * @return businessCompanyContent
	 */
	public String getBusinessCompanyContent() {
		return businessCompanyContent;
	}
	/**
	 * @return businessCompanyName
	 */
	public String getBusinessCompanyName() {
		return businessCompanyName;
	}
	/**
	 * @return businessCompanyCapital
	 */
	public float getBusinessCompanyCapital() {
		return businessCompanyCapital;
	}
	/**
	 * @return businessCompanyNumber
	 */
	public String getBusinessCompanyNumber() {
		return businessCompanyNumber;
	}
	/**
	 * @return businessCompanyPayTaxes
	 */
	public Integer getBusinessCompanyPayTaxes() {
		return businessCompanyPayTaxes;
	}
	/**
	 * @return businessCompanyCreatDate
	 */
	public String getBusinessCompanyCreatDate() {
		return businessCompanyCreatDate;
	}
	/**
	 * @return businessCompanyRange
	 */
	public String getBusinessCompanyRange() {
		return businessCompanyRange;
	}
	/**
	 * @return businessCompanyRegion
	 */
	public String getBusinessCompanyRegion() {
		return businessCompanyRegion;
	}
	/**
	 * @return businessCompanyIndustry
	 */
	public String getBusinessCompanyIndustry() {
		return businessCompanyIndustry;
	}
	/**
	 * @return businessCompanyAccount
	 */
	public Integer getBusinessCompanyAccount() {
		return businessCompanyAccount;
	}
	/**
	 * @return businessCompanyTax
	 */
	public Integer getBusinessCompanyTax() {
		return businessCompanyTax;
	}
	/**
	 * @return businessCompanyState
	 */
	public Integer getBusinessCompanyState() {
		return businessCompanyState;
	}
	/**
	 * @return businessCompanyCreatTime
	 */
	public String getBusinessCompanyCreatTime() {
		return businessCompanyCreatTime;
	}
	/**
	 * @return businessCompanyBrowse
	 */
	public Integer getBusinessCompanyBrowse() {
		return businessCompanyBrowse;
	}
	/**
	 * @return businessCompany
	 */
	public Integer getBusinessCompany() {
		return businessCompany;
	}
	/**
	 * @return adminId
	 */
	public Integer getAdminId() {
		return adminId;
	}
	/**
	 * @return businessCompanyTop
	 */
	public Integer getBusinessCompanyTop() {
		return businessCompanyTop;
	}
	/**
	 * @return admin
	 */
	public Admin getAdmin() {
		return Admin;
	}
	/**
	 * @return companyImg
	 */
	public List<CompanyImg> getCompanyImg() {
		return companyImg;
	}
	/**
	 * @param businessCompanyId 要设置的 businessCompanyId
	 */
	public void setBusinessCompanyId(Integer businessCompanyId) {
		this.businessCompanyId = businessCompanyId;
	}
	/**
	 * @param businessCompanyContent 要设置的 businessCompanyContent
	 */
	public void setBusinessCompanyContent(String businessCompanyContent) {
		this.businessCompanyContent = businessCompanyContent;
	}
	/**
	 * @param businessCompanyName 要设置的 businessCompanyName
	 */
	public void setBusinessCompanyName(String businessCompanyName) {
		this.businessCompanyName = businessCompanyName;
	}
	/**
	 * @param businessCompanyCapital 要设置的 businessCompanyCapital
	 */
	public void setBusinessCompanyCapital(float businessCompanyCapital) {
		this.businessCompanyCapital = businessCompanyCapital;
	}
	/**
	 * @param businessCompanyNumber 要设置的 businessCompanyNumber
	 */
	public void setBusinessCompanyNumber(String businessCompanyNumber) {
		this.businessCompanyNumber = businessCompanyNumber;
	}
	/**
	 * @param businessCompanyPayTaxes 要设置的 businessCompanyPayTaxes
	 */
	public void setBusinessCompanyPayTaxes(Integer businessCompanyPayTaxes) {
		this.businessCompanyPayTaxes = businessCompanyPayTaxes;
	}
	/**
	 * @param businessCompanyCreatDate 要设置的 businessCompanyCreatDate
	 */
	public void setBusinessCompanyCreatDate(String businessCompanyCreatDate) {
		this.businessCompanyCreatDate = businessCompanyCreatDate;
	}
	/**
	 * @param businessCompanyRange 要设置的 businessCompanyRange
	 */
	public void setBusinessCompanyRange(String businessCompanyRange) {
		this.businessCompanyRange = businessCompanyRange;
	}
	/**
	 * @param businessCompanyRegion 要设置的 businessCompanyRegion
	 */
	public void setBusinessCompanyRegion(String businessCompanyRegion) {
		this.businessCompanyRegion = businessCompanyRegion;
	}
	/**
	 * @param businessCompanyIndustry 要设置的 businessCompanyIndustry
	 */
	public void setBusinessCompanyIndustry(String businessCompanyIndustry) {
		this.businessCompanyIndustry = businessCompanyIndustry;
	}
	/**
	 * @param businessCompanyAccount 要设置的 businessCompanyAccount
	 */
	public void setBusinessCompanyAccount(Integer businessCompanyAccount) {
		this.businessCompanyAccount = businessCompanyAccount;
	}
	/**
	 * @param businessCompanyTax 要设置的 businessCompanyTax
	 */
	public void setBusinessCompanyTax(Integer businessCompanyTax) {
		this.businessCompanyTax = businessCompanyTax;
	}
	/**
	 * @param businessCompanyState 要设置的 businessCompanyState
	 */
	public void setBusinessCompanyState(Integer businessCompanyState) {
		this.businessCompanyState = businessCompanyState;
	}
	/**
	 * @param businessCompanyCreatTime 要设置的 businessCompanyCreatTime
	 */
	public void setBusinessCompanyCreatTime(String businessCompanyCreatTime) {
		this.businessCompanyCreatTime = businessCompanyCreatTime;
	}
	/**
	 * @param businessCompanyBrowse 要设置的 businessCompanyBrowse
	 */
	public void setBusinessCompanyBrowse(Integer businessCompanyBrowse) {
		this.businessCompanyBrowse = businessCompanyBrowse;
	}
	/**
	 * @param businessCompany 要设置的 businessCompany
	 */
	public void setBusinessCompany(Integer businessCompany) {
		this.businessCompany = businessCompany;
	}
	/**
	 * @param adminId 要设置的 adminId
	 */
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	/**
	 * @param businessCompanyTop 要设置的 businessCompanyTop
	 */
	public void setBusinessCompanyTop(Integer businessCompanyTop) {
		this.businessCompanyTop = businessCompanyTop;
	}
	/**
	 * @param admin 要设置的 admin
	 */
	public void setAdmin(Admin admin) {
		Admin = admin;
	}
	/**
	 * @param companyImg 要设置的 companyImg
	 */
	public void setCompanyImg(List<CompanyImg> companyImg) {
		this.companyImg = companyImg;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
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
				+ ", businessCompanyTop=" + businessCompanyTop + ", Admin=" + Admin + ", companyImg=" + companyImg
				+ "]";
	}
	


}
