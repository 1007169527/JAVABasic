<table>
  <tr>
    <td style = "background-color: black;">
      <p class = "big" style = "color: cyan; font-size: 3em; font-weight: bold;">
        <%
          java.util.Locale locale = request.getLocale();
          java.text.DateFormat dateFormat = java.text.DateFormat.getDateTimeInstance(
            java.text.DateFormat.LONG,
            java.text.DateFormat.LONG, locale);
        %>
        <%= dateFormat.format(new java.util.Date()) %>
      </p>
    </td>
  </tr>
</table>
