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
</head>
<body>

<table id="myTable" class="display" border="1" cellpadding="20%">
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>

    <th>Country</th>
    <th>Amount</th>
    <th>Year</th>


  </tr>
  </thead>
  <tbody>
  <%List<Book> list = BookRepository.getAllBooksOrderByCountry();
   request.setAttribute("myList",list);

%>
   <c:forEach items="${requestScope.myList}" var="book">--%>

    <tr>
      <td><c:out value="${book.id}"/> </td>
      <td><c:out value="${book.name}"/> </td>
      <td><c:out value="${book.country}"/> </td>
      <td><c:out value="${book.amount}"/> </td>
      <td><c:out value="${book.year}"/> </td>


    </tr>
      <%--        </c:if>--%>
    </c:forEach>

</body>
</html>
