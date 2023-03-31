

import java.util.Scanner;

public class PracticaClasseCorregit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double GRAVETAT_TERRA = 9.807;
        String nomPlanetaMenysPes = "", nomPlanetaMesPes ="";
        double pesPlanetaMenysPes = Integer.MAX_VALUE, pesPlanetaMesPes= 0;
        int pesAstronauta = 0, nombrePlanetes = 0;

        //declaració d' array de Strings
        String[] nomPlanetes;
        double[] gravetatPlanetes;
        double[] pesosAstronautes;


        System.out.println("Introdueixi el pes de l' astronauta a la Terra:");
        do{
            if(input.hasNextInt()) {
                pesAstronauta = input.nextInt();
                input.nextLine();
                if(pesAstronauta <= 0){
                    System.out.println("Introdueix un valor positiu!");
                    continue;
                }
                break;
            }else
            {
                System.out.println("Dada no vàlida, escriu un enter.");
                input.nextLine();
            }
        }while(true);

        System.out.println("En quants planetes desitges calcular-ne el pes?");
        do{
            if(input.hasNextInt()) {
                nombrePlanetes = input.nextInt();
                input.nextLine();
                if(nombrePlanetes < 2){
                    System.out.println("Introdueix un valor positiu (minim 2)!");
                    continue;
                }
                break;
            }else
            {
                System.out.println("Dada no vàlida, escriu un enter.");
                input.nextLine();
            }
        }while(true);

        // Inicialització d' arrays
        nomPlanetes = new String[nombrePlanetes];
        gravetatPlanetes = new double[nombrePlanetes];
        pesosAstronautes = new double[nombrePlanetes];

        for (int i = 0; i < nombrePlanetes; i++) {
            double gravetatPlaneta = 0.0;
            System.out.println("Introdueixi el nom del planeta "+(i+1) +":");
            String nomPlaneta = input.nextLine();
            System.out.println("Introdueixi la gravetat en el planeta " + nomPlaneta);

            do{
                if(input.hasNextDouble()) {
                    gravetatPlaneta = input.nextDouble();
                    input.nextLine();
                    if(gravetatPlaneta <=0){
                        System.out.println("Introdueix un valor positiu");
                        continue;
                    }
                    break;
                }else
                {
                    System.out.println("Dada no vàlida, escriu un numero.");
                    input.nextLine();
                }
            }while(true);

            double pesAstronautaNouPlaneta = pesAstronauta/GRAVETAT_TERRA * gravetatPlaneta;
            System.out.printf("El pes del astronauta a %s és de %.3f kg.",nomPlaneta,pesAstronautaNouPlaneta);
            double diferenciaPes = (pesAstronautaNouPlaneta - pesAstronauta);
            if(diferenciaPes < -15){
                System.out.println(" Posa' t pedres a les butxaques!\n");
            }else if(diferenciaPes > 15){
                System.out.println(" Agafa un globus d'heli!\n");
            }else{
                System.out.println("\n");
            }

            //Comparem el pes en el nou planeta amb els registres que tenim de planetes (max pes i min pes)
            if(pesAstronautaNouPlaneta < pesPlanetaMenysPes){
                pesPlanetaMenysPes = pesAstronautaNouPlaneta;
                nomPlanetaMenysPes = nomPlaneta;
            }
            if(pesAstronautaNouPlaneta > pesPlanetaMesPes){
                pesPlanetaMesPes = pesAstronautaNouPlaneta;
                nomPlanetaMesPes = nomPlaneta;
            }

            // Poem les dades als arrays
            nomPlanetes[i] = nomPlaneta;
            gravetatPlanetes[i] = gravetatPlaneta;
            pesosAstronautes[i] = pesAstronautaNouPlaneta;
        }
        //Mostrem planeta amb menys i més pes
        System.out.printf("Si vas a %s no et cansaràs, si vas a %s no et podràs moure",nomPlanetaMenysPes,nomPlanetaMesPes);

        for (int i = 0; i < nombrePlanetes; i++) {
            System.out.println("\n" + nomPlanetes[i] + " " + gravetatPlanetes[i] + " " + pesosAstronautes[i]);
        }
    }
}