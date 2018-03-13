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
   <script type="text/javascript" src="js/swiper.js"></script>
   <link rel="stylesheet" href="css/swiper.css" type="text/css" />
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
	
	
	function imgPreview1(fileDom){
				 $("#preview1").show();
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        $(".del1").show();
		$(".addIcon1").hide();
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
            var img = document.getElementById("preview1");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
	
	
	
	function imgPreview2(fileDom){
				 $("#preview2").show();
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        $(".del2").show();
		$(".addIcon2").hide();
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
            var img = document.getElementById("preview2");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
	
   </script>
   
<body>
      <div class="content">
         
          <div class="title"><div class="icon"></div>Banner</div>
                   
          
              <div class="lbt">
              <ul class="line">
                   <li>1</li>
                   <li>
                        <div class="view">
                                  <div class="viewimg">
                                     <img id="preview" src="${s0.url}" />
                                     <input type="hidden" name="swiperid" value="${s0.swiperid }">
                                     <input type="hidden" name="img" value="${s0.url }">
                                     <div class="addIcon"><input type="file" id="file" class="file" onchange="imgPreview(this)" /></div>
                                     <div class="del" style="display:none"></div>
                                  </div>
                                </div>
                   </li>
                   <li>
                   <li class="ylIcon">预览</li>
                   <li class="submit">提交</li>
                   </li>
              </ul>
             <form action="" id="file" method= "post" enctype ="multipart/form-data">
              <ul class="line">
                   <li>2</li>
                   <li>
                         <div class="view">
                                  <div class="viewimg">
                                     <input type="hidden" name="swiperid1" value="${s1.swiperid }">
                                     <input type="hidden" name="img1" value="${s1.url }">
                                     <img id="preview1"  src="${s1.url }"/>
                                     <div class="addIcon1"><input type="file" name="file" class="file1" onchange="imgPreview1(this)" /></div>
                                     <div class="del1" style="display:none"></div>
                                  </div>
                                </div>
                      
                   </li>
                   <li>
                   <li class="ylIcon1">预览</li>
                    <li class="submit1">提交</li>
                    </li>
              </ul>
              </form>
              <ul class="line">
                   <li>3</li>
                   <li>
                         <div class="view">
                                  <div class="viewimg">
                                     <input type="hidden" name="swiperid2" value="${s2.swiperid }">
                                     <img id="preview2" src="${s2.url }"/>
                                     <input type="hidden" name="img2" value="${s2.url }">
                                     <div class="addIcon2"><input type="file" name="file" class="file2" onchange="imgPreview2(this)" /></div>
                                     <div class="del2" style="display:none"></div>
                                  </div>
                                </div>
                   </li>
                   <li>
                   <li class="ylIcon2">预览</li>
                   <li class="submit2">提交</li>
                   </li>
              </ul>
                 
             </div>
                
            
            
            
      </div>    
       
                  <div class="yl" style="display:none;">
                     <img src="../018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg" />
                 </div>   
</body>
</html>
