<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<s:a action="login.action">execute() method</s:a><br/>
 <s:a action="login!method1.action">method1() method</s:a><br/>
 <s:a action="login!method2.action">method2() method</s:a><br/>
 <s:a action="login!method3.action">method3() method</s:a><br/>
</center>

</body>
</html>
