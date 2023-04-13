import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class testOpties {

    protected ArrayList<Optie> testEssentieel = new ArrayList<>();
    protected ArrayList<Optie> testOptioneel = new ArrayList<>();

    public void aanmakenOpties(){
        //Hier worden de verschillende essentiële en optionele opties aangemaakt.
        Optie stuur = new Optie("Stuur", "Standaard stuur", 150.0, true);
        Keuze stuur1 = new Keuze("Basis stuur", "Standaard stuur van aluminium", 150.0, true, 1);
        Keuze stuur2 = new Keuze("Eikenhout stuur", "Stuur van eikenhout", 210.0, false, 2);
        Keuze stuur3 = new Keuze("Eikenhout stuur met bladgoud", "Stuur van eikenhout versiert met bladgoud", 275.0, false, 3);
        stuur.voegToe(stuur1, stuur2, stuur3);
        testEssentieel.add(stuur);

        Optie motor = new Optie("Moter", "Standaard motor", 10000.0, true);
        Keuze motor1 = new Keuze("Basis Motor", "Standaard motor 500PK.", 10000.0, true, 1);
        Keuze motor2 = new Keuze("Motor 800PK", "Motor een vermogen van 800PK.", 15000.0, false, 2);
        Keuze motor3 = new Keuze("Motor 800PK met supercharger", "800PK motor met een supercharger.", 18750.0, false, 3);
        motor.voegToe(motor1, motor2, motor3);
        testEssentieel.add(motor);

        Optie reddingsboot = new Optie("Reddingsboot", "Standaard reddingsboot", 2000.0, true);
        Keuze redding1 = new Keuze("Basis reddingsboot", "Standaard reddingsboot met ruimte voor 5", 2000.0, true, 1);
        Keuze redding2 = new Keuze("Grotere reddingsboot", "Grotere reddingsboot met ruimte voor 10", 4000.0, false, 2);
        Keuze redding3 = new Keuze("Luxe reddingsboot", "Reddingsboot met ruimte voor 10, een minibar en audio installatie.", 10300.75, false, 3);
        reddingsboot.voegToe(redding1, redding2, redding3);
        testEssentieel.add(reddingsboot);

        Optie feestboot = new Optie("Party Boat", "Feestelijke toevoegingen", 5000.0, false);
        Keuze feest1 = new Keuze("Basis uitbreiding", "Upgrade aan het audio-systeem en RGB lampen", 5000.0, false, 1);
        Keuze feest2 = new Keuze("Medium uitbreiding", "Naast de toevoegingen van Optie 1 ook een uitgebreide bar en dansvloer", 10000.0, false, 2);
        Keuze feest3 = new Keuze("VIP uitbreiding", "Naast de toevoegingen van Opties 1&2 ook een helicopter pad voor makkelijke transport", 25000.0, false, 3);
        feestboot.voegToe(feest1, feest2, feest3);
        testOptioneel.add(feestboot);

        Optie bekleding = new Optie("Bekleding", "Uitbreding op de bekleding", 5000.0, false);
        Keuze bekleding1 = new Keuze("Hout interieur", "Het interieur wordt gestyled met hout", 5000.0, false, 1);
        Keuze bekleding2 = new Keuze("Zelfontworpen buitenkant", "Door de koper ontworpen buitenkant", 10000.0, false, 2);
        Keuze bekleding3 = new Keuze("Combi", "Een combinatie van Optie 1 en Optie 2", 15000.0, false, 3);
        bekleding.voegToe(bekleding1, bekleding2, bekleding3);
        testOptioneel.add(bekleding);

        Optie personeel = new Optie("Personeel", "Keuze uit eigen personeel", 5000.0, false);
        Keuze pers1 = new Keuze("Basis personeel", "Een kapitein en 2 matrosen", 5000.0, false, 1);
        Keuze pers2 = new Keuze("Keuken personeel", "Ook een chefkok met 2 hulpjes", 10000.0, false, 2);
        Keuze pers3 = new Keuze("VIP personeel", "Masseuses en etc.", 25000.0, false, 3);
        personeel.voegToe(pers1, pers2, pers3);
        testOptioneel.add(personeel);
    }

    public void nieuweOptie(boolean essentieel){
        //Begin gemaakt aan het mogelijk maken voor de gebruiker om nieuwe opties toe te voegen.

        //Dit is een begin aan het mogelijk maken voor de gebruiker om nieuwe opties toe te voegen.
        Scanner scanner = new Scanner(System.in);
        System.out.println("U gaat nu een nieuwe optie toevoegen aan ShipFlex.");
        System.out.println("Geef de naam van de nieuwe optie:");
        String naam = "werkt het?";
        System.out.println("Geef een omschrijving van de nieuwe optie:");
        String omschrijving = "test1";
        System.out.println("Geef de begin prijs van de nieuwe optie");
        double prijs = 50.0;
        System.out.println("Is de nieuwe optie essentieel? geef 'true' als antwoord is het geval van wel, geef 'false' als het niet zo is.");
        boolean isEssentieel = essentieel;
        System.out.println("Is dit de optie die u wilt toevoegen?:");
        System.out.println("Naam: " + naam + " omschrijving: " + omschrijving + " prijs: " + prijs + " essentieel of niet: " + isEssentieel);
        System.out.println("Type 'j' als het correct is en 'n' als u opnieuw wilt beginnen.");

        String kies = "j";
                Optie nieuw = new Optie(naam, omschrijving, prijs, isEssentieel);
                Keuze nieuw1 = new Keuze(naam, omschrijving, prijs, isEssentieel, 1);
                nieuw.voegToe2(nieuw1);
                if (nieuw.isEssentieel){
                    testEssentieel.add(nieuw);
                }
                else{
                    testOptioneel.add(nieuw);
                }
        }

    public ArrayList<Optie> kiesOptieEssentieel(){
        //Dit wordt aangeroepen als de klant de essentiële opties gaat kiezen, er wordt een ArrayList gereturned met de keuzes.
        ArrayList<Optie> gekozenEssentieel = new ArrayList<>();
        System.out.println("Het is voor de volgende " + testEssentieel.size() + " opties verplicht om een keuze te maken.");

        for(Optie optie : testEssentieel) {
            System.out.println("Welk type " + optie.naam + " wilt u toevoegen?");
            int check2 = optie.keuzes.size();
            for (int i = 0; i < optie.keuzes.size(); i++){
                System.out.println("Optie " + (i + 1) + ": " + optie.keuzes.get(i).omschrijving);
            }
            System.out.println();
            System.out.println("Als u voor de volgende " + check2 + " opties de basis uitvoering kiest (optie 1) krijgt u 10% korting op de totaalprijs.");
            System.out.println("Type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            /* Scanner scanner = new Scanner(System.in);
            int check = -1;
            while (check < 1 || check > check2) {
                if (scanner.hasNextInt()) {
                    check = scanner.nextInt();
                    if (check < 1 || check > check2) {
                        System.out.println("Ongeldige invoer. Getal is valt niet tussen 1 en " + check2);
                    }
                } else {
                    System.out.println("Ongeldige invoer. Voer een geldig getal in dat valt tussen 1 en " + check2);
                    scanner.next();
                }
            }
            */
            gekozenEssentieel.add(optie.keuzes.get(0));

            System.out.println();
        }
        return gekozenEssentieel;
    }

    public ArrayList<Optie> kiesOptieOptioneel(){
        //Dit wordt aangeroepen als de klant de optionele opties gaat kiezen, er wordt een ArrayList gereturned met de keuzes.
        ArrayList<Optie> gekozenOptioneel = new ArrayList<>();
        System.out.println("Het is voor de volgende " + testOptioneel.size() + " opties mogelijk om het niet toe te voegen.");
        System.out.println();
        System.out.println("Als u alle " + testOptioneel.size() + " optionele opties toevoegd krijg u een vaste korting van €2000.");

        for(Optie optie : testOptioneel) {
            System.out.println("Welk type " + optie.naam + " wilt u toevoegen?");
            int check1 = optie.keuzes.size();
            for (int i = 0; i < optie.keuzes.size(); i++){
                System.out.println("Optie " + (i + 1) + ": " + optie.keuzes.get(i).omschrijving);
            }
            System.out.println("Type '0' als u niks wilt toevoegen, type '1' voor Optie 1, '2' voor Optie 2 en '3' voor Optie 3.");

            /* Scanner scanner = new Scanner(System.in);
            int check = -1;
            while (check < 0 || check > check1) { // als er geen 1,2 of 3 wordt ingevuld blijft hij de vraag stellen
                if (scanner.hasNextInt()) { // hier controleert hij of er wel een int, is ingevuld en niet bijvoorbeeld een string
                    check = scanner.nextInt();
                    if (check < 0 || check > check1) { // als het geen 1,2 of 3 is print hij dit uit
                        System.out.println("Ongeldige invoer. Getal valt niet tussen 0 en " + check1);
                    }
                } else { // als het iets anders dan een int is print hij dit uit
                    System.out.println("Ongeldige invoer. Voer een geldig getal dat valt tussen 0 en " + check1);
                    scanner.next(); // verwijder de ongeldige invoer uit de scanner
                }
            }
            if (check == 0){
                continue;
            }
             */

            gekozenOptioneel.add(optie.keuzes.get(0));

            System.out.println();
        }
        return gekozenOptioneel;
    }

    @Test
    public void testaanmakenOpties(){
        //Arrange
        Opties optie = new Opties();
        //Act
        optie.aanmakenOpties();
        //Assert
        assertEquals(3, optie.essentieel.size());
        assertEquals(3, optie.optioneel.size());
    }
    @Test
    public void testkiesOptieOptioneel(){
        //Arrange
        testOpties optie = new testOpties();
        //Act
        optie.aanmakenOpties();
        //Assert
        assertEquals(3, optie.kiesOptieOptioneel().size());
    }

    @Test
    public void testkiesOptieEssentieel(){
        //Arrange
        testOpties optie = new testOpties();
        //Act
        optie.aanmakenOpties();
        //Assert
        assertEquals(3, optie.kiesOptieEssentieel().size());
    }

    @Test
    public void testNieuweOptie(){
        //Arrange
        testOpties optie = new testOpties();
        testOpties optie1 = new testOpties();
        //Act
        optie.nieuweOptie(true);
        optie1.nieuweOptie(false);
        //Assert
        assertEquals(1, optie.testEssentieel.size());
        assertEquals(1, optie1.testOptioneel.size());
    }

}
