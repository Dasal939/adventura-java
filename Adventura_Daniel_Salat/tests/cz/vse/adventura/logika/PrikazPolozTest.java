package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazPolozTest {
    private HerniPlan plan;
    private Batoh batoh;
    private Prostor prostor;
    private PrikazPoloz prikazPoloz;
    private Vec vec;

    @BeforeEach
    void setUp() {
        batoh = new Batoh();
        plan = new HerniPlan(); // Vytvoříme herní plán a přiřadíme mu batoh
        prostor = new Prostor("prostor", "popis");
        plan.setAktualniProstor(prostor);
        plan.setBatoh(batoh);
        prikazPoloz = new PrikazPoloz(plan);
        vec = new Vec("nazevVeci", true);
    }

    @Test
    void provedPrikaz() {
        // Test bez parametrů
        String vysledek = prikazPoloz.provedPrikaz();
        assertEquals("Co mám položit? Musíš zadat název", vysledek);

        // Test, když věc není v batohu
        vysledek = prikazPoloz.provedPrikaz("nazevVeci");
        assertEquals("Věc nazevVeci se nepodařilo položit: Tuhle věc v batohu nemám.", vysledek);

        // Test, když věc je v batohu
        batoh.pridejVec(vec);
        vysledek = prikazPoloz.provedPrikaz("nazevVeci");
        assertEquals("Položil jsi nazevVeci.", vysledek);
        assertFalse(batoh.obsahujeVec("nazevVeci"));
        assertTrue(prostor.obsahujeVec("nazevVeci"));

    }

    @Test
    void getNazev() {
        assertEquals("poloz", prikazPoloz.getNazev());
    }
}
