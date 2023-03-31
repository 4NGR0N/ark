#!/bin/bash
clear
rm registroreducido.txt
echo "Dime una opcion:"
echo "a) Buscar por edad"
echo "b) Comprobacion de referencia con otro fichero"
read opcion

if [ $opcion == a ]
then
	echo "Dime el año de construccion del inmueble"
	read edad

	while read linia
	do
		var=`echo $linia | awk -F "@" '{print $2}'`
		if [ $var -eq $edad ]
		then
			echo $linia | awk -F "@" '{print "Referencia: " $1, " // Fecha: " $2, " // m2: " $3}'
  		fi
	done < datos.txt
fi

if [ $opcion == b ]
then
	while read linia
	do
		var_datos=`echo $linia | awk -F "@" '{print $1}'`
		while read linia2
		do
			var_comprobacion=`echo $linia2 | awk '{print $1}'`
			if [ $var_datos == $var_comprobacion ]
			then
				echo $linia | awk -F "@" '{print "Referencia: " $1, "// Coordenadas: " $4}' >> registroreducido.txt
			fi
		done < comprobacion.txt
	done < datos.txt
fi

