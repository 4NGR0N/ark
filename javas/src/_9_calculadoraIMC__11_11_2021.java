

import java.util.Scanner;

public class _9_calculadoraIMC__11_11_2021 {
    public static void main(String[] args) {
        double pes,alçada,imc;
        int edat;
        String nom;
        String  intent = "s";
        String punt_de_tall="";
        Scanner entrada = new Scanner(System.in);

        while( intent.equalsIgnoreCase("s")) {

            System.out.println("Dona'm el nom del pacient:");
            nom = entrada.nextLine();

            System.out.println("Dona'm la teva edat:");
            do{
                if(entrada.hasNextInt()){
                    edat=entrada.nextInt();
                    entrada.nextLine();
                    break;
                }else{
                    System.out.println("Dada erronea, dona'm una edat correcta (int):");
                    entrada.nextLine();
                }
            }while(true);

            System.out.println("Digue'm la teva alçada:");
            do{
                if(entrada.hasNextDouble()){
                    alçada=entrada.nextDouble();
                    entrada.nextLine();
                    break;
                }else{
                    System.out.println("Dada erronea, dona'm una alçada correcta (double):");
                    entrada.nextLine();
                }
            }while(true);

            System.out.println("Digue'm el teu pes:");
            do{
                if(entrada.hasNextDouble()){
                    pes=entrada.nextDouble();
                    entrada.nextLine();
                    break;
                }else{
                    System.out.println("Dada erronea, dona'm un pes correcte (double):");
                    entrada.nextLine();
                }
            }while(true);

            imc = pes / (alçada * alçada);

            if(imc<18){
                punt_de_tall="pes baix";
            }else if(imc<25) {
                punt_de_tall="pes adeqüat";
            }else if(imc<30){
                punt_de_tall="sobrepès";
            }else if(imc>=30){
                punt_de_tall="obesitat";
            }


            System.out.println(nom + " el teu IMC es: " + imc + "(" + punt_de_tall + ")");
            System.out.println("BBBBBBBBBBBBBBBBBBAAAAAAASSSSSOOOOOOOOOO");

            int index = (int)imc;

            for (int i = 0; i < index; i++) {
                System.out.print("*");
            }

            System.out.println("");

            if(edat<20 || edat>65){
                System.out.println("Ets fora de la edat de càlcul de l'IMC. Consulta les taules per a més seguretat.");
            }
            System.out.println("Vols calcular un altre pacient? [s/n]");
            intent=entrada.nextLine();
        }
        System.out.println("Adeu!");
    }
}
