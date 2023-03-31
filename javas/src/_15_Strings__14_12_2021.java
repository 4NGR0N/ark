

public class _15_Strings__14_12_2021 {
    public static void main(String[] args) {
        String dilluns ="Dilluns", dimarts="Dimarts", dimecres="Dimecres";
        String message;                             // declaració de Strings 'message' no te cap valor. Si fem metodes, donarà error
        message="Hola que tal?\nAvui és dimarts.";
        System.out.print("Dilluns");                // Escriu un valor String per consola sense fer salt de línia
        System.out.print("Dimarts");
        System.out.print("Dimecres");
        System.out.println(message);                // Escriu un valor String per consola i fa un salt de línia
        System.out.printf("Dies de la setmana: %s %s %s\n", dilluns, dimarts, dimecres);
        System.out.printf("Nombre enter: %d, nombre decimal: %f",5,23.45f);
        
    }
}
