import java.util.ArrayList;
import java.util.Scanner;


class Offerte{
    private Klant klant;
    private Korting korting;
    protected Boot boot;

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void setKorting(Korting korting) {
        this.korting = korting;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public void printOfferte(){
        boolean milieukorting = false;
        boolean bulkkorting = false;
        System.out.println("Offerte voor: " + boot.getType() + ", " + boot.getNaam());
        System.out.println("Naam klant: " + klant.getNaam());
        System.out.println("Adres: " + klant.getAdres());
        if (klant.getKvkNummer() != 0){
            System.out.println("kvk nummer: " + klant.getKvkNummer());
        }
        if (klant.isOverheid()){
            System.out.println("Overheids instanttie: ja");
        }
        System.out.println();
        System.out.println("Basis prijs van " + boot.getNaam() + ": " + boot.getPrijs());
        System.out.println("De gekozen essentiële opties:");
        System.out.println("Optie 1: " + boot.opties.get(0).naam + ", €" + boot.opties.get(0).prijs);
        System.out.println("Optie 2: " + boot.opties.get(1).naam + ", €" + boot.opties.get(1).prijs);
        System.out.println("Optie 3: " + boot.opties.get(2).naam + ", €" + boot.opties.get(2).prijs);
        System.out.println();
        if (boot.opties.size() > 3){
            System.out.println("De gekozen optionele opties:");
            int grootte = boot.opties.size();
            for (int i = 3; i < grootte; i++) {
                System.out.println("Optie " + (i + 1) + ": " + boot.opties.get(i).naam + ", €" + boot.opties.get(i).prijs);
            }
        }
        else{
            System.out.println("Er zijn geen optionele opties toegevoegd.");
        }
        System.out.println();
        System.out.println("De volgende kortingen zijn toegepast:");
        if (korting.kortingenLijst.get(0).check){
            System.out.println("10% milieukorting");
            milieukorting = true;
        }
        if (korting.kortingenLijst.get(1).check){
            System.out.println("€2000 bulkkorting");
            bulkkorting = true;
        }
        System.out.println();
        double totaal = boot.getPrijs();
        for (Optie optie : boot.opties){
            totaal = totaal + optie.prijs;
        }
        if ((!milieukorting && !bulkkorting)) {
            System.out.println("De totaalprijs is: €" + totaal);
        }
        else{
            System.out.println("De prijs voor het toepassen van de korting is: €" + totaal);
            System.out.println();
            if (milieukorting){
                totaal = totaal * korting.kortingenLijst.get(0).getPercentage();
            }
            if (bulkkorting){
                totaal = totaal - korting.kortingenLijst.get(1).getPercentage();
            }
            System.out.println("De totaalprijs na het toepassen van de korting is: €" + totaal);
        }
    }
}

class Botenlist {
    ArrayList<Boot> boten = new ArrayList<>();
    public void printBotenLijst() {
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
    public void berekening() {
        double totaleprijs =0;
        for (Boot b : boten) {
            totaleprijs += b.getPrijs();
        }
        System.out.println();
    }
}
class Boot extends Offerte{
    ArrayList <Optie> opties = new ArrayList<Optie>();

    public ArrayList<Optie> getOpties() {
        return opties;
    }
    public String getNaam() {
        return naam;
    }
    public String getType() {
        return type;
    }
    public String getMerk() {
        return merk;
    }
    public Double getPrijs() {
        return prijs;
    }
    public Double getLengte() {
        return lengte;
    }
    public Double getGewicht() {
        return gewicht;
    }

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
            System.out.println("Optie 1: " + optie.keuzes.get(0).omschrijving);
            System.out.println("Optie 2: " + optie.keuzes.get(1).omschrijving);
            System.out.println("Optie 3: " + optie.keuzes.get(2).omschrijving);
            System.out.println();
            System.out.println("Als u voor de volgende 3 opties de basis uitvoering kiest (optie 1) krijgt u 10% korting op de totaalprijs.");
            System.out.println("Type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            Scanner scanner = new Scanner(System.in);
            int check = -1;
            while (check < 1 || check > 3) { // als er geen 1,2 of 3 wordt ingevuld blijft hij de vraag stellen
                if (scanner.hasNextInt()) { // hier controleert hij of er wel een int, is ingevuld en niet bijvoorbeeld een string
                    check = scanner.nextInt();
                    if (check < 1 || check > 3) { // als het geen 1,2 of 3 is print hij dit uit
                        System.out.println("Ongeldige invoer. Getal is niet 1, 2 of 3");
                    }
                } else { // als het iets anders dan een int is print hij dit uit
                    System.out.println("Ongeldige invoer. Voer een geldig getal in (1, 2 of 3).");
                    scanner.next(); // verwijder de ongeldige invoer uit de scanner
                }
            }
            if (check == 1) {
                gekozenEssentieel.add(optie.keuzes.get(0));
            }
            if (check == 2) {
                gekozenEssentieel.add(optie.keuzes.get(1));
            }
            if (check == 3) {
                gekozenEssentieel.add(optie.keuzes.get(2));
            }
            System.out.println();
        }
        return gekozenEssentieel;
    }

