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
	<blockquote class="layui-elem-quote news_search">

		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal rolesAdd_btn">添加</a>
		</div>
		

		
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<colgroup>

					<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>

					<th >id</th>
					<th>角色名</th>
					<th>备注</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:forEach items="${itemsList}" var="item">
					<tr>

						<td >${item.id }</td>
						<td>${item.name }</td>
						<td>${item.remarks}</td>
						<td><fmt:formatDate value="${item.create_at}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a data-id="${item.id }" class="layui-btn layui-btn-mini rolesAdd_btn"><i
									class="iconfont icon-edit "></i> 编辑</a>
							<a data-id="${item.id }" class="layui-btn layui-btn-mini setRoleMenu_btn"><i
								class="iconfont icon-edit "></i> 设置权限</a>
							<a class="layui-btn layui-btn-danger layui-btn-mini news_del"
							data-id="1"><i class="layui-icon"></i> 删除</a></td>
					</tr>
					<tr>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="${ctx}static/page/rolemenu/rolemenu.js"></script>
</body>
</html>