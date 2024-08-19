package cz.vse.adventura.logika;

/**
 * Třída PrikazDej implementuje příkaz "dej", který umožňuje hráči dát quest item postavě.
 * Tento příkaz kontroluje, zda hráč má potřebný quest item a interaguje s herním plánem a postavami.
 *
 * Autor: Daniel Salat
 * Verze: květen/červen 2024
 */
public class PrikazDej implements IPrikaz {
    private static final String NAZEV = "dej";
    private HerniPlan plan;

    /**
     * Konstruktor třídy PrikazDej inicializuje příkaz s herním plánem.
     *
     * @param plan Herní plán, ve kterém se příkaz vykonává.
     */
    public PrikazDej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda provede příkaz "dej", který umožňuje hráči dát quest item postavě.
     *
     * @param parametry Parametry příkazu (očekává se název postavy).
     * @return Vrací zprávu o výsledku provedení příkazu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Nezadal jsi název postavy, které chceš dát quest item.";
        }

        String jmeno = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        Postava postava = aktualniProstor.getPostava(jmeno);

        if (postava == null) {
            return "Tato postava tu není.";
        }
        // Pokud postava v aktuálním prostoru existuje a batoh obsahuje potřebnou věc pro její quest
        if (postava.getJmeno().contains(jmeno) && plan.getBatoh().obsahujeVec(aktualniProstor.getQuest().getPotrebnaVec().getNazev())) {
            if (aktualniProstor.getQuest().isFinal()) {
                if (plan.getBatoh().obsahujeVec("nove_tenisky")) {
                    System.out.println(postava.getDialog2());
                    System.out.println("Odemknul jsi dveře, probudil manažera a ten vyhlásil do rozhlasu ať si pro tebe přijde maminka. Naštěstí jsi získal zpátky svoje nové tenisky a máma vůbec neví že jsi je ztratil. Všechno dobře dopadlo a dostal jsi zmrzlinu!");
                    System.exit(0); //Nešlo mi to přes hra.setKonecHry(true)
                }
                else {
                    System.out.println(postava.getDialog2());
                    System.out.println("Odemknul jsi dveře, probudil manažera a ten vyhlásil do rozhlasu ať si pro tebe přijde maminka. Po tom co zjistila že jsi ztratil svoje nové boty tě na místě seřezala. Prohrál jsi.");
                    System.exit(0); //Nešlo mi to přes hra.setKonecHry(true)
                }
            }
            plan.getBatoh().odeberVec(aktualniProstor.getQuest().getPotrebnaVec().getNazev()); // Odebere potřebnou věc z batohu
            plan.getBatoh().pridejVec(aktualniProstor.getQuest().getOdmena()); // Přidá odměnu do batohu
            System.out.println(postava.getDialog2());
            return "Dostal jsi " + aktualniProstor.getQuest().getOdmena().getNazev() + " a máš to v batohu.";
        }
        return "Nemáš potřebný quest item pro tuto postavu.";
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
