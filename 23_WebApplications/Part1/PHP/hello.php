<?php
session_start();
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $_SESSION['name'] = $_POST['name'];
    $_SESSION['start_time'] = time();
}
$name = $_SESSION['name'];
$start_time = $_SESSION['start_time'];
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Hello <?php echo htmlspecialchars($name); ?></title>
  <style>
    .top-right { position: absolute; top: 10px; right: 10px; }
  </style>
</head>
<body>
  <div class="top-right">
    Start Time: <?php echo date('Y-m-d H:i:s', $start_time); ?>
  </div>
  <h1>Hello <?php echo htmlspecialchars($name); ?></h1>
  <form action="logout.php" method="post">
    <input type="submit" value="Logout">
  </form>
</body>
</html>
