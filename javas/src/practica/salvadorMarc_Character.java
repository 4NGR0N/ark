package practica;

public class salvadorMarc_Character {
    String name;
    String height;
    String mass;
    String hair_color;
    String skin_color;
    String eye_color;
    String birth_year;
    String gender;
    String homeworld;
    String species;
    
    public salvadorMarc_Character(String name, String height, String mass, String hair_color, String skin_color,
            String eye_color, String birth_year, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public void enPantalla(){
        System.out.println(ANSI_GREEN+"Nombre: "+ ANSI_PURPLE + this.name);
        System.out.println(ANSI_GREEN+"Altura: "+ ANSI_PURPLE + this.height);
        System.out.println(ANSI_GREEN+"Masa: "+ ANSI_PURPLE + this.mass);
        System.out.println(ANSI_GREEN+"Color de cabello: "+ ANSI_PURPLE + this.hair_color);
        System.out.println(ANSI_GREEN+"Color de piel: "+ ANSI_PURPLE + this.skin_color);
        System.out.println(ANSI_GREEN+"Color de ojos: " + ANSI_PURPLE+ this.eye_color);
        System.out.println(ANSI_GREEN+"Año de nacimiento: " + ANSI_PURPLE+ this.birth_year);
        System.out.println(ANSI_GREEN+"Género: " + ANSI_PURPLE+ this.gender);
        System.out.println(ANSI_GREEN+"Planeta natal: " + ANSI_PURPLE+ this.homeworld);
        System.out.println(ANSI_GREEN+"Especie: " + ANSI_PURPLE+ this.species);
        System.out.println(ANSI_CYAN+"-------------------------"+ANSI_RESET);
    }    
}
