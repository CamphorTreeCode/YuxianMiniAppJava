<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" href="css/wxIndex.css" type="text/css" />
<body>
         
     <div class="content">
             <div class="module">
               <h4><div class="icon"></div>小程序信息</h4>
               <h1>上海玉先企业管理有限公司</h1>
             </div>
             <div class="module">
               <h4><div class="icon"></div>联系信息</h4>
               <h1>上海申肃网络科技有限公司</h1>
               <h3>传手小程序开发平台</h3>
             </div>
             <div class="module">
               <h4><div class="icon"></div>消息提醒</h4>
               <div class="information">
                   <h1>工商注册:</h1>
                   <h1><span>30</span>条信息</h1>
               </div>
             </div>
             <div class="module">
               <h4>联系电话&nbsp:<span>021-610132895</span></h4>
               <h1>联系地址：<span>上海市松江区乐都路358号云间大厦</span></h1>
             </div>
     </div>
</body>
</html>