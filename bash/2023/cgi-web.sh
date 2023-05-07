#!/bin/bash

# Set the content type to HTML
echo "Content-type: text/html"
echo ""

# Run the ps command to get a list of processes
ps_output=$(ps -aux)

# Print the list of processes in an HTML table
echo "<table>"
echo "<tr><th>USER</th><th>PID</th><th>%CPU</th><th>%MEM</th><th>VSZ</th><th>COMMAND</th></tr>"
while read -r line; do
    echo "<tr><td>$(echo $line | awk '{print $1}')</td><td>$(echo $line | awk '{print $2}')</td><td>$(echo $line | awk '{print $3}')</td><td>$(echo $line | awk '{print $4}')</td><td>$(echo $line | awk '{print $5}')</td><td>$(echo $line | awk '{print $11}')</td></tr>"
done <<< "$ps_output"
echo "</table>"

# Check if a PID was submitted via a form
if [ "$REQUEST_METHOD" = "POST" ]; then
    # Get the PID from the submitted form data
    read -n $CONTENT_LENGTH form_data
    pid=$(echo $form_data | sed 's/^.*=\(.*\)$/\1/')
    # Kill the process with the submitted PID
    kill $pid
fi

# Print a form to allow users to kill a process
echo "<form method='POST'>"
echo "<label for='pid'>Enter PID to kill:</label>"
echo "<input type='text' name='pid'>"
echo "<input type='submit' value='Kill'>"
echo "</form>"