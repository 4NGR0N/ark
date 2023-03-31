#!/bin/bash
clear
cat /dev/null > postres.txt

contador=0
clients=0

while read line
do
	modul=$[$contador%4]
	if [ $modul -eq 0 ]
	then
		#He trobat un client
		echo es un nom
		clients=$[$clients+1]
	else
		#He trobat un plat
		if [ $modul -eq 3 ]		#miro si es un postre
		then
			echo $line >> postres.txt
		else
			echo $line
		fi
	fi
	contador=$[$contador+1]

done < comanda.txt

echo -e "\n"
echo "Hi ha $clients clients"
echo -e "\n"
echo "Postres: "
echo -e "\n"
cat postres.txt
echo -e "\n"
echo @@@@@@@@ Altra forma de fer-ho @@@@@@@@@

contador=0
clients=0

while read line
do

	if [ $contador -eq 0 ]
	then
		echo "Es un nom"
		clients=$[$clients+1]
	else
		echo $line
	fi
	if [ $contador -eq 3 ]
	then
		contador=0
	else
		contador=$[$contador+1]
	fi

done < comanda.txt
