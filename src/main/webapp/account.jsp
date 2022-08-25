<%@ page import="com.example.library.userServlets.AuthorizationUserServlet" %><%--
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
<p>Name: <%=AuthorizationUserServlet.login%></p>
<p>Role: <%= AuthorizationUserServlet.role %></p>
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
<% if (AuthorizationUserServlet.role.equals("Admin")) { %>
<a href="http://localhost:8888/Library_war_exploded/save_book.jsp">Save book</a>
<% }
%>


<br>
<br>

<a href="http://localhost:8888/Library_war_exploded/test.jsp">My Info</a>

<br>
<br>

<form method="post" action="takeBook">
    <br><br>
    Take book
    Name:<input type="text" name="name">
    <br><br>
    <button name="button">Enter</button>

</form>


</body>
</html>
