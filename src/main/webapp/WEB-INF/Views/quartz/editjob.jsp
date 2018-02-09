<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>编辑任务</title>
	  <%@ include file="/include/lib.jsp" %>
	  <link rel="stylesheet" href="${ctx}static/css/news.css" media="all" />
  </head>
  <body class="childrenBody">
  <form action="${pageContext.request.contextPath }/quartz/edit" method="post">
	<input type="hidden" name="oldjobName" value="${pd.jobName}" >
	<input type="hidden" name="oldjobGroup" value="${pd.jobGroup}" >
	<input type="hidden" name="oldtriggerName" value="${pd.triggerName}" >
	<input type="hidden" name="oldtriggerGroup" value="${pd.triggerGroupName}" >
	<span>编辑Trigger</span>
	<hr/>
	  <div class="layui-form-item">
		  <label class="layui-form-label">cron表达式</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="$${pd.cron}" name="cron" lay-verify="required" placeholder="请输入cron表达式">
		  </div>
	  </div>
	  <div class="layui-form-item">
		  <label class="layui-form-label">clazz</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="${pd.clazz}" name="clazz" lay-verify="required" placeholder="请输入clazz">
		  </div>
	  </div>
	  <div class="layui-form-item">
		  <label class="layui-form-label">jobName</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="${pd.jobName}" name="jobName" lay-verify="required" placeholder="请输入jobName">
		  </div>
	  </div>
	  <div class="layui-form-item">
		  <label class="layui-form-label">jobGroupName</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="${pd.jobGroup}" name="jobGroupName" lay-verify="required" placeholder="请输入jobGroupName">
		  </div>
	  </div>
	  <div class="layui-form-item">
		  <label class="layui-form-label">triggerName</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="${pd.triggerName}" name="triggerName" lay-verify="required" placeholder="请输入triggerName">
		  </div>
	  </div>
	  <div class="layui-form-item">
		  <label class="layui-form-label">triggerGroupName</label>
		  <div class="layui-input-block">
			  <input type="text" class="layui-input linksName" value="${pd.triggerGroupName}" name="triggerGroupName" lay-verify="required" placeholder="请输入triggerGroupName">
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
	$(".cancel").click(function(){
		history.go(-1) ;
	});
});
</script>
