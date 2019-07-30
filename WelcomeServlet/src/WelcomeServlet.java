import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<?xml version\"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + 
				"XHTML 1.0 Strict//EN\" \"http://www.w3.org" +
				"/TR/xhtml1/DTD/xhtml-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>A Simple Servlet Example</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Welcome to Servlet!<h1/>");
		out.println("</body>");
		out.println("</html>");
		out.close(); 
	}
}
