#!/bin/bash
clear

for var in 1 2 3 4 5 6 7 8 9 pep jose perro
do
	echo $var
done

for var in `ls`
do
	if [ -f $var ]
	then
		echo Element $var es fitxer >> file.txt
	fi
	if [ -d $var ]
	then
		echo Element $var es carpeta >> file.txt
	fi
done

for l in `seq 1 5`
do
	echo $l
done 
