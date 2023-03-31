#!/bin/bash
clear
trobat=1
echo Entra opcio
read opcio
if [ $opcio == a ]
then
	echo Entra nombre y apellido
	read nombre
	echo Entra edad
	read edad
	echo entra dni
	read dni
	while [ $trobat -eq 1 ]
	do
		idgym=$[$RANDOM]
		trobat=0
		while read line
		do
			idgymfile=`echo $line | awk -F "-" '{print $4}'`
			if [ $idgym == $idgymfile ]
			then
				trobat=1
		fi
		done < clientes.txt
	done
	echo $nombre-$edad-$dni-$idgym-1-0000-00-00 >> clientes.txt
fi
if [ $opcio == b ]
then
	canvis=0 #Variabler que s'activa si hi ha hagut canvis en date
	bucle=1 #variable que controla la posició dins del while read ione per poder fer despres el sed
	echo Entra id
	read id
	while read line
	do
		idgymfile=`echo $line | awk -F "-" '{print $4}'`
		pago=`echo $line | awk -F "-" '{print $5}'`
		if [ $id == $idgymfile ]
		then
			if [ $pago == 1 ]
			then
				previ=`echo $line | awk -F "-" '{print $1"-"$2"-"$3}'`
				echo ACCESO GARANTIZADO
				sed $bucle"d" clientes.txt > aux.txt
				dat=`date -I`
				echo $previ-$id-1-$dat >> aux.txt
				canvis=1
			else
				echo NO PAGADO
			fi
		fi
	bucle=$[$bucle+1]
	done < clientes.txt
	if [ $canvis -eq 1 ]
	then
		rm clientes.txt
		mv aux.txt clientes.txt
	fi
fi
if [ $opcio == c ]
then
	count=0
	while true
	do
	if [ $count -eq 2 ] || [ $count -eq 4 ]
	then
	cat clientes.txt | grep \\-0- | awk -F "-" '{print $1 $3}'
	fi
	if [ $count -eq 4 ]
	then
	cat clientes.txt | grep \\-1- | wc -l
	fi
	count=$[$count+1]
	if [ $count -eq 5 ]
	then
		count=1
	fi
	sleep 1
	echo -e "\n"
	done
fi
