#!/usr/bin/python3

import sys
import socket
import threading

puerto_final = sys.argv[1]
ip_lectura = sys.argv[2]
last = input("Introduce el ultimo valor de la ultima ip que quieres ver: ")
cadena = ip_lectura.split(".")


def escaneo_puerto(ip):
    try:
        for contador in range(19, int(puerto_final)):
            print("Current Threat: " + threading.currentThread().getName())
            puerto = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
            puerto.settimeout(5000)
            conexion = puerto.connect_ex((ip,contador))
            if conexion == 0:
                print("IP:" + str(ip) + " Puerto:" + str(contador) + "  --> ABIERTO.")
            puerto.close
    except:
        print("Escriu el nom del script junto con el puerto y la ip: <nombre.py> PuertoFinal IP")

ip_actual = cadena[0] + "." + cadena[1] + "." + cadena[2] + "."

for cont in range(int(cadena[3]),int(last)+1):
    ip_result = ip_actual + str(cont)
    #escaneo_puerto(ip_result)
    hilo = threading.Thread(target=escaneo_puerto, args=(ip_result,))
    hilo.start()