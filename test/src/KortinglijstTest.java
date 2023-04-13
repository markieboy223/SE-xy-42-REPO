import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


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
