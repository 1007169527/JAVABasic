<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
  <head>
    <title>Processing "get" requests with data</title>
  </head>
  <body>
    <%
      String name = request.getParameter("firstName");
      if(name != null) {
    %>
        <h1>
          Hello <%= name %>, <br />
          Welcome to Java Server Pages;
        </h1>
    <% 
      } else {
    %>
        <form action = "welcome.jsp" method = "get">
          <p>Type your first name and press Submit</p>
          <p><input type = "text" name = "firstName" />
            <input type = "submit" value = "Submit" />
          </p>
        </form>
    <%
      }
    %>
  </body>
</html>                