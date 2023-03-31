

import java.util.Scanner;

public class Marc_Salvador_Torné {
    public static void main(String[] args) {

        double pes_astronauta,gravetat_planeta,pes_final,diferencia_pes,pes_mes_alt,pes_mes_baix,pes_anterior;
        double gravetat_Terra;
        gravetat_Terra=9.807;
        String nom_planeta,frase_final,planeta_mes_pesat,planeta_menys_pesat,nom_anterior;
        Scanner entrada = new Scanner(System.in);
        Integer num_planetes;

        pes_mes_baix = Integer.MAX_VALUE; /* Valor més alt representable */
        planeta_menys_pesat="";
        pes_mes_alt = 0;
        planeta_mes_pesat ="";

        System.out.println("Quants pesos/planetes vols calcular?");

        do{
            if(entrada.hasNextInt()){
                num_planetes=entrada.nextInt();
                if(num_planetes>0) {
                    entrada.nextLine();
                    break;
                }else{
                    entrada.nextLine();
                    System.out.println("Entra un numero positiu, si us plau:");
                }
            }else{
                System.out.println("Dada erronea, dona'm un numero correcte:");
                entrada.nextLine();
            }
        }while(true);

        for (int i = 1; i <= num_planetes ; i++) {

            System.out.println("Dona'm el pes de l'astronauta a la Terra (en Kg):");
            do{
                if(entrada.hasNextDouble()){
                    pes_astronauta=entrada.nextDouble();
                    if(pes_astronauta>0) {
                        entrada.nextLine();
                        break;
                    }else{
                        entrada.nextLine();
                        System.out.println("Entra un pes positiu, si us plau:");
                    }
                }else{
                    System.out.println("Dada erronea, dona'm un pes correcte (amb decimals):");
                    entrada.nextLine();
                }
            }while(true);

            System.out.println("Dona'm el nom del planeta num."+i+":");
            nom_planeta = entrada.nextLine();

            System.out.println("Dona'm la gravetat del planeta "+nom_planeta+":");
            do{
                if(entrada.hasNextDouble()){
                    gravetat_planeta=entrada.nextDouble();
                    if(gravetat_planeta>0) {
                        entrada.nextLine();
                        break;
                    }else{
                        entrada.nextLine();
                        System.out.println("Entra una gravetat positiva, si us plau:");
                    }
                }else{
                    System.out.println("Dada erronea, dona'm una gravetat correcta (decimal):");
                    entrada.nextLine();
                }
            }while(true);

            pes_final = pes_astronauta / gravetat_Terra * gravetat_planeta;
            diferencia_pes = pes_final - pes_astronauta;

            if(pes_final>pes_mes_alt){
                planeta_mes_pesat=nom_planeta;
                pes_mes_alt=pes_final;
            }

            if(pes_final<pes_mes_baix){
                planeta_menys_pesat=nom_planeta;
                pes_mes_baix=pes_final;
            }

            frase_final="";

            if(diferencia_pes<-15){
                frase_final ="Posa't pedres a les butxaques!\n";
            } else if(diferencia_pes>15){
                frase_final = "Agafa un globus d'heli!\n";
            }

            System.out.println("El pes de l'astronauta a "+nom_planeta+" és de: "+pes_final+". "+frase_final);
        }
        System.out.println("Si vas a "+planeta_menys_pesat+" no et cansaràs.Si vas a "+planeta_mes_pesat+" no et podrás moure");
        System.out.println("Gracies per confiar en la NASA");
    }
}
