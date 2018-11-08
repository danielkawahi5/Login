<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 27.04.2018
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>~~Login Page~~</title>
    <style>
        body {
            color: azure;
        }
        p {
            color: darkcyan;
        }
        strong {
            font-family: Jokerman;
            color: coral;
        }
        label {
            font-family: Tahoma;
            color: red;
        }
    </style>
</head>
<body>
<center>
    <strong>ENTER CORRECT LOGIN AND PASSWORD TO SEE SOMETHING BEAUTIFUL</strong>
    <p><img src="${pageContext.request.contextPath}/images/just.jpg" width="300"; height="350"; /></p>
    <br/><br/><br/><br/><br/>
<form action="/login" method="post">
    <label for="nick">LOGIN:</label>
    <input type="text" id="nick" name="username"/><br/>

    <label for="password">PASSWORD:</label>
    <input type="password" id="password" name="password"/><br/>

    <br/>
    <input type="submit" value="LOOOOGGG" style="background: azure;"/>
</form>
    <a href="registration.jsp" style="color:black;font-size:50px;"> REGISTER! </a>
    <%
        if(request.getParameter("loginFailure") != null){
                    response.getWriter().append("<div style='color:red;'>Niepoprawne dane logowania!</div>");
        }

        if(request.getParameter("logout") != null){
                    response.getWriter().append("<div style='color:red;'>Poprawnie wylogowano z serwisu!</div>");
        }
    %>
</center>
</body>
</html>
