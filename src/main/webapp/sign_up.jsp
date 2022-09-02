<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/19/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<body>

<form method="post" action="save-user">
<h1>Sign up</h1>
    Login: <input name="login " minlength="5"/>
    <br><br>
    Password: <input name="password" minlength="5" />
    <br><br>
    Role: <select name="role" class="select-css">
        <option value="Admin">Admin</option>
        <option value="Reader">Reader</option>
        <option value="Librarian">Librarian</option>
    </select>

    <br><br>
    <button name="button">Enter</button>
</form>




</body>
</html>
