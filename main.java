import java.util.ArrayList;

class Plezierjacht{
    ArrayList <Optie> opties = new ArrayList<Optie>();
    private String naam;
    private String merk;
    private Double prijs;
    private Double lengte;
    private Double gewicht;

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

    }

}


