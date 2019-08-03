import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet3 extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	    throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + 
				"XHTML 1.0 Strict//EN\" \"http://www.w3.org" +
				"/TR/xhtml1/DTD/xhtml-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xthml\">");
		
		out.println("<head>");
		out.println("<title>Processing post request with data</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>Hello " + firstName + ",<br />");
		out.println("Welcome to Servlets!</h1>");
		out.println("</body>");
		
		out.println("</html>");
		out.close();
	}
}
