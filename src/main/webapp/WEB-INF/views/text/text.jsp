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
   <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
   <script type="text/javascript" src="js/text.js"></script>
   <link rel="stylesheet" href="css/text.css" type="text/css" />
   <script type="text/javascript">
      
      window.onload=function(){
            var ue = UE.getEditor('container');
            $.get("../text/getByType",{type:1},function(data){
			var aa=eval(data)
			
			$("[name=textid]").val(aa[0].textid)
			$("#preview").attr("src",aa[0].img)
			$("[name=file1]").val(aa[0].img)
			$("[name=type]").val(aa[0].type)
			ue.setContent(aa[0].context);
			
		    $(this).parent().toggle;
		  })
         
      }
      
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
   <form method="post" enctype="multipart/form-data" action="../text/update">  
      <div class="content">
           	 <div class="textType"><span>工商注册</span><div class="icon"></div>
                  <input type="hidden" name="textid">
                  <input type="hidden" name="type" value="1">
                  <input type="hidden" name="file1">
                  <div class="details" style="display:none;">
                       <ul>
                         
                            <li value="1">工商注册</li>
                            <li value="2">代理记账</li>
                            <li value="3">代办资质</li>
                           
                          
                            <li value="4">网站建设</li>
                            <li value="5">商标专利</li>
                            <li value="6">宣传推广</li>
                          
                         
                            <li value="7">小程序开发</li>
                            <li value="8">增值服务</li>
                            <li value="9">公司简介</li>
                          
                       </ul>
                  </div>
              </div>
          </div>
          <div class="noticeImg">
             <div class="img"><div class="icon"></div>选项图片</div>
             <div>
                <div class="view">
                  <div class="viewimg">
                     <img id="preview" />
                     <div class="addIcon"><input type="file" name="file" class="file" onchange="imgPreview(this)" /></div>
                     <div class="del" style="display:none"></div>
                  </div>
                </div>
                
             </div>
            
             <br />
           
          </div>
          <div>
          <div class="zw"><div class="icon"></div>正文</div>
        <script id="container" name="context" type="text/plain">
            
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
          <div class="foot">
             <input type="submit" value="确认修改" id="submit"/>
          </div>
      </div>
   </form>
</body>
</html>
