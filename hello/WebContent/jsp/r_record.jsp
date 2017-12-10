<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
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
<title>借阅历史</title>
</head>
<body>
<%@ include file="readerheader.jsp"%>
<table class="table table-striped">
  <caption>当前借阅信息</caption>
  <thead>
    <tr>
      <th>读者编号</th>
      <th>图书编号</th>
      <th>图书名</th>
      <th>作者</th>
      <th>出版社</th>
      <th>借书日期</th>
      <th>还书日期</th>
    </tr>
  </thead>
  <tbody>
    <s:iterator value="reclist" var="var">   
    <tr>   
     <td><s:property value="#var.readerid"/></td>   
     <td><s:property value="#var.bookid"/></td> 
     <td><s:property value="#var.book.name"/></td> 
     <td><s:property value="#var.book.author"/></td> 
     <td><s:property value="#var.book.publish"/></td>    
     <td><s:property value="#var.dateborrow"/></td> 
      <td><s:property value="#var.datereturn"/></td> 
    </tr>   
    </s:iterator>   
  </tbody>
</table> 
</body>
</html>