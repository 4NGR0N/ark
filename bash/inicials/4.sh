#!/bin/bash
#Fes un script que ens calculi el factorial d’un nombre

read -p "Dame un numero para el factorial: " numInput
count=1
total=1
while [[ $count -lt $numInput ]]
do
    total=$(($total * $count))
    ((count++))
done
echo $total