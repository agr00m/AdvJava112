<html>
<head><title>First JSP</title></head>
<body>
    <h1> Aaron's Home Page</h1>
    <a href="linkingDemo.html">Linking Demo</a>
    
    <%
      double num = Math.random();
      if (num > 0.95) {
    %>
        <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
    <%
      } else {
    %>
        <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
    <%
      }
    %>
    <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
  
</body>
</html>