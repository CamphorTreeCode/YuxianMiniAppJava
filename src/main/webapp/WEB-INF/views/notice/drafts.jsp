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
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
  $(function(){
  if($("[name=s]").val()==1){
        parent.stateTypeli1();
    }
    if($("[name=s]").val()==2){
        parent.stateTypeli2();
        $(".title span").html("已发布");
        
    }
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
	 $("#delList").click(function(){
	     var a=confirm("确认删除");
	     if(a==true){
	       return true;
	     }if(a!=true){
	       return false;
	     }
	 
	 })
 })
</script>
</head>
<link rel="stylesheet" href="css/issueList.css" type="text/css" />
<body>
      <div class="content">
           <div class="title"><div class="icon"></div><span>待发布</span></div>
           
           <ul class="property">
              <li>顺序</li>
              <li>名称</li>
              <li>缩略图</li>
              <li>时间</li>
              <li></li>
           </ul>
           <div class="clear"></div>
                  <input type="hidden" name="s" value="${state }">
                   <c:forEach items="${requestScope.noticePage.lists}" var="notice" varStatus="xs">
                   <ul class="context">
                     <li>${(requestScope.noticePage.currPage-1)*5+xs.index+1}</li>
		              <li>${notice.title }</li>
		              <li class="img"><img style="width: 100%; height: 100%;"src="${notice.img}" /></li>
		              <li>${notice.createtime }</li>
		              <li>
		              <a href="../notice/look?id=${notice.noticeid}" style="color:#2497DA">查看</a>
		              <a href="../notice/del?id=${notice.noticeid}&&state=${state}" style="color:red" id="delList">删除</a>   
		              </li>
                   </ul>
                   </c:forEach>
                   <div class="clear"></div>
                   <div class="Footline"></div>
          <div class="index">
                    <c:if test="${requestScope.noticePage.currPage != 1}">
                    <a href="../notice/getbystate?currentPage=${requestScope.noticePage.currPage-1}&&state=${state}" style="color:#000;">
                    <li id="front"></li>
                    </a>
                    </c:if>
                    
                    
                    <c:if test="${requestScope.noticePage.totalPage<=5}">
	                    <c:forEach  var="i" begin="1" end="${requestScope.noticePage.totalPage}" step="1">
	                       <a href="../notice/getbystate?currentPage=${i}&&state=${state}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
	                    
	                    </c:forEach>
                    </c:if>
                    <c:if test="${requestScope.noticePage.totalPage>5}">
                    
                        <c:if test="${requestScope.noticePage.currPage==1 || requestScope.noticePage.currPage ==2}">
		                    <c:forEach  var="i" begin="1" end="5" step="1">
		                       <a href="../notice/getbystate?currentPage=${i}&&state=${state}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
		                    
		                    </c:forEach>
	                    </c:if>
                        <c:if test="${requestScope.noticePage.currPage>2}">
		                    <c:if test="${requestScope.noticePage.totalPage-requestScope.noticePage.currPage<=2}">
			                    <c:forEach  var="i" begin="${requestScope.noticePage.totalPage-4}" end="${requestScope.noticePage.totalPage}" step="1">
			                       <a href="../notice/getbystate?currentPage=${i}&&state=${state}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
		                    <c:if test="${requestScope.noticePage.totalPage-requestScope.noticePage.currPage>2}">
			                    <c:forEach  var="i" begin="${requestScope.noticePage.currPage-2}" end="${requestScope.noticePage.currPage+2}" step="1">
			                       <a href="../notice/getbystate?currentPage=${i}&&state=${state}" class="pageNumberA"><li class="pageNumber">${i}</li></a>
			                    
			                    </c:forEach>
		                    </c:if>
	                    
	                   </c:if>
	                    
                    </c:if>
                    
                    
                    
                   
                    
                    
                    
                    
                    
                    
                    <c:if test="${requestScope.noticePage.currPage != requestScope.noticePage.totalPage}">
                    <a href="../notice/getbystate?currentPage=${requestScope.noticePage.currPage+1}&&state=${state}"
				           	style="color:#000;">
                    <li id="rear"></li>
                    </a>
                    </c:if>
                    <li id="ym"><span>第${requestScope.noticePage.currPage }/ ${requestScope.noticePage.totalPage}页</span>&nbsp;&nbsp;</li>
                    <input type="hidden" name="ym" value="${ requestScope.noticePage.currPage }">
                    <input type="hidden" name="zys" value="${requestScope.noticePage.totalPage}">
          </div>
      </div>
</body>
</html>
