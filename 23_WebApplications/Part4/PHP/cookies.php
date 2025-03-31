<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Cookies</title>
</head>
<body>
    <?php
    // Set sample cookies if not already set
    if(!isset($_COOKIE["user"])) {
        setcookie("user", "JohnDoe", time() + 3600);
        setcookie("sessionID", "XYZ123", time() + 3600);
    }
    ?>
    <form method="post" action="">
        <input type="submit" name="listCookies" value="List Cookies">
    </form>
    <?php
    if(isset($_POST["listCookies"])) {
        echo "<h3>Cookies Stored:</h3>";
        if(count($_COOKIE) > 0) {
            echo "<ul>";
            foreach($_COOKIE as $name => $value) {
                echo "<li>" . htmlspecialchars($name) . " = " . htmlspecialchars($value) . "</li>";
            }
            echo "</ul>";
        } else {
            echo "No cookies found.";
        }
    }
    ?>
</body>
</html>
