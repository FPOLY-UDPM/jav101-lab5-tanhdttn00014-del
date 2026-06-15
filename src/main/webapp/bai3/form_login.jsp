<%--
  Created by IntelliJ IDEA.
  User: TuanTA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input name="username" value="${username}"> <br>
        <input name="password" value="${password}">  <br>
        <input type="checkbox" name="remember-me"> Remember me?
        <hr>
        <button>Login</button>
    </form>
${message}
</body>
</html>
