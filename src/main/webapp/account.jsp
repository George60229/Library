<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2022
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Name: <%= request.getParameter("login") %></p>
<p>Role: <%= request.getParameter("role") %></p>
<form action="checkOrderBook">
    <p>Please select your preferred orderBy method:</p>
    <div>
        <input type="radio" id="1"
               name="contact" value="1"checked>
        <label for="1">Author</label>

        <input type="radio" id="2"
               name="contact" value="2">
        <label for="2">Country</label>

        <input type="radio" id="3"
               name="contact" value="3">
        <label for="3">Name</label>
        <input type="radio" id="4"
               name="contact" value="4">
        <label for="4">Year</label>

    </div>
    <div>
        <button type="submit">Submit</button>

    </div>
</form>


<h1><%= "View Books" %>
</h1>
<a href="viewBooksOrderByName">View Books servlet</a>

<h1><%= "My Info" %>
</h1>
<a href="http://localhost:8888/Library_war_exploded/test.jsp">My Info</a>

<h1><%= "Save Book " %>
</h1>
<a href="http://localhost:8888/Library_war_exploded/save_book.jsp">Save book</a>
</body>
</html>
