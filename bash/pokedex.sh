#!/bin/bash
clear
rm info_pokedex*
cat /dev/null > imagenes.txt
cat /dev/null > totjunt.txt
cat /dev/null > pokemons.html

echo "Dime que pokemons quieres:"
echo "a) Pokemons estaticos"
echo "b) Pokemons en movimiento"
echo "c) Todos los Pokemons (estaticos y en movimiento"
read opcion

if [ $opcion == a ]
then
	wget www.pokeyplay.com/info_pokedex.php			#Busquem la pàgina "info_pokedex.php"
	cat info_pokedex.php >> totjunt.txt			#Aqui posem el contingut de la primera pagina a "totjunt.txt"
	for i in `seq 2 8`
	do
		wget www.pokeyplay.com/info_pokedex$i.php	#Busquem les pàgines restants, (1..8)
		cat info_pokedex$i.php >> totjunt.txt		#Aqui posem la resta de pàgines (1...8) a l' arxiu "totjunt.txt"
	done

	cat totjunt.txt | grep -w '<img src="http://urpgstatic.com/img_library/pokemon_sprites' | awk -F "<" '{print $3}' | awk -F "style" '{print $1}' > imagenes.txt

	echo "<!DOCTYPE html>" >> pokemons.html
	echo "<html>" >> pokemons.html
	echo "<body>" >> pokemons.html
	echo "<h2>Pókedex</h2>" >> pokemons.html

	while read linia
	do
		echo "<$linia>" >> pokemons.html
	done < imagenes.txt

	echo "</body" >> pokemons.html
	echo "</html>" >> pokemons.html

	firefox pokemons.html
fi

if [ $opcion == b ]
then
        wget www.pokeyplay.com/info_pokedex.php                 #Busquem la pàgina "info_pokedex.php"
        cat info_pokedex.php >> totjunt.txt                     #Aqui posem el contingut de la primera pagina a "totjunt.txt"
        for i in 9
        do
                wget www.pokeyplay.com/info_pokedex$i.php       #Busquem les pàgines restants, (1..8)
                cat info_pokedex$i.php >> totjunt.txt           #Aqui posem la resta de pàgines (1...8) a l' arxiu "totjunt.txt"
        done

        cat totjunt.txt | grep -w '<img src="http://urpgstatic.com/img_library/pokemon_sprites_animated' | awk -F "<" '{print $3}' | awk -F "style" '{print $1}' > imagenes.txt

        echo "<!DOCTYPE html>" >> pokemons.html
        echo "<html>" >> pokemons.html
        echo "<body>" >> pokemons.html
        echo "<h2>Pókedex</h2>" >> pokemons.html

        while read linia
        do
                echo "<$linia>" >> pokemons.html
        done < imagenes.txt

        echo "</body" >> pokemons.html
        echo "</html>" >> pokemons.html

        firefox pokemons.html
fi

if [ $opcion == c ]
then
        wget www.pokeyplay.com/info_pokedex.php                 #Busquem la pàgina "info_pokedex.php"
        cat info_pokedex.php >> totjunt.txt                     #Aqui posem el contingut de la primera pagina a "totjunt.txt"
        for i in `seq 2 9`
        do
                wget www.pokeyplay.com/info_pokedex$i.php       #Busquem les pàgines restants, (2..8)
                cat info_pokedex$i.php >> totjunt.txt           #Aqui posem la resta de pàgines (2..8) a l' arxiu "totjunt.txt"
        done

        cat totjunt.txt | grep -w '<img src="http://urpgstatic.com/img_library/pokemon_sprites' | awk -F "<" '{print $3}' | awk -F "style" '{print $1}' > imagenes.txt
	cat totjunt.txt | grep -w '<img src="http://urpgstatic.com/img_library/pokemon_sprites_animated' | awk -F "<" '{print $3}' | awk -F "style" '{print $1}' >> imagenes.txt

        echo "<!DOCTYPE html>" >> pokemons.html
        echo "<html>" >> pokemons.html
        echo "<body>" >> pokemons.html
        echo "<h2>Pókedex</h2>" >> pokemons.html

        while read linia
        do
                echo "<$linia>" >> pokemons.html
        done < imagenes.txt

        echo "</body" >> pokemons.html
        echo "</html>" >> pokemons.html

        firefox pokemons.html
fi
