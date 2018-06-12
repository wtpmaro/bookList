<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${validations}" var="validation">

        <p>${validation.getPropertyPath()} : ${validation.getMessage()}</p>

    </c:forEach>
</body>
</html>
