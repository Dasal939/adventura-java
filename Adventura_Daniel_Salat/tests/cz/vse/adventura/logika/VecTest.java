package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecTest {
    private Vec vec;

    @BeforeEach
    void setUp() {
        vec = new Vec("testVec", true);
    }

    @Test
    void getNazev() {
        assertEquals("testVec", vec.getNazev());
    }

    @Test
    void isPrenositelna() {
        assertTrue(vec.isPrenositelna());
    }

    @Test
    void setNazev() {
        vec.setNazev("novyNazev");
        assertEquals("novyNazev", vec.getNazev());
    }
}
