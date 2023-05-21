#!/bin/bash
echo Content-Type:text/html
echo -e "
<html>
	<head>
	<title>Kill process</title>
	</head>
	<body>"

read pid
echo -e $pid
ki=`echo $pid | awk -F "=" '{print $2}'`
echo -e $ki
sudo kill -9 $ki
echo -e "<h3>Procés 'Killed' satisfactoriament</h3>
	<a href='menu.sh'>Tornar Al Menu Principal</a>
	</body>
	</html>"
