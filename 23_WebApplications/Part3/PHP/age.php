<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Age Check</title>
</head>
<body>
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = trim($_POST["name"]);
    $age = (int)$_POST["age"];
    if ($age < 18) {
        echo "Hello " . htmlspecialchars($name) . ", you are not authorized to visit the site.";
    } else {
        echo "Welcome " . htmlspecialchars($name) . " to this site.";
    }
} else {
?>
    <form method="post" action="">
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" required><br><br>
        <input type="submit" value="Submit">
    </form>
<?php
}
?>
</body>
</html>
