<?php
$servername = "localhost";

$username = "id6694494_shubham";

$password = "shubham";

$dbname = "id6694494_demo11";

// Create connection

$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection

if ($conn->connect_error)
 {
    
die("Connection failed: " . $conn->connect_error);

}

$sql = "SELECT name,phnno,vno,age,credits from users where id=".$_GET["id"];

$result = $conn->query($sql);

if ($result->num_rows > 0)
 {
    // output data of each row
    
while($row = $result->fetch_assoc())
 {
   
     echo "NAME:".$row["name"]."\nPHONE NO:".$row["phnno"]."\nVEHICLE NO:".$row["vno"]."\nAGE:".$row["age"]."\nCREDITS:".$row["credits"];
	
    //$idee=$row["id"];
   
 }

}
?>