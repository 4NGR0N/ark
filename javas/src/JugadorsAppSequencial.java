
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JugadorsAppSequencial {

    public static void main(String[] args) throws InterruptedException {
        String[][] jugadors = new String[10][4];
        String[] header = {"NOM", "CLUB", "DORSAL", "GOLS"};
        Scanner input = new Scanner(System.in);
        int opcio = 0;
        boolean valid = false;
        boolean sortir = false;

        //introduim uns quants jugadors
        jugadors[0][0] = "Leo Messi";
        jugadors[0][1] = "FCB";
        jugadors[0][2] = "10";
        jugadors[0][3] = "30";

        jugadors[1][0] = "Benzema";
        jugadors[1][1] = "RMCF";
        jugadors[1][2] = "9";
        jugadors[1][3] = "29";

        jugadors[2][0] = "Luis Suarez";
        jugadors[2][1] = "AT Madrid";
        jugadors[2][2] = "9";
        jugadors[2][3] = "25";

        jugadors[3][0] = "Neymar";
        jugadors[3][1] = "PSG";
        jugadors[3][2] = "11";
        jugadors[3][3] = "35";


        while (!sortir) {
            do {
                System.out.println("Benvingut a la BBDD de jugadors.\nQuina operació vol realitzar");
                System.out.println("1 - Alta jugador");
                System.out.println("2 - Mostrar Jugadors");
                System.out.println("3 - Buscar jugadors");
                System.out.println("4 - Esdistiques");
                System.out.println("5 - Sortir");

                if (input.hasNextInt()) {
                    opcio = input.nextInt();
                    input.nextLine();
                    if (opcio > 0 && opcio < 6) {
                        valid = true;
                    }
                } else {
                    input.nextLine();
                }
            } while (!valid);

            switch (opcio) {
                case 1://alta jugador
                    int insertIndex = 0;
                    while (jugadors[insertIndex][0] != null && insertIndex < jugadors.length - 1) {
                        insertIndex++;
                    }
                    if (insertIndex == jugadors.length - 1) {
                        System.out.println("No hi ha lloc per enmagatzemar més jugadors.");
                    } else {
                        System.out.println("-----Alta jugador------");
                        System.out.println("Nom del jugador:");
                        jugadors[insertIndex][0] = input.nextLine();
                        System.out.println("Nom del club:");
                        jugadors[insertIndex][1] = input.nextLine();
                        int dorsal = 0;
                        do {
                            System.out.println("Dorsal:");
                            if (input.hasNextInt()) {
                                dorsal = input.nextInt();
                                input.nextLine();
                                if (dorsal > 0 && dorsal < 100) {
                                    valid = true;
                                }
                            } else {
                                input.nextLine();
                            }
                        } while (!valid);
                        jugadors[insertIndex][2] = String.valueOf(dorsal);
                        int gols = 0;
                        do {
                            System.out.println("Gols:");
                            if (input.hasNextInt()) {
                                gols = input.nextInt();
                                input.nextLine();
                                if (gols > 0 && gols < 100) {
                                    valid = true;
                                }
                            } else {
                                input.nextLine();
                            }
                        } while (!valid);
                        jugadors[insertIndex][3] = String.valueOf(gols);
                    }
                    break;
                case 2: //mostrar jugadors
                    for (int i = 0; i < header.length; i++) {
                        System.out.print(String.format("%1$15s", header[i]));
                    }
                    System.out.println();
                    for (int i = 0; i < jugadors.length; i++) {
                        if (jugadors[i][0] != null) {
                            for (int j = 0; j < jugadors[i].length; j++) {
                                System.out.print(String.format("%1$15s", jugadors[i][j]));
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 3: //Buscar jugador
                    int opcioSubmenu = 0;
                    do {
                        do {
                            System.out.println("Escull com cercar:");
                            System.out.println("1-Cercar per NOM");
                            System.out.println("2-Cercar per CLUB");
                            System.out.println("3-Cercar per DORSAL");
                            System.out.println("4-tornar enrere");
                            if (input.hasNextInt()) {
                                opcioSubmenu = input.nextInt();
                                input.nextLine();
                                if (opcioSubmenu > 0 && opcioSubmenu < 4) {
                                    valid = true;
                                }
                            } else {
                                input.nextLine();
                            }
                        } while (!valid);
                        switch (opcioSubmenu) {
                            case 1: {
                                System.out.println("Escriu el NOM a cercar:");
                                String cadenaCercar = input.nextLine();
                                for (int i = 0; i < header.length; i++) {
                                    System.out.print(String.format("%1$15s", header[i]));
                                }
                                System.out.println();
                                for (int i = 0; i < jugadors.length; i++) {
                                    if (jugadors[i][0] != null && jugadors[i][0].toLowerCase().contains(cadenaCercar.toLowerCase())) {
                                        for (int j = 0; j < jugadors[i].length; j++) {
                                            System.out.print(String.format("%1$15s", jugadors[i][j]));
                                        }
                                        System.out.println();
                                    }
                                }
                                opcioSubmenu = 4;
                                break;
                            }
                            case 2: {
                                System.out.println("Escriu el CLUB a cercar:");
                                String cadenaCercar = input.nextLine();
                                for (int i = 0; i < header.length; i++) {
                                    System.out.print(String.format("%1$15s", header[i]));
                                }
                                System.out.println();
                                for (int i = 0; i < jugadors.length; i++) {
                                    if (jugadors[i][0] != null && jugadors[i][1].toLowerCase().contains(cadenaCercar.toLowerCase())) {
                                        for (int j = 0; j < jugadors[i].length; j++) {
                                            System.out.print(String.format("%1$15s", jugadors[i][j]));
                                        }
                                        System.out.println();
                                    }
                                }
                                opcioSubmenu = 4; //posem opcioSubmenu a 3 per sortir al menu superior
                                break;
                            }
                            case 3: {
                                System.out.println("Escriu el DORSAL a cercar:");
                                String cadenaCercar = input.nextLine();
                                for (int i = 0; i < header.length; i++) {
                                    System.out.print(String.format("%1$15s", header[i]));
                                }
                                System.out.println();
                                for (int i = 0; i < jugadors.length; i++) {
                                    if (jugadors[i][0] != null && jugadors[i][2].equals(cadenaCercar)) {
                                        for (int j = 0; j < jugadors[i].length; j++) {
                                            System.out.print(String.format("%1$15s", jugadors[i][j]));
                                        }
                                        System.out.println();
                                    }
                                }
                                opcioSubmenu = 4;
                                break;
                            }
                        }
                        System.out.println();
                    } while (opcioSubmenu != 4);
                    break;
                case 4:
                    //jugador amb més gols, jugador amb menys gols i mitjana de gols
                    String jugadorAmbMesGols = "";
                    int golsJugadorAmbMesGols = 0;
                    String jugadorAmbMenysGols = "";
                    int golsJugadorAmbMenysGols = 10000;
                    int mitjanaGols = 0;
                    int totalGols = 0;
                    int totalJugadors = 0;
                    for (int i = 0; i < jugadors.length; i++) {
                        if (jugadors[i][0] != null) {
                            int golsdJugadorActual = Integer.parseInt(jugadors[i][3]);
                            if (golsdJugadorActual > golsJugadorAmbMesGols) {
                                jugadorAmbMesGols = jugadors[i][0];
                                golsJugadorAmbMesGols = golsdJugadorActual;
                            }
                            if (golsdJugadorActual < golsJugadorAmbMenysGols) {
                                jugadorAmbMenysGols = jugadors[i][0];
                                golsJugadorAmbMenysGols = golsdJugadorActual;
                            }
                            totalGols += golsdJugadorActual;
                            totalJugadors++;
                        }
                    }
                    mitjanaGols = totalGols / totalJugadors;
                    System.out.println(String.format("El jugador amb mes gols es %s, ha fet %d gols", jugadorAmbMesGols, golsJugadorAmbMesGols));
                    System.out.println(String.format("El jugador amb menys gols es %s, ha fet %d gols", jugadorAmbMenysGols, golsJugadorAmbMenysGols));
                    System.out.println("Mitjana de gols:" + mitjanaGols);
                    break;
                case 5: //sortir
                    sortir = true;
                    Thread.sleep(1000);
                    System.out.println("bye bye");
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
}