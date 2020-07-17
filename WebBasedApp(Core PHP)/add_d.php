<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

$id = $_POST["id"];
$name = $_POST["name"];
$gender = $_POST["gender"];
$spec = $_POST["spec"];
$addr = $_POST["address"];
$mobile = $_POST["number"];
$email = $_POST["email"];

$query = "insert into doctor values($id, '$name', '$gender','$spec','$addr','$mobile','$email')";
if (mysqli_query($con, $query)) {
    echo "<h1>Doctor Data Inserted successfully</h1>";
} else {
    echo "<h1>Error Inserting Doctor is: </h1>" . mysqli_error($con);
}
?>