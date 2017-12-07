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
  <input type="hidden" value="${item.id}" name="id">
  <div class="layui-form-item">
    <label class="layui-form-label">登录用户名</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input linksName" value="${item.login_name}" autocomplete="off" name="login_name" lay-verify="required" placeholder="用于登录系统">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">登录密码</label>
    <div class="layui-input-block">
      <input type="password" class="layui-input linksUrl" value="${item.password}" autocomplete="off" name="password" lay-verify="required" placeholder="请输入登录密码">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">昵称</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input linksUrl" value="${item.name}" name="name"  placeholder="请输入昵称">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input linksUrl" value="${item.email}" name="email"  lay-verify="email" placeholder="请输入邮箱">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">手机号</label>
    <div class="layui-input-block">
      <input type="text" class="layui-input linksUrl" value="${item.mobile}" name="mobile"  lay-verify="phone" placeholder="请输入手机号">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">是否禁用</label>
    <div class="layui-input-block">
      <input type="radio" name="status" value="enable" title="enable" <c:if test="${item.status eq 'enable'}">checked</c:if>>
      <input type="radio" name="status" value="disabled" title="disabled" <c:if test="${item.status eq 'disabled'}">checked</c:if>>

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

    </div>
  </div>
</form>

<script type="text/javascript" src="${ctx}static/page/admin/adduser.js"></script>
</body>
</html>
