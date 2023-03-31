

import java.util.Scanner;

public class _15_exercici3_Strings__14_12_2021 {
    public static void main(String[] args) {
        //  3. Escriu un programa per obtenir una cadena formada pels primers 2 i els darrers 2 caràcters d'una cadena donada. Si la longitud de
        //  la cadena és inferior a 2, torneu una cadena buida.
        //  Cadena de mostra: "w3resource" Resultat esperat: 'w3ce'
        //  Cadena de mostra: "w3"
        //  Resultat esperat: 'w3w3'
        //  Cadena de mostra: "w" Resultat esperat: cadena buida

        Scanner entrada = new Scanner(System.in);
        System.out.println("Dona'm una frase o paraula: ");
        String frase = entrada.nextLine();
        if (frase.length()<2) {
            String fraseResultat = frase.substring(0, 2);
            System.out.println(fraseResultat);
            fraseResultat = fraseResultat + frase.substring(frase.length() - 2, frase.length() - 1);
            System.out.println(fraseResultat);
        }
        System.out.println("Adeu!");
    }
}
