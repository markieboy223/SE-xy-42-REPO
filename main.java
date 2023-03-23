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
    public void type1(){ //Hier check ik of de klant particulier, bedrijf od overheid is
        if (kvkNummer == 0 && isOverheid){
            type = "particulier";
            percentage = 0.0;
        }
        else if (!isOverheid) {
            type = "overheid";
            percentage = 15.0;
        }
        else if (kvkNummer != 0) {
            type = "bedrijf";
            percentage = 10.0;
        }
    }
    public void klantNaam(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef uw naam:");
        String naam = scanner.next();
        setNaam(naam);
        System.out.println("Geef uw adres:");
        String adres = scanner.next();
        setAdres(adres);
        System.out.println("Heeft u een kvkNummer J of N:");
        String kvkNummerJN = scanner.next();
        if (kvkNummerJN.equals("J")){ //Hier checkt de if of er J is ingevoerd en daar vraagt hij dan om het kvkNummer
            System.out.println("Geef uw kvkNummer");
            int kvkNummer = scanner.nextInt();
            setKvkNummer(kvkNummer);
        }
        else if (kvkNummerJN.equals("N")){// Als er N wordt ingevoerd en dan gaat hij door naar of het een overheid is
            System.out.println("Bent u van de overheid? J of N");
            String overheid = scanner.next();
            if(overheid.equals("J")){ //Als overheid J is wordt hij true en wordt hij geset
                boolean overheid2 = true;
                setOverheid(overheid2);
            }
            else if (overheid.equals("N")) { //Als overheid N is wordt hij false en word hij geset
                boolean overheid2 = false;
                setOverheid(overheid2);
            }
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