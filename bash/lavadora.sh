#!/bin/bash
clear
echo "Escriu el programa que vols fer: [suave]/[intenso]/[extra]"
read programa

###### CENTRIFUGAT EXTRA

if [ $programa == "extra" ]
then
	echo "Supercentrifugado!"
	sleep 5
fi

###### ALGORITME PRINCIPAL PROGRAMES (funciona amb 'programas.txt')

while read line
do
	primera=`echo $line | awk '{print $1}'`
	segunda=`echo $line | awk '{print $2}'`
	tercera=`echo $line | awk '{print $3}'`
	if [ $primera == "@" ]
	then
		if [ $tercera == $programa ]
		then
			imprime=true
		else
			imprime=false
		fi
	fi
	if [[ $imprime == true && $primera != "@" ]]
	then
		echo $primera
		sleep $segunda
	fi
done < programas.txt
