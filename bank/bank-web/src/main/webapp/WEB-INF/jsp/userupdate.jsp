<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/usertypeupdate.action" method="post">
<input type="hidden" name="id"  value="${user.id}"/><br/>
用户名：<input type="text" name="username"  value="${user.username}"/><br/>
用户密码：<input type="text" name="password"  value="${user.password }"/><br/>
用户类型：<select id="usertype" name="usertype" >
<option value = "1"  <c:if test="${user.usertype==1}">selected="selected"</c:if> >黑名单</option>
<option value = "2"  <c:if test="${user.usertype==2}">selected="selected"</c:if> >白名单</option>
<option value = "3"  <c:if test="${user.usertype==3}">selected="selected"</c:if> >灰名单</option>
<option value = "4"  <c:if test="${user.usertype==4}">selected="selected"</c:if> >高风险手机号</option>
<option value = "5"  <c:if test="${user.usertype==5}">selected="selected"</c:if> >高风险ip</option>
<option value = "6"  <c:if test="${user.usertype==6}">selected="selected"</c:if> >高风险账户</option>
</select>
<input type="submit" value="提交"/>
</form>

</body>
</html>