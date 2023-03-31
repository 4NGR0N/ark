#!/bin/bash
clear

#El WHILE llegeix linia a linia

while read line
do
	var=`echo $line | awk '{print $3}'`   #3a columna linia de fitxer
	echo $var
	sleep 1

done < file.txt

