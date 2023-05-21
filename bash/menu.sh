#!/bin/bash
echo "Content-Type:text/html; charset=UTF-8"
echo -e "
<html>
	<head>
		<title>Benvinguts al website de monitorització</title>
	</head>
	<body>
	<pre>
"
echo -e "<h1> Benvingut almenu principal</h1>"
echo -e "<h3> Escull una opcio </h3>"
echo -e "<a href='script_web.sh'>Processos del Sistema</a><br>"
echo -e "<a href='moni.sh'>Monitoritzacio del Sistemaa</a><br>"
echo -e "<a href='rebota.sh'>Reboot del sistema</a><br>"
echo -e "</pre>
	</body>
</html>"
