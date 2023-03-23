import java.util.ArrayList;
import java.util.Scanner;

 class Boot{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    private String naam;
    private String type;
    private String merk;
    private double prijs;
    private double lengte;
    private double gewicht;

    public Boot(String naam, String type, String merk, double prijs, double lengte, double gewicht) {
        this.naam = naam;
        this.type = type;
        this.merk = merk;
        this.prijs = prijs;
        this.lengte = lengte;
        this.gewicht = gewicht;
    }
    public void printBoot(){
        System.out.println();
        System.out.println("Naam: " + naam);
        System.out.println("Type: " + type);
        System.out.println("Merk: " + merk);
        System.out.println("Prijs: " + prijs + " Euro");
        System.out.println("Lengte: " + lengte + "M");
        System.out.println("Gewicht: " + gewicht+ "KG");
    }
}
class Plezierjacht extends Boot {
    public Plezierjacht(String naam,String type, String merk, double prijs, double lengte, double gewicht){
        super(naam, type, merk, prijs, lengte, gewicht);
    }
}
class Zeiljacht extends Boot {
    private String zeil;
    public Zeiljacht(String naam,String type, String merk, double prijs, double lengte, double gewicht, String zeil){
        super(naam, type, merk, prijs, lengte, gewicht);
        this.zeil = zeil;
    }
    @Override
    public void printBoot(){
        super.printBoot();
        System.out.print("Zeil: " + zeil);
    }
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


        //Boten menu
        System.out.println("Kies een van de boten om toe te voegen aan ");
        //Boten aanmaken
        Plezierjacht APMarine = new Plezierjacht("AP Marine","Plezierjacht", "Marine", 25000.00, 15.2, 4000);
        Zeiljacht Zeilbootje = new Zeiljacht("AP SEA","Zeiljacht", "Marine", 30000.00, 15.2, 4000, "zeil");

        //Boten printen
        APMarine.printBoot();
        Zeilbootje.printBoot();

        //Boot kiezen
    }

}


