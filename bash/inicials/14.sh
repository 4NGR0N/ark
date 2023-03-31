#!/bin/bash
#Fes un script que faci un llista dels usuaris que han fet login en el sistema. El script s’executarà cada minut, la sortida ha de ser de la forma: “data” “hora” “usuaris logejats” i s’ha d’escriure sobre un fitxer. (pots utilitzar CRON)

echo -e "Username\t" " Data\t" "Hora Login" " N. Users\t" | tee users_log.txt
num_user=$(who | awk '{print $1}' | sort -u | wc -l)
who | awk -v num=$num_user '{print $1, "\t\t ",$3, " \t ", $4, "\t ", num}' | sort -u -k 1 | tee -a users_log.txt
# per a que repeteixi cada minut fariam servir crontab -e i hi escriuriem " * * * * * Ejercici14.sh" per a repetir cada minut cada dia cada mes i setmana