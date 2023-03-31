#!/bin/bash
jugadaCPU=`shuf -i 0-2 -n 1`

echo "Digue'm una jugada (Pedra=0, Paper=1, Tisora=2)"
read jugadaPlayer

echo $jugadaPlayer
echo $jugadaCPU

if [ $jugadaCPU == 0 ] && [ $jugadaPlayer == 0 ] 
	then 
		echo "Empat Pedra -- Pedra"
	elif [ $jugadaCPU -eq 0 ] && [ $jugadaPlayer -eq 1 ]
		then 
			echo "Guanya jugador! Pedra -- Paper"
	elif [ $jugadaCPU -eq 0 ] && [ $jugadaPlayer -eq 2 ] 
		then 
			echo "CPU guanya! Pedra -- Tisora"
	elif [ $jugadaCPU -eq 1 ] && [ $jugadaPlayer -eq 0 ]
		then 
			echo "Guanya CPU! Paper -- Pedra"
	elif [ $jugadaCPU -eq 1 ] && [ $jugadaPlayer -eq 1 ] 
		then 
			echo "Empat Paper -- Paper"
	elif [ $jugadaCPU -eq 1 ] && [ $jugadaPlayer -eq 2 ]
		then 
			echo "Guanya Jugador! Paper -- Tisora"
	elif [ $jugadaCPU -eq 2 ] && [ $jugadaPlayer -eq 0 ]
		then 
			echo "Guanya Jugador! Tisora -- Pedra"
	elif [ $jugadaCPU -eq 2 ] && [ $jugadaPlayer -eq 1 ]
		then 
			echo "CPU guanya! Tisora -- Paper"
	elif [ $jugadaCPU -eq 2 ] && [ $jugadaPlayer -eq 2 ]
		then 
			echo "Empat Tisora -- Tisora"
fi
