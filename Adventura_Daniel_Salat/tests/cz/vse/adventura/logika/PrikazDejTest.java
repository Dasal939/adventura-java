package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazDejTest {

    private HerniPlan plan;
    private Prostor prostor;
    private Postava postava;
    private Quest quest;
    private Vec potrebnaVec;
    private Vec odmena;
    private Batoh batoh;
    private PrikazDej prikazDej;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
        batoh = new Batoh();
        prostor = new Prostor("prostor", "popis");
        postava = new Postava("postava", "dialog1", "dialog2");
        potrebnaVec = new Vec("potrebna_vec", true);
        odmena = new Vec("odmena", true);
        quest = new Quest(potrebnaVec, postava, odmena);
        prostor.pridejPostavu(postava);
        prostor.setQuest(quest);
        plan.setAktualniProstor(prostor);
        plan.setBatoh(batoh);
        prikazDej = new PrikazDej(plan);
    }

    @Test
    void provedPrikaz() {
        // Test bez parametrů
        String vysledek = prikazDej.provedPrikaz();
        assertEquals("Nezadal jsi název postavy, které chceš dát quest item.", vysledek);

        // Test, když postava není v prostoru
        vysledek = prikazDej.provedPrikaz("neexistujiciPostava");
        assertEquals("Tato postava tu není.", vysledek);

        // Test, když nemám quest item
        vysledek = prikazDej.provedPrikaz("postava");
        assertEquals("Nemáš potřebný quest item pro tuto postavu.", vysledek);

        // Test, když mám quest item
        batoh.pridejVec(potrebnaVec);
        vysledek = prikazDej.provedPrikaz("postava");
        assertEquals("Dostal jsi odmena a máš to v batohu.", vysledek);
        assertFalse(batoh.obsahujeVec("potrebna_vec"));
        assertTrue(batoh.obsahujeVec("odmena"));
    }

    @Test
    void getNazev() {
        assertEquals("dej", prikazDej.getNazev());
    }
}