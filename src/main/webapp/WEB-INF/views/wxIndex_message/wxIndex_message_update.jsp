<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>申肃后台</title>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  </head>
   <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
   <script src="js/icheck.js"></script>
   <script src="js/distpicker.data.js"></script>
   <script src="js/distpicker.js"></script>
   <script src="js/main.js"></script>
   <script type="text/javascript" src="js/wxIndex_message_sell_add.js"></script>
   <link rel="stylesheet" href="skins/all.css" type="text/css" />
   <link rel="stylesheet" href="css/wxIndex_message_sell_add.css" type="text/css" />
   <link href="css/bootstrap.css" rel="stylesheet">
   <script type="text/javascript">
     $(function(){
           $(document).ready(function(){
              $('input').each(function(){
                 if($(this).prop("checked")){
                     
                     $(this).parent().parent().parent().css("color","#1897DA")
                 }
              
              })
            })
           
        //修改页面获取地区
	var addre=$("[name=addre]").val()
	if(addre!="undefined"){
	    var addressList= addre.split("-")
		$("#address").distpicker({
		   province: addressList[0],
		   city: addressList[1],
		   district: addressList[2]
	     });
	}
     
     
     })
   </script>
<body>
   <form method="post" enctype="multipart/form-data" action="../wxIndex_message/update" class="form-inline">
      <input type="hidden" name="token" value="${token}" />
      <input type="hidden" value="${sessionScope.user.adminId}" name="adminId">
      <input type="hidden" value="${buc.businessCompanyId }" name="businessCompanyId">
      <input type="hidden" value="${b}" name="businessCompany"> 
      <input type="hidden" value="${buc.businessCompanyRegion }" name="addre"/>
      
      <div class="content">
          <div class="noticeImg">
             <div class="img"><div class="icon"></div>上传图片</div>
             <div>
                <div class="view">
                  <c:forEach items="${imgList }" var="i">
                  <div class="viewimg">
                     <img class="preview" src="${i.companyUrl}"/>
                     <div class="addIcon"><input type="file" name="file" class="file" /></div>
                     <div class="del" style="display:none"></div>
                     <input type="hidden" name="file1"  value="${i.companyUrl}" />
                  </div>
                  </c:forEach>
                </div>
           
             </div>
             
          </div>
          <div class="clear"></div>
          <div class="zw"><div class="icon"></div>内容</div>
          <div class="zwContent"> 
                <textarea placeholder="请填写详情内容" name="businessCompanyContent">${buc.businessCompanyContent }</textarea>
                
          </div>
         
         <c:if test="${b==0}">
         <div class="companyDetails leble"><img src="img/biaoqian.png" />标签:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="blue">转让</span></div>
         </c:if>
         
         <c:if test="${b==1}">
         <div class="companyDetails leble"><img src="img/biaoqian.png" />标签:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="blue">收购</span></div>
         </c:if>
         <c:if test="${b==0}">
         <div class="companyDetails"><img src="img/gongsi.png" />公司名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请输入您的公司名称" name="businessCompanyName" value="${buc.businessCompanyName }"/></div>
         <div class="companyDetails"><img src="img/qian.png" />注册资本:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请输入公司注册资本(万元)" name="businessCompanyCapital" value="${buc.businessCompanyCapital }"/></div>
         <div class="companyDetails"><img src="img/zhuce.png" />注册号/统一社会信用代码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请填写正确的社会信用代码" name="businessCompanyNumber" value="${buc.businessCompanyNumber}"/></div>
         
       
         <div class="companyDetails radio">
             <div><img src="img/shui.png" />
             纳税类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
             
             <div class="besetRadio"><span><label><input type="radio" name="businessCompanyPayTaxes" value="1" alertvalue="请选择捐税类型" <c:if test="${buc.businessCompanyPayTaxes==1}">checked</c:if>/>一般纳税人</label></span></div>
             <div class="besetRadio"><span><label><input type="radio" name="businessCompanyPayTaxes" value="0" <c:if test="${buc.businessCompanyPayTaxes==0}">checked</c:if> />小规模</label></span></div>
         </div>
         <div class="companyDetails"><img src="img/riqi.png" />成立时间:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  placeholder="请输入公司成立时间" name="businessCompanyCreatDate" value="${buc.businessCompanyCreatDate}"/></div>
         <div class="companyDetails"><img src="img/fuwufanwei.png" />经营范围</div>
         <div class="businessScope">
            <textarea placeholder="请输入公司经营范围" name="businessCompanyRange">${buc.businessCompanyRange }</textarea>
         </div>
         </c:if>
         <div class="companyDetails regisetAddress"><img src="img/diqiu.png" /><c:if test="${b==0 }">注册地区</c:if><c:if test="${b==1 }">求购区域</c:if></div>
         <div class="address companyDetails" id="address">
             <div data-toggle="distpicker" >
		        <div class="form-group">
		          <label class="sr-only" for="province1">Province</label>
		          <select class="form-control" id="province1" name="address"></select>
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="city1">City</label>
		          <select class="form-control" id="city1" name="address"></select>
		        </div>
		        <div class="form-group">
		          <label class="sr-only" for="district1">District</label>
		          <select class="form-control" id="district1" name="address"></select>
		        </div>
      </div>
         </div>
      </div>
      <c:if test="${b==0}">
      <div class="companyDetails companyType"><img src="img/lingdai.png" />公司行业</div>
      <div class="companyTypeList radio">
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="文化咨询服务类公司" alertvalue="请选择公司行业" <c:if test="${buc.businessCompanyIndustry=='文化咨询服务类公司'}">checked</c:if>/>文化咨询服务类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="贸易类公司" <c:if test="${buc.businessCompanyIndustry=='贸易类公司'}">checked</c:if>/>贸易类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="科技类公司" <c:if test="${buc.businessCompanyIndustry=='科技类公司'}">checked</c:if>/>科技类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="工程类公司" <c:if test="${buc.businessCompanyIndustry=='工程类公司'}">checked</c:if>/>工程类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="餐饮类公司" <c:if test="${buc.businessCompanyIndustry=='餐饮类公司'}">checked</c:if>/>餐饮类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="影视类公司" <c:if test="${buc.businessCompanyIndustry=='影视类公司'}">checked</c:if>/>影视类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="事业类公司" <c:if test="${buc.businessCompanyIndustry=='事业类公司'}">checked</c:if>/>事业类公司</label></span></div>
           <div class="besetRadio"><span><label><input type="radio"  name="businessCompanyIndustry" value="金融类公司" <c:if test="${buc.businessCompanyIndustry=='金融类公司'}">checked</c:if>/>金融类公司</label></span></div>
      </div>
      <div class="clear"></div>
      <div class="companyDetails bankAccount radio">
               <div><img src="img/yinghang.png" />
               银行账户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyAccount" value="1" alertvalue="请选择银行账户类型 " <c:if test="${buc.businessCompanyAccount==1}">checked</c:if> />已开基本账户</label></span></div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyAccount" value="0" <c:if test="${buc.businessCompanyAccount==0}">checked</c:if>/>未开基本账户</label></span></div>
      </div>
      
       <div class="companyDetails"><img src="img/shui.png" />税务信息</div>
       <div class="revenueMesssage companyDetails radio">
               <div>是否报道/开业:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyTax" value="1" alertvalue="请选择是否报道" <c:if test="${buc.businessCompanyTax==1}">checked</c:if>/>是</label></span></div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyTax" value="0" <c:if test="${buc.businessCompanyTax==0}">checked</c:if> />否</label></span></div>
       </div>
       </c:if>
       <c:if test="${sessionScope.user.adminState==0}">
       <div class="stickChoose companyDetails radio">
               <div>是否置顶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyTop" value="1" alertvalue="请选择是否置顶" <c:if test="${buc.businessCompanyTop==1}">checked</c:if>/>是</label></span></div>
               <div class="besetRadio"><span><label><input type="radio" name="businessCompanyTop" value="0" <c:if test="${buc.businessCompanyTop==0}">checked</c:if>/>否</label></span></div>
       </div> 
       </c:if>
       <div class="foot">
             <input type="submit" value="确认提交" id="submit" />
       </div>
         
         
      </div>
         
   </form>
   
   <script>
          $(document).ready(function(){
           
            $('.radio input').on('ifCreated ifClicked ifChanged ifChecked ifUnchecked ifDisabled ifEnabled ifDestroyed', function(event){
              
            }).iCheck({
              checkboxClass: 'icheckbox_square-blue',
              radioClass: 'iradio_square-blue',
              increaseArea: '100%'
            });
          });
     </script>
</body>
</html>
       