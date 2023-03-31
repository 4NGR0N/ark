#!/bin/bash

for variable in `ls`
do

	if [ -f $variable ]; then
		echo $variable  es un fitxer
	elif [ -d $variable ]; then
		echo $variable es una carpeta
	else
		echo $variable ni es fitxer ni es carpeta
	fi

done

#################################LLEGIM PARAULA A PARAULA un fitxer exemple.txt  AMB FOR

for paraula in `cat exemple.txt`
do

	echo $paraula

done
echo -e "\n"


##################################LLEGIM LINEA A LINEA un fitxer exemple.txt AMB WHILE

while read line
do
	echo $line
done < exemple.txt



##################################DIFERENTS CONDICIONS EN UN IF
echo entra var
read var
if [ $var -gt 5 ] && [ $var -lt 10 ]
then
	#AND &&
	#OR ||
	echo $var es major a 5 pero menor a 10
fi













