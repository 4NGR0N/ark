#!/bin/bash
#Fes el mateix script que l’anterior, però amb dos nivells de profunditat (directori i subdirectori)

noestabe=0
while [[ noestabe -eq 0 ]];
do
    read -p "Donam un directori a buscar: " directory
    read -p "Digam el fitxer a buscar: " fitxer
    # trobar en directori arxiu que contingui $fitxer
    find ${directory} -maxdepth 2 -name ${fitxer} -type f 2>/dev/null
    # si dona codi correcte sortir del loop
    correct=$(echo $?)
    if [[ $correct -eq 0 ]] 
    then
        noestabe=1
    fi
done