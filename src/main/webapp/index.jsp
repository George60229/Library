<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>





<a href="http://localhost:8888/Library_war_exploded/sign_up.jsp">Sign up </a>


<br><br>



<a href="http://localhost:8888/Library_war_exploded/sign_in.jsp">Sign in</a>

<br><br>
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
</body>
</html>