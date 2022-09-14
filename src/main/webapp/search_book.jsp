<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2022
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
    <title>Title</title>
</head>
<body>

<form method="get" action="viewBookByName">

  Name book: <input name="name" type="text" required/>

  <input type="submit" value="Submit" />
</form>

<form method="get" action="viewBookByAuthor">

  Author: <input name="author" type="text" required/>

  <input type="submit" value="Submit" />
</form>
</body>
</html>
