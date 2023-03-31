#!/bin/bash

echo PEDRA PAPER O TISORA
echo PE    PA      TI
read u1

rand=$[$RANDOM%3]

case "$rand" in 
	"0")
	u2=PA
	;;
	"1")
	u2=PE
	;;
	"2")
	u2=TI
	;;
esac
echo "Usuari 2 ha triat $u2 "
if [ $u1 == $u2 ]; then
	echo empat
else 
	if [ $u1 == PE ] && [ $u2 == TI ]; then
		echo guanya $u1 usuari 1
	elif [ $u1 == TI ] && [ $u2 == PA ]; then
	       echo guanya $u1 usuari 1
	elif [ $u1 == PA ] && [ $u2 == PE ]; then
		echo guanya $u1 usuari 1
	else 
		echo guanya $u2 usuari2
	fi
fi
