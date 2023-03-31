#!/bin/bash
true=0
num=$[$RANDOM%101]
intents=0
while [ $true -ne 1 ]; do
	echo Intents: $intents
	echo Numero no encertat, entra numero:
	read number
	if [ $num -lt $number ]; then
		echo el numero es menor! -----------------	
	fi
	if [ $num -gt $number ]; then
		echo el numero es major! +++++++++++++++++
	fi	
	if [ $num -eq $number ]; then
		echo Has encertat !
		true=1
	fi
	intents=$[intents+1]
done
