package com.huang.servlet;
import java.io.* ;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
              throws ServletException,IOException{
		PrintWriter out = resp.getWriter() ;
		out.println("<html>") ;
		out.println("<head><title>MLDNJAVA</title></head>") ;
		out.println("<body>") ;
		out.println("<h1>HELLO WORLD</h1>") ;
		out.println("</body>") ;
		out.println("</html>") ;
		out.close() ;
	}
}