package cz.vse.adventura.logika;

/**
 * Třída Vec reprezentuje věc v rámci hry.
 *
 * Věc má určený název a boolean, který rozhoduje, zda je přenositelná nebo ne.
 *
 * @author Daniel Salat
 * @version květen/červen 2024
 */
public class Vec {
    private String nazev;

    private boolean prenositelna;

    /**
     * Konstruktor pro vytvoření instance věci se zadaným názvem a booleanem, který rozhoduje o přenositelnosti.
     *
     * @param nazev Název věci.
     * @param prenositelna Přenositelnost.
     */
    public Vec(String nazev, boolean prenositelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
    }

    /**
     * Metoda pro získání názvu věci.
     *
     * @return Název věci.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda pro nastavení názvu věci.
     *
     * @param nazev Název věci.
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Metoda pro zjištění, zda je věc přenositelná.
     *
     * @return True, pokud je věc přenositelná, jinak false
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }
}
