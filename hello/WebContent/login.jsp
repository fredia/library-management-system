<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>
	
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
     <link rel="stylesheet" href="css/style.css">
	 <script src="js/jquery-1.11.1.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
	<script src="js/loginscripts.js"></script>
	 <script src="js/jquery.backstretch.min.js"></script>
</head>
<body>
 <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>欢迎</strong>来到登录界面</h1>
                            <div class="description">
                            	
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录到图书管理系统</h3>
                            		<p>请输入您的用户名和密码登录</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="name" placeholder="Username..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="pass" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
			                 
			                        <div>
			                        <label>
			                         <input type="checkbox" name="ism"  value="1" >
									    管理员
									</label>
			                        </div>
			                        
			                        <button type="submit" class="btn">Sign in!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>

</body>
</html>