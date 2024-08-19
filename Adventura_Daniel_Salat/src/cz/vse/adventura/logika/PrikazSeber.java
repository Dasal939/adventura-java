package cz.vse.adventura.logika;

/**
 * Třída PrikazSeber implementuje příkaz "seber", který umožňuje hráči sebrat věc z aktuálního prostoru a dát ji do batohu.
 * Příkaz interaguje s herním plánem.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";

    private HerniPlan plan;

    /**
     * Konstruktor třídy PrikazSeber inicializuje příkaz s daným herním plánem.
     *
     * @param plan Herní plán, ve kterém se příkaz vykonává.
     */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda provede příkaz "seber", který umožňuje hráči sebrat věc z aktuálního prostoru a dát ji do batohu.
     *
     * @param parametry (Očekává se název věci).
     * @return Vrací zprávu o výsledku provedení příkazu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám sebrat? Musíš zadat název věci.";
        }

        String nazevVeci = parametry[0];

        try {
            plan.seberVec(nazevVeci);
            return "Věc " + nazevVeci + " byla sebrána a je v batohu.";
        } catch (IllegalStateException e) {
            return "Věc se nepodařila sebrat: " + e.getMessage();
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
