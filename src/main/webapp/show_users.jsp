<%@ page import="com.example.library.UserRepository" %>
<%@ page import="com.example.library.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2022
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Show books</title>
  <link rel="stylesheet" href="styles/table_styles.less">
  <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
</head>
<body>

<table id="myTable" class="display" border="1" cellpadding="20%">

  <tr>

    <th>Login</th>
    <th>Role</th>


  </tr>

  <tbody>

    <%List<User> list = UserRepository.getAllUsers();
   request.setAttribute("myList",list);

%>
  <c:forEach items="${requestScope.myList}" var="user">
      <%


      %>

  <tr>
    <td><c:out value="${user.login}"/> </td>
    <td><c:out value="${user.role}"/> </td>
  </tr>
    <%--        </c:if>--%>
  </c:forEach>

</body>
</html>



