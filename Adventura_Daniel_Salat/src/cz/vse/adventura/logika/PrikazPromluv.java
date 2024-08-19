package cz.vse.adventura.logika;

/**
 * Třída PrikazPromluv implementuje příkaz "promluv", který umožňuje hráči mluvit s postavami v aktuálním prostoru.
 * Příkaz vrací řetězec "dialog1", díky němu se dozvíme co po nás daná postava chce.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class PrikazPromluv implements IPrikaz{

    private static final String NAZEV = "promluv";

    private HerniPlan plan;

    /**
     * Konstruktor třídy PrikazPromluv inicializuje příkaz s daným herním plánem.
     *
     * @param plan Herní plán, ve kterém se příkaz vykonává.
     */
    public PrikazPromluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda provede příkaz "promluv", který umožňuje hráči mluvit s postavou v aktuálním prostoru.
     *
     * @param parametry (Očekává se jméno postavy).
     * @return Vrací dialog postavy nebo chybovou zprávu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nezadal jsi žádné jméno.";
        }

        String jmeno = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.getPostava(jmeno);

        if (postava == null) {
            return "Tato postava tu není.";
        }
        if (postava.getJmeno().contains(jmeno)) {
            return postava.getDialog1();
        }

        return "Taková postava tu není.";
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
