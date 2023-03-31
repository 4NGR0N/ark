

import java.util.Scanner;

public class _15_exercici2_Strings__14_12_2021 {
    public static void main(String[] args) {
        //  2.  Escriu un programa per comptar el nombre de caràcters (freqüència de caràcters) en una cadena.
        //      Cadena de mostra: "google.com"
        //      Resultat esperat: {'g': 2, 'o': 3, 'l': 1, 'e': 1, '.': 1, 'c': 1, 'm': 1}

        Scanner entrada = new Scanner(System.in);

        // Entrem frase
        System.out.println("Entra un String:");
        String frase=entrada.nextLine();
        String textResultat = "{ ";
        // Programa
            for (int i = 0; i < frase.length(); i++) {
                char lletra = frase.charAt(i);
                int acc=0;
                if (i == frase.indexOf(lletra)) {
                    for (int j = i; j < frase.length(); j++) {
                        if (lletra == frase.charAt(j)) {
                            acc++;
                        }
                    }
                    // String.format("%2d x %2d",i,j) retorna una cadena del tipus: _1 x _1 on el simbol "_" es un espai que deixa el String.format. Deixa 2 espais abans dels $d.
                    textResultat +=String.format("'%c':%d, ",lletra,acc);
                }
            }
            //treiem la "," final amb el substring
            textResultat=textResultat.substring(0,textResultat.length()-3);
            textResultat +=" }";
            System.out.println(textResultat);
    }
}
