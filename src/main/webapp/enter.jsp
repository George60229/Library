
<html>
<head>
  <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
  <title>Sign in</title>
  <link rel="stylesheet" href="styles/enter_styles.less">
</head>
<body>



<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

<div id="id01" class="modal">

  <form class="modal-content animate" action="authorizationUser" >


    <div class="container">

      <input type="text" placeholder="Enter Username" name="login" required>


      <input type="password" placeholder="Enter Password" name="password" required>
      Role: <label>
      <select name="role" class="select-css">
        <option value="Admin">Admin</option>
        <option value="Reader">Reader</option>
        <option value="Librarian">Librarian</option>
      </select>
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

<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Change role</button>

<div id="id02" class="modal">

  <form class="modal-content animate" action="changeRole" method="post">


    <div class="container">

      <input type="text" placeholder="Enter Username" name="login" required>

      Role: <label>
      <select name="role" class="select-css">
        <option value="Admin">Admin</option>
        <option value="Reader">Reader</option>
        <option value="Librarian">Librarian</option>
      </select>
    </label>
      <button type="submit">Login</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>

    </div>
  </form>
</div>

<script>
  // Get the modal
  var modal = document.getElementById('id02');

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
</script>

</body>
</html>


