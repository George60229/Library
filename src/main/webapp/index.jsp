<%@ page import="com.example.library.userServlets.AuthorizationUserServlet" %>
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

        <form method="post" class="modal-content animate" action="saveUser">


            <div class="container">

                <input type="text" placeholder="Enter Username" name="login" required minlength="5">


                <input type="password" placeholder="Enter Password" name="password" required minlength="5">

                </label>
                <button type="submit">Submit</button>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id011').style.display='none'" class="cancelbtn">Cancel</button>

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
    <h2>Choose orderBy method to view all books</h2>
</div>




    <form class="form" action="show_books.jsp">


        <button type="submit">Submit</button>
        <div class="container">



            <p>
                <input type="radio" id="1x"
                       name="contact" value="author" checked>
                <label for="1x">Author</label>
            </p>
            <p>
                <input type="radio" id="2x"
                       name="contact" value="country">
                <label for="2x">Country</label>
            </p>
            <p>
                <input type="radio" id="3x"
                       name="contact" value="name">
                <label for="3x">Name</label>
            </p>


           <p>
               <input type="radio" id="4x"
                      name="contact" value="year">
               <label for="4x">Year</label>
           </p>





        </div>



    </form>




</body>
</html>