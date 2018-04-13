<%@page import="com.woman.tool.UpdataName"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>申肃后台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/notice/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		parent.regist()
		var a = $("[name=ym]").val();
		var b = $("[name=zys]").val();
		if (b <= 5) {
			$(".pageNumber")[a - 1].setAttribute("class", "click");
			$(".pageNumberA")[a - 1].setAttribute("class", "clickNumber");
		}
		if (b > 5) {
			if (b - a >= 2) {
				if (a >= 4) {
					$(".pageNumber")[2].setAttribute("class", "click");
					$(".pageNumberA")[2].setAttribute("class", "clickNumber");
				}

				if (a < 4) {
					$(".pageNumber")[a - 1].setAttribute("class", "click");
					$(".pageNumberA")[a - 1].setAttribute("class", "clickNumber");
				}
			} else {
				$(".pageNumber")[5 - (b - a) - 1].setAttribute("class", "click");
				$(".pageNumberA")[5 - (b - a) - 1].setAttribute("class", "clickNumber");
			}

		}
	}
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
	background: #F2F2F2;
}

.listTitle {
	height: 35px;
	border: 1px solid #EEE;
	border-bottom: none;
	width: 89%;
	background: #fff;
}

.property li {
	float: left;
	list-style: none;
	width: 20%;
	text-align: center;
	line-height: 35px;
	border-right: 1px solid #EEE;
	box-sizing: content-box;
	height: 100%;
	font-size: 1rem;
	color: #333;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.valueListTitle {
	height: 50px;
}

.property｛
    position:relative
  ｝
  .valueListTitle .property li {
	line-height: 50px;
}

span {
	color: #2497DA;
}

span a {
	color: #2497DA;
}

.selectPage {
	width: 80%;
	margin-top: 1.5%;
}
.show{
cursor:pointer;}
.showValue {
	position: fixed;
	width: 88%;
	background: #fff;
	display: none;
	box-shadow: 0px 0px 10px 5px #DCDCDD;
	margin-left: 0.8%;
	
}

.None {
	display: none;
}

.oneList {
	height: 30px;
	border-bottom: 1px solid #F2F2F2;
}

.Name {
	height: 100%;
	margin-left: 3%;
	line-height: 30px;
	color: #333;
}

.NameValue {
	line-height: 30px;
	color: #BBB;
}

.butDown {
	height: 70px;
	margin: 0 auto;
	background: #F2F2F2
}

.downWd {
	height: 40px;
	line-height: 40px;
	color: #fff;
	background: #1196DB;
	width: 16%;
	text-align: center;
	margin-left: 8%;
	margin-right: 8%;
	text-decoration: none;
}

.lhight li {
	line-height: 50px;
}

.index {
	width: 930px;
	padding-left: 230px;
	margin-top: 10px;
}

.index li {
	float: left;
	width: 25px;
	height: 25px;
	border-radius: 5px;
	border: 1px solid #1897DA;
	margin: 10px;
	text-align: center;
	line-height: 25px;
}

.click {
	background: #1897DA;
}

.clickNumber {
	color: #fff;
}

a.pageNumberA {
	color: #1897DA;
}

#ym {
	width: 100px;
	text-align: center;
}

#front {
	background-image: url("../notice/img/next2.png");
	background-size: 200px 200px;
	background-position: 50% 50%;
	border: none;
	width: 27px;
	height: 27px;
}

#rear {
	background-image: url("../notice/img/next.png");
	background-size: 200px 200px;
	background-position: 50% 50%;
	border: none;
	width: 27px;
	height: 27px;
	margin-bottom: 2px;
}

* {
	list-style: none;
}

.quxiao {
	background: #f9f9f9;
	height: 35px;
}

.quxiaoimg {
     height: 20px;
    width: 20px;
    /* border: 1px solid red; */
    margin-top: 7px;
    margin-right: 2%;
}
.quxiaoimg img{
  height:100%;
  width:100%;
  display:block;

}
.hidden{
cursor:pointer;}

