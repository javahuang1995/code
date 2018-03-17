<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<!-- 下面两种写法都可以访问 -->
	</span>
	<a
		href="${pageContext.request.contextPath }/category_update.action?id=2&type=huangning&hot=false">访问update</a>
	<a href="category_save.action">访问save</a>
	<a href="category_save.action?id=7&type=haha&hot=true">测试ModelDriven</a>  
	<a href="category_query.action">查询所有类别</a>
	<br />
	<c:forEach items="${requestScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br />
	</c:forEach>

	<c:forEach items="${sessionScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br />
	</c:forEach>

	<c:forEach items="${applicationScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br />
	</c:forEach>
	
	<a href="send_main_aindex.action">首页访问</a><!-- 进入web-inf/main/aindex.jsp -->
</body>
</html>
