
/*
11. Crea un algoritme que decideixi si un alumne aprova o suspèn l’assignatura de
programació sabent que per aprovar, ha d’obtenir un 5 de mitjana entre les notes
dels següents elements avaluables:
a. Exercicis entregables
b. POUs avaluables
c. Examen final
d. Pràctica final
Demana a l’usuari que insereixi les 4 notes i que comprovi si l’alumne aprova o no.
Mostra el resultat d’aprovat o no aprovat per pantalla
Extra: Calcula la nota real de la UF1 segons el PIC usant els percentatges
corresponents.
 */

import java.util.Scanner;



public class _3_exercici_11__21_10_2021 {
    public static void main(String[] args) {

        double exercicis,POU,examen,practica,mitjana;
        Scanner input = new Scanner(System.in);
        System.out.println("Dona'm la nota mitja dels exercicis:");
        exercicis = input.nextDouble();
        input.nextLine();
        System.out.println("Dona'm la nota mitja dels POU:");
        POU = input.nextDouble();
        input.nextLine();
        System.out.println("Dona'm la nota mitja de la Pràctica:");
        practica = input.nextDouble();
        input.nextLine();
        System.out.println("Dona'm la nota mitja del Exàmen:");
        examen = input.nextDouble();
        input.nextLine();
        mitjana = exercicis*0.1+POU*0.2+practica*0.3+examen*0.4;
        if(mitjana<5){
            System.out.println("Estas suspès amb una nota mitja de: "+mitjana);
        }else if (mitjana<7){
            System.out.println("Estàs aprovat amb un bé, amb una nota mitja de: "+mitjana);
        }else if (mitjana<9) {
            System.out.println("Estàs aprovat amb un notable, amb una nota mitja de: " + mitjana);
        }else{
            System.out.println("Estàs aprovat amb un excel.lent, amb una nota mitja de: " + mitjana);
        }
    }
}
