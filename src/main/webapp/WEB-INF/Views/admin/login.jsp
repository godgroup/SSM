<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">


<script type="text/javascript" src="${ctx}static/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}static/js/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}static/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}";
</script>
<title>SSM登录</title>
</head>
<body>
	<form id="forms">
		<p>登录名：<input type="text" id="name" name="loginName" /></p>
		<p>密码：<input type="text" id="pswd" name="pswd" /></p>
	</form>
	<button type="button" onclick="login();">登录</button>
	
	<script>
	$(function(){
		$('#forms').validate({
			rules:{
				loginName:"required",
				pswd:"required"
			},
			messages:{
				loginName:'请输入登录名',
				pswd:'请输入密码'
			}
		});
	});
		function login()
		{
			if($('#forms').valid())
			{
				$.post(ctx+'admin/loginValidate',$('#forms').serialize(),function(result){
					if(result.success){
						window.location.href=ctx+'home/index';
					}else{
						alert(result.data);
					}
				},'json');
			}
		}
	</script>
</body>
</html>