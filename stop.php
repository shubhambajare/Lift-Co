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

$sql = "DELETE from active where id=".$_GET["id"];
$conn->query($sql);

$conn->close();
?>
