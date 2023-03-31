#!/bin/bash

# 0 piedra
# 1 papel
# 2 tijera

clear
var=$RANDOM
echo $var
oppc=$(($var%3))

echo Entra piedra, papel o tijera
read opcion

if [ $opcion == piedra ]
	then 
		$opnum=0
fi
if [ $opcion == papel ]
	then 
		$opnum=1
fi
if [ $opcion == tijera ]
	then 
		$opnum=2
fi

if [ $oppc -eq $opnum ]
	then 
		echo Empate
else
	if [ $oppc -eq 0  ] && [ $opnum -eq 1  ]
		then 
			echo GANO YO. PC ha sacado $oppc y usuario ha sacado $opnum
		elif [ $oppc -eq 1 ] && [ $opnum -eq 0  ]
			then 
				echo GANA PC, PC ha sacado $oppc y usuario ha sacado $opnum
		elif [ $oppc -eq 2  ] && [ $opnum -eq 1 ]
			then
				echo GANA PC, PC ha sacado $oppc y usuario ha sacado $opnum
	else
		echo Has perdido. La maquina ha sacado $oppc y usuario ha sacado $opnum
	fi
fi

		 
