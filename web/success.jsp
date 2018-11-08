<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 10.05.2018
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
SUKCES KURWA MAC
<%
    String name = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String address = request.getParameter("address");
    String city = request.getParameter("city");
    String postalCode = request.getParameter("postalcode");
    String gender = request.getParameter("gender");
%>
<tr>
    <td>First Name:</td>
    <td><%= name%></td>
</tr>
<tr>
    <td>Last Name:</td>
    <td><%= lastname%></td>
</tr>
<tr>
    <td>Username:</td>
    <td><%= username%></td>
</tr>
<tr>
    <td>Password:</td>
    <td><%= password%></td>
</tr>
<tr>
    <td>Address:</td>
    <td><%= address%></td>
</tr>
<tr>
    <td>City:</td>
    <td><%= city%></td>
</tr>
<tr>
    <td>Postal Code:</td>
    <td><%= postalCode%></td>
</tr>
<tr>
    <td>Gender:</td>
    <td><%= gender%></td>
</tr>

</body>
</html>
