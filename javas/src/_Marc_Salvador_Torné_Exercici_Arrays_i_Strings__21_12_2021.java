

import java.util.Scanner;

public class _Marc_Salvador_Torné_Exercici_Arrays_i_Strings__21_12_2021 {
    public static void main(String[] args) {
        // Fes una aplicació que demani de forma repetida frases per consola d’una longitud no inferior a 200 caràcters, que continguin com a mínim 6 paraules.
        //
        //Distribueix les paraules de cada frase en 3 vectors, han de tenir una capacitat de 10 paraules cada un:
        //
        //Paraules curtes ( De 3 o menys lletres)
        //Paraules llargues (De 7 o més lletres)
        //Resta de paraules..
        //Segueix demanant frases fins que un dels vectors estigui ple, no n’hi càpiguen més paraules.
        //
        //Finalment mostra el contingut del vector més ple amb les paraules ordenades de mes curta a més llarga.

        Scanner entrada = new Scanner(System.in);
        String [] llargues = new String[10];
        String [] mitges = new String[10];
        String [] curtes = new String[10];
        int indexLlargues = 0;
        int indexMitges = 0;
        int indexCurtes = 0;

        while (indexCurtes<=9 && indexMitges<=9 && indexLlargues<=9) {

            // Demanem frase
            System.out.println("Entra una frase de 200 o més caràcters, amb un mínim de 6 paraules");
            String frase = entrada.nextLine();
            String[] paraules = frase.split(" ");

            // Processem arrays
            if (frase.length() >= 200 && paraules.length >= 6) {
                System.out.println("Enhorabona, hi ha " + frase.length() + " lletres i hi ha " + paraules.length + " paraules");
                for (int i = 0; i < paraules.length; i++) {
                    if (paraules[i].length() <= 3 && indexCurtes <= 9) {
                        curtes[indexCurtes] = paraules[i];
                        indexCurtes++;
                    } else if (paraules[i].length() >= 7 && indexLlargues <= 9) {
                        llargues[indexLlargues] = paraules[i];
                        indexLlargues++;
                    } else {
                        if (indexMitges <= 9) {
                            mitges[indexMitges] = paraules[i];
                            indexMitges++;
                        }
                    }
                }
            } else {
                System.out.println("La frase no és prou llarga. Escriu una frase de com a minim 200 caràcters i 6 paraules");
            }
        }

            //Sortida per pantalla
            System.out.println();
            if(indexCurtes>=9){
                System.out.print("Curtes:  ");
                System.out.print("{ ");
                for (int i = 0; i < curtes.length; i++) {
                    System.out.print(curtes[i]+" , ");
                }
                System.out.print(" }");
                System.out.println();
            }
            if(indexMitges>=9){
                System.out.print("Mitges:  ");
                System.out.print("{ ");
                for (int i = 0; i < mitges.length; i++) {
                    System.out.print(mitges[i]+" , ");
                }
                System.out.print(" }");
                System.out.println();
            }
            if(indexLlargues>=9){
                System.out.print("Llargues:  ");
                System.out.print("{ ");
                for (int i = 0; i < llargues.length; i++) {
                    System.out.print(llargues[i]+" , ");
                }
                System.out.print(" }");
                System.out.println();
            }
        }
    }
