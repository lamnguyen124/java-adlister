<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 8/21/19
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equalsIgnoreCase("post")) {

        // Getting the info from the HTTP request
        String username = request.getParameter("username").equalsIgnoreCase("admin")
        String password = request.getParameter("password").equals("pass");

        if (username.equalsIgnoreCase("admin") && password.equals("pass")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="
<form method="POST" action="/login.jsp">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" placeholder="Enter your username" />
    <label for="password">password</label>
    <input id="password" type="password" name="password" placeholder="password"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
