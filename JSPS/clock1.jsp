<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv = "refresh" content = "60" />
    <title>A Simple JSP Example</title>
    <style type = "text/css">
      body {
        font-family: helvetica, arial, sans-serif;
      }
      table, tr, td {
        border: 3px groove;
        padding: 5px;
        background-color: #dddddd;
      }
    </style>
  </head>
  
  <body>
    <p>Simple JSP Example</p>
    <table>
      <tr>
        <td>
          <p>
            <!-- JSP expression to insert date/time -->
            <%= new java.util.Date() %>
          </p>
        </td>
      </tr>
    </table>
  </body>
</html>
        
