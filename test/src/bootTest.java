import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class bootTest {
    @Test
    public void testBotenlist() {
        //Hier wordt gekeken of boten correct worden aangemaakt en geplaatst in de botenlist.

        // Arrange
        int verwacht = 2;
        Botenlist botenlist = new Botenlist();
        Plezierjacht pj = new Plezierjacht("Plezierjacht 1", "Plezierjacht", 50000, 8, 2000, "Familie-uitjes");
        Zeiljacht zj = new Zeiljacht("Zeiljacht 1", "Zeiljacht", 75000, 12, 3000, "Grootzeil");

        //Act
        botenlist.boten.add(pj);
        botenlist.boten.add(zj);

        // Assert
        Assertions.assertEquals(verwacht, botenlist.boten.size());
    }

    @Test
    public void testPrintBoot() {
        //Hier wordt gekeken of het aanmaken van de boten goed gebeurt en de gegevens van een boot correct kunnen worden opgevraagd.

        // Arrange
        String verwacht = "Naam: Plezierjacht 1 Type: Plezierjacht Prijs: 50000.0 Euro Lengte: 8.0M Gewicht: 2000.0KG Bestemd: Familie-uitjes ";
        Plezierjacht pj = new Plezierjacht("Plezierjacht 1 ", "Plezierjacht ", 50000, 8, 2000, "Familie-uitjes ");
        // Act
        String boot = pj.printBoot();

        // Assert
        Assertions.assertEquals(verwacht, boot);
    }
}
