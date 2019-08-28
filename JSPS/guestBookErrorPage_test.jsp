<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page isErrorPage = "true" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.rtfsc.*" %>
  
<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
  <title>Error!</title>
  <style type = "text/css">
    .bigRed {
      color: red;
      font-weight: bold;
    }
  </style>
</head>  

<body>
  <p class = "bigRed">
    <%
      if(exception instanceOf SQLException)
    %>
      An SQLException
    <%
      else if(exception instanceOf ClassNotFoundException)
    %>
      A ClassNotFoundException
    <%
      else
    %>
      An exception
      occured while interacting with guestbook database.
  </p>
  
  <p class = "bigRed">
    The error message was:<br />
    <%= exception.getMessage() %>
  </p>
  <p class = "bigRed">Please try later</p>
</body>

</html>