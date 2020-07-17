<?php
$db_host = 'localhost'; // Server Name
$db_user = 'root'; // Username
$db_pass = ''; // Password
$db_name = 'practice'; // Database Name

$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());	
}
$epid = $_POST["epid"];
$name = $_POST["name"];
$sql = "SELECT * 
		FROM eprescription where epid='$epid'";	
$query = mysqli_query($conn, $sql);

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
}
?>
<html>
<head>
	<title>E-prescription</title>
	<style type="text/css">
        input[type="text"]{
            font-family: Georgia, "Times New Roman", Times, serif;
	background: rgba(255,255,255,.1);
	border: none;
	border-radius: 4px;
	font-size: 16px;
	margin: 0;
	outline: 0;
	padding: 7px;
	width: 100%;
	box-sizing: border-box; 
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box; 
	background-color: #e8eeef;
	color:#8a97a0;
	-webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
	box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
	margin-bottom: 30px;
        }
    input[type="submit"],
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
	width: 100%;
	border: 1px solid #16a085;
	border-width: 1px 1px 3px;
	margin-bottom: 10px;
}
input[type="submit"]:hover,
input[type="button"]:hover
{
	background: #109177;
}
		body {
			font-size: 15px;
			color: #343d44;
			font-family: "segoe-ui", "open-sans", tahoma, arial;
			padding: 0;
			margin: 0;
		}
		table {
			margin: auto;
			font-family: "Lucida Sans Unicode", "Lucida Grande", "Segoe Ui";
			font-size: 12px;
		}

		h1 {
			margin: 25px auto 0;
			text-align: center;
			text-transform: uppercase;
			font-size: 17px;
		}

		table td {
			transition: all .5s;
		}
		
		/* Table */
		.data-table {
			border-collapse: collapse;
			font-size: 14px;
			min-width: 537px;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #e1edff;
			padding: 7px 17px;
		}
		.data-table caption {
			margin: 7px;
		}

		/* Table Header */
		.data-table thead th {
			background-color: #508abb;
			color: #FFFFFF;
			border-color: #6ea1cc !important;
			text-transform: uppercase;
		}

		/* Table Body */
		.data-table tbody td {
			color: #353535;
		}
		.data-table tbody td:first-child,
		.data-table tbody td:nth-child(4),
		.data-table tbody td:last-child {
			text-align: right;
		}

		.data-table tbody tr:nth-child(odd) td {
			background-color: #f4fbff;
		}
		.data-table tbody tr:hover td {
			background-color: #ffffa2;
			border-color: #ffff0f;
		}

		/* Table Footer */
		.data-table tfoot th {
			background-color: #e5f5ff;
			text-align: right;
		}
		.data-table tfoot th:first-child {
			text-align: left;
		}
		.data-table tbody td:empty
		{
			background-color: #ffcccc;
		}
	</style>
</head>
<body>
	<h1>E-Prescription</h1>
	<table class="data-table">
		<thead>
			<tr>
                <th>S.NO</th>
                <th>DOCTOR ID</th>
				<th>ILLNESS</th>
                <th>MEDICINE</th>
				<th>WHEN TAKE</th>
				<th>DOSAGE</th>
				<th>SPECIAL INSTRUCTION</th>
				<th>DAYS</th>
                <th>TREATMENT DATE</th>
                <th>HEALTH TIPS</th>
				<th>AMOUNT</th>
			</tr>
		</thead>
		<tbody>
		<?php
            echo '<caption class="title">E-Prescription of '.$epid.' with Patient named '.$name.'</caption>';
		$no 	= 1;
		$total 	= 0;
		while ($row = mysqli_fetch_array($query))
		{
			$amount  = $row['amount'] == 0 ? '' : number_format($row['amount']);
			echo '<tr>
					<td>'.$no.'</td>
                    <td>'.$row['did'].'</td>
					<td>'.$row['ill'].'</td>
					<td>'.$row['med'].'</td>
                    <td>'.$row['when'].'</td>
					<td>'.$row['dosage'].'</td>
					<td>'.$row['sinstr'].'</td>
                    <td>'.$row['days'].'</td>
					<td>'. date('F d, Y', strtotime($row['tdate'])) . '</td>
                    <td>'.$row['htip'].'</td>
					<td>'.$amount.'</td>
				</tr>';
			$total += $row['amount'];
			$no++;
		}?>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="10">TOTAL</th>
				<th><?=number_format($total)?></th>
			</tr>
		</tfoot>
	</table>
    <form method="post" action="acknowledge.php">
        <input type="text" name="epid" placeholder="Enter prescription id and name *"/>
        <input type="text" name="did" placeholder="Enter doctor id *"/>
    <input type="submit" value="Dispense Medicines and send Acknowledgement"/>
        <a href="Medical%20Login.html"><input type="button" value="Logout"/></a>
    </form>
</body>
</html>