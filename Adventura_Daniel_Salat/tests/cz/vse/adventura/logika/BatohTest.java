package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatohTest {
    private Vec vec1;
    private Vec vec2;
    private Vec vec3;
    private Vec vec4;
    private Batoh batoh;

    @BeforeEach
    void setUp() {
        vec1 = new Vec("auticko", true);
        vec2 = new Vec("vlacek", true);
        vec3 = new Vec("vojacek", true);
        vec4 = new Vec("stul", false);
        batoh = new Batoh();
    }

    @Test
    void pridejVec() {
        batoh.pridejVec(vec1);
        assertTrue(batoh.obsahujeVec("auticko")); // Ověříme, že batoh obsahuje přidanou věc
        batoh.pridejVec(vec2);
        assertTrue(batoh.obsahujeVec("vlacek")); // Ověříme, že batoh obsahuje přidanou věc
        batoh.pridejVec(vec3);
        assertTrue(batoh.obsahujeVec("vojacek")); // Ověříme, že batoh obsahuje přidanou věc

        //batoh.pridejVec(vec4); // Ověříme, že batoh nepřidá nepřenositelnou věc
    }

    @Test
    void odeberVec() {
        batoh.pridejVec(vec1);
        Vec odebranaVec = batoh.odeberVec("auticko");
        assertEquals("auticko", odebranaVec.getNazev()); // Ověříme, zda je správně vrácená odebraná věc
        assertFalse(batoh.obsahujeVec("auticko")); // Ověříme, že věc byla úspěšně odebrána z batohu
    }

    @Test
    void obsahujeVec() {
        batoh.pridejVec(vec1);
        assertTrue(batoh.obsahujeVec("auticko")); // Ověříme, zda batoh obsahuje přidanou věc
        assertFalse(batoh.obsahujeVec("vlacek")); // Ověříme, zda batoh neobsahuje věc, kterou jsme nepřidali
    }

    @Test
    void jeVolno() {
        assertTrue(batoh.jeVolno()); // Ověříme, že batoh je volný na začátku
        batoh.pridejVec(vec1);
        batoh.pridejVec(vec2);
        batoh.pridejVec(vec3);
        assertFalse(batoh.jeVolno()); // Ověříme, že batoh je plný
    }

    @Test
    void vypisVeci() {
        assertEquals("Batoh je prázdný.", batoh.vypisVeci()); // Ověříme, že vypíše správnou zprávu pro prázdný batoh
        batoh.pridejVec(vec1);
        assertEquals("Batoh máš z 1/3 zaplněný.\nV batohu jsou následující věci:\nauticko", batoh.vypisVeci()); // Ověříme, že správně vypíše obsah batohu s jednou věcí
    }
}