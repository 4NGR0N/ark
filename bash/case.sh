#!/bin/bash
#manera "if" de fer-ho
for i in `seq 1 3`
do
	if [ $i -eq 1 ]
	then
		echo Es 1
	elif [ $i -eq 2  ]
	then
		echo Es 2
	elif [ $i -eq 3  ]
	then
		echo Es 3
	fi
#manera case (es a dins del for per agafar la $i)
	case $i in
		1)
			echo Es $i
		;;
		2)
			echo Es $i
		;;
		3)
			echo Es $i
		;;
	esac 
done
