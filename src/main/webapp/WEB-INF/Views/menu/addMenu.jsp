<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/lib.jsp" %>
<title>文章列表--layui后台管理模板</title>
<link rel="stylesheet" href="${ctx}static/css/news.css" media="all" />
<link rel="stylesheet" href="${ctx}static/css/treeselect.css" media="all" />
</head>


<body class="childrenBody">
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">菜单名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input linksName" name="name" lay-verify="required" placeholder="请输入网站名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单地址</label>
			<div class="layui-input-block">
				<input type="tel" class="layui-input linksUrl" name="href" lay-verify="required|url" placeholder="请输入网站地址">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">类型</label>
		    <div class="layui-input-block">
		      <input type="radio" name="type" value="menu" title="menu">
		      <input type="radio" name="type" value="page" title="page" checked>
		      <input type="radio" name="type" value="action" title="action" >
		    </div>
	    </div>
		<div class="layui-form-item">
		    <label class="layui-form-label">是否禁用</label>
		    <div class="layui-input-block">
		      <input type="radio" name="status" value="disabled" title="disabled">
		      <input type="radio" name="status" value="enable" title="enable" checked>
		     
		    </div>
	    </div>
		<div class="layui-form-item">
			<label class="layui-form-label">父菜单</label>
			<div class="layui-input-block">
				<input type="text" id="treeselecttest11" name="icon" placeholder="请选择" autocomplete="off" class="layui-input">
				<ul id="treeselecttest"></ul>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addLinks">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	
	<script type="text/javascript" src="${ctx}static/page/links/linksAdd.js"></script>
</body>
</html>