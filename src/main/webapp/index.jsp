<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<body>

<h2 align="center"><font color="#675bf5" size="5"><strong>Welcome to best library</strong></font></h2>


<div class="wrapper">
    <div class="logger">
        <a class="logger__link" href="http://localhost:8888/Library_war_exploded/sign_up.jsp">Sign up </a>
        <a class="logger__link" href="http://localhost:8888/Library_war_exploded/sign_in.jsp">Sign in</a>
    </div>

    <form class="form" action="checkOrderBook">
        <p class="form__title">Please select your preferred orderBy method for books:</p>
        <div>
            <input type="radio" id="1"
                   name="contact" value="1" checked>
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
</div>
</body>
</html>