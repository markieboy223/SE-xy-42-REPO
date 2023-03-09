import java.util.ArrayList;
import java.util.Scanner;

class Dagboek{
    ArrayList<dagAantekening> dagaantekeningen = new ArrayList<>();

    public void voegDagaantekingToe(dagAantekening dagAantekening){
        dagaantekeningen.add(dagAantekening);
    }
}
class dagAantekening{
    private String naam;
    private String datum;
    private String tekst;
    public dagAantekening(String naam, String datum, String tekst){
        this.naam = naam;
        this.datum = datum;
        this.tekst = tekst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Voeg een dagaantekening toe.");
        Scanner scanner =  new Scanner(System.in);
        Dagboek dagboek = new Dagboek();

        dagAantekening dagAantekeningen1 = new dagAantekening(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        System.out.println("Voeg nog een dagaantekening toe");
        dagAantekening dagAantekeningen2 = new dagAantekening(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        System.out.println("Voeg nog een dagaantekening toe");
        dagAantekening dagAantekeningen3 = new dagAantekening(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        dagboek.voegDagaantekingToe(dagAantekeningen1);
        dagboek.voegDagaantekingToe(dagAantekeningen2);
        dagboek.voegDagaantekingToe(dagAantekeningen3);


        for (int i=0; i<dagboek.dagaantekeningen.size(); i++) {
            System.out.println(dagboek.dagaantekeningen.get(i).getNaam() + " " + dagboek.dagaantekeningen.get(i).getDatum() + " " + dagboek.dagaantekeningen.get(i).getTekst());
        }

    }
}