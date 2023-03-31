#!/bin/bash
#Fes un script que ens indiqui si la tecla que hem polsat és una lletra, un número o un altre caràcter.

echo "Entra un caracter:"
read car
if [[ $car =~ ^[A-Za-z]$ ]]
then
    echo "Es una letra"
else
    echo "Es un numero"
fi