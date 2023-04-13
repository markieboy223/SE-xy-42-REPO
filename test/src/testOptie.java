import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testOptie{
    @Test
    public void testVoegToe() {
        //arrange
        Optie optie = new Optie("Stuur", "Goud", 200.00, true);
        Keuze keuze1 = new Keuze("Stuur", "zilver", 150.00, true, 1);
        Keuze keuze2 = new Keuze("Stuur", "brons", 100.00, true, 1);
        Keuze keuze3 = new Keuze("Stuur", "plastic", 50.00, true, 1);

        //act
        optie.voegToe(keuze1, keuze2, keuze3);

        //assert
        assertEquals(3, optie.keuzes.size());

        assertEquals("Stuur", optie.keuzes.get(0).naam);
        assertEquals("zilver", optie.keuzes.get(0).omschrijving);
        assertEquals(150.00, optie.keuzes.get(0).prijs);
        assertEquals(true, optie.keuzes.get(0).isEssentieel);
        assertEquals(1, optie.keuzes.get(0).optie);

        assertEquals("Stuur", optie.keuzes.get(1).naam);
        assertEquals("brons", optie.keuzes.get(1).omschrijving);
        assertEquals(100.00, optie.keuzes.get(1).prijs);
        assertEquals(true, optie.keuzes.get(1).isEssentieel);
        assertEquals(1, optie.keuzes.get(1).optie);

        assertEquals("Stuur", optie.keuzes.get(2).naam);
        assertEquals("plastic", optie.keuzes.get(2).omschrijving);
        assertEquals(50.00, optie.keuzes.get(2).prijs);
        assertEquals(true, optie.keuzes.get(2).isEssentieel);
        assertEquals(1, optie.keuzes.get(2).optie);

    }
}
