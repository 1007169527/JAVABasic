<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page errorPage = "guestBookErrorPage.jsp" %>
<%@ page import = "java.util.*" %>
<%@ page import = "net.rtfsc.*" %>
<jsp:useBean id = "guestData" scope = "request"
  class = "net.rtfsc.guestDataBean" />
  
<html xmlns = "http://www.w3.org/1999/xhtml">

<head>
  <title>GusetList</title>
  <style type = "text/css">
    body {
      font-family: tahoma, helvetiva, arial, sans-serif;
    }
    table, tr, td, th {
      text-align: center;
      border: 3px, groove;
      padding: 5px;
      background-color: #dddddd;
    }
  </style>
 </head>
 
 <body>
   <p>Guest List</p>
   <table>
     <thead>
       <tr>
         <th> style = "width: 100px;">Last name</th>
         <th> style = "width: 100px;">First name</th>
         <th> style = "width: 200px;">Email</th>
       </tr>
     </thead>
     
     <tbody>
       <%
         List guestList = guestData.getGuestList();
         Iterator guestListIterator = guestList.iterator();
         GuestBean guest;
         while(guestListIterator.hasNext()) {
           guest = (GuestBean) guestListIterator.next();
       %>
         <tr>
           <td><%= guest.getLastName() %></td>
           <td><%= guest.getFirstName() %></td>
           <td><a href "mailto:<%= guest.getEmail() %>">
             <%= guest.getEmail() %></td>
         </tr>
       </%
         }
       %>
     </tbody>
   </table>
  </body>
</html>           