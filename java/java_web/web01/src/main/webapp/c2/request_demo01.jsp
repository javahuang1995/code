<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head><title>www.mldnjava.cn，MLDN高端Java培训</title></head>
<body>
<%
	request.setCharacterEncoding("utf-8") ;// 设置的是统一编码
	//String content = new // String(request.getParameter("info").getBytes("ISO8859-1")) ;
	String content = request.getParameter("info") +"你好";
	System.out.println(content);
%>
<h2><%=content%></h2>
</body>
</html>