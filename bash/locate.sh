#!/bin/bash

echo "Quin element vols buscar?"
read element
sudo updatedb
locate $element > file.txt
items=`cat file.txt | wc -l`
echo "He trobat $items elements"
echo Vols que els mostri? S o N ?
read opcio
if [ $opcio == S ] 
then
	cat file.txt
else
	echo "OK no mostro res!"
fi

