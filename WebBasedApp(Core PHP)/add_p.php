<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

$id = $_POST["id"];
$name = $_POST["name"];
$age = $_POST["age"];
$gender = $_POST["gender"];
$bp = $_POST["bp"];
$addr = $_POST["address"];
$email = $_POST["email"];
$mobile = $_POST["number"];


$query = "insert into patient values('$id', '$name','$age', '$gender','$bp','$addr','$email','$mobile')";
if (mysqli_query($con, $query)) {
    echo "<h1>Patient Data Inserted successfully</h1>";
    echo "<a href=\"E-Prescription.html\"><input type=\"button\" value=\"Issue Prescription\"/></a>";
} else {
    echo "<h1>Error Inserting Patient is: </h1>" . mysqli_error($con);
}
?>