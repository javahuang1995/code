<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>

    <form action="login">
        <s:property value="Result" />
        <br /> 姓名<input type='text' name="Name"> <br /> 年龄<input
            type='text' name=Age> <input type="submit" value="提交">
    </form>
</body>
</html>