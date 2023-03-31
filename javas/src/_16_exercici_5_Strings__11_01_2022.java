

import java.util.Scanner;

public class _16_exercici_5_Strings__11_01_2022 {
    public static void main(String[] args) {

        /*
         * 5. Escriviu un programa que agafi un vector de paraules i ens digui quina és la més llarga i quina longitud té.
         * */

        Scanner input = new Scanner(System.in);
        String [] matriu = new String[5];
        String paraulaMesLlarga = "";
        String paraulaInversa = "";

        System.out.println("Escriu 5 paraules");
        for (int i = 0; i < matriu.length; i++) {
            matriu[i] = input.nextLine();
            if(matriu[i].length()>paraulaMesLlarga.length()){
                paraulaMesLlarga=matriu[i];
            }
        }

        System.out.println("La paraula més llarga és: " + paraulaMesLlarga );

        //Reverse
        for (int i = paraulaMesLlarga.length(); i < 0 ; i--) {
        
        }
    }
}
