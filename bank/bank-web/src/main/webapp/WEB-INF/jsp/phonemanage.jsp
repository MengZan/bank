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
	<c:when test="${empty phone }">
		添加phone
		<form action="${pageContext.request.contextPath }/list/phoneadd.action" method="post">
		<input type="hidden" name="id"  value="${phone.id}"/><br/>
		phone值：<input type="text" name="phonedata"  value="" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		风险等级：<input type="text" name="phonesafe"  value="" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		<input type="submit" value="添加"/>
		</form>
	</c:when>
	
	<c:otherwise>
		修改phone
		<form action="${pageContext.request.contextPath }/list/phoneedit.action" method="post">
		<input type="hidden" name="id"  value="${phone.id}" /><br/>
		phone值：<input type="text" name="phonedata"  value="${phone.phoneNumber}" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		风险等级：<input type="text" name="phonesafe"  value="${phone.safety }" onkeyup="value=value.replace(/[^\d]/g,'')"/><br/>
		<input type="submit" value="保存修改"/>
		</form>
	</c:otherwise>
</c:choose>

</body>
</html>