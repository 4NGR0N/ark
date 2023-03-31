cat /dev/null > message.txt
echo -e "To:yautja@telefonica.net" > message.txt
echo -e "From:marc.salvador@gracia.lasalle.cat" >> message.txt
echo -e "Subject:Entrada como ROOT en `hostname` \n" >> message.txt
echo -e "ALERTA - Acceso a Terminal de Root en: `hostname` el: `date +'%Y/%m/%d'`
desde $terminal en IP: $ip" >> message.txt
ssmtp yautja@telefonica.net < message.txt