

import java.util.Scanner;

public class _15_exemple_inputs__14_12_2021 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] valors = new String[5];
        for (int i = 0; i < 5; i++) {
            valors[i]=input.next();             //Només agafa elprimer valor del que escriguis.
            //valors[i]=input.nextLine();       //Agafa tot el que li posis.
        }
    }
}
