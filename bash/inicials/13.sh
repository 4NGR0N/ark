#!/bin/bash
#Executa tres pings a diferents ips, en background i redirigint la seva sortida a /dev/null. Fes un script que ens mostri una llista amb el PID associat a cada ping (“numero” “PID” “pagina a la que fa ping”), i posteriorment et pregunti de quin numero de la llista vols aturar el ping.

ping -c 1 8.8.8.8 >/dev/null &
ping -c 1 4.4.4.4 >/dev/null &
ping -c 1 www.google.es >/dev/null &
echo " "
ps aux | grep "ping" | grep -v "grep" | awk '{print NR,$2,$14}'
echo " "