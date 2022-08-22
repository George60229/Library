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
</head>
<body>

<form method="post" action="save-user">

    Login: <input name="login" />
    <br><br>
    Password: <input name="password"  />
    <br><br>
    Role: <select name="role">
        <option value="Admin">Admin</option>
        <option value="Reader">Reader</option>
        <option value="Librarian">Librarian</option>
    </select>

    <br><br>
    <input type="submit" value="Submit" />
</form>




</body>
</html>
