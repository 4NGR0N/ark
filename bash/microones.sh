#/bin/bash

temperatura=0
voltes=0
contador=0

#Preguntem al usuari la temperatura

echo "Pulsa temperatura: Baixa (b), Mitja (m), Alta (a):"
read temperatura
echo $temperatura

#mirem les voltes que hi toquen

if [ $temperatura == "b" ]
	then
		voltes=2
	elif [ $temperatura == "m" ]
		then
			voltes=5
	elif [ $temperatura == "a" ]
		then	
			voltes=10
fi

#escrivim per pantalla

while [ $contador != $voltes ]
do
	echo "Escalfant..."
	sleep 1
	contador=$(($contador+1))
done
