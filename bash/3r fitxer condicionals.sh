#!/bin/bash

#Exemple 7 comparacio variable amb constant
echo Entra numero
read number
if [ $number -gt "5" ]
then
	echo es mes gran que 5
fi
#Tambe es pot if i then a la mateix linea emprant ;
if [ $number -gt "7" ]; then
echo es mes gran que 7; fi
#-------------------------------------------------------------
###########COMPARADORS########################
#  -lt <
#  -gt >
#  -le <=
#  -ge >=
#  -eq ==
#  -ne !=
###############################################

#Exemple 8 comparacio cadenes
echo entra la password
read pass
if [ $pass = "pepe" ]
then
	echo password correcte
else
	echo password incorrecte
fi
#--------------------------------------------------------------
###########COMPARADORS STRINGS#################
#  s1=s2
#  s1!=s2
#  -n s1 is not null
#  -z s1 is null
###############################################
#Exemple 9 case
echo "Que vols menjar?"
read menu
case "$menu" in
	"pasta")
		echo hidrats per la nit no !
	;;
	"verdura")
		echo vegguie
	;;
	*)
		echo no ho tens clar?
	;;
esac


