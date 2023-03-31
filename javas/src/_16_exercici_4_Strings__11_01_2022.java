

import java.util.Scanner;

public class _16_exercici_4_Strings__11_01_2022 {
    public static void main(String[] args) {
        //4. Escriviu un programa per afegir 'ing' al final d'una cadena determinada (la longitud ha de ser com a mínim 3). Si la cadena donada ja acaba amb 'ing', afegiu 'ly' al seu lloc. Si la longitud de la cadena donada és inferior a 3, deixeu-la sense canvis.
        // Cadena de mostra: "abc"
        // Resultat esperat: "abcing"
        // Cadena de mostra: "string"
        // Resultat esperat: "stringly"

        //Variables
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println("Escriu una paraula de minim 3 lletres");
            String paraula = input.nextLine();
            if(paraula.length() > 2) {
                if (paraula.endsWith("ing")) {
                    paraula = paraula + "ly";
                } else {
                    paraula = paraula + "ing";
                }
            }
            System.out.println(paraula);
        }



    }
}
