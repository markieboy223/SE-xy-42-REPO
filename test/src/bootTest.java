import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

class Botenlist {
    ArrayList<Boot> boten = new ArrayList<>();
    public void printBotenLijst() {
        for (Boot b : boten) {
            System.out.println("Ons assortiment aan boten waaruit u als klant kunt kiezen: ");
            b.printBoot();
            System.out.println();
        }
    }
    public void berekening() {
        double totaleprijs =0;
        for (Boot b : boten) {
            totaleprijs += b.getPrijs();
        }
        System.out.println("Dit is uw totale prijs: € "+ totaleprijs);
        System.out.println();
    }
}

abstract class Boot {
    private String naam;
    private String type;
    private Double prijs;
    private Double lengte;
    private Double gewicht;

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

    public int kiesBoot(){
        System.out.println("Welke boot is gekozen? Type '1' voor APMarine, '2' voor Quiness en '3' voor Zeilbootje.");
        Scanner scanner = new Scanner(System.in);
        int keuze = -1;
        while (keuze < 1 || keuze > 3) { // blijft de vraag stellen totdat een geldige keuze wordt ingevoerd
            if (scanner.hasNextInt()) { // controleert of een integer wordt ingevoerd
                keuze = scanner.nextInt();
                if (keuze < 1 || keuze > 3) { // als de keuze ongeldig is
                    System.out.println("Ongeldige invoer. Voer een geldig getal in (1, 2 of 3).");
                }
            } else { // als de invoer geen integer is
                System.out.println("Ongeldige invoer. Voer een geldig getal in (1, 2 of 3).");
                scanner.next(); // verwijder de ongeldige invoer uit de scanner
            }
        }
        return keuze;

    }

    public Boot(String naam, String type, double prijs, double lengte, double gewicht) {
        this.naam = naam;
        this.type = type;
        this.prijs = prijs;
        this.lengte = lengte;
        this.gewicht = gewicht;
    }
    abstract void printBoot();
}
class Plezierjacht extends Boot {
    private String bestemd;
    public Plezierjacht(String naam, String type, double prijs, double lengte, double gewicht, String bestemd){
        super(naam, type, prijs, lengte, gewicht);
        this.bestemd = bestemd;
    }
    @Override
    public void printBoot(){
        System.out.println();
        System.out.println("Naam: " + getNaam());
        System.out.println("Type: " + getType());
        System.out.println("Prijs: " + getPrijs() + " Euro");
        System.out.println("Lengte: " + getLengte() + "M");
        System.out.println("Gewicht: " + getGewicht() + "KG");
        System.out.print("Bestemd: " + bestemd);
    }
}
class Zeiljacht extends Boot {
    private String zeil;
    public Zeiljacht(String naam, String type, double prijs, double lengte, double gewicht, String zeil){
        super(naam, type, prijs, lengte, gewicht);
        this.zeil = zeil;
    }
    @Override
    public void printBoot(){
        System.out.println();
        System.out.println("Naam: " + getNaam());
        System.out.println("Type: " + getType());
        System.out.println("Prijs: " + getPrijs() + " Euro");
        System.out.println("Lengte: " + getLengte() + "M");
        System.out.println("Gewicht: " + getGewicht() + "KG");
        System.out.print("Zeil: " + zeil);
    }
}


public class bootTest {
    @Test
    public void testBoot() {



    }
}
