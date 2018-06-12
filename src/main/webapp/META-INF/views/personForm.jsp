<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="person">
    <form:hidden path="id" />
    <form:input path="login" placeholder="Login"/>
    <form:password path="password" placeholder="Password"/>
<form:input path="email" placeholder="eMail" />
    <input type="submit" value="save">
</form:form>

</body>
</html>
