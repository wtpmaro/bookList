<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/authors/addForm" modelAttribute="author">
    <form:hidden path="id" />
    <p> <form:input path="firstName" placeholder="First Name"/></p>
    <form:errors path="firstName" />
    <p> <form:input path="lastName" placeholder="Last Name"/></p>
    <form:errors path="lastName" />
    <p> <form:input path="pesel" placeholder="Pesel"/></p>
    <form:errors path="pesel" />
    <p> <form:input path="email" type="email" placeholder="Email"/></p>
    <form:errors path="email" />
    <p>  <form:input path="birthDay" type="date" placeholder="Date of birth"/></p>
    <form:errors path="birthDay" />
    <input type="submit" value="save">
</form:form>

</body>
</html>
