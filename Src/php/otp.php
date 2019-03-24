<?php
$curl = curl_init();
curl_setopt_array($curl, array(
  CURLOPT_URL => "https://www.fast2sms.com/dev/bulk?authorization=mVI0vZLaTP1fixkMrRWqFtsK9bXynD53d7puNjcAGzUBYH4w2O49B2N7QFdeuyct8TKOAUJ1IjCGxawM&sender_id=FSTSMS&message=".urlencode('6897')."&language=english&route=p&numbers=".urlencode($_GET["phone"]),
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_SSL_VERIFYHOST => 0,
  CURLOPT_SSL_VERIFYPEER => 0,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "GET",
  CURLOPT_HTTPHEADER => array(
    "cache-control: no-cache"
  ),
));
$response = curl_exec($curl);
$err = curl_error($curl);
curl_close($curl);

echo "6897"
?>
