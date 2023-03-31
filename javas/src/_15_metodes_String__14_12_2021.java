

public class _15_metodes_String__14_12_2021 {
    public static void main(String[] args) {

        // Mètode instancia (retorna un valor en base al propi objecte)
        String frase = "Això és una frase";
        System.out.println(frase.length());

        // Mètode static (no l' invoco des de cap objecte, sinó de la classe)
        System.out.println("Això és un String: " + String.valueOf(23));

        // Mètode .charAt() retorna la lletra en la posició donada
        String nom = "Gerard";
        System.out.println(nom.charAt(5));

        // Mètode .indexOf() retorna la posició de la lletra passada
        System.out.println(nom.indexOf("r"));
    }
}
