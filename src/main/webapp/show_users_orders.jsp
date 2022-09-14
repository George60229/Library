<%@ page import="com.example.library.BookRepository" %>
<%@ page import="com.example.library.Book" %>
<%@ page import="com.example.library.UserInfoRepository" %>
<%@ page import="com.example.library.UserInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show books</title>
    <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
    <link rel="stylesheet" href="styles/table_styles.less">
</head>
<body>

<table id="myTable" class="display" border="1" cellpadding="20%">

    <tr>

        <th>Reader</th>
        <th>Book</th>


    </tr>

    <tbody>

        <%List<UserInfo> list = UserInfoRepository.getAllUsersInfo();
   request.setAttribute("myList",list);

%>
    <c:forEach items="${requestScope.myList}" var="info">
            <%


            %>

    <tr>
        <td><c:out value="${info.login}"/> </td>
        <td><c:out value="${info.book}"/> </td>
    </tr>
        <%--        </c:if>--%>
    </c:forEach>

</body>
</html>

