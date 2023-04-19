#!/bin/bash

#Borrem les cadenes/regles que hi hagi

iptables -F

# Hacemos que la red 10.0.4.0/24 sea traducda por las tablas NAT i asi poder navegar

iptables -t nat -A POSTROUTING -s 10.0.4.0/24 -o enp0s3 -j MASQUERADE

# Politica de las cadenas por defecto

iptables -P INPUT DROP
iptables -P OUTPUT DROP
iptables -P FORWARD DROP

# Permet DNS

#iptables -A FORWARD -p udp --dport 53 -j ACCEPT
#iptables -A FORWARD -p tcp --dport 53 -j ACCEPT

# Pings al Firewall

iptables -A INPUT -i enp0s8 -p icmp --icmp-type echo-request -j ACCEPT
iptables -A OUTPUT -o enp0s8 -p icmp --icmp-type echo-reply -j ACCEPT

# Pings a Internet

iptables -A FORWARD -i enp0s8 -o enp0s3 -p icmp --icmp-type echo-request -j ACCEPT
iptables -A FORWARD -i enp0s3 -o enp0s8 -p icmp --icmp-type echo-reply -j ACCEPT

# El usuari pot navegar per internet

iptables -A FORWARD -i enp0s8 -o enp0s3 -p tcp -m multiport --dport 80,443 -j ACCEPT
iptables -A FORWARD -i enp0s8 -o enp0s3 -p udp --dport 53 -j ACCEPT

## Com que les conexions de tornada estan establertes, fem una altra regla per quant entra

iptables -A FORWARD -i enp0s3 -o enp0s8 -m state --state RELATED,ESTABLISHED -j ACCEPT
