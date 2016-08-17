<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规则操作</title>
</head>
<body>
添加/修改规则
<form action="${pageContext.request.contextPath }/ruleEdit.action" method="post">
<input type="hidden" name="id"  value="${rule.id}"/><br/>
规则名称：<input type="text" name="rulename"  value="${rule.rulename}"/><br/>
业务类型：<input type="text" name="type"  value="${rule.type }"/><br/>
风险等级：<input type="text" name="safeLevel"  value="${rule.safeLevel }"/><br/>
条件一：<input type="text" name="time"  value="时间，如：12h，30min"/><br/>
条件二：<input type="text" name="deals"  value="交易量，如：3"/><br/>
条件三：<input type="text" name="isCommonFromPlace"  value="是否是常用转出地址。如：true"/><br/>
<input type="submit" value="完成"/>
</form>
规则描述：${rule.ruledesc }
</body>
</html>