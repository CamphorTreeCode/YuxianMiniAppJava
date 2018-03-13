// JavaScript Document
$(function(){
	var ue = UE.getEditor('container');
	$(".textType").click(function(){
		
		 $(".details").toggle();
		
		
		})
	 $(".details li").click(function(){
		  $(this).parent().toggle;
		 })
     $(".del").click(function(){
		  
		  $("#preview").hide();
		  $(".addIcon").show();
		  $(this).hide();
		  })
	 $(".details li").click(function(){
		 $(".textType span").html($(this).html());
		 
	     var type=$(this).val();
		  $.get("../text/getByType",{type:type},function(data){
			var aa=eval(data)
			$(".textid").val(aa[0].textid)
			$("#preview").src=aa[0].img
			$("[name=type]").val(aa[0].type)
			ue.setContent(aa[0].context);
			
		  $(this).parent().toggle;
		  })
		 })
	
	})