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
	<form method="post" ACTION="${ctx}menu/menulist" id="myform">
		<input type="hidden" name="pageNo" id="currpage" value="1">
		<input type="hidden" name="pageSize" value="10">
		<input type="hidden" name="keyWords" >
	</form>
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
			<div class="layui-input-inline">
				<input type="text" value="${keyWords}" id="search_input" placeholder="请输入关键字"
					class="layui-input search_input">
			</div>
			<a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal menuAdd_btn">添加</a>
		</div>
		
		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger batchDel">批量禁用</a>
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
				<col width="9%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>勾选</th>
					<th >id</th>
					<th>菜单名</th>
					<th>菜单链接</th>
					<th>菜单类型</th>
					<th>状态</th><th>备注</th>
					<th>添加时间</th>
					
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:forEach items="${items.list}" var="item">
					<tr>
						<td><input type="checkbox" name="checked" lay-skin="primary"
							lay-filter="choose">
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary">
								<i class="layui-icon"></i>
							</div></td>
						<td >${item.id }</td>
						<td>${item.name }</td>
						<td>${item.href}</td>
						<td>${item.type}</td>
						<td>${item.status}</td><td>${item.remarks}</td>
						<td><fmt:formatDate value="${item.create_at}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a data-id="${item.id }" class="layui-btn layui-btn-mini menuAdd_btn"><i
								class="iconfont icon-edit "></i> 编辑</a>
							<a class="layui-btn layui-btn-danger layui-btn-mini news_del"
							data-id="1"><i class="layui-icon"></i> 禁用</a></td>
					</tr>
					<tr>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div id="page" style="margin:0 auto; "></div>
	<script>
		var total=${items.pages };
		var currPage=${items.pageNum };
	</script>
	<script type="text/javascript" src="${ctx}static/page/menu/menulist.js" ></script>
</body>
</html>