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
  <!-- 创建表单 -->
  <s:form action="user">
  <!-- 创建表单元素 -->
  <s:optiontransferselect
     label="Favourite Cartoons Characters"
     name="leftSides"
     leftTitle="Left Title"
     rightTitle="Right Title"
     list="{'Popeye', 'He-Man', 'Spiderman'}"
     multiple="true"
     headerKey="headerKey"
     headerValue="--- Please Select ---"
     emptyOption="true"
     doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
     doubleName="rightSides"
     doubleHeaderKey="doubleHeaderKey"
     doubleHeaderValue="--- Please Select ---"
     doubleEmptyOption="true"
     doubleMultiple="true"
 />
     <s:submit/>
  </s:form>
</center>
</body>
</html>
