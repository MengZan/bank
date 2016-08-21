<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规则操作</title>
</head>
<body>

<c:choose>
	<c:when test="${empty rule }">
		添加规则
		<form action="${pageContext.request.contextPath }/addRule.action" method="post">
		<input type="hidden" name="id"  value="${rule.id}"/><br/>
		规则名称：<input type="text" name="rulename"  value=""/><br/>
		业务类型：<input type="text" name="type"  value=""/><br/>
		风险等级：<input type="text" name="safeLevel"  value=""/><br/>
		条件一：<input type="text" name="time"  value="多少时间内，如：12h，30min"/><br/>
		条件二：<input type="text" name="deals"  value="交易量，如：3"/><br/>
		条件三：<input type="text" name="isCommonFromPlace"  value="是否是常用转出地址，如：true"/><br/>
		条件四：<input type="text" name="moneyOfDay" value="日转账金额，如10000.00"/> <br/>
		条件五：<input type="text" name="toUsersOfDay" value="转出用户数量，如10"/> <br/>
		<input type="submit" value="添加"/>
		</form>
	</c:when>
	
	<c:otherwise>
		修改规则
		<form action="${pageContext.request.contextPath }/editRule.action" method="post">
		<input type="hidden" name="id"  value="${rule.id}"/><br/>
		规则名称：<input type="text" name="rulename"  value="${rule.rulename}"/><br/>
		业务类型：<input type="text" name="type"  value="${rule.type }"/><br/>
		风险等级：<input type="text" name="safeLevel"  value="${rule.safeLevel }"/><br/>
		<c:if test="${not empty ruleFactor.time }">时间小于等于：<input type="text" name="time"  value="${ruleFactor.time }"/><br/></c:if>
		<c:if test="${not empty ruleFactor.deals }">交易量超过：<input type="text" name="deals"  value="${ruleFactor.deals }"/><br/></c:if>
		<c:if test="${ruleFactor.isCommonFromPlace }">是否常用转出地址：<input type="text" name="isCommonFromPlace"  value="${ruleFactor.isCommonFromPlace }"/><br/></c:if>
		<c:if test="${not empty ruleFactor.moneyOfDay }">日转账金额超过：<input type="text" name="moneyOfDay"  value="${ruleFactor.moneyOfDay }"/><br/></c:if>
		<c:if test="${not empty ruleFactor.toUsersOfDay }">当日转出账户数量超过：<input type="text" name="toUsersOfDay"  value="${ruleFactor.toUsersOfDay }"/><br/></c:if>
		<input type="submit" value="保存修改"/>
		</form>
		<!-- 规则描述：${rule.ruledesc } -->
	</c:otherwise>
</c:choose>

</body>
</html>