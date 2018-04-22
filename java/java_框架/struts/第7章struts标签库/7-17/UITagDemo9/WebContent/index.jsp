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
	<!-- 创建 表单元素-->
	<s:select label="My Selection"
           name="mySelection"
           value="%{'POPEYE'}"
           list="%{#{'SUPERMAN':'Superman', 'SPIDERMAN':'spiderman'}}">
          <s:optgroup label="Adult"
                list="%{#{'SOUTH_PARK':'South Park'}}" />
          <s:optgroup label="Japanese"
                list="%{#{'POKEMON':'pokemon','DIGIMON':'digimon','SAILORMOON':'Sailormoon'}}" />
	</s:select>	
	</center>
</body>
</html>
