#!/bin/bash
clear
trobat=0
cat /dev/null > registre.txt     	#Esborra el arxiu
while true
do
	var=$[$RANDOM%99] 		#Retorna del 0 al 98
	num=$[$var+1] 	  		#Offset del 1 al 99
	while read line   		#Busca si el num calculat esta al registre.txt
	do
		if [ $num -eq $line  ]
		then
			trobat=1 	#trobat val 1 si trobem un valor repetit
		fi
	done < registre.txt
	if [ $trobat -eq 0 ]  		#Si no l'hem trobat  el num el posem al registre
	then
		echo $num >> registre.txt
		echo $num
	else
		trobat=0       		#Si trobat val 1 el reinicio
		echo numero repetit
	fi
	read enter
done

