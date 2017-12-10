<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">


<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">welcome</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../jsp/m_reader.jsp"><span class="glyphicon glyphicon-user"></span>读者管理</a></li>
      <li><a href="../jsp/m_book.jsp"><span class="glyphicon glyphicon-book"></span>图书管理</a></li>
      <li><a href="../jsp/m_borrow.jsp"><span class="glyphicon glyphicon-log-out"></span>借书管理</a></li>
      <li><a href="../jsp/m_back.jsp"><span class="glyphicon glyphicon-log-in"></span>还书管理</a></li>
    </ul>
  </div>
</nav>
