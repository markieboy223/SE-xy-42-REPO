import java.util.ArrayList;
import java.util.Scanner;

class Botenlist{
    ArrayList<Boot> boten = new ArrayList<>();
    public void printBotenLijst(){
        for (Boot b : boten) {
            System.out.println();
            System.out.println("Naam: " + b.getNaam());
            System.out.println("Type: " + b.getType());
            System.out.println("Merk: " + b.getMerk());
            System.out.println("Prijs: " + b.getPrijs() + " Euro");
            System.out.println("Lengte: " + b.getLengte() + "M");
            System.out.println("Gewicht: " + b.getGewicht() + "KG");
        }
    }
}
 class Boot{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    private String naam;
    private String type;
    private String merk;
    private Double prijs;
    private Double lengte;
    private Double gewicht;

    public Boot(String naam, String type, String merk, double prijs, double lengte, double gewicht) {
        this.naam = naam;
        this.type = type;
        this.merk = merk;
        this.prijs = prijs;
        this.lengte = lengte;
        this.gewicht = gewicht;
    }

     public String getNaam() {
         return naam;
     }

     public void setNaam(String naam) {
         this.naam = naam;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getMerk() {
         return merk;
     }

     public void setMerk(String merk) {
         this.merk = merk;
     }

     public double getPrijs() {
         return prijs;
     }

     public void setPrijs(double prijs) {
         this.prijs = prijs;
     }

     public double getLengte() {
         return lengte;
     }

     public void setLengte(double lengte) {
         this.lengte = lengte;
     }

     public double getGewicht() {
         return gewicht;
     }

     public void setGewicht(double gewicht) {
         this.gewicht = gewicht;
     }
     public void printBoot(){
         System.out.println();
         System.out.println("Naam: " + naam);
         System.out.println("Type: " + type);
         System.out.println("Merk: " + merk);
         System.out.println("Prijs: " + prijs + " Euro");
         System.out.println("Lengte: " + lengte + "M");
         System.out.println("Gewicht: " + gewicht + "KG");
     }
 }
class Plezierjacht extends Boot {
    public Plezierjacht(String naam, String type, String merk, double prijs, double lengte, double gewicht){
        super(naam, type, merk, prijs, lengte, gewicht);
    }
}
class Zeiljacht extends Boot {
    private String zeil;
    public Zeiljacht(String naam, String type, String merk, double prijs, double lengte, double gewicht, String zeil){
        super(naam, type, merk, prijs, lengte, gewicht);
        this.zeil = zeil;
    }
    @Override
    public void printBoot(){
        super.printBoot();
        System.out.print("Zeil: " + zeil);
    }
}

class Opties{
    //Deze 2 lijsten bevatten alle beschikbare opties.
    protected ArrayList<Optie> Essentieel = new ArrayList<>();
    protected ArrayList<Optie> Optioneel = new ArrayList<>();

    public ArrayList<Optie> kiesOptieEssentieel(){
        //Dit wordt aangeroepen als de klant de essentiële opties gaat kiezen, er wordt een ArrayList gereturned met de keuzes.
        ArrayList<Optie> gekozenEssentieel = new ArrayList<>();
        System.out.println("Het is voor de volgende " + Essentieel.size() + " opties verplicht om een keuze te maken.");

        for(Optie optie : Essentieel) {
            System.out.println("Welk type " + optie.naam + " wilt u toevoegen?");
            System.out.println("Optie 1: " + optie.opties.get(0).omschrijving);
            System.out.println("Optie 2: " + optie.opties.get(1).omschrijving);
            System.out.println("Optie 3: " + optie.opties.get(2).omschrijving);
            System.out.println("Type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            Scanner scanner = new Scanner(System.in);
            int check = scanner.nextInt();
            //Hier moet nog een veiligheidscheck worden toegevoegd voor verkeerde inputs.
            if (check == 1) {
                gekozenEssentieel.add(optie.opties.get(0));
            }
            if (check == 2) {
                gekozenEssentieel.add(optie.opties.get(1));
            }
            if (check == 3) {
                gekozenEssentieel.add(optie.opties.get(2));
            }
            System.out.println();
        }
        return gekozenEssentieel;
    }

    public ArrayList<Optie> kiesOptieOptioneel(){
        //Dit wordt aangeroepen als de klant de optionele opties gaat kiezen, er wordt een ArrayList gereturned met de keuzes.
        ArrayList<Optie> gekozenOptioneel = new ArrayList<>();
        System.out.println("Het is voor de volgende " + Optioneel.size() + " opties mogelijk om het niet toe te voegen.");

        for(Optie optie : Optioneel) {
            System.out.println("Welk type " + optie.naam + " wilt u toevoegen?");
            System.out.println("Optie 1: " + optie.opties.get(0).omschrijving);
            System.out.println("Optie 2: " + optie.opties.get(1).omschrijving);
            System.out.println("Optie 3: " + optie.opties.get(2).omschrijving);
            System.out.println("Type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            Scanner scanner = new Scanner(System.in);
            int check = scanner.nextInt();
            //Hier moet nog een veiligheidscheck worden toegevoegd voor verkeerde inputs.
            if (check == 0){
                continue;
            }
            if (check == 1) {
                gekozenOptioneel.add(optie.opties.get(0));
            }
            if (check == 2) {
                gekozenOptioneel.add(optie.opties.get(1));
            }
            if (check == 3) {
                gekozenOptioneel.add(optie.opties.get(2));
            }
            System.out.println();
        }
        return gekozenOptioneel;
    }

    public void aanmakenOpties(){
        //Hier worden de verschillende essentiële en optionele opties aangemaakt.
        Optie stuur = new Optie("Stuur", "Standaard stuur", 150.0, true);
        Keuze stuur1 = new Keuze("Basis stuur", "Standaard stuur van aluminium", 150.0, false, 1);
        Keuze stuur2 = new Keuze("Eikenhout stuur", "Stuur van eikenhout", 210.0, false, 2);
        Keuze stuur3 = new Keuze("Eikenhout stuur met bladgoud", "Stuur van eikenhout versiert met bladgoud", 275.0, false, 3);
        stuur.voegToe(stuur1);
        stuur.voegToe(stuur2);
        stuur.voegToe(stuur3);
        Essentieel.add(stuur);

        Optie motor = new Optie("Moter", "Standaard motor", 10000.0, true);
        Keuze motor1 = new Keuze("Basis Motor", "Standaard motor 500PK.", 10000.0, false, 1);
        Keuze motor2 = new Keuze("Motor 800PK", "Motor een vermogen van 800PK.", 15000.0, false, 2);
        Keuze motor3 = new Keuze("Motor 800PK met supercharger", "800PK motor met een supercharger.", 18750.0, false, 3);
        motor.voegToe(motor1);
        motor.voegToe(motor2);
        motor.voegToe(motor3);
        Essentieel.add(motor);

        Optie reddingsboot = new Optie("Reddingsboot", "Standaard reddingsboot", 2000.0, true);
        Keuze redding1 = new Keuze("Basis reddingsboot", "Standaard reddingsboot met ruimte voor 5", 2000.0, false, 1);
        Keuze redding2 = new Keuze("Grotere reddingsboot", "Grotere reddingsboot met ruimte voor 10", 4000.0, false, 2);
        Keuze redding3 = new Keuze("Luxe reddingsboot", "Reddingsboot met ruimte voor 10, een minibar en audio installatie.", 10300.75, false, 3);
        reddingsboot.voegToe(redding1);
        reddingsboot.voegToe(redding2);
        reddingsboot.voegToe(redding3);
        Essentieel.add(reddingsboot);

        Optie feestboot = new Optie("Party Boat", "Feestelijke toevoegingen", 5000.0, false);
        Keuze feest1 = new Keuze("Basis uitbreiding", "Upgrade aan het audio-systeem en RGB lampen", 5000.0, false, 1);
        Keuze feest2 = new Keuze("Medium uitbreiding", "Naast de toevoegingen van Optie 1 ook een uitgebreide bar en dansvloer", 10000.0, false, 2);
        Keuze feest3 = new Keuze("VIP uitbreiding", "Naast de toevoegingen van Opties 1&2 ook een helicopter pad voor makkelijke transport", 25000.0, false, 3);
        feestboot.voegToe(feest1);
        feestboot.voegToe(feest2);
        feestboot.voegToe(feest3);
        Optioneel.add(feestboot);

        Optie bekleding = new Optie("Bekleding", "Uitbreding op de bekleding", 5000.0, false);
        Keuze bekleding1 = new Keuze("Hout interieur", "Het interieur wordt gestyled met hout", 5000.0, false, 1);
        Keuze bekleding2 = new Keuze("Zelfontworpen buitenkant", "Door de koper ontworpen buitenkant", 10000.0, false, 2);
        Keuze bekleding3 = new Keuze("Combi", "Een combinatie van Optie 1 en Optie 2", 15000.0, false, 3);
        bekleding.voegToe(bekleding1);
        bekleding.voegToe(bekleding2);
        bekleding.voegToe(bekleding3);
        Optioneel.add(bekleding);

        Optie personeel = new Optie("Personeel", "Keuze uit eigen personeel", 5000.0, false);
        Keuze pers1 = new Keuze("Basis personeel", "Een kapitein en 2 matrosen", 5000.0, false, 1);
        Keuze pers2 = new Keuze("Keuken personeel", "Ook een chefkok met 2 hulpjes", 10000.0, false, 2);
        Keuze pers3 = new Keuze("VIP personeel", "Masseuses en etc.", 25000.0, false, 3);
        personeel.voegToe(pers1);
        personeel.voegToe(pers2);
        personeel.voegToe(pers3);
        Optioneel.add(personeel);
    }
    public void nieuweOptie(){
        //Begin gemaakt aan het mogelijk maken voor de gebruiker om nieuwe opties toe te voegen.

        //Dit is een begin aan het mogelijk maken voor de gebruiker om nieuwe opties toe te voegen.
        Scanner scanner = new Scanner(System.in);
        System.out.println("U gaat nu een nieuwe optie toevoegen aan ShipFlex.");
        System.out.println("Geef de naam van de nieuwe optie:");
        String naam = scanner.nextLine();
        System.out.println("Geef een omschrijving van de nieuwe optie:");
        String omschrijving = scanner.nextLine();
        System.out.println("Geef de begin prijs van de nieuwe optie");
        double prijs = scanner.nextDouble();
        System.out.println("Is de nieuwe optie essentieel? geef 'true' als antwoord is het geval van wel, geef 'false' als het niet zo is.");
        boolean isEssentieel = scanner.nextBoolean();
        System.out.println("Wilt u meerdere versies van de Optie toevoegen?");
    }
}
class Optie extends Opties{

    protected ArrayList<Keuze> opties = new ArrayList<>();
    protected String naam;
    protected String omschrijving;
    protected Double prijs;
    protected Boolean isEssentieel;

    public Optie(String naam, String omschrijving, Double prijs, Boolean isEssentieel){
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.prijs = prijs;
        this.isEssentieel = isEssentieel;
    }
    public void voegToe(Keuze keuze){
        opties.add(keuze);
    }
}
class Keuze extends Optie{
    protected int optie;
    public Keuze(String naam, String omschrijving, Double prijs, Boolean isEssentieel, int optie) {
        super(naam, omschrijving, prijs, isEssentieel);
        this.optie = optie;
    }
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

public class main {
    public static void main(String[] args) {

        System.out.println("Welkom bij ShipFlex, wat wilt u doen?");

        //Klant
//        Klant klant = new Klant("", 0.0);
//        klant.klantNaam();

        //Boten menu
//        System.out.println("Hier de lijst met beschikbare boten om uit te kiezen.");
        //Boten aanmaken
        Boot boot = new Boot("boot", "boot", "boot", 25000.00, 15.2, 4000);
        Boot APMarine = new Plezierjacht("AP Marine", "Plezierjacht", "Marine", 25000.00, 15.2, 4000);
        Boot Quinness = new Plezierjacht("Quinness 2", "Plezier jacht", "Guinness", 50000.00, 20.5, 5000);
        Boot Zeilbootje = new Zeiljacht("AP SEA", "Zeiljacht", "Marine", 30000.00, 15.2, 4000, "zeil");

//        boot.printBoot();
//        APMarine.printBoot();
//        Quinness.printBoot();
//        Zeilbootje.printBoot();


        //BotenList
        Botenlist botenlist = new Botenlist();
        botenlist.boten.add(APMarine);
        botenlist.boten.add(Quinness);
        botenlist.boten.add(Zeilbootje);
        botenlist.printBotenLijst();

        //Boten printen
//        APMarine.printBoot();
//        Zeilbootje.printBoot();
//        Quinness.printBoot();

        //Boot kiezen met klant

//        Opties opties = new Opties();
//        opties.aanmakenOpties();
//        ArrayList<Optie> gekozenEssentieel = new ArrayList<Optie>(opties.kiesOptieEssentieel());
//        ArrayList<Optie> gekozenOptioneel = new ArrayList<Optie>(opties.kiesOptieOptioneel());
    }
}