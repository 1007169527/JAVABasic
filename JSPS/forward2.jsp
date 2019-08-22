<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
  <head>
    <title>Processing a forward request</title>
    <style type = "text/css">
      .big {
        font-family: tahoma, helvetica, arial, sans-serif;
        font-weight: bold;
      }
    </style>
  </head>
  
  <body>
    <p class = "big">
      Hello <%= request.getParameter("firstName") %>, <br \>
      Your request was received <br \> abd forward at
    </p>
    <table>
      <tr>
        <td style = "border: 6px outset";>
          <p class = "big" style = "color: cyan;">
            <%= request.getParameter("date") %>
          </p>
        </td>
      </tr>
    </table>
  </body>
</html>