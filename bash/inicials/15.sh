#Podem afegir dins de bashrc i dins de bash_logout un redireccionament creant un arxiu, com aquests arxius s’executen al loguejar (bashrc) i al logout (bash_logout) aquests guardaran els “logs”
#En bashrc:
echo $(whoami) s’ha loguejat $(date)
#En bash_logout:
echo $(whoami) s’ha desloguejat $(date)