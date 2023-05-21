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

sudo reboot

echo -e "</pre>
	</body>
</html>
"
