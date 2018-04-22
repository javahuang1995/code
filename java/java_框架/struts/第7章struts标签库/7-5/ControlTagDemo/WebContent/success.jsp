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
		<!--创建javabean实例，得到对象mydecider -->
		<s:bean name="com.action.EvenDecider" var="mydecider"></s:bean>
		<s:subset source="{1,2,3,3,4}" decider="#mydecider">	<!--取子集，并调用自定义类方法-->
			<!--遍历输出-->
			<s:iterator>
				<s:property />
			</s:iterator>
		</s:subset>
	</center>
</body>

</html>
