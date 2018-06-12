<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/books/addForm">Add Book</a>

<table border="1px">
    <th>Title</th>
    <th>Description</th>
    <th>Author</th>
    <th>Publisher</th>
    <th>Pages</th>
    <th>Action</th>
    <c:forEach items="${books}" var="book">
            <tr><td>${book.title}</td>
            <td>${book.description}</td>
            <td>
            <c:forEach items="${book.authors}" var="author" >
                <p>${author.firstName} ${author.lastName} </p>

            </c:forEach>
            </td>
                <td>${book.publisher.name}</td>
                <td>${book.pages}</td>
        <td>
            <a href="/books/delete/${book.id}">Delete Book</a>
            <a href="/books/update/${book.id}">Edit Book</a>
        </td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
