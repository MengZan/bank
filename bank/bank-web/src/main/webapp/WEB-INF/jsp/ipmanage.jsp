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

<c:choose>
	<c:when test="${empty ip }">
		添加ip
		<form action="${pageContext.request.contextPath }/list/ipadd.action" method="post">
		<input type="hidden" name="id"  value="${ip.id}"/><br/>
		ip值：<input type="text" name="ipdata"  value="" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		风险等级：<input type="text" name="ipsafe"  value="" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		<input type="submit" value="添加"/>
		</form>
	</c:when>
	
	<c:otherwise>
		修改ip
		<form action="${pageContext.request.contextPath }/list/ipedit.action" method="post">
		<input type="hidden" name="id"  value="${ip.id}" /><br/>
		ip值：<input type="text" name="ipdata"  value="${ip.ip}" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		风险等级：<input type="text" name="ipsafe"  value="${ip.safety }" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		<input type="submit" value="保存修改"/>
		</form>
	</c:otherwise>
</c:choose>

</body>
</html>