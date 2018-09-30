<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    	$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		});
		$(".loginbody .loginbtn").click(function(){
			$(".loginbody .errormsg label").html("");
			var userName = $(".loginbody .loginuser").val();
			var password = $(".loginbody .loginpwd").val();
			if(userName==null||userName==""){
				$(".loginbody .loginuser").focus();
				$(".loginbody .errormsg label").html("用户名为空");
				return false;
			}
			if(password==null||password==""){
				$(".loginbody .loginpwd").focus();
				$(".loginbody .errormsg label").html("密码为空");
				return false;
			}
		});
	})
</script>
</head>
<body>
    <div class="mainBody">
      <div class="cloud"></div>
      <div class="cloud" style="z-index:2;"></div>
    </div>  
	<div class="logintop">    
	    <span>欢迎登录后台管理界面平台</span>    
	    <ul>
		    <li><a href="#">回首页</a></li>
		    <li><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
	    </ul>    
    </div>
    <div class="loginbody">
    	<span class="systemlogo"></span> 
	    <form class="loginbox" action="${pageContext.request.contextPath}/login" method="post">
		    <ul>
			    <li><input name="userName" type="text" class="loginuser" value="" placeHolder="用户名"/></li>
			    <li><input name="password" type="password" class="loginpwd" placeHolder="密码"/></li>
			    <li>
			    	<input name="" type="submit" class="loginbtn" value="登录"/>
			    	<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label>
			    </li>
			    <li class="errormsg"><label>${errorMsg }</label></li>
		    </ul>
    	</form>
    </div>
    <div class="loginbm">版权所有  2013  <a href="http://www.kytc.com">kytc.com</a>  仅供学习交流，勿用于任何商业用途</div>
</body>
</html>