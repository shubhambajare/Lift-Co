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

$sql = "SELECT id from active where start='".$_GET["from"]."' and end='".$_GET["to"]."'";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        //echo $row["id"];
	$idee=$row["id"];
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
$sql = "insert into paired values($idee,".$_GET["id"].",0)";
$conn->query($sql);
$sql = "insert into paired values(".$_GET["id"].",$idee,0)";
$conn->query($sql);

$sql = "delete from active where id=$idee";
$conn->query($sql);
}

else
{
echo "111";
}

$conn->close();
?>
