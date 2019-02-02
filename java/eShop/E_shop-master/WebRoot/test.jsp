<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'MyJsp.jsp' starting page</title>
</head>
<body>
	POST提交：
	<form action="hello.action" method="POST">
		<!--注意这里先用POST-->
		<input type="text" name="name"> <input type="submit"
			value="提交">
	</form>
	
	GET提交：
	<form action="hello.action" method="GET">
		<!--注意这里先用POST-->
		<input type="text" name="name"> <input type="submit"
			value="提交">
	</form>
	
	<s:property value="name" />
</body>
</html>