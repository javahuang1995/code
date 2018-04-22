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
	<!-- 遍历集合 -->
	<s:iterator value="fruits">
		<s:property /><br/>
	</s:iterator>	
	</center>
</body>


</html>

<!--  	<s:iterator value="mySelection">
				<s:property />&nbsp;
			</s:iterator><br/>
			<s:property value="mySelection"/>
			
			<s:property value="name"/><br/>
		<s:property value="password"/>
		
		
		<s:iterator value="country">
				<s:property />&nbsp;
			</s:iterator>
			-->