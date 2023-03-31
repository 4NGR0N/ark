#!/bin/bash

# creem un arxiu anomenat nouPorts i si existeix el buida
cat /dev/null > nouPorts.txt
# creem una variable de control booleana
canvi=false

# amb un bucle formatejem els resultats de la lectura de l'arxiu portsIP i obtenim les variables per separat per a poder treure-les per pantalla posteriorment, ja estigui tancat o obert tot comprovat amb un echo >/dev/null/{IP}/{PORT}
while read line
do
	estat=$(echo $line | awk '{print $3}')
	ip=$(echo $line | awk '{print $1}')
	port=$(echo $line | awk '{print $2}')

	(echo >/dev/tcp/$ip/$port) >/dev/null 2>&1
	
	if [[ $? -eq 0 ]]
	then
		echo "$ip $port open" >> nouPorts.txt
	else
		echo "$ip $port close" >> nouPorts.txt
	fi

done < portsIp.txt

# comprovem que el resultat sigui diferent al que tenia manteriorment, es a dir que hi ha hagut un canvi
diff nouPorts.txt portsIp.txt >/dev/null 2>&1

# si el resultat no es 0 es a dir, hi ha hagut un canvi, canviem la variable control "canvi"
if [[ $? -ne 0 ]]
then
	canvi=true
fi

# com hi ha hagut un canvi substituim els ports per els nous ports canviats
cat nouPorts.txt > portsIp.txt

#Si hi ha hagut canvi ens avisa del canvi i ens permet conectar-nos al servidors per a executar commandes
if [[ $canvi == true ]]
then
	# aqui es on hi hauria d'haver el ssmtp avisant del canvi, no ho hem implementat per que no podem grabar-ho com caldría, si veiem que s'executa "./interroga" vol dir que hi ha hagut canvi i rebriam el correu que haguessim prefet en un altre arxiu .txt

	echo "Hi ha hagut un canvi, enviant correu a l'administrador"
	sleep 1

	# per a cada ip en l'arxiu dels ports creat en el pas anterior ho passarem com a argument al script interroga
	for ip in $(cat portsIp.txt | awk '{print $1}' | sort -u)
	do
		./interroga.sh $ip
	done
fi
