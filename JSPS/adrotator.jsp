<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C/DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<jsp:useBean id = "rotator" scope = "application"
  class = "com.rtfsc.Rotator" />

<html xmlns = "http://www.w3.org/1999/xhtml">
  <head>
    <title>AdRotator Example</title>
    <style type = "text/css">
      .big {
        font-family: tahoma, helvetica, arial, sans-serif;
        font-weight: bold;
      }
    </style>
    <% rotator.nextAd(); %>
  </head>
  <body>
    <p class = "big">AdRotator Example</p>
    <p>
      <a href = "<jsp:getProperty name = "rotator"
        property = "link" />">
        <img src = "<jsp:getProperty name = "rotator"
          property = "image" />" width = "100" height = "100" alt = "advertisement" />
      </a>
    </p>
  </body>
</html>