    public ArrayList<Optie> kiesOptieOptioneel(){
        //Dit wordt aangeroepen als de klant de optionele opties gaat kiezen, er wordt een ArrayList gereturned met de keuzes.
        ArrayList<Optie> gekozenOptioneel = new ArrayList<>();
        System.out.println("Het is voor de volgende " + Optioneel.size() + " opties mogelijk om het niet toe te voegen.");
        System.out.println();
        System.out.println("Als u alle 3 optionele opties toevoegd krijg u een vaste korting van €2000.");

        for(Optie optie : Optioneel) {
            System.out.println("Welk type " + optie.naam + " wilt u toevoegen?");
            System.out.println("Optie 1: " + optie.keuzes.get(0).omschrijving);
            System.out.println("Optie 2: " + optie.keuzes.get(1).omschrijving);
            System.out.println("Optie 3: " + optie.keuzes.get(2).omschrijving);
            System.out.println("Type '0' als u niks wilt toevoegen, type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            Scanner scanner = new Scanner(System.in);
            int check = -1;
            while (check < 0 || check > 3) { // als er geen 1,2 of 3 wordt ingevuld blijft hij de vraag stellen
                if (scanner.hasNextInt()) { // hier controleert hij of er wel een int, is ingevuld en niet bijvoorbeeld een string
                    check = scanner.nextInt();
                    if (check < 0 || check > 3) { // als het geen 1,2 of 3 is print hij dit uit
                        System.out.println("Ongeldige invoer. Getal is niet 0, 1, 2 of 3");
                    }
                } else { // als het iets anders dan een int is print hij dit uit
                    System.out.println("Ongeldige invoer. Voer een geldig getal in (0, 1, 2 of 3).");
                    scanner.next(); // verwijder de ongeldige invoer uit de scanner
                }
            }

            if (check == 0){
                continue;
            }
            if (check == 1) {
                gekozenOptioneel.add(optie.keuzes.get(0));
            }
            if (check == 2) {
                gekozenOptioneel.add(optie.keuzes.get(1));
            }
            if (check == 3) {
                gekozenOptioneel.add(optie.keuzes.get(2));
            }
            System.out.println();
        }
        return gekozenOptioneel;
    }

    public void aanmakenOptiesPlezierjacht1(){
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

    public void aanmakenOptiesPlezierjacht2(){
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

    public void aanmakenOptiesZeiljacht(){
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

    protected ArrayList<Keuze> keuzes = new ArrayList<>();
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
        keuzes.add(keuze);
    }
}
class Keuze extends Optie{
    protected int optie;
    public Keuze(String naam, String omschrijving, Double prijs, Boolean isEssentieel, int optie) {
        super(naam, omschrijving, prijs, isEssentieel);
        this.optie = optie;
    }
}

class Klant extends Offerte{
    private String naam = "";
    private String adres = "";
    private int kvkNummer = 0;
    private boolean isOverheid = false;


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

 class Korting extends Offerte{
    ArrayList<Kortinglijst> kortingenLijst = new ArrayList<>();

    public void maakKorting(){
        Kortinglijst milieukorting1 = new Kortinglijst("Milieukorting", 0.9);
        Kortinglijst bulkkorting1 = new Kortinglijst("Bulkkorting", 2000.0);

        kortingenLijst.add(milieukorting1);
        kortingenLijst.add(bulkkorting1);
    }

    public void checkKorting(Boot boot){
        if (boot.opties.size() == 6){
            kortingenLijst.get(1).check = true;
        }
        if (boot.opties.get(0).prijs + boot.opties.get(1).prijs + boot.opties.get(2).prijs == 12150){
            kortingenLijst.get(0).check = true;
        }
    }
 }
class Kortinglijst extends Korting{
    protected String type;
    protected Double percentage;
    protected boolean check = false;
    public String getType() {
        return type;
    }
    public Double getPercentage() {
        return percentage;
    }
    public Kortinglijst(String type, Double percentage) {
        this.type = type;
        this.percentage = percentage;
    }
}

public class main {
    public static void main(String[] args) {

        Offerte offerte = new Offerte();
        Korting korting= new Korting();

        System.out.println("Welkom bij ShipFlex, wat wilt u doen?");

        //Klant
        Klant klant = new Klant();
        klant.klantNaam();

        //Boten menu
        System.out.println("Hier de lijst met beschikbare boten om uit te kiezen.");
        //Boten aanmaken
        Plezierjacht APMarine = new Plezierjacht("AP Marine", "Plezierjacht", "Marine", 25000.00, 15.2, 4000);
        Plezierjacht Quinness = new Plezierjacht("Quinness 2", "Plezier jacht", "Guinness", 50000.00, 20.5, 5000);
        Zeiljacht Zeilbootje = new Zeiljacht("AP SEA", "Zeiljacht", "Marine", 30000.00, 15.2, 4000, "zeil");

        Botenlist botenlist = new Botenlist();
        botenlist.boten.add(APMarine);
        botenlist.boten.add(Quinness);
        botenlist.boten.add(Zeilbootje);

        botenlist.printBotenLijst();
        botenlist.berekening();


        //Boot kiezen met klant

        System.out.println("Welke boot is gekozen? Type '1' voor APMarine, '2' voor Quiness en '3' voor Zeilbootje.");
        Scanner scanner = new Scanner(System.in);
        int keuze = -1;
        while (keuze < 1 || keuze > 3) { // als er geen 1,2 of 3 wordt ingevuld blijft hij de vraag stellen
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

        Opties optie1 = new Opties();
        if (keuze == 1) {
            optie1.aanmakenOptiesPlezierjacht1();
            ArrayList<Optie> gekozenEssentieel = new ArrayList<Optie>(optie1.kiesOptieEssentieel());
            ArrayList<Optie> gekozenOptioneel = new ArrayList<Optie>(optie1.kiesOptieOptioneel());
            APMarine.opties.addAll(gekozenEssentieel);
            APMarine.opties.addAll(gekozenOptioneel);
            offerte.setBoot(APMarine);
            offerte.setKorting(korting);
            korting.maakKorting();
            korting.checkKorting(offerte.boot);
        }
        if (keuze == 2) {
            optie1.aanmakenOptiesPlezierjacht2();
            ArrayList<Optie> gekozenEssentieel = new ArrayList<Optie>(optie1.kiesOptieEssentieel());
            ArrayList<Optie> gekozenOptioneel = new ArrayList<Optie>(optie1.kiesOptieOptioneel());
            Quinness.opties.addAll(gekozenEssentieel);
            Quinness.opties.addAll(gekozenOptioneel);
            offerte.setBoot(Quinness);
            offerte.setKorting(korting);
            korting.maakKorting();
            korting.checkKorting(offerte.boot);
        }
        if (keuze == 3) {
            optie1.aanmakenOptiesZeiljacht();
            ArrayList<Optie> gekozenEssentieel = new ArrayList<Optie>(optie1.kiesOptieEssentieel());
            ArrayList<Optie> gekozenOptioneel = new ArrayList<Optie>(optie1.kiesOptieOptioneel());
            Zeilbootje.opties.addAll(gekozenEssentieel);
            Zeilbootje.opties.addAll(gekozenOptioneel);
            offerte.setBoot(Zeilbootje);
            offerte.setKorting(korting);
            korting.maakKorting();
            korting.checkKorting(offerte.boot);
        }
        offerte.setKlant(klant);
        offerte.printOfferte();
    }
}