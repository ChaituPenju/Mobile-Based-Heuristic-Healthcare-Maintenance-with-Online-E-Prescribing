<?php 
   define('DB_SERVER', 'localhost');
   define('DB_USERNAME', 'root');
   define('DB_PASSWORD', '');
   define('DB_DATABASE', 'practice');
$con=mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);
?>
<html>
<head>
<style>
input[type="button"]
{
	position: relative;
	display: block;
	padding: 19px 39px 18px 39px;
	color: #FFF;
	margin: 0 auto;
	background: #1abc9c;
	font-size: 18px;
	text-align: center;
	font-style: normal;
	width: 30%;
	border: 1px solid #16a085;
	border-width: 1px 1px 3px;
	margin-bottom: 10px;
}
input[type="button"]:hover
{
	background: #109177;
}
</style>
</head>
    <body>
    
    </body>
</html>
<?php
$id = $_POST["pid"];
$did = $_POST["did"];
$name = $_POST["pname"];
$ill = $_POST["ill"];
$med = $_POST["med"];
$when = $_POST["when"];
$dose = $_POST["dose"];
$instr = $_POST["instr"];
$days = $_POST["days"];
$tdate = $_POST["tdate"];
$htips = $_POST["htips"];
$amount = $_POST["amount"];
$mail = $_POST["mail"];

$query = "insert into eprescription values('$id','$did', '$name', '$ill','$med','$when','$dose','$instr','$days','$tdate','$htips',$amount)";
$subject = "Your E-Prescription";
$message = "Login to page to see prescription:http://192.168.137.1:8085/doc/PatientLogin.html";
if(mail($mail,$subject,$message)){
    echo "<h1>Prescription Sent to Mail.</h1>";
}
if (mysqli_query($con, $query)) {
    echo "<h1>E-Prescription Data Inserted successfully</h1>";
    echo "<input type=\"button\" onclick=\"location.href='E-Prescription.html'\" value=\"Add More Medicines in Prescription\"/>";
} else {
    echo "<h1>Error Inserting Doctor is: </h1>" . mysqli_error($con);
}
?>