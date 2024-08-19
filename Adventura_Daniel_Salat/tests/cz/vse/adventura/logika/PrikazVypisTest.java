package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazVypisTest {
    private HerniPlan plan;
    private Batoh batoh;
    private Prostor prostor;
    private PrikazVypis prikazVypis;

    @BeforeEach
    void setUp() {
        batoh = new Batoh();
        plan = new HerniPlan();
        plan.setBatoh(batoh);
        prostor = new Prostor("testProstor", "testPopis");
        plan.setAktualniProstor(prostor);
        prikazVypis = new PrikazVypis(plan);
    }

    @Test
    void provedPrikaz() {
        // Test výpisu batohu
        String vysledek = prikazVypis.provedPrikaz("batoh");
        assertEquals("Batoh je prázdný.", vysledek);

        // Přidání věci do batohu a test výpis batohu
        batoh.pridejVec(new Vec("testVec", true));
        vysledek = prikazVypis.provedPrikaz("batoh");
        assertEquals("Batoh máš z 1/3 zaplněný.\n" +
                "V batohu jsou následující věci:\n" +
                "testVec", vysledek);

        // Test výpis prostoru
        vysledek = prikazVypis.provedPrikaz("prostor");
        assertEquals("Jsi v testProstor\n" +
                "východy:\n" +
                "věci:\n" +
                "postavy:", vysledek);

        // Test neznámého parametru
        vysledek = prikazVypis.provedPrikaz("neznámýParametr");
        assertEquals("To neznám. Můžu vypsat batoh/prostor.", vysledek);
    }

    @Test
    void getNazev() {
        assertEquals("vypis", prikazVypis.getNazev());
    }
}
