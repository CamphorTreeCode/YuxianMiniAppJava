<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>申肃后台</title>

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
<script type="text/javascript">
   $(function(){
      
       $("[name=adminName]").attr({maxlength:25})
       $("[name=adminNickName]").attr({maxlength:45})
       $("[name=adminPhone]").attr({maxlength:11})
       $("[name=adminPassword]").attr({maxlength:25})
        var r1;
       $("[name=adminName]").blur(function(){
           
            var AdminName=$("[name=adminName]").val();
            $.get("./employee/verify",{name:AdminName},function(data){
                       if(data==0){
                           r1=false
                           alert("不能添加账号一样的两个管理员")
                           alert(r)
                       }
                       if(data==1){
                           r1=true
                       }
                       
          })
       
       })
      
      
      $(".commitAdd").click(function(){
          var r=true;
          
          if($("[name=file1]").length==0){
           if( $("[name=file]").val()==""){
                r=false;
                alert("请选择员工头像")
                return false;
             }
            }
           if(r1==false){
             alert("不能添加账号一样的两个管理员")
             r=false;
             return false;
           }
          if(r1==true){
            r=true;
            
          }
          $(".inputText input").each(function(i){
                
             if($(this).val()==""){
                r=false;
                alert($(this).attr("placeholder"))
                return false;
             }
          })
         
          return r;
      })
   })
</script>
</head>

<body>
	<!--头像部分  -->
	<form method="post" enctype="multipart/form-data" action="./employee/updateEmployee">
	<input type="hidden" name="token" value="${token}" />
	<div class="headImg">
		<div class="headTitle himg box">
			<div class="headTitleImg lf boxCenter" >
				<img alt="" src="img/touxaing.png">
			</div>
			<div class="headTitleText lf">上传头像</div>
		</div>

		<div class="headBodyImg htext box">
		    
			<div id="upimg"  class="headBodybox hbb boxCenter">
				<img id="head" class="upimgcss" alt="" src="${requestScope.admin.adminImgUrl}" >

			</div>
		</div>
	</div>
  <input type="text"  name="adminId"   value="${requestScope.admin.adminId}"  style="display: none" />
    <input type="hidden" value="${requestScope.admin.adminImgUrl}" name="file1">
   <input type="file" id="upload_file" name="file"   style="display: none" />
   
   
	<!--设置帐号  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/biaoti.png">
			</div>
			<div class="headTitleText lf">设置帐号</div>
		</div>
		<div class="inputText"><input type="text" name="adminName" value="${requestScope.admin.adminName}" placeholder="请输入帐号"></div>
	
	</div>
		<!--设置名称  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/ren.png">
			</div>
			<div class="headTitleText lf">设置名称</div>
		</div>
		<div class="inputText"><input type="text" name="adminNickName" value="${requestScope.admin.adminNickName}" placeholder="在此输入员工昵称"></div>
	   
	</div>
			<!--设置联系方式  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/phone.png">
			</div>
			<div class="headTitleText lf">设置联系方式</div>
		</div>
		<div class="inputText"><input type="text" name="adminPhone"  value="${requestScope.admin.adminPhone}" placeholder="在此输入联系方式"></div>
	   
	</div>
			<!--设置密码  -->
	<div class="headImg userNumber">
		<div class="headTitle box">
			<div class="headTitleImg lf boxCenter">
				<img alt="" src="img/mima.png">
			</div>
			<div class="headTitleText lf">设置密码</div>
		</div>
		<div class="inputText"><input type="password" name="adminPassword"  value="${requestScope.admin.adminPassword}" placeholder="在此输入登录所用密码"></div>
	   
	</div>
	<button type="submit" class="commitAdd ri">修改员工</button>
	</form>
</body>
</html>
