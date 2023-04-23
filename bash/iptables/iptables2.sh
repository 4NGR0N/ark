#Alguns flags:
# -A : ADD
# -i : interface de entrada
# -o : interface de sortida
#

# XARXES

WAN=enp0s3
LAN=enp0s8
DMZ=enp0s9

#Per habilitar l'enrutament es trova a /etc/sysctl.conf
#Despres, sysctl -p

#Borrem totes les regles que hi hagi

iptables -F

# Fem les traduccions NAT

iptables -t nat -A POSTROUTING -s 10.0.0.0/16 -o $WAN -j MASQUERADE

#Obrim els ports
#DNAT -- destination NAT

iptables -t nat -A PREROUTING -p tcp --dport 443 -i $WAN -j DNAT --to 10.0.5.2:443
iptables -t nat -A PREROUTING -p tcp --dport 80 -i $WAN -j DNAT --to 10.0.5.2:80

#Treiem totes les regles anteriors per fer unes noves

iptables -P INPUT DROP
iptables -P OUTPUT DROP
iptables -P FORWARD DROP

#REGLES DE FILTRAT
#A les regles de FORWARD hauriem de poder posar la -i i la -o

#Firewall fa ping a totes les interficies

iptables -A OUTPUT -p icmp --icmp-type echo-request -j ACCEPT
iptables -A INPUT -p icmp --icmp-type echo-reply -j ACCEPT

#FIREWALL pot instalar software

iptables -A OUTPUT -o $WAN -p tcp -m multiport --dport 80,443 -j ACCEPT
iptables -A OUTPUT -o $WAN -p udp --dport 53 -j ACCEPT
iptables -A INPUT -i $WAN -m state --state RELATED,ESTABLISHED -j ACCEPT

# LAN pot fer ping a internet
iptables -A FORWARD -p icmp --icmp-type echo-request -i $LAN -o $WAN -j ACCEPT
iptables -A FORWARD -p icmp --icmp-type echo-reply -i $WAN -o $LAN -j ACCEPT

# LAN pot navegar i fer DNS
iptables -A FORWARD -i $LAN -o $WAN -p tcp -m multiport --dport http,https,ftp,imap,pop3,smtp -j ACCEPT
iptables -A FORWARD -i $LAN -o $WAN -p udp --dport 53 -j ACCEPT
iptables -A FORWARD -i $WAN -o $LAN -m state --state RELATED,ESTABLISHED -j ACCEPT

#Client pot veure servidor web (LAN a DMZ)
iptables -A FORWARD -i $LAN -o $DMZ -p tcp -m multiport --dport http,https -j ACCEPT
iptables -A FORWARD -i $DMZ -o $LAN -m state --state RELATED,ESTABLISHED -j ACCEPT
iptables -A FORWARD -i $WAN -o $DMZ -p tcp -m multiport --dport http,https -j ACCEPT
iptables -A FORWARD -i $DMZ -o $WAN -m state --state RELATED,ESTABLISHED -j ACCEPT

