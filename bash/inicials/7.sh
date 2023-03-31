#!/bin/bash
#Fes un script que li digui a l'usuari que l’executa quin és el seu “login” i quin és el seu “home”

nom=$(whoami)
echo "El teu login es:" $nom
directory=$(cat /etc/passwd | grep $nom | awk -F ":" '{print $6}')
echo "El teu home directory es:" $directory