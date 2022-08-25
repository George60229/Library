<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/19/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter name</title>
</head>
<body>
<form action="authorizationUser">
    <h1>Sign in</h1>
    Login:<input type="text" name="login">
<br><br>

    Password:<input type="text" name="password">
    <br><br>
    Role: <select name="role">
    <option value="Admin">Admin</option>
    <option value="Reader">Reader</option>
    <option value="Librarian">Librarian</option>
</select>
    <br><br>
    <button name="button">Enter</button>

</form>



</body>
</html>
