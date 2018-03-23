<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'company.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
* {
	margin: 0;
	padding: 0;
}

.lf {
	float: left
}

.cl {
	clear: both;
}

.ri {
	float: right;
}
 .body{
   background:#F2F2F2;
 }
 .listTitle{
     height: 35px;
    border: 1px solid #EEE;
    width:75%;
    background:#fff;
    }
 .property li{
    float: left;
    list-style: none;
    width: 20%;
    text-align: center;
    line-height: 35px;
    border-right:1px solid #EEE;
 }
 
</style>
  </head>
  
  <body>
     <div class="body">
      
        <div class="listTitle">
            <ul class="property">
              <li>顺序</li>
              <li>名称</li>
              <li>联系方式</li>
              <li>公司类别</li>
              <li></li>
           </ul></div>
     
     </div>
  </body>
</html>
