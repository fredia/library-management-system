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
      <li><a href="../jsp/r_search.jsp"><span class="glyphicon glyphicon-search"></span> 图书检索</a></li>
      <li><a href="nowquery"><span class="glyphicon glyphicon-book"></span> 我的流通</a></li>
      <li><a href="recordquery"><span class="glyphicon glyphicon-list-alt"></span> 借阅历史</a></li>
      <li><a href="../jsp/r_xg.jsp"><span class="glyphicon glyphicon-cog"></span> 修改密码</a></li>
      <li><a href="../jsp/r_gr.jsp"><span class="glyphicon glyphicon-user"></span> 个人画像</a></li>
    </ul>
  </div>
</nav>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
