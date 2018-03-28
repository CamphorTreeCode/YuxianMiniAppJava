// JavaScript Document
$(function(){
	 var ue = UE.getEditor('container');
	  $(".del").click(function(){ 
		  $("#preview").hide();
		  $(".addIcon").show();
		  $(this).hide();
		  })
		parent.notice();
	  $("[name=title]").attr({maxlength:"20"});
	  
	  $("[name=submit]").click(function(){
		  var marker=true;
		  
		  if($("[name=title]").val().length==0){
			  marker=false;
			  dis=false;
			  alert("标题不能为空")  
		  }
		  if($("[name=file]")[0].files[0]==null){
			  marker=false;
			  dis=false;
			  alert("图片不能为空")
			  
		  }
		  if(marker==false){
			  this.disable=false
		  }

		  if(marke==true){
			  this.disable=true
		  }

		  return marker;
		  
	 
		  
	  })
	  $("[name=wait]").click(function(){
		  
		  var marker=true;
		  if($("[name=title]").val().length==0){
			  marker=false;
			  alert("标题不能为空")  
		  }
		  if(marker==false){
			  this.disable=false
		  }

		  if(marke==true){
			  this.disable=true
		  }

		  return marker;
		  
	  })
	  $("[name=looksubmit]").click(function(){
		  var marker=true;
		  if($("[name=title]").val().length==0){
			  marker=false;
			  alert("标题不能为空")  
		  }
		  if($("[name=file1]").val()==""){
			  if($("[name=file]")[0].files[0]==null){
				  marker=false;
				  alert("图片不能为空")
				  
			  }
		  }
		  if(ue.getContentTxt().length==0){
			  marker=false;
			  alert("正文不能为空")
		  }
		  if(marker==false){
			  this.disable=false
		  }

		  if(marke==true){
			  this.disable=true
		  }
		  return marker;
		  
		  
	  })
	})