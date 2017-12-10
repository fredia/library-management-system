<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html>
<sx:head/>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style>

.box{
	position: absolute;
	width: 450px;
	left:50%;
	top:50%; 
    margin-left:-200px;
    margin-top:-100px;
    border:1px ;
    
   }
.xz{
text-align:center
}
</style>

<title>图书检索</title>
</head>
<body>
<%@ include file="readerheader.jsp"%>
<div class="box">
<form action="../queryres" method="post">
<div>
        <h2 class="text-center"><span class="glyphicon glyphicon-search"></span>输入关键字查询</h2>
        <input type="text" class="form-control" name="input"> 
<div class="xz">
	<s:radio list="#{'0':'书名','1':'作者','2':'出版社'}" name="type" value="0"/>
</div>
<div class="xz">
      <s:checkbox id="permisskey" name="mh" label="模糊查询" value="0" fieldValue="ok"/>
	 <button type="submit" class="btn btn-default">查询</button>
</div>
</div>
</form>
 </div>

</body>
</html>