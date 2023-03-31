#!/bin/bash
#Per el script anterior, fes el llistat de tots els subdirectoris amb dos nivells de profunditat.

read -p "Donam un directori a buscar: " directory
# canviat una mica ja que requereix profunditat
find $directory -mindepth 2 -maxdepth 2 -type d
# afegit com a variable per que per algun motiu avegades fallaba, aixi va bé
correct=$(echo $?)
if [[ $correct -ne 0 ]] 
then
    echo "El directori seleccionat no existeix"
fi