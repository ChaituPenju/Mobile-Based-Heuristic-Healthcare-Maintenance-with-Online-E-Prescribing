<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

$id = $_POST["id"];
$query = "select * from patient where pid='$id'";
$result = mysqli_query($con, $query);
$rowcount = mysqli_num_rows($result);

if ($result) {
    echo "<h1>Query Worked Successfully.</h1>";
} else {
    echo "Error deleting record: " . mysqli_error($conn);
}

if($rowcount == 1){
    echo "<h1>Patient Exists.</h1>";
     echo "<a href=\"E-Prescription.html\"><input type=\"button\" value=\"Issue Prescription\"/></a>";
}else{
    echo"<h1>Your Entered Patient details does not exist.</h1>";
    echo "<a href=\"Patient_Info.html\"><input type=\"button\" value=\"Add Patient\"/></a>";
}

?>