#!/bin/bash
clear
encerts=0
while [ $encerts -lt 15 ]
do
	echo "Entra numero:"
	read number
	for num in `cat carton.txt`
	do
		if [ $num -eq $number ]
		then
			encerts=$[$encerts+1]
		fi
	done

done
echo "BINGO!!!"
