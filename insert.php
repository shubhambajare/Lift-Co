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
$p=$_GET["phone"];
$sql = "insert into users values(null,'".$_GET["name"]."',".$p.",'".$_GET["vno"]."',".$_GET["age"].",100)";
$conn->query($sql);

$sql = "SELECT id from users where phnno=".$p;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo $row["id"];
    }
}
?>
