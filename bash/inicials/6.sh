#!/bin/bash
#Fes un script que ens faci una llista del nombres primers. Per fer aquest script aprofita l’anterior, i dissenya una funció que ens digui si un nombre és o no primer.

numInput=1
while [[ numInput -lt 100 ]]
do
    count=$(($numInput-1))
    noes=0
    rem=1
    while [[ $count -gt 0 ]]
    do
        remn=$(($numInput % $count))
        if [[ $remn -eq 0 && $count -ne 1 ]];
        then
            noes=1
        fi
        count=$(($count-1))
    done
    if [[ $noes -ne 1 ]] 
    then
        echo $numInput >> numPrimos.txt
    fi
    numInput=$(($numInput+1))
done