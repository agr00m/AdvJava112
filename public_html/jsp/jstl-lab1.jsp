<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" value="Aaron Groom" />
<c:set var="location" value="Mount Horeb" />
<html>
<head>
  <title>My First JSP Page</title>
</head>

<body>
    <h2>JSTL Lab 1</h2>    
    <p>
        My name is: ${name} <br>
        I live in: ${location}
    </p>
</body>
</html>