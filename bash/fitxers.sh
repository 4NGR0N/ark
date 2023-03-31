#!/bin/bash
clear

#El WHILE llegeix linia a linia

while read line
do
	echo $line #linia de fitxer
	echo -e "\n"
	echo -e "\n"
	echo Hola
done < file.txt

#El FOR llegeix paraula a paraula

for paraula in `cat file.txt`
do
	echo $paraula
done

