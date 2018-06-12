<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="personDTO">
    <form:hidden path="id" />
    <form:input path="login" placeholder="Login"/><br>
    <form:password path="password" placeholder="Password"/><br>
<form:input path="email" placeholder="eMail" /><br>
    <form:input path="firstName" placeholder="First name"/><br>
    <form:input path="lastName" placeholder="Last name"/><br>
    Male:	<form:radiobutton	path="gender"	value="M"/><br>
    Female:	<form:radiobutton	path="gender"	value="F"/><br>
    <form:select	path="country"	items="${country}"	/><br>
    <form:textarea	path="notes"	rows="3" cols="20"/><br>
    Mailing list: <form:checkbox	path="mailingList"/><br>
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/><br>
    <form:checkboxes path="hobbies" items="${hobbies}" /><br>
    <input type="submit" value="save">
</form:form>

</body>
</html>
