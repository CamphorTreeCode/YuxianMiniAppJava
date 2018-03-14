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
<title>玉先后台</title>
</head>
   <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
   <script type="text/javascript" src="js/issueNotice.js"></script>
   <link rel="stylesheet" href="css/issueNotice.css" type="text/css" />
   <script type="text/javascript">
     function imgPreview(fileDom){
				 $("#preview").show();
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        $(".del").show();
		$(".addIcon").hide();
        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function(e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
   
   </script>
   
<body>
   <form name="myForm" method="post" enctype="multipart/form-data" action="../notice/submit">  
      <div class="content">
          <input type="hidden" name="file1" value="${notice.img}">
          <input type="hidden" name="noticeid" value="${notice.noticeid }">
          <input type="hidden" name="state" value="${notice.state }">
          <div class="title"><div class="icon"></div>标题</div>
          <div class="titleInput"><input type="text" placeholder="在此处输入标题" name="title" value="${notice.title }"/></div>
          <div class="noticeImg">
             <div class="img"><div class="icon"></div>公告图片</div>
             <div>
                <div class="view">
                  <div class="viewimg">
                     <img id="preview" src="${notice.img }"/>
                     <div class="addIcon"><input type="file" name="file" class="file" onchange="imgPreview(this)" /></div>
                     <div class="del" style="display:none"></div>
                  </div>
                </div>
                
             </div>
          </div>
          <div>
        <script id="container" name="context" type="text/plain">
             ${notice.context}
        </script>
        <!-- 配置文件 -->
        <script type="text/javascript" src="ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
        <script type="text/javascript" src="ueditor.all.js"></script>
        <!-- 实例化编辑器 -->
        <script type="text/javascript">
            var ue = UE.getEditor('container');
        </script>
          </div>
          <c:if test="${state!=2 }">
          <div class="foot">
             <input type="submit" value="确认发布" name="looksubmit">
             <input type="submit" value="存草稿箱" onclick="this.form.action='../notice/wait'" name="wait">
          </div>
          </c:if>
      </div>
   </form>
</body>
</html>
