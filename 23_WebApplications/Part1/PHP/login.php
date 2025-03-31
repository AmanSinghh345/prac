<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
  <form action="hello.php" method="post">
    Enter your name: <input type="text" name="name" required>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
