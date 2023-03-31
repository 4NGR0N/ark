#!/bin/bash
clear

# o SIN
# C, B
# 0 ECO

echo Entra una matricula
read mat
mfile=`cat pegatina.txt | grep -w $mat`       #Amb això guardem elresultat del grep a mfile
echo $mfile
last=`echo "${mfile: -1}"`       #troba la ultima lletra
echo $last
if [ $last == C ] || [ $last == B ] || [ $last == 0 ]
then
	echo "Pots entrar a la ZBE"
elif [ $last == O ]
then
	echo "No pots entrar a la ZBE"
	echo "SIN ETIQUETA"
else 
	echo "Etiqueta no coneguda"
fi

