<?php
$to="krishnareddymuddu29@gmail.com";
$subject="abcd";
$txt = "Mail times";
for($i=1;$i<10;$i++){
if(mail($to,$subject,$txt)){
    echo "Mail Sent ".$i;
}
    else{
        echo "Mail not sending";
    }
}
?>