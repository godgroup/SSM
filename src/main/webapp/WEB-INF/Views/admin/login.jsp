<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var="ctx" value="${pageContext.request.contextPath}/" />
	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">

	<script type="text/javascript">
		var ctx = "${ctx}";
	</script>

	<link rel="stylesheet" href="${ctx}static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="/SSM/static/css/login.css" media="all" />

	<title>图书管理系统登录</title>
</head>
<body>


	<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">
		<source src="/SSM/static/page/login/login.mp4"   type="video/mp4">
		<!-- 此视频文件为支付宝所有，在此仅供样式参考，如用到商业用途，请自行更换为其他视频或图片，否则造成的任何问题使用者本人承担，谢谢 -->
	</video>
	<div class="video_mask"></div>
	<div class="login">
		<h1>图书管理系统登录</h1>
		<form class="layui-form" id="forms">
			<div class="layui-form-item">
				<input class="layui-input" name="loginName" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
			</div>
			<div class="layui-form-item">
				<input class="layui-input" name="pswd" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
			</div>

			<button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		</form>
	</div>


	<script type="text/javascript" src="/SSM/static/layui/layui.js"></script>
	<script type="text/javascript" src="/SSM/static/page/login/login.js"></script>
</body>
</html>