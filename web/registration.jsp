<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 10.05.2018
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<style>
    div.ex {
        text-align: center;width: 350px;
        padding: 20px;
        border: 10px skyblue;
        margin: 5px;
    }
</style>
<body>

<h1>Registration Form</h1>
<div class="ex">
    <form action="/registration" method="post">
        <table style="width: 60%">
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstname"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastname"/></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="city"/></td>
            </tr>
            <tr>
                <td>Postal Code:</td>
                <td><input type="text" name="postalcode"/></td>
            </tr><tr>
                <td>Gender:</td>
                <td><input type="text" name="gender"/></td>
            </tr>


        </table>
        <input type="submit" value="REGISTER"/>
    </form>
</div>

<%
    if(request.getAttribute("failure") !=null){
        response.getWriter().println("<div style='color:red;'>This username is already in use!!!.....</div>");
    }
%>

</body>
</html>
