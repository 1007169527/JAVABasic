import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String location = request.getParameter("page");
		
		if(location != null) {
			if(location.equals("bing"))
				response.sendRedirect("http://www.bing.com");
			else if(location.equals("welcome"))
				response.sendRedirect("../servlet1/welcome");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + 
				"XHTML 1.0 Strict//EN\" \"http://www.w3.org" +
				"/TR/xhtml1/DTD/xhtml-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xthml\">");
		
		out.println("<head>");
		out.println("<title>Invaild page</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Invalid page requested</h1>");
		out.println("<p><a href = " +
				"\"RedirectServlet.html\">");
		out.println("Click here to choose again</a></p>");
		out.println("</body>");
		
		out.println("</html>");
		out.close();
	}
}





