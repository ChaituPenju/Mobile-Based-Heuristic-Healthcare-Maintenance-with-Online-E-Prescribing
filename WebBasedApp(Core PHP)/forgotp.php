<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);
$to = $_POST['email'];
$sql = "select * from patient where email='$to'";
$query = mysqli_query($con,$sql);
$count = mysqli_num_rows($query);
while($row = mysqli_fetch_array($query)){
    $pass=$row['phone'];
}
if($count == 1){
    echo "Email Exists";
    if(mail($to,"Your Password is",$pass)){
    echo "Password sent to mail .Check your Mail.";
    }
    echo "<a href=\"PatientLogin.html\">Go to Login Page</a>";
}
else{
    echo "Email Does not exist";
}
?>