package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {
    private Vec klic;
    private Vec mapa;
    private Postava postava1;
    private Postava postava2;

    @BeforeEach
    void setUp() {
        klic = new Vec("klic", true);
        mapa = new Vec("mapa", true);

        postava1 = new Postava("postava1", "Potřebuju klíč!", "Díky.");
        postava2 = new Postava("postava2", "Potřebuju mapu!", "Díky.");
    }

    @Test
    void getPotrebnaVec() {
        Quest quest1 = new Quest(klic, postava1, mapa);
        Quest quest2 = new Quest(mapa, postava2, true);

        assertEquals(klic, quest1.getPotrebnaVec()); //Testuji že postava1 chce klíč
        assertEquals(mapa, quest2.getPotrebnaVec()); //Testuji že postava2 chce mapu
    }

    @Test
    void getOdmena() {
        Quest quest1 = new Quest(klic, postava1, mapa);
        Quest quest2 = new Quest(mapa, postava2, true);

        assertEquals(mapa, quest1.getOdmena());
        assertNull(quest2.getOdmena()); // Protože quest2 nemá definovanou odměnu
    }

    @Test
    void isFinal() {
        Quest quest1 = new Quest(klic, postava1, mapa);
        Quest quest2 = new Quest(mapa, postava2, true);

        assertFalse(quest1.isFinal()); //Quest1 neni final
        assertTrue(quest2.isFinal()); //Quest2 je final
    }
}