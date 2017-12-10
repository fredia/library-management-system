<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<link href="../css/toastr.min.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script src="../js/toastr.min.js"></script>
<title>借出管理</title>
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
<%@ include file="manageheader.jsp"%>

<div class="form-horizontal box">
  <div class="form-group">
    <label for="firstname" class="col-sm-3 control-label">读者编号</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="readerid">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-3 control-label">图书编号</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="bookid" >
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-3 control-label">日       期</label>
    <div class="col-sm-9">
      <input type="date" class="form-control"  id="backdate">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" id="btn_sub">确认</button>
    </div>
  </div>
</div>
<script>
$(function(){

	var date = new Date();
	t=date.getFullYear() + '-'+(date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-'+date.getDate();
	//alert(t);
	$("#backdate").val(t);

	});
$("#btn_sub").click(function () {
	 var params = {
   			
   	        readerid:$("#readerid").val(),
   	        bookid:$("#bookid").val(),
   	        day:$("#backdate").val()
  	        };
 	   $.ajax({
            type: "post",
            url: "../borrow.action",
            data: params,
		       dataType:"text",
            success: function(json){  
		    	 var obj = $.parseJSON(json);
           	 var s = obj.ret;
           	 if(s=="借出成功")
           		 {
           		 toastr.success(s);
           		 }
           	 else
           		 {
           		 toastr.error("error!");
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