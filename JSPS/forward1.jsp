<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
  <head>
    <title>Forward request to another JSP</title>
  </head>
  <body>
    <%
      String name = request.getParameter("firstName");
      if (name != null) {
    %>
    <jsp:forward page = "forward2.jsp">
      <jsp:param name = "date"
        value = "<%= new java.util.Date() %>" />
    </jsp:forward>
    <%
      }
      else {
    %>
        <form action = "forward1.jsp" method = "get">
          <p>Type your first name and press Submit</p>
          <p><input type = "text" name = "firstName" />
            <input type = "submit" value="Submit" />
          </p>
        </form>         
    <%
      }
    %>
  </body>
</html>
