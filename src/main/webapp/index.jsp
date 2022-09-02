<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
<title>Main page</title>
    <link rel="stylesheet" href="styles/enter_styles.less">
</head>
<body bgcolor="#fff8dc">

<div class="one"><h1>Welcome to the best library</h1>


    <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

    <div id="id01" class="modal">

        <form class="modal-content animate" action="authorizationUser">


            <div class="container">

                <input type="text" placeholder="Enter Username" name="login" required>


                <input type="password" placeholder="Enter Password" name="password" required>

                </label>
                <button type="submit">Login</button>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>

    <script>
        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>

    <button onclick="document.getElementById('id011').style.display='block'" style="width:auto;">Register</button>

    <div id="id011" class="modal">

        <form class="modal-content animate" action="authorizationUser">


            <div class="container">

                <input type="text" placeholder="Enter Username" name="login" required minlength="5">


                <input type="password" placeholder="Enter Password" name="password" required minlength="5">

                </label>
                <button type="submit">Submit</button>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id011').style.display='none'" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>

    <script>
        // Get the modal
        var modal = document.getElementById('id01');

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</div>


<div class="wrapper">





</div>
</body>
</html>