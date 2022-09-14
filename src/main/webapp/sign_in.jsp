<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/19/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter name</title>
    <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
    <link rel="stylesheet" href="styles/enter_styles.less">
</head>
<body>

<h1>Sign in</h1>
<button id="show">Show password</button>
<br>
<br>



<form action="authorizationUser">

    Login:<input type="text" name="login" minlength="5">
<br><br>

    Password:<input type="password" name="password" minlength="5" id="show1">

    <script>
        var input = document.getElementById("show1");
        var button = document.getElementById("show");
        button.onclick = show;

        function show () {
            if(input.getAttribute('type') == 'password') {
                input.removeAttribute('type');
                input.setAttribute('type', 'text');
                button.innerHTML='Hide password';

            } else {
                input.removeAttribute('type');
                input.setAttribute('type', 'password');
                button.innerHTML='Show password';

            }
        }
    </script>
    <br><br>
    Role: <label>
    <select name="role" class="select-css">
    <option value="Admin">Admin</option>
    <option value="Reader">Reader</option>
    <option value="Librarian">Librarian</option>
</select>
</label>
    <br><br>
    <button name="button">Enter</button>

</form>



</body>
</html>
