package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazPromluvTest {
    private HerniPlan plan;
    private PrikazPromluv prikazPromluv;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        prikazPromluv = new PrikazPromluv(plan);
    }

    @Test
    void provedPrikaz() {
        assertEquals("Nezadal jsi žádné jméno.", prikazPromluv.provedPrikaz()); // Test, když není zadán žádný parametr

        assertEquals("Tato postava tu není.", prikazPromluv.provedPrikaz("neexistujici_postava")); // Test, když je zadáno jméno neexistující postavy

        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava postava = new Postava("postava", "dialog1", "dialog2");
        aktualniProstor.pridejPostavu(postava);

        assertEquals("dialog1", prikazPromluv.provedPrikaz("postava")); // Test, když je zadáno jméno postavy
    }

    @Test
    void getNazev() {
        assertEquals("promluv", prikazPromluv.getNazev());
    }
}