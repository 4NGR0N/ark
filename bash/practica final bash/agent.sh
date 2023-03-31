#!/bin/bash
clear

# Menu interactiu per a poder enviar comandes al servidor corresponent
echo -e "\n[+] Benvingut al menu principal de $HOSTNAME, siusplau escull una opcio:"
echo -e "\n\t- mem - Per a observar la memoria dels 10 procesos principals."
echo -e "\t- file - Per a poder comprovar els filesystems."
echo -e "\t- cpu - Per a analitzar el consum de la CPU per als 10 primers processos."

while true
do
	#read -p $'\nSiusplau introdueix una comanda:\n'$HOSTNAME" >> " comanda
	echo -en "\nSiusplau introdueix una comanda:\n$HOSTNAME >> " 
	read comanda


	# si la comanda es mem extraurem el % de consum de memoria dels 10 procediments mes als
	if [[ $comanda == "mem" ]]
	then
		clear
		echo ""
		ps aux | sort -rk 4 | awk '{print $1"\011\011"$2"\011\011"$4"\011\011"$11}' | head -11
	# si la comanda es file obtindrem els filesystems del servidor
	elif [[ $comanda == "file" ]]
	then
		clear
		echo ""
		df -h	
	# si la comanda es cpu obtimdren el % de consum de CPU dels 10 proceso mes alts
	elif [[ $comanda == "cpu" ]]
	then
		clear
		echo ""
		ps aux | sort -rk 3 | awk '{print $1"\011\011"$2"\011\011"$3"\011\011"$11}' | head -11
	# amb exit sortirem del programa poden seguir al següent server
	elif [[ $comanda == "exit" ]]
	then
		clear
		echo -e "\nExiting"
		sleep 1
		clear
		echo -e "\nExiting."
		sleep 1
		clear
		echo -e "\nExiting.."
		sleep 1
		clear
		echo -e "\nExiting..."
		sleep 1
		clear
		exit 0

	fi
done
