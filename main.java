import java.util.ArrayList;
import java.util.Scanner;

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

    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij ShipFlex, wat wilt u doen?");
        System.out.println("Optie 1: Een offerte aanmaken");
        System.out.println("Optie 2: Aanpassingen maken binnen ShipFlex");
        if (scanner.nextLine().equals("Optie 1")){
            //Het programma laten runnen
        }
        if (scanner.nextLine().equals("Optie 2")){
            //Aanpassingen laten maken
        }
        else {
            System.out.println("Kies alstublief 'Optie 1' of 'Optie 2'");
        }


    }

}
