<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/publishers/addForm" modelAttribute="publisher">
    <form:hidden path="id" />
    <form:input path="name" placeholder="Name"/>
    <form:input path="nip" placeholder="Nip"/>
    <form:errors path="nip" />
    <form:input path="regon" placeholder="Regon"/>
    <form:errors path="regon" />
    <input type="submit" value="save">
</form:form>

</body>
</html>
