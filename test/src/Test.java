import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class Kortinglijst {
    ArrayList<Korting> kortingenLijst = new ArrayList<>();

    public void maakKorting(){
        Korting milieukorting1 = new Korting("Milieukorting", 0.9);
        Korting bulkkorting1 = new Korting("Bulkkorting", 2000.0);
        Korting overheid1 = new Korting("Overheids korting", 1000.0);
        Korting onderneming1 = new Korting("Ondernemings korting", 1500.0);

        kortingenLijst.add(milieukorting1);
        kortingenLijst.add(bulkkorting1);
        kortingenLijst.add(overheid1);
        kortingenLijst.add(onderneming1);
    }

    }



class Korting {
    protected String type;
    protected Double percentage;
    protected boolean check = false;
    public String getType() {
        return type;
    }
    public Double getPercentage() {
        return percentage;
    }
    public Korting(String type, Double percentage) {
        this.type = type;
        this.percentage = percentage;
    }
}

class KortinglijstTest extends Kortinglijst {

    @Test
    public void testMaakKorting() {
        // Arrange
        Kortinglijst kl = new Kortinglijst();
        ArrayList<Korting> kortingenLijst = kl.kortingenLijst;

        //Act
        kl.maakKorting();

        // Assert
        Assertions.assertEquals(4, kortingenLijst.size());
        Assertions.assertEquals("Milieukorting", kortingenLijst.get(0).type);
        Assertions.assertEquals("Bulkkorting", kortingenLijst.get(1).type);
        Assertions.assertEquals("Overheids korting", kortingenLijst.get(2).type);
        Assertions.assertEquals("Ondernemings korting", kortingenLijst.get(3).type);
        Assertions.assertEquals(0.9,kortingenLijst.get(0).percentage);
        Assertions.assertEquals(2000.0,kortingenLijst.get(1).percentage);
        Assertions.assertEquals(1000.0,kortingenLijst.get(2).percentage);
        Assertions.assertEquals(1500.0,kortingenLijst.get(3).percentage);

    }}
