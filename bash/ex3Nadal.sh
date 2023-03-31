#!/bin/bash
estacio=0
while true
do
	read tecla
	if [ $tecla == R ]
	then
		estacio=0
	fi
	if [ $tecla == S ] && [ $estacio -lt 3 ] #Si pulsan S y la estacion es menor a la 3
	then
		estacio=$[$estacio+1]
	fi
	if [ $tecla == E ]
		echo Desalojen el tren e forma tranquila gracias
	fi
	if [ $tecla == A ] && [ $estacio -gt 0 ] #Si pulsan anterior y no estamos en estacion 0
	then	
		if [ $estacio -ne 3 ] #Si estamos en la 3a estacion no podemos tirar atras.
		then 				  #Hay que hacer reset segun enunciado
			estacio=$[$estaicio-1]
		fi
	fi
	if [ $estacio -eq 1 ]
	then
		echo Barcelona Sants
	elif [ $estacio -eq 2 ]
	then
		echo Barcelona Passeig de Gracia
	elif [ $estacio -eq 3 ]
	then
		echo Barcelona el Clot Arago
	fi
done
