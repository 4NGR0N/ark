#!/bin/bash
#Fes un script que ens doni la hora escrita segons el següent format: “dotze hores i vint-i-tres minuts”

hora=$(date | awk '{print $4}' | awk -F ":" '{print $1}')
minuts=$(date | awk '{print $4}' | awk -F ":" '{print $2}')
hori=$(cat nums.txt | awk -v lhora=$hora '{print $lhora}')
mini=$(cat nums.txt | awk -v lmini=$minuts '{print $lmini}')

if [[ $mini = 0 ]] 
then
    echo "son les $hori en punt"
fi
echo "son les $hori i $mini"