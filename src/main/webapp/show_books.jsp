<%@ page import="com.example.library.BookRepository" %>
<%@ page import="com.example.library.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/3/2022
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Show books</title>
  <link rel="stylesheet" href="styles/table_styles.less">
</head>
<body>

<table id="myTable" class="display" border="1" cellpadding="20%">

  <tr>

    <th>Name</th>
    <th>Country</th>
    <th>Amount</th>
    <th>Year</th>
    <th>Author</th>

  </tr>

  <tbody>

    <%List<Book> list = BookRepository.getAllBooksOrderByAuthor();
   request.setAttribute("myList",list);

%>
   <c:forEach items="${requestScope.myList}" var="book">
  <%


  %>

    <tr>
      <td><c:out value="${book.name}"/> </td>
      <td><c:out value="${book.country}"/> </td>
      <td><c:out value="${book.amount}"/> </td>
      <td><c:out value="${book.year}"/> </td>
      <td><c:out value="${book.author}"/> </td>

    </tr>
      <%--        </c:if>--%>
    </c:forEach>

</body>
</html>

