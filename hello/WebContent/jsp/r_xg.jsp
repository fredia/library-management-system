<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<link href="../css/toastr.min.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script src="../js/toastr.min.js"></script>
<title>修改密码</title>
<style>

.box{
	position: absolute;
	width: 450px;
	left:50%;
	top:50%; 
    margin-left:-200px;
    margin-top:-100px;
    border:1px ;
    text-align:center
   }
.xz{
text-align:center
}
</style>
</head>
<body>
<%@ include file="readerheader.jsp"%>
<div class="form-horizontal box">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">旧密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="old">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="new1" >
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control"  id="new2">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" id="btn_sub">确认修改</button>
    </div>
  </div>
</div>
<script>
$("#btn_sub").click(function () {
	 var params = {
    			
    	        oldpass:$("#old").val(),
    	        newpass1:$("#new1").val(),
    	        newpass2:$("#new2").val()
   	        };
	 if(params.newpass1!=params.newpass2)
		 {
		    toastr.error('新密码不一致');
		    return;
		 }
  	   $.ajax({
             type: "post",
             url: "../updatepass.action",
             data: params,
 		       dataType:"text",
             success: function(json){  
		    	 var obj = $.parseJSON(json);
            	 var s = obj.ret;
            	 if(s=="修改密码成功")
            		 {
            		 toastr.success(s);
            		 }
            	 else
            		 {
            		 toastr.error(s);
            		 }
             },
             error: function () {
          	   toastr.error('Error');
             },
             complete: function () {

             }

         }); 
 });
</script>
</body>
</html>