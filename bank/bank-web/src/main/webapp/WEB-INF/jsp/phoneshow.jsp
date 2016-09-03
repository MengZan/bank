<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
th,td{width: 150px;border: 2px solid gray;text-align: center;}
body{text-align: center;}
a{text-decoration: none;}
table {border-collapse: collapse;}
</style>

</head>
<body>

 

 <form action="${pageContext.request.contextPath }/list/phoneshow.action" method="post">

<a href="${pageContext.request.contextPath }/list/phonemanage">添加ip</a>

<h2 align="center">用户信息</h2>
<table align="center">
<tr><td>id</td><td>phonenumber</td><td>风险值</td><td>操作</td></tr>
</table>
<table align="center">
<c:forEach items="${listss}" var="data">
<tr>
<td class="hidden-480">${data.getId()}</td>
<td class="hidden-480">${data.getPhoneNumber() }</td>
<td class="hidden-480">${data.getSafety()}</td>

<td class="hidden-480"><a href="${pageContext.request.contextPath }/list/phonemanage/${data.id}">修改</a>
<a href="${pageContext.request.contextPath }/list/phonedelete/${data.id}" onclick="if(confirm('确定删除?')==false)return false;">删除</a></td>
</tr>
</c:forEach>
</table>
<br>
<c:if test="${pageNos>1 }">
<a href="${pageContext.request.contextPath }/list/phoneshow.action?pageNos=1" >首页</a>
<a href="${pageContext.request.contextPath }/list/phoneshow.action?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="${pageContext.request.contextPath }/list/phoneshow.action?pageNos=${pageNos+1 }">下一页</a>
<a href="${pageContext.request.contextPath }/list/phoneshow.action?pageNos=${recordCount }">末页</a>
</c:if>

<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1" onkeyup="value=value.replace(/[^\d]/g,'')">页
<input type="submit" value="到达">
</h4>


条件选择:<br/>



<br/>

<input type="submit" value="搜索">

</form>

<table align="center">
<tr><td>总手机号数</td><td>高风险手机数</td></tr>
</table>

<table align="center">
<tr>
<td class="hidden-480">${phone_total} </td>
<td class="hidden-480">${phone_danger} </td>

</tr>
</table>

</body>
</html>