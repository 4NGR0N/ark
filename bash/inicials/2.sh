#!/bin/bash
#Fes un script que quan l’executem ens digui quin dia de la setmana es (dilluns, dimarts, dimecres, dijous, divendres, dissabte o diumenge)

dia=$(date +%A)
cat diaSemana.txt | grep $dia | awk '{print $2}'