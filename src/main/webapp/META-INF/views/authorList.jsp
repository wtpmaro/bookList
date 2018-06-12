<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/authors/addForm">Add Authors</a>

<ul>
    <c:forEach items="${authors}" var="author">
        <li>
            <p>${author.firstName}
            ${author.lastName}
            <a href="/authors/delete/${author.id}">Delete</a>
            <a href="/authors/update/${author.id}">Edit</a></p>
        </li>

    </c:forEach>
</ul>
</body>
</html>
