#!/bin/bash

#Això es un comentari

#EXEMPLE DEFINICIÓ VARIABLES
echo "### EXEMPLE 1 definició de variables ###"
nomvariable=22
echo nomvariable #mostra nomvariable
echo $nomvariable #mostra 22
echo '$nomvariable' #mostra $variable a causa de les ' '
echo "$nomvariable" #mostra 22
echo "Variable no definida: $variablenodefinida" #No mostra res
echo "### FI EXEMPLE 1 ###"
echo -e "\n"

#EXEMPLE NUMERIC
echo "### EXEMPLE 2 JUGUEM AMB NÚMEROS ###"
v=1337 #defineixo un valor
z=$v #copio el CONTINGUT ($)n de v a la z
echo $z
z=$[1228 + 1] #realització suma
echo $z
z=$[1228 - 10] #realització resta
echo $z
echo "### FI EXEMPLE 2 ###"
echo -e "\n"

#EXEMPLE READ i SUMA
echo "### EXEMPLE 3 READ i SUMA ###"
echo "Entra el 1r valor"
read valor1
echo "Entra 2n valor"
read valor2
suma=$[valor1 + valor2]
echo "Resultat de la suma:  $suma"
echo "### FI EXEMPLE 3 ###"
echo -e "\n"

#EXEMPLE \n i \t
echo "### EXEMPLE 4 \n i \t ###"
echo -e  "Fare un salt \n de linea"
echo -e "Ara tabulo \t tabulo"
echo "Cal afegir -e perque tot funcioni"
echo "### FI EXEMPLE 4 ###"
echo -e "\n"


#EXEMPLE read i locate
echo "### EXEMPLE 5 read i locate ###"
echo "Quin fitxer vols buscar?"
read fitxerbusqueda
sudo updatedb #actualitzo BBDD del locate
echo "Vols buscar: $fitxerbusqueda"
locate $fitxerbusqueda #busco el fitxer 
echo "### FI EXEMPLE 5 ###"
echo -e "\n"

#EXEMPLE read i locate
echo "### EXEMPLE 6 ###"
rm fileroute2 #borro el fitxer si ja existia (execuxió previa de lescript)
rm fileroute
touch fileroute2 #creo fitxer de nou
touch fileroute	
echo "Guardo taula de rutes"
netstat -r > fileroute #Guardo taula rutes actual al fitxer fileroute
echo "Entra destí"
read ip
echo "Entra mask"
read mask
echo "Entra gateway atencio!!! ha de ser valid sino ERROR"
read gate
#Pregunto (read) a l'usuari per tot el necessari
sudo route add -net $ip netmask $mask gw $gate #introdueixo nova ruta
echo "Ruta introduida"
netstat -r > fileroute2 #torno a guardar el contingut de la taula de rutes a un altre fitxer
echo -e "\n"
echo -e "Diferencia entre fitxers:"
diff fileroute fileroute2 #consulto les diferencies entre fitxers
sudo route del -net $ip netmask $mask gw $gate #esborro la ruta que he afegir per no deixar brossa a la taula :)
echo "### FI EXEMPLE 6 ###"
echo -e "\n"















