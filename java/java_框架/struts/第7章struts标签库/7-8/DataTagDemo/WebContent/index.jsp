<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<s:url value="user.action"  var="url">
       <s:param name="id" value="10" />
</s:url>
<s:a href="%{url}">user</s:a>
<br/>
<s:url action="user">
    <s:param name="id" value="10" />
</s:url><br/>
<s:url includeParams="get">
    <s:param name="id" value="10" />
</s:url>
</center>
</body>


</html>
