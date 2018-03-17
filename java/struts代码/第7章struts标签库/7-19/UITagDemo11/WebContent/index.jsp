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
  <s:form action="user">
  <s:updownselect
list="#{'england':'England', 'america':'America', 'germany':'Germany','china':'China'}"
name="country"
headerKey="-1"
headerValue="--- choose a country ---"
emptyOption="true" 
moveUpLabel="up"
moveDownLabel="down"
selectAllLabel="all"
/>
     <s:submit/>
  </s:form>
</center>
</body>


</html>
