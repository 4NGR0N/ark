#!/bin/bash


#Exemple while
count=0
while [ $count -lt 10 ]; do
	echo Entra numero major de 10 per sortir
	read count
done 

#Exemple menu amb while pregunta 2 plats
var=0
while [ $var -lt 2 ]
do
	echo "Que vols menjar?"
	read menu
	case "$menu" in
		"pasta")
			echo hidrats per la nit no !
			var=$[var+1]
		;;
		"verdura")
			echo vegano
			var=$[var+1]
		;;
		"peix")
			echo omega 3
			var=$[var+1]
		;;
		*)
			echo "no ho tens clar?"
		;;
	esac
done

#Exemple 14 bucle tornem a primaria
i=0
echo "Entra taula de multiplicar!"
read n
while [ $i -lt 11 ] #igual que -le 10
do
	v=$[n*i]
	echo "$n per $i = $v"
	i=$[i+1]
done

