#!/bin/bash
clear
trobat=0
efila=1
volta=1
cat /dev/null > registre.txt
cat /dev/null > carton.txt	     	#Esborra el arxiu
while [ $volta -le 15 ]
do
	var=$[$RANDOM%99] 		#Retorna del 0 al 98
	num=$[$var+1] 	  		#Offset del 1 al 99
	while read line   		#Busca si el num calculat esta al registre.txt
	do
		if [ $num -eq $line ]
		then
			trobat=1 	#trobat val 1 si trobem un valor repetit
		fi
	done < registre.txt
	if [ $trobat -eq 0 ]  		#Si no l'hem trobat  el num el posem al registre
	then
		volta=$[$volta+1]
		echo $num >> registre.txt
		echo $num
		case $efila in
			1)
				var1=$num
			;;
			2)
				var2=$num
			;;
			3)
				var3=$num
			;;
			4)
				var4=$num
			;;
			5)
				var5=$num
			;;
		esac
		efila=$[$efila+1]
		if [ $efila -eq 6  ]
		then
			echo $var1 $var2 $var3 $var4 $var5 >>  carton.txt
			efila=1
		fi
	else
		trobat=0
		echo numero repetit
	fi
	read enter
done
