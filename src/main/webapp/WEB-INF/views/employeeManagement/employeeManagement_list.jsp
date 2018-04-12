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
<title>申肃后台</title>
</head>
<base href="<%=basePath%>">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/wxIndex_message_sell_list.js"></script>
<link rel="stylesheet" href="css/wxIndex_message_sell_list.css" type="text/css" />
<script type="text/javascript">
   $(function(){
   
   
   
   parent.employee();
   /*删除确认*/
   $(".employeeDel").click(function(){
     var name=$(this).attr("adminName")
     var con=confirm("确认删除管理员"+name+"吗")
		  if(!con){
			return false;
		  }
   
   })
   
   /*分页样式 start*/
	var a=$("[name=ym]").val();
    var b=$("[name=zys]").val();
    if(b<=5){
       $(".pageNumber")[a-1].setAttribute("class","click");
        $(".pageNumberA")[a-1].setAttribute("class","clickNumber");
    }
    if(b>5){
        if(b-a>=2){
	        if(a>=4){
	            $(".pageNumber")[2].setAttribute("class","click");
	             $(".pageNumberA")[2].setAttribute("class","clickNumber");
	        }
	        
	        if(a<4){
	            $(".pageNumber")[a-1].setAttribute("class","click");
	             $(".pageNumberA")[a-1].setAttribute("class","clickNumber");
	        }
        }else{
             $(".pageNumber")[5-(b-a)-1].setAttribute("class","click");
              $(".pageNumberA")[5-(b-a)-1].setAttribute("class","clickNumber");
        }
       
    }
     
     $(".pageNumber").bind("click",function(){
	      $(".pageNumber").removeClass("click")
	 })
    
	     
	 /*分页样式  end*/    
	 })
</script>
<body>
      <div class="content">
           <input type="hidden" name="businessCompany" value="${businessCompany }">
           <div class="title"><div class="icon"></div>管理</div>
           <a href="./employee/EmployeePage"><div class="title addMessage"><img src="img/jiahao.png" />添加员工</div></a>
           <ul class="property" style="background:#fff;">
              <li>头像</li>
              <li>账号</li>
              <li>名称</li>
              <li>密码</li>
              <li>联系方式</li>
              <li>添加时间</li>
              <li></li>
           </ul>
           <div class="clear"></div>
           
                   <c:forEach items="${employeePage.lists }" var="e">
                   
                   <ul class="context" style="background:#fff;">
                      <li>
                        
                        <img src="${e.adminImgUrl }" style="width:80%; height:80%; margin:7px auto;"/>
                        
                      </li>
                      <li>${e.adminName }</li>
                      <li>
                         ${e.adminNickName}                                                             
                      </li>
                      <li>${e.adminPassword }</li>
                      <li style="padding-top:20px;">${e.adminPhone }</li>
                      <li>${e.adminCrateTime}</li>
                      <li>
                        <a href="./employee/selectEmployee?adminid=${e.adminId }"><span class="blue" style="margin-left:20px;">修改</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="./employee/del?adminid=${e.adminId }"> <span class="blue employeeDel" style="margin-left:20px;" adminName="${e.adminName}">删除</span></a>
                      </li>
                   </ul>
                   
                   </c:forEach>
                   
                   
                   <div class="clear"></div>
          <div class="index">
                    <c:if test="${requestScope.employeePage.currPage != 1}">
	                    <a href="./employee/list?currentPage=${requestScope.employeePage.currPage-1}" style="color:#000;">
	                         <li id="front"></li>
	                    </a>
                    </c:if>
                    
                    
                    
                    <c:if test="${requestScope.employeePage.totalPage<=5}">
	                    <c:forEach  var="i" begin="1" end="${requestScope.employeePage.totalPage}" step="1">
	                       <a href="./employee/list?currentPage=${i }" class="pageNumberA"><li class="pageNumber">${i}</li></a>
	                    
	                    </c:forEach>
                    </c:if>
                    <c:if test="${requestScope.employeePage.totalPage>5}">
                    
                        <c:if test="${requestScope.employeePage.currPage==1 || requestScope.employeePage.currPage ==2}">
		                    <c:forEach  var="i" begin="1" end="5" step="1">
		                        <a href="./employee/list?currentPage=${i }" class="pageNumberA"><li class="pageNumber">${i}</li></a>
		                    
		                    </c:forEach>
	                    </c:if>
                        <c:if test="${requestScope.employeePage.currPage>2}">
		                    <c:if test="${requestScope.employeePage.totalPage-requestScope.employeePage.currPage<=2}">
			                    <c:forEach  var="i" begin="${requestScope.employeePage.totalPage-4}" end="${requestScope.employeePage.totalPage}" step="1">
			                       <a href="./employee/list?currentPage=${i }" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
		                    <c:if test="${requestScope.employeePage.totalPage-requestScope.employeePage.currPage>2}">
			                    <c:forEach  var="i" begin="${requestScope.employeePage.currPage-2}" end="${requestScope.employeePage.currPage+2}" step="1">
			                      <a href="./employee/list?currentPage=${i }" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
	                    
	                   </c:if>
	                    
                    </c:if>
                    <c:if test="${requestScope.employeePage.currPage != requestScope.employeePage.totalPage}">
	                    <a href="./employee/list?currentPage=${requestScope.employeePage.currPage+1}" style="color:#000;">
	                          <li id="rear"></li>
	                    </a>
                    </c:if>
                    
                    
                    <li id="ym"><span>第${requestScope.employeePage.currPage }/ ${requestScope.employeePage.totalPage}页</span>&nbsp;&nbsp;</li>
                    <input type="hidden" name="ym" value="${ requestScope.employeePage.currPage }">
                    <input type="hidden" name="zys" value="${requestScope.employeePage.totalPage}">
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
