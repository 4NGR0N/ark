#!/bin/bash

echo "Content-type: text/html; charset=UTF-8"
echo -e "
<html>
	<head>
		<title>Monitor</title>
"
echo -e	"</head>
	<body>
<pre>"

free -m | awk 'NR==2{printf "<b>\tMemoriautilitzada:</b> %s/%sMB (%.2f%%)\n", $3,$2,$3*100/$2}'
df -h | awk '$NF=="/"{printf "<b>\tHDD:</b> %d/%dGB (%s)\n", $3,$2,$5}'
top -bn1 | grep load | awk '{printf "<b>\t Càrrega CPU:</b> %.2f %%\n", $(NF-2)}'
echo -e "<h3> Temps en funcionament:</h3>"
uptime | awk '{print "\t"$2,$3,"minutes"}' | sed "s/\,//g"
echo -e "</pre>
	</body>
</html>
"
