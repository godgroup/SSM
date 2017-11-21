<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/include/lib.jsp" %>
  <title>文章列表--layui后台管理模板</title>

</head>


<body class="childrenBody">
<form class="layui-form" style="width:80%;">
  <input type="hidden" value="${userRoleVo.uid}" name="uid">
  <div class="layui-form-item">
    <label class="layui-form-label">用户姓名</label>
    <div class="layui-input-block">
     <label class="layui-form-label"> ${userRoleVo.loginName}</label>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">用户姓名</label>
    <div class="layui-input-block">
      <c:forEach items="${itemsListVo}" var="item">
        ${item.name}  <input style="display:inline " type="checkbox" name="roles" value="${item.id}" title="${item.name}" <c:if test="${item.checked==1}">checked</c:if> >
      </c:forEach>
    </div>
  </div>



  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="button" class="layui-btn setuserrole_btn" >立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script type="text/javascript" src="${ctx}static/page/admin/setuserrole.js?v=4.0"></script>

</body>
</html>