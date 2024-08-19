package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostavaTest {
    private Postava postava;

    @BeforeEach
    void setUp() {
        postava = new Postava("TestPostava", "Ahoj, jsem testovací postava.", "Děkuji za item!");
    }

    @Test
    void getJmeno() {
        assertEquals("TestPostava", postava.getJmeno());
    }

    @Test
    void getDialog1() {
        assertEquals("Ahoj, jsem testovací postava.", postava.getDialog1());
    }

    @Test
    void getDialog2() {
        assertEquals("Děkuji za item!", postava.getDialog2());
    }
}
