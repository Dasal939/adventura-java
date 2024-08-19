package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazSeberTest {
    private HerniPlan plan;
    private PrikazSeber prikazSeber;

    private Vec vec1 = new Vec("auticko", true);

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        prikazSeber = new PrikazSeber(plan);
    }

    @Test
    void provedPrikaz() {
        assertEquals("Věc " + vec1.getNazev() + " byla sebrána a je v batohu.", prikazSeber.provedPrikaz("auticko")); //Test sebrání přenositelné věci

        assertEquals("Věc se nepodařila sebrat: Tuhle věc tady nevidím.", prikazSeber.provedPrikaz("stul")); //Test sebrání věci, která tu není

        assertEquals("Co mám sebrat? Musíš zadat název věci.", prikazSeber.provedPrikaz()); //Test, když neuvedu věc
    }

    @Test
    void getNazev() {
        assertEquals("seber", prikazSeber.getNazev());
    }
}