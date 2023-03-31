#!/bin/bash

pause=1
while [ $pause -eq 1 ]; do
	rand=$[$RANDOM%101]
	a=$[$rand+100]
	echo He calculado $a
	echo Entra numero
	read b


	while [ $b -gt 10 ] || [ $b -lt 1 ]; do
		echo Numero no valido
		read b
	done

	paroimpar=$[$b%2]
	if  [ $paroimpar -eq 0 ]; then 
		#es par
		a=$[$a+$b]
	else
		#es impar
		a=$[$a-$b]
	fi

	echo "Es de tu agrado el número: $a ? (S o N)"
	read yesno

	if [ $yesno == S ]; then  
		echo -e $a"O"
		pause=0
	elif [ $yesno == N ]; then
		echo -e $a"K"
	else
		echo letra no valida
	fi

done
