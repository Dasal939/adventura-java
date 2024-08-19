package cz.vse.adventura.logika;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//S tímto testem jsem si moc nevěděl rady, hodně pomohlo ChatGPT

class PrikazFnukejTest {
    private PrikazFnukej prikazFnukej;
    private List<String> possibleOutputs;

    @BeforeEach
    void setUp() {
        prikazFnukej = new PrikazFnukej();
        possibleOutputs = Arrays.asList(
                "ááá, mamiii, kde jsi? :(",
                "maminkoooo, chci jít domůůů :(",
                "béééé, já chci mámuuuu :(",
                "bůůůůůů :("
        );
    }

    @AfterEach
    void tearDown() {
        prikazFnukej = null;
    }

    @Test
    void provedPrikaz() {
        String vysledek = prikazFnukej.provedPrikaz();
        assertTrue(possibleOutputs.contains(vysledek));
    }

    @Test
    void getNazev() {
        assertEquals("fnukej", prikazFnukej.getNazev());
    }
}
