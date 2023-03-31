

public class _16_exercici_3_matrius_2__11_01_2022 {

    // Lletres de colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    //Colors de fons
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {

        /*
        * TRUE false false false false
        * false TRUE false false false
        * false false TRUE false false
        * false false false TRUE false
        * false false false false TRUE
        * */

        boolean[][] matriu = new boolean[5][5];
        int contador = 1;

        //generar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if(i == j){
                    matriu[i][j] = true;
                }else{
                    matriu[i][j] = false;
                }
            }
        }

        //mostrar els valors de la matriu
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if(i == j){
                    System.out.printf(ANSI_WHITE+ANSI_BLACK_BACKGROUND+"%6s"+ANSI_RESET, matriu[i][j]);
                }else{
                    System.out.printf(ANSI_WHITE_BACKGROUND+"%6s"+ANSI_RESET, matriu[i][j]);
                }
            }
            System.out.println();
        }
    }
}
