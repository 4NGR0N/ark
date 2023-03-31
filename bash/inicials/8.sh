#!/bin/bash
#Fes un script que ens mostri per pantalla quin és el "UID” de cadascun dels usuaris (només dels usuaris que no son de sistema) de la màquina (“login” “UID”)

echo ""
echo "##############################"
echo -e "\tLogin" ---- "UID"
echo "##############################"
cat /etc/passwd | grep -v "bash" | awk -F ":" '{print $1,"--",$3}'
echo ""