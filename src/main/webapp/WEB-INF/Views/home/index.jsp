<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/lib.jsp" %>
<title>欢迎进入SSM</title>
</head>
<body>

<h1>欢迎进入SSM系统</h1>
<button type="button" class="btn btn-primary" onclick="getUserName();">ajax获取用户名</button>

<script>
	function getUserName()
	{
		$.post(ctx+'home/getUserName',function(result){
			if(result.success)
			{
				alert(result.username);
			}
		},'json');
	}
</script>
</body>
</html>