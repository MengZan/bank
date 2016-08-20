<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规则管理</title>
</head>
<body>
规则列表：
<a href="${pageContext.request.contextPath }/rule">添加规则</a>
<table width="60%" border=2>
<tr>
	<td>规则名称</td>
	<td>规则描述</td>
	<td>业务类型</td>
	<td>风险等级</td>
	<td>操作</td>
</tr>
<c:forEach items="${rules }" var="rule">
<tr>
	<td>${rule.rulename }</td>
	<td>${rule.ruledesc }</td>
	<td>${rule.type }</td>
	<td>${rule.safeLevel }</td>
	<td><a href="${pageContext.request.contextPath }/rule/${rule.id}">修改</a>
			<a href="${pageContext.request.contextPath }/deleteRule/${rule.id }">删除</a>
	</td>
</tr>
</c:forEach>
</table>
<br/><a href="/">返回首页</a>
</body>
</html>