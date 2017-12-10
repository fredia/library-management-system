<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jieguo</title>
</head>
<body>
<table border="1" width="50%"  cellspacing="0" cellpadding="0">   
    <tr>   
      <td>key=value</td>   
      <td>ID</td>     
    </tr>   
    <s:iterator value="booklist" var="var">   
    <tr>   
     <td><s:property value="#var.name"/></td>   
     <td><s:property value="#var.author"/></td>      
    </tr>   
    </s:iterator>   
  </table>   
</body>
</html>