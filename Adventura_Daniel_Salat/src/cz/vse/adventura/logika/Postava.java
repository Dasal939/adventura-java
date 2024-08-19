package cz.vse.adventura.logika;

/**
 * Třída Postava reprezentuje herní postavu, která má jméno a dva dialogy.
 * První dialog se přehraje po promluvení s postavou, druhý po předání předmětu, který daná postava chce.
 * Poskytuje metody pro získání jména postavy a obou dialogů.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class Postava {
    private String jmeno;

    private String dialog1;

    private String dialog2;

    /**
     * Konstruktor třídy Postava inicializuje postavu s jejím jménem a dvěma dialogy.
     * @param jmeno Jméno postavy.
     * @param dialog1 První dialog postavy.
     * @param dialog2 Druhý dialog postavy.
     */
    public Postava(String jmeno, String dialog1, String dialog2) {
        this.jmeno = jmeno;
        this.dialog1 = dialog1;
        this.dialog2 = dialog2;
    }

    /**
     * Metoda vrací jméno postavy.
     *
     * @return Vrací jméno postavy.
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda vrací první dialog postavy.
     *
     * @return Vrací první dialog postavy.
     */
    public String getDialog1() {
        return dialog1;
    }

    /**
     * Metoda vrací druhý dialog postavy.
     *
     * @return Vrací druhý dialog postavy.
     */
    public String getDialog2() {
        return dialog2;
    }

}
