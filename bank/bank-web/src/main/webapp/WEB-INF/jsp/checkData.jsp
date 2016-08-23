<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欺诈检测</title>

<style type="text/css">
th,td{width: 150px;border: 2px solid gray;text-align: center;}
body{text-align: center;}
a{text-decoration: none;}
table {border-collapse: collapse;}
</style>

</head>
<body>


<form action="${pageContext.request.contextPath }/datashow_fenye.action" method="post">
 
<h2 align="center">交易信息</h2>
<table align="center">
<tr><td>序号</td><td>发起用户</td><td>目标用户</td><td>金钱</td><td>日期</td><td>发起地</td><td>目的地</td><td>工具</td><td>风险等级</td></tr>
</table>
<table align="center">
<c:forEach items="${listss }" var="data">
<tr>
<td class="hidden-480">${data.getId()}</td>
<td class="hidden-480"><a href="${pageContext.request.contextPath }/datashowbyfromuser/${data.fromuser }" >${data.getFromuser() }</a></td>
<td class="hidden-480">${data.getTouser()}</td>
<td class="hidden-480">${data.getMoney()}</td>
<td class="hidden-480">${data.getDatetime()}</td>
<td class="hidden-480">${data.getFromplace()}</td>
<td class="hidden-480">${data.getToplace()}</td>
<td class="hidden-480">${data.getTool()}</td>
<td class="hidden-480">${data.getSafeLevel()}</td>
</tr>
</c:forEach>
</table>
<br>
<c:if test="${pageNos>1 }">
<a href="${pageContext.request.contextPath }/datashow_fenye.action?pageNos=1" >首页</a>
<a href="${pageContext.request.contextPath }/datashow_fenye.action?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="${pageContext.request.contextPath }/datashow_fenye.action?pageNos=${pageNos+1 }">下一页</a>
<a href="${pageContext.request.contextPath }/datashow_fenye.action?pageNos=${recordCount }">末页</a>
</c:if>

<h4 align="center">共${recordCount }页  
<input type="text" value="${pageNos}" name="pageNos" size="1" onkeyup="value=value.replace(/[^\d]/g,'')">页
<input type="submit" value="到达">
</h4>


<input type="submit" value="展示">

</form>

<form action="${pageContext.request.contextPath }/check_test.action?pageNos=${pageNos}" method="post">

<input type="submit" value="检测">

</form>

<form action="${pageContext.request.contextPath }/check_all.action" method="post">

<input type="submit" value="检测全部">

</form>

${message}
${time }
<table align="center">
<tr><td>总交易数</td><td>黑名单交易数</td><td>白名单交易数</td><td>欺诈交易数</td></tr>
</table>

<table align="center">
<tr>
<td class="hidden-480">${count_n} </td>
<td class="hidden-480">${count_black} </td>
<td class="hidden-480">${count_white} </td>
<td class="hidden-480">${count} </td>
</tr>
</table>

<a href="/">返回首页</a>
</body>
</html>