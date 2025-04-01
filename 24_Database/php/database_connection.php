<?php
// Database connection details
$host = 'localhost';
$user = 'root';
$pass = '';
$db   = 'test';

// Create connection using MySQLi
$conn = new mysqli($host, $user, $pass, $db);
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

// Execute a sample query
$sql = "SELECT column_name FROM table1";
$result = $conn->query($sql);

// Display fetched records
if ($result->num_rows > 0) {
  while ($row = $result->fetch_assoc()) {
    echo $row['column_name'] . "<br>";
  }
} else {
  echo "No results";
}

$conn->close();
?>
