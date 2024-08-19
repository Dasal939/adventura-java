package cz.vse.adventura.logika;

/**
 * Třída PrikazVypis implementuje příkaz "vypis", který umožňuje hráči vypsat obsah batohu nebo aktuálního prostoru.
 * V případě že chce hráč vypsat prostor příkaz interaguje s herním plánem.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class PrikazVypis implements IPrikaz {
    private static final String NAZEV = "vypis";

    private HerniPlan plan;

    /**
     * Konstruktor třídy PrikazVypis inicializuje příkaz s daným herním plánem.
     *
     * @param herniPlan Herní plán, ve kterém se příkaz vykonává.
     */
    public PrikazVypis(HerniPlan herniPlan) {
        this.plan = herniPlan;
    }

    /**
     * Metoda provede příkaz "vypis", který umožňuje hráči vypsat obsah batohu nebo aktuálního prostoru.
     *
     * @param parametry (Očekává se jedno slovo: "batoh" nebo "prostor").
     * @return Vrací informace o obsahu batohu nebo aktuálním prostoru, nebo chybovou zprávu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám vypsat? (batoh/prostor)";
        }
        if (parametry[0].equals("batoh")) {
            return plan.getBatoh().vypisVeci();
        }
        if (parametry[0].equals("prostor")) {
            return "Jsi v " + plan.getAktualniProstor().getNazev() +"\n" + plan.getAktualniProstor().popisVychodu() + "\n" + plan.getAktualniProstor().popisVeci()  + "\n" + plan.getAktualniProstor().popisPostav();
        }
        else {
            return "To neznám. Můžu vypsat batoh/prostor.";
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
