<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PHP Script Demo</title>
</head>
<body>
  <h2>PHP Script for Sum of Digits and Palindrome Check</h2>
  <form method="post" action="">
    <label for="number">Enter a Number:</label>
    <input type="text" id="number" name="number" required>
    <br><br>
    <input type="submit" value="Submit">
  </form>

  <?php
  if (isset($_POST['number'])) {
      $number = trim($_POST['number']);

      // Calculate sum of individual digits
      $temp = $number;
      $sum = 0;
      while ($temp > 0) {
          $sum += $temp % 10;
          $temp = floor($temp / 10);
      }

      // Check whether the number is a palindrome
      $reverse = strrev($number);
      $isPalindrome = ($number === $reverse) ? "Yes, it is a palindrome." : "No, it is not a palindrome.";

      echo "<h3>Results for number: $number</h3>";
      echo "Sum of individual digits: $sum<br>";
      echo "Palindrome check: $isPalindrome";
  }
  ?>
</body>
</html>
