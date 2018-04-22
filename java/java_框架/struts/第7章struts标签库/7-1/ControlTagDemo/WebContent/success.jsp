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
<!--使用append标签来拼接集合 -->
<s:append var="myAppendIterator">
     <s:param value="%{myList1}" />
     <s:param value="%{myList2}" />
     <s:param value="%{myList3}" />
</s:append>
<!-- 遍历集合元素 -->
<s:iterator value="%{#myAppendIterator}">
     <s:property />
</s:iterator>
</center>
</body>

</html>
