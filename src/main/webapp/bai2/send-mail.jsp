<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
    <h3>Send Email via Gmail SMTP</h3>
    <c:url value="/send-mail" var="url"/>
    <form action="${url}" method="post">
        To: <input type="email" name="to" required style="width: 300px;"> <br><br>
        Subject: <input type="text" name="subject" required style="width: 300px;"> <br><br>
        Message: <br>
        <textarea name="body" rows="5" cols="40" required></textarea> <br><br>
        <button type="submit">Send Email</button>
    </form>

    <c:if test="${not empty message}">
        <p style="color: ${error ? 'red' : 'green'}">${message}</p>
    </c:if>
</body>
</html>
