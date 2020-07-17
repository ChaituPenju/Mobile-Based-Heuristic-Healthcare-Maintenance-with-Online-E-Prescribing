<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

$id = $_POST["pid"];
$name = $_POST["pname"];
$cquery = "select * from patient where pid='$id' and pname='$name'";
$query = "DELETE FROM patient WHERE pid='$id' and pname='$name'";

$cresult = mysqli_query($con, $cquery);
$result = mysqli_query($con, $query);
$rowcount = mysqli_num_rows($cresult);

if ($result) {
    echo "<h1>Query Worked Successfully.</h1>";
} else {
    echo "Error deleting record: " . mysqli_error($conn);
}

if($rowcount == 1){
    echo "<h1>Patient Exists.Deleted his Data Successfully.</h1>";
}else{
    echo"<h1>Your Entered Patient details does not exists.</h1>";
}
?>