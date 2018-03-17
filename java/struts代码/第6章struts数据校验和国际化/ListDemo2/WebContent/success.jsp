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
Name:<s:property value="users[0].name"/>
Age:<s:property value="users[0].age"/>
Tel:<s:property value="users[0].tel"/><br/>
Name:<s:property value="users[1].name"/>
Age:<s:property value="users[1].age"/>
Tel:<s:property value="users[1].tel"/>
</center>
</body>
</html>