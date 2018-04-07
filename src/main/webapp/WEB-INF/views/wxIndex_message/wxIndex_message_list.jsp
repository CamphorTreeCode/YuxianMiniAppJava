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
</head>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/wxIndex_message_sell_list.js"></script>
<link rel="stylesheet" href="css/wxIndex_message_sell_list.css" type="text/css" />
<script type="text/javascript">
   parent.sell();
</script>
<body>
      <div class="content">
           <div class="title"><div class="icon"></div>管理</div>
           <a href="#"><div class="title addMessage"><img src="img/jiahao.png" />添加信息</div></a>
           <ul class="property">
              <li>头像</li>
              <li>账号</li>
              <li>图片</li>
              <li>电话</li>
              <li>发布时间</li>
              <li>状态</li>
              <li></li>
              <li></li>
           </ul>
           <div class="clear"></div>
                   <c:forEach items="${businessCompanyPage.lists}" var="b">
                   <ul class="context">
                      <li>${b.businessCompanyId }</li>
                      <li></li>
                      <li class="img">
                           <div class="slideshow">
                                <div class="preview" style="display:none;"><span>查看大图</span></div>
                                <div class="savaimg">
                                   <div><img src="../img/017d08568e4e876ac725bb5cae36c4.gif" /></div>  
                                   
                                   <div><img src="../img/下载.jpg" /></div>
                                   
                                   <div><img src="../img/017d08568e4e876ac725bb5cae36c4.gif" /></div>  
                                   
                                   <div><img src="../img/下载.jpg" /></div>
                                   
                                   <div><img src="../img/017d08568e4e876ac725bb5cae36c4.gif" /></div>  
                                   
                                   <div><img src="../img/下载.jpg" /></div>
                                </div>
                           </div>
                           
                      </li>
                      <li>13482486131</li>
                      <li>2018.3.30 17:23</li>
                      <li class="blue">已置顶</li>
                      <li class="handle">
                          <a href="#" class="blue"><span>修改</span></a>
                          <a href="#" class="blue"><span>删除</span></a>
                          <a href="#" class="blue"><span>查看</span></a>
                      </li>
                      <a href="#" class="blue"><li>取消置顶</li></a>
                   </ul>
                   </c:forEach>
                   <ul class="context">
                      <li>1</li>
                      <li>公司注册流程</li>
                       <li class="img">
                           <div class="slideshow">
                                <img src="../img/下载.jpg" />
                           
                                <img src="../img/017d08568e4e876ac725bb5cae36c4.gif" />
                                
                                <img src="../img/u=3478924363,3684130430&fm=27&gp=0.jpg" />
                           </div>
                           
                      </li>
                      <li>13482486131</li>
                      <li>2018.3.30 17:23</li>
                      <li class="blue">已置顶</li>
                       <li class="handle">
                          <a href="#" class="blue"><span>修改</span></a>
                          <a href="#" class="blue"><span>删除</span></a>
                          <a href="#" class="blue"><span>查看</span></a>
                      </li>
                      <a href="#" class="blue"><li>取消置顶</li></a>
                   </ul>
                   <ul class="context">
                      <li>1</li>
                      <li>公司注册流程</li>
                       <li class="img">
                           <div class="slideshow">
                                <div><img src="../img/u=3478924363,3684130430&fm=27&gp=0.jpg" /></div>
                                <img src="../img/017d08568e4e876ac725bb5cae36c4.gif" />
                                <img src="../img/017d08568e4e876ac725bb5cae36c4.gif" />
                           </div>
                           
                      </li>
                      <li>13482486131</li>
                      <li>2018.3.30 17:23</li>
                      <li class="blue">已置顶</li>
                       <li class="handle">
                          <a href="#" class="blue"><span>修改</span></a>
                          <a href="#" class="blue"><span>删除</span></a>
                          <a href="#" class="blue"><span>查看</span></a>
                      </li>
                      <a href="#" class="blue"><li>取消置顶</li></a>
                   </ul>
                   <ul class="context">
                      <li>1</li>
                      <li></li>
                       <li class="img">
                           <div class="slideshow">
                                <img src="../img/017d08568e4e876ac725bb5cae36c4.gif" />
                                <img src="../img/017d08568e4e876ac725bb5cae36c4.gif" />
                                
                           </div>
                           
                      </li>
                      <li></li>
                      <li></li>
                      <li></li>
                      <li class="handle">
                          <span></span>
                          <span></span>
                          <span></span>
                      </li>
                      <li></li>
                   </ul>
                   <ul class="context">
                      <li></li>
                      <li></li>
                      <li class="img"><img src="http://shensu.free.ngrok.cc/RegistCompanyIMG\2018-03-13\e6e45891-d2c2-414d-bb91-96fe2df8ef6a.png" /></li>
                      <li></li>
                      <li></li>
                      <li></li>
                      <li class="handle">
                          <span></span>
                          <span></span>
                          <span></span>
                      </li>
                      <li></li>
                   </ul>
                   
                   
                   <div class="clear"></div>
          <div class="index">
                 
                    <a href="#" class="blue"><li id="front"></li></a>
                    <a href="#" class="blue"><li>1</li></a>
                    <a href="#" class="blue"><li>2</li></a>
                    <a href="#" class="blue"><li>3</li></a>
                    <a href="#" class="blue"><li id="rear"></li></a>
                  
          </div>
      </div>
      <div class="perviewOutBorder" style="display:none;">
          <div class="bigImgPreview">
                <div class="window">
                     <div class="vessel">
                          <div><img src="../img/下载.jpg" /></div>
                     </div>
                </div>
          </div>
          <div class="bigImgFront pageTurning"><img src="img/微信图片_20180331174129.png" /></div>
          <div class="bigImgRear pageTurning"><img src="img/微信图片_20180330105138.png" /></div>
          <div class="bigImgPreviewClose"><img src="img/微信图片_20180314163812.png" /></div>
      </div>
</body>
</html>
