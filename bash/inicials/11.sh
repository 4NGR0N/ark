#!/bin/bash
#Fes un script que ens busqui un fitxer dins d’un directori . En cas que existeixi ens digui el propietari del mateix. El script ens demanarà un nou directori, en cas que el que fiquem no existeixi

noestabe=0
while [[ noestabe -eq 0 ]];
do
    read -p "Donam un directori a buscar: " directory
    read -p "Digam el fitxer a buscar: " fitxer
    # trobar en directori arxiu que contingui $fitxer
    find ${directory}/*${fitxer}* 2>/dev/null
    # si dona codi correcte sortir del loop
    correct=$(echo $?)
    if [[ $correct -eq 0 ]]; then
        noestabe=1
    fi
done