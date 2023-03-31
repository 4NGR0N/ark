#!/bin/bash
while true; do
rm monitor.txt
nlineas=`wc -l < pacientes.txt`
if [ $nlineas -gt 15 ]; then
	echo SATURACION EN SALA DE ESPERA
fi
while read line
do
	nom=`echo $line | awk '{print $1 $2}'`
	edat=`echo $line | awk '{print $3}'`
	dni=`echo $line | awk '{print $4}'`
	temps=`echo $line | awk '{print $5}'`
	prio=`echo $line | awk '{print $6}'`

	if [ $edat -lt 18 ] && [ $temps -gt 1800 ]; then
		if [ $prio -lt 5 ]; then
			prio=$[prio+1]
		fi
	fi
	letra=`echo "${dni:: -8}"`
	if [ $letra == X ] || [ $letra == Y ] || [ $letra == Z ]; then
		if [ $prio -gt 2 ]
		then
			prio=2
		fi
	fi
	echo $nom $edat $dni $temps $prio >> monitor.txt
done < pacientes.txt
sleep 3
done
