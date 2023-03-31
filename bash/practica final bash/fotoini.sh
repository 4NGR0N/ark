#!/bin/bash

# asignem una variable per a guardad la nostra IP
mip=$(ip a | grep "inet " | grep -v "127.0" | awk '{print $2}' | awk -F "/" '{print $1}')

# amb nmap escanejem totes les IP a les que te acces aquest servidor de monitoritzacio i les guardem en un txt
nmap -sn 10.0.2.0/24 -oG ips.txt >/dev/null 2>&1

# llegim el txt i filtre per paraules clau, obtenint les IP formatejades correctament
cat ips.txt | grep -v "Nmap" | grep -v "\.1 " | grep -v ".254 " | grep -v $mip | awk '{print $2}' | sponge ips.txt

# creem un arxiu anomenat portsIP buit, en cas de existeixi que es borri
cat /dev/null > portsIp.txt

# fem un bucle que itera de ip en ip, fent un escanejat de ports per cadas cuna i guardant el resultat formatejat en l'arxiu anteriorment creat
for ip in $(cat ips.txt)
do
		nmap -p- -sS --min-rate 5000 -n -Pn $ip | grep open | awk -F "/" -v ip=$ip '{print ip , $1 , "open"}' >> portsIp.txt
done
