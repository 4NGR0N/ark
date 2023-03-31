

import java.util.Scanner;

public class A03_Correccio {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] pCurtes = new String[10],pLlargues = new String[10],pResta = new String[10];
        int iCurtes = 0, iLlargues = 0, iResta = 0;
        boolean acabar = false;
        while (!acabar) {
            System.out.println("Escriu una frase de mínim 200 caracter i 6 paraules");
            String frase = input.nextLine();
            String[] paraules = frase.split(" ");
            if (frase.length() >= 200 && paraules.length >= 6) {
                for (int i = 0; i < paraules.length; i++) {
                    if (paraules[i].length() < 3) {
                        pCurtes[iCurtes] = paraules[i];
                        iCurtes++;
                    } else if (paraules[i].length() > 6) {
                        pLlargues[iLlargues] = paraules[i];
                        iLlargues++;
                    } else {
                        pResta[iResta] = paraules[i];
                        iResta++;
                    }
                    if (iCurtes > 9 || iLlargues > 9 || iResta > 9) {
                        acabar = true;
                        break;
                    }
                }
            } else {
                System.out.println("La frase ha de contenir mínim 200 caràcters i 6 paraules");
            }
        }
        //mostrem el contingut el vector més ple
        if (iCurtes > iLlargues && iCurtes > iResta){
            System.out.println("El vector més ple es el de paraules curtes:");

            //ordenem array
            for (int i = 1; i < pCurtes.length; i++) {
                for (int j = 0; j < pCurtes.length - i; j++) {
                    if(pCurtes[j].length() > pCurtes[j+1].length()){
                        String aux = pCurtes[j];
                        pCurtes[j] = pCurtes[j+1];
                        pCurtes[j+1] = aux;
                    }
                }
            }

            //mostrem array
            for (int i = 0; i < pCurtes.length; i++) {
                System.out.print(pCurtes[i] + " ");
            }
        }else if (iLlargues > iCurtes && iLlargues > iResta){
            System.out.println("El vector més ple es el de paraules llargues");

            //ordenem array
            for (int i = 1; i < pLlargues.length; i++) {
                for (int j = 0; j < pLlargues.length - i; j++) {
                    if(pLlargues[j].length() > pLlargues[j+1].length()){
                        String aux = pLlargues[j];
                        pLlargues[j] = pLlargues[j+1];
                        pLlargues[j+1] = aux;
                    }
                }
            }

            for (int i = 0; i < pLlargues.length; i++) {
                System.out.print(pLlargues[i] + " ");
            }
        }else {
            System.out.println("El vector més ple es que no conté ni paraules curtes ni llargues:");

            //ordenem array
            for (int i = 1; i < pResta.length; i++) {
                for (int j = 0; j < pResta.length - i; j++) {
                    if(pResta[j].length() > pResta[j+1].length()){
                        String aux = pResta[j];
                        pResta[j] = pResta[j+1];
                        pResta[j+1] = aux;
                    }
                }
            }

            for (int i = 0; i < pResta.length; i++) {
                System.out.print(pResta[i] + " ");
            }
        }
    }
}
