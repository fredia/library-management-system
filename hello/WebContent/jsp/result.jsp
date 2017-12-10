 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<title>测试</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
</head>
<body>
<a href="#" id='1' class="lj" >aa</a>
<a href="#" id='2' class="lj" >ab</a>
 <script type="text/javascript">
 $(function() {
	 $(".lj").click(function() {
		 
  	 var idd =event.target.text;
  	 alert(idd);
  	var params = {
	          
	           bookid : idd
	        };
	 $.ajax({
		    type: "POST",
		    url: "../bookxq.action",
		    data: params,
		    dataType:"text",
		    error:function(){
	            alert("执行错误！");
	        }
	 });
  	 
   });
});
 $(function() {
	    $('#myModal').modal('toogle')
	});
 </script>
</body>
</html> 