</style>

<script>

	$(function() {
	//	var url = "http://localhost/Maven_Project/"
	var url ='<%=UpdataName.urlName%>/<%=UpdataName.projectName%>/'
		//显示公司详细信息
		$('.show').click(function() {
			//var myid= e.currentTarget.dataset.value;
			var p = $(this).attr('data');
			var showState = $(this).attr('datb');
			console.log(p, showState)
			if (showState == 0) {
				$(this).text("查看");
			}
			//  alert(p)
			var that = this
			if ($(that).parent().parent().parent().find(".showValue").css("display") == "none") {
				$.ajax({
					type : 'get',
					url : url + "shareholder/selectShareholder",
					dataType : 'json',
					data : {
						companyid : p,
						showState : showState
					},
					beforeSend : function() {
						//   obj.html('正在处理...');  
					},
					success : function(json) {
						console.log(json)
						if ($("#ids" + p).length > 0) {
							console.log(111)

						} else {
							$.each(json, function(index, item) {
								//循环获取数据  
								/*    var name = json[index].Name;
								   var idnumber = json[index].IdNumber;
								   var sex = json[index].Sex; */
								console.log(item)
								$(that).parent().parent().parent().find(".showValue").append(
									"<div id='ids" + p + "' class='oneList cl ''><div class='showName lf '>股东姓名：</div><div class='showNameValue lf'>" + item.name + "</div></div>"
									+ "<div  class='oneList cl '><div class='showName lf '>股东电话：</div><div class='showNameValue lf'>" + item.phone + "</div></div>"
									+ "<div  class='oneList cl '><div class='showName lf '>股东邮箱：</div><div class='showNameValue lf'>" + item.email + "</div></div>"
									+ "<div  class='oneList cl '><div class='showName lf '>股东比例：</div><div class='showNameValue lf'>" + item.holdscale + "%</div></div>"
									+ "<div  class='oneList cl '><div class='showName lf '>股东身份证号码：</div><div class='showNameValue lf'>" + item.idcard + "</div></div>");

							});
							$(that).parent().parent().parent().find(".showValue").append(
								"<div id='ids" + p + "' class='butDown boxCenter'>"
								+ "<a id='downWd' data='" + p + "' class='downWd lf'  href='" + url + "tool/exportMillCertificate?companyId=" + p + "'>下载文档</a>"
								+ "<a id='downId' data='" + p + "' href='" + url + "tool/downloadImg?companyId=" + p + "' class='downIdcard downWd lf'>下载身份证</a>"
								+ "</div>"
								+ "</div> "
							)



						}


						// alert(json)
						$(that).parent().parent().parent().parent().find(".showValue").hide();
						$(that).parent().parent().parent().find(".showValue").show();

					}
				});
			} else {
				$(that).parent().parent().parent().parent().find(".showValue").hide();
			}


		})


    $('.hidden').click(function() {
     console.log("111")
$(this).parent().parent().parent().parent().find(".showValue").hide();
})



	})
</script>
</head>

