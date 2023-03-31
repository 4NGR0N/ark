#!/bin/bash
#Fes un script que ens faci un llistat de tots els subdirectoris que hi ha en un determinat directori entrat per línia de comandes. Si el directori no existeix, surt del script amb un missatge d’error

read -p "Donam un directori a buscar: " directory
ls -R $directory 2>/dev/null
if [[ $? -ne 0 ]] 
then
    echo "El directori seleccionat no existeix"
fi