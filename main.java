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

    public static void main(String[] args) {
        Opties opties = new Opties();
        opties.aanmakenOpties();
        ArrayList<Optie> gekozenEssentieel = new ArrayList<Optie>(opties.kiesOptieEssentieel());
        ArrayList<Optie> gekozenOptioneel = new ArrayList<Optie>(opties.kiesOptieOptioneel());


    }

}