<body>
	<div class="body">

		<div class="listTitle ">
			<ul class="property box">
				<li>顺序</li>
				<li>名称</li>
				<li>联系方式</li>
				<li>公司申请时间</li>
				<li></li>
			</ul>
		</div>
		<c:forEach items="${requestScope.companyPage.lists}" var="company"
			varStatus="i">
			<div class="listTitle valueListTitle">


				<ul class="property lhight box">
					<li>${i.index+1}</li>
					<li>${company.companyname}</li>
					<li>${company.linkphone}</li>
					<li>${company.createtime}</li>
					<li><span class="show" data="${company.companyid}"
						datb="${company.showState}">
							${company.showState==0?"未查看":"查看"}</span></li>
				</ul>


				<div class="showValue">
					<div class="quxiao ">
						<div class="quxiaoimg ri">
							<img class="hidden" src="https://www.chuanshoucs.com/ImgRegCompany/quxiao.png">
						</div>

					</div>
					<div class="oneList cl ">
						<div class="showName lf ">名称：</div>
						<div class="showNameValue lf">${company.companyname}</div>
					</div>
					<div class="oneList cl ">
						<div class="showName lf ">备选名称：</div>
						<div class="showNameValue lf">${company.remarkname}</div>
					</div>
					<div class="oneList cl ">
						<div class="showName lf ">企业类型：</div>
						<div class="showNameValue lf">${company.enterprisetype}</div>
					</div>
					<div class="oneList cl ">
						<div class="showName lf ">注册资本：</div>
						<div class="showNameValue lf">${company.registeredcapital}万</div>
					</div>
					<div class="oneList businessscope cl ">
						<div class="showName lf ">经营范围：</div>
						<div class="showNameValue lf">${company.businessscope}</div>
					</div>
					<div class="oneList businessscope cl ">
						<div class="showName lf ">公司类别：</div>
						<div class="showNameValue lf">${company.companytype}</div>
					</div>

				</div>
			</div>
		</c:forEach>

		<div class="index">
			<c:if test="${requestScope.companyPage.currPage != 1}">
				<a
					href="${pageContext.request.contextPath }/company/companyPage?currentPage=${requestScope.companyPage.currPage-1}&&state=${state}"
					style="color:#000;">
					<li id="front"></li>
				</a>
			</c:if>


			<c:if test="${requestScope.companyPage.totalPage<=5}">
				<c:forEach var="i" begin="1"
					end="${requestScope.companyPage.totalPage}" step="1">
					<a
						href="${pageContext.request.contextPath }/company/companyPage?currentPage=${i}"
						class="pageNumberA"><li class="pageNumber">${i}</li></a>

				</c:forEach>
			</c:if>
			<c:if test="${requestScope.companyPage.totalPage>5}">

				<c:if
					test="${requestScope.companyPage.currPage==1 || requestScope.companyPage.currPage ==2}">
					<c:forEach var="i" begin="1" end="5" step="1">
						<a
							href="${pageContext.request.contextPath }/company/companyPage?currentPage=${i}"
							class="pageNumberA"><li class="pageNumber">${i}</li></a>

					</c:forEach>
				</c:if>
				<c:if test="${requestScope.companyPage.currPage>2}">
					<c:if
						test="${requestScope.companyPage.totalPage-requestScope.companyPage.currPage<=2}">
						<c:forEach var="i" begin="${requestScope.companyPage.totalPage-4}"
							end="${requestScope.companyPage.totalPage}" step="1">
							<a
								href="${pageContext.request.contextPath }/company/companyPage?currentPage=${i}"
								class="pageNumberA"><li class="pageNumber">${i}</li></a>

						</c:forEach>
					</c:if>
					<c:if
						test="${requestScope.companyPage.totalPage-requestScope.companyPage.currPage>2}">
						<c:forEach var="i" begin="${requestScope.companyPage.currPage-2}"
							end="${requestScope.companyPage.currPage+2}" step="1">
							<a
								href="${pageContext.request.contextPath }/company/companyPage?currentPage=${i}"
								class="pageNumberA"><li class="pageNumber">${i}</li></a>

						</c:forEach>
					</c:if>

				</c:if>

			</c:if>










			<c:if
				test="${requestScope.companyPage.currPage != requestScope.companyPage.totalPage}">
				<a
					href="${pageContext.request.contextPath }/company/companyPage?currentPage=${requestScope.companyPage.currPage+1}"
					style="color:#000;">
					<li id="rear"></li>
				</a>
			</c:if>
			<li id="ym"><span>第${requestScope.companyPage.currPage }/
					${requestScope.companyPage.totalPage}页</span>&nbsp;&nbsp;</li> <input
				type="hidden" name="ym"
				value="${ requestScope.companyPage.currPage }"> <input
				type="hidden" name="zys"
				value="${requestScope.companyPage.totalPage}">
		</div>
	</div>
</body>
</html>
