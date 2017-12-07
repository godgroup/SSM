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
<form method="post" ACTION="${ctx}admin/userlist" id="myform">
	<input type="hidden" name="pageNo" id="currpage" value="1">
	<input type="hidden" name="pageSize" value="10">
	<input type="hidden" name="keyWords" >
</form>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input type="text" value="${keyWords}" id="search_input" name="keyWords" placeholder="请输入关键字"
					class="layui-input search_input">
			</div>
			<a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal userAdd_btn">添加</a>
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
					<th>登录名</th>
					<th>密码</th>
					<th>email</th>
					<th>手机号</th>
					<th>发布时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:forEach items="${items.list}" var="item">
					<tr>

						<td >${item.id }</td>
						<td>${item.login_name }</td>
						<td>${item.password}</td>
						<td>${item.email}</td>
						<td>${item.mobile}</td>
						<td><fmt:formatDate value="${item.create_at}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a data-uid="${item.id }" class="layui-btn layui-btn-mini userAdd_btn"><i
								class="iconfont icon-edit "></i> 编辑</a>

							<a
							class="layui-btn layui-btn-normal layui-btn-mini setAdminRole_btn" data-uid="${item.id }"><i
								class="layui-icon"></i> 设置角色</a><a
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
	<script>
		var total=${items.pages };
		var currPage=${items.pageNum };
	</script>
	<script type="text/javascript" src="${ctx}static/page/admin/userlist.js"></script>
</body>
</html>