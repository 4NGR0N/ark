#!/bin/bash

echo "Content-type: text/html"
echo -e "
<html>
	<head>
		<title>Procs</title>
"
echo "<style>"
echo "table {"
echo "    border-collapse: collapse;"
echo "    width: 75%;"
echo "}"
echo ""
echo "table th, table td {"
echo "    border: 1px solid black;"
echo "    padding: 8px;"
echo "    text-align: center;"
echo "}"
echo ""
echo "table th {"
echo "    background-color: #dddddd;"
echo "}"
echo "</style>"
echo -e	"</head>
	<body>"

ps_output=$(ps -aux)

echo "<center><table>"
echo "<tr><th>USER</th><th>PID</th><th>%CPU</th><th>%MEM</th><th>VSZ</th><th>COMMAND</th></tr>"
while read -r line
do

    echo "<tr><td>$(echo $line | awk '{print $1}')</td><td>$(echo $line | awk '{print $2}')</td><td>$(echo $line | awk '{print $3}')</td><td>$(echo $line | awk '{print $4}')</td><td>$(echo $line | awk '{print $5}')</td><td>$(echo $line | awk '{print $11}')</td></tr>"

done <<< "$ps_output"

echo "</table></center>"

echo -e "
	<br>
	<br>
	<form method='POST' action='./killer.sh'>
	<label for='pid'>Enter PID to kill:</label>
	<input type='text' name='pid'>
	<input type='submit' value='Kill'>
	</form>
	</body>
"
