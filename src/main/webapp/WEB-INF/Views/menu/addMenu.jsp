<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/lib.jsp" %>
<title>文章列表--layui后台管理模板</title>
<link rel="stylesheet" href="${ctx}static/css/news.css" media="all" />
<link rel="stylesheet" href="${ctx}static/css/treeselect.css?v=1" media="all" />
</head>


<body class="childrenBody">
	<form class="layui-form" style="width:80%;">
	<input type="hidden" value="${item.id}" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">菜单名称</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input linksName" value="${item.name}" name="name" lay-verify="required" placeholder="请输入网站名称">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">菜单地址</label>
			<div class="layui-input-block">
				<input type="tel" class="layui-input linksUrl" value="${item.href}" name="href" lay-verify="required" placeholder="请输入网站地址">
			</div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">类型</label>
		    <div class="layui-input-block">
		      <input type="radio" name="type" value="menu" title="menu" <c:if test="${item.type eq 'menu'}">checked</c:if>>
		      <input type="radio" name="type" value="page" title="page" <c:if test="${item.type eq 'page'}">checked</c:if>>
		      <input type="radio" name="type" value="action" title="action" <c:if test="${item.type eq 'action'}">checked</c:if> >
		    </div>
	    </div>
		<div class="layui-form-item">
		    <label class="layui-form-label">是否禁用</label>
		    <div class="layui-input-block">
		      <input type="radio" name="status" value="disabled" title="disabled" <c:if test="${item.status eq 'disabled'}">checked</c:if>>
		      <input type="radio" name="status" value="enable" title="enable" <c:if test="${item.status eq 'enable'}">checked</c:if>>
		     
		    </div>
	    </div>
		<div class="layui-form-item">
			<label class="layui-form-label">父菜单</label>
			<div class="layui-input-block">
				<input type="text" id="treeselecttest11" value="${item.parent_id}"  name="parent_id" placeholder="请选择" autocomplete="off" class="layui-input">
				
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-block">
				<input type="text" class="layui-input linksName" value="${item.remarks}" name="remarks" lay-verify="" placeholder="请输入备注">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addLinks">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	
	<script type="text/javascript" src="${ctx}static/page/menu/addmenu.js"></script>
</body>
</html>