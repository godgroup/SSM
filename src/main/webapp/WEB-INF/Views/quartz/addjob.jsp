<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>新增任务</title>
      <%@ include file="/include/lib.jsp" %>
      <link rel="stylesheet" href="${ctx}static/css/news.css" media="all" />
  </head>

  <body class="childrenBody">
  <form  class="layui-form" style="width:80%;" action="${pageContext.request.contextPath }/quartz/add" method="post">
  <span>新增Trigger</span>
	<hr/>
      <div class="layui-form-item">
          <label class="layui-form-label">cron表达式</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="cron" lay-verify="required" placeholder="请输入cron表达式">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">clazz</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="clazz" lay-verify="required" placeholder="请输入clazz">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">jobName</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="jobName" lay-verify="required" placeholder="请输入jobName">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">jobGroupName</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="jobGroupName" lay-verify="required" placeholder="请输入jobGroupName">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">triggerName</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="triggerName" lay-verify="required" placeholder="请输入triggerName">
          </div>
      </div>
      <div class="layui-form-item">
          <label class="layui-form-label">triggerGroupName</label>
          <div class="layui-input-block">
              <input type="text" class="layui-input linksName" value="${item.name}" name="triggerGroupName" lay-verify="required" placeholder="请输入triggerGroupName">
          </div>
      </div>
      <div class="layui-form-item">
          <div class="layui-input-block">
              <button type="submit" class="layui-btn">提交</button>
              <button class="layui-btn layui-btn-primary cancel"  type="button" style="border: 0;background-color: #fff;">返回</button>

          </div>
      </div>

  </form>
  </body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script>
$(document).ready(function() {
    var url = "${pageContext.request.contextPath}";
	$(".cancel").click(function(){
        window.location.href = url + "/quartz/listjob";
	});
});
</script>

