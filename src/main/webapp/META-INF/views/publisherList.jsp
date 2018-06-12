<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/publishers/addForm">Add Publisher</a>

<ul>
    <c:forEach items="${publishers}" var="publisher">
        <li>
            <p>${publisher.name}</p>
            <a href="/publishers/delete/${publisher.id}">Delete Publisher</a>
            <a href="/publishers/update/${publisher.id}">Edit Publisher</a>
        </li>

    </c:forEach>
</ul>
</body>
</html>
