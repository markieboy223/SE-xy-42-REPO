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
    protected String naam;
    protected String omschrijving;
    protected Double prijs;
    protected Boolean isEssentieel;
    protected int Optie;

    public Optie(String naam, String omschrijving, Double prijs, Boolean isEssentieel){
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.prijs = prijs;
        this.isEssentieel = isEssentieel;
    }


}

class OptieKeuze extends Optie{
    private String keuze1;
    private String keuze2;
    private String keuze3;

    private Double prijs1;
    private Double prijs2;
    private Double prijs3;
    private int keuze;

    public OptieKeuze(String naam, String omschrijving, Double prijs, Boolean isEssentieel, String keuze1, String keuze2, String keuze3, Double prijs1, Double prijs2, Double prijs3) {
        super(naam, omschrijving, prijs, isEssentieel);
        this.keuze1 = keuze1;
        this.keuze2 = keuze2;
        this.keuze3 = keuze3;
        this.prijs1 = prijs1;
        this.prijs2 = prijs2;
        this.prijs3 = prijs3;
    }

    public void Keuze(){
        System.out.println("Wat voor type " + super.naam + " is gekozen?");
        System.out.println("Optie 1: "+ keuze1);
        System.out.println("Optie 2: "+ keuze2);
        System.out.println("Optie 3: "+ keuze3);
        Scanner scanner = new Scanner(System.in);

        if (super.isEssentieel){
            System.out.println("U moet verplicht een type " + super.naam + " kiezen.");
        }
        System.out.println("Type '1' voor Optie 1, '2' voor Optie 2 en '3' voor optie 3.");
        if (!super.isEssentieel) {
            System.out.println("In het geval dat u geen "+ super.naam + " wilt toevoegen type dan '0'.");
        }
        keuze = scanner.nextInt();

        if ((keuze == 0) && !super.isEssentieel) {
            System.out.println("U heeft gekozen om geen " + super.naam + " toe te voegen.");
        }
        if (keuze == 1) {
            super.Optie = 1;
            super.prijs = prijs1;
            super.omschrijving = keuze1;

        }
        if (keuze == 2) {
            super.Optie = 2;
            super.prijs = prijs2;
            super.omschrijving = keuze2;

        }
        if (keuze == 3) {
            super.Optie = 3;
            super.prijs = prijs3;
            super.omschrijving = keuze3;

        }
        else {
            System.out.println("U moet een van de opties kiezen.");
            Keuze();
        }

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
        ArrayList<Optie> gekozen = new ArrayList<>();
        OptieKeuze stuur = new OptieKeuze("Stuur", "Standaard stuur van aluminium", 150.0, true,
                "Een standaard stuur van aluminium", "Een eikhouten stuur", "Een eikhouten stuur versiers met bladgoud",
                150.0, 200.0, 250.0);
        stuur.Keuze();
        gekozen.add(stuur);
        System.out.println(gekozen.get(0).naam);
        System.out.println(gekozen.get(0).omschrijving);
        System.out.println(gekozen.get(0).prijs);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij ShipFlex, wat wilt u doen?");
        System.out.println("Optie 1: Een offerte aanmaken");
        System.out.println("Optie 2: Aanpassingen maken binnen ShipFlex");




    }

}