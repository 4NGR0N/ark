

import java.util.Scanner;

/* El Departament d’Ensenyament de la Generalitat vol saber el percentatge nois i noies
que hi ha a les aules. Dissenya un algoritme que pregunti quantes noies i nois hi ha a
l’aula i aleshores en mostri els percentatges. */

public class _2_exercici_4__19_10_2021 {
    public static void main(String[] args) {

        int nombreNois,nombreNoies;
        // Demanar nombre de nois de la classe

        Scanner input = new Scanner(System.in);
        System.out.println("Digue'm el nombre de nois:");
        nombreNois = input.nextInt();
        input.nextLine();

        // Demanar nombre de noies de la classe

        System.out.println("Diguem el nombre de noies:");
        nombreNoies = input.nextInt();
        input.nextLine();

        // Calcular els percentatges

        int total = nombreNoies + nombreNois;
        int percentatgeNois = nombreNois*100/total;
        int percentatgeNoies = nombreNoies*100/total;

        //Treure el resultat per pantalla

        System.out.println("El percentatge de nois es: "+percentatgeNois+"% i el percentatge de noies es: "+percentatgeNoies+"%.");

    }

}
