<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'employeeManagement_add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>


</style>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/employeeManagement.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/notice/js/jquery-1.10.2.min.js"></script>
<script src="http://www.jq22.com/jquery/vue.min.js"></script>
<script src="js/employeeManagement.js"></script>
</head>

<body>
	<!--头像部分  -->
	<div class="headImg">
		<div class="headTitle himg box">
			<div class="headTitleImg lf boxCenter" >
				<img alt="" src="img/touxaing.png">
			</div>
			<div class="headTitleText   lf">上传头像</div>
		</div>

		<div class="headBodyImg htext box">
			<div id="upimg"  class="headBodybox hbb boxCenter">
				<img id="head" class="upimgcss" alt="" src="img/jia.png">

			</div>
		</div>
	</div>

   <input type="file" id="upload_file" multiple style="display: none" />

	<!--设置帐号  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/biaoti.png">
			</div>
			<div class="headTitleText lf">设置帐号</div>
		</div>
		<div class="inputText"><input type="text" name="user_search" placeholder="请输入帐号"></div>
	
	</div>
		<!--设置名称  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/ren.png">
			</div>
			<div class="headTitleText lf">设置名称</div>
		</div>
		<div class="inputText"><input type="text" name="user_search" placeholder="在此输入员工昵称"></div>
	   
	</div>
			<!--设置联系方式  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/phone.png">
			</div>
			<div class="headTitleText lf">设置联系方式</div>
		</div>
		<div class="inputText"><input type="text" name="user_search" placeholder="在此输入联系方式"></div>
	   
	</div>
			<!--设置密码  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/mima.png">
			</div>
			<div class="headTitleText lf">设置密码</div>
		</div>
		<div class="inputText"><input type="text" name="user_search" placeholder="在此输入登录所用密码"></div>
	   
	</div>
	<div class="commitAdd ri">添加员工</div>
</body>
</html>
