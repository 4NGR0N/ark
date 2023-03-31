#!/bin/bash

# Interficie "dinamica" per a conectarnos al servior / ip que passem com a argument i poder enviar comandes predefinides

clear
echo -e "Conectant a la IP $1"
sleep 1
clear
echo -e "Conectant a la IP $1."
sleep 1
clear
echo -e "Conectant a la IP $1.."
sleep 1
clear
echo -e "Conectant a la IP $1..."
sleep 1
clear
sleep 1

ncat -nv $1 4444 2>/dev/null
