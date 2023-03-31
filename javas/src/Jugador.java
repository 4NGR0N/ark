

import java.util.Objects;

public class Jugador {
    private String nom;
    private String club;
    private int dorsal;
    private int gols;
    public static int maximnAnysCarrera = 20;

    public Jugador(String nom, String club, int dorsal, int gols) {
        this.nom = nom;
        this.club = club;
        this.dorsal = dorsal;
        this.gols = gols;
    }

    public static void dirHola(){
        System.out.println("Hola");
    }

    public String getNom() {
        return nom;
    }

    public String getClub() {
        return club;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getGols() {
        return gols;
    }

    @Override
    public String toString() {
        return String.format("%1$15s%2$15s%3$15s%4$15s",nom,club,String.valueOf(dorsal),String.valueOf(gols));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return dorsal == jugador.dorsal &&
                Objects.equals(nom, jugador.nom) &&
                Objects.equals(club, jugador.club);
    }

}
