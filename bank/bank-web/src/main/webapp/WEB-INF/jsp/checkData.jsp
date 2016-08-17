<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欺诈检测</title>
</head>
<body>
检测数据：
<form action="${pageContext.request.contextPath }/check.action" method="post">
转出用户：<input type="text" name="fromuser"  value="1"/><br/>
转入用户：<input type="text" name="touser"  value="2"/><br/>
转账金额：<input type="text" name="money"  value="100.00"/><br/>
转账时间：<input type="text" name="datetime"  value="2016-8-17 16:52:00"/><br/>
转出地址：<input type="text" name="fromplace"  value="上海"/><br/>
转入地址：<input type="text" name="toplace"  value="上海"/><br/>
转账方式：<input type="text" name="tool"  value="手机"/><br/>
<input type="submit" value="检测"/>
</form>
风险等级：${data.safeLevel } ${message }<br/>
运行时间：${time }<br/><br/>
<a href="/">返回首页</a>
</body>
</html>