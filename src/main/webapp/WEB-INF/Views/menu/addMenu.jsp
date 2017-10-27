<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/lib.jsp" %>
<title>文章列表--layui后台管理模板</title>
<link rel="stylesheet" href="${ctx}static/css/news.css" media="all" />
</head>


<body class="childrenBody">
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">网站名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input linksName" lay-verify="required" placeholder="请输入网站名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">网站地址</label>
			<div class="layui-input-block">
				<input type="tel" class="layui-input linksUrl" lay-verify="required|url" placeholder="请输入网站地址">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">展示位置</label>
				<div class="layui-input-block">
					<input type="checkbox" name="homePage" class="homePage" title="首页" checked>
					<input type="checkbox" name="subPage" class="subPage" title="子页">
				</div>
			</div>
			<div class="layui-inline">		
				<label class="layui-form-label">发布时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input linksTime" lay-verify="date" onclick="layui.laydate({elem:this})">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站长邮箱</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input masterEmail" lay-verify="email" placeholder="请输入网站地址">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点描述</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入站点描述" class="layui-textarea linksDesc"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addLinks">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="linksAdd.js"></script>
</body>
</html>