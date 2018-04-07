/**
 * 员工管理js
 */
	$(function() {
	
	$("#upimg").click(function(){
       $("#upload_file").click();
       /* var pic = $('#upload_file')[0].files[0];     */ 

});
$("#upload_file").change(function(){     
            if (window.createObjectURL != undefined) { 
                url = window.createObjectURL(this.files[0]);
            } else if (window.URL != undefined) { 
                url = window.URL.createObjectURL(this.files[0]);
            } else if (window.webkitURL != undefined) { 
                url = window.webkitURL.createObjectURL(this.files[0]);
            }
      console.log(1,url)
      if(url){
      $("#head").attr("src",url); 
      $("#head").attr("class","imgcss")
   }
 })
       function getUrl(file){
            var url=null;
      
            return url;
      }
})