

import java.util.Scanner;

public class _7_exercici_taules_multiplicar__4_11_2021 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int taula=-1, acabar=-1;
        while(taula<0 || taula>10) {
            System.out.println("Digue'm quina taula et vols saltar");
            taula = entrada.nextInt();
            entrada.nextLine();
        }
        while(acabar<0 || acabar>10) {
            System.out.println("Digue'm fins a quina taula vols arribar");
            acabar = entrada.nextInt();
            entrada.nextLine();
        }
        for (int i = 0; i <= 10; i++) {
            if(i==taula) {
                System.out.println("Ens saltem la taula del "+taula);
                continue;
            }else if(i==acabar+1){
                System.out.println("Parem a la taula del "+acabar);
                break;
            }else{
                for (int j = 0; j <= 10; j++) {
                    //hem de controlar la coma que va després del 10
                    if(j==10){
                        System.out.print(i +" X "+j+" = "+i*j);
                    } else {
                        System.out.print(i +" X "+j+" = "+i*j+" , ");
                    }
                }
            }
            System.out.println();
        }
    }
}
