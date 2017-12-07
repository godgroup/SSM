<<%@ page language="java" contentType="text/html; charset=UTF-8"
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
  <input type="hidden" value="${item.id}" name="id">
  <div class="layui-form-item">
    <label class="layui-form-label">角色名字</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input linksName" value="${item.name}" name="name" lay-verify="required" placeholder="请输入网站名称">
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

<script type="text/javascript" src="${ctx}static/page/rolemenu/addrole.js"></script>
</body>
</html>