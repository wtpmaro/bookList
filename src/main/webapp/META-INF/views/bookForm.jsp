<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/books/addForm" modelAttribute="book">
    <form:hidden path="id" />
    <p>  <form:input path="title" placeholder="Title"/></p>
    <form:errors path="title" />
    <label>Select authors:</label>
    <p>  <form:checkboxes path="authors" items="${authorList}" itemLabel="lastName" itemValue="id"/></p>
    <form:errors path="authors" />
     <label>Select publisher:</label>
    <p>  <form:select path="publisher.id" items="${publishersList}" itemLabel="name" itemValue="id"/></p>
    <form:errors path="publisher" />
    <p>  <form:textarea path="description" placeholder="description"/></p>
    <form:errors path="description" />
    <p>  <form:input path="rating" placeholder="rating"/> </p>
    <form:errors path="rating"/>
    <p>  <form:input path="pages" placeholder="pages"/> </p>
    <form:errors path="pages"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
