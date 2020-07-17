<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);

$id = $_POST["epid"];
$cquery = "select * from eprescription where epid='$id'";
$query = "DELETE FROM eprescription WHERE epid='$id'";
$cresult = mysqli_query($con, $cquery);
$result = mysqli_query($con, $query);
$rowcount = mysqli_num_rows($cresult);

if ($result) {
    echo "<h1>Query Worked Successfully.</h1>";
} else {
    echo "Error deleting record: " . mysqli_error($conn);
}

if($rowcount >= 1){
    echo "<h1>Prescription Exists.Deleted Data Successfully.</h1>";
    echo "<a href=\"del_ep.html\"><input type=\"button\" value=\"Go Back\"/></a>";
}else{
    echo"<h1>Your Entered Prescription details does not exists.</h1>";
    echo "<a href=\"del_ep.html\"><input type=\"button\" value=\"Go Back\"/></a>";
}

?>