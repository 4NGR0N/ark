#!/usr/bin/python3

#Importem les llibreries de sistema, sockets i threadings respectivament.
import sys
import socket
import threading


#captura de flags del script
ipInicial=sys.argv[1]
ipFinal=sys.argv[2]
portLimit=sys.argv[3]

#separació de l'ultim bloc de les IP's donades
ipInicial_array=ipInicial.split(".")
ipFinal_array=ipFinal.split(".")
ipStart_cut=ipInicial_array[3]
ipEnd_cut=ipFinal_array[3]

#Definim una funció que recorre un set de ports PER A UNA IP, on el port indicat per l'usuari (portLimit) es l'últim.
def scan_ports(ip):
    try:
        for acc in range(1, int(portLimit)):
            puerto = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
            puerto.settimeout(5000)
            conexion = puerto.connect_ex((ip,acc))
            if conexion == 0:
                print("PORT:"+str(acc)+" OPEN! on IP: "+str(ip))
            #else:
                #print("PORT:"+str(acc)+" CLOSE? on IP: "+str(ip))
            puerto.close()
    except:
        print("Usage: analiza <ip_start> <ip_end> <portLimit>")
#Ara anem enviant a la funció abans definida varies IP's, compreses entre el limit introduït per l'usuari (IpInicial->IpFinal), alhora cadascun dels escanejos es farà en un 'fil' de la CPU diferent, enviant la execució de la funció principal (scanPorts) a un 'thread' cada cop.
for acc2 in range(int(ipStart_cut),int(ipEnd_cut)):
    ipCompleta = ipInicial_array[0]+"."+ipInicial_array[1]+"."+ipInicial_array[2]+"."+str(acc2)
    hilo = threading.Thread(target=scan_ports, args=(ipCompleta,))
    hilo.start()
