#!/bin/bash
echo Con que pausa quieres los pings
read freq
while true
do
	ping -c 1 -w 1 192.168.1.1
	sleep $freq
	ping -c 1 -w 1 10.0.2.15
	sleep $freq
	ping -c 1 -w 1 192.168.1.3
done
