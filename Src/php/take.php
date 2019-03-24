<?php
$servername = "localhost";
$username = "id6694494_shubham";
$password = "shubham";
$dbname = "id6694494_demo11";
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "insert into active values(".$_GET["id"].",'".$_GET["from"]."','".$_GET["to"]."')";
$conn->query($sql);
echo "ok";
$conn->close();
?>
