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
    	 $(".file").val("");
		  $("#preview").hide();
		  $(".addIcon").show();
		  $(this).hide();
		  })
	 var textType='工商注册';
	 $(".details li").click(function(){
		 
		textType=$(this).html();
	     var type=$(this).val();
	     $(".textType span").html($(this).html());
		  $.get("../text/getByType",{type:type},function(data){
			var aa=eval(data)
			
			$("[name=textid]").val(aa[0].textid)
			$("#preview").attr("src",aa[0].img)
			$("[name=file1]").val(aa[0].img)
			$("[name=type]").val(aa[0].type)
			ue.setContent(aa[0].context);
			
		    $(this).parent().toggle;
		  })
		 })
		 $("#submit").click(function(){
			var a=confirm("确认修改文本信息吗？("+textType+")")
			if(a==true){
				return true;
			}else{
				return false;
			}
			
			
			 
		 })
		 parent.option();

		 
	})