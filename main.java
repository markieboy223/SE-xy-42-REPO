import java.util.ArrayList;

class Optie{
    private String naam;
    private String omschrijving;
    private Double prijs;
    private Boolean isEssentieel;
}

class OverheidKlant extends Klant{

}

class BedrijfKlant extends Klant{
    private int kvkNummer;
}

class Korting {
    private Double percentage;
    private String type;
}
class Klant{
    private String naam;
    private String adres;
    private int kvkNummer;
    private boolean isOverheid;
}

class Plezierjacht{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    String naam;
    String merk;
    Double prijs;
    Double lengte;
    Double gewicht;

}


public class main {
    public static String test = "boot";
    public static void main(String[] args) {
        System.out.println(test);

    }

}


