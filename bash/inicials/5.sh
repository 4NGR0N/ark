#!/bin/bash
#Fes un script que ens digui si un nombre és primer

read -p "Dame un numero para comprobar: " numInput
count=$(($numInput-1))
while [[ $count -gt 0 ]]
do
    remn=$(($numInput % $count))
    if [[ $remn -eq 0 && $count -ne 1 ]];
    then
        noes=1
    fi
    count=$(($count-1))
done
if [[ $noes -ne 1 ]]; then
    echo "Es primo"
fi