import java.util.ArrayList;

class Plezierjacht{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    private String naam;
    private String merk;
    private Double prijs;
    private Double lengte;
    private Double gewicht;

}

class Optie{
    private String naam;
    private String omschrijving;
    private Double prijs;
    private Boolean isEssentieel;
}

class Klant{
    private String naam;
    private String adres;
    private int kvkNummer;
    private boolean isOverheid;
}

class Korting {
    private Double percentage;
    private String type;
}


public class main {
    public static String test = "boot";
    public static void main(String[] args) {
        System.out.println(test);
        System.out.println("Welkom bij ShipFlex, wat wilt u doen?");
        System.out.println("Optie 1: Een offerte aanmaken.");
        System.out.println("Optie 2: Aanpassingen maken aan ShipFlex.");
        //Hier met een scanner kijken of er 1 of 2 wordt getypt
    }

}


