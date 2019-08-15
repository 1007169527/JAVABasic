//P908
import java.io.*;
import java.text.*;
import java.util.Properties;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SurveyServlet extends HttpServlet {
	static final String framework = "embedded";
	static final String protocol = "jdbc:derby://localhost:1527/";
	static final String dbName = "animalsurvey";
	static final String databaseUrl = protocol + dbName;
	private Connection connection;
	private Statement statement;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			connection = DriverManager.getConnection(databaseUrl);
			statement = connection.createStatement();
 		} catch (Exception exception) {
			exception.printStackTrace();
			throw new UnavailableException(exception.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		out.println("<?xml version\"1.0\"?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD " + 
				"XHTML 1.0 Strict//EN\" \"http://www.w3.org" +
				"/TR/xhtml1/DTD/xhtml-strict.dtd\">");
		
		int value = Integer.parseInt(request.getParameter("animal"));
		String query;
		try {
			query = "UPDATE surveyresults SET votes = votes + 1 WHERE id = " + value;
			statement.execute(query);
			query = "SELECT sum(votes) FROM surveyresults";
			ResultSet totalRS = statement.executeQuery(query);
			totalRS.next();
			int total = totalRS.getInt(1);
			query = "SELECT surveyoption, votes, id FROM surveyresults ORDER BY id";
			ResultSet resultsRS = statement.executeQuery(query);
			out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
			out.println("<head>");
			out.println("<title>Thank you!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>Thank you for participating.");
			out.println("<br />Results:</p><pre>");
			int votes;
			while(resultsRS.next()) {
				out.print(resultsRS.getString(1));
				out.print(": ");
				votes = resultsRS.getInt(2);
				out.print(twoDigits.format((double) votes/total*100));
				out.print("% responses: ");
				out.println(votes);
			}
			resultsRS.close();
			out.print("Total responses: ");
			out.print(total);
			out.println("</pre></body></html>");
			out.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			out.println("<title>Error</title>");
			out.println("</head>");
			out.println("<body><p>Database error occurred.");
			out.println("Try again later.</p></body></html>");
			out.close();
		}
	}
	
	public void destory() {
		try {
			statement.close();
			connection.close();
		}
		
		catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
