
class Optie{
    private String naam;
    private Double prijs;
    private Boolean isEssentieel;
}

class Klant{
    private String naam;
    private String adres;
}

class OverheidKlant extends Klant{

}

class BedrijfKlant extends Klant{
    private int kvkNummer;
}
class Korting{
    private Double percentage;
}

public class main {
    public static String test = "boot";
    public static void main(String[] args) {
        System.out.println(test);

    }

}
