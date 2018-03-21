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
<script src="js/jquery-1.10.2.min.js"></script>
</head>
<link rel="stylesheet" href="css/issueList.css" type="text/css" />
<body>
      <div class="content">
           <div class="title"><div class="icon"></div>待发布</div>
           
           <ul class="property">
              <li>顺序</li>
              <li>名称</li>
              <li>缩略图</li>
              <li>时间</li>
              <li></li>
           </ul>
           <div class="clear"></div>
                   <c:forEach items="${requestScope.noticePage.lists}" var="notice" >
                   
                   <ul class="context">
                     <li>${notice.noticeid}</li>
		              <li>${notice.title }</li>
		              <li class="img"><img src="http://shensu.free.ngrok.cc/RegistCompanyIMG\2018-03-13\e6e45891-d2c2-414d-bb91-96fe2df8ef6a.png" /></li>
		              <li>${notice.createtime }</li>
		              <li><a href="../notice/look?id=${notice.noticeid}">查看</a></li>
                   </ul>
                   </c:forEach>
                   <div class="clear"></div>
                   <div class="Footline"></div>
          <div class="index">
                    <c:if test="${requestScope.noticePage.currPage != 1}">
                    <a href="../notice/getbystate?currentPage=${requestScope.noticePage.currPage-1}&&state=${state}" style="color:#000;">
                    <li id="front"></li>
                    </a>
                    </c:if>
                    <c:forEach  var="i" begin="1" end="${requestScope.noticePage.totalPage}" step="1">
                    <li><a href="../notice/getbystate?currentPage=${i}&&state=${state}">${i}</a></li>
                    
                    </c:forEach>
                    <c:if test="${requestScope.noticePage.currPage != requestScope.noticePage.totalPage}">
                    <a href="../notice/getbystate?currentPage=${requestScope.noticePage.currPage+1}&&state=${state}"
				           	style="color:#000;">
                    <li id="rear"></li>
                    </a>
                    </c:if>
                    <li id="ym"><span>第${requestScope.noticePage.currPage }/ ${requestScope.noticePage.totalPage}页</span>&nbsp;&nbsp;</li>
                    
          </div>
      </div>
</body>
</html>
