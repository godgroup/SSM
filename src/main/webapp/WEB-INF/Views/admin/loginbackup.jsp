<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="/include/lib.jsp" %>


  <script type="text/javascript" src="${ctx}static/js/jquery.min.js"></script>
  <script type="text/javascript" src="${ctx}static/js/jquery.form.js"></script>
  <script type="text/javascript" src="${ctx}static/js/jquery.validate.min.js"></script>
  <script type="text/javascript">
    var ctx = "${ctx}";
  </script>
  <title>图书管理系统登录</title>
</head>
<body>
<form id="forms">
  <p>登录名：<input type="text" id="name" name="loginName" /></p>
  <p>密码：<input type="text" id="pswd" name="pswd" /></p>
</form>
<button type="button" onclick="login();">登录</button>

<script>
  $(function(){
    $('#forms').validate({
      rules:{
        loginName:"required",
        pswd:"required"
      },
      messages:{
        loginName:'请输入登录名',
        pswd:'请输入密码'
      }
    });
  });
  function login()
  {
    if($('#forms').valid())
    {
      $.post(ctx+'admin/loginValidate',$('#forms').serialize(),function(result){
        if(result.success){
          window.location.href=ctx+'home/index';
        }else{
          alert(result.data);
        }
      },'json');
    }
  }
</script>
</body>
</html>