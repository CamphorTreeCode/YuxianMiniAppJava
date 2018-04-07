<%@page import="com.woman.tool.UpdataName"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片工具</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/notice/js/jquery-1.10.2.min.js"></script>
  		<script type="text/javascript">
  		 $(function(){ 
         //var url = "http://localhost/Maven_Project/"
	var url ='<%=UpdataName.urlName%>/<%=UpdataName.projectName%>/'
	$('#upload').click(function() {
	$.ajax({
    url: url+"tool/uploadImg",
    type: 'POST',
    cache: false,
    data: new FormData($('#uploadForm')[0]),
    processData: false,
    contentType: false
}).done(function(res) {
   console.log(res) 
   var jsonObj1 = $.parseJSON(res);
   console.log(jsonObj1);
   $("#img").append("<div class='imgyd'><img class='img' title='上传前的图片' src="+jsonObj1[0].imgpath+"><div class='imgwz'>上传前的图片</div>"
   +"<div class='imgwz'>原图大小："+jsonObj1[0].imgpathSize+"</div><div class='imgwz'>原图图片的地址："+jsonObj1[0].imgpath+"</div></div><div class='imgyd2'>"
   +"<img title='压缩后的图片' class='img' src="+jsonObj1[0].zipiMG+"><div class='imgwz'>压缩后的图片</div>"
   +"<div class='imgwz'>压缩大小："+jsonObj1[0].zipImgSize+"</div><div class='imgwz'>压缩后图片的地址："+jsonObj1[0].zipiMG+"</div></div>");
}).fail(function(res) {
  console.log(res);
  console.log('112212fail');
  });
})

  
})
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
	.imgBody{
	  width:80%;
	      margin: 0 auto;
	      
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
.imgBody form{
    margin-top: 1%;

}
	#img{
	    height: 450px;
    margin-top: 6%;
	}
	.img{
	    height: 100%;
    margin: 0 auto;
    display: block;
	    }
	    .imgFrom{
	   margin-top:4%;
	    widght:100%;
	    }
	    
	    .imgyd{
	    margin-right:10%;}
	    .imgyd2{
	    margin-left:10%;}
	    
	    .imgwz{
	     text-align: center;
	     line-height: 30px;
	    }
	    .insize{
	     width:100%
	    }
	    .inputsize{
	    width:77%;}
	</style>
  <body>
  <div class="imgBody">
  <div class="imgFrom  boxCenter"> 
<form class="" id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="file"/><br>
  <label class="insize"> 请输入图片的大小: <input class="inputsize" id="text" placeholder="值在0到1之间，1就是原图大小" type="text" name="imgSize"/></label>
  <label class="insize"> 请输入图片的品质: <input class="inputsize" id="text1" placeholder="值在0到1之间，越接近于1质量越好" type="text" name="imgQuality"/></label>
  <button id="upload" type="button">上传</button>
</form>
</div>
   <div id="img" class="boxCenter cl"></div>  
   </div>
   
  </body>
</html>
