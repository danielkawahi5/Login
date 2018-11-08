<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 02.05.2018
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged</title>
</head>
<body>
<center>
<p><b>You heve logged successfully!!</b></p>
<p>
<form action="/logout" method="post">
    <strong><input type="submit" value="Log the fuck OUT!" style="background:greenyellow;"/></strong>
</form>
</p>
</center>
<%
    if(session.getAttribute("Logged") == null) {
        response.sendRedirect("login.jsp");
    }
    if(session.getAttribute("Male").equals(true)) {
        %>

        <center><img src="${pageContext.request.contextPath}/images/miss.reff.jpg" /></center>

        <%
    } else {
        %>
        <center><img src="${pageContext.request.contextPath}/images/marlon.jpg" /></center>

        <%
    }
%>
</body>
</html>
