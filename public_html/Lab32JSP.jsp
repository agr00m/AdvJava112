<!doctype html>

<html>
<head>
  <title>Lab 3-2</title>
</head>

<body>

    <h3>Lab 3-2 HTTP Request</h3>
    <p><ul>
        <li>The Current Locale of the request: <%= request.getLocale() %></li>
        <li>The Context Path of the request: <%= request.getContextPath() %></li>
        <li>The Local Name of the server: <%= request.getServerName() %></li>
        <li>The Scheme used to make the request: <%= request.getRequestURI() %></li>
    </ul></p>
    
    <h3>HTML Request Header Fields</h3>
    <p><ul>
    <%@ page import="java.util.*"%> 
    <% 
        String headerName;
        Enumeration attributes = request.getHeaderNames();
        while (attributes.hasMoreElements()) {
            headerName = attributes.nextElement().toString();
            out.println("<li>");
            out.println(headerName + ": " + request.getHeader(headerName));
            out.println("</li>");
        }
    %></ul></p>
    <a href="index.jsp">Home</a>
</body>
</html>