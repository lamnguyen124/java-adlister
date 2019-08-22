<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 8/22/19
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>${ad.id}</h2>
        <p>${ad.userId}</p>
        <p>${ad.title}</p>
        <p>${ad.description}</p>
    </div>
</c:forEach>
</body>
</html>
