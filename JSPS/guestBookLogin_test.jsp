<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page errorPage = "guestBookErrorPage.jsp" %>
<jsp:useBean id = "guest" scope = "page"
  class = "net.rtfsc.GuestBean" />
<jsp:useBean id = "guestBean" scope = "request"
  class = "net.rtfsc.GuestDataBean" />

<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
  <title>Guest Book Login</title>
  <style type = "text/css">
    body {
      font-family: tahoma, helvetiva, arial, sans-serif;
    }
    
    table, tr, td {
      border: 3px, groove;
      padding: 5px;
      background-color: #dddddd;
    }
  </style>
</head>

<body>
  <jsp:setProperty name = "guest" property = "*" />
  <%
    if(guest.getFirstName() == null ||
      guest.getLastName() == null ||
      guest.getEmail() == null) {
  %>
    <form method = "post" action = "guestBookLogin.jsp">
      <p>Enter your first name, last name, email address to register in our guest book.</p>
      <table>
        <tr>
          <td>FirstName</td>
          <td>
            <input type = "text" name = "firstName" />
          </td>
         </tr>
         <tr>
           <td>LastName</td>
           <td>
             <input type = "text" name = "lastName" />
           </td>
         <tr>
         <tr>
           <td>Email</td>
           <td>
             <input type = "text" name = "email" />
           </td>
         <tr>
         <tr>
           <td colspan = "2">
             <input type = "submit" value = "Submit" />
           </td>
         </tr>
       </table>
     </form>
   <%
     } else {
   %>        
       <jsp:forward page = "guestBookView.jsp" />
   <%
     }
   %>
 </body>
 
 </html>    