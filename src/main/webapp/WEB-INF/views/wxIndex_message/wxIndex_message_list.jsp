<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/wxIndex_message_sell_list.js"></script>
<link rel="stylesheet" href="css/wxIndex_message_sell_list.css" type="text/css" />
<body>
      <div class="content">
           <input type="hidden" name="businessCompany" value="${businessCompany }"> 
           <div class="title"><div class="icon"></div>管理</div>
           <a href="../wxIndex_message/add?businessCompany=${businessCompany }"><div class="title addMessage"><img src="img/jiahao.png" />添加信息</div></a>
           <ul class="property">
              <li>头像</li>
              <li>账号</li>
              <li>图片</li>
              <li>电话</li>
              <li>发布时间</li>
              <li>状态</li>
              <li></li>
              <li></li>
           </ul>
           <div class="clear"></div>
                   <c:forEach items="${businessCompanyPage.lists}" var="b">
                   <ul class="context">
                      <li>
                        
                        <img src="${b.admin.adminImgUrl }" style="width:80%; height:80%; margin:7px auto;"/>
                        
                      </li>
                      <li>${b.admin.adminName}</li>
                      <li class="img">
                           <div class="slideshow">
                                <div class="preview" style="display:none;"><span>查看大图</span></div>
                                <div class="savaimg">
                                   <c:forEach items="${b.companyImg }" var="bimg">
                                   <div><img src="${bimg.companyUrl}" /></div>  
                                   
                                   
                                   </c:forEach>
                                </div>
                           </div>
                           
                      </li>
                      <li>${b.admin.adminPhone }</li>
                      <li>${b.businessCompanyCreatTime }</li>
                      <c:if test="${b.businessCompanyTop==1 }">
                      <li class="blue">已置顶</li>
                      </c:if>
                      <c:if test="${b.businessCompanyTop==0 }">
                      <li class="blue">没置顶</li>
                      </c:if>
                      <li class="handle">
                          <a href="../wxIndex_message/update?id=${b.businessCompanyId}" class="blue"><span>修改</span></a>
                          <a href="../wxIndex_message/del?id=${b.businessCompanyId}&&businessCompany=${b.businessCompany}" class="blue"><span>删除</span></a>
                          <a href="../wxIndex_message/look?id=${b.businessCompanyId}" class="blue"><span>查看</span></a>
                      </li>
                      <c:if test="${b.businessCompanyTop==1 }">
                      <a href="../wxIndex_message/updataTop?id=${b.businessCompanyId}&&businessCompany=${b.businessCompany}&&businessCompanyTop=0" class="blue"><li>取消置顶</li></a>
                      </c:if>
                      <c:if test="${b.businessCompanyTop==0}">
                      <a href="../wxIndex_message/updataTop?id=${b.businessCompanyId}&&businessCompany=${b.businessCompany}&&businessCompanyTop=1" class="blue"><li>置顶</li></a>
                      </c:if>
                   </ul>
                   </c:forEach>
                   
                   
                   <div class="clear"></div>
          <div class="index">
                    <c:if test="${requestScope.businessCompanyPage.currPage != 1}">
	                    <a href="../wxIndex_message/list?currentPage=${requestScope.businessCompanyPage.currPage-1}&&businessCompany=${businessCompany}" style="color:#000;">
	                         <li id="front"></li>
	                    </a>
                    </c:if>
                    
                    
                    
                    <c:if test="${requestScope.businessCompanyPage.totalPage<=5}">
	                    <c:forEach  var="i" begin="1" end="${requestScope.businessCompanyPage.totalPage}" step="1">
	                       <a href="../wxIndex_message/list?currentPage=${i}&&businessCompany=${businessCompany}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
	                    
	                    </c:forEach>
                    </c:if>
                    <c:if test="${requestScope.businessCompanyPage.totalPage>5}">
                    
                        <c:if test="${requestScope.businessCompanyPage.currPage==1 || requestScope.businessCompanyPage.currPage ==2}">
		                    <c:forEach  var="i" begin="1" end="5" step="1">
		                       <a href="../wxIndex_message/list?currentPage=${i}&&businessCompany=${businessCompany}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
		                    
		                    </c:forEach>
	                    </c:if>
                        <c:if test="${requestScope.businessCompanyPage.currPage>2}">
		                    <c:if test="${requestScope.businessCompanyPage.totalPage-requestScope.businessCompanyPage.currPage<=2}">
			                    <c:forEach  var="i" begin="${requestScope.businessCompanyPage.totalPage-4}" end="${requestScope.businessCompanyPage.totalPage}" step="1">
			                       <a href="../wxIndex_message/list?currentPage=${i}&&businessCompany=${businessCompany}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
		                    <c:if test="${requestScope.businessCompanyPage.totalPage-requestScope.businessCompanyPage.currPage>2}">
			                    <c:forEach  var="i" begin="${requestScope.businessCompanyPage.currPage-2}" end="${requestScope.businessCompanyPage.currPage+2}" step="1">
			                       <a href="../wxIndex_message/list?currentPage=${i}&&businessCompany=${businessCompany}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
	                    
	                   </c:if>
	                    
                    </c:if>
                    
                    
                    
                    
                    <c:if test="${requestScope.businessCompanyPage.currPage != requestScope.businessCompanyPage.totalPage}">
	                    <a href="../wxIndex_message/list?currentPage=${requestScope.businessCompanyPage.currPage+1}&&businessCompany=${businessCompany}" style="color:#000;">
	                          <li id="rear"></li>
	                    </a>
                    </c:if>
                    
                    
                    <li id="ym"><span>第${requestScope.businessCompanyPage.currPage }/ ${requestScope.businessCompanyPage.totalPage}页</span>&nbsp;&nbsp;</li>
                    <input type="hidden" name="ym" value="${ requestScope.businessCompanyPage.currPage }">
                    <input type="hidden" name="zys" value="${requestScope.businessCompanyPage.totalPage}">
          </div>
          
      </div>
      <div class="perviewOutBorder" style="display:none;">
          <div class="bigImgPreview">
                <div class="window">
                     <div class="vessel">
                          <div><img src="../img/下载.jpg" /></div>
                     </div>
                </div>
          </div>
          <div class="bigImgFront pageTurning"><img src="img/微信图片_20180331174129.png" /></div>
          <div class="bigImgRear pageTurning"><img src="img/微信图片_20180330105138.png" /></div>
          <div class="bigImgPreviewClose"><img src="img/微信图片_20180314163812.png" /></div>
      </div>
</body>
</html>
