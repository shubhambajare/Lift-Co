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

$sql = "SELECT giver_id from paired where taker_id=".$_GET["id"];
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        //echo $row["name"]."\n".$row["phnno"];
	$idee=$row["giver_id"];
    }

$sql = "SELECT name,phnno from users where id=$idee";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo $row["name"]."\n".$row["phnno"];
	//$idee=$row["id"];
    }
}
}
else
{
echo "notmatch";
}


$conn->close();
?>
