<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<h1>互联网金融反欺诈系统</h1>
<div>
<c:choose>
	<c:when test="${empty username }">
		<a href=" #">用户登录</a>	
	</c:when>
	<c:otherwise>
		你好，${username }&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="#" >数据采集</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="#" >数据展示</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/usermanage" >名单管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/rulelist" >规则管理</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/checkdata" >欺诈检测</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/logout.action" >退出</a>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>