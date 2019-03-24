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
/*
$sql = "UPDATE TABLE paired SET finishflag=1 where taker_id=".$_GET["id"];
$conn->query($sql);

$sql = "SELECT finishflag from paired where giver_id=".$_GET["id"];
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $flag=$row["finishflag"];
    }
}
if ($flag == 1)
{

}
*/
$sql ="DELETE from paired where taker_id=".$_GET["id"];
$conn->query($sql);
$sql ="DELETE from paired where giver_id=".$_GET["id"];
$conn->query($sql);

$conn->close();
?>
