package cz.vse.adventura.logika;

/**
 * Třída PrikazPoloz implementuje příkaz "poloz", který umožňuje hráči položit věc z batohu do aktuálního prostoru.
 * Příkaz interaguje s herním plánem.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class PrikazPoloz implements  IPrikaz {
    private static final String NAZEV = "poloz";
    private HerniPlan plan;

    /**
     * Konstruktor třídy PrikazPoloz inicializuje příkaz s daným herním plánem.
     *
     * @param plan Herní plán, ve kterém se příkaz vykonává
     */
    public PrikazPoloz(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda provede příkaz "poloz", který umožňuje hráči položit věc z batohu do aktuálního prostoru.
     *
     * @param parametry (očekává se název věci).
     * @return Vrací zprávu o výsledku provedení příkazu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám položit? Musíš zadat název";
        }

        String nazevVeci = parametry[0];

        try {
            plan.polozVec(nazevVeci);
            return "Položil jsi " + nazevVeci + ".";
        } catch (IllegalStateException e) {
            return "Věc " + nazevVeci + " se nepodařilo položit: " + e.getMessage();
        }
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return Vrací název příkazu.
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
