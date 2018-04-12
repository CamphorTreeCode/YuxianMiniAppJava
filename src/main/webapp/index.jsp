
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申肃后台</title>
<script type="text/javascript">

</script>
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

.box {
	display: flex;
	display: -webkit-flex; /*webkit*/
	-moz-justify-content: flex-start;
	-webkit-justify-content: flex-start;
	justify-content: flex-start;
	-webkit-box-align: center;
	-moz-align-items: center;
	-webkit-align-items: center;
	align-items: center;
}

.boxCenter {
	display: flex;
	display: -webkit-flex; /*webkit*/
	-moz-justify-content: center;
	-webkit-justify-content: center;
	justify-content: centert;
	-webkit-box-align: center;
	-moz-align-items: center;
	-webkit-align-items: center;
	align-items: center;
}

.body {
	height: 100%;
	width: 100%;
	background-image: url('img/background.png');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	-moz-background-size: 100% 100%;
}

.lineBule {
	height: 6%;
	background-image: url('img/topback.png');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	-moz-background-size: 100% 100%;
}

.leftImg {
	height: 70%;

	margin-left: 10%;
}

.leftImg img {
	width: 100%;
	height: 100%;
}

.leftWord {
	color: #fff;
	font-size: 1.4rem;
	margin-left: 1%;
}

.bodyCenter {
	height: 94%;
}

.contenBody {
	height: 50%;
	width: 39%;
	margin: 0 auto;
}

.headImg {
	height: 20%;
}

.headImg img {
	border-radius: 50%;
	height: 100%;
}

.welcome {
	color: #6BC9FF;
	font-size: 1.3rem;
	height: 15%;
}

.userName {
	height: 16%;
}

.userNameContent {
	background: #DEF2FD;
	width: 62%;
	height: 80%;
	border-radius: 300px;
}

.userNameContent input {
	background: #DEF2FD;
	border: none;
	width: 73%;
	margin-left: 10%;
	height: 67%;
	font-size: 1.3rem;
	color: #9CD8FE;
	outline: none;
}

.userNameContent img {
	width: 10%;
	height: 78%;
}

.loginBut {
	height: 20%;
}

.loginBut button {
	width: 32%;
	color: #fff;
	background: #8AD5FD;
	height: 50%;
	font-size: 1.3rem;
	border-radius: 300px;
	border: none;
	outline: none;
}

input::-webkit-input-placeholder {
	color: #9CD8FE;
}
.leftImg img{
      width: 36px;
    height: 36px;
    margin-top: 9%;
}
</style>
</head>
<script type="text/javascript">
    window.onload=function(){
    if (window != top)
         top.location.href = location.href; 
    }
   
</script>
<body>
	<div class="body">
		<div class="lineBule box">
			<div class="leftImg lf">
				<img alt="" src="img/xcxlogo.png" />
			</div>
			<div class="leftWord lf">小程序后台系统</div>
		</div>

		<div class="bodyCenter box">
			<div class="contenBody">

				<div class="headImg boxCenter">
					<img alt="" src="img/head.jpg">
				</div>

				<div class="welcome boxCenter">Welcome,My Friend</div>
				<form action="${pageContext.request.contextPath}/login/login">
				   <input type="hidden" name="token" value="${token}" />
					<div class="userName boxCenter">
						<div class="userNameContent box">
							<input class="ipt" type="text" placeholder="请输入用户名" value=""
								name="user_name"> <img alt="" src="img/yonghu.png">
						</div>
					</div>

					<div class="userName boxCenter">
						<div class="userNameContent box">
							<input class="ipt" type="password" placeholder="请输入密码" value=""
								name="user_password"> <img alt="" src="img/yaos.png">
						</div>
					</div>
                 
					<div class="loginBut boxCenter">
						<button type="submit">登录</button>
					</div>
				</form>
			</div>

		</div>
</body>

</html>