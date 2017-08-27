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
			<div class="layui-input-inline">
				<input type="text" value="" placeholder="请输入关键字"
					class="layui-input search_input">
			</div>
			<a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn">添加</a>
		</div>
		
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
		</div>
		
	</blockquote>
	<div class="layui-form news_list">
		<table class="layui-table">
			<colgroup>
				<col width="9%">
					<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="9%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>勾选</th>
					<th >id</th>
					<th>登录名</th>
					<th>密码</th>
					<th>email</th>
					<th>手机号</th>
					<th>发布时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:forEach items="${itemsList}" var="item">
					<tr>
						<td><input type="checkbox" name="checked" lay-skin="primary"
							lay-filter="choose">
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary">
								<i class="layui-icon"></i>
							</div></td>
						<td >${item.id }</td>
						<td>${item.login_name }</td>
						<td>${item.password}</td>
						<td>${item.email}</td>
						<td>${item.mobile}</td>
						<td><fmt:formatDate value="${item.create_at}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a class="layui-btn layui-btn-mini news_edit"><i
								class="iconfont icon-edit"></i> 编辑</a><a
							class="layui-btn layui-btn-normal layui-btn-mini news_collect"><i
								class="layui-icon"></i> 收藏</a><a
							class="layui-btn layui-btn-danger layui-btn-mini news_del"
							data-id="1"><i class="layui-icon"></i> 删除</a></td>
					</tr>
					<tr>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page"></div>
	

</body>
</html>