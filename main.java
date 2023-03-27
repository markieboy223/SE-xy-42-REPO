import java.util.ArrayList;
import java.util.Scanner;

class Optie{
    private String naam;
    private String omschrijving;
    private Double prijs;
    private Boolean isEssentieel;
}

class Klant extends Korting{
    private String naam = "";
    private String adres = "";
    private int kvkNummer = 0;
    private boolean isOverheid = false;

    public Klant(String type, Double percentage) {
        super(type, percentage);
    }

    public void klantNaam() {
        Scanner scanner = new Scanner(System.in);
        int keuze = -1;
        while (keuze < 1 || keuze > 3) { // als er geen 1,2 of 3 wordt ingevuld blijft hij de vraag stellen
            System.out.println("Maak een keuze: ");
            System.out.println("1. Particulier");
            System.out.println("2. Bedrijf");
            System.out.println("3. Overheid");
            System.out.println("Voer uw keuze in (1, 2 of 3):");
            if (scanner.hasNextInt()) { // hier controleert hij of er wel een int, is ingevuld en niet bijvoorbeeld een string
                keuze = scanner.nextInt();
                if (keuze < 1 || keuze > 3) { // als het geen 1,2 of 3 is print hij dit uit
                    System.out.println("Ongeldige invoer. Getal is niet 1, 2 of 3");
                }
            } else { // als het iets anders dan een int is print hij dit uit
                System.out.println("Ongeldige invoer. Voer een geldig getal in (1, 2 of 3).");
                scanner.next(); // verwijder de ongeldige invoer uit de scanner
            }
        }
        System.out.println("Geef uw naam:");
        String naam = scanner.next();
        setNaam(naam);
        System.out.println("Geef uw adres:");
        String adres = scanner.next();
        setAdres(adres);
        if (keuze == 1) {

        } else if (keuze == 2) { //
            System.out.println("Geef uw kvkNummer (*8 cijfers vereist)");
            int kvkNummer = scanner.nextInt();
            int aantalCijfers = 8;
            while (String.valueOf(kvkNummer).length() != aantalCijfers) { // hier checkt de while loop of het kvkNummer 8 cijfers heeft of niet
                System.out.println("Geef uw kvkNummer (*8 cijfers vereist)");
                kvkNummer = scanner.nextInt();
            }
            setKvkNummer(kvkNummer);
        } else if (keuze == 3) {
            isOverheid = true;
        }

    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
    public boolean isOverheid() {
        return isOverheid;
    }
    public int getKvkNummer() {
        return kvkNummer;
    }
    public String getAdres() {
        return adres;
    }
    public String getNaam() {
        return naam;
    }
    public void setOverheid(boolean overheid) {
        this.isOverheid = overheid;
    }
    public void setKvkNummer(int kvkNummer) {
        this.kvkNummer = kvkNummer;
    }

}

class Korting{
    protected String type = "";
    protected Double percentage = 0.0;

    public Korting(String type, Double percentage) {
        this.type = type;
        this.percentage = percentage;
    }

    public Korting(String type) {
        this.type = type;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Plezierjacht{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    private String naam;
    private String merk;
    private Double prijs;
    private Double lengte;
    private Double gewicht;

}

public class main {
    public static void main(String[] args) {
        Klant klant = new Klant("", 0.0);
        klant.klantNaam();
    }

}