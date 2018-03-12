// JavaScript Document
$(function(){
	
	$(".notice").click(function(){
		$(".position span").html("发布公告")
		$(".stateType").show(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(this).addClass("clickColor");
		})
	
	$(".stateType li").click(function(){
		a=$(this).html()
	    $(".position span").html("公告查询("+a+")")
	    $(".stateType li").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
	    $(this).addClass("clickColor");
		
		})
	$(".wxIndex").click(function(){
		$(".position span").html("小程序首页")
		$(".stateType").hide(500);
		$(".stateType li").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(".regist").removeClass("clickColor");
		$(this).addClass("clickColor");
		})
	$(".regist").click(function(){
		 $(".position span").html("工商注册信息")
		 $(".stateType").hide(500);
		$(".stateType li").removeClass("clickColor");
		$(".wxIndex").removeClass("clickColor");
		$(".notice").removeClass("clickColor");
		$(this).addClass("clickColor");
		})
	})
	
