<?php
session_start();
$name = $_SESSION['name'];
$start_time = $_SESSION['start_time'];
$end_time = time();
$duration = $end_time - $start_time; // in seconds
session_destroy();
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Logout</title>
</head>
<body>
  <h1>Thank You <?php echo htmlspecialchars($name); ?></h1>
  <p>Duration of usage: <?php echo $duration; ?> seconds.</p>
</body>
</html>
