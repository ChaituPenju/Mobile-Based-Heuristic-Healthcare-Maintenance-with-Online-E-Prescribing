<?php
$db_host = 'localhost'; // Server Name
$db_user = 'root'; // Username
$db_pass = ''; // Password
$db_name = 'practice'; // Database Name
$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());	
}
$epid=$_POST['epid'];
$did=$_POST['did'];
$sql = "select * from doctor where id='$did'";
$query = mysqli_query($conn,$sql);
while($row = mysqli_fetch_array($query)){
    $to=$row['email'];
}
$subject = "Patient took Medicines";
$txt = "Patient ".$epid." took medicines";
if(mail($to,$subject,$txt)){
    echo "Successfully acknowledged";
}
else{
    echo "Mail Not Sent";
}
?>