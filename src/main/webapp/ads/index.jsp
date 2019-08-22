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
    <title>Ads</title>
</head>
<body>
<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>Ad: ${ad.id}</h2>
        <p>User: ${ad.userId}</p>
        <p>Title: ${ad.title}</p>
        <p>Description: ${ad.description}</p>
    </div>
</c:forEach>
</body>
</html>
