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
   <!-- 创建复选框，根据list集合 -->
   <s:checkboxlist name="characters" list="#{'a':'1','b':'2','c':'3','d':'4'}" 
          label="choose a character" labelposition="top"
          listKey="key"
          listValue="value" />
    <s:checkboxlist name="interests" list="{'football','basketball','volleyball','swimming'}" 
          label="Interest" 
          labelposition="top"/>
        <s:submit/>
</s:form>
</center>
</body>

</html>